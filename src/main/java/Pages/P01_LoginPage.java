package Pages;

import Utilities.BrowserUtils;
import Utilities.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class P01_LoginPage {
    private final By usernameFieldLocator = By.cssSelector("[formcontrolname=\"userName\"]");
    private final By passwordFieldLocator = By.cssSelector("[formcontrolname=\"password\"]");
    private final By loginButtonLocator = By.id("btnlogin");

    private final WebDriver driver;

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public P01_LoginPage navigateToLoginPage(String url) {
        BrowserUtils.navigateToUrl(driver, url);
        return this;
    }

    public P01_LoginPage enterUsername(String username) {
        ElementUtils.sendDataToElement(driver, usernameFieldLocator, username);
        return this;
    }

    public P01_LoginPage enterPassword(String password) {
        ElementUtils.sendDataToElement(driver, passwordFieldLocator, password);
        return this;
    }

    public P01_LoginPage clickLoginButton() {
        ElementUtils.clickOnElement(driver, loginButtonLocator);
        return this;
    }

    public void assertLoginWithValidCredentials(){
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://example.com/dashboard";
        Assert.assertEquals(actualUrl, expectedUrl, "Login with valid credentials failed.");
    }
}
