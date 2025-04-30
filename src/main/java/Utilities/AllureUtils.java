package Utilities;

import io.qameta.allure.Allure;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllureUtils {
    public static final String allureResultsDirectoryPath = "TestOutputs/allure-results";
    public static final String allureReportDirectoryPath = "TestOutputs/allure-report";
    static String userHome = System.getProperty("user.home");
    // C:\Users\Mohamed\scoop\apps\allure\2.32.0\bin
    static String allurePath = userHome + File.separator + "scoop" + File.separator + "apps"
            + File.separator + "allure" + File.separator + "2.32.0" + File.separator
            + "bin" + File.separator + "allure";

    private AllureUtils() {
    }

    public static void generateAllureReport() {
        if (PropertiesUtils.getPropertyValue("os.name").toLowerCase().contains("win")) //windows 11
        {
            String WIN = allurePath + ".bat";
            TerminalUtils.executeCommand(WIN, "generate", allureResultsDirectoryPath, "-o", allureReportDirectoryPath, "clean", "--single-file");
            LogsUtils.info("Allure report generated successfully on Windows");
        } else {
            TerminalUtils.executeCommand(allurePath, "generate", allureResultsDirectoryPath, "-o", allureReportDirectoryPath, "clean", "--single-file");
            LogsUtils.info("Allure report generated successfully on " + PropertiesUtils.getPropertyValue("os.name"));
        }
    }

    public static String renameReport() {
        File newName = new File("Report_" + TimestampUtils.getTimestamp() + ".html");
        File oldName = new File(allureReportDirectoryPath + File.separator + "index.html");
        FilesUtils.renameFile(oldName, newName);
        return newName.getName();
    }

    public static void openReport(String fileName) {
        String reportPath = allureReportDirectoryPath + File.separator + fileName;
        if (PropertiesUtils.getPropertyValue("openAllureReportAutomatically").equalsIgnoreCase("true")) {
            if (PropertiesUtils.getPropertyValue("os.name").toLowerCase().contains("win")) {
                TerminalUtils.executeCommand("cmd.exe", "/c", "start", reportPath);
            } else {
                TerminalUtils.executeCommand("open", reportPath);
            }
        }
    }

    public static void attacheLogsToAllureReport() {
        try {
            File logFile = FilesUtils.getLatestFile(LogsUtils.logsDirectoryPath);
            if (!logFile.exists()) {
                LogsUtils.warn("Log file does not exist: " + LogsUtils.logsDirectoryPath);
                return;
            }
            Allure.addAttachment("Logs.log", Files.readString(Path.of(logFile.getPath())));
            LogsUtils.info("Log file attached to Allure report: " + logFile.getPath());
        } catch (Exception e) {
            LogsUtils.error("Failed to attach log file to Allure report: " + e.getMessage());
        }
    }

    public static void attacheScreenshotToAllureReport(String screenshotName, String screenshotPath) {
        try {
            Allure.addAttachment(screenshotName, Files.newInputStream(Path.of(screenshotPath)));
            LogsUtils.info("Screenshot attached to Allure report: " + screenshotPath);
        } catch (Exception e) {
            LogsUtils.error("Failed to attach screenshot file to Allure report: " + e.getMessage());
        }
    }
}
