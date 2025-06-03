package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P12_ProtocolsAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new protocol\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By protocolGroupDropdownLocator = By.cssSelector("[formcontrolname=\"protocolGroupId\"]");
    private final By requiresCommentCheckboxLocator = By.cssSelector("[formcontrolname=\"requireComment\"]");
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
    private final By protocolAddedMessageLocator = By.cssSelector("[aria-label=\"New protocol has been added successfully\"]");
    private final By protocolEditedMessageLocator = By.cssSelector("[aria-label=\"Selected protocol has been updated successfully\"]");
    private final By protocolDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected protocol has been deleted successfully\"]");
    private final By emptyNameFieldMessageLocator = By.cssSelector("[aria-label='Protocol name cannot be empty or contain spaces only. Please enter a valid name']");
    private final By emptyProtocolGroupMessageLocator = By.cssSelector("[aria-label='Protocol group is required. Please select a protocol group']");

    private final DriverFactory driver;

    public P12_ProtocolsAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add Protocol button")
    public P12_ProtocolsAdminPage clickOnAddProtocolButton() {
        LogsUtils.info("Clicking on Add button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter Protocol Name")
    public P12_ProtocolsAdminPage enterProtocolName(String name) {
        LogsUtils.info("Entering Protocol Name: " + name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Select Protocol Group")
    public P12_ProtocolsAdminPage selectProtocolGroup() {
        LogsUtils.info("Selecting Protocol Group");
        driver.elementUtils().clickOnElement(protocolGroupDropdownLocator);
        By protocolGroupOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(protocolGroupOptionLocator);
        return this;
    }

    @Step("Check Requires Comment checkbox")
    public P12_ProtocolsAdminPage checkRequiresCommentCheckbox() {
        LogsUtils.info("Checking Requires Comment checkbox");
        driver.elementUtils().clickOnElement(requiresCommentCheckboxLocator);
        return this;
    }

    @Step("Check Active checkbox")
    public P12_ProtocolsAdminPage checkActiveCheckbox() {
        LogsUtils.info("Checking Active checkbox");
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Add Section button")
    public P12_ProtocolsAdminPage clickOnAddSectionButton() {
        LogsUtils.info("Clicking on Add Section button");
        driver.elementUtils().clickOnElement(addSectionButtonLocator);
        return this;
    }

    @Step("Click on Add Parameter button")
    public P12_ProtocolsAdminPage clickOnAddParameterButton() {
        LogsUtils.info("Clicking on Add Parameter button");
        driver.elementUtils().clickOnElement(addParameterButtonLocator);
        return this;
    }

    @Step("Select Filter Row Settings")
    public P12_ProtocolsAdminPage selectFilterRowSettings() {
        LogsUtils.info("Selecting Filter Row Settings");
        driver.elementUtils().clickOnElement(filterRowSettingsDropdownLocator);
        By filterRowSettingsOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(filterRowSettingsOptionLocator);
        return this;
    }

    @Step("Select Operator")
    public P12_ProtocolsAdminPage selectOperator() {
        LogsUtils.info("Selecting Operator");
        driver.elementUtils().clickOnElement(operatorDropdownLocator);
        By operatorOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(operatorOptionLocator);
        return this;
    }

    @Step("Select Code")
    public P12_ProtocolsAdminPage selectCode() {
        LogsUtils.info("Selecting Code");
        driver.elementUtils().clickOnElement(codeDropdownLocator);
        By codeOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(codeOptionLocator);
        return this;
    }

    @Step("Click on Save button")
    public P12_ProtocolsAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Cancel button")
    public P12_ProtocolsAdminPage clickOnCancelButton() {
        LogsUtils.info("Clicking on Cancel button");
        driver.elementUtils().clickOnElement(cancelButtonLocator);
        return this;
    }

    @Step("Search for Protocol")
    public P12_ProtocolsAdminPage searchForProtocol(String name) {
        LogsUtils.info("Searching for Protocol: " + name);
        driver.elementUtils().sendDataToElement(nameSearchFieldLocator, name);
        return this;
    }

    @Step("Click on Edit button")
    public P12_ProtocolsAdminPage clickOnEditButton(String name) throws InterruptedException {
        LogsUtils.info("Clicking on Edit button for Protocol: " + name);
        By editButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        Thread.sleep(500);
        return this;
    }

    @Step("Click on Delete button")
    public P12_ProtocolsAdminPage clickOnDeleteButton(String name) {
        LogsUtils.info("Clicking on Delete button for Protocol: " + name);
        By deleteButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P12_ProtocolsAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Assert visibility of Protocol Added Alert")
    public void assertVisibilityOfProtocolAddedAlert() {
        LogsUtils.info("Asserting visibility of Protocol Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(protocolAddedMessageLocator),
                "Protocol added alert not visible"
        );
    }

    @Step("Assert visibility of Protocol Edited Alert")
    public void assertVisibilityOfProtocolEditedAlert() {
        LogsUtils.info("Asserting visibility of Protocol Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(protocolEditedMessageLocator),
                "Protocol edited alert not visible"
        );
    }

    @Step("Assert visibility of Protocol Deleted Alert")
    public void assertVisibilityOfProtocolDeletedAlert() {
        LogsUtils.info("Asserting visibility of Protocol Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(protocolDeletedMessageLocator),
                "Protocol deleted alert not visible"
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

    @Step("Assert visibility of empty protocol group message")
    public void assertVisibilityOfEmptyProtocolGroupMessage() {
        LogsUtils.info("Asserting visibility of empty protocol group message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyProtocolGroupMessageLocator),
                "Empty protocol group message not visible"
        );
    }
} 