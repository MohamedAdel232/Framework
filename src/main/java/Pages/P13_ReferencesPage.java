package Pages;

import Factories.DriverFactory;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public class P13_ReferencesPage {
    private final By newButtonLocator = By.cssSelector("[title=\"Add new reference\"]");
    private final By titleTextFieldLocator = By.cssSelector("[formcontrolname=\"title\"]");
    private final By anatomyDropdownLocator = By.cssSelector("[formcontrolname=\"anatomyId\"]");
    private final By subspecialtyDropdownLocator = By.cssSelector("[formcontrolname=\"specialityId\"]");
    private final By selectFilesButtonLocator = By.cssSelector("[type=\"file\"]");
    private final By notesTextFieldLocator = By.cssSelector("[formcontrolname=\"note\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By editButtonLocator = By.cssSelector("[title=\"Edit reference\"]");
    private final By deleteButtonLocator = By.cssSelector("[title=\"Delete the selected reference(s)\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By scheduleButtonLocator = By.cssSelector("[title=\"Add the selected reference(s) to a meeting\"]");
    private final By addToMeetingButtonLocator = By.cssSelector("[title=\"Move to Meeting\"]");
    private final By scheduledMeetingLocator = By.xpath("(//td [@class=\"k-scheduler-cell ng-star-inserted\"] /.. /.. /.. /.. /.. //div //div[@class=\"schEvent available-Meeting ng-star-inserted\"])");
    private final By referenceAddedMessageLocator = By.cssSelector("[aria-label=\"Reference has been added successfully\"]");
    private final By referenceEditedMessageLocator = By.cssSelector("[aria-label=\"Selected reference has been edited successfully\"]");
    private final By referenceScheduledMessageLocator = By.cssSelector("[aria-label=\"The selected reference has been added successfully to the selected meeting\"]");
    private final By referenceDeletedMessageLocator = By.cssSelector("[aria-label=\"The selected reference has been deleted successfully\"]");

    private final DriverFactory driver;

    public P13_ReferencesPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on New button")
    public P13_ReferencesPage clickOnNewButton() {
        driver.elementUtils().clickOnElement(newButtonLocator);
        return this;
    }

    @Step("Enter title")
    public P13_ReferencesPage enterTitle(String title) {
        driver.elementUtils().sendDataToElement(titleTextFieldLocator, title);
        return this;
    }

    @Step("Select anatomy")
    public P13_ReferencesPage selectAnatomy() {
        driver.elementUtils().clickOnElement(anatomyDropdownLocator);
        By anatomyOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(anatomyOptionLocator);
        return this;
    }

    @Step("Select subspecialty")
    public P13_ReferencesPage selectSubspecialty() {
        driver.elementUtils().clickOnElement(subspecialtyDropdownLocator);
        By subspecialtyOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(subspecialtyOptionLocator);
        return this;
    }

    @Step("Upload a file")
    public P13_ReferencesPage uploadFile(String filePath) {
        driver.elementUtils().uploadFile(selectFilesButtonLocator, filePath);
        return this;
    }

    @Step("Enter notes")
    public P13_ReferencesPage enterNotes(String notes) {
        driver.elementUtils().sendDataToElement(notesTextFieldLocator, notes);
        return this;
    }

    @Step("Click on Save button")
    public P13_ReferencesPage clickOnSaveButton() {
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Check reference checkbox's")
    public P13_ReferencesPage checkReferenceCheckbox(String referenceTitle) {
        By checkboxLocator = RelativeLocator.with(By.cssSelector("[type=\"checkbox\"]"))
                .toLeftOf(By.xpath("//div[contains(text(), \"" + referenceTitle + "\")]"));
        driver.elementUtils().clickOnElement(checkboxLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P13_ReferencesPage clickOnEditButton() {
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P13_ReferencesPage clickOnDeleteButton() {
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P13_ReferencesPage clickOnYesButton() {
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on Schedule button")
    public P13_ReferencesPage clickOnScheduleButton() {
        driver.elementUtils().clickOnElement(scheduleButtonLocator);
        return this;
    }

    @Step("Select a scheduled meeting")
    public P13_ReferencesPage selectScheduledMeeting() {
        driver.elementUtils().clickOnElement(scheduledMeetingLocator);
        driver.elementUtils().clickOnElement(addToMeetingButtonLocator);
        return this;
    }


    @Step("Verify Reference added message")
    public void assertVisibilityOfReferenceAddedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(referenceAddedMessageLocator),
                "Reference added alert not visible"
        );
    }

    @Step("Verify Reference edited message")
    public void assertVisibilityOfReferenceEditedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(referenceEditedMessageLocator),
                "Reference edited alert not visible"
        );
    }

    @Step("Verify Reference scheduled message")
    public void assertVisibilityOfReferenceScheduledAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(referenceScheduledMessageLocator),
                "Reference scheduled alert not visible"
        );
    }

    @Step("Verify Reference deleted message")
    public void assertVisibilityOfReferenceDeletedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(referenceDeletedMessageLocator),
                "Reference deleted alert not visible"
        );
    }
}
