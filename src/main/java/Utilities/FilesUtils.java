package Utilities;

import org.apache.commons.io.FileUtils;

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

    public static void cleanDirectory(File file) {
        try {
            FileUtils.deleteQuietly(file);
        } catch (Exception e) {
            LogsUtils.error("Failed to clean directory: " + e.getMessage());
        }
    }

    public static void createDirectory(File directory) {
        if (!directory.exists()) {
            try {
                Files.createDirectories(directory.toPath());
                LogsUtils.info("Directory created: " + directory);
            } catch (IOException e) {
                LogsUtils.error("Failed to create directory: " + directory);
            }
        } else {
            LogsUtils.info("Directory already exists: " + directory);
        }
    }

    public static void renameFile(File oldName, File newName) {
        try {
            File targetFile = oldName.getParentFile().getAbsoluteFile();
            String targetDirectory = targetFile + File.separator + newName;
            FileUtils.copyFile(oldName, new File(targetDirectory));
            FileUtils.deleteQuietly(oldName);
            LogsUtils.info("Target File Path: \"" + oldName.getPath() + "\", file was renamed to \"" + newName.getName() + "\".");
        } catch (Exception e) {
            LogsUtils.error("Failed to rename file: " + e.getMessage());
        }
    }

    public static int getNumberOfFilesInDirectory(String directoryPath) {
        return new File(directoryPath).list().length;
    }

    public static String getDownloadsDirectoryPath() {
        return PropertiesUtils.getPropertyValue("user.home") + File.separator + "Downloads";
    }
}
