package com;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;

public class SyntheticDataGenerator {

    public static void main(String[] args) {
        String txtFilePath = "";
        String fontFolderPath = "";
        String outputFolder = "";

        int imgHeight = 64;
        Random random = new Random();

        File directory = new File(outputFolder);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Load fonts at a baseline size. We will scale them dynamically later.
        List<Font> availableFonts = loadFontsFromDirectory(fontFolderPath, 32f);

        if (availableFonts.isEmpty()) {
            System.out.println("No valid fonts found.");
            return;
        }

        int counter = 5223;

        try (BufferedReader br = new BufferedReader(new FileReader(txtFilePath))) {
            String line;
            System.out.println("Starting image generation with augmentation...");

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                // 1. Randomize Font and Size per image
                Font baseFont = availableFonts.get(random.nextInt(availableFonts.size()));
                float minFontSize = 24f;
                float maxFontSize = 34f;
                float randomSize = minFontSize + random.nextFloat() * (maxFontSize - minFontSize);
                Font selectedFont = baseFont.deriveFont(randomSize);

                // 2. Calculate dynamic width based on the actual text string
                BufferedImage tempImg = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
                Graphics2D tempG = tempImg.createGraphics();
                tempG.setFont(selectedFont);
                FontMetrics fm = tempG.getFontMetrics();
                // Width = Text width + padding left/right
                int dynamicWidth = fm.stringWidth(line) + 40;
                tempG.dispose();

                // 3. Create the actual canvas
                BufferedImage img = new BufferedImage(dynamicWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = img.createGraphics();

                g2d.setColor(Color.WHITE);
                g2d.fillRect(0, 0, dynamicWidth, imgHeight);

                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

                // --- 4. APPLY ROTATION AUGMENTATION ---
                // Random angle between -3 and +3 degrees
                double angleDegrees = -3 + (6 * random.nextDouble());
                double angleRadians = Math.toRadians(angleDegrees);

                // Rotate around the center of the image
                AffineTransform originalTransform = g2d.getTransform();
                g2d.rotate(angleRadians, dynamicWidth / 2.0, imgHeight / 2.0);

                // Draw Text
                g2d.setFont(selectedFont);
                g2d.setColor(Color.BLACK);
                int textX = 20;
                int textY = ((imgHeight - fm.getHeight()) / 2) + fm.getAscent();
                g2d.drawString(line, textX, textY);

                // Restore transform so noise isn't rotated
                g2d.setTransform(originalTransform);

                // --- 5. APPLY NOISE/DISTORTION AUGMENTATION ---
                addNoise(g2d, dynamicWidth, imgHeight, random);

                g2d.dispose();

                // Save image
                String fileName = "Sentence-" + counter + ".jpeg";
                File outputFile = new File(directory, fileName);
                ImageIO.write(img, "jpeg", outputFile);

                counter++;
            }
            System.out.println("Success! Generated " + (counter - 1) + " images.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds random artifacts to mimic bad scanning or messy handwriting.
     */
    private static void addNoise(Graphics2D g2d, int width, int height, Random random) {
        // Randomly adjust stroke thickness for noise
        g2d.setStroke(new BasicStroke(random.nextFloat() * 1.5f));

        // Add subtle background speckles
        int numSpeckles = random.nextInt(50) + 20; // 20 to 70 speckles
        for (int i = 0; i < numSpeckles; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            // Light grey to black speckles
            int grayColor = random.nextInt(150);
            g2d.setColor(new Color(grayColor, grayColor, grayColor));
            g2d.fillRect(x, y, 1, 1);
        }

        // Add occasional faint "stray lines"
        if (random.nextBoolean()) {
            g2d.setColor(new Color(200, 200, 200)); // Very faint gray
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g2d.drawLine(x1, y1, x2, y2);
        }
    }

    private static List<Font> loadFontsFromDirectory(String folderPath, float fontSize) {
        List<Font> fonts = new ArrayList<>();
        File fontDir = new File(folderPath);

        if (!fontDir.exists() || !fontDir.isDirectory()) return fonts;

        File[] files = fontDir.listFiles();
        if (files != null) {
            for (File file : files) {
                String name = file.getName().toLowerCase();
                if (name.endsWith(".ttf") || name.endsWith(".otf")) {
                    try {
                        Font font = Font.createFont(Font.TRUETYPE_FONT, file).deriveFont(fontSize);
                        fonts.add(font);
                    } catch (Exception e) {
                        System.out.println("Skipping invalid font file: " + file.getName());
                    }
                }
            }
        }
        return fonts;
    }
}