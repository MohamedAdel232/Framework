package Utilities;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotUtils {
    private RobotUtils() {
    }

    public static void clickOnEnterButton() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
