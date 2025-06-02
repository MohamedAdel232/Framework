package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P04_StudyPriorityAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new study priority\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By hl7ValueTextFieldLocator = By.cssSelector("[formcontrolname=\"hl7Value\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By cancelButtonLocator = By.cssSelector("[title=\"Cancel\"]");
    private final By studyPriorityNameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By studyPriorityAddedMessageLocator = By.cssSelector("[aria-label=\"New study priority has been added successfully\"]");
    private final By studyPriorityEditedMessageLocator = By.cssSelector("[aria-label=\"Selected study priority has been updated successfully\"]");
    private final By studyPriorityDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected study priority has been deleted successfully\"]");
    private final By emptyNameFieldMessageLocator = By.cssSelector("[aria-label='Study priority name cannot be empty or contain spaces only, please enter a valid name']");
    private final By emptyHL7ValueFieldMessageLocator = By.cssSelector("[aria-label='Study priority HL7 value cannot be empty or contain spaces only, please enter a valid HL7 value']");

    private final DriverFactory driver;

    public P04_StudyPriorityAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add Study Priority button")
    public P04_StudyPriorityAdminPage clickOnAddStudyPriorityButton() {
        LogsUtils.info("Clicking on Add button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter Study Priority name")
    public P04_StudyPriorityAdminPage enterStudyPriorityName(String name) {
        LogsUtils.info("Entering Study Priority name: " + name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Enter Study Priority HL7 Value")
    public P04_StudyPriorityAdminPage enterStudyPriorityHL7Value(String hl7Value) {
        LogsUtils.info("Entering Study Priority HL7 Value: " + hl7Value);
        driver.elementUtils().sendDataToElement(hl7ValueTextFieldLocator, hl7Value);
        return this;
    }

    @Step("Click on Save button")
    public P04_StudyPriorityAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Cancel button")
    public P04_StudyPriorityAdminPage clickOnCancelButton() {
        LogsUtils.info("Clicking on Cancel button");
        driver.elementUtils().clickOnElement(cancelButtonLocator);
        return this;
    }

    @Step("Search for Study Priority by name")
    public P04_StudyPriorityAdminPage searchForStudyPriorityByName(String name) {
        LogsUtils.info("Searching for Study Priority by name: " + name);
        driver.elementUtils().sendDataToElement(studyPriorityNameSearchFieldLocator, name);
        return this;
    }

    @Step("Click on Edit button")
    public P04_StudyPriorityAdminPage clickOnEditButton(String studyPriorityName) {
        LogsUtils.info("Clicking on Edit button for Study Priority: " + studyPriorityName);
        By editButtonLocator = By.xpath("//td[.='" + studyPriorityName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P04_StudyPriorityAdminPage clickOnDeleteButton(String studyPriorityName) {
        LogsUtils.info("Clicking on Delete button for Study Priority: " + studyPriorityName);
        By deleteButtonLocator = By.xpath("//td[.='" + studyPriorityName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P04_StudyPriorityAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Assert visibility of Study Priority Added Alert")
    public void assertVisibilityOfStudyPriorityAddedAlert() {
        LogsUtils.info("Asserting visibility of Study Priority Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(studyPriorityAddedMessageLocator),
                "Study Priority added alert not visible"
        );
    }

    @Step("Assert visibility of Study Priority Edited Alert")
    public void assertVisibilityOfStudyPriorityEditedAlert() {
        LogsUtils.info("Asserting visibility of Study Priority Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(studyPriorityEditedMessageLocator),
                "Study Priority edited alert not visible"
        );
    }

    @Step("Assert visibility of Study Priority Deleted Alert")
    public void assertVisibilityOfStudyPriorityDeletedAlert() {
        LogsUtils.info("Asserting visibility of Study Priority Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(studyPriorityDeletedMessageLocator),
                "Study Priority deleted alert not visible"
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