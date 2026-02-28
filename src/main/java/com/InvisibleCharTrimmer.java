package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InvisibleCharTrimmer {

    public static void main(String[] args) {

        // ==========================================
        // 1. SET YOUR FOLDER PATH HERE
        // ==========================================
        String inputFilePath = "";

        // Creates a new folder inside your input folder to save the cleaned files safely
        String outputFilePath = "";


        int processedCount = 0;

                try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
                     BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

                    String line;
                    while ((line = reader.readLine()) != null) {

                        // --- THE CLEANING LOGIC ---
                        // 1. Remove zero-width spaces, non-joiners, BOM, and other invisible Unicode artifacts
                        String cleanedLine = line.replaceAll("[\u200B-\u200D\u200E\u200F\uFEFF]", "");

                        // 2. Strip standard whitespaces (spaces, tabs) from the very beginning and end of the line
                        cleanedLine = cleanedLine.strip();

                        // Write the cleaned line to the new file
                        writer.write(cleanedLine);
                        writer.newLine();
                    }

                    processedCount++;

                } catch (IOException e) {
                    System.err.println("Error processing file: ");
                    e.printStackTrace();
                }


        System.out.println("\n--- Processing Complete ---");
        System.out.println("Successfully cleaned " + processedCount + " files.");
        System.out.println("Saved to: " + outputFilePath);
    }
}