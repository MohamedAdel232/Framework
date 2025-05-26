package Pages;

import Factories.DriverFactory;
import Utilities.ClipboardUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P20_ORUProfilesAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new ORU profile\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By sitesDropdownLocator = By.cssSelector("[formcontrolname=\"sites\"]");
    private final By preliminaryTextFieldLocator = By.cssSelector("[formcontrolname=\"preliminary\"]");
    private final By finalTextFieldLocator = By.cssSelector("[formcontrolname=\"final\"]");
    private final By addendumTextFieldLocator = By.cssSelector("[formcontrolname=\"addendum\"]");
    private final By patientIDCheckboxLocator = By.cssSelector("input[title=\"Patient ID\"]");
    private final By patientNameCheckboxLocator = By.cssSelector("input[title=\"Patient Name\"]");
    private final By accessionNumberCheckboxLocator = By.cssSelector("input[title=\"Accession Number\"]");
    private final By reportingPhysiciansCheckboxLocator = By.cssSelector("input[title=\"Reporting Physicians\"]");
    private final By risUserIDCheckboxLocator = By.cssSelector("input[title=\"RIS User ID\"]");
    private final By studyDateCheckboxLocator = By.cssSelector("input[title=\"Study Date\"]");
    private final By reportDateCheckboxLocator = By.cssSelector("input[title=\"Report Date\"]");
    private final By risSendingAppTextFieldLocator = By.cssSelector("[formcontrolname=\"risSendingApp\"]");
    private final By addNewAttributeButtonLocator = By.cssSelector("[title=\"Add new attribute\"]");
    private final By attributeNameSearchFieldLocator = By.cssSelector("input[role=\"searchbox\"]");
    private final By nameAttributeDropdownLocator = By.xpath("//kendo-dropdownlist [@formcontrolname=\"name\"]");
    private final By multipleSegmentsCheckboxLocator = By.cssSelector("input[title=\"Multiple Segments\"]");
    private final By requiredCheckboxLocator = By.cssSelector("input[title=\"Required\"]");
    private final By segmentDropdownLocator = By.cssSelector("[formcontrolname=\"segment\"]");
    private final By fieldNoTextFieldLocator = By.cssSelector("[formcontrolname=\"fieldNo\"]");
    private final By repeatTextFieldLocator = By.cssSelector("[formcontrolname=\"repeat\"]");
    private final By componentTextFieldLocator = By.cssSelector("[formcontrolname=\"component\"]");
    private final By subComponentTextFieldLocator = By.cssSelector("[formcontrolname=\"subComponent\"]");
    private final By saveORUAttributeButtonLocator = By.xpath("(//button [@title=\"Save\"])[1]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By searchForORUProfileTextFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By oruProfileAddedMessageLocator = By.cssSelector("[aria-label=\"ORU profile has been added successfully\"]");
    private final By oruProfileEditedMessageLocator = By.cssSelector("[aria-label=\"ORU profile has been edited successfully\"]");
    private final By oruProfileDeletedMessageLocator = By.xpath("//div[contains(text(), \"ORU profile has been deleted successfully\")]");

    private final DriverFactory driver;

    public P20_ORUProfilesAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add ORU Profile button")
    public P20_ORUProfilesAdminPage clickOnAddButton() {
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter ORU Profile name")
    public P20_ORUProfilesAdminPage enterORUProfileName(String name) {
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Select site")
    public P20_ORUProfilesAdminPage selectSite() {
        driver.elementUtils().clickOnElement(sitesDropdownLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Enter preliminary")
    public P20_ORUProfilesAdminPage enterPreliminary(String preliminaryText) {
        driver.elementUtils().sendDataToElement(preliminaryTextFieldLocator, preliminaryText);
        return this;
    }

    @Step("Enter final")
    public P20_ORUProfilesAdminPage enterFinal(String finalText) {
        driver.elementUtils().sendDataToElement(finalTextFieldLocator, finalText);
        return this;
    }

    @Step("Enter addendum")
    public P20_ORUProfilesAdminPage enterAddendum(String addendumText) {
        driver.elementUtils().sendDataToElement(addendumTextFieldLocator, addendumText);
        return this;
    }

    @Step("Check Patient ID checkbox")
    public P20_ORUProfilesAdminPage checkPatientIDCheckbox() {
        driver.elementUtils().clickOnElement(patientIDCheckboxLocator);
        return this;
    }

    @Step("Check Patient Name checkbox")
    public P20_ORUProfilesAdminPage checkPatientNameCheckbox() {
        driver.elementUtils().clickOnElement(patientNameCheckboxLocator);
        return this;
    }

    @Step("Check Accession Number checkbox")
    public P20_ORUProfilesAdminPage checkAccessionNumberCheckbox() {
        driver.elementUtils().clickOnElement(accessionNumberCheckboxLocator);
        return this;
    }

    @Step("Check Reporting Physicians checkbox")
    public P20_ORUProfilesAdminPage checkReportingPhysiciansCheckbox() {
        driver.elementUtils().clickOnElement(reportingPhysiciansCheckboxLocator);
        return this;
    }

    @Step("Check RIS User ID checkbox")
    public P20_ORUProfilesAdminPage checkRISUserIDCheckbox() {
        driver.elementUtils().clickOnElement(risUserIDCheckboxLocator);
        return this;
    }

    @Step("Check Study Date checkbox")
    public P20_ORUProfilesAdminPage checkStudyDateCheckbox() {
        driver.elementUtils().clickOnElement(studyDateCheckboxLocator);
        return this;
    }

    @Step("Check Report Date checkbox")
    public P20_ORUProfilesAdminPage checkReportDateCheckbox() {
        driver.elementUtils().clickOnElement(reportDateCheckboxLocator);
        return this;
    }

    @Step("Enter RIS Sending App")
    public P20_ORUProfilesAdminPage enterRISSendingApp(String risSendingApp) {
        driver.elementUtils().sendDataToElement(risSendingAppTextFieldLocator, risSendingApp);
        return this;
    }

    @Step("Click on Add New Attribute button")
    public P20_ORUProfilesAdminPage clickOnAddNewAttributeButton() {
        driver.elementUtils().clickOnElement(addNewAttributeButtonLocator);
        return this;
    }

    @Step("Select Name Attribute")
    public P20_ORUProfilesAdminPage selectNameAttribute(String nameAttribute) {
        driver.elementUtils().clickOnElement(nameAttributeDropdownLocator);
        searchAttributeByName(nameAttribute);
        By nameAttributeOptionLocator = By.xpath("//span [text()=\"" + nameAttribute + "\"]");
        driver.elementUtils().clickOnElement(nameAttributeOptionLocator);
        return this;
    }

    @Step("Check Multiple Segments checkbox")
    public P20_ORUProfilesAdminPage checkMultipleSegmentsCheckbox() {
        driver.elementUtils().clickOnElement(multipleSegmentsCheckboxLocator);
        return this;
    }

    @Step("Check Required checkbox")
    public P20_ORUProfilesAdminPage checkRequiredCheckbox() {
        driver.elementUtils().clickOnElement(requiredCheckboxLocator);
        return this;
    }

    @Step("Select Segment")
    public P20_ORUProfilesAdminPage selectSegment() {
        driver.elementUtils().clickOnElement(segmentDropdownLocator);
        By segmentOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(segmentOptionLocator);
        return this;
    }

    @Step("Enter Field No")
    public P20_ORUProfilesAdminPage enterFieldNo(String fieldNo) {
        driver.elementUtils().clickOnElement(fieldNoTextFieldLocator);
        ClipboardUtils.copyToClipboard(fieldNo);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Enter Repeat")
    public P20_ORUProfilesAdminPage enterRepeat(String repeat) {
        driver.elementUtils().clickOnElement(repeatTextFieldLocator);
        ClipboardUtils.copyToClipboard(repeat);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Enter Component")
    public P20_ORUProfilesAdminPage enterComponent(String component) {
        driver.elementUtils().clickOnElement(componentTextFieldLocator);
        ClipboardUtils.copyToClipboard(component);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Enter Sub Component")
    public P20_ORUProfilesAdminPage enterSubComponent(String subComponent) {
        driver.elementUtils().clickOnElement(subComponentTextFieldLocator);
        ClipboardUtils.copyToClipboard(subComponent);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Click on Save ORU Attribute button")
    public P20_ORUProfilesAdminPage clickOnSaveORUAttributeButton() {
        driver.elementUtils().clickOnElement(saveORUAttributeButtonLocator);
        return this;
    }

    @Step("Click on Save button")
    public P20_ORUProfilesAdminPage clickOnSaveButton() {
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Search for Attribute by name")
    public P20_ORUProfilesAdminPage searchAttributeByName(String attributeName) {
        driver.elementUtils().sendDataToElement(attributeNameSearchFieldLocator, attributeName);
        return this;
    }

    @Step("Add ORU Attribute")
    public P20_ORUProfilesAdminPage addORUAttribute(String accessionNumber, String reportDate, String reportStatus, String fieldNo, String repeat, String component, String subComponent) {
        return this
                .selectNameAttribute(accessionNumber)
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .clickOnSaveORUAttributeButton()
                .clickOnAddNewAttributeButton()
                .selectNameAttribute(reportDate)
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .clickOnSaveORUAttributeButton()
                .clickOnAddNewAttributeButton()
                .selectNameAttribute(reportStatus)
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent);
    }

    @Step("Search for ORU Profile by name")
    public P20_ORUProfilesAdminPage searchForORUProfile(String oruProfileName) {
        driver.elementUtils().sendDataToElement(searchForORUProfileTextFieldLocator, oruProfileName);
        return this;
    }

    @Step("Click on Edit button")
    public P20_ORUProfilesAdminPage clickOnEditButton(String oruProfileName) {
        By editButtonLocator = By.xpath("//td[.='" + oruProfileName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P20_ORUProfilesAdminPage clickOnDeleteButton(String oruProfileName) {
        By deleteButtonLocator = By.xpath("//td[.='" + oruProfileName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P20_ORUProfilesAdminPage clickOnYesButton() {
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Verify ORU Profile added message")
    public void assertVisibilityOfORUProfileAddedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(oruProfileAddedMessageLocator),
                "ORU Profile added alert not visible"
        );
    }

    @Step("Verify ORU Profile edited message")
    public void assertVisibilityOfORUProfileEditedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(oruProfileEditedMessageLocator),
                "ORU Profile edited alert not visible"
        );
    }

    @Step("Verify ORU Profile deleted message")
    public void assertVisibilityOfORUProfileDeletedAlert(String oruProfileName) {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(oruProfileDeletedMessageLocator),
                "ORU Profile deleted alert not visible"
        );
    }
}
