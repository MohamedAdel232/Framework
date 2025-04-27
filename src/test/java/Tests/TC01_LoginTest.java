package Tests;

import Pages.P01_LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC01_LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
    }

    @Test
    public void loginWithValidCredentialsTC() {
        new P01_LoginPage(driver)
            .navigateToLoginPage("https://example.com/login")
            .enterUsername("validUser")
            .enterPassword("validPassword")
            .clickLoginButton()
            .assertLoginWithValidCredentials();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
