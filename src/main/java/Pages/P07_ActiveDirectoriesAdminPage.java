package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P07_ActiveDirectoriesAdminPage {
    private final By addNewActiveDirectoryButtonLocator = By.cssSelector("[title=\"Add new active directory\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By urlTextFieldLocator = By.cssSelector("[formcontrolname=\"url\"]");
    private final By siteDropdownLocator = By.cssSelector("[formcontrolname=\"sites\"]");
    private final By activeCheckboxLocator = By.cssSelector("[formcontrolname=\"active\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By nameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By yesButtonLocator = By.xpath("//button[.=\"Yes\"]");
    private final By okButtonLocator = By.xpath("//button[.=\"OK\"]");
    private final By closeButtonLocator = By.cssSelector("[title=\"Close\"]");

    private final By activeDirectoryEditedMessageLocator = By.xpath("//p [.=\"Active directory has been updated successfully\"]");
    private final By activeDirectoryDeletedMessageLocator = By.xpath("//p [.=\"Selected active directory has been deleted successfully\"]");

    private final By emptyNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name is required \"]");
    private final By emptyUrlMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" URL is required \"]");
    private final By invalidUrlMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Invalid URL \"]");
    private final By emptySiteMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Select at least one site \"]");
    private final By spacesOnlyNameFieldMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name cannot contain spaces only \"]");

    private final DriverFactory driver;

    public P07_ActiveDirectoriesAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add New Active Directory Button")
    public P07_ActiveDirectoriesAdminPage clickOnAddNewActiveDirectoryButton() {
        LogsUtils.info("Clicking on Add New Active Directory Button");
        driver.elementUtils().clickOnElement(addNewActiveDirectoryButtonLocator);
        return this;
    }

    @Step("Enter Name: {name}")
    public P07_ActiveDirectoriesAdminPage enterName(String name) {
        LogsUtils.info("Entering Name: " + name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Enter URL: {url}")
    public P07_ActiveDirectoriesAdminPage enterUrl(String url) {
        LogsUtils.info("Entering URL: " + url);
        driver.elementUtils().sendDataToElement(urlTextFieldLocator, url);
        return this;
    }

    @Step("Select Site")
    public P07_ActiveDirectoriesAdminPage selectSite() {
        LogsUtils.info("Selecting Site");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Click on Site Dropdown")
    public P07_ActiveDirectoriesAdminPage clickOnSiteDropdown() {
        LogsUtils.info("Clicking on Site Dropdown");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        return this;
    }

    @Step("Check Active Checkbox")
    public P07_ActiveDirectoriesAdminPage checkActiveCheckbox() {
        LogsUtils.info("Checking Active Checkbox");
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Save Button")
    public P07_ActiveDirectoriesAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save Button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Search Active Directory by Name: {name}")
    public P07_ActiveDirectoriesAdminPage searchActiveDirectoryByName(String name) {
        LogsUtils.info("Searching Active Directory by Name: " + name);
        driver.elementUtils().sendDataToElement(nameSearchFieldLocator, name);
        return this;
    }

    @Step("Click on Edit button")
    public P07_ActiveDirectoriesAdminPage clickOnEditButton(String name) {
        LogsUtils.info("Clicking on Edit button for Active Directory: " + name);
        By editButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P07_ActiveDirectoriesAdminPage clickOnDeleteButton(String name) {
        LogsUtils.info("Clicking on Delete button for Active Directory: " + name);
        By deleteButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes Button")
    public P07_ActiveDirectoriesAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes Button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on OK Button")
    public P07_ActiveDirectoriesAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK Button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Click on Close Button")
    public P07_ActiveDirectoriesAdminPage clickOnCloseButton() {
        LogsUtils.info("Clicking on Close Button");
        driver.elementUtils().clickOnElement(closeButtonLocator);
        return this;
    }

    @Step("Assert visibility of Active Directory Edited Alert")
    public void assertVisibilityOfActiveDirectoryEditedAlert() {
        LogsUtils.info("Asserting visibility of Active Directory Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(activeDirectoryEditedMessageLocator),
                "Active directory edited alert not visible"
        );
    }

    @Step("Assert visibility of Active Directory Deleted Alert")
    public void assertVisibilityOfActiveDirectoryDeletedAlert() {
        LogsUtils.info("Asserting visibility of Active Directory Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(activeDirectoryDeletedMessageLocator),
                "Active directory deleted alert not visible"
        );
    }

    @Step("Assert visibility of Empty Name Message")
    public void assertVisibilityOfEmptyNameMessage() {
        LogsUtils.info("Asserting visibility of Empty Name Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyNameMessageLocator),
                "Empty name message not visible"
        );
    }

    @Step("Assert visibility of Empty URL Message")
    public void assertVisibilityOfEmptyUrlMessage() {
        LogsUtils.info("Asserting visibility of Empty URL Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyUrlMessageLocator),
                "Empty URL message not visible"
        );
    }

    @Step("Assert visibility of Invalid URL Message")
    public void assertVisibilityOfInvalidUrlMessage() {
        LogsUtils.info("Asserting visibility of Invalid URL Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(invalidUrlMessageLocator),
                "Invalid URL message not visible"
        );
    }

    @Step("Assert visibility of Empty Site Message")
    public void assertVisibilityOfEmptySiteMessage() {
        LogsUtils.info("Asserting visibility of Empty Site Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySiteMessageLocator),
                "Empty site message not visible"
        );
    }

    @Step("Assert visibility of spaces only name field message")
    public void assertVisibilityOfSpacesOnlyNameFieldMessage() {
        LogsUtils.info("Asserting visibility of spaces only name field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyNameFieldMessageLocator),
                "Spaces only name field message not visible"
        );
    }
} 