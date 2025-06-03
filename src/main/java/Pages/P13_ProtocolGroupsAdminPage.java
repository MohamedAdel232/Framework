package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P13_ProtocolGroupsAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new protocol group\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By activeCheckboxLocator = By.cssSelector("[formcontrolname=\"status\"]");
    private final By addSectionButtonLocator = By.xpath("(//button[@title=\"Add Section\"])[1]");
    private final By addParameterButtonLocator = By.xpath("(//button[@title=\"Add Parameter\"])[2]");
    private final By filterRowSettingsDropdownLocator = By.cssSelector("kendo-dropdownlist[textfield=\"title\"]");
    private final By operatorDropdownLocator = By.cssSelector("[aria-label=\"operator\"]");
    private final By codeDropdownLocator = By.cssSelector("[valuefield=\"code\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By cancelButtonLocator = By.cssSelector("[title=\"Cancel\"]");
    private final By nameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By protocolGroupAddedMessageLocator = By.cssSelector("[aria-label=\"New protocol group has been added successfully\"]");
    private final By protocolGroupEditedMessageLocator = By.cssSelector("[aria-label=\"Selected protocol group has been updated successfully\"]");
    private final By protocolGroupDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected protocol group has been deleted successfully\"]");
    private final By emptyNameFieldMessageLocator = By.cssSelector("[aria-label='Protocol group name cannot be empty or contain spaces only. Please enter a valid name']");

    private final DriverFactory driver;

    public P13_ProtocolGroupsAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add Protocol Group button")
    public P13_ProtocolGroupsAdminPage clickOnAddProtocolGroupButton() {
        LogsUtils.info("Clicking on Add button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter Protocol Group Name")
    public P13_ProtocolGroupsAdminPage enterProtocolGroupName(String name) {
        LogsUtils.info("Entering Protocol Group Name: " + name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Check Active checkbox")
    public P13_ProtocolGroupsAdminPage checkActiveCheckbox() {
        LogsUtils.info("Checking Active checkbox");
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Add Section button")
    public P13_ProtocolGroupsAdminPage clickOnAddSectionButton() {
        LogsUtils.info("Clicking on Add Section button");
        driver.elementUtils().clickOnElement(addSectionButtonLocator);
        return this;
    }

    @Step("Click on Add Parameter button")
    public P13_ProtocolGroupsAdminPage clickOnAddParameterButton() {
        LogsUtils.info("Clicking on Add Parameter button");
        driver.elementUtils().clickOnElement(addParameterButtonLocator);
        return this;
    }

    @Step("Select Filter Row Settings")
    public P13_ProtocolGroupsAdminPage selectFilterRowSettings() {
        LogsUtils.info("Selecting Filter Row Settings");
        driver.elementUtils().clickOnElement(filterRowSettingsDropdownLocator);
        By filterRowSettingsOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(filterRowSettingsOptionLocator);
        return this;
    }

    @Step("Select Operator")
    public P13_ProtocolGroupsAdminPage selectOperator() {
        LogsUtils.info("Selecting Operator");
        driver.elementUtils().clickOnElement(operatorDropdownLocator);
        By operatorOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(operatorOptionLocator);
        return this;
    }

    @Step("Select Code")
    public P13_ProtocolGroupsAdminPage selectCode() {
        LogsUtils.info("Selecting Code");
        driver.elementUtils().clickOnElement(codeDropdownLocator);
        By codeOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(codeOptionLocator);
        return this;
    }

    @Step("Click on Save button")
    public P13_ProtocolGroupsAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Cancel button")
    public P13_ProtocolGroupsAdminPage clickOnCancelButton() {
        LogsUtils.info("Clicking on Cancel button");
        driver.elementUtils().clickOnElement(cancelButtonLocator);
        return this;
    }

    @Step("Search for Protocol Group")
    public P13_ProtocolGroupsAdminPage searchForProtocolGroup(String name) {
        LogsUtils.info("Searching for Protocol Group: " + name);
        driver.elementUtils().sendDataToElement(nameSearchFieldLocator, name);
        return this;
    }

    @Step("Click on Edit button")
    public P13_ProtocolGroupsAdminPage clickOnEditButton(String name) throws InterruptedException {
        LogsUtils.info("Clicking on Edit button for Protocol Group: " + name);
        Thread.sleep(500);
        By editButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P13_ProtocolGroupsAdminPage clickOnDeleteButton(String name) throws InterruptedException {
        LogsUtils.info("Clicking on Delete button for Protocol Group: " + name);
        Thread.sleep(500);
        By deleteButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P13_ProtocolGroupsAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Assert visibility of Protocol Group Added Alert")
    public void assertVisibilityOfProtocolGroupAddedAlert() {
        LogsUtils.info("Asserting visibility of Protocol Group Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(protocolGroupAddedMessageLocator),
                "Protocol Group added alert not visible"
        );
    }

    @Step("Assert visibility of Protocol Group Edited Alert")
    public void assertVisibilityOfProtocolGroupEditedAlert() {
        LogsUtils.info("Asserting visibility of Protocol Group Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(protocolGroupEditedMessageLocator),
                "Protocol Group edited alert not visible"
        );
    }

    @Step("Assert visibility of Protocol Group Deleted Alert")
    public void assertVisibilityOfProtocolGroupDeletedAlert() {
        LogsUtils.info("Asserting visibility of Protocol Group Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(protocolGroupDeletedMessageLocator),
                "Protocol Group deleted alert not visible"
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
} 