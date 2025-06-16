package Pages;

import Factories.DriverFactory;
import Utilities.ClipboardUtils;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P13_EmailServersAdminPage {
    private final By addNewEmailServerButton = By.cssSelector("[title=\"Add new email server\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By typeDropdownLocator = By.cssSelector("[formcontrolname=\"relay\"]");
    private final By siteDropdownLocator = By.cssSelector("[formcontrolname=\"sites\"]");
    private final By emailServerTextFieldLocator = By.cssSelector("[formcontrolname=\"serverName\"]");
    private final By senderEmailTextFieldLocator = By.cssSelector("[formcontrolname=\"senderEmail\"]");
    private final By senderNameTextFieldLocator = By.cssSelector("[formcontrolname=\"senderName\"]");
    private final By smtpServerTextFieldLocator = By.cssSelector("[formcontrolname=\"serverName\"]");
    private final By smtpPortNoTextFieldLocator = By.cssSelector("[formcontrolname=\"port\"]");
    private final By smtpUsernameTextFieldLocator = By.cssSelector("[formcontrolname=\"userName\"]");
    private final By smtpPasswordTextFieldLocator = By.cssSelector("[formcontrolname=\"password\"]");
    private final By enableSSLCheckboxLocator = By.cssSelector("[formcontrolname=\"enableSSL\"]");
    private final By enableLDAPAuthCheckboxLocator = By.cssSelector("[formcontrolname=\"smtpLdapAuth\"]");
    private final By nameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By okButtonLocator = By.xpath("//button[.=\"OK\"]");
    private final By yesButtonLocator = By.xpath("//button[.=\"Yes\"]");
    private final By closeButtonLocator = By.cssSelector("[title=\"Close\"]");

    private final By emailServerAddedMessageLocator = By.xpath("//p [.=\"Email server has been added successfully\"]");
    private final By emailServerEditedMessageLocator = By.xpath("//p [.=\"Email server has been updated successfully\"]");
    private final By emailServerDeletedMessageLocator = By.xpath("//p [.=\"Selected Email server has been deleted successfully\"]");

    private final By emptyNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name is required \"]");
    private final By emptyTypeMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Type is required \"]");
    private final By emptySiteMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Please select at least one site \"]");
    private final By emptyEmailServerMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Server name is required \"]");
    private final By emptySenderEmailMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Sender email is required \"]");
    private final By emptySenderNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Sender name is required \"]");
    private final By emptySMTPServerMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Server name is required \"]");
    private final By emptySMTPPortNoMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Port no. is required \"]");
    private final By emptySMTPUsernameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Username is required \"]");
    private final By emptySMTPPasswordMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Password is required \"]");

    private final By spacesOnlyNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name cannot contain spaces only \"]");
    private final By spacesOnlyEmailServerMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Server name cannot contain spaces only \"]");
    private final By spacesOnlySenderEmailMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Sender email cannot contain white spaces \"]");
    private final By spacesOnlySenderNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Sender name cannot contain spaces only \"]");
    private final By spacesOnlySMTPServerMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Server name cannot contain spaces only \"]");

    private final By invalidSenderEmailMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Invalid sender email \"]");

    private final By lessThanZeroPortNoMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Port no. should be more than 0 \"]");

    private final DriverFactory driver;

    public P13_EmailServersAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add New Email Server Button")
    public P13_EmailServersAdminPage clickOnAddNewEmailServerButton() {
        LogsUtils.info("Clicking on Add New Email Server button");
        driver.elementUtils().clickOnElement(addNewEmailServerButton);
        return this;
    }

    @Step("Enter Name: {name}")
    public P13_EmailServersAdminPage enterName(String name) {
        LogsUtils.info("Entering Name: " + name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Select Type")
    public P13_EmailServersAdminPage selectType(String type) {
        LogsUtils.info("Selecting Type");
        driver.elementUtils().clickOnElement(typeDropdownLocator);
        By typeOptionLocator = By.xpath("//span [.=\"" + type + "\"]");
        driver.elementUtils().clickOnElement(typeOptionLocator);
        return this;
    }

    @Step("Click on Type Dropdown")
    public P13_EmailServersAdminPage clickOnTypeDropdown() {
        LogsUtils.info("Clicking on Type Dropdown");
        driver.elementUtils().clickOnElement(typeDropdownLocator);
        return this;
    }

    @Step("Select Site")
    public P13_EmailServersAdminPage selectSite() {
        LogsUtils.info("Selecting Site");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Click on Site Dropdown")
    public P13_EmailServersAdminPage clickOnSiteDropdown() {
        LogsUtils.info("Clicking on Site Dropdown");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        return this;
    }

    @Step("Enter Email Server: {emailServer}")
    public P13_EmailServersAdminPage enterEmailServer(String emailServer) {
        LogsUtils.info("Entering Email Server: " + emailServer);
        driver.elementUtils().sendDataToElement(emailServerTextFieldLocator, emailServer);
        return this;
    }

    @Step("Enter Sender Email: {senderEmail}")
    public P13_EmailServersAdminPage enterSenderEmail(String senderEmail) {
        LogsUtils.info("Entering Sender Email: " + senderEmail);
        driver.elementUtils().sendDataToElement(senderEmailTextFieldLocator, senderEmail);
        return this;
    }

    @Step("Enter Sender Name: {senderName}")
    public P13_EmailServersAdminPage enterSenderName(String senderName) {
        LogsUtils.info("Entering Sender Name: " + senderName);
        driver.elementUtils().sendDataToElement(senderNameTextFieldLocator, senderName);
        return this;
    }

    @Step("Enter SMTP Server: {smtpServer}")
    public P13_EmailServersAdminPage enterSMTPServer(String smtpServer) {
        LogsUtils.info("Entering SMTP Server: " + smtpServer);
        driver.elementUtils().sendDataToElement(smtpServerTextFieldLocator, smtpServer);
        return this;
    }

    @Step("Enter SMTP Port No.: {smtpPortNo}")
    public P13_EmailServersAdminPage enterSMTPPortNo(String smtpPortNo) {
        LogsUtils.info("Entering SMTP Port No.: " + smtpPortNo);
        ClipboardUtils.copyToClipboard(smtpPortNo);
        driver.elementUtils().clickOnElement(smtpPortNoTextFieldLocator);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Enter SMTP Username: {smtpUsername}")
    public P13_EmailServersAdminPage enterSMTPUsername(String smtpUsername) {
        LogsUtils.info("Entering SMTP Username: " + smtpUsername);
        driver.elementUtils().sendDataToElement(smtpUsernameTextFieldLocator, smtpUsername);
        return this;
    }

    @Step("Enter SMTP Password: {smtpPassword}")
    public P13_EmailServersAdminPage enterSMTPPassword(String smtpPassword) {
        LogsUtils.info("Entering SMTP Password: " + smtpPassword);
        driver.elementUtils().sendDataToElement(smtpPasswordTextFieldLocator, smtpPassword);
        return this;
    }

    @Step("Click on Enable SSL Checkbox")
    public P13_EmailServersAdminPage clickOnEnableSSLCheckbox() {
        LogsUtils.info("Clicking on Enable SSL Checkbox");
        driver.elementUtils().clickOnElement(enableSSLCheckboxLocator);
        return this;
    }

    @Step("Click on Enable LDAP Auth Checkbox")
    public P13_EmailServersAdminPage clickOnEnableLDAPAuthCheckbox() {
        LogsUtils.info("Clicking on Enable LDAP Auth Checkbox");
        driver.elementUtils().clickOnElement(enableLDAPAuthCheckboxLocator);
        return this;
    }

    @Step("Search Email Server by Name: {name}")
    public P13_EmailServersAdminPage searchEmailServersByName(String name) {
        LogsUtils.info("Searching Email Server by Name: " + name);
        driver.elementUtils().clearElement(nameSearchFieldLocator);
        driver.elementUtils().sendDataToElement(nameSearchFieldLocator, name);
        return this;
    }

    @Step("Click on Save Button")
    public P13_EmailServersAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save Button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P13_EmailServersAdminPage clickOnEditButton(String name) {
        LogsUtils.info("Clicking on Edit button for Email Server: " + name);
        By editButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P13_EmailServersAdminPage clickOnDeleteButton(String name) {
        LogsUtils.info("Clicking on Delete button for Email Server: " + name);
        By deleteButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes Button")
    public P13_EmailServersAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes Button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on OK Button")
    public P13_EmailServersAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK Button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Click on Close Button")
    public P13_EmailServersAdminPage clickOnCloseButton() {
        LogsUtils.info("Clicking on Close Button");
        driver.elementUtils().clickOnElement(closeButtonLocator);
        return this;
    }

    @Step("Assert visibility of Email Server Added Alert")
    public void assertVisibilityOfEmailServerAddedAlert() {
        LogsUtils.info("Asserting visibility of Email Server Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emailServerAddedMessageLocator),
                "Email Server added alert not visible"
        );
    }

    @Step("Assert visibility of Email Server Edited Alert")
    public void assertVisibilityOfEmailServerEditedAlert() {
        LogsUtils.info("Asserting visibility of Email Server Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emailServerEditedMessageLocator),
                "Email Server edited alert not visible"
        );
    }

    @Step("Assert visibility of Email Server Deleted Alert")
    public void assertVisibilityOfEmailServerDeletedAlert() {
        LogsUtils.info("Asserting visibility of Email Server Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emailServerDeletedMessageLocator),
                "Email Server deleted alert not visible"
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

    @Step("Assert visibility of Empty Site Message")
    public void assertVisibilityOfEmptySiteMessage() {
        LogsUtils.info("Asserting visibility of Empty Site Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySiteMessageLocator),
                "Empty site message not visible"
        );
    }

    @Step("Assert visibility of Empty Email Server Message")
    public void assertVisibilityOfEmptyEmailServerMessage() {
        LogsUtils.info("Asserting visibility of Empty Email Server Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyEmailServerMessageLocator),
                "Empty email server message not visible"
        );
    }

    @Step("Assert visibility of Empty Sender Email Message")
    public void assertVisibilityOfEmptySenderEmailMessage() {
        LogsUtils.info("Asserting visibility of Empty Sender Email Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySenderEmailMessageLocator),
                "Empty sender email message not visible"
        );
    }

    @Step("Assert visibility of Empty Sender Name Message")
    public void assertVisibilityOfEmptySenderNameMessage() {
        LogsUtils.info("Asserting visibility of Empty Sender Name Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySenderNameMessageLocator),
                "Empty sender name message not visible"
        );
    }

    @Step("Assert visibility of Empty SMTP Server Message")
    public void assertVisibilityOfEmptySMTPServerMessage() {
        LogsUtils.info("Asserting visibility of Empty SMTP Server Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySMTPServerMessageLocator),
                "Empty SMTP server message not visible"
        );
    }

    @Step("Assert visibility of Empty SMTP Port No. Message")
    public void assertVisibilityOfEmptySMTPPortNoMessage() {
        LogsUtils.info("Asserting visibility of Empty SMTP Port No. Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySMTPPortNoMessageLocator),
                "Empty SMTP port no. message not visible"
        );
    }

    @Step("Assert visibility of Empty SMTP Username Message")
    public void assertVisibilityOfEmptySMTPUsernameMessage() {
        LogsUtils.info("Asserting visibility of Empty SMTP Username Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySMTPUsernameMessageLocator),
                "Empty SMTP username message not visible"
        );
    }

    @Step("Assert visibility of Empty SMTP Password Message")
    public void assertVisibilityOfEmptySMTPPasswordMessage() {
        LogsUtils.info("Asserting visibility of Empty SMTP Password Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySMTPPasswordMessageLocator),
                "Empty SMTP password message not visible"
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

    @Step("Assert visibility of Spaces Only Email Server Message")
    public void assertVisibilityOfSpacesOnlyEmailServerMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only Email Server Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyEmailServerMessageLocator),
                "Spaces only email server message not visible"
        );
    }

    @Step("Assert visibility of Spaces Only Sender Email Message")
    public void assertVisibilityOfSpacesOnlySenderEmailMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only Sender Email Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlySenderEmailMessageLocator),
                "Spaces only sender email message not visible"
        );
    }

    @Step("Assert visibility of Spaces Only Sender Name Message")
    public void assertVisibilityOfSpacesOnlySenderNameMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only Sender Name Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlySenderNameMessageLocator),
                "Spaces only sender name message not visible"
        );
    }

    @Step("Assert visibility of Spaces Only SMTP Server Message")
    public void assertVisibilityOfSpacesOnlySMTPServerMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only SMTP Server Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlySMTPServerMessageLocator),
                "Spaces only SMTP server message not visible"
        );
    }

    @Step("Assert visibility of Invalid Sender Email Message")
    public void assertVisibilityOfInvalidSenderEmailMessage() {
        LogsUtils.info("Asserting visibility of Invalid Sender Email Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(invalidSenderEmailMessageLocator),
                "Invalid sender email message not visible"
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
