package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P12_DestinationsAdminPage {
    private final By addNewDestinationButtonLocator = By.cssSelector("[title=\"Add new destination\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By typeDropdownLocator = By.cssSelector("[formcontrolname=\"type\"]");
    private final By modeDropdownLocator = By.cssSelector("[formcontrolname=\"mode\"]");
    private final By siteDropdownLocator = By.cssSelector("[formcontrolname=\"sites\"]");
    private final By ipAddressTextFieldLocator = By.cssSelector("[formcontrolname=\"ipAddress\"]");
    private final By portNoTextFieldLocator = By.cssSelector("[formcontrolname=\"portNo\"]");
    private final By activeCheckboxLocator = By.cssSelector("[title=\"Active\"]");
    private final By aeTitleTextFieldLocator = By.cssSelector("[formcontrolname=\"aeTitle\"]");
    private final By hl7OutboundProfileDropdownLocator = By.cssSelector("[formcontrolname=\"hl7OutboundProfileId\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By okButtonLocator = By.xpath("//button[.=\"OK\"]");
    private final By yesButtonLocator = By.xpath("//button[.=\"Yes\"]");
    private final By closeButtonLocator = By.cssSelector("[title=\"Close\"]");
    private final By nameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By destinationEditedMessageLocator = By.xpath("//p [.=\"Destination has been updated successfully\"]");
    private final By destinationDeletedMessageLocator = By.xpath("//p [.=\"Selected destination has been deleted successfully\"]");

    private final By emptyNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name is required \"]");
    private final By emptyTypeMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Type is required \"]");
    private final By emptyModeMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Mode is required \"]");
    private final By emptySiteMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Select at least one site \"]");
    private final By emptyIPAddressMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" IP address is required \"]");
    private final By emptyPortNoMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Port no. is required \"]");
    private final By emptyHL7OutboundProfileMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" HL7 outbound profile is required \"]");
    private final By emptyAETitleMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" AE title is required \"]");

    private final By spacesOnlyNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name cannot contain spaces only \"]");
    private final By spacesOnlyAETitleMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" AE title cannot contain white spaces \"]");

    private final By invalidIPAddressMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Invalid IP address \"]");
    private final By invalidPortNoMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Invalid port no. \"]");

    private final By lessThanZeroPortNoMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Port no. should be more than 0 \"]");

    private final DriverFactory driver;

    public P12_DestinationsAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add New Destination Button")
    public P12_DestinationsAdminPage clickOnAddNewDestinationButon() {
        LogsUtils.info("Clicking on Add New Destination Button");
        driver.elementUtils().clickOnElement(addNewDestinationButtonLocator);
        return this;
    }

    @Step("Enter Name: {name}")
    public P12_DestinationsAdminPage enterName(String name) {
        LogsUtils.info("Entering Name: " + name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Select Type")
    public P12_DestinationsAdminPage selectType(String type) {
        LogsUtils.info("Selecting Type");
        driver.elementUtils().clickOnElement(typeDropdownLocator);
        By typeOptionLocator = By.xpath("//li [.=\" " + type + " \"]");
        driver.elementUtils().clickOnElement(typeOptionLocator);
        return this;
    }

    @Step("Click on Type Dropdown")
    public P12_DestinationsAdminPage clickOnTypeDropdown() {
        LogsUtils.info("Clicking on Type Dropdown");
        driver.elementUtils().clickOnElement(typeDropdownLocator);
        return this;
    }

    @Step("Select Mode")
    public P12_DestinationsAdminPage selectMode(String mode) {
        LogsUtils.info("Selecting Mode");
        driver.elementUtils().clickOnElement(modeDropdownLocator);
        By modeOptionLocator = By.xpath("//li [.=\" " + mode + " \"]");
        driver.elementUtils().clickOnElement(modeOptionLocator);
        return this;
    }

    @Step("Click on Mode Dropdown")
    public P12_DestinationsAdminPage clickOnModeDropdown() {
        LogsUtils.info("Clicking on Mode Dropdown");
        driver.elementUtils().clickOnElement(modeDropdownLocator);
        return this;
    }

    @Step("Select Site")
    public P12_DestinationsAdminPage selectSite() {
        LogsUtils.info("Selecting Site");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Click on Site Dropdown")
    public P12_DestinationsAdminPage clickOnSiteDropdown() {
        LogsUtils.info("Clicking on Site Dropdown");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        return this;
    }

    @Step("Enter IP Address: {ipAddress}")
    public P12_DestinationsAdminPage enterIPAddress(String ipAddress) {
        LogsUtils.info("Entering IP Address: " + ipAddress);
        driver.elementUtils().sendDataToElement(ipAddressTextFieldLocator, ipAddress);
        return this;
    }

    @Step("Enter Port NO.: {portNo}")
    public P12_DestinationsAdminPage enterPortNo(String portNo) {
        LogsUtils.info("Entering Port NO.: " + portNo);
        driver.elementUtils().sendDataToElement(portNoTextFieldLocator, portNo);
        return this;
    }

    @Step("Select HL7 Outbound Profile")
    public P12_DestinationsAdminPage selectHL7OutboundProfile() {
        LogsUtils.info("Selecting HL7 Outbound Profile");
        driver.elementUtils().clickOnElement(hl7OutboundProfileDropdownLocator);
        By hl7OutboundProfileOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(hl7OutboundProfileOptionLocator);
        return this;
    }

    @Step("Click on HL7 Outbound Profile Dropdown")
    public P12_DestinationsAdminPage clickOnHL7OutboundProfileDropdown() {
        LogsUtils.info("Clicking on HL7 Outbound Profile Dropdown");
        driver.elementUtils().clickOnElement(hl7OutboundProfileDropdownLocator);
        return this;
    }

    @Step("Enter AE Title: {aeTitle}")
    public P12_DestinationsAdminPage enterAETitle(String aeTitle) {
        LogsUtils.info("Entering AE Title: " + aeTitle);
        driver.elementUtils().sendDataToElement(aeTitleTextFieldLocator, aeTitle);
        return this;
    }

    @Step("Check Active checkbox")
    public P12_DestinationsAdminPage checkActiveCheckbox() {
        LogsUtils.info("Checking Active checkbox");
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Save Button")
    public P12_DestinationsAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save Button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P12_DestinationsAdminPage clickOnEditButton(String name) {
        LogsUtils.info("Clicking on Edit button for Destination: " + name);
        By editButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P12_DestinationsAdminPage clickOnDeleteButton(String name) {
        LogsUtils.info("Clicking on Delete button for Destination: " + name);
        By deleteButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes Button")
    public P12_DestinationsAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes Button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on OK Button")
    public P12_DestinationsAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK Button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Click on Close Button")
    public P12_DestinationsAdminPage clickOnCloseButton() {
        LogsUtils.info("Clicking on Close Button");
        driver.elementUtils().clickOnElement(closeButtonLocator);
        return this;
    }

    @Step("Search Destination by Name: {name}")
    public P12_DestinationsAdminPage searchDestinationByName(String name) {
        LogsUtils.info("Searching Destination by Name: " + name);
        driver.elementUtils().sendDataToElement(nameSearchFieldLocator, name);
        return this;
    }

    @Step("Assert visibility of Destination Edited Alert")
    public void assertVisibilityOfDestinationEditedAlert() {
        LogsUtils.info("Asserting visibility of Destination Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(destinationEditedMessageLocator),
                "Destination edited alert not visible"
        );
    }

    @Step("Assert visibility of Destination Deleted Alert")
    public void assertVisibilityOfDestinationDeletedAlert() {
        LogsUtils.info("Asserting visibility of Destination Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(destinationDeletedMessageLocator),
                "Destination deleted alert not visible"
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

    @Step("Assert visibility of Empty Type Message")
    public void assertVisibilityOfEmptyTypeMessage() {
        LogsUtils.info("Asserting visibility of Empty Type Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyTypeMessageLocator),
                "Empty type message not visible"
        );
    }

    @Step("Assert visibility of Empty Mode Message")
    public void assertVisibilityOfEmptyModeMessage() {
        LogsUtils.info("Asserting visibility of Empty Mode Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyModeMessageLocator),
                "Empty mode message not visible"
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

    @Step("Assert visibility of Empty IP Address Message")
    public void assertVisibilityOfEmptyIPAddressMessage() {
        LogsUtils.info("Asserting visibility of Empty IP Address Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyIPAddressMessageLocator),
                "Empty IP Address message not visible"
        );
    }

    @Step("Assert visibility of Empty Port No. Message")
    public void assertVisibilityOfEmptyPortNoMessage() {
        LogsUtils.info("Asserting visibility of Empty Port No. Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyPortNoMessageLocator),
                "Empty Port No. message not visible"
        );
    }

    @Step("Assert visibility of Empty HL7 Outbound Profile Message")
    public void assertVisibilityOfEmptyHL7OutboundProfileMessage() {
        LogsUtils.info("Asserting visibility of Empty HL7 Outbound Profile Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyHL7OutboundProfileMessageLocator),
                "Empty HL7 Outbound Profile message not visible"
        );
    }

    @Step("Assert visibility of Empty AE Title Message")
    public void assertVisibilityOfEmptyAETitleMessage() {
        LogsUtils.info("Asserting visibility of Empty AE Title Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyAETitleMessageLocator),
                "Empty AE Title message not visible"
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

    @Step("Assert visibility of Spaces Only AE Title Message")
    public void assertVisibilityOfSpacesOnlyAETitleMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only AE Title Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyAETitleMessageLocator),
                "Spaces only AE Title message not visible"
        );
    }

    @Step("Assert visibility of Invalid IP Address Message")
    public void assertVisibilityOfInvalidIPAddressMessage() {
        LogsUtils.info("Asserting visibility of Invalid IP Address Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(invalidIPAddressMessageLocator),
                "Invalid IP Address message not visible"
        );
    }

    @Step("Assert visibility of Invalid Port No. Message")
    public void assertVisibilityOfInvalidPortNoMessage() {
        LogsUtils.info("Asserting visibility of Invalid Port No. Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(invalidPortNoMessageLocator),
                "Invalid Port No. message not visible"
        );
    }

    @Step("Assert visibility of less Than Zero Port No Message")
    public void assertVisibilityOfLessThanZeroPortNoMessage() {
        LogsUtils.info("Asserting visibility of less Than Zero Port No Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(lessThanZeroPortNoMessageLocator),
                "Less Than Zero Port No message not visible"
        );
    }
}
