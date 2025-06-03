package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P14_FoldersAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new folder\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By subspecialtyDropdownLocator = By.cssSelector("[formcontrolname=\"subspeciality\"]");
    private final By setAsDefaultCheckboxLocator = By.cssSelector("input[title=\"Set as default\"]");
    private final By addSectionButtonLocator = By.xpath("(//button[@title=\"Add Section\"])[1]");
    private final By addParameterButtonLocator = By.xpath("(//button[@title=\"Add Parameter\"])[2]");
    private final By filterRowSettingsDropdownLocator = By.cssSelector("kendo-dropdownlist[textfield=\"title\"]");
    private final By operatorDropdownLocator = By.cssSelector("[aria-label=\"operator\"]");
    private final By codeDropdownLocator = By.cssSelector("[valuefield=\"code\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By cancelButtonLocator = By.cssSelector("[title=\"Back\"]");
    private final By nameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By folderAddedMessageLocator = By.cssSelector("[aria-label=\"New Folder has been added successfully\"]");
    private final By folderEditedMessageLocator = By.cssSelector("[aria-label=\"Selected Folder has been updated successfully\"]");
    private final By folderDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected Folder has been deleted successfully\"]");
    private final By emptyNameFieldMessageLocator = By.cssSelector("[aria-label='Folder name cannot be empty or contain spaces only. Please enter a valid name']");
    private final By emptySubspecialtyMessageLocator = By.cssSelector("[aria-label='Subspecialty is required, Please select subspecialty']");
    private final By emptyParameterMessageLocator = By.cssSelector("[aria-label='At least one parameter must be configured for the folder']");

    private final DriverFactory driver;

    public P14_FoldersAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add Folder button")
    public P14_FoldersAdminPage clickOnAddFolderButton() {
        LogsUtils.info("Clicking on Add button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter Folder Name")
    public P14_FoldersAdminPage enterFolderName(String name) {
        LogsUtils.info("Entering Folder Name: " + name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Select Subspecialty")
    public P14_FoldersAdminPage selectSubspecialty() {
        LogsUtils.info("Selecting Subspecialty");
        driver.elementUtils().clickOnElement(subspecialtyDropdownLocator);
        By subspecialtyOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(subspecialtyOptionLocator);
        return this;
    }

    @Step("Check Set as Default checkbox")
    public P14_FoldersAdminPage checkSetAsDefaultCheckbox() {
        LogsUtils.info("Checking Set as Default checkbox");
        driver.elementUtils().clickOnElement(setAsDefaultCheckboxLocator);
        return this;
    }

    @Step("Click on Add Section button")
    public P14_FoldersAdminPage clickOnAddSectionButton() {
        LogsUtils.info("Clicking on Add Section button");
        driver.elementUtils().clickOnElement(addSectionButtonLocator);
        return this;
    }

    @Step("Click on Add Parameter button")
    public P14_FoldersAdminPage clickOnAddParameterButton() {
        LogsUtils.info("Clicking on Add Parameter button");
        driver.elementUtils().clickOnElement(addParameterButtonLocator);
        return this;
    }

    @Step("Select Filter Row Settings")
    public P14_FoldersAdminPage selectFilterRowSettings() {
        LogsUtils.info("Selecting Filter Row Settings");
        driver.elementUtils().clickOnElement(filterRowSettingsDropdownLocator);
        By filterRowSettingsOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(filterRowSettingsOptionLocator);
        return this;
    }

    @Step("Select Operator")
    public P14_FoldersAdminPage selectOperator() {
        LogsUtils.info("Selecting Operator");
        driver.elementUtils().clickOnElement(operatorDropdownLocator);
        By operatorOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(operatorOptionLocator);
        return this;
    }

    @Step("Select Code")
    public P14_FoldersAdminPage selectCode() {
        LogsUtils.info("Selecting Code");
        driver.elementUtils().clickOnElement(codeDropdownLocator);
        By codeOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(codeOptionLocator);
        return this;
    }

    @Step("Click on Save button")
    public P14_FoldersAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Cancel button")
    public P14_FoldersAdminPage clickOnCancelButton() {
        LogsUtils.info("Clicking on Cancel button");
        driver.elementUtils().clickOnElement(cancelButtonLocator);
        return this;
    }

    @Step("Search for Folder")
    public P14_FoldersAdminPage searchForFolder(String name) {
        LogsUtils.info("Searching for Folder: " + name);
        driver.elementUtils().sendDataToElement(nameSearchFieldLocator, name);
        return this;
    }

    @Step("Click on Edit button")
    public P14_FoldersAdminPage clickOnEditButton(String name) throws InterruptedException {
        LogsUtils.info("Clicking on Edit button for Folder: " + name);
        Thread.sleep(500);
        By editButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P14_FoldersAdminPage clickOnDeleteButton(String name) throws InterruptedException {
        LogsUtils.info("Clicking on Delete button for Folder: " + name);
        Thread.sleep(500);
        By deleteButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P14_FoldersAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Assert visibility of Folder Added Alert")
    public void assertVisibilityOfFolderAddedAlert() {
        LogsUtils.info("Asserting visibility of Folder Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(folderAddedMessageLocator),
                "Folder added alert not visible"
        );
    }

    @Step("Assert visibility of Folder Edited Alert")
    public void assertVisibilityOfFolderEditedAlert() {
        LogsUtils.info("Asserting visibility of Folder Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(folderEditedMessageLocator),
                "Folder edited alert not visible"
        );
    }

    @Step("Assert visibility of Folder Deleted Alert")
    public void assertVisibilityOfFolderDeletedAlert() {
        LogsUtils.info("Asserting visibility of Folder Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(folderDeletedMessageLocator),
                "Folder deleted alert not visible"
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

    @Step("Assert visibility of empty subspecialty message")
    public void assertVisibilityOfEmptySubspecialtyMessage() {
        LogsUtils.info("Asserting visibility of empty subspecialty message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySubspecialtyMessageLocator),
                "Empty subspecialty message not visible"
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