package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P04_LocationsAdminPage {
    private final By addButtonLocator = By.id("addNewLocation");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By hl7LocationNameTextFieldLocator = By.cssSelector("[formcontrolname=\"hl7LocationName\"]");
    private final By accessionNoPrefixTextFieldLocator = By.cssSelector("[formcontrolname=\"accessionNumberPrefix\"]");
    private final By anonymizedAccessionNoPrefixTextFieldLocator = By.cssSelector("[formcontrolname=\"anonymizedAccessionNumberPrefix\"]");
    private final By anonymizedPatientNamePrefixTextFieldLocator = By.cssSelector("[formcontrolname=\"anonymizedPatientNamePrefix\"]");
    private final By anonymizedPatientIdPrefixTextFieldLocator = By.cssSelector("[formcontrolname=\"anonymizedPatientIdPrefix\"]");
    private final By studyAutoDeleteTextFieldLocator = By.cssSelector("[formcontrolname=\"studyAutoDelete\"]");
    private final By queryIntervalTextFieldLocator = By.cssSelector("[formcontrolname=\"queryInterval\"]");
    private final By queryTimeoutTextFieldLocator = By.cssSelector("[formcontrolname=\"queryTimeout\"]");
    private final By matchImageCountTextFieldLocator = By.cssSelector("[formcontrolname=\"matchImageCount\"]");
    private final By institutionDropdownLocator = By.id("Institution");
    private final By enableRoutingCheckboxLocator = By.id("enablerouting");
    private final By activeCheckboxLocator = By.id("customCheck1");
    private final By saveButtonLocator = By.xpath("//span [.=\" Save \"]");
    private final By nameSearchTextFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By okButtonLocator = By.xpath("//button [.=\"OK\"]");
    private final By yesButtonLocator = By.xpath("//button[.=\"Yes\"]");
    private final By closeButtonLocator = By.cssSelector("[title=\"Close\"]");

    private final By locationAddedMessageLocator = By.xpath("//p [.=\"Location has been Added successfully\"]");
    private final By locationEditedMessageLocator = By.xpath("//p [.=\"Location has been Updated successfully\"]");
    private final By locationDeletedMessageLocator = By.xpath("//p [.=\"The selected location has been deleted successfully\"]");

    private final By nameIsRequiredMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name is required \"]");
    private final By nameCannotContainWhiteSpacesMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name cannot contain white spaces \"]");

    private final By queryIntervalIsRequiredMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Query Interval is required \"]");
    private final By queryIntervalMustBeBetween1And20MessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Query Interval must be between 1 and 20. \"]");

    private final By queryTimeoutIsRequiredMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Query Timeout is required \"]");
    private final By queryTimeoutMustBeGreaterThan1MessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Query Timeout must be Greater than 1. \"]");

    private final By matchImageCountIsRequiredMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Match Image Count is required \"]");
    private final By matchImageCountMustBeBetween2And5MessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Match Image Count must be between 2 and 5. \"]");

    private final By institutionIsRequiredMessageLocator = By.xpath("//div [@class=\"text-danger\"][.=\" Institution is required \"]");

    private final DriverFactory driver;

    public P04_LocationsAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add Button")
    public P04_LocationsAdminPage clickOnAddButton() {
        LogsUtils.info("Clicking on Add Button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter Name")
    public P04_LocationsAdminPage enterName(String name) {
        LogsUtils.info("Entering Name:", name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Enter HL7 Location Name")
    public P04_LocationsAdminPage enterHl7LocationName(String hl7LocationName) {
        LogsUtils.info("Entering HL7 Location Name:", hl7LocationName);
        driver.elementUtils().sendDataToElement(hl7LocationNameTextFieldLocator, hl7LocationName);
        return this;
    }

    @Step("Enter Accession Number Prefix")
    public P04_LocationsAdminPage enterAccessionNoPrefix(String accessionNoPrefix) {
        LogsUtils.info("Entering Accession Number Prefix:", accessionNoPrefix);
        driver.elementUtils().sendDataToElement(accessionNoPrefixTextFieldLocator, accessionNoPrefix);
        return this;
    }

    @Step("Enter Anonymized Accession Number Prefix")
    public P04_LocationsAdminPage enterAnonymizedAccessionNoPrefix(String anonymizedAccessionNoPrefix) {
        LogsUtils.info("Entering Anonymized Accession Number Prefix:", anonymizedAccessionNoPrefix);
        driver.elementUtils().sendDataToElement(anonymizedAccessionNoPrefixTextFieldLocator, anonymizedAccessionNoPrefix);
        return this;
    }

    @Step("Enter Anonymized Patient Name Prefix")
    public P04_LocationsAdminPage enterAnonymizedPatientNamePrefix(String anonymizedPatientNamePrefix) {
        LogsUtils.info("Entering Anonymized Patient Name Prefix:", anonymizedPatientNamePrefix);
        driver.elementUtils().sendDataToElement(anonymizedPatientNamePrefixTextFieldLocator, anonymizedPatientNamePrefix);
        return this;
    }

    @Step("Enter Anonymized Patient ID Prefix")
    public P04_LocationsAdminPage enterAnonymizedPatientIdPrefix(String anonymizedPatientIdPrefix) {
        LogsUtils.info("Entering Anonymized Patient ID Prefix:", anonymizedPatientIdPrefix);
        driver.elementUtils().sendDataToElement(anonymizedPatientIdPrefixTextFieldLocator, anonymizedPatientIdPrefix);
        return this;
    }

    @Step("Enter Study Auto Delete")
    public P04_LocationsAdminPage enterStudyAutoDelete(String studyAutoDelete) {
        LogsUtils.info("Entering Study Auto Delete:", studyAutoDelete);
        driver.elementUtils().sendDataToElement(studyAutoDeleteTextFieldLocator, studyAutoDelete);
        return this;
    }

    @Step("Enter Query Interval")
    public P04_LocationsAdminPage enterQueryInterval(String queryInterval) {
        LogsUtils.info("Entering Query Interval:", queryInterval);
        driver.elementUtils().sendDataToElement(queryIntervalTextFieldLocator, queryInterval);
        return this;
    }

    @Step("Enter Query Timeout")
    public P04_LocationsAdminPage enterQueryTimeout(String queryTimeout) {
        LogsUtils.info("Entering Query Timeout:", queryTimeout);
        driver.elementUtils().sendDataToElement(queryTimeoutTextFieldLocator, queryTimeout);
        return this;
    }

    @Step("Enter Match Image Count")
    public P04_LocationsAdminPage enterMatchImageCount(String matchImageCount) {
        LogsUtils.info("Entering Match Image Count:", matchImageCount);
        driver.elementUtils().sendDataToElement(matchImageCountTextFieldLocator, matchImageCount);
        return this;
    }

    @Step("Select Institution")
    public P04_LocationsAdminPage selectInstitution(String institution) {
        LogsUtils.info("Selecting Institution:", institution);
        driver.elementUtils().clickOnElement(institutionDropdownLocator);
        By institutionOptionLocator = By.xpath("//li[.=\" " + institution + " \"]");
        driver.elementUtils().clickOnElement(institutionOptionLocator);
        return this;
    }

    @Step("Click On Institution Dropdown")
    public P04_LocationsAdminPage clickOnInstitutionDropdown() {
        LogsUtils.info("Click On Institution Dropdown");
        driver.elementUtils().clickOnElement(institutionDropdownLocator);
        return this;
    }

    @Step("Check Enable Routing Checkbox")
    public P04_LocationsAdminPage checkEnableRoutingCheckbox() {
        LogsUtils.info("Check Enable Routing Checkbox");
        driver.elementUtils().checkCheckboxJS(enableRoutingCheckboxLocator);
        return this;
    }

    @Step("Uncheck Enable Routing Checkbox")
    public P04_LocationsAdminPage uncheckEnableRoutingCheckbox() {
        LogsUtils.info("Uncheck Enable Routing Checkbox");
        driver.elementUtils().uncheckCheckboxJS(enableRoutingCheckboxLocator);
        return this;
    }

    @Step("Check Active Checkbox")
    public P04_LocationsAdminPage checkOnActiveCheckbox() {
        LogsUtils.info("Check Active Checkbox");
        driver.elementUtils().checkCheckboxJS(activeCheckboxLocator);
        return this;
    }

    @Step("Uncheck Active Checkbox")
    public P04_LocationsAdminPage uncheckOnActiveCheckbox() {
        LogsUtils.info("Uncheck Active Checkbox");
        driver.elementUtils().uncheckCheckboxJS(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Save Button")
    public P04_LocationsAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save Button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Search for Location by Name")
    public P04_LocationsAdminPage searchForLocationByName(String name) {
        LogsUtils.info("Searching for Location:", name);
        driver.elementUtils().sendDataToElement(nameSearchTextFieldLocator, name);
        return this;
    }

    @Step("Click on OK Button")
    public P04_LocationsAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK Button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Click on Yes Button")
    public P04_LocationsAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes Button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on Close Button")
    public P04_LocationsAdminPage clickOnCloseButton() {
        LogsUtils.info("Clicking on Close Button");
        driver.elementUtils().clickOnElement(closeButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P04_LocationsAdminPage clickOnEditButton(String locationName) {
        LogsUtils.info("Clicking on Edit Button for Location: " + locationName);
        By editButtonLocator = By.xpath("//td[.='" + locationName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P04_LocationsAdminPage clickOnDeleteButton(String locationName) {
        LogsUtils.info("Clicking on Delete Button for Location: " + locationName);
        By deleteButtonLocator = By.xpath("//td[.='" + locationName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Assert Location Added Message")
    public void assertLocationAddedMessage(String expectedLocationAddedMessage) {
        LogsUtils.info("Asserting Location Added Message");
        String actualLocationAddedMessage = driver.elementUtils().getDataFromElement(locationAddedMessageLocator);
        LogsUtils.info("Expected Location Added Message:", expectedLocationAddedMessage);
        LogsUtils.info("Actual Location Added Message:", actualLocationAddedMessage);
        SoftAssertUtils.softAssertEquals(actualLocationAddedMessage, expectedLocationAddedMessage,
                "Wrong Location Added Message");
    }

    @Step("Assert Location Edited Message")
    public void assertLocationEditedMessage(String expectedLocationEditedMessage) {
        LogsUtils.info("Asserting Location Edited Message");
        String actualLocationEditedMessage = driver.elementUtils().getDataFromElement(locationEditedMessageLocator);
        LogsUtils.info("Expected Location Edited Message:", expectedLocationEditedMessage);
        LogsUtils.info("Actual Location Edited Message:", actualLocationEditedMessage);
        SoftAssertUtils.softAssertEquals(actualLocationEditedMessage, expectedLocationEditedMessage,
                "Wrong Location Edited Message");
    }

    @Step("Assert Location Deleted Message")
    public void assertLocationDeletedMessage(String expectedLocationDeletedMessage) {
        LogsUtils.info("Asserting Location Deleted Message");
        String actualLocationDeletedMessage = driver.elementUtils().getDataFromElement(locationDeletedMessageLocator);
        LogsUtils.info("Expected Location Deleted Message:", expectedLocationDeletedMessage);
        LogsUtils.info("Actual Location Deleted Message:", actualLocationDeletedMessage);
        SoftAssertUtils.softAssertEquals(actualLocationDeletedMessage, expectedLocationDeletedMessage,
                "Wrong Location Deleted Message");
    }

    @Step("Assert Visibility of Name is Required Message")
    public void assertVisibilityOfNameIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of Name Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(nameIsRequiredMessageLocator),
                "Name Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of Name Cannot Contain White Spaces Message")
    public void assertVisibilityOfNameCannotContainWhiteSpacesMessage() {
        LogsUtils.info("Asserting Visibility Of Name Cannot Contain White Spaces Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(nameCannotContainWhiteSpacesMessageLocator),
                "Name Cannot Contain White Spaces Message is not Displayed");
    }

    @Step("Assert Visibility of Query Interval is Required Message")
    public void assertVisibilityOfQueryIntervalIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of Query Interval Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(queryIntervalIsRequiredMessageLocator),
                "Query Interval Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of Query Interval Must Be Between 1 And 20 Message")
    public void assertVisibilityOfQueryIntervalMustBeBetween1And20Message() {
        LogsUtils.info("Asserting Visibility Of Query Interval Must Be Between 1 And 20 Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(queryIntervalMustBeBetween1And20MessageLocator),
                "Query Interval Must Be Between 1 And 20 Message is not Displayed");
    }

    @Step("Assert Visibility of Query Timeout is Required Message")
    public void assertVisibilityOfQueryTimeoutIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of Query Timeout Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(queryTimeoutIsRequiredMessageLocator),
                "Query Timeout Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of Query Timeout Must Be Greater Than 1 Message")
    public void assertVisibilityOfQueryTimeoutMustBeGreaterThan1Message() {
        LogsUtils.info("Asserting Visibility Of Query Timeout Must Be Greater Than 1 Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(queryTimeoutMustBeGreaterThan1MessageLocator),
                "Query Timeout Must Be Greater Than 1 Message is not Displayed");
    }

    @Step("Assert Visibility of Match Image Count is Required Message")
    public void assertVisibilityOfMatchImageCountIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of Match Image Count Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(matchImageCountIsRequiredMessageLocator),
                "Match Image Count Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of Match Image Count Must Be Between 2 And 5 Message")
    public void assertVisibilityOfMatchImageCountMustBeBetween2And5Message() {
        LogsUtils.info("Asserting Visibility Of Match Image Count Must Be Between 2 And 5 Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(matchImageCountMustBeBetween2And5MessageLocator),
                "Match Image Count Must Be Between 2 And 5 Message is not Displayed");
    }

    @Step("Assert Visibility of Institution is Required Message")
    public void assertVisibilityOfInstitutionIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of Institution Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(institutionIsRequiredMessageLocator),
                "Institution Is Required Message is not Displayed");
    }
}