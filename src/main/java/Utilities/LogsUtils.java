package Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogsUtils {
    public static String LogFilePath = "TestOutputs/Logs";

    private LogsUtils() {
    }

    public static Logger logger() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    }

    public static void info(String... msg) {
        if (msg == null || msg.length == 0) {
            logger().info("No message provided");
        } else {
            logger().info(String.join(" ", msg));
        }
    }

    public static void error(String... msg) {
        if (msg == null || msg.length == 0) {
            logger().info("No message provided");
        } else {
            logger().error(String.join(" ", msg));
        }
    }

    public static void warn(String... msg) {
        if (msg == null || msg.length == 0) {
            logger().info("No message provided");
        } else {
            logger().warn(String.join(" ", msg));
        }
    }

    public static void fatal(String... msg) {
        if (msg == null || msg.length == 0) {
            logger().info("No message provided");
        } else {
            logger().fatal(String.join(" ", msg));
        }
    }

    public static void debug(String... msg) {
        if (msg == null || msg.length == 0) {
            logger().info("No message provided");
        } else {
            logger().debug(String.join(" ", msg));
        }
    }

    public static void trace(String... msg) {
        if (msg == null || msg.length == 0) {
            logger().info("No message provided");
        } else {
            logger().trace(String.join(" ", msg));
        }
    }
}
