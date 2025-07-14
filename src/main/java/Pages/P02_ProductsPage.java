package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P02_ProductsPage {
    private final By sauceLabsBackpackAddToCartButtonLocator = By.id("add-to-cart-sauce-labs-backpack");
    private final By numberOfItemsInCartLocator = By.cssSelector("[data-test=\"shopping-cart-badge\"]");

    private final DriverFactory driver;

    public P02_ProductsPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Sauce Labs Backpack Add to Cart button")
    public P02_ProductsPage clickOnSauceLabsBackpackAddToCartButton() {
        LogsUtils.info("Clicking on Sauce Labs Backpack Add to Cart button");
        driver.elementUtils().clickOnElement(sauceLabsBackpackAddToCartButtonLocator);
        return this;
    }

    @Step("Get number of items in cart")
    private String getNumberOfItemsInCart() {
        LogsUtils.info("Getting number of items in cart");
        return driver.elementUtils().getDataFromElement(numberOfItemsInCartLocator);
    }

    @Step("Assert number of items in cart")
    public P02_ProductsPage assertNumberOfItemsInCart(String expectedNumber) {
        LogsUtils.info("Asserting number of items in cart");
        SoftAssertUtils.softAssertEquals(getNumberOfItemsInCart(), expectedNumber, "Number of items in cart is not as expected");
        return this;
    }

}
