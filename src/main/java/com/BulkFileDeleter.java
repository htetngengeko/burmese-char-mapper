package com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BulkFileDeleter {

    public static void main(String[] args) {

        // ==========================================
        // 1. SET YOUR FOLDER PATH HERE
        // ==========================================
        // Note: Use forward slashes (/) or double backslashes (\\) in Java paths
        String folderPath = "";
//        /Users/htetngengeko/Downloads/synthetic-data/word-output

        // File naming settings
        String prefix = "Sentence-";
        String extension = ".jpeg";
        int startNum = 1000;
        int endNum = 5222;

        System.out.println("Target folder: " + folderPath);
        System.out.println("Attempting to delete files from " + prefix + startNum + extension + " to " + prefix + endNum + extension + "...\n");

        int deletedCount = 0;
        int missingCount = 0;

        // ==========================================
        // 2. DELETION LOOP
        // ==========================================
        for (int i = startNum; i <= endNum; i++) {
            String fileName = prefix + i + extension;
            Path filePath = Paths.get(folderPath, fileName);

            try {
                // deleteIfExists returns true if deleted, false if the file wasn't there
                if (Files.deleteIfExists(filePath)) {
                    deletedCount++;
                    // Optional: Uncomment the next line if you want to see every file deleted
                    // System.out.println("Deleted: " + fileName);
                } else {
                    missingCount++;
                }
            } catch (IOException e) {
                System.err.println("Error deleting " + fileName + ": " + e.getMessage());
            }
        }

        // ==========================================
        // 3. PRINT SUMMARY
        // ==========================================
        System.out.println("--- Deletion Summary ---");
        System.out.println("Files successfully deleted: " + deletedCount);
        System.out.println("Files not found (already missing): " + missingCount);
    }
}