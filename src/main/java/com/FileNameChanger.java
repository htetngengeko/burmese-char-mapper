package com;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class FileNameChanger {

    // ==========================================
    // MAIN METHOD ADDED HERE
    // ==========================================
    public static void main(String[] args) {

        // 1. Set your paths and variables here
        String inputFolderPath = "";
        String outputFolderPath = "";
        String prefix = "Sentence-";
        int startingCounter = 1;

        System.out.println("Starting file copy and rename process...\n");

        // 2. Instantiate the class and call the method
        FileNameChanger changer = new FileNameChanger();
        changer.fileNameChanger(inputFolderPath, outputFolderPath, prefix, startingCounter);

        System.out.println("\nProcess complete!");
    }

    public void fileNameChanger(String inputFolderPath, String outputFolderPath, String prefix, int startingCounter) {
        File inputFolder = new File(inputFolderPath);
        File outputFolder = new File(outputFolderPath);
        File[] listOfFiles = inputFolder.listFiles();

        if (!inputFolder.exists() || listOfFiles == null || listOfFiles.length == 0) {
            System.out.println("Directory " + inputFolder.getPath() + " does not exist or is empty.");
            return;
        }

        // Create the output directory if it doesn't exist
        if (!outputFolder.exists()) {
            outputFolder.mkdirs();
        }

        int counter = startingCounter;
        int successCount = 0;

        for (File file : listOfFiles) {
            if (file.isFile()) { // Ensure we only copy files, not folders
                String originalFileName = file.getName();

                if(originalFileName.contains("jpeg")) {
                    String extension = "";

                    int dotIndex = originalFileName.lastIndexOf('.');
                    if (dotIndex > 0) {
                        extension = originalFileName.substring(dotIndex);
                    }

                    String newFileName = prefix + counter + extension;

                    File newFile = new File(outputFolder, newFileName);

                    try {
                        // Copy the file to the new folder with the new name
                        Files.copy(file.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Copied: " + originalFileName + " -> " + newFileName);
                        successCount++;
                    } catch (IOException e) {
                        System.out.println("Failed to copy: " + originalFileName);
                        e.printStackTrace();
                    }

                }
                counter++;
            }
        }
        System.out.println("Total files successfully processed: " + successCount);
    }
}