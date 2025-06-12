package Pages;

import Factories.DriverFactory;
import Utilities.ClipboardUtils;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P09_HL7NodesAdminPage {
    private final By addNewHL7NodeButtonLocator = By.cssSelector("[title=\"Add new HL7 node\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By ipAddressTextFieldLocator = By.cssSelector("[formcontrolname=\"ip\"]");
    private final By portNoTextFieldLocator = By.cssSelector("[formcontrolname=\"port\"]");
    private final By descriptionTextFieldLocator = By.cssSelector("[formcontrolname=\"description\"]");
    private final By siteDropdownLocator = By.cssSelector("[formcontrolname=\"sites\"]");
    private final By activeCheckboxLocator = By.cssSelector("[formcontrolname=\"status\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By nameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By yesButtonLocator = By.xpath("//button[.=\"Yes\"]");
    private final By okButtonLocator = By.xpath("//button[.=\"OK\"]");
    private final By closeButtonLocator = By.cssSelector("[title=\"Close\"]");

    private final By hl7NodeAddedMessageLocator = By.xpath("//p [.=\"HL7 node has been added successfully\"]");
    private final By hl7NodeEditedMessageLocator = By.xpath("//p [.=\"HL7 node has been updated successfully\"]");

    private final By emptyNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name is required \"]");
    private final By emptyIpAddressMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" IP is required \"]");
    private final By emptyPortNoMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Port no. is required \"]");
    private final By emptySiteMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Please select at least one site \"]");

    private final By spacesOnlyNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name can't contain only white space \"]");
    private final By spacesOnlyIpAddressMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" IP cannot contain spaces only \"]");

    private final By invalidIPAddressMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Invalid IP address \"]");
    private final By invalidPortNoMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Port no. should be greater than 0 \"]");

    private final DriverFactory driver;

    public P09_HL7NodesAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add New HL7 Node Button")
    public P09_HL7NodesAdminPage clickOnAddNewHL7NodeButton() {
        LogsUtils.info("Clicking on Add New HL7 Node Button");
        driver.elementUtils().clickOnElement(addNewHL7NodeButtonLocator);
        return this;
    }

    @Step("Enter Name: {name}")
    public P09_HL7NodesAdminPage enterHL7NodeName(String name) {
        LogsUtils.info("Entering Name: " + name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Enter IP Address: {ipAddress}")
    public P09_HL7NodesAdminPage enterIpAddress(String ipAddress) {
        LogsUtils.info("Entering IP Address: " + ipAddress);
        driver.elementUtils().sendDataToElement(ipAddressTextFieldLocator, ipAddress);
        return this;
    }

    @Step("Enter port")
    public P09_HL7NodesAdminPage enterPortNo(String port) {
        LogsUtils.info("Entering port: " + port);
        driver.elementUtils().clickOnElement(portNoTextFieldLocator);
        ClipboardUtils.copyToClipboard(port);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Enter Description: {description}")
    public P09_HL7NodesAdminPage enterDescription(String description) {
        LogsUtils.info("Entering Description: " + description);
        driver.elementUtils().sendDataToElement(descriptionTextFieldLocator, description);
        return this;
    }

    @Step("Select Site")
    public P09_HL7NodesAdminPage selectSite() {
        LogsUtils.info("Selecting Site");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Click on Site Dropdown")
    public P09_HL7NodesAdminPage clickOnSiteDropdown() {
        LogsUtils.info("Clicking on Site Dropdown");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        return this;
    }

    @Step("Check Active Checkbox")
    public P09_HL7NodesAdminPage checkActiveCheckbox() {
        LogsUtils.info("Checking Active Checkbox");
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Save Button")
    public P09_HL7NodesAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save Button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Search HL7 Node by Name: {name}")
    public P09_HL7NodesAdminPage searchHL7NodeByName(String name) {
        LogsUtils.info("Searching HL7 Node by Name: " + name);
        driver.elementUtils().sendDataToElement(nameSearchFieldLocator, name);
        return this;
    }

    @Step("Click on Edit button")
    public P09_HL7NodesAdminPage clickOnEditButton(String name) {
        LogsUtils.info("Clicking on Edit button for HL7 Node: " + name);
        By editButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P09_HL7NodesAdminPage clickOnDeleteButton(String name) {
        LogsUtils.info("Clicking on Delete button for HL7 Node: " + name);
        By deleteButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes Button")
    public P09_HL7NodesAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes Button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on OK Button")
    public P09_HL7NodesAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK Button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Click on Close Button")
    public P09_HL7NodesAdminPage clickOnCloseButton() {
        LogsUtils.info("Clicking on Close Button");
        driver.elementUtils().clickOnElement(closeButtonLocator);
        return this;
    }

    @Step("Assert visibility of HL7 Node Added Alert")
    public void assertVisibilityOfHL7NodeAddedAlert() {
        LogsUtils.info("Asserting visibility of HL7 Node Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(hl7NodeAddedMessageLocator),
                "HL7 node added alert not visible"
        );
    }

    @Step("Assert visibility of HL7 Node Edited Alert")
    public void assertVisibilityOfHL7NodeEditedAlert() {
        LogsUtils.info("Asserting visibility of HL7 Node Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(hl7NodeEditedMessageLocator),
                "HL7 node edited alert not visible"
        );
    }

    @Step("Assert visibility of HL7 Node Deleted Alert")
    public void assertVisibilityOfHL7NodeDeletedAlert(String name) {
        LogsUtils.info("Asserting visibility of HL7 Node Deleted Alert");
        By hl7NodeDeletedMessageLocator = By.xpath("//p [.=\"" + name + "\" node has been deleted successfully\"]");

        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(hl7NodeDeletedMessageLocator),
                "HL7 node deleted alert not visible"
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

    @Step("Assert visibility of Empty IP Address Message")
    public void assertVisibilityOfEmptyIpAddressMessage() {
        LogsUtils.info("Asserting visibility of Empty IP Address Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyIpAddressMessageLocator),
                "Empty IP address message not visible"
        );
    }

    @Step("Assert visibility of Empty Port No Message")
    public void assertVisibilityOfEmptyPortNoMessage() {
        LogsUtils.info("Asserting visibility of Empty Port No Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyPortNoMessageLocator),
                "Empty port no message not visible"
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

    @Step("Assert visibility of Spaces Only IP Address Message")
    public void assertVisibilityOfSpacesOnlyIpAddressMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only IP Address Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyIpAddressMessageLocator),
                "Spaces only IP address message not visible"
        );
    }

    @Step("Assert visibility of Invalid IP Address Message")
    public void assertVisibilityOfInvalidIPAddressMessage() {
        LogsUtils.info("Asserting visibility of Invalid IP Address Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(invalidIPAddressMessageLocator),
                "Invalid IP address message not visible"
        );
    }

    @Step("Assert visibility of Invalid Port No Message")
    public void assertVisibilityOfInvalidPortNoMessage() {
        LogsUtils.info("Asserting visibility of Invalid Port No Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(invalidPortNoMessageLocator),
                "Invalid port no message not visible"
        );
    }
} 