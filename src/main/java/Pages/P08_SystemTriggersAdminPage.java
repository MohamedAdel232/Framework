package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P08_SystemTriggersAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new system trigger\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By messageTypeDropdownLocator = By.cssSelector("[formcontrolname=\"messageType\"]");
    private final By orderStatusTextFieldLocator = By.cssSelector("[formcontrolname=\"orderStatus\"]");
    private final By orderControlTextFieldLocator = By.cssSelector("[formcontrolname=\"orderControl\"]");
    private final By systemActionDropdownLocator = By.cssSelector("[formcontrolname=\"systemAction\"]");
    private final By availableActionsDropdownLocator = By.cssSelector("[formcontrolname=\"availableActions\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By cancelButtonLocator = By.cssSelector("[title=\"Cancel\"]");
    private final By systemTriggerNameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By systemTriggerAddedMessageLocator = By.cssSelector("[aria-label=\"New system trigger has been added successfully\"]");
    private final By systemTriggerEditedMessageLocator = By.cssSelector("[aria-label=\"Selected system trigger has been updated successfully\"]");
    private final By systemTriggerDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected system trigger has been deleted successfully\"]");
    private final By emptyNameFieldMessageLocator = By.cssSelector("[aria-label='Name cannot be empty or contain spaces only, please enter a valid name']");
    private final By emptyMessageTypeFieldMessageLocator = By.cssSelector("[aria-label='Please select a message type']");
    private final By emptyOrderStatusFieldMessageLocator = By.cssSelector("[aria-label='Order Status cannot be empty or contain spaces only, please enter a valid Order Status']");
    private final By emptyOrderControlFieldMessageLocator = By.cssSelector("[aria-label='Order Control cannot be empty or contain spaces only, please enter a valid Order Control']");
    private final By emptySystemActionFieldMessageLocator = By.cssSelector("[aria-label='Please select a System Action']");
    private final By emptyAvailableActionsFieldMessageLocator = By.cssSelector("[aria-label='Please select an Available Actions']");

    private final DriverFactory driver;

    public P08_SystemTriggersAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add System Trigger button")
    public P08_SystemTriggersAdminPage clickOnAddSystemTriggersButton() {
        LogsUtils.info("Clicking on Add button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter System Trigger name")
    public P08_SystemTriggersAdminPage enterSystemTriggerName(String name) {
        LogsUtils.info("Entering System Trigger name: " + name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Select Message Type")
    public P08_SystemTriggersAdminPage selectMessageType() {
        LogsUtils.info("Selecting Message Type");
        driver.elementUtils().clickOnElement(messageTypeDropdownLocator);
        By messageTypeOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(messageTypeOptionLocator);
        return this;
    }

    @Step("Enter Order Status")
    public P08_SystemTriggersAdminPage enterOrderStatus(String orderStatus) {
        LogsUtils.info("Entering Order Status: " + orderStatus);
        driver.elementUtils().sendDataToElement(orderStatusTextFieldLocator, orderStatus);
        return this;
    }

    @Step("Enter Order Control")
    public P08_SystemTriggersAdminPage enterOrderControl(String orderControl) {
        LogsUtils.info("Entering Order Control: " + orderControl);
        driver.elementUtils().sendDataToElement(orderControlTextFieldLocator, orderControl);
        return this;
    }

    @Step("Select System Action")
    public P08_SystemTriggersAdminPage selectSystemAction() {
        LogsUtils.info("Selecting System Action");
        driver.elementUtils().clickOnElement(systemActionDropdownLocator);
        By systemActionOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(systemActionOptionLocator);
        return this;
    }

    @Step("Select Available Actions")
    public P08_SystemTriggersAdminPage selectAvailableActions() {
        LogsUtils.info("Selecting Available Actions");
        driver.elementUtils().clickOnElement(availableActionsDropdownLocator);
        By availableActionsOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(availableActionsOptionLocator);
        return this;
    }

    @Step("Click on Save button")
    public P08_SystemTriggersAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Cancel button")
    public P08_SystemTriggersAdminPage clickOnCancelButton() {
        LogsUtils.info("Clicking on Cancel button");
        driver.elementUtils().clickOnElement(cancelButtonLocator);
        return this;
    }

    @Step("Search for System Trigger by name")
    public P08_SystemTriggersAdminPage searchForSystemTriggerByName(String name) {
        LogsUtils.info("Searching for System Trigger by name: " + name);
        driver.elementUtils().sendDataToElement(systemTriggerNameSearchFieldLocator, name);
        return this;
    }

    @Step("Click on Edit button")
    public P08_SystemTriggersAdminPage clickOnEditButton(String systemTriggerName) {
        LogsUtils.info("Clicking on Edit button for System Trigger: " + systemTriggerName);
        By editButtonLocator = By.xpath("//td[.='" + systemTriggerName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P08_SystemTriggersAdminPage clickOnDeleteButton(String systemTriggerName) {
        LogsUtils.info("Clicking on Delete button for System Trigger: " + systemTriggerName);
        By deleteButtonLocator = By.xpath("//td[.='" + systemTriggerName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P08_SystemTriggersAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Assert visibility of System Trigger Added Alert")
    public void assertVisibilityOfSystemTriggerAddedAlert() {
        LogsUtils.info("Asserting visibility of System Trigger Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(systemTriggerAddedMessageLocator),
                "System Trigger added alert not visible"
        );
    }

    @Step("Assert visibility of System Trigger Edited Alert")
    public void assertVisibilityOfSystemTriggerEditedAlert() {
        LogsUtils.info("Asserting visibility of System Trigger Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(systemTriggerEditedMessageLocator),
                "System Trigger edited alert not visible"
        );
    }

    @Step("Assert visibility of System Trigger Deleted Alert")
    public void assertVisibilityOfSystemTriggerDeletedAlert() {
        LogsUtils.info("Asserting visibility of System Trigger Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(systemTriggerDeletedMessageLocator),
                "System Trigger deleted alert not visible"
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

    @Step("Assert visibility of empty message type field message")
    public void assertVisibilityOfEmptyMessageTypeFieldMessage() {
        LogsUtils.info("Asserting visibility of empty message type field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyMessageTypeFieldMessageLocator),
                "Empty message type field message not visible"
        );
    }

    @Step("Assert visibility of empty order status field message")
    public void assertVisibilityOfEmptyOrderStatusFieldMessage() {
        LogsUtils.info("Asserting visibility of empty order status field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyOrderStatusFieldMessageLocator),
                "Empty order status field message not visible"
        );
    }

    @Step("Assert visibility of empty order control field message")
    public void assertVisibilityOfEmptyOrderControlFieldMessage() {
        LogsUtils.info("Asserting visibility of empty order control field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyOrderControlFieldMessageLocator),
                "Empty order control field message not visible"
        );
    }

    @Step("Assert visibility of empty system action field message")
    public void assertVisibilityOfEmptySystemActionFieldMessage() {
        LogsUtils.info("Asserting visibility of empty system action field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySystemActionFieldMessageLocator),
                "Empty system action field message not visible"
        );
    }

    @Step("Assert visibility of empty available actions field message")
    public void assertVisibilityOfEmptyAvailableActionsFieldMessage() {
        LogsUtils.info("Asserting visibility of empty available actions field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyAvailableActionsFieldMessageLocator),
                "Empty available actions field message not visible"
        );
    }
}
