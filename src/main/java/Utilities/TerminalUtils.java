package Utilities;

public class TerminalUtils {
    private TerminalUtils() {
    }

    public static void executeCommand(String... command) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();
            LogsUtils.info("Command executed: " + String.join(" ", command));
        } catch (Exception e) {
            LogsUtils.error("Failed to execute command: " + e.getMessage());
        }
    }
}
