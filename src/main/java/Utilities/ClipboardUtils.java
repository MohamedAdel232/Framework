package Utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class ClipboardUtils {
    private final WebDriver driver;

    public ClipboardUtils(WebDriver driver) {
        this.driver = driver;
    }

    public static void copyToClipboard(String value) {
        StringSelection stringSelection = new StringSelection(value);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public void pasteFromClipboard() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .perform();
    }
}
