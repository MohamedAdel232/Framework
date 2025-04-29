package Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FilesUtils {
    private FilesUtils() {
    }

    public static void deleteFiles(File directoryPath) {
        if (directoryPath == null || !directoryPath.exists()) {
            LogsUtils.warn("Directory does not exist: " + directoryPath);
            return;
        }

        File[] filesList = directoryPath.listFiles();
        if (filesList == null) {
            LogsUtils.warn("No files found in directory: " + directoryPath);
            return;
        }

        for (File file : filesList) {
            if (file.isDirectory()) {
                deleteFiles(file);
            } else {
                try {
                    Files.delete(file.toPath());
                } catch (IOException e) {
                    LogsUtils.error("Failed to delete file: " + file);
                }
            }
        }
    }

    public static File getLatestFile(String directoryPath) {
        File folder = new File(directoryPath);
        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            LogsUtils.warn("No files found in directory: " + directoryPath);
            return null;
        }

        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }
        return latestFile;
    }


}
