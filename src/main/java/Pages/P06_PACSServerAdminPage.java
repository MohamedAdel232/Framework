package Pages;

import Factories.DriverFactory;
import Utilities.ClipboardUtils;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P06_PACSServerAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"New PACS Server\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By ipTextFieldLocator = By.cssSelector("[formcontrolname=\"ip\"]");
    private final By aeTitleTextFieldLocator = By.cssSelector("[formcontrolname=\"aeTitle\"]");
    private final By portTextFieldLocator = By.cssSelector("[formcontrolname=\"port\"]");
    private final By issuerOfPatientIdTextFieldLocator = By.cssSelector("[formcontrolname=\"patientIDIssuer\"]");
    private final By institutionDropdownLocator = By.cssSelector("[formcontrolname=\"institution\"]");
    private final By locationDropdownLocator = By.cssSelector("[formcontrolname=\"locations\"]");
    private final By activeCheckboxLocator = By.id("status");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By nameSearchTextFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By okButtonLocator = By.xpath("//button [.=\"OK\"]");
    private final By yesButtonLocator = By.xpath("//button[.='Yes']");
    private final By closeButtonLocator = By.cssSelector("[title=\"Close\"]");

    private final By pacsServerAddedMessageLocator = By.xpath("//p [.='PACS server has been Added successfully']");
    private final By pacsServerEditedMessageLocator = By.xpath("//p [.='PACS server has been Updated successfully']");
    private final By pacsServerDeletedMessageLocator = By.xpath("//p [.='PACS server has been deleted successfully']");

    private final By nameIsRequiredMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' Name is required ']");
    private final By nameCannotContainWhiteSpacesOnlyMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' Name cannot contain white spaces only ']");

    private final By ipIsRequiredMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' IP address is required ']");
    private final By ipCannotContainWhiteSpacesMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' IP cannot contain white spaces ']");
    private final By invalidIPMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' Invalid IP address ']");

    private final By aeTitleIsRequiredMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' AE title is required ']");
    private final By aeTitleCannotContainWhiteSpacesMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' AE title cannot contain spaces ']");

    private final By portIsRequiredMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' Port no. is required ']");
    private final By portCannotContainWhiteSpacesMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' Port cannot contain white spaces ']");
    private final By invalidPortMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' Invalid Port ']");
    private final By portMustBeBetween1And65535MessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' Port must be between 1 and 65535 ']");
    private final By portMustNotBeLessThanOneMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' Port no. must not be less than one ']");

    private final By institutionIsRequiredMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' Institution is required ']");

    private final By pleaseSelectAtLeastOneLocationMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' Please select at least one Location ']");

    private final DriverFactory driver;

    public P06_PACSServerAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add Button")
    public P06_PACSServerAdminPage clickOnAddButton() {
        LogsUtils.info("Clicking on Add Button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter Name")
    public P06_PACSServerAdminPage enterName(String name) {
        LogsUtils.info("Entering Name:", name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Enter IP")
    public P06_PACSServerAdminPage enterIP(String ip) {
        LogsUtils.info("Entering IP:", ip);
        driver.elementUtils().sendDataToElement(ipTextFieldLocator, ip);
        return this;
    }

    @Step("Enter AE Title")
    public P06_PACSServerAdminPage enterAETitle(String aeTitle) {
        LogsUtils.info("Entering AE Title:", aeTitle);
        driver.elementUtils().sendDataToElement(aeTitleTextFieldLocator, aeTitle);
        return this;
    }

    @Step("Enter Port")
    public P06_PACSServerAdminPage enterPort(String port) {
        LogsUtils.info("Entering Port:", port);
        ClipboardUtils.copyToClipboard(port);
        driver.elementUtils().clickOnElement(portTextFieldLocator);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Enter Issuer of Patient ID")
    public P06_PACSServerAdminPage enterIssuerOfPatientId(String issuer) {
        LogsUtils.info("Entering Issuer of Patient ID:", issuer);
        driver.elementUtils().sendDataToElement(issuerOfPatientIdTextFieldLocator, issuer);
        return this;
    }

    @Step("Select Institution")
    public P06_PACSServerAdminPage selectInstitution(String institution) {
        LogsUtils.info("Selecting Institution:", institution);
        driver.elementUtils().clickOnElement(institutionDropdownLocator);
        By institutionOptionLocator = By.xpath("//li[.=' " + institution + " ']");
        driver.elementUtils().scrollToElement(institutionOptionLocator);
        driver.elementUtils().clickOnElement(institutionOptionLocator);
        return this;
    }

    @Step("Click on Institution Dropdown")
    public P06_PACSServerAdminPage clickOnInstitutionDropdown() {
        LogsUtils.info("Clicking on Institution Dropdown");
        driver.elementUtils().clickOnElement(institutionDropdownLocator);
        return this;
    }

    @Step("Select Location")
    public P06_PACSServerAdminPage selectLocation() {
        LogsUtils.info("Selecting Location");
        driver.elementUtils().clickOnElement(locationDropdownLocator);
        By locationOptionLocator = By.xpath("(//li[@role='option'])[1]");
        driver.elementUtils().clickOnElement(locationOptionLocator);
        return this;
    }

    @Step("Click On Location Dropdown")
    public P06_PACSServerAdminPage clickOnLocationDropdown() {
        LogsUtils.info("Clicking On Location Dropdown");
        driver.elementUtils().clickOnElement(locationDropdownLocator);
        return this;
    }

    @Step("Check Active Checkbox")
    public P06_PACSServerAdminPage checkOnActiveCheckbox() {
        LogsUtils.info("Check Active Checkbox");
        driver.elementUtils().checkCheckboxJS(activeCheckboxLocator);
        return this;
    }

    @Step("Uncheck Active Checkbox")
    public P06_PACSServerAdminPage uncheckOnActiveCheckbox() {
        LogsUtils.info("Uncheck Active Checkbox");
        driver.elementUtils().uncheckCheckboxJS(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Save Button")
    public P06_PACSServerAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save Button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Search for PACS Server by Name")
    public P06_PACSServerAdminPage searchForPACSServerByName(String name) {
        LogsUtils.info("Searching for PACS Server:", name);
        driver.elementUtils().sendDataToElement(nameSearchTextFieldLocator, name);
        return this;
    }

    @Step("Click on OK Button")
    public P06_PACSServerAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK Button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Click on Yes Button")
    public P06_PACSServerAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes Button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on Close Button")
    public P06_PACSServerAdminPage clickOnCloseButton() {
        LogsUtils.info("Clicking on Close Button");
        driver.elementUtils().clickOnElement(closeButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P06_PACSServerAdminPage clickOnEditButton(String pacsServerName) {
        LogsUtils.info("Clicking on Edit Button for PACS Server: " + pacsServerName);
        By editButtonLocator = By.xpath("//td[.='" + pacsServerName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P06_PACSServerAdminPage clickOnDeleteButton(String pacsServerName) {
        LogsUtils.info("Clicking on Delete Button for PACS Server: " + pacsServerName);
        By deleteButtonLocator = By.xpath("//td[.='" + pacsServerName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Assert PACS Server Added Message")
    public void assertPACSServerAddedMessage(String expectedMessage) {
        LogsUtils.info("Asserting PACS Server Added Message");
        String actualMessage = driver.elementUtils().getDataFromElement(pacsServerAddedMessageLocator);
        LogsUtils.info("Expected PACS Server Added Message:", expectedMessage);
        LogsUtils.info("Actual PACS Server Added Message:", actualMessage);
        SoftAssertUtils.softAssertEquals(actualMessage, expectedMessage, "Wrong PACS Server Added Message");
    }

    @Step("Assert PACS Server Edited Message")
    public void assertPACSServerEditedMessage(String expectedMessage) {
        LogsUtils.info("Asserting PACS Server Edited Message");
        String actualMessage = driver.elementUtils().getDataFromElement(pacsServerEditedMessageLocator);
        LogsUtils.info("Expected PACS Server Edited Message:", expectedMessage);
        LogsUtils.info("Actual PACS Server Edited Message:", actualMessage);
        SoftAssertUtils.softAssertEquals(actualMessage, expectedMessage, "Wrong PACS Server Edited Message");
    }

    @Step("Assert PACS Server Deleted Message")
    public void assertPACSServerDeletedMessage(String expectedMessage) {
        LogsUtils.info("Asserting PACS Server Deleted Message");
        String actualMessage = driver.elementUtils().getDataFromElement(pacsServerDeletedMessageLocator);
        LogsUtils.info("Expected PACS Server Deleted Message:", expectedMessage);
        LogsUtils.info("Actual PACS Server Deleted Message:", actualMessage);
        SoftAssertUtils.softAssertEquals(actualMessage, expectedMessage, "Wrong PACS Server Deleted Message");
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

    @Step("Assert Visibility of IP is Required Message")
    public void assertVisibilityOfIPIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of IP Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(ipIsRequiredMessageLocator),
                "IP Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of IP Cannot Contain White Spaces Message")
    public void assertVisibilityOfIPCannotContainWhiteSpacesMessage() {
        LogsUtils.info("Asserting Visibility Of IP Cannot Contain White Spaces Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(ipCannotContainWhiteSpacesMessageLocator),
                "IP Cannot Contain White Spaces Message is not Displayed");
    }

    @Step("Assert Visibility of Invalid IP Message")
    public void assertVisibilityOfInvalidIPMessage() {
        LogsUtils.info("Asserting Visibility Of Invalid IP Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(invalidIPMessageLocator),
                "Invalid IP Message is not Displayed");
    }

    @Step("Assert Visibility of AE Title is Required Message")
    public void assertVisibilityOfAETitleIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of AE Title Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(aeTitleIsRequiredMessageLocator),
                "AE Title Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of AE Title Cannot Contain White Spaces Message")
    public void assertVisibilityOfAETitleCannotContainWhiteSpacesMessage() {
        LogsUtils.info("Asserting Visibility Of AE Title Cannot Contain White Spaces Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(aeTitleCannotContainWhiteSpacesMessageLocator),
                "AE Title Cannot Contain White Spaces Message is not Displayed");
    }

    @Step("Assert Visibility of Port is Required Message")
    public void assertVisibilityOfPortIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of Port Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(portIsRequiredMessageLocator),
                "Port Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of Port Cannot Contain White Spaces Message")
    public void assertVisibilityOfPortCannotContainWhiteSpacesMessage() {
        LogsUtils.info("Asserting Visibility Of Port Cannot Contain White Spaces Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(portCannotContainWhiteSpacesMessageLocator),
                "Port Cannot Contain White Spaces Message is not Displayed");
    }

    @Step("Assert Visibility of Invalid Port Message")
    public void assertVisibilityOfInvalidPortMessage() {
        LogsUtils.info("Asserting Visibility Of Invalid Port Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(invalidPortMessageLocator),
                "Invalid Port Message is not Displayed");
    }

    @Step("Assert Visibility of Port Must Be Between 1 And 65535 Message")
    public void assertVisibilityOfPortMustBeBetween1And65535Message() {
        LogsUtils.info("Asserting Visibility Of Port Must Be Between 1 And 65535 Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(portMustBeBetween1And65535MessageLocator),
                "Port Must Be Between 1 And 65535 Message is not Displayed");
    }

    @Step("Assert Visibility of Port Must Not Be Less Than One Message")
    public void assertVisibilityOfPortMustNotBeLessThanOneMessage() {
        LogsUtils.info("Asserting Visibility Of Port Must Not Be Less Than One Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(portMustNotBeLessThanOneMessageLocator),
                "Port Must Not Be Less Than One Message is not Displayed");
    }

    @Step("Assert Visibility of Institution is Required Message")
    public void assertVisibilityOfInstitutionIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of Institution Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(institutionIsRequiredMessageLocator),
                "Institution Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of Please Select At Least One Location Message")
    public void assertVisibilityOfPleaseSelectAtLeastOneLocationMessage() {
        LogsUtils.info("Asserting Visibility Of Please Select At Least One Location Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(pleaseSelectAtLeastOneLocationMessageLocator),
                "Please Select At Least One Location Message is not Displayed");
    }
}
