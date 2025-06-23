package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P07_DICOMDestinationsAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"New DICOM Destination\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By ipTextFieldLocator = By.cssSelector("[formcontrolname=\"ipAddress\"]");
    private final By aeTitleTextFieldLocator = By.cssSelector("[formcontrolname=\"aeTitle\"]");
    private final By portTextFieldLocator = By.cssSelector("[formcontrolname=\"portNo\"]");
    private final By aiCheckboxLocator = By.id("ai");
    private final By activeCheckboxLocator = By.id("active");
    private final By saveButtonLocator = By.xpath("//span[.=\" Save \"]");
    private final By nameSearchTextFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By okButtonLocator = By.xpath("//button [.=\"OK\"]");
    private final By yesButtonLocator = By.xpath("//button[.='Yes']");
    private final By closeButtonLocator = By.cssSelector("[title=\"Close\"]");

    private final By dicomDestinationAddedMessageLocator = By.xpath("//p [.='Added successfully']");
    private final By dicomDestinationEditedMessageLocator = By.xpath("//p [.='Updated successfully']");
    private final By dicomDestinationDeletedMessageLocator = By.xpath("//p [.='The selected DICOM destination has been deleted successfully']");

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

    private final DriverFactory driver;

    public P07_DICOMDestinationsAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add Button")
    public P07_DICOMDestinationsAdminPage clickOnAddButton() {
        LogsUtils.info("Clicking on Add Button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter Name")
    public P07_DICOMDestinationsAdminPage enterName(String name) {
        LogsUtils.info("Entering Name:", name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Enter IP")
    public P07_DICOMDestinationsAdminPage enterIP(String ip) {
        LogsUtils.info("Entering IP:", ip);
        driver.elementUtils().sendDataToElement(ipTextFieldLocator, ip);
        return this;
    }

    @Step("Enter AE Title")
    public P07_DICOMDestinationsAdminPage enterAETitle(String aeTitle) {
        LogsUtils.info("Entering AE Title:", aeTitle);
        driver.elementUtils().sendDataToElement(aeTitleTextFieldLocator, aeTitle);
        return this;
    }

    @Step("Enter Port")
    public P07_DICOMDestinationsAdminPage enterPort(String port) {
        LogsUtils.info("Entering Port:", port);
        driver.elementUtils().sendDataToElement(portTextFieldLocator, port);
        return this;
    }

    @Step("Check AI Checkbox")
    public P07_DICOMDestinationsAdminPage checkAICheckbox() {
        LogsUtils.info("Check AI Checkbox");
        driver.elementUtils().checkCheckboxJS(aiCheckboxLocator);
        return this;
    }

    @Step("Uncheck AI Checkbox")
    public P07_DICOMDestinationsAdminPage uncheckAICheckbox() {
        LogsUtils.info("Uncheck AI Checkbox");
        driver.elementUtils().uncheckCheckboxJS(aiCheckboxLocator);
        return this;
    }

    @Step("Check Active Checkbox")
    public P07_DICOMDestinationsAdminPage checkOnActiveCheckbox() {
        LogsUtils.info("Check Active Checkbox");
        driver.elementUtils().checkCheckboxJS(activeCheckboxLocator);
        return this;
    }

    @Step("Uncheck Active Checkbox")
    public P07_DICOMDestinationsAdminPage uncheckOnActiveCheckbox() {
        LogsUtils.info("Uncheck Active Checkbox");
        driver.elementUtils().uncheckCheckboxJS(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Save Button")
    public P07_DICOMDestinationsAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save Button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Search for DICOM Destination by Name")
    public P07_DICOMDestinationsAdminPage searchForDICOMDestinationByName(String name) {
        LogsUtils.info("Searching for DICOM Destination:", name);
        driver.elementUtils().sendDataToElement(nameSearchTextFieldLocator, name);
        return this;
    }

    @Step("Click on OK Button")
    public P07_DICOMDestinationsAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK Button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Click on Yes Button")
    public P07_DICOMDestinationsAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes Button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on Close Button")
    public P07_DICOMDestinationsAdminPage clickOnCloseButton() {
        LogsUtils.info("Clicking on Close Button");
        driver.elementUtils().clickOnElement(closeButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P07_DICOMDestinationsAdminPage clickOnEditButton(String destinationName) {
        LogsUtils.info("Clicking on Edit Button for DICOM Destination: " + destinationName);
        By editButtonLocator = By.xpath("//td[.='" + destinationName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P07_DICOMDestinationsAdminPage clickOnDeleteButton(String destinationName) {
        LogsUtils.info("Clicking on Delete Button for DICOM Destination: " + destinationName);
        By deleteButtonLocator = By.xpath("//td[.='" + destinationName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Assert DICOM Destination Added Message")
    public void assertDICOMDestinationAddedMessage(String expectedMessage) {
        LogsUtils.info("Asserting DICOM Destination Added Message");
        String actualMessage = driver.elementUtils().getDataFromElement(dicomDestinationAddedMessageLocator);
        LogsUtils.info("Expected DICOM Destination Added Message:", expectedMessage);
        LogsUtils.info("Actual DICOM Destination Added Message:", actualMessage);
        SoftAssertUtils.softAssertEquals(actualMessage, expectedMessage, "Wrong DICOM Destination Added Message");
    }

    @Step("Assert DICOM Destination Edited Message")
    public void assertDICOMDestinationEditedMessage(String expectedMessage) {
        LogsUtils.info("Asserting DICOM Destination Edited Message");
        String actualMessage = driver.elementUtils().getDataFromElement(dicomDestinationEditedMessageLocator);
        LogsUtils.info("Expected DICOM Destination Edited Message:", expectedMessage);
        LogsUtils.info("Actual DICOM Destination Edited Message:", actualMessage);
        SoftAssertUtils.softAssertEquals(actualMessage, expectedMessage, "Wrong DICOM Destination Edited Message");
    }

    @Step("Assert DICOM Destination Deleted Message")
    public void assertDICOMDestinationDeletedMessage(String expectedMessage) {
        LogsUtils.info("Asserting DICOM Destination Deleted Message");
        String actualMessage = driver.elementUtils().getDataFromElement(dicomDestinationDeletedMessageLocator);
        LogsUtils.info("Expected DICOM Destination Deleted Message:", expectedMessage);
        LogsUtils.info("Actual DICOM Destination Deleted Message:", actualMessage);
        SoftAssertUtils.softAssertEquals(actualMessage, expectedMessage, "Wrong DICOM Destination Deleted Message");
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
} 