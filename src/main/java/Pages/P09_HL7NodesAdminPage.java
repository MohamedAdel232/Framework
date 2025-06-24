package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P09_HL7NodesAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"New Hl7\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By ipTextFieldLocator = By.cssSelector("[formcontrolname=\"ip\"]");
    private final By portTextFieldLocator = By.cssSelector("[formcontrolname=\"port\"]");
    private final By institutionDropdownLocator = By.id("Institution");
    private final By locationDropdownLocator = By.cssSelector("[formcontrolname=\"locations\"]");
    private final By descriptionTextFieldLocator = By.cssSelector("[formcontrolname=\"description\"]");
    private final By ignoreORMCheckboxLocator = By.id("ignoreORM");
    private final By ignoreORUCheckboxLocator = By.id("ignoreORU");
    private final By ignoreADTCheckboxLocator = By.id("ignoreADT");
    private final By ignorePreliminaryORUCheckboxLocator = By.id("ignorePreliminaryORU");
    private final By activeCheckboxLocator = By.id("status");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By nameSearchTextFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By okButtonLocator = By.xpath("//button [.='OK']");
    private final By yesButtonLocator = By.xpath("//button[.='Yes']");
    private final By closeButtonLocator = By.cssSelector("[title=\"Close\"]");

    private final By hl7NodeAddedMessageLocator = By.xpath("//p [.='HL7 node has been added successfully.']");
    private final By hl7NodeEditedMessageLocator = By.xpath("//p [.='Updated successfully']");
    private final By hl7NodeDeletedMessageLocator = By.xpath("//p [.='Deleted successfully']");

    private final By nameIsRequiredMessageLocator = By.xpath("//div [@class='text-danger'][.=' Name is required ']");
    private final By nameCannotContainWhiteSpacesOnlyMessageLocator = By.xpath("//div [@class='text-danger'][.=' Name cannot contain white spaces only ']");

    private final By ipIsRequiredMessageLocator = By.xpath("//div [@class='text-danger'][.=' IP address is required ']");
    private final By ipCannotContainWhiteSpacesMessageLocator = By.xpath("//div [@class='text-danger'][.=' IP cannot contain white spaces ']");
    private final By invalidIPMessageLocator = By.xpath("//div [@class='text-danger'][.=' Invalid IP address ']");

    private final By portIsRequiredMessageLocator = By.xpath("//div [@class='text-danger'][.=' Port no. is required ']");
    private final By portCannotContainWhiteSpacesMessageLocator = By.xpath("//div [@class='text-danger'][.=' Port cannot contain white spaces ']");
    private final By invalidPortMessageLocator = By.xpath("//div [@class='text-danger'][.=' Invalid Port ']");
    private final By portMustBeBetween1And65535MessageLocator = By.xpath("//div [@class='text-danger'][.=' Port must be between 1 and 65535 ']");

    private final By institutionIsRequiredMessageLocator = By.xpath("//div [@class='text-danger'][.='Institution is required']");

    private final By locationIsRequiredMessageLocator = By.xpath("//div [@class='text-danger'][.=' Please select at least one Location ']");

    private final DriverFactory driver;

    public P09_HL7NodesAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add Button")
    public P09_HL7NodesAdminPage clickOnAddButton() {
        LogsUtils.info("Clicking on Add Button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter Name")
    public P09_HL7NodesAdminPage enterName(String name) {
        LogsUtils.info("Entering Name:", name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Enter IP")
    public P09_HL7NodesAdminPage enterIP(String ip) {
        LogsUtils.info("Entering IP:", ip);
        driver.elementUtils().sendDataToElement(ipTextFieldLocator, ip);
        return this;
    }

    @Step("Enter Port")
    public P09_HL7NodesAdminPage enterPort(String port) {
        LogsUtils.info("Entering Port:", port);
        driver.elementUtils().sendDataToElement(portTextFieldLocator, port);
        return this;
    }

    @Step("Select Institution")
    public P09_HL7NodesAdminPage selectInstitution(String institution) {
        LogsUtils.info("Selecting Institution:", institution);
        driver.elementUtils().clickOnElement(institutionDropdownLocator);
        By institutionOptionLocator = By.xpath("//li[.=' " + institution + " ']");
        driver.elementUtils().clickOnElement(institutionOptionLocator);
        return this;
    }

    @Step("Click on Institution Dropdown")
    public P09_HL7NodesAdminPage clickOnInstitutionDropdown() {
        LogsUtils.info("Clicking on Institution Dropdown");
        driver.elementUtils().clickOnElement(institutionDropdownLocator);
        return this;
    }

    @Step("Select Location")
    public P09_HL7NodesAdminPage selectLocation() {
        LogsUtils.info("Selecting Location");
        driver.elementUtils().clickOnElement(locationDropdownLocator);
        By locationOptionLocator = By.xpath("(//li[@role='option'])[1]");
        driver.elementUtils().clickOnElement(locationOptionLocator);
        return this;
    }

    @Step("Click On Location Dropdown")
    public P09_HL7NodesAdminPage clickOnLocationDropdown() {
        LogsUtils.info("Clicking On Location Dropdown");
        driver.elementUtils().clickOnElement(locationDropdownLocator);
        return this;
    }

    @Step("Enter Description")
    public P09_HL7NodesAdminPage enterDescription(String description) {
        LogsUtils.info("Entering Description:", description);
        driver.elementUtils().sendDataToElement(descriptionTextFieldLocator, description);
        return this;
    }

    @Step("Check Ignore ORM Checkbox")
    public P09_HL7NodesAdminPage checkIgnoreORMCheckbox() {
        LogsUtils.info("Check Ignore ORM Checkbox");
        driver.elementUtils().checkCheckboxJS(ignoreORMCheckboxLocator);
        return this;
    }

    @Step("Uncheck Ignore ORM Checkbox")
    public P09_HL7NodesAdminPage uncheckIgnoreORMCheckbox() {
        LogsUtils.info("Uncheck Ignore ORM Checkbox");
        driver.elementUtils().uncheckCheckboxJS(ignoreORMCheckboxLocator);
        return this;
    }

    @Step("Check Ignore ORU Checkbox")
    public P09_HL7NodesAdminPage checkIgnoreORUCheckbox() {
        LogsUtils.info("Check Ignore ORU Checkbox");
        driver.elementUtils().checkCheckboxJS(ignoreORUCheckboxLocator);
        return this;
    }

    @Step("Uncheck Ignore ORU Checkbox")
    public P09_HL7NodesAdminPage uncheckIgnoreORUCheckbox() {
        LogsUtils.info("Uncheck Ignore ORU Checkbox");
        driver.elementUtils().uncheckCheckboxJS(ignoreORUCheckboxLocator);
        return this;
    }

    @Step("Check Ignore ADT Checkbox")
    public P09_HL7NodesAdminPage checkIgnoreADTCheckbox() {
        LogsUtils.info("Check Ignore ADT Checkbox");
        driver.elementUtils().checkCheckboxJS(ignoreADTCheckboxLocator);
        return this;
    }

    @Step("Uncheck Ignore ADT Checkbox")
    public P09_HL7NodesAdminPage uncheckIgnoreADTCheckbox() {
        LogsUtils.info("Uncheck Ignore ADT Checkbox");
        driver.elementUtils().uncheckCheckboxJS(ignoreADTCheckboxLocator);
        return this;
    }

    @Step("Check Ignore Preliminary ORU Checkbox")
    public P09_HL7NodesAdminPage checkIgnorePreliminaryORUCheckbox() {
        LogsUtils.info("Check Ignore Preliminary ORU Checkbox");
        driver.elementUtils().checkCheckboxJS(ignorePreliminaryORUCheckboxLocator);
        return this;
    }

    @Step("Uncheck Ignore Preliminary ORU Checkbox")
    public P09_HL7NodesAdminPage uncheckIgnorePreliminaryORUCheckbox() {
        LogsUtils.info("Uncheck Ignore Preliminary ORU Checkbox");
        driver.elementUtils().uncheckCheckboxJS(ignorePreliminaryORUCheckboxLocator);
        return this;
    }

    @Step("Check Active Checkbox")
    public P09_HL7NodesAdminPage checkOnActiveCheckbox() {
        LogsUtils.info("Check Active Checkbox");
        driver.elementUtils().checkCheckboxJS(activeCheckboxLocator);
        return this;
    }

    @Step("Uncheck Active Checkbox")
    public P09_HL7NodesAdminPage uncheckOnActiveCheckbox() {
        LogsUtils.info("Uncheck Active Checkbox");
        driver.elementUtils().uncheckCheckboxJS(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Save Button")
    public P09_HL7NodesAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save Button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Search for HL7 Node by Name")
    public P09_HL7NodesAdminPage searchForHL7NodeByName(String name) {
        LogsUtils.info("Searching for HL7 Node:", name);
        driver.elementUtils().sendDataToElement(nameSearchTextFieldLocator, name);
        return this;
    }

    @Step("Click on OK Button")
    public P09_HL7NodesAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK Button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Click on Yes Button")
    public P09_HL7NodesAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes Button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on Close Button")
    public P09_HL7NodesAdminPage clickOnCloseButton() {
        LogsUtils.info("Clicking on Close Button");
        driver.elementUtils().clickOnElement(closeButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P09_HL7NodesAdminPage clickOnEditButton(String nodeName) {
        LogsUtils.info("Clicking on Edit Button for HL7 Node: " + nodeName);
        By editButtonLocator = By.xpath("//td[.='" + nodeName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P09_HL7NodesAdminPage clickOnDeleteButton(String nodeName) {
        LogsUtils.info("Clicking on Delete Button for HL7 Node: " + nodeName);
        By deleteButtonLocator = By.xpath("//td[.='" + nodeName + "']/following-sibling::td//a[@title='Remove']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Assert HL7 Node Added Message")
    public void assertHL7NodeAddedMessage(String expectedMessage) {
        LogsUtils.info("Asserting HL7 Node Added Message");
        String actualMessage = driver.elementUtils().getDataFromElement(hl7NodeAddedMessageLocator);
        LogsUtils.info("Expected HL7 Node Added Message:", expectedMessage);
        LogsUtils.info("Actual HL7 Node Added Message:", actualMessage);
        SoftAssertUtils.softAssertEquals(actualMessage, expectedMessage, "Wrong HL7 Node Added Message");
    }

    @Step("Assert HL7 Node Edited Message")
    public void assertHL7NodeEditedMessage(String expectedMessage) {
        LogsUtils.info("Asserting HL7 Node Edited Message");
        String actualMessage = driver.elementUtils().getDataFromElement(hl7NodeEditedMessageLocator);
        LogsUtils.info("Expected HL7 Node Edited Message:", expectedMessage);
        LogsUtils.info("Actual HL7 Node Edited Message:", actualMessage);
        SoftAssertUtils.softAssertEquals(actualMessage, expectedMessage, "Wrong HL7 Node Edited Message");
    }

    @Step("Assert HL7 Node Deleted Message")
    public void assertHL7NodeDeletedMessage(String expectedMessage) {
        LogsUtils.info("Asserting HL7 Node Deleted Message");
        String actualMessage = driver.elementUtils().getDataFromElement(hl7NodeDeletedMessageLocator);
        LogsUtils.info("Expected HL7 Node Deleted Message:", expectedMessage);
        LogsUtils.info("Actual HL7 Node Deleted Message:", actualMessage);
        SoftAssertUtils.softAssertEquals(actualMessage, expectedMessage, "Wrong HL7 Node Deleted Message");
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

    @Step("Assert Visibility of Port Must Be Between 1 and 65535 Message")
    public void assertVisibilityOfPortMustBeBetween1And65535Message() {
        LogsUtils.info("Asserting Visibility Of Port Must Be Between 1 and 65535 Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(portMustBeBetween1And65535MessageLocator),
                "Port Must Be Between 1 and 65535 Message is not Displayed");
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