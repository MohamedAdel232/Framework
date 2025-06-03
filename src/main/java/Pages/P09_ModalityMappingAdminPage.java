package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P09_ModalityMappingAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new modality mapping\"]");
    private final By procedureCodeTextFieldLocator = By.cssSelector("[formcontrolname=\"procedureCode\"]");
    private final By procedureDescriptionTextFieldLocator = By.cssSelector("[formcontrolname=\"procedureDescription\"]");
    private final By modalityDropdownLocator = By.cssSelector("[formcontrolname=\"modality\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By cancelButtonLocator = By.cssSelector("[title=\"Cancel\"]");
    private final By procedureCodeSearchFieldLocator = By.cssSelector("input[aria-label=\"Procedure Code Filter\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By modalityMappingAddedMessageLocator = By.cssSelector("[aria-label=\"New modality mapping has been added successfully\"]");
    private final By modalityMappingEditedMessageLocator = By.cssSelector("[aria-label=\"Selected modality mapping has been edited successfully\"]");
    private final By modalityMappingDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected modality mapping has been deleted successfully\"]");
    private final By emptyProcedureCodeFieldMessageLocator = By.cssSelector("[aria-label='Procedure code cannot be empty or contain spaces only']");
    private final By emptyProcedureDescriptionFieldMessageLocator = By.cssSelector("[aria-label='Procedure description cannot be empty or contain spaces only']");
    private final By emptyModalityFieldMessageLocator = By.cssSelector("[aria-label='Please select a modality']");

    private final DriverFactory driver;

    public P09_ModalityMappingAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add Modality Mapping button")
    public P09_ModalityMappingAdminPage clickOnAddModalityMappingButton() {
        LogsUtils.info("Clicking on Add button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter Procedure Code")
    public P09_ModalityMappingAdminPage enterProcedureCode(String procedureCode) {
        LogsUtils.info("Entering Procedure Code: " + procedureCode);
        driver.elementUtils().sendDataToElement(procedureCodeTextFieldLocator, procedureCode);
        return this;
    }

    @Step("Enter Procedure Description")
    public P09_ModalityMappingAdminPage enterProcedureDescription(String procedureDescription) {
        LogsUtils.info("Entering Procedure Description: " + procedureDescription);
        driver.elementUtils().sendDataToElement(procedureDescriptionTextFieldLocator, procedureDescription);
        return this;
    }

    @Step("Select Modality")
    public P09_ModalityMappingAdminPage selectModality() {
        LogsUtils.info("Selecting Modality");
        driver.elementUtils().clickOnElement(modalityDropdownLocator);
        By modalityOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(modalityOptionLocator);
        return this;
    }

    @Step("Click on Save button")
    public P09_ModalityMappingAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Cancel button")
    public P09_ModalityMappingAdminPage clickOnCancelButton() {
        LogsUtils.info("Clicking on Cancel button");
        driver.elementUtils().clickOnElement(cancelButtonLocator);
        return this;
    }

    @Step("Search for Modality Mapping by procedure code")
    public P09_ModalityMappingAdminPage searchForModalityMappingByProcedureCode(String procedureCode) {
        LogsUtils.info("Searching for Modality Mapping by procedure code: " + procedureCode);
        driver.elementUtils().sendDataToElement(procedureCodeSearchFieldLocator, procedureCode);
        return this;
    }

    @Step("Click on Edit button")
    public P09_ModalityMappingAdminPage clickOnEditButton(String procedureCode) {
        LogsUtils.info("Clicking on Edit button for Modality Mapping: " + procedureCode);
        By editButtonLocator = By.xpath("//td[.='" + procedureCode + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P09_ModalityMappingAdminPage clickOnDeleteButton(String procedureCode) {
        LogsUtils.info("Clicking on Delete button for Modality Mapping: " + procedureCode);
        By deleteButtonLocator = By.xpath("//td[.='" + procedureCode + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P09_ModalityMappingAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Assert visibility of Modality Mapping Added Alert")
    public void assertVisibilityOfModalityMappingAddedAlert() {
        LogsUtils.info("Asserting visibility of Modality Mapping Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(modalityMappingAddedMessageLocator),
                "Modality Mapping added alert not visible"
        );
    }

    @Step("Assert visibility of Modality Mapping Edited Alert")
    public void assertVisibilityOfModalityMappingEditedAlert() {
        LogsUtils.info("Asserting visibility of Modality Mapping Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(modalityMappingEditedMessageLocator),
                "Modality Mapping edited alert not visible"
        );
    }

    @Step("Assert visibility of Modality Mapping Deleted Alert")
    public void assertVisibilityOfModalityMappingDeletedAlert() {
        LogsUtils.info("Asserting visibility of Modality Mapping Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(modalityMappingDeletedMessageLocator),
                "Modality Mapping deleted alert not visible"
        );
    }

    @Step("Assert visibility of empty procedure code field message")
    public void assertVisibilityOfEmptyProcedureCodeFieldMessage() {
        LogsUtils.info("Asserting visibility of empty procedure code field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyProcedureCodeFieldMessageLocator),
                "Empty procedure code field message not visible"
        );
    }

    @Step("Assert visibility of empty procedure description field message")
    public void assertVisibilityOfEmptyProcedureDescriptionFieldMessage() {
        LogsUtils.info("Asserting visibility of empty procedure description field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyProcedureDescriptionFieldMessageLocator),
                "Empty procedure description field message not visible"
        );
    }

    @Step("Assert visibility of empty modality field message")
    public void assertVisibilityOfEmptyModalityFieldMessage() {
        LogsUtils.info("Asserting visibility of empty modality field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyModalityFieldMessageLocator),
                "Empty modality field message not visible"
        );
    }
} 