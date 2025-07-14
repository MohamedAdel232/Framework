package Factories;

import Utilities.LogsUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class RemoteDriverFactory {
    private static Capabilities getOptions(String browser, String platformName) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (platformName.equalsIgnoreCase("windows")) {
                    chromeOptions.setPlatformName("Windows 10");
                } else if (platformName.equalsIgnoreCase("linux")) {
                    chromeOptions.setPlatformName("Linux");
                } else {
                    throw new IllegalArgumentException("Unsupported platform: " + platformName);
                }
                return chromeOptions;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (platformName.equalsIgnoreCase("windows")) {
                    edgeOptions.setPlatformName("Windows 10");
                } else if (platformName.equalsIgnoreCase("linux")) {
                    edgeOptions.setPlatformName("Linux");
                } else {
                    throw new IllegalArgumentException("Unsupported platform: " + platformName);
                }
                return edgeOptions;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (platformName.equalsIgnoreCase("windows")) {
                    firefoxOptions.setPlatformName("Windows 10");
                } else if (platformName.equalsIgnoreCase("linux")) {
                    firefoxOptions.setPlatformName("Linux");
                } else {
                    throw new IllegalArgumentException("Unsupported platform: " + platformName);
                }
                return firefoxOptions;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    public static WebDriver startDriver(String browser, String platformName, String gridUrl) {
        URI uri;
        URL url;
        try {
            uri = new URI(gridUrl);
            url = uri.toURL();
            LogsUtils.info("Starting remote driver for browser: " + browser + " on platform: " + platformName);
            return new RemoteWebDriver(url, getOptions(browser, platformName));
        } catch (URISyntaxException | MalformedURLException e) {
            LogsUtils.error("Error starting remote driver: " + e.getMessage());
        }
        return null;
    }
}
