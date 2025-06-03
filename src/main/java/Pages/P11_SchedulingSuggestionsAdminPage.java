package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P11_SchedulingSuggestionsAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new scheduling suggestion\"]");
    private final By schedulingSuggestionTextFieldLocator = By.cssSelector("[formcontrolname=\"schedulingSuggestion\"]");
    private final By manualDateCheckboxLocator = By.cssSelector("[formcontrolname=\"manualDate\"]");
    private final By activeCheckboxLocator = By.cssSelector("[formcontrolname=\"active\"]");
    private final By defaultCheckboxLocator = By.cssSelector("[formcontrolname=\"default\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By cancelButtonLocator = By.cssSelector("[title=\"Cancel\"]");
    private final By schedulingSuggestionSearchFieldLocator = By.cssSelector("input[aria-label=\"Scheduling Suggestion Filter\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By schedulingSuggestionAddedMessageLocator = By.cssSelector("[aria-label=\"New Scheduling suggestion has been added successfully\"]");
    private final By schedulingSuggestionEditedMessageLocator = By.cssSelector("[aria-label=\"Selected Scheduling suggestion has been updated successfully\"]");
    private final By schedulingSuggestionDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected Scheduling suggestion has been deleted successfully\"]");
    private final By emptySchedulingSuggestionFieldMessageLocator = By.cssSelector("[aria-label='Scheduling suggestion cannot be empty or contain spaces only, please enter a valid suggestion']");

    private final DriverFactory driver;

    public P11_SchedulingSuggestionsAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add Scheduling Suggestion button")
    public P11_SchedulingSuggestionsAdminPage clickOnAddSchedulingSuggestionButton() {
        LogsUtils.info("Clicking on Add button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter Scheduling Suggestion")
    public P11_SchedulingSuggestionsAdminPage enterSchedulingSuggestion(String suggestion) {
        LogsUtils.info("Entering Scheduling Suggestion: " + suggestion);
        driver.elementUtils().sendDataToElement(schedulingSuggestionTextFieldLocator, suggestion);
        return this;
    }

    @Step("Check Manual Date checkbox")
    public P11_SchedulingSuggestionsAdminPage checkManualDateCheckbox() {
        LogsUtils.info("Checking Manual Date checkbox");
        driver.elementUtils().clickOnElement(manualDateCheckboxLocator);
        return this;
    }

    @Step("Check Active checkbox")
    public P11_SchedulingSuggestionsAdminPage checkActiveCheckbox() {
        LogsUtils.info("Checking Active checkbox");
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Check Default checkbox")
    public P11_SchedulingSuggestionsAdminPage checkDefaultCheckbox() {
        LogsUtils.info("Checking Default checkbox");
        driver.elementUtils().clickOnElement(defaultCheckboxLocator);
        return this;
    }

    @Step("Click on Save button")
    public P11_SchedulingSuggestionsAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Cancel button")
    public P11_SchedulingSuggestionsAdminPage clickOnCancelButton() {
        LogsUtils.info("Clicking on Cancel button");
        driver.elementUtils().clickOnElement(cancelButtonLocator);
        return this;
    }

    @Step("Search for Scheduling Suggestion")
    public P11_SchedulingSuggestionsAdminPage searchForSchedulingSuggestion(String suggestion) {
        LogsUtils.info("Searching for Scheduling Suggestion: " + suggestion);
        driver.elementUtils().sendDataToElement(schedulingSuggestionSearchFieldLocator, suggestion);
        return this;
    }

    @Step("Click on Edit button")
    public P11_SchedulingSuggestionsAdminPage clickOnEditButton(String suggestion) {
        LogsUtils.info("Clicking on Edit button for Scheduling Suggestion: " + suggestion);
        By editButtonLocator = By.xpath("//td[.='" + suggestion + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P11_SchedulingSuggestionsAdminPage clickOnDeleteButton(String suggestion) {
        LogsUtils.info("Clicking on Delete button for Scheduling Suggestion: " + suggestion);
        By deleteButtonLocator = By.xpath("//td[.='" + suggestion + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P11_SchedulingSuggestionsAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Assert visibility of Scheduling Suggestion Added Alert")
    public void assertVisibilityOfSchedulingSuggestionAddedAlert() {
        LogsUtils.info("Asserting visibility of Scheduling Suggestion Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(schedulingSuggestionAddedMessageLocator),
                "Scheduling Suggestion added alert not visible"
        );
    }

    @Step("Assert visibility of Scheduling Suggestion Edited Alert")
    public void assertVisibilityOfSchedulingSuggestionEditedAlert() {
        LogsUtils.info("Asserting visibility of Scheduling Suggestion Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(schedulingSuggestionEditedMessageLocator),
                "Scheduling Suggestion edited alert not visible"
        );
    }

    @Step("Assert visibility of Scheduling Suggestion Deleted Alert")
    public void assertVisibilityOfSchedulingSuggestionDeletedAlert() {
        LogsUtils.info("Asserting visibility of Scheduling Suggestion Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(schedulingSuggestionDeletedMessageLocator),
                "Scheduling Suggestion deleted alert not visible"
        );
    }

    @Step("Assert visibility of empty scheduling suggestion field message")
    public void assertVisibilityOfEmptySchedulingSuggestionFieldMessage() {
        LogsUtils.info("Asserting visibility of empty scheduling suggestion field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySchedulingSuggestionFieldMessageLocator),
                "Empty scheduling suggestion field message not visible"
        );
    }
} 