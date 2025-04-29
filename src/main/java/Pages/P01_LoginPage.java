package Pages;

import Utilities.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    private final By usernameFieldLocator = By.id("user-name");
    private final By passwordFieldLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-button");

    private final WebDriver driver;

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Navigate to login page")
    public P01_LoginPage navigateToLoginPage(String url) {
        LogsUtils.info("Navigating to login page");
        BrowserUtils.navigateToUrl(driver, url);
        return this;
    }

    @Step("Enter username")
    public P01_LoginPage enterUsername(String username) {
        LogsUtils.info("Entering username");
        ElementUtils.sendDataToElement(driver, usernameFieldLocator, username);
        return this;
    }

    @Step("Enter password")
    public P01_LoginPage enterPassword(String password) {
        LogsUtils.info("Entering password");
        ElementUtils.sendDataToElement(driver, passwordFieldLocator, password);
        return this;
    }

    @Step("Click login button")
    public P01_LoginPage clickLoginButton() {
        LogsUtils.info("Clicking login button");
        ElementUtils.clickOnElement(driver, loginButtonLocator);
        return this;
    }

    @Step("Assert login with valid credentials")
    public void assertLoginWithValidCredentials() {
        String expectedUrl = PropertiesUtils.getPropertyValue("HomePageUrl");
        LogsUtils.info("Asserting login with valid credentials");
        AssertUtils.assertPageUrl(driver, expectedUrl, "Login with valid credentials failed");
    }
}
