package Pages;

import Factories.DriverFactory;
import Utilities.ClipboardUtils;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P03_InstitutionsAdminPage {
    private final By addInstitutionButtonLocator = By.cssSelector("[title=\"New Institution\"]");
    private final By institutionNameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By studyExpirationTextFieldLocator = By.cssSelector("[formcontrolname=\"deleteconfig\"]");
    private final By activeCheckboxLocator = By.xpath("//div [@class=\"custom-control custom-checkbox\"]");
    private final By expirationTextFieldLocator = By.cssSelector("[formcontrolname=\"expiration\"]");
    private final By attemptsTextFieldLocator = By.cssSelector("[formcontrolname=\"attempts\"]");
    private final By resendLimitTextFieldLocator = By.cssSelector("[formcontrolname=\"resendLimit\"]");
    private final By otpMessageTextFieldLocator = By.xpath("//div [@class=\"ProseMirror\"]");
    private final By okButtonLocator = By.cssSelector("[title=\"OK\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By institutionNameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By closeButtonLocator = By.cssSelector("[title=\"Close\"]");
    private final By institutionAddedMessageLocator = By.xpath("//p [.=\"Entered institution has been added successfully\"]");
    private final By institutionEditedMessageLocator = By.xpath("//p [.=\"Updated successfully\"]");
    private final By institutionDeletedMessageLocator = By.xpath("//p [.=\"The selected institution has been deleted successfully\"]");
    private final By emptyInstitutionNameMessageLocator = By.xpath("//p [.=\"Name cannot be empty or contain spaces only, please enter a valid name\"]");
    private final By emptyStudyExpirationMessageLocator = By.xpath("//p [.=\"Study Expiration is required\"]");
    private final By emptyExpirationMessageLocator = By.xpath("//p [.=\"Expiration is required\"]");
    private final By emptyAttemptsMessageLocator = By.xpath("//p [.=\"Attempts is required\"]");
    private final By emptyResendLimitMessageLocator = By.xpath("//p [.=\"Resend limit is required\"]");
    private final By emptyOtpMessageLocator = By.xpath("//p [.=\"OTP message cannot be empty or contain spaces only, please enter valid text in OTP message\"]");

    private final DriverFactory driver;

    public P03_InstitutionsAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add Institution button")
    public P03_InstitutionsAdminPage clickOnAddInstitutionButton() {
        LogsUtils.info("Clicking on Add Institution button");
        driver.elementUtils().clickOnElement(addInstitutionButtonLocator);
        return this;
    }

    @Step("Enter institution name: {institutionName}")
    public P03_InstitutionsAdminPage enterInstitutionName(String institutionName) {
        LogsUtils.info("Entering institution name: " + institutionName);
        driver.elementUtils().sendDataToElement(institutionNameTextFieldLocator, institutionName);
        return this;
    }

    @Step("Enter study expiration: {studyExpiration}")
    public P03_InstitutionsAdminPage enterStudyExpiration(String studyExpiration) {
        LogsUtils.info("Entering study expiration: " + studyExpiration);
        driver.elementUtils().clearElement(studyExpirationTextFieldLocator);
        driver.elementUtils().sendDataToElement(studyExpirationTextFieldLocator, studyExpiration);
        return this;
    }

    @Step("Click on Active checkbox")
    public P03_InstitutionsAdminPage clickOnActiveCheckbox() {
        LogsUtils.info("Clicking on Active checkbox");
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Enter expiration: {expiration}")
    public P03_InstitutionsAdminPage enterExpiration(String expiration) {
        LogsUtils.info("Entering expiration: " + expiration);
        driver.elementUtils().sendDataToElement(expirationTextFieldLocator, expiration);
        return this;
    }

    @Step("Enter attempts: {attempts}")
    public P03_InstitutionsAdminPage enterAttempts(String attempts) {
        LogsUtils.info("Entering attempts: " + attempts);
        driver.elementUtils().sendDataToElement(attemptsTextFieldLocator, attempts);
        return this;
    }

    @Step("Enter resend limit: {resendLimit}")
    public P03_InstitutionsAdminPage enterResendLimit(String resendLimit) {
        LogsUtils.info("Entering resend limit: " + resendLimit);
        driver.elementUtils().sendDataToElement(resendLimitTextFieldLocator, resendLimit);
        return this;
    }

    @Step("Enter OTP message: {otpMessage}")
    public P03_InstitutionsAdminPage enterOtpMessage(String otpMessage) {
        LogsUtils.info("Entering OTP message: " + otpMessage);
        driver.elementUtils().clickOnElement(otpMessageTextFieldLocator);
        ClipboardUtils.copyToClipboard(otpMessage);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Click on OK button")
    public P03_InstitutionsAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P03_InstitutionsAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Search for institution by name: {institutionName}")
    public P03_InstitutionsAdminPage searchForInstitutionByName(String institutionName) {
        LogsUtils.info("Searching for institution by name: " + institutionName);
        driver.elementUtils().sendDataToElement(institutionNameSearchFieldLocator, institutionName);
        return this;
    }

    @Step("Click on Edit button")
    public P03_InstitutionsAdminPage clickOnEditButton(String institutionName) {
        LogsUtils.info("Clicking on Edit button for Institution: " + institutionName);
        By editButtonLocator = By.xpath("//td[.='" + institutionName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P03_InstitutionsAdminPage clickOnDeleteButton(String institutionName) {
        LogsUtils.info("Clicking on Delete button for Institution: " + institutionName);
        By deleteButtonLocator = By.xpath("//td[.='" + institutionName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Save button")
    public P03_InstitutionsAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Close button")
    public P03_InstitutionsAdminPage clickOnCloseButton() {
        LogsUtils.info("Clicking on Close button");
        driver.elementUtils().clickOnElement(closeButtonLocator);
        return this;
    }

    @Step("Assert visibility of Institution Added Alert")
    public void assertVisibilityOfInstitutionAddedAlert() {
        LogsUtils.info("Asserting visibility of Institution Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(institutionAddedMessageLocator),
                "Institution added alert not visible"
        );
    }

    @Step("Assert visibility of Institution Edited Alert")
    public void assertVisibilityOfInstitutionEditedAlert() {
        LogsUtils.info("Asserting visibility of Institution Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(institutionEditedMessageLocator),
                "Institution edited alert not visible"
        );
    }

    @Step("Assert visibility of Institution Deleted Alert")
    public void assertVisibilityOfInstitutionDeletedAlert() {
        LogsUtils.info("Asserting visibility of Institution Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(institutionDeletedMessageLocator),
                "Institution deleted alert not visible"
        );
    }

    @Step("Assert visibility of Empty Institution Name Message")
    public void assertVisibilityOfEmptyInstitutionNameMessage() {
        LogsUtils.info("Asserting visibility of Empty Institution Name Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyInstitutionNameMessageLocator),
                "Empty institution name message not visible"
        );
    }

    @Step("Assert visibility of Empty Study Expiration Message")
    public void assertVisibilityOfEmptyStudyExpirationMessage() {
        LogsUtils.info("Asserting visibility of Empty Study Expiration Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyStudyExpirationMessageLocator),
                "Empty study expiration message not visible"
        );
    }

    @Step("Assert visibility of Empty Expiration Message")
    public void assertVisibilityOfEmptyExpirationMessage() {
        LogsUtils.info("Asserting visibility of Empty Expiration Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyExpirationMessageLocator),
                "Empty expiration message not visible"
        );
    }

    @Step("Assert visibility of Empty Attempts Message")
    public void assertVisibilityOfEmptyAttemptsMessage() {
        LogsUtils.info("Asserting visibility of Empty Attempts Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyAttemptsMessageLocator),
                "Empty attempts message not visible"
        );
    }

    @Step("Assert visibility of Empty Resend Limit Message")
    public void assertVisibilityOfEmptyResendLimitMessage() {
        LogsUtils.info("Asserting visibility of Empty Resend Limit Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyResendLimitMessageLocator),
                "Empty resend limit message not visible"
        );
    }

    @Step("Assert visibility of Empty OTP Message")
    public void assertVisibilityOfEmptyOtpMessage() {
        LogsUtils.info("Asserting visibility of Empty OTP Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyOtpMessageLocator),
                "Empty OTP message not visible"
        );
    }
}
