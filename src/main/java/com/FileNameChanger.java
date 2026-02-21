package com;

import java.io.File;

public class FileNameChanger {

    public void fileNameChanger(String folderPath, String prefix, int counter) {
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();

        if (!folder.exists() || listOfFiles == null || listOfFiles.length == 0) {
            System.out.println("Directory " + folder.getPath() + " does not exist.");
            return;
        }

        for (File file : listOfFiles) {
            String originalFileName = file.getName();

            if (!originalFileName.startsWith(prefix)) {
                String extension = "";
                int dotIndex = originalFileName.lastIndexOf('.');
                if (dotIndex > 0) {
                    extension = originalFileName.substring(dotIndex);
                }

                String newFileName = prefix + counter + extension;
                File newFile = new File(folder, newFileName);

                if (file.renameTo(newFile)) {
                    System.out.println("Renamed: " + originalFileName + " -> " + newFileName);
                } else {
                    System.out.println("Failed: " + originalFileName);
                }

                counter++;
        }
        System.out.println("Total files renamed: " + (counter - 1));
    }
}
}
