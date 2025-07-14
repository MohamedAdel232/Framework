package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P01_LoginPage {
    private final By usernameTextFieldLocator = By.id("user-name");
    private final By passwordTextFieldLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-button");

    private final DriverFactory driver;

    public P01_LoginPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Navigate to login page")
    public P01_LoginPage navigateToLoginPage(String url) {
        LogsUtils.info("Navigating to login page");
        driver.browserUtils().navigateToUrl(url);
        return this;
    }

    @Step("Enter username")
    public P01_LoginPage enterUsername(String username) {
        LogsUtils.info("Entering username");
        driver.elementUtils().sendDataToElement(usernameTextFieldLocator, username);
        return this;
    }

    @Step("Enter password")
    public P01_LoginPage enterPassword(String password) {
        LogsUtils.info("Entering password");
        driver.elementUtils().sendDataToElement(passwordTextFieldLocator, password);
        return this;
    }

    @Step("Click login button")
    public P01_LoginPage clickLoginButton() {
        LogsUtils.info("Clicking login button");
        driver.elementUtils().clickOnElement(loginButtonLocator);
        return this;
    }

    @Step("Assert login with valid credentials")
    public P01_LoginPage assertLoginWithValidCredentials() {
        String expectedUrl = PropertiesUtils.getPropertyValue("HomePageUrl");
        LogsUtils.info("Asserting login with valid credentials");
        driver.softAssertActionsUtils().assertPageUrl(expectedUrl, "Login with valid credentials failed");
        return this;
    }
}
