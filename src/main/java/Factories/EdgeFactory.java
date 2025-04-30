package Factories;

import Utilities.PropertiesUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Map;

public class EdgeFactory extends AbstractDriver implements WebDriverOptions<EdgeOptions> {
    @Override
    public EdgeOptions getOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--disable-extensions");
        edgeOptions.addArguments("--disable-infobars");
        edgeOptions.addArguments("--disable-notifications");
        edgeOptions.addArguments("--remote-allow-origins=*");
        Map<String, Object> edgePrefs = Map.of(
                "profile.default_content_setting_values.notifications", 2,
                "credential_enable_service", false,
                "profile.password_manager_enabled", false,
                "autofill.profile.enabled", false,
                "autofill.credit_card_enabled", false
        );
        edgeOptions.setExperimentalOption("prefs", edgePrefs);
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        if (!PropertiesUtils.getPropertyValue("executionType").equalsIgnoreCase("local")) {
            edgeOptions.addArguments("--headless");
        }
        return edgeOptions;
    }

    @Override
    public WebDriver startDriver() {
        return new EdgeDriver(getOptions());
    }
}
