package Pages;

import Factories.DriverFactory;
import Utilities.ClipboardUtils;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P15_ORUProfilesAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add ORU Profile\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By sitesDropdownLocator = By.cssSelector("[formcontrolname=\"sites\"]");
    private final By preliminaryTextFieldLocator = By.cssSelector("[formcontrolname=\"preliminary\"]");
    private final By finalTextFieldLocator = By.cssSelector("[formcontrolname=\"final\"]");
    private final By addendumTextFieldLocator = By.cssSelector("[formcontrolname=\"addendum\"]");

    private final By risSendingAppTextFieldLocator = By.cssSelector("[formcontrolname=\"sendingApplicationName\"]");
    private final By addNewAttributeButtonLocator = By.cssSelector("[title=\"New Attribute\"]");
    private final By nameAttributeDropdownLocator = By.cssSelector("[formcontrolname=\"attribute\"]");
    private final By keysCheckboxLocator = By.cssSelector("[formcontrolname=\"keys\"]");
    private final By multipleSegmentsCheckboxLocator = By.cssSelector("[formcontrolname=\"multipleValue\"]");
    private final By requiredCheckboxLocator = By.cssSelector("[formcontrolname=\"isRequired\"]");

    private final By segmentDropdownLocator = By.cssSelector("[formcontrolname=\"segment\"]");
    private final By fieldNoTextFieldLocator = By.cssSelector("[formcontrolname=\"fieldNo\"]");
    private final By repeatTextFieldLocator = By.cssSelector("[formcontrolname=\"repeated\"]");
    private final By componentTextFieldLocator = By.cssSelector("[formcontrolname=\"componentNo\"]");
    private final By subComponentTextFieldLocator = By.cssSelector("[formcontrolname=\"subComponentNo\"]");

    private final By keySegmentDropdownLocator = By.cssSelector("[formcontrolname=\"keySegment\"]");
    private final By keyFieldNoTextFieldLocator = By.cssSelector("[formcontrolname=\"keyFieldNo\"]");
    private final By keyRepeatTextFieldLocator = By.cssSelector("[formcontrolname=\"keyRepeated\"]");
    private final By keyComponentTextFieldLocator = By.cssSelector("[formcontrolname=\"keyComponentNo\"]");
    private final By keySubComponentTextFieldLocator = By.cssSelector("[formcontrolname=\"keySubComponentNo\"]");

    private final By saveORUAttributeButtonLocator = By.xpath("(//button [@title=\"Save\"])[1]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By yesButtonLocator = By.xpath("//button [.=\"Yes\"]");
    private final By backButtonLocator = By.cssSelector("[title=\"Back\"]");
    private final By cancelButtonLocator = By.cssSelector("[title=\"Cancel\"]");
    private final By okButtonLocator = By.xpath("//button[.=\"OK\"]");
    private final By searchForORUProfileTextFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");

    private final By oruProfileEditedMessageLocator = By.xpath("//p [.=\"ORU profile has been updated successfully\"]");

    private final By emptyNameFieldMessageLocator = By.xpath("//div [@class=\"text-invalid text-danger ng-star-inserted\"][.=\" Name is required \"]");
    private final By emptySiteFieldMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Please select at least one site \"]");
    private final By emptyPreliminaryFieldMessageLocator = By.xpath("//div [@class=\"text-invalid text-danger ng-star-inserted\"][.=\" Preliminary is required \"]");
    private final By emptyFinalFieldMessageLocator = By.xpath("//div [@class=\"text-invalid text-danger ng-star-inserted\"][.=\" Final is required \"]");
    private final By emptyAddendumFieldMessageLocator = By.xpath("//div [@class=\"text-invalid text-danger ng-star-inserted\"][.=\" Addendum is required \"]");
    private final By emptyRISSendingAppFieldMessageLocator = By.xpath("//div [@class=\"text-invalid text-danger ng-star-inserted\"][.=\" RIS Sending App is required \"]");

    private final By emptyAttributeNameFieldMessageLocator = By.xpath("//div [@class=\"text-invalid text-danger attr ng-star-inserted\"][.=\" Name is required \"]");
    private final By emptySegmentFieldMessageLocator = By.xpath("//div [@class=\"text-invalid text-danger\"][.=\" Segment is required \"]");
    private final By emptyFieldNoFieldMessageLocator = By.xpath("//div [@class=\"text-invalid text-danger ng-star-inserted\"][.=\" Field No.  is required \"]");
    private final By emptyRepeatFieldMessageLocator = By.xpath("//div [@class=\"text-invalid text-danger ng-star-inserted\"][.=\" Repeat  is required \"]");
    private final By emptyKeyRepeatFieldMessageLocator = By.xpath("//div [@class=\"text-invalid text-danger ng-star-inserted\"][.=\" Key Repeat  is required \"]");
    private final By emptyComponentFieldMessageLocator = By.xpath("//div [@class=\"text-invalid text-danger ng-star-inserted\"][.=\" Component No.  is required \"]");
    private final By emptySubComponentFieldMessageLocator = By.xpath("//div [@class=\"text-invalid text-danger ng-star-inserted\"][.=\" Sub-Component No.  is required \"]");

    private final DriverFactory driver;

    public P15_ORUProfilesAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add ORU Profile button")
    public P15_ORUProfilesAdminPage clickOnAddButton() {
        LogsUtils.info("Clicking on Add ORU Profile button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter ORU Profile name")
    public P15_ORUProfilesAdminPage enterORUProfileName(String name) {
        LogsUtils.info("Entering ORU Profile name: " + name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Select site")
    public P15_ORUProfilesAdminPage selectSite() {
        LogsUtils.info("Selecting site from dropdown");
        driver.elementUtils().clickOnElement(sitesDropdownLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Click on Site Dropdown")
    public P15_ORUProfilesAdminPage clickOnSiteDropdown() {
        LogsUtils.info("Clicking on Site Dropdown");
        driver.elementUtils().clickOnElement(sitesDropdownLocator);
        return this;
    }

    @Step("Enter preliminary")
    public P15_ORUProfilesAdminPage enterPreliminary(String preliminaryText) {
        LogsUtils.info("Entering preliminary text: " + preliminaryText);
        driver.elementUtils().sendDataToElement(preliminaryTextFieldLocator, preliminaryText);
        return this;
    }

    @Step("Enter final")
    public P15_ORUProfilesAdminPage enterFinal(String finalText) {
        LogsUtils.info("Entering final text: " + finalText);
        driver.elementUtils().sendDataToElement(finalTextFieldLocator, finalText);
        return this;
    }

    @Step("Enter addendum")
    public P15_ORUProfilesAdminPage enterAddendum(String addendumText) {
        LogsUtils.info("Entering addendum text: " + addendumText);
        driver.elementUtils().sendDataToElement(addendumTextFieldLocator, addendumText);
        return this;
    }

    @Step("Enter RIS Sending App")
    public P15_ORUProfilesAdminPage enterRISSendingApp(String risSendingApp) {
        LogsUtils.info("Entering RIS Sending App: " + risSendingApp);
        driver.elementUtils().sendDataToElement(risSendingAppTextFieldLocator, risSendingApp);
        return this;
    }

    @Step("Click on Add New Attribute button")
    public P15_ORUProfilesAdminPage clickOnAddNewAttributeButton() {
        LogsUtils.info("Clicking on Add New Attribute button");
        driver.elementUtils().clickOnElement(addNewAttributeButtonLocator);
        return this;
    }

    @Step("Select Name Attribute")
    public P15_ORUProfilesAdminPage selectNameAttribute(String nameAttribute) {
        LogsUtils.info("Selecting Name Attribute: " + nameAttribute);
        driver.elementUtils().clickOnElement(nameAttributeDropdownLocator);
        By nameAttributeOptionLocator = By.xpath("//span [text()=\"" + nameAttribute + "\"]");
        driver.elementUtils().scrollToElement(nameAttributeOptionLocator);
        driver.elementUtils().clickOnElement(nameAttributeOptionLocator);
        return this;
    }

    @Step("Click on Name Attribute dropdown")
    public P15_ORUProfilesAdminPage clickOnNameAttributeDropdown() {
        LogsUtils.info("Clicking on Name Attribute dropdown");
        driver.elementUtils().clickOnElement(nameAttributeDropdownLocator);
        return this;
    }

    @Step("Check Keys checkbox")
    public P15_ORUProfilesAdminPage checkKeysCheckbox() {
        LogsUtils.info("Checking Keys checkbox");
        driver.elementUtils().clickOnElement(keysCheckboxLocator);
        return this;
    }

    @Step("Check Multiple Segments checkbox")
    public P15_ORUProfilesAdminPage checkMultipleSegmentsCheckbox() {
        LogsUtils.info("Checking Multiple Segments checkbox");
        driver.elementUtils().clickOnElement(multipleSegmentsCheckboxLocator);
        return this;
    }

    @Step("Check Required checkbox")
    public P15_ORUProfilesAdminPage checkRequiredCheckbox() {
        LogsUtils.info("Checking Required checkbox");
        driver.elementUtils().clickOnElement(requiredCheckboxLocator);
        return this;
    }

    @Step("Select Segment")
    public P15_ORUProfilesAdminPage selectSegment() {
        LogsUtils.info("Selecting Segment from dropdown");
        driver.elementUtils().clickOnElement(segmentDropdownLocator);
        By segmentOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(segmentOptionLocator);
        return this;
    }

    @Step("Click on Segment Dropdown")
    public P15_ORUProfilesAdminPage clickOnSegmentDropdown() {
        LogsUtils.info("Clicking on Segment Dropdown");
        driver.elementUtils().clickOnElement(segmentDropdownLocator);
        return this;
    }

    @Step("Enter Field No")
    public P15_ORUProfilesAdminPage enterFieldNo(String fieldNo) {
        LogsUtils.info("Entering Field No: " + fieldNo);
        driver.elementUtils().clickOnElement(fieldNoTextFieldLocator);
        ClipboardUtils.copyToClipboard(fieldNo);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Enter Repeat")
    public P15_ORUProfilesAdminPage enterRepeat(String repeat) {
        LogsUtils.info("Entering Repeat: " + repeat);
        driver.elementUtils().clickOnElement(repeatTextFieldLocator);
        ClipboardUtils.copyToClipboard(repeat);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Enter Component")
    public P15_ORUProfilesAdminPage enterComponent(String component) {
        LogsUtils.info("Entering Component: " + component);
        driver.elementUtils().clickOnElement(componentTextFieldLocator);
        ClipboardUtils.copyToClipboard(component);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Enter Sub Component")
    public P15_ORUProfilesAdminPage enterSubComponent(String subComponent) {
        LogsUtils.info("Entering Sub Component: " + subComponent);
        driver.elementUtils().clickOnElement(subComponentTextFieldLocator);
        ClipboardUtils.copyToClipboard(subComponent);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Select Key Segment")
    public P15_ORUProfilesAdminPage selectKeySegment() {
        LogsUtils.info("Selecting Key Segment from dropdown");
        driver.elementUtils().clickOnElement(keySegmentDropdownLocator);
        By segmentOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(segmentOptionLocator);
        return this;
    }

    @Step("Click on Key Segment Dropdown")
    public P15_ORUProfilesAdminPage clickOnKeySegmentDropdown() {
        LogsUtils.info("Clicking on Key Segment Dropdown");
        driver.elementUtils().clickOnElement(keySegmentDropdownLocator);
        return this;
    }

    @Step("Enter Key Field No")
    public P15_ORUProfilesAdminPage enterKeyFieldNo(String fieldNo) {
        LogsUtils.info("Entering Key Field No: " + fieldNo);
        driver.elementUtils().clickOnElement(keyFieldNoTextFieldLocator);
        ClipboardUtils.copyToClipboard(fieldNo);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Enter Key Repeat")
    public P15_ORUProfilesAdminPage enterKeyRepeat(String repeat) {
        LogsUtils.info("Entering Key Repeat: " + repeat);
        driver.elementUtils().clickOnElement(keyRepeatTextFieldLocator);
        ClipboardUtils.copyToClipboard(repeat);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Enter Key Component")
    public P15_ORUProfilesAdminPage enterKeyComponent(String component) {
        LogsUtils.info("Entering Key Component: " + component);
        driver.elementUtils().clickOnElement(keyComponentTextFieldLocator);
        ClipboardUtils.copyToClipboard(component);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Enter Key Sub Component")
    public P15_ORUProfilesAdminPage enterKeySubComponent(String subComponent) {
        LogsUtils.info("Entering Key Sub Component: " + subComponent);
        driver.elementUtils().clickOnElement(keySubComponentTextFieldLocator);
        ClipboardUtils.copyToClipboard(subComponent);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Click on Save ORU Attribute button")
    public P15_ORUProfilesAdminPage clickOnSaveORUAttributeButton() {
        LogsUtils.info("Clicking on Save ORU Attribute button");
        driver.elementUtils().clickOnElement(saveORUAttributeButtonLocator);
        return this;
    }

    @Step("Click on Save button")
    public P15_ORUProfilesAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on OK Button")
    public P15_ORUProfilesAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK Button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Add ORU Attribute")
    public P15_ORUProfilesAdminPage addORUAttribute(String sendingFacility, String assignedPatientLocation, String sendingApplication,
                                                    String risPatientID, String hospitalPatientID, String nationalPatientID, String patientFirstName, String patientLastName
            , String birthDate, String gender, String accessionNumber, String reportingPhysicianFirstName, String reportingPhysicianLastName,
                                                    String reportText, String reportValueType, String fieldNo, String repeat, String component, String subComponent) {

        LogsUtils.info("Adding ORU Attribute");
        return this
                .selectNameAttribute(sendingFacility)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .clickOnSaveORUAttributeButton()

                .clickOnAddNewAttributeButton()
                .selectNameAttribute(assignedPatientLocation)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .clickOnSaveORUAttributeButton()

                .clickOnAddNewAttributeButton()
                .selectNameAttribute(sendingApplication)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .clickOnSaveORUAttributeButton()

                .clickOnAddNewAttributeButton()
                .selectNameAttribute(risPatientID)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .clickOnSaveORUAttributeButton()

                .clickOnAddNewAttributeButton()
                .selectNameAttribute(hospitalPatientID)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .clickOnSaveORUAttributeButton()

                .clickOnAddNewAttributeButton()
                .selectNameAttribute(nationalPatientID)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .clickOnSaveORUAttributeButton()

                .clickOnAddNewAttributeButton()
                .selectNameAttribute(patientFirstName)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .clickOnSaveORUAttributeButton()

                .clickOnAddNewAttributeButton()
                .selectNameAttribute(patientLastName)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .clickOnSaveORUAttributeButton()

                .clickOnAddNewAttributeButton()
                .selectNameAttribute(birthDate)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .clickOnSaveORUAttributeButton()

                .clickOnAddNewAttributeButton()
                .selectNameAttribute(gender)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .clickOnSaveORUAttributeButton()

                .clickOnAddNewAttributeButton()
                .selectNameAttribute(accessionNumber)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .clickOnSaveORUAttributeButton()

                .clickOnAddNewAttributeButton()
                .selectNameAttribute(reportingPhysicianFirstName)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .clickOnSaveORUAttributeButton()

                .clickOnAddNewAttributeButton()
                .selectNameAttribute(reportingPhysicianLastName)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .clickOnSaveORUAttributeButton()

                .clickOnAddNewAttributeButton()
                .selectNameAttribute(reportText)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .clickOnSaveORUAttributeButton()

                .clickOnAddNewAttributeButton()
                .selectNameAttribute(reportValueType)
                .checkKeysCheckbox()
                .checkMultipleSegmentsCheckbox()
                .checkRequiredCheckbox()
                .selectKeySegment()
                .enterKeyFieldNo(fieldNo)
                .enterKeyRepeat(repeat)
                .enterKeyComponent(component)
                .enterKeySubComponent(subComponent)
                .selectSegment()
                .enterFieldNo(fieldNo)
                .enterRepeat(repeat)
                .enterComponent(component)
                .enterSubComponent(subComponent)
                .clickOnSaveORUAttributeButton();
    }

    @Step("Search for ORU Profile by name")
    public P15_ORUProfilesAdminPage searchForORUProfile(String oruProfileName) {
        LogsUtils.info("Searching for ORU Profile by name: " + oruProfileName);
        driver.elementUtils().sendDataToElement(searchForORUProfileTextFieldLocator, oruProfileName);
        return this;
    }

    @Step("Click on Edit button")
    public P15_ORUProfilesAdminPage clickOnEditButton(String oruProfileName) {
        LogsUtils.info("Clicking on Edit button for ORU Profile: " + oruProfileName);
        By editButtonLocator = By.xpath("//td[.='" + oruProfileName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P15_ORUProfilesAdminPage clickOnDeleteButton(String oruProfileName) {
        LogsUtils.info("Clicking on Delete button for ORU Profile: " + oruProfileName);
        By deleteButtonLocator = By.xpath("//td[.='" + oruProfileName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P15_ORUProfilesAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes button to confirm action");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on Back button")
    public P15_ORUProfilesAdminPage clickOnBackButton() {
        LogsUtils.info("Clicking on Back button");
        driver.elementUtils().clickOnElement(backButtonLocator);
        return this;
    }

    @Step("Click on Cancel button")
    public P15_ORUProfilesAdminPage clickOnCancelButton() {
        LogsUtils.info("Clicking on Cancel button");
        driver.elementUtils().clickOnElement(cancelButtonLocator);
        return this;
    }

    @Step("Verify ORU Profile edited message")
    public void assertVisibilityOfORUProfileEditedAlert() {
        LogsUtils.info("Verifying ORU Profile edited alert visibility");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(oruProfileEditedMessageLocator),
                "ORU Profile edited alert not visible"
        );
    }

    @Step("Verify ORU Profile deleted message")
    public void assertVisibilityOfORUProfileDeletedAlert(String oruProfileName) {
        LogsUtils.info("Verifying visibility of ORU Profile deleted alert for: " + oruProfileName);
        By hl7NodeDeletedMessageLocator = By.xpath("//p [.='\"" + oruProfileName + "\" ORU profile has been deleted successfully']");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(hl7NodeDeletedMessageLocator),
                "ORU Profile deleted alert not visible"
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

    @Step("Assert visibility of empty site field message")
    public void assertVisibilityOfEmptySiteFieldMessage() {
        LogsUtils.info("Asserting visibility of empty site field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySiteFieldMessageLocator),
                "Empty site field message not visible"
        );
    }

    @Step("Assert visibility of empty preliminary field message")
    public void assertVisibilityOfEmptyPreliminaryFieldMessage() {
        LogsUtils.info("Asserting visibility of empty preliminary field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyPreliminaryFieldMessageLocator),
                "Empty preliminary field message not visible"
        );
    }

    @Step("Assert visibility of empty final field message")
    public void assertVisibilityOfEmptyFinalFieldMessage() {
        LogsUtils.info("Asserting visibility of empty final field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyFinalFieldMessageLocator),
                "Empty final field message not visible"
        );
    }

    @Step("Assert visibility of empty addendum field message")
    public void assertVisibilityOfEmptyAddendumFieldMessage() {
        LogsUtils.info("Asserting visibility of empty addendum field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyAddendumFieldMessageLocator),
                "Empty addendum field message not visible"
        );
    }

    @Step("Assert visibility of empty RIS sending app field message")
    public void assertVisibilityOfEmptyRISSendingAppFieldMessage() {
        LogsUtils.info("Asserting visibility of empty RIS sending app field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyRISSendingAppFieldMessageLocator),
                "Empty RIS sending app field message not visible"
        );
    }

    @Step("Assert visibility of empty attribute name field message")
    public void assertVisibilityOfEmptyAttributeNameFieldMessage() {
        LogsUtils.info("Asserting visibility of empty attribute name field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyAttributeNameFieldMessageLocator),
                "Empty attribute name field message not visible"
        );
    }

    @Step("Assert visibility of empty segment field message")
    public void assertVisibilityOfEmptySegmentFieldMessage() {
        LogsUtils.info("Asserting visibility of empty segment field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySegmentFieldMessageLocator),
                "Empty segment field message not visible"
        );
    }

    @Step("Assert visibility of empty field no field message")
    public void assertVisibilityOfEmptyFieldNoFieldMessage() {
        LogsUtils.info("Asserting visibility of empty field no field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyFieldNoFieldMessageLocator),
                "Empty field no field message not visible"
        );
    }

    @Step("Assert visibility of empty repeat field message")
    public void assertVisibilityOfEmptyRepeatFieldMessage() {
        LogsUtils.info("Asserting visibility of empty repeat field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyRepeatFieldMessageLocator),
                "Empty repeat field message not visible"
        );
    }

    @Step("Assert visibility of empty component field message")
    public void assertVisibilityOfEmptyComponentFieldMessage() {
        LogsUtils.info("Asserting visibility of empty component field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyComponentFieldMessageLocator),
                "Empty component field message not visible"
        );
    }

    @Step("Assert visibility of empty sub-component field message")
    public void assertVisibilityOfEmptySubComponentFieldMessage() {
        LogsUtils.info("Asserting visibility of empty sub-component field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySubComponentFieldMessageLocator),
                "Empty sub-component field message not visible"
        );
    }

    @Step("Assert visibility of empty key repeat field message")
    public void assertVisibilityOfEmptyKeyRepeatFieldMessage() {
        LogsUtils.info("Asserting visibility of empty key repeat field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyKeyRepeatFieldMessageLocator),
                "Empty key repeat field message not visible"
        );
    }
}
