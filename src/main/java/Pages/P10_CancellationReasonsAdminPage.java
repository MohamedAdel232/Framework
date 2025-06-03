package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P10_CancellationReasonsAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new cancellation reason\"]");
    private final By reasonTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By requiresCommentCheckboxLocator = By.cssSelector("[formcontrolname=\"requiresComment\"]");
    private final By activeCheckboxLocator = By.cssSelector("[formcontrolname=\"active\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By cancelButtonLocator = By.cssSelector("[title=\"Cancel\"]");
    private final By reasonSearchFieldLocator = By.cssSelector("input[aria-label=\"Reason Filter\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By cancellationReasonAddedMessageLocator = By.cssSelector("[aria-label=\"New cancellation reason has been added successfully\"]");
    private final By cancellationReasonEditedMessageLocator = By.cssSelector("[aria-label=\"Selected cancellation reason has been updated successfully\"]");
    private final By cancellationReasonDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected cancellation reason has been deleted successfully\"]");
    private final By emptyReasonFieldMessageLocator = By.cssSelector("[aria-label='Cancellation reason cannot be empty or contain spaces only, please enter a valid reason']");

    private final DriverFactory driver;

    public P10_CancellationReasonsAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add Cancellation Reason button")
    public P10_CancellationReasonsAdminPage clickOnAddCancellationReasonButton() {
        LogsUtils.info("Clicking on Add button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter Reason")
    public P10_CancellationReasonsAdminPage enterReason(String reason) {
        LogsUtils.info("Entering Reason: " + reason);
        driver.elementUtils().sendDataToElement(reasonTextFieldLocator, reason);
        return this;
    }

    @Step("Check Requires Comment checkbox")
    public P10_CancellationReasonsAdminPage checkRequiresCommentCheckbox() {
        LogsUtils.info("Checking Requires Comment checkbox");
        driver.elementUtils().clickOnElement(requiresCommentCheckboxLocator);
        return this;
    }

    @Step("Check Active checkbox")
    public P10_CancellationReasonsAdminPage checkActiveCheckbox() {
        LogsUtils.info("Checking Active checkbox");
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Save button")
    public P10_CancellationReasonsAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Cancel button")
    public P10_CancellationReasonsAdminPage clickOnCancelButton() {
        LogsUtils.info("Clicking on Cancel button");
        driver.elementUtils().clickOnElement(cancelButtonLocator);
        return this;
    }

    @Step("Search for Cancellation Reason")
    public P10_CancellationReasonsAdminPage searchForCancellationReason(String reason) {
        LogsUtils.info("Searching for Cancellation Reason: " + reason);
        driver.elementUtils().sendDataToElement(reasonSearchFieldLocator, reason);
        return this;
    }

    @Step("Click on Edit button")
    public P10_CancellationReasonsAdminPage clickOnEditButton(String reason) {
        LogsUtils.info("Clicking on Edit button for Cancellation Reason: " + reason);
        By editButtonLocator = By.xpath("//td[.='" + reason + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P10_CancellationReasonsAdminPage clickOnDeleteButton(String reason) {
        LogsUtils.info("Clicking on Delete button for Cancellation Reason: " + reason);
        By deleteButtonLocator = By.xpath("//td[.='" + reason + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P10_CancellationReasonsAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Assert visibility of Cancellation Reason Added Alert")
    public void assertVisibilityOfCancellationReasonAddedAlert() {
        LogsUtils.info("Asserting visibility of Cancellation Reason Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(cancellationReasonAddedMessageLocator),
                "Cancellation Reason added alert not visible"
        );
    }

    @Step("Assert visibility of Cancellation Reason Edited Alert")
    public void assertVisibilityOfCancellationReasonEditedAlert() {
        LogsUtils.info("Asserting visibility of Cancellation Reason Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(cancellationReasonEditedMessageLocator),
                "Cancellation Reason edited alert not visible"
        );
    }

    @Step("Assert visibility of Cancellation Reason Deleted Alert")
    public void assertVisibilityOfCancellationReasonDeletedAlert() {
        LogsUtils.info("Asserting visibility of Cancellation Reason Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(cancellationReasonDeletedMessageLocator),
                "Cancellation Reason deleted alert not visible"
        );
    }

    @Step("Assert visibility of empty reason field message")
    public void assertVisibilityOfEmptyReasonFieldMessage() {
        LogsUtils.info("Asserting visibility of empty reason field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyReasonFieldMessageLocator),
                "Empty reason field message not visible"
        );
    }
} 