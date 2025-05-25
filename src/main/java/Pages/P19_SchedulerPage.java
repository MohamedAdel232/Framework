package Pages;

import Factories.DriverFactory;
import Utilities.DataBaseUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P19_SchedulerPage {
    private final By myMeetingsButtonLocator = By.cssSelector("[title=\"My Meetings\"]");
    private final By todayButtonLocator = By.cssSelector("[title=\"Today\"]");
    private final By addMeetingButtonLocator = By.cssSelector("[title=\"Add Meeting\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"title\"]");
    private final By scheduledStartDateTextFieldLocator = By.id("datetimepicker-1");
    private final By scheduledEndDateTextFieldLocator = By.id("datetimepicker-2");
    private final By locationTextFieldLocator = By.xpath("//kendo-autocomplete [@formcontrolname=\"room\"] //input");
    private final By subspecialtyDropdownLocator = By.cssSelector("[formcontrolname=\"specialtyId\"]");
    private final By studiesLimitDropdownLocator = By.cssSelector("[formcontrolname=\"studiesLimit\"]");
    private final By closureTimeTextFieldLocator = By.cssSelector("[formcontrolname=\"closureTime\"]");
    private final By restrictedCheckboxLocator = By.cssSelector("[formcontrolname=\"restricted\"]");
    private final By reminderTextFieldLocator = By.cssSelector("[formcontrolname=\"reminder\"]");
    private final By repetitionButtonLocator = By.cssSelector("[title=\"Enable\"]");
    private final By disableRepetitionButtonLocator = By.cssSelector("input[title=\"Disable\"]");
    private final By enableRepetitionCheckboxLocator = By.cssSelector("input[title=\"Enable\"]");
    private final By dailyButtonLocator = By.cssSelector("input[title=\"Daily\"]");
    private final By weeklyButtonLocator = By.cssSelector("input[title=\"Weekly\"]");
    private final By monthlyButtonLocator = By.cssSelector("input[title=\"Monthly\"]");
    private final By everyDaysButtonLocator = By.cssSelector("input[title=\"Every\"]");
    private final By daysToRepeatTextFieldLocator = By.cssSelector("[formcontrolname=\"interval\"]");
    private final By everyWorkdayButtonLocator = By.cssSelector("input[title=\"Every workday\"]");
    private final By endAfterButtonLocator = By.cssSelector("input[title=\"End after\"]");
    private final By occurrencesCountTextFieldLocator = By.cssSelector("[formcontrolname=\"count\"]");
    private final By endByButtonLocator = By.cssSelector("input[title=\"End by\"]");
    private final By endByDateTextFieldLocator = By.cssSelector("[formcontrolname=\"endDate\"]");
    private final By saveRepetitionButtonLocator = By.xpath("(//button[@title=\"Save\"])[1]");
    private final By cancelRepetitionButtonLocator = By.xpath("[title=\"Cancel\"]");
    private final By meetingNotesTextFieldLocator = By.id("meetingNotesTextarea");
    private final By clinicianDropdownLocator = By.cssSelector("[placeholder=\"---Select Clinician(s)---\"]");
    private final By addClinicianButtonLocator = By.cssSelector("[title=\"Add Clinician\"]");
    private final By clinicianNameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By clinicianEmailTextFieldLocator = By.cssSelector("[formcontrolname=\"email\"]");
    private final By saveClinicianButtonLocator = By.xpath("(//button[@title=\"Save\"])[1]");
    private final By cancelClinicianButtonLocator = By.xpath("[title=\"Cancel\"]");
    private final By meetingLinkTextFieldLocator = By.cssSelector("[formcontrolname=\"until\"]");
    private final By addStudiesButtonLocator = By.cssSelector("[title=\"Add new Studies\"]");
    private final By acrCodeDropdownLocator = By.cssSelector("[formcontrolname=\"acrCode\"]");
    private final By searchForACRCodeTextFieldLocator = By.cssSelector("input[aria-label=\"Filter\"]");
    private final By studyTimeTextFieldLocator = By.cssSelector("[formcontrolname=\"studyTime\"]");
    private final By notesTextFieldLocator = By.cssSelector("[formcontrolname=\"notes\"]");
    private final By reportTextFieldLocator = By.className("ProseMirror");
    private final By addMeetingStudyButtonLocator = By.cssSelector("[title=\"Add\"]");
    private final By cancelMeetingStudyButtonLocator = By.xpath("button[title=\"Cancel\"]");
    private final By saveMeetingButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By meetingAddedMessageLocator = By.cssSelector("[aria-label=\"Meeting has been added successfully\"]");
    private final By meetingEditedMessageLocator = By.cssSelector("[aria-label=\"Meeting has been edited successfully\"]");
    private final By meetingDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected meeting has been deleted successfully\"]");
    private final By scheduledMeetingLocator = By.xpath("//div[@class=\"schEvent ng-star-inserted scheduled-Meeting\"]");
    private final By editMeetingButtonLocator = By.cssSelector("[aria-label=\"Edit\"]");
    private final By deleteMeetingButtonLocator = By.cssSelector("[aria-label=\"Delete\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");

    private final DriverFactory driver;

    public P19_SchedulerPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Delete all the meetings before starting the test")
    public P19_SchedulerPage deleteAllMeetings() {
        DataBaseUtils.configure("jdbc:postgresql://192.168.2.97:5432/icode-tfs", "postgres", "P@ssw0rd@Lotus");
        DataBaseUtils.executeUpdate("DELETE FROM meetingattendees\n" +
                "WHERE meetingid IN (\n" +
                "    SELECT id FROM meetings WHERE createdby = '620b6939-179b-4a16-9e1e-04b7a09dad6d'\n" +
                ");\n" +
                "\n" +
                "DELETE FROM meetingstudies\n" +
                "WHERE meetingid IN (\n" +
                "    SELECT id FROM meetings WHERE createdby = '620b6939-179b-4a16-9e1e-04b7a09dad6d'\n" +
                ");\n" +
                "\n" +
                "DELETE FROM meetings\n" +
                "WHERE createdby = '620b6939-179b-4a16-9e1e-04b7a09dad6d';\n");
        DataBaseUtils.closeConnection();
        return this;
    }

    @Step("Click on My Meetings button")
    public P19_SchedulerPage clickOnMyMeetingsButton() {
        driver.elementUtils().clickOnElement(myMeetingsButtonLocator);
        return this;
    }

    @Step("Click on Today button")
    public P19_SchedulerPage clickOnTodayButton() {
        driver.elementUtils().clickOnElement(todayButtonLocator);
        return this;
    }

    @Step("Click on Add Meeting button")
    public P19_SchedulerPage clickOnAddMeetingButton() {
        driver.elementUtils().clickOnElement(addMeetingButtonLocator);
        return this;
    }

    @Step("Enter meeting name")
    public P19_SchedulerPage enterMeetingName(String meetingName) {
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, meetingName);
        return this;
    }

    @Step("Enter scheduled start date")
    public P19_SchedulerPage enterScheduledStartDate(String startDate) {
        driver.elementUtils().sendDataToElement(scheduledStartDateTextFieldLocator, startDate);
        return this;
    }

    @Step("Enter scheduled end date")
    public P19_SchedulerPage enterScheduledEndDate(String endDate) {
        driver.elementUtils().sendDataToElement(scheduledEndDateTextFieldLocator, endDate);
        return this;
    }

    @Step("Enter location")
    public P19_SchedulerPage enterLocation(String location) {
        driver.elementUtils().sendDataToElement(locationTextFieldLocator, location);
        return this;
    }

    @Step("Select subspecialty")
    public P19_SchedulerPage selectSubspecialty() {
        driver.elementUtils().clickOnElement(subspecialtyDropdownLocator);
        By subspecialtyOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(subspecialtyOptionLocator);
        return this;
    }

    @Step("Click on Save meeting button")
    public P19_SchedulerPage clickOnSaveMeetingButton() {
        driver.elementUtils().clickOnElement(saveMeetingButtonLocator);
        return this;
    }

    @Step("Click on Add Studies button")
    public P19_SchedulerPage clickOnAddStudiesButton() {
        driver.elementUtils().clickOnElement(addStudiesButtonLocator);
        return this;
    }

    @Step("Select ACR code")
    public P19_SchedulerPage selectACRCode(String acrCode) {
        driver.elementUtils().clickOnElement(acrCodeDropdownLocator);
        driver.elementUtils().sendDataToElement(searchForACRCodeTextFieldLocator, acrCode);
        By acrCodeOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(acrCodeOptionLocator);
        return this;
    }

    @Step("Click on Add Meeting Study button")
    public P19_SchedulerPage clickOnAddMeetingStudyButton() {
        driver.elementUtils().clickOnElement(addMeetingStudyButtonLocator);
        return this;
    }

    @Step("Click on Edit Meeting button")
    public P19_SchedulerPage clickOnEditMeetingButton() {
        driver.elementUtils().rightClickOnElement(scheduledMeetingLocator);
        driver.elementUtils().clickOnElement(editMeetingButtonLocator);
        return this;
    }

    @Step("Click on Delete Meeting button")
    public P19_SchedulerPage clickOnDeleteMeetingButton() {
        driver.elementUtils().rightClickOnElement(scheduledMeetingLocator);
        driver.elementUtils().clickOnElement(deleteMeetingButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P19_SchedulerPage clickOnYesButton() {
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Verify Meeting added message")
    public void assertVisibilityOfMeetingAddedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(meetingAddedMessageLocator),
                "Meeting added alert not visible"
        );
    }

    @Step("Verify Meeting edited message")
    public void assertVisibilityOfMeetingEditedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(meetingEditedMessageLocator),
                "Meeting edited alert not visible"
        );
    }

    @Step("Verify Meeting deleted message")
    public void assertVisibilityOfMeetingDeletedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(meetingDeletedMessageLocator),
                "Meeting deleted alert not visible"
        );
    }
}
