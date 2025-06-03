package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P16_ProcedureGroupsAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new procedure group\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By procedureCheckboxLocator = By.xpath("(//input[@aria-label=\"Select Row\"])[1]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By cancelButtonLocator = By.cssSelector("[title=\"Back\"]");
    private final By nameSearchFieldLocator = By.cssSelector("input[aria-label=\"Procedure Group Filter\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By procedureGroupAddedMessageLocator = By.cssSelector("[aria-label=\"Procedure group has been added successfully\"]");
    private final By procedureGroupEditedMessageLocator = By.cssSelector("[aria-label=\"Procedure group has been updated successfully\"]");
    private final By procedureGroupDeletedMessageLocator = By.cssSelector("[aria-label=\"Procedure group deleted successfully\"]");
    private final By emptyNameFieldMessageLocator = By.cssSelector("[aria-label='Procedure Group name cannot be empty or contain spaces only. Please enter a valid name']");
    private final By emptyProcedureMessageLocator = By.cssSelector("[aria-label='Please add at least one procedure to the procedure group']");

    private final DriverFactory driver;

    public P16_ProcedureGroupsAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add Procedure Group button")
    public P16_ProcedureGroupsAdminPage clickOnAddProcedureGroupButton() {
        LogsUtils.info("Clicking on Add button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter Procedure Group Name")
    public P16_ProcedureGroupsAdminPage enterProcedureGroupName(String name) {
        LogsUtils.info("Entering Procedure Group Name: " + name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Select Procedure Checkbox")
    public P16_ProcedureGroupsAdminPage selectProcedureCheckbox() {
        LogsUtils.info("Selecting Procedure Checkbox");
        driver.elementUtils().clickOnElement(procedureCheckboxLocator);
        return this;
    }

    @Step("Click on Save button")
    public P16_ProcedureGroupsAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Cancel button")
    public P16_ProcedureGroupsAdminPage clickOnCancelButton() {
        LogsUtils.info("Clicking on Cancel button");
        driver.elementUtils().clickOnElement(cancelButtonLocator);
        return this;
    }

    @Step("Search for Procedure Group")
    public P16_ProcedureGroupsAdminPage searchForProcedureGroup(String name) {
        LogsUtils.info("Searching for Procedure Group: " + name);
        driver.elementUtils().sendDataToElement(nameSearchFieldLocator, name);
        return this;
    }

    @Step("Click on Edit button")
    public P16_ProcedureGroupsAdminPage clickOnEditButton(String name) throws InterruptedException {
        LogsUtils.info("Clicking on Edit button for Procedure Group: " + name);
        Thread.sleep(500);
        By editButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P16_ProcedureGroupsAdminPage clickOnDeleteButton(String name) throws InterruptedException {
        LogsUtils.info("Clicking on Delete button for Procedure Group: " + name);
        Thread.sleep(500);
        By deleteButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P16_ProcedureGroupsAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Assert visibility of Procedure Group Added Alert")
    public void assertVisibilityOfProcedureGroupAddedAlert() {
        LogsUtils.info("Asserting visibility of Procedure Group Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(procedureGroupAddedMessageLocator),
                "Procedure Group added alert not visible"
        );
    }

    @Step("Assert visibility of Procedure Group Edited Alert")
    public void assertVisibilityOfProcedureGroupEditedAlert() {
        LogsUtils.info("Asserting visibility of Procedure Group Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(procedureGroupEditedMessageLocator),
                "Procedure Group edited alert not visible"
        );
    }

    @Step("Assert visibility of Procedure Group Deleted Alert")
    public void assertVisibilityOfProcedureGroupDeletedAlert() {
        LogsUtils.info("Asserting visibility of Procedure Group Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(procedureGroupDeletedMessageLocator),
                "Procedure Group deleted alert not visible"
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

    @Step("Assert visibility of empty procedure message")
    public void assertVisibilityOfEmptyProcedureMessage() {
        LogsUtils.info("Asserting visibility of empty procedure message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyProcedureMessageLocator),
                "Empty procedure message not visible"
        );
    }
} 