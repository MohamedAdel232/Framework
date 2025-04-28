package Pages;

import Utilities.AssertUtils;
import Utilities.BrowserUtils;
import Utilities.ElementUtils;
import Utilities.LogsUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;

public class P01_LoginPage {
    private final By usernameFieldLocator = By.id("user-name");
    private final By passwordFieldLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-button");

    private final WebDriver driver;

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public P01_LoginPage navigateToLoginPage(String url) {
        LogsUtils.info("Navigating to login page");
        BrowserUtils.navigateToUrl(driver, url);
        return this;
    }

    public P01_LoginPage enterUsername(String username) {
        LogsUtils.info("Entering username");
        ElementUtils.sendDataToElement(driver, usernameFieldLocator, username);
        return this;
    }

    public P01_LoginPage enterPassword(String password) {
        LogsUtils.info("Entering password");
        ElementUtils.sendDataToElement(driver, passwordFieldLocator, password);
        return this;
    }

    public P01_LoginPage clickLoginButton() {
        LogsUtils.info("Clicking login button");
        ElementUtils.clickOnElement(driver, loginButtonLocator);
        return this;
    }

    public void assertLoginWithValidCredentials() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        LogsUtils.info("Asserting login with valid credentials");
        AssertUtils.assertPageUrl(driver, expectedUrl, "Login with valid credentials failed");
    }
}
