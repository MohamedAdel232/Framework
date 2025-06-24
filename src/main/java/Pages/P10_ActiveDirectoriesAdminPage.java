package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P10_ActiveDirectoriesAdminPage {
    private final By addButtonLocator = By.id("addNewLDAP");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By urlTextFieldLocator = By.cssSelector("[formcontrolname=\"url\"]");
    private final By institutionDropdownLocator = By.id("Institution");
    private final By locationDropdownLocator = By.cssSelector("[formcontrolname=\"location\"]");
    private final By activeCheckboxLocator = By.id("active");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By nameSearchTextFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By okButtonLocator = By.xpath("//button [.='OK']");
    private final By yesButtonLocator = By.xpath("//button[.='Yes']");
    private final By closeButtonLocator = By.cssSelector("[title=\"Close\"]");

    private final By activeDirectoryAddedMessageLocator = By.xpath("//p [.='The active directory has been added successfully']");
    private final By activeDirectoryEditedMessageLocator = By.xpath("//p [.='The selected active directory has been updated successfully']");
    private final By activeDirectoryDeletedMessageLocator = By.xpath("//p [.='The selected active directory has been deleted successfully']");

    private final By nameIsRequiredMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' Name is required ']");
    private final By nameCannotContainWhiteSpacesOnlyMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' Name cannot contain white spaces only ']");

    private final By urlIsRequiredMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' URL is required ']");
    private final By invalidUrlMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' Invalid URL ']");
    private final By urlCannotContainWhiteSpacesOnlyMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' URL cannot contain white spaces only ']");

    private final By institutionIsRequiredMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' Institution is required ']");

    private final By locationIsRequiredMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' Location is required ']");

    private final DriverFactory driver;

    public P10_ActiveDirectoriesAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add Button")
    public P10_ActiveDirectoriesAdminPage clickOnAddButton() {
        LogsUtils.info("Clicking on Add Button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter Name")
    public P10_ActiveDirectoriesAdminPage enterName(String name) {
        LogsUtils.info("Entering Name:", name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Enter URL")
    public P10_ActiveDirectoriesAdminPage enterURL(String url) {
        LogsUtils.info("Entering URL:", url);
        driver.elementUtils().sendDataToElement(urlTextFieldLocator, url);
        return this;
    }

    @Step("Select Institution")
    public P10_ActiveDirectoriesAdminPage selectInstitution(String institution) {
        LogsUtils.info("Selecting Institution:", institution);
        driver.elementUtils().clickOnElement(institutionDropdownLocator);
        By institutionOptionLocator = By.xpath("//li[.=' " + institution + " ']");
        driver.elementUtils().clickOnElement(institutionOptionLocator);
        return this;
    }

    @Step("Click on Institution Dropdown")
    public P10_ActiveDirectoriesAdminPage clickOnInstitutionDropdown() {
        LogsUtils.info("Clicking on Institution Dropdown");
        driver.elementUtils().clickOnElement(institutionDropdownLocator);
        return this;
    }

    @Step("Select Location")
    public P10_ActiveDirectoriesAdminPage selectLocation() {
        LogsUtils.info("Selecting Location");
        driver.elementUtils().clickOnElement(locationDropdownLocator);
        By locationOptionLocator = By.xpath("(//li[@role='option'])[1]");
        driver.elementUtils().clickOnElement(locationOptionLocator);
        return this;
    }

    @Step("Click On Location Dropdown")
    public P10_ActiveDirectoriesAdminPage clickOnLocationDropdown() {
        LogsUtils.info("Clicking On Location Dropdown");
        driver.elementUtils().clickOnElement(locationDropdownLocator);
        return this;
    }

    @Step("Check Active Checkbox")
    public P10_ActiveDirectoriesAdminPage checkOnActiveCheckbox() {
        LogsUtils.info("Check Active Checkbox");
        driver.elementUtils().checkCheckboxJS(activeCheckboxLocator);
        return this;
    }

    @Step("Uncheck Active Checkbox")
    public P10_ActiveDirectoriesAdminPage uncheckOnActiveCheckbox() {
        LogsUtils.info("Uncheck Active Checkbox");
        driver.elementUtils().uncheckCheckboxJS(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Save Button")
    public P10_ActiveDirectoriesAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save Button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Search for Active Directory by Name")
    public P10_ActiveDirectoriesAdminPage searchForActiveDirectoryByName(String name) {
        LogsUtils.info("Searching for Active Directory:", name);
        driver.elementUtils().sendDataToElement(nameSearchTextFieldLocator, name);
        return this;
    }

    @Step("Click on OK Button")
    public P10_ActiveDirectoriesAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK Button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Click on Yes Button")
    public P10_ActiveDirectoriesAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes Button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on Close Button")
    public P10_ActiveDirectoriesAdminPage clickOnCloseButton() {
        LogsUtils.info("Clicking on Close Button");
        driver.elementUtils().clickOnElement(closeButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P10_ActiveDirectoriesAdminPage clickOnEditButton(String directoryName) {
        LogsUtils.info("Clicking on Edit Button for Active Directory: " + directoryName);
        By editButtonLocator = By.xpath("//td[.='" + directoryName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P10_ActiveDirectoriesAdminPage clickOnDeleteButton(String directoryName) {
        LogsUtils.info("Clicking on Delete Button for Active Directory: " + directoryName);
        By deleteButtonLocator = By.xpath("//td[.='" + directoryName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Assert Active Directory Added Message")
    public void assertActiveDirectoryAddedMessage(String expectedMessage) {
        LogsUtils.info("Asserting Active Directory Added Message");
        String actualMessage = driver.elementUtils().getDataFromElement(activeDirectoryAddedMessageLocator);
        LogsUtils.info("Expected Active Directory Added Message:", expectedMessage);
        LogsUtils.info("Actual Active Directory Added Message:", actualMessage);
        SoftAssertUtils.softAssertEquals(actualMessage, expectedMessage, "Wrong Active Directory Added Message");
    }

    @Step("Assert Active Directory Edited Message")
    public void assertActiveDirectoryEditedMessage(String expectedMessage) {
        LogsUtils.info("Asserting Active Directory Edited Message");
        String actualMessage = driver.elementUtils().getDataFromElement(activeDirectoryEditedMessageLocator);
        LogsUtils.info("Expected Active Directory Edited Message:", expectedMessage);
        LogsUtils.info("Actual Active Directory Edited Message:", actualMessage);
        SoftAssertUtils.softAssertEquals(actualMessage, expectedMessage, "Wrong Active Directory Edited Message");
    }

    @Step("Assert Active Directory Deleted Message")
    public void assertActiveDirectoryDeletedMessage(String expectedMessage) {
        LogsUtils.info("Asserting Active Directory Deleted Message");
        String actualMessage = driver.elementUtils().getDataFromElement(activeDirectoryDeletedMessageLocator);
        LogsUtils.info("Expected Active Directory Deleted Message:", expectedMessage);
        LogsUtils.info("Actual Active Directory Deleted Message:", actualMessage);
        SoftAssertUtils.softAssertEquals(actualMessage, expectedMessage, "Wrong Active Directory Deleted Message");
    }

    @Step("Assert Visibility of Name is Required Message")
    public void assertVisibilityOfNameIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of Name Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(nameIsRequiredMessageLocator),
                "Name Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of Name Cannot Contain White Spaces Only Message")
    public void assertVisibilityOfNameCannotContainWhiteSpacesOnlyMessage() {
        LogsUtils.info("Asserting Visibility Of Name Cannot Contain White Spaces Only Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(nameCannotContainWhiteSpacesOnlyMessageLocator),
                "Name Cannot Contain White Spaces Only Message is not Displayed");
    }

    @Step("Assert Visibility of URL is Required Message")
    public void assertVisibilityOfURLIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of URL Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(urlIsRequiredMessageLocator),
                "URL Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of Invalid URL Message")
    public void assertVisibilityOfInvalidURLMessage() {
        LogsUtils.info("Asserting Visibility Of Invalid URL Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(invalidUrlMessageLocator),
                "Invalid URL Message is not Displayed");
    }

    @Step("Assert Visibility of URL Cannot Contain White Spaces Only Message")
    public void assertVisibilityOfURLCannotContainWhiteSpacesOnlyMessage() {
        LogsUtils.info("Asserting Visibility Of URL Cannot Contain White Spaces Only Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(urlCannotContainWhiteSpacesOnlyMessageLocator),
                "URL Cannot Contain White Spaces Only Message is not Displayed");
    }

    @Step("Assert Visibility of Institution is Required Message")
    public void assertVisibilityOfInstitutionIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of Institution Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(institutionIsRequiredMessageLocator),
                "Institution Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of Location is Required Message")
    public void assertVisibilityOfLocationIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of Location Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(locationIsRequiredMessageLocator),
                "Location Is Required Message is not Displayed");
    }
} 