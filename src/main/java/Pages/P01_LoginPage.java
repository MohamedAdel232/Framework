package Pages;

import Utilities.BrowserUtils;
import Utilities.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    private final By usernameFieldLocator = By.cssSelector("[formcontrolname=\"userName\"]");
    private final By passwordFieldLocator = By.cssSelector("[formcontrolname=\"password\"]");
    private final By loginButtonLocator = By.id("btnlogin");

    private final WebDriver driver;

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage(String url) {
        BrowserUtils.navigateToUrl(driver, url);
    }

    public void enterUsername(String username) {
        ElementUtils.sendDataToElement(driver, usernameFieldLocator, username);
    }

    public void enterPassword(String password) {
        ElementUtils.sendDataToElement(driver, passwordFieldLocator, password);
    }

    public void clickLoginButton() {
        ElementUtils.clickOnElement(driver, loginButtonLocator);
    }
}
