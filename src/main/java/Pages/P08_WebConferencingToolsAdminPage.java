package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P08_WebConferencingToolsAdminPage {
    private final By addNewWebConferencingToolButtonLocator = By.cssSelector("[title=\"Add new web conferencing tool\"]");
    private final By typeDropdownLocator = By.cssSelector("[formcontrolname=\"type\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By applicationIdTextFieldLocator = By.cssSelector("[formcontrolname=\"applicationId\"]");
    private final By directoryIdTextFieldLocator = By.cssSelector("[formcontrolname=\"directoryId\"]");
    private final By clientSecretTextFieldLocator = By.cssSelector("[formcontrolname=\"clientSecret\"]");
    private final By siteDropdownLocator = By.cssSelector("[formcontrolname=\"sites\"]");
    private final By activeCheckboxLocator = By.cssSelector("[formcontrolname=\"status\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By nameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By yesButtonLocator = By.xpath("//button[.=\"Yes\"]");
    private final By okButtonLocator = By.xpath("//button[.=\"OK\"]");
    private final By closeButtonLocator = By.cssSelector("[title=\"Close\"]");

    private final By webConferencingToolAddedMessageLocator = By.xpath("//p [.=\"Web conferencing tool has been added successfully\"]");
    private final By webConferencingToolEditedMessageLocator = By.xpath("//p [.=\"Web Conferencing Tool Updated Successfully\"]");
    private final By webConferencingToolDeletedMessageLocator = By.xpath("//p [.=\"Selected web conferencing tool has been deleted successfully\"]");

    private final By emptyNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name is required \"]");
    private final By emptyApplicationIdMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Application ID is required \"]");
    private final By emptyDirectoryIdMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Directory ID is required \"]");
    private final By emptyClientSecretMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Client Secret is required \"]");
    private final By emptySiteMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Please select at least one site \"]");

    private final By spacesOnlyNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name can't contain only white space \"]");
    private final By spacesOnlyApplicationIdMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Application ID can't contain only white space \"]");
    private final By spacesOnlyDirectoryIdMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Directory ID can't contain only white space \"]");
    private final By spacesOnlyClientSecretMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Client Secret can't contain only white space \"]");

    private final DriverFactory driver;

    public P08_WebConferencingToolsAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add New Web Conferencing Tool Button")
    public P08_WebConferencingToolsAdminPage clickOnAddNewWebConferencingToolButton() {
        LogsUtils.info("Clicking on Add New Web Conferencing Tool Button");
        driver.elementUtils().clickOnElement(addNewWebConferencingToolButtonLocator);
        return this;
    }

    @Step("Select Type")
    public P08_WebConferencingToolsAdminPage selectType() {
        LogsUtils.info("Selecting Type");
        driver.elementUtils().clickOnElement(typeDropdownLocator);
        By typeOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(typeOptionLocator);
        return this;
    }

    @Step("Click on Type Dropdown")
    public P08_WebConferencingToolsAdminPage clickOnTypeDropdown() {
        LogsUtils.info("Clicking on Type Dropdown");
        driver.elementUtils().clickOnElement(typeDropdownLocator);
        return this;
    }

    @Step("Enter Name: {name}")
    public P08_WebConferencingToolsAdminPage enterWebConferencingToolName(String name) {
        LogsUtils.info("Entering Name: " + name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Enter Application ID: {applicationId}")
    public P08_WebConferencingToolsAdminPage enterApplicationId(String applicationId) {
        LogsUtils.info("Entering Application ID: " + applicationId);
        driver.elementUtils().sendDataToElement(applicationIdTextFieldLocator, applicationId);
        return this;
    }

    @Step("Enter Directory ID: {directoryId}")
    public P08_WebConferencingToolsAdminPage enterDirectoryId(String directoryId) {
        LogsUtils.info("Entering Directory ID: " + directoryId);
        driver.elementUtils().sendDataToElement(directoryIdTextFieldLocator, directoryId);
        return this;
    }

    @Step("Enter Client Secret: {clientSecret}")
    public P08_WebConferencingToolsAdminPage enterClientSecret(String clientSecret) {
        LogsUtils.info("Entering Client Secret: " + clientSecret);
        driver.elementUtils().sendDataToElement(clientSecretTextFieldLocator, clientSecret);
        return this;
    }

    @Step("Select Site")
    public P08_WebConferencingToolsAdminPage selectSite() {
        LogsUtils.info("Selecting Site");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Click on Site Dropdown")
    public P08_WebConferencingToolsAdminPage clickOnSiteDropdown() {
        LogsUtils.info("Clicking on Site Dropdown");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        return this;
    }

    @Step("Check Active Checkbox")
    public P08_WebConferencingToolsAdminPage checkActiveCheckbox() {
        LogsUtils.info("Checking Active Checkbox");
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Save Button")
    public P08_WebConferencingToolsAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save Button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Search Web Conferencing Tool by Name: {name}")
    public P08_WebConferencingToolsAdminPage searchWebConferencingToolByName(String name) {
        LogsUtils.info("Searching Web Conferencing Tool by Name: " + name);
        driver.elementUtils().sendDataToElement(nameSearchFieldLocator, name);
        return this;
    }

    @Step("Click on Edit button")
    public P08_WebConferencingToolsAdminPage clickOnEditButton(String name) {
        LogsUtils.info("Clicking on Edit button for Web Conferencing Tool: " + name);
        By editButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P08_WebConferencingToolsAdminPage clickOnDeleteButton(String name) {
        LogsUtils.info("Clicking on Delete button for Web Conferencing Tool: " + name);
        By deleteButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes Button")
    public P08_WebConferencingToolsAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes Button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on OK Button")
    public P08_WebConferencingToolsAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK Button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Click on Close Button")
    public P08_WebConferencingToolsAdminPage clickOnCloseButton() {
        LogsUtils.info("Clicking on Close Button");
        driver.elementUtils().clickOnElement(closeButtonLocator);
        return this;
    }

    @Step("Assert visibility of Web Conferencing Tool Added Alert")
    public void assertVisibilityOfWebConferencingToolAddedAlert() {
        LogsUtils.info("Asserting visibility of Web Conferencing Tool Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(webConferencingToolAddedMessageLocator),
                "Web conferencing tool added alert not visible"
        );
    }

    @Step("Assert visibility of Web Conferencing Tool Edited Alert")
    public void assertVisibilityOfWebConferencingToolEditedAlert() {
        LogsUtils.info("Asserting visibility of Web Conferencing Tool Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(webConferencingToolEditedMessageLocator),
                "Web conferencing tool edited alert not visible"
        );
    }

    @Step("Assert visibility of Web Conferencing Tool Deleted Alert")
    public void assertVisibilityOfWebConferencingToolDeletedAlert() {
        LogsUtils.info("Asserting visibility of Web Conferencing Tool Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(webConferencingToolDeletedMessageLocator),
                "Web conferencing tool deleted alert not visible"
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

    @Step("Assert visibility of Empty Application ID Message")
    public void assertVisibilityOfEmptyApplicationIdMessage() {
        LogsUtils.info("Asserting visibility of Empty Application ID Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyApplicationIdMessageLocator),
                "Empty application ID message not visible"
        );
    }

    @Step("Assert visibility of Empty Directory ID Message")
    public void assertVisibilityOfEmptyDirectoryIdMessage() {
        LogsUtils.info("Asserting visibility of Empty Directory ID Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyDirectoryIdMessageLocator),
                "Empty directory ID message not visible"
        );
    }

    @Step("Assert visibility of Empty Client Secret Message")
    public void assertVisibilityOfEmptyClientSecretMessage() {
        LogsUtils.info("Asserting visibility of Empty Client Secret Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyClientSecretMessageLocator),
                "Empty client secret message not visible"
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

    @Step("Assert visibility of Spaces Only Name Message")
    public void assertVisibilityOfSpacesOnlyNameMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only Name Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyNameMessageLocator),
                "Spaces only name message not visible"
        );
    }

    @Step("Assert visibility of Spaces Only Application ID Message")
    public void assertVisibilityOfSpacesOnlyApplicationIdMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only Application ID Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyApplicationIdMessageLocator),
                "Spaces only application ID message not visible"
        );
    }

    @Step("Assert visibility of Spaces Only Directory ID Message")
    public void assertVisibilityOfSpacesOnlyDirectoryIdMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only Directory ID Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyDirectoryIdMessageLocator),
                "Spaces only directory ID message not visible"
        );
    }

    @Step("Assert visibility of Spaces Only Client Secret Message")
    public void assertVisibilityOfSpacesOnlyClientSecretMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only Client Secret Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyClientSecretMessageLocator),
                "Spaces only client secret message not visible"
        );
    }
} 