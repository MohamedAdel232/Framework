package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P03_PatientTypeAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new patient type\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By hl7ValueTextFieldLocator = By.cssSelector("[formcontrolname=\"hl7Value\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By cancelButtonLocator = By.cssSelector("[title=\"Cancel\"]");
    private final By patientTypeNameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");

    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By patientTypeAddedMessageLocator = By.cssSelector("[aria-label=\"New patient type has been added successfully\"]");
    private final By patientTypeEditedMessageLocator = By.cssSelector("[aria-label=\"Selected patient type has been updated successfully\"]");
    private final By patientTypeDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected patient type has been deleted successfully\"]");
    private final By emptyNameFieldMessageLocator = By.cssSelector("[aria-label='Patient type name cannot be empty or contain spaces only, please enter a valid name']");
    private final By emptyHL7ValueFieldMessageLocator = By.cssSelector("[aria-label='Patient type HL7 value cannot be empty or contain spaces only, please enter a valid HL7 value']");

    private final DriverFactory driver;

    public P03_PatientTypeAdminPage(DriverFactory driver) {
        this.driver= driver;
    }

    @Step("Click on Add Patient Type button")
    public P03_PatientTypeAdminPage clickOnAddPatientTypeButton() {
        LogsUtils.info("Clicking on Add button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter Patient Type name")
    public P03_PatientTypeAdminPage enterPatientTypeName(String name) {
        LogsUtils.info("Entering Patient Type name: " + name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Enter Patient Type HL7 Value")
    public P03_PatientTypeAdminPage enterPatientTypeHL7Value(String hl7Value) {
        LogsUtils.info("Entering Patient Type HL7 Value: " + hl7Value);
        driver.elementUtils().sendDataToElement(hl7ValueTextFieldLocator, hl7Value);
        return this;
    }

    @Step("Click on Save button")
    public P03_PatientTypeAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Cancel button")
    public P03_PatientTypeAdminPage clickOnCancelButton() {
        LogsUtils.info("Clicking on Cancel button");
        driver.elementUtils().clickOnElement(cancelButtonLocator);
        return this;
    }

    @Step("Search for Patient Type by name")
    public P03_PatientTypeAdminPage searchForPatientTypeByName(String name) {
        LogsUtils.info("Searching for Patient Type by name: " + name);
        driver.elementUtils().sendDataToElement(patientTypeNameSearchFieldLocator, name);
        return this;
    }

    @Step("Click on Edit button")
    public P03_PatientTypeAdminPage clickOnEditButton(String patientTypeName) {
        LogsUtils.info("Clicking on Edit button for Active Directory: " + patientTypeName);
        By editButtonLocator = By.xpath("//td[.='" + patientTypeName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P03_PatientTypeAdminPage clickOnDeleteButton(String patientTypeName) {
        LogsUtils.info("Clicking on Delete button for Active Directory: " + patientTypeName);
        By deleteButtonLocator = By.xpath("//td[.='" + patientTypeName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P03_PatientTypeAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Assert visibility of Patient Type Added Alert")
    public void assertVisibilityOfPatientTypeAddedAlert() {
        LogsUtils.info("Asserting visibility of Patient Type Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(patientTypeAddedMessageLocator),
                "Patient Type added alert not visible"
        );
    }

    @Step("Assert visibility of Patient Type Edited Alert")
    public void assertVisibilityOfPatientTypeEditedAlert() {
        LogsUtils.info("Asserting visibility of Patient Type Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(patientTypeEditedMessageLocator),
                "Patient Type edited alert not visible"
        );
    }

    @Step("Assert visibility of Patient Type Deleted Alert")
    public void assertVisibilityOfPatientTypeDeletedAlert() {
        LogsUtils.info("Asserting visibility of Patient Type Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(patientTypeDeletedMessageLocator),
                "Patient Type deleted alert not visible"
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

    @Step("Assert visibility of empty HL7 value field message")
    public void assertVisibilityOfEmptyHL7ValueFieldMessage() {
        LogsUtils.info("Asserting visibility of empty HL7 value field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyHL7ValueFieldMessageLocator),
                "Empty HL7 value field message not visible"
        );
    }
}
