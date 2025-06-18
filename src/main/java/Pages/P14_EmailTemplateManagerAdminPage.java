package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P14_EmailTemplateManagerAdminPage {
    private final By addNewEmailTemplateManagerButtonLocator = By.cssSelector("[title=\"Add new email template\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By typeDropdownLocator = By.cssSelector("[formcontrolname=\"type\"]");
    private final By siteDropdownLocator = By.cssSelector("[formcontrolname=\"sites\"]");
    private final By activeCheckboxLocator = By.cssSelector("[formcontrolname=\"active\"]");
    private final By subjectTextFieldLocator = By.cssSelector("[formcontrolname=\"subject\"]");
    private final By bodyTextFieldLocator = By.className("ProseMirror");
    private final By nameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By okButtonLocator = By.xpath("//button[.=\"OK\"]");
    private final By yesButtonLocator = By.xpath("//button[.=\"Yes\"]");
    private final By backButtonLocator = By.cssSelector("[title=\"Back\"]");

    private final By emailTemplateManagerEditedMessageLocator = By.xpath("//p [.=\"Email template has been updated successfully\"]");
    private final By emailTemplateManagerDeletedMessageLocator = By.xpath("//p [.=\"Selected email template has been deleted successfully\"]");

    private final By emptyNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name cannot be empty or contain spaces only \"]");
    private final By emptyTypeMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Type is required \"]");
    private final By emptySiteMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Select at least one site \"]");
    private final By emptySubjectMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Subject cannot be empty or contain spaces only \"]");
    private final By emptyBodyMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Body cannot be empty or contain spaces only \"]");

    private final By spacesOnlyNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name cannot be empty or contain spaces only \"]");
    private final By spacesOnlySubjectMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Subject cannot be empty or contain spaces only \"]");
    private final By spacesOnlyBodyMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Body cannot be empty or contain spaces only \"]");

    private final DriverFactory driver;

    public P14_EmailTemplateManagerAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add New Email Template Manager Button")
    public P14_EmailTemplateManagerAdminPage clickOnAddNewEmailTemplateManagerButton() {
        LogsUtils.info("Clicking on Add New Email Template Manager button");
        driver.elementUtils().clickOnElement(addNewEmailTemplateManagerButtonLocator);
        return this;
    }

    @Step("Enter Name: {name}")
    public P14_EmailTemplateManagerAdminPage enterName(String name) {
        LogsUtils.info("Entering Name: " + name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Select Type")
    public P14_EmailTemplateManagerAdminPage selectType() {
        LogsUtils.info("Selecting Type");
        driver.elementUtils().clickOnElement(typeDropdownLocator);
        By typeOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(typeOptionLocator);
        return this;
    }

    @Step("Click on Type Dropdown")
    public P14_EmailTemplateManagerAdminPage clickOnTypeDropdown() {
        LogsUtils.info("Clicking on Type Dropdown");
        driver.elementUtils().clickOnElement(typeDropdownLocator);
        return this;
    }

    @Step("Select Site")
    public P14_EmailTemplateManagerAdminPage selectSite() {
        LogsUtils.info("Selecting Site");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Click on Site Dropdown")
    public P14_EmailTemplateManagerAdminPage clickOnSiteDropdown() {
        LogsUtils.info("Clicking on Site Dropdown");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        return this;
    }

    @Step("Click on Active Checkbox")
    public P14_EmailTemplateManagerAdminPage clickOnActiveCheckbox() {
        LogsUtils.info("Clicking on Active checkbox");
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Enter Subject: {subject}")
    public P14_EmailTemplateManagerAdminPage enterSubject(String subject) {
        LogsUtils.info("Entering Subject: " + subject);
        driver.elementUtils().sendDataToElement(subjectTextFieldLocator, subject);
        return this;
    }

    @Step("Enter Body: {body}")
    public P14_EmailTemplateManagerAdminPage enterBody(String body) {
        LogsUtils.info("Entering Body: " + body);
        driver.elementUtils().sendDataToElement(bodyTextFieldLocator, body);
        return this;
    }

    @Step("Search Email Template Manager by Name: {name}")
    public P14_EmailTemplateManagerAdminPage searchEmailTemplateManagerByName(String name) {
        LogsUtils.info("Searching Email Template  Manager by Name: " + name);
        driver.elementUtils().clearElement(nameSearchFieldLocator);
        driver.elementUtils().sendDataToElement(nameSearchFieldLocator, name);
        return this;
    }

    @Step("Click on Save Button")
    public P14_EmailTemplateManagerAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save Button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P14_EmailTemplateManagerAdminPage clickOnEditButton(String name) {
        LogsUtils.info("Clicking on Edit button for Email Template  Manager: " + name);
        By editButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P14_EmailTemplateManagerAdminPage clickOnDeleteButton(String name) {
        LogsUtils.info("Clicking on Delete button for Email Template  Manager: " + name);
        By deleteButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes Button")
    public P14_EmailTemplateManagerAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes Button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on OK Button")
    public P14_EmailTemplateManagerAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK Button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Click on Close Button")
    public P14_EmailTemplateManagerAdminPage clickOnBackButton() {
        LogsUtils.info("Clicking on Close Button");
        driver.elementUtils().clickOnElement(backButtonLocator);
        return this;
    }

    @Step("Assert visibility of Email Template  Manager Edited Alert")
    public void assertVisibilityOfEmailTemplateManagerEditedAlert() {
        LogsUtils.info("Asserting visibility of Email Template Manager Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emailTemplateManagerEditedMessageLocator),
                "Email Template Manager edited alert not visible"
        );
    }

    @Step("Assert visibility of Email Template Manager Deleted Alert")
    public void assertVisibilityOfEmailTemplateManagerDeletedAlert() {
        LogsUtils.info("Asserting visibility of Email Template Manager Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emailTemplateManagerDeletedMessageLocator),
                "Email Template Manager deleted alert not visible"
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

    @Step("Assert visibility of Empty Subject Message")
    public void assertVisibilityOfEmptySubjectMessage() {
        LogsUtils.info("Asserting visibility of Empty Subject Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySubjectMessageLocator),
                "Empty subject message not visible"
        );
    }

    @Step("Assert visibility of Empty Body Message")
    public void assertVisibilityOfEmptyBodyMessage() {
        LogsUtils.info("Asserting visibility of Empty Body Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyBodyMessageLocator),
                "Empty body message not visible"
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

    @Step("Assert visibility of Spaces Only Subject Message")
    public void assertVisibilityOfSpacesOnlySubjectMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only Subject Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlySubjectMessageLocator),
                "Spaces only subject message not visible"
        );
    }

    @Step("Assert visibility of Spaces Only Body Message")
    public void assertVisibilityOfSpacesOnlyBodyMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only Body Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyBodyMessageLocator),
                "Spaces only body message not visible"
        );
    }
}
