package Factories;

import Utilities.PropertiesUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class ChromeFactory extends AbstractDriver implements WebDriverOptions<ChromeOptions> {
    @Override
    public ChromeOptions getOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--remote-allow-origins=*");
        Map<String, Object> chromePrefs = Map.of(
                "profile.default_content_setting_values.notifications", 2,
                "credential_enable_service", false,
                "profile.password_manager_enabled", false,
                "autofill.profile.enabled", false,
                "autofill.credit_card_enabled", false
        );
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        if (!PropertiesUtils.getPropertyValue("executionType").equalsIgnoreCase("local")) {
            chromeOptions.addArguments("--headless");
        }
        return chromeOptions;
    }

    @Override
    public WebDriver startDriver() {
        return new ChromeDriver(getOptions());
    }
}
