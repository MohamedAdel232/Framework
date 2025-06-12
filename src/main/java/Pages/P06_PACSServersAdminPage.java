package Pages;

import Factories.DriverFactory;
import Utilities.ClipboardUtils;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P06_PACSServersAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"New PACS Server\"]");
    private final By nameFieldLocator = By.cssSelector("[formcontrolname='name']");
    private final By ipAddressFieldLocator = By.cssSelector("[formcontrolname='ip']");
    private final By aeTitleFieldLocator = By.cssSelector("[formcontrolname='aeTitle']");
    private final By portFieldLocator = By.cssSelector("[formcontrolname=\"port\"]");
    private final By issuerOfPatientIdFieldLocator = By.cssSelector("[formcontrolname=\"patientIDIssuer\"]");
    private final By siteDropdownLocator = By.cssSelector("[formcontrolname=\"sites\"]");
    private final By activeCheckboxLocator = By.cssSelector("[title=\"Active PACS Server\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By okButtonLocator = By.xpath("//button[.=\"OK\"]");
    private final By yesButtonLocator = By.xpath("//button [.=\"Yes\"]");
    private final By cancelButtonLocator = By.cssSelector("[title=\"Close\"]");
    private final By pacsServerNameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");

    private final By pacsServerAddedMessageLocator = By.xpath("//p [.=\"PACS server has been added successfully\"]");
    private final By pacsServerEditedMessageLocator = By.xpath("//p [.=\"PACS server has been edited successfully\"]");
    private final By pacsServerDeletedMessageLocator = By.xpath("//p [.=\"Selected PACS server has been deleted successfully\"]");

    private final By emptyNameFieldMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name is required \"]");
    private final By emptyIPAddressFieldMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" IP address is required \"]");
    private final By emptyAETitleFieldMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" AE title is required \"]");
    private final By emptyPortFieldMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Port no. is required \"]");
    private final By emptySiteFieldMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Please select at least one site \"]");

    private final By spacesOnlyNameFieldMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name cannot contain spaces \"]");
    private final By spacesOnlyIPAddressFieldMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" IP address cannot contain spaces \"]");
    private final By spacesOnlyAETitleFieldMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" AE title cannot contain spaces \"]");
    private final By spacesOnlyIssuerOfPatientIDFieldMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Issuer of patient ID cannot contain spaces \"]");

    private final By invalidIPAddressMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Invalid IP address \"]");
    private final By invalidPortNoMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Port must not be less than one degit  \"]");


    private final DriverFactory driver;

    public P06_PACSServersAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add button")
    public P06_PACSServersAdminPage clickOnAddButton() {
        LogsUtils.info("Clicking on Add button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter name")
    public P06_PACSServersAdminPage enterName(String name) {
        LogsUtils.info("Entering PACS server name: " + name);
        driver.elementUtils().sendDataToElement(nameFieldLocator, name);
        return this;
    }

    @Step("Enter IP address")
    public P06_PACSServersAdminPage enterIPAddress(String ipAddress) {
        LogsUtils.info("Entering PACS server IP address: " + ipAddress);
        driver.elementUtils().sendDataToElement(ipAddressFieldLocator, ipAddress);
        return this;
    }

    @Step("Enter AE Title")
    public P06_PACSServersAdminPage enterAETitle(String aeTitle) {
        LogsUtils.info("Entering AE Title: " + aeTitle);
        driver.elementUtils().sendDataToElement(aeTitleFieldLocator, aeTitle);
        return this;
    }

    @Step("Enter port")
    public P06_PACSServersAdminPage enterPort(String port) {
        LogsUtils.info("Entering port: " + port);
        driver.elementUtils().clickOnElement(portFieldLocator);
        ClipboardUtils.copyToClipboard(port);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Enter issuer of patient ID")
    public P06_PACSServersAdminPage enterIssuerOfPatientId(String issuerOfPatientId) {
        LogsUtils.info("Entering issuer of patient ID: " + issuerOfPatientId);
        driver.elementUtils().sendDataToElement(issuerOfPatientIdFieldLocator, issuerOfPatientId);
        return this;
    }

    @Step("Select site")
    public P06_PACSServersAdminPage selectSite() {
        LogsUtils.info("Selecting site");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Click on Site Dropdown")
    public P06_PACSServersAdminPage clickOnSiteDropdown() {
        LogsUtils.info("Clicking on Site Dropdown");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        return this;
    }

    @Step("Click on Active checkbox")
    public P06_PACSServersAdminPage clickOnActiveCheckbox() {
        LogsUtils.info("Clicking on Active checkbox");
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Save button")
    public P06_PACSServersAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P06_PACSServersAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on Cancel button")
    public P06_PACSServersAdminPage clickOnCancelButton() {
        LogsUtils.info("Clicking on Cancel button");
        driver.elementUtils().clickOnElement(cancelButtonLocator);
        return this;
    }

    @Step("Search for PACS Server")
    public P06_PACSServersAdminPage searchForPacsServer(String pacsServerName) {
        LogsUtils.info("Searching for PACS Server: " + pacsServerName);
        driver.elementUtils().sendDataToElement(pacsServerNameSearchFieldLocator, pacsServerName);
        return this;
    }

    @Step("Click on Edit button")
    public P06_PACSServersAdminPage clickOnEditButton(String pacsServerName) {
        LogsUtils.info("Clicking on Edit button for PACS server: " + pacsServerName);
        By editButtonLocator = By.xpath("//td[.='" + pacsServerName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P06_PACSServersAdminPage clickOnDeleteButton(String pacsServerName) {
        LogsUtils.info("Clicking on Delete button for PACS server: " + pacsServerName);
        By deleteButtonLocator = By.xpath("//td[.='" + pacsServerName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on OK Button")
    public P06_PACSServersAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK Button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Assert visibility of PACS Server Added Alert")
    public void assertVisibilityOfPacsServerAddedAlert() {
        LogsUtils.info("Asserting visibility of PACS Server Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(pacsServerAddedMessageLocator),
                "PACS Server added alert not visible"
        );
    }

    @Step("Assert visibility of PACS Server Edited Alert")
    public void assertVisibilityOfPacsServerEditedAlert() {
        LogsUtils.info("Asserting visibility of PACS Server Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(pacsServerEditedMessageLocator),
                "PACS Server edited alert not visible"
        );
    }

    @Step("Assert visibility of PACS Server Deleted Alert")
    public void assertVisibilityOfPacsServerDeletedAlert() {
        LogsUtils.info("Asserting visibility of PACS Server Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(pacsServerDeletedMessageLocator),
                "PACS Server deleted alert not visible"
        );
    }

    @Step("Assert visibility of empty name field message")
    public void assertVisibilityOfEmptyNameFieldMessage() {
        LogsUtils.info("Asserting visibility of empty name field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyNameFieldMessageLocator),
                "Empty name field message not visible"
        );
    }

    @Step("Assert visibility of empty IP address field message")
    public void assertVisibilityOfEmptyIPAddressFieldMessage() {
        LogsUtils.info("Asserting visibility of empty IP address field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyIPAddressFieldMessageLocator),
                "Empty IP address field message not visible"
        );
    }

    @Step("Assert visibility of empty AE Title field message")
    public void assertVisibilityOfEmptyAETitleFieldMessage() {
        LogsUtils.info("Asserting visibility of empty AE Title field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyAETitleFieldMessageLocator),
                "Empty AE Title field message not visible"
        );
    }

    @Step("Assert visibility of empty port field message")
    public void assertVisibilityOfEmptyPortFieldMessage() {
        LogsUtils.info("Asserting visibility of empty port field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyPortFieldMessageLocator),
                "Empty port field message not visible"
        );
    }

    @Step("Assert visibility of empty site field message")
    public void assertVisibilityOfEmptySiteFieldMessage() {
        LogsUtils.info("Asserting visibility of empty site field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySiteFieldMessageLocator),
                "Empty site field message not visible"
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

    @Step("Assert visibility of spaces only IP address field message")
    public void assertVisibilityOfSpacesOnlyIPAddressFieldMessage() {
        LogsUtils.info("Asserting visibility of spaces only IP address field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyIPAddressFieldMessageLocator),
                "Spaces only IP address field message not visible"
        );
    }

    @Step("Assert visibility of spaces only AE Title field message")
    public void assertVisibilityOfSpacesOnlyAETitleFieldMessage() {
        LogsUtils.info("Asserting visibility of spaces only AE Title field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyAETitleFieldMessageLocator),
                "Spaces only AE Title field message not visible"
        );
    }

    @Step("Assert visibility of spaces only issuer of patient ID field message")
    public void assertVisibilityOfSpacesOnlyIssuerOfPatientIDFieldMessage() {
        LogsUtils.info("Asserting visibility of spaces only issuer of patient ID field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyIssuerOfPatientIDFieldMessageLocator),
                "Spaces only issuer of patient ID field message not visible"
        );
    }

    @Step("Assert visibility of invalid IP address message")
    public void assertVisibilityOfInvalidIPAddressMessage() {
        LogsUtils.info("Asserting visibility of invalid IP address message");
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
