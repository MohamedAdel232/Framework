package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P06_PatientEligibilityAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new patient eligibility\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By hl7ValueTextFieldLocator = By.cssSelector("[formcontrolname=\"hl7Value\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By cancelButtonLocator = By.cssSelector("[title=\"Cancel\"]");
    private final By patientEligibilityNameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");

    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By patientEligibilityAddedMessageLocator = By.cssSelector("[aria-label=\"New patient eligibility has been added successfully\"]");
    private final By patientEligibilityEditedMessageLocator = By.cssSelector("[aria-label=\"Selected patient eligibility has been updated successfully\"]");
    private final By patientEligibilityDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected patient eligibility has been deleted successfully\"]");
    private final By emptyNameFieldMessageLocator = By.cssSelector("[aria-label='Patient eligibility name cannot be empty or contain spaces only, please enter a valid name']");
    private final By emptyHL7ValueFieldMessageLocator = By.cssSelector("[aria-label='Patient eligibility HL7 value cannot be empty or contain spaces only, please enter a valid HL7 value']");

    private final DriverFactory driver;

    public P06_PatientEligibilityAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add Patient Eligibility button")
    public P06_PatientEligibilityAdminPage clickOnAddPatientEligibilityButton() {
        LogsUtils.info("Clicking on Add button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter Patient Eligibility name")
    public P06_PatientEligibilityAdminPage enterPatientEligibilityName(String name) {
        LogsUtils.info("Entering Patient Eligibility name: " + name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Enter Patient Eligibility HL7 Value")
    public P06_PatientEligibilityAdminPage enterPatientEligibilityHL7Value(String hl7Value) {
        LogsUtils.info("Entering Patient Eligibility HL7 Value: " + hl7Value);
        driver.elementUtils().sendDataToElement(hl7ValueTextFieldLocator, hl7Value);
        return this;
    }

    @Step("Click on Save button")
    public P06_PatientEligibilityAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Cancel button")
    public P06_PatientEligibilityAdminPage clickOnCancelButton() {
        LogsUtils.info("Clicking on Cancel button");
        driver.elementUtils().clickOnElement(cancelButtonLocator);
        return this;
    }

    @Step("Search for Patient Eligibility by name")
    public P06_PatientEligibilityAdminPage searchForPatientEligibilityByName(String name) {
        LogsUtils.info("Searching for Patient Eligibility by name: " + name);
        driver.elementUtils().sendDataToElement(patientEligibilityNameSearchFieldLocator, name);
        return this;
    }

    @Step("Click on Edit button")
    public P06_PatientEligibilityAdminPage clickOnEditButton(String patientEligibilityName) {
        LogsUtils.info("Clicking on Edit button for Patient Eligibility: " + patientEligibilityName);
        By editButtonLocator = By.xpath("//td[.='" + patientEligibilityName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P06_PatientEligibilityAdminPage clickOnDeleteButton(String patientEligibilityName) {
        LogsUtils.info("Clicking on Delete button for Patient Eligibility: " + patientEligibilityName);
        By deleteButtonLocator = By.xpath("//td[.='" + patientEligibilityName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P06_PatientEligibilityAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Assert visibility of Patient Eligibility Added Alert")
    public void assertVisibilityOfPatientEligibilityAddedAlert() {
        LogsUtils.info("Asserting visibility of Patient Eligibility Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(patientEligibilityAddedMessageLocator),
                "Patient Eligibility added alert not visible"
        );
    }

    @Step("Assert visibility of Patient Eligibility Edited Alert")
    public void assertVisibilityOfPatientEligibilityEditedAlert() {
        LogsUtils.info("Asserting visibility of Patient Eligibility Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(patientEligibilityEditedMessageLocator),
                "Patient Eligibility edited alert not visible"
        );
    }

    @Step("Assert visibility of Patient Eligibility Deleted Alert")
    public void assertVisibilityOfPatientEligibilityDeletedAlert() {
        LogsUtils.info("Asserting visibility of Patient Eligibility Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(patientEligibilityDeletedMessageLocator),
                "Patient Eligibility deleted alert not visible"
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