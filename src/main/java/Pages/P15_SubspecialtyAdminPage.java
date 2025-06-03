package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P15_SubspecialtyAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new subspecialty\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By filterRowSettingsDropdownLocator = By.cssSelector("kendo-dropdownlist[textfield=\"title\"]");
    private final By operatorDropdownLocator = By.cssSelector("[aria-label=\"operator\"]");
    private final By codeDropdownLocator = By.cssSelector("[valuefield=\"code\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By cancelButtonLocator = By.cssSelector("[title=\"Back\"]");
    private final By nameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By subspecialtyAddedMessageLocator = By.cssSelector("[aria-label=\"New subspecialty has been added successfully\"]");
    private final By subspecialtyEditedMessageLocator = By.cssSelector("[aria-label=\"Selected subspecialty has been updated successfully\"]");
    private final By subspecialtyDeletedMessageLocator = By.cssSelector("[aria-label=\"The selected subspecialty has associated records and cannot be deleted\"]");
    private final By emptyNameFieldMessageLocator = By.cssSelector("[aria-label='Subspecialty name cannot be empty or contain spaces only. Please enter a valid name']");
    private final By emptyParameterMessageLocator = By.cssSelector("[aria-label='At least one parameter must be configured for the subspecialty']");

    private final DriverFactory driver;

    public P15_SubspecialtyAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add Subspecialty button")
    public P15_SubspecialtyAdminPage clickOnAddSubspecialtyButton() {
        LogsUtils.info("Clicking on Add button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter Subspecialty Name")
    public P15_SubspecialtyAdminPage enterSubspecialtyName(String name) {
        LogsUtils.info("Entering Subspecialty Name: " + name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Select Filter Row Settings")
    public P15_SubspecialtyAdminPage selectFilterRowSettings() {
        LogsUtils.info("Selecting Filter Row Settings");
        driver.elementUtils().clickOnElement(filterRowSettingsDropdownLocator);
        By filterRowSettingsOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(filterRowSettingsOptionLocator);
        return this;
    }

    @Step("Select Operator")
    public P15_SubspecialtyAdminPage selectOperator() {
        LogsUtils.info("Selecting Operator");
        driver.elementUtils().clickOnElement(operatorDropdownLocator);
        By operatorOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(operatorOptionLocator);
        return this;
    }

    @Step("Select Code")
    public P15_SubspecialtyAdminPage selectCode() {
        LogsUtils.info("Selecting Code");
        driver.elementUtils().clickOnElement(codeDropdownLocator);
        By codeOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(codeOptionLocator);
        return this;
    }

    @Step("Click on Save button")
    public P15_SubspecialtyAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Cancel button")
    public P15_SubspecialtyAdminPage clickOnCancelButton() {
        LogsUtils.info("Clicking on Cancel button");
        driver.elementUtils().clickOnElement(cancelButtonLocator);
        return this;
    }

    @Step("Search for Subspecialty")
    public P15_SubspecialtyAdminPage searchForSubspecialty(String name) {
        LogsUtils.info("Searching for Subspecialty: " + name);
        driver.elementUtils().sendDataToElement(nameSearchFieldLocator, name);
        return this;
    }

    @Step("Click on Edit button")
    public P15_SubspecialtyAdminPage clickOnEditButton(String name) throws InterruptedException {
        LogsUtils.info("Clicking on Edit button for Subspecialty: " + name);
        Thread.sleep(500);
        By editButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P15_SubspecialtyAdminPage clickOnDeleteButton(String name) throws InterruptedException {
        LogsUtils.info("Clicking on Delete button for Subspecialty: " + name);
        Thread.sleep(500);
        By deleteButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P15_SubspecialtyAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Assert visibility of Subspecialty Added Alert")
    public void assertVisibilityOfSubspecialtyAddedAlert() {
        LogsUtils.info("Asserting visibility of Subspecialty Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(subspecialtyAddedMessageLocator),
                "Subspecialty added alert not visible"
        );
    }

    @Step("Assert visibility of Subspecialty Edited Alert")
    public void assertVisibilityOfSubspecialtyEditedAlert() {
        LogsUtils.info("Asserting visibility of Subspecialty Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(subspecialtyEditedMessageLocator),
                "Subspecialty edited alert not visible"
        );
    }

    @Step("Assert visibility of Subspecialty Deleted Alert")
    public void assertVisibilityOfSubspecialtyDeletedAlert() {
        LogsUtils.info("Asserting visibility of Subspecialty Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(subspecialtyDeletedMessageLocator),
                "Subspecialty deleted alert not visible"
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

    @Step("Assert visibility of empty parameter message")
    public void assertVisibilityOfEmptyParameterMessage() {
        LogsUtils.info("Asserting visibility of empty parameter message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyParameterMessageLocator),
                "Empty parameter message not visible"
        );
    }
} 