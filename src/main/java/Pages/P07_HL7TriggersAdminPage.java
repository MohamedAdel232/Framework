package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P07_HL7TriggersAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new HL7 trigger\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By eventDropdownLocator = By.cssSelector("[formcontrolname=\"event\"]");
    private final By destinationDropdownLocator = By.cssSelector("[formcontrolname=\"destination\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By cancelButtonLocator = By.cssSelector("[title=\"Cancel\"]");
    private final By hl7TriggerNameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By hl7TriggerAddedMessageLocator = By.cssSelector("[aria-label=\"New HL7 trigger has been added successfully\"]");
    private final By hl7TriggerEditedMessageLocator = By.cssSelector("[aria-label=\"Selected HL7 trigger has been updated successfully\"]");
    private final By hl7TriggerDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected HL7 trigger has been deleted successfully\"]");
    private final By emptyNameFieldMessageLocator = By.cssSelector("[aria-label='Name cannot be empty or contain spaces only, please enter a valid name']");
    private final By emptyEventFieldMessageLocator = By.cssSelector("[aria-label='Please select an event']");
    private final By emptyDestinationFieldMessageLocator = By.cssSelector("[aria-label='Please select at least one destination']");

    private final DriverFactory driver;

    public P07_HL7TriggersAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add HL7 Trigger button")
    public P07_HL7TriggersAdminPage clickOnAddHL7TriggersButton() {
        LogsUtils.info("Clicking on Add button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter HL7 Trigger name")
    public P07_HL7TriggersAdminPage enterHL7TriggerName(String name) {
        LogsUtils.info("Entering HL7 Trigger name: " + name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Select HL7 Trigger event")
    public P07_HL7TriggersAdminPage selectHL7TriggerEvent() {
        LogsUtils.info("Selecting HL7 Trigger event");
        driver.elementUtils().clickOnElement(eventDropdownLocator);
        By eventOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(eventOptionLocator);
        return this;
    }

    @Step("Select HL7 Trigger destination")
    public P07_HL7TriggersAdminPage selectHL7TriggerDestination() {
        LogsUtils.info("Selecting HL7 Trigger destination");
        driver.elementUtils().clickOnElement(destinationDropdownLocator);
        By destinationOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(destinationOptionLocator);
        return this;
    }

    @Step("Click on Save button")
    public P07_HL7TriggersAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Cancel button")
    public P07_HL7TriggersAdminPage clickOnCancelButton() {
        LogsUtils.info("Clicking on Cancel button");
        driver.elementUtils().clickOnElement(cancelButtonLocator);
        return this;
    }

    @Step("Search for HL7 Trigger by name")
    public P07_HL7TriggersAdminPage searchForHL7TriggerByName(String name) {
        LogsUtils.info("Searching for HL7 Trigger by name: " + name);
        driver.elementUtils().sendDataToElement(hl7TriggerNameSearchFieldLocator, name);
        return this;
    }

    @Step("Click on Edit button")
    public P07_HL7TriggersAdminPage clickOnEditButton(String hl7TriggerName){
        LogsUtils.info("Clicking on Edit button for HL7 Trigger: " + hl7TriggerName);
        By editButtonLocator = By.xpath("//td[.='" + hl7TriggerName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P07_HL7TriggersAdminPage clickOnDeleteButton(String hl7TriggerName) {
        LogsUtils.info("Clicking on Delete button for HL7 Trigger: " + hl7TriggerName);
        By deleteButtonLocator = By.xpath("//td[.='" + hl7TriggerName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P07_HL7TriggersAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Assert visibility of HL7 Trigger Added Alert")
    public void assertVisibilityOfHL7TriggerAddedAlert() {
        LogsUtils.info("Asserting visibility of HL7 Trigger Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(hl7TriggerAddedMessageLocator),
                "HL7 Trigger added alert not visible"
        );
    }

    @Step("Assert visibility of HL7 Trigger Edited Alert")
    public void assertVisibilityOfHL7TriggerEditedAlert() {
        LogsUtils.info("Asserting visibility of HL7 Trigger Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(hl7TriggerEditedMessageLocator),
                "HL7 Trigger edited alert not visible"
        );
    }

    @Step("Assert visibility of HL7 Trigger Deleted Alert")
    public void assertVisibilityOfHL7TriggerDeletedAlert() {
        LogsUtils.info("Asserting visibility of HL7 Trigger Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(hl7TriggerDeletedMessageLocator),
                "HL7 Trigger deleted alert not visible"
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

    @Step("Assert visibility of empty event field message")
    public void assertVisibilityOfEmptyEventFieldMessage() {
        LogsUtils.info("Asserting visibility of empty event field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyEventFieldMessageLocator),
                "Empty event field message not visible"
        );
    }

    @Step("Assert visibility of empty destination field message")
    public void assertVisibilityOfEmptyDestinationFieldMessage() {
        LogsUtils.info("Asserting visibility of empty destination field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyDestinationFieldMessageLocator),
                "Empty destination field message not visible"
        );
    }
}
