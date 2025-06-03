package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P02_UsersAdminPage {
    private final By generalConfigButtonLocator = By.xpath("//span[text()=\"General Configuration\"] /..");
    private final By worklistMappingButtonLocator = By.xpath("//span[text()=\"Worklist Mapping\"] /..");
    private final By patientTypeAdminButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/patienttype\"]");
    private final By studyPriorityAdminButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/studypriority\"]");
    private final By orderingLocationsAdminButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/orderinglocations\"]");
    private final By patientEligibilityAdminButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/patienteligibility\"]");
    private final By hl7ConfigurationButtonLocator = By.xpath("//span[text()=\" HL7 Configuration\"] /..");
    private final By systemSettingsButtonLocator = By.xpath("//span[text()=\"System Settings\"] /..");
    private final By hl7TriggersButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/hl7/triggers\"]");
    private final By systemTriggersButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/systemtriggers\"]");
    private final By modalityMappingButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/modalitymapping\"]");
    private final By cancellationReasonsButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/cancellationreasons\"]");
    private final By schedulingSuggestionsButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/schedulingsuggestions\"]");
    private final By sitesAdminButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/sites\"]");
    private final By protocolsButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/protocols\"]");
    private final By protocolGroupsButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/protocolgroups\"]");
    private final By foldersButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/folders\"]");
    private final By subspecialtyButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/subspecialty\"]");
    private final By procedureGroupsButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/proceduregroup\"]");

    private final By addButtonLocator = By.cssSelector("[title=\"Add new user\"]");
    private final By userRoleDropdownLocator = By.cssSelector("[formcontrolname=\"mainRole\"]");
    private final By usernameTextFieldLocator = By.cssSelector("[formcontrolname=\"username\"]");
    private final By fullNameTextFieldLocator = By.cssSelector("[formcontrolname=\"fullName\"]");
    private final By passwordTextFieldLocator = By.cssSelector("[formcontrolname=\"password\"]");
    private final By confirmPasswordTextFieldLocator = By.cssSelector("[formcontrolname=\"confirmPassword\"]");
    private final By emailTextFieldLocator = By.cssSelector("[formcontrolname=\"email\"]");
    private final By activeCheckboxLocator = By.cssSelector("input[title=\"Active\"]");
    private final By siteDropdownLocator = By.cssSelector("[formcontrolname=\"siteId\"]");
    private final By pacsUsernameTextFieldLocator = By.cssSelector("[formcontrolname=\"integrationUsername\"]");
    private final By risUserIDTextFieldLocator = By.cssSelector("[formcontrolname=\"integrationId\"]");
    private final By otherRolesDropdownLocator = By.cssSelector("[placeholder=\"---Select Other Role(s)---\"]");
    private final By subspecialtyDropdownLocator = By.cssSelector("[placeholder=\"---Select Subspecialty---\"]");
    private final By defaultSubspecialtyDropdownLocator = By.cssSelector("[formcontrolname=\"defaultSubspecialty\"]");
    private final By modalityDropdownLocator = By.cssSelector("[placeholder=\"---Select Modality---\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By cancelButtonLocator = By.cssSelector("[title=\"Back\"]");
    private final By searchFieldLocator = By.cssSelector("input[aria-label=\"Username Filter\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");

    private final By userAddedMessageLocator = By.cssSelector("[aria-label=\"User has been added successfully\"]");
    private final By userEditedMessageLocator = By.cssSelector("[aria-label=\"Selected user has been updated successfully\"]");
    private final By userDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected User has been deleted successfully\"]");

    private final DriverFactory driver;

    public P02_UsersAdminPage(DriverFactory driver){
        this.driver = driver;
    }

    @Step("Click on General Configuration button")
    public P02_UsersAdminPage clickOnGeneralConfigButton() {
        LogsUtils.info("Clicking on General Configuration button");
        driver.elementUtils().clickOnElement(generalConfigButtonLocator);
        return new P02_UsersAdminPage(driver);
    }

    @Step("Click on Worklist Mapping button")
    public P02_UsersAdminPage clickOnWorklistMappingButton() {
        LogsUtils.info("Clicking on Worklist Mapping button");
        driver.elementUtils().clickOnElement(worklistMappingButtonLocator);
        return new P02_UsersAdminPage(driver);
    }

    @Step("Click on Patient Type Admin button")
    public P03_PatientTypeAdminPage clickOnPatientTypeAdminButton() {
        LogsUtils.info("Clicking on Patient Type Admin button");
        driver.elementUtils().clickOnElement(patientTypeAdminButtonLocator);
        return new P03_PatientTypeAdminPage(driver);
    }

    @Step("Click on Study Priority Admin button")
    public P04_StudyPriorityAdminPage clickOnStudyPriorityAdminButton() {
        LogsUtils.info("Clicking on Study Priority Admin button");
        driver.elementUtils().clickOnElement(studyPriorityAdminButtonLocator);
        return new P04_StudyPriorityAdminPage(driver);
    }


    @Step("Click on Ordering Locations Admin button")
    public P05_OrderingLocationsAdminPage clickOnOrderingLocationsAdminButton() {
        LogsUtils.info("Clicking on Ordering Locations Admin button");
        driver.elementUtils().clickOnElement(orderingLocationsAdminButtonLocator);
        return new P05_OrderingLocationsAdminPage(driver);
    }

    @Step("Click on Patient Eligibility Admin button")
    public P06_PatientEligibilityAdminPage clickOnPatientEligibilityAdminButton() {
        LogsUtils.info("Clicking on Patient Eligibility Admin button");
        driver.elementUtils().clickOnElement(patientEligibilityAdminButtonLocator);
        return new P06_PatientEligibilityAdminPage(driver);
    }


    @Step("Click on HL7 Configuration button")
    public P02_UsersAdminPage clickOnHL7ConfigurationButton() {
        LogsUtils.info("Clicking on HL7 Configuration button");
        driver.elementUtils().clickOnElement(hl7ConfigurationButtonLocator);
        return new P02_UsersAdminPage(driver);
    }

    @Step("Click on System Settings button")
    public P02_UsersAdminPage clickOnSystemSettingsButton() {
        LogsUtils.info("Clicking on System Settings button");
        driver.elementUtils().clickOnElement(systemSettingsButtonLocator);
        return new P02_UsersAdminPage(driver);
    }

    @Step("Click on HL7 Triggers button")
    public P07_HL7TriggersAdminPage clickOnHL7TriggersButton() {
        LogsUtils.info("Clicking on HL7 Triggers button");
        driver.elementUtils().clickOnElement(hl7TriggersButtonLocator);
        return new P07_HL7TriggersAdminPage(driver);
    }

    @Step("Click on System Triggers button")
    public P08_SystemTriggersAdminPage clickOnSystemTriggersButton() {
        LogsUtils.info("Clicking on System Triggers button");
        driver.elementUtils().clickOnElement(systemTriggersButtonLocator);
        return new P08_SystemTriggersAdminPage(driver);
    }

    @Step("Click on Modality Mapping button")
    public P09_ModalityMappingAdminPage clickOnModalityMappingButton() {
        LogsUtils.info("Clicking on Modality Mapping button");
        driver.elementUtils().clickOnElement(modalityMappingButtonLocator);
        return new P09_ModalityMappingAdminPage(driver);
    }

    @Step("Click on Cancellation Reasons button")
    public P10_CancellationReasonsAdminPage clickOnCancellationReasonsButton() {
        LogsUtils.info("Clicking on Cancellation Reasons button");
        driver.elementUtils().clickOnElement(cancellationReasonsButtonLocator);
        return new P10_CancellationReasonsAdminPage(driver);
    }

    @Step("Click on Scheduling Suggestions button")
    public P11_SchedulingSuggestionsAdminPage clickOnSchedulingSuggestionsButton() {
        LogsUtils.info("Clicking on Scheduling Suggestions button");
        driver.elementUtils().clickOnElement(schedulingSuggestionsButtonLocator);
        return new P11_SchedulingSuggestionsAdminPage(driver);
    }

    @Step("Click on Sites")
    public P17_SitesAdminPage clickOnSitesButton() {
        LogsUtils.info("Clicking on General Configuration button");
        driver.elementUtils().clickOnElement(sitesAdminButtonLocator);
        return new P17_SitesAdminPage(driver);
    }

    @Step("Click on Protocols button")
    public P12_ProtocolsAdminPage clickOnProtocolsButton() {
        LogsUtils.info("Clicking on Protocols button");
        driver.elementUtils().clickOnElement(protocolsButtonLocator);
        return new P12_ProtocolsAdminPage(driver);
    }

    @Step("Click on Protocol Groups button")
    public P13_ProtocolGroupsAdminPage clickOnProtocolGroupsButton() {
        LogsUtils.info("Clicking on Protocol Groups button");
        driver.elementUtils().clickOnElement(protocolGroupsButtonLocator);
        return new P13_ProtocolGroupsAdminPage(driver);
    }

    @Step("Click on Folders button")
    public P14_FoldersAdminPage clickOnFoldersButton() {
        LogsUtils.info("Clicking on Folders button");
        driver.elementUtils().clickOnElement(foldersButtonLocator);
        return new P14_FoldersAdminPage(driver);
    }

    @Step("Click on Subspecialty button")
    public P15_SubspecialtyAdminPage clickOnSubspecialtyButton() {
        LogsUtils.info("Clicking on Subspecialty button");
        driver.elementUtils().clickOnElement(subspecialtyButtonLocator);
        return new P15_SubspecialtyAdminPage(driver);
    }

    @Step("Click on Procedure Groups button")
    public P16_ProcedureGroupsAdminPage clickOnProcedureGroupsButton() {
        LogsUtils.info("Clicking on Procedure Groups button");
        driver.elementUtils().clickOnElement(procedureGroupsButtonLocator);
        return new P16_ProcedureGroupsAdminPage(driver);
    }

    @Step("Click on Add User button")
    public P02_UsersAdminPage clickOnAddUserButton() {
        LogsUtils.info("Clicking on Add User button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Select User Role")
    public P02_UsersAdminPage selectUserRole(String role) {
        LogsUtils.info("Selecting User Role: " + role);
        driver.elementUtils().clickOnElement(userRoleDropdownLocator);
        By roleOptionLocator = By.xpath("//span [text()=\""+role+"\"]");
        driver.elementUtils().clickOnElement(roleOptionLocator);
        return this;
    }

    @Step("Enter Username")
    public P02_UsersAdminPage enterUsername(String username) {
        LogsUtils.info("Entering Username: " + username);
        driver.elementUtils().sendDataToElement(usernameTextFieldLocator, username);
        return this;
    }

    @Step("Enter Full Name")
    public P02_UsersAdminPage enterFullName(String fullName) {
        LogsUtils.info("Entering Full Name: " + fullName);
        driver.elementUtils().sendDataToElement(fullNameTextFieldLocator, fullName);
        return this;
    }

    @Step("Enter Password")
    public P02_UsersAdminPage enterPassword(String password) {
        LogsUtils.info("Entering Password");
        driver.elementUtils().sendDataToElement(passwordTextFieldLocator, password);
        return this;
    }

    @Step("Enter Confirm Password")
    public P02_UsersAdminPage enterConfirmPassword(String confirmPassword) {
        LogsUtils.info("Entering Confirm Password");
        driver.elementUtils().sendDataToElement(confirmPasswordTextFieldLocator, confirmPassword);
        return this;
    }

    @Step("Enter Email")
    public P02_UsersAdminPage enterEmail(String email) {
        LogsUtils.info("Entering Email: " + email);
        driver.elementUtils().sendDataToElement(emailTextFieldLocator, email);
        return this;
    }

    @Step("Check Active Checkbox")
    public P02_UsersAdminPage checkActiveCheckbox() {
        LogsUtils.info("Checking Active Checkbox");
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Select Site")
    public P02_UsersAdminPage selectSite() {
        LogsUtils.info("Selecting Site");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Enter PACS Username")
    public P02_UsersAdminPage enterPacsUsername(String pacsUsername) {
        LogsUtils.info("Entering PACS Username: " + pacsUsername);
        driver.elementUtils().sendDataToElement(pacsUsernameTextFieldLocator, pacsUsername);
        return this;
    }

    @Step("Enter RIS User ID")
    public P02_UsersAdminPage enterRisUserID(String risUserID) {
        LogsUtils.info("Entering RIS User ID: " + risUserID);
        driver.elementUtils().sendDataToElement(risUserIDTextFieldLocator, risUserID);
        return this;
    }

    @Step("Select Other Roles")
    public P02_UsersAdminPage selectOtherRoles() {
        LogsUtils.info("Selecting Other Role");
        driver.elementUtils().clickOnElement(otherRolesDropdownLocator);
        By otherRoleOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(otherRoleOptionLocator);
        return this;
    }

    @Step("Select Subspecialty")
    public P02_UsersAdminPage selectSubspecialty() {
        LogsUtils.info("Selecting Subspecialty");
        driver.elementUtils().clickOnElement(subspecialtyDropdownLocator);
        By subspecialtyOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(subspecialtyOptionLocator);
        return this;
    }

    @Step("Select Default Subspecialty")
    public P02_UsersAdminPage selectDefaultSubspecialty() {
        LogsUtils.info("Selecting Default Subspecialty");
        driver.elementUtils().clickOnElement(defaultSubspecialtyDropdownLocator);
        By defaultSubspecialtyOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(defaultSubspecialtyOptionLocator);
        return this;
    }

    @Step("Select Modality")
    public P02_UsersAdminPage selectModality() {
        LogsUtils.info("Selecting Modality");
        driver.elementUtils().clickOnElement(modalityDropdownLocator);
        By modalityOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(modalityOptionLocator);
        return this;
    }

    @Step("Click on Save button")
    public P02_UsersAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Cancel button")
    public P02_UsersAdminPage clickOnCancelButton() {
        LogsUtils.info("Clicking on Cancel button");
        driver.elementUtils().clickOnElement(cancelButtonLocator);
        return this;
    }

    @Step("Search User by Username")
    public P02_UsersAdminPage searchUserByUsername(String username) {
        LogsUtils.info("Searching User by Username: " + username);
        driver.elementUtils().sendDataToElement(searchFieldLocator, username);
        return this;
    }

    @Step("Click on Edit button")
    public P02_UsersAdminPage clickOnEditButton(String username) {
        LogsUtils.info("Clicking on Edit button for Username: " + username);
        By editButtonLocator = By.xpath("//td[.='" + username + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P02_UsersAdminPage clickOnDeleteButton(String username) throws InterruptedException {
        LogsUtils.info("Clicking on Delete button for Username: " + username);
        Thread.sleep(500);
        By deleteButtonLocator = By.xpath("//td[.='" + username + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P02_UsersAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Assert visibility of User Added Alert")
    public void assertVisibilityOfUserAddedAlert() {
        LogsUtils.info("Asserting visibility of User Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(userAddedMessageLocator),
                "User added alert not visible"
        );
    }

    @Step("Assert visibility of User Edited Alert")
    public void assertVisibilityOfUserEditedAlert() {
        LogsUtils.info("Asserting visibility of User Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(userEditedMessageLocator),
                "User edited alert not visible"
        );
    }

    @Step("Assert visibility of User Deleted Alert")
    public void assertVisibilityOfUserDeletedAlert() {
        LogsUtils.info("Asserting visibility of User Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(userDeletedMessageLocator),
                "User deleted alert not visible"
        );
    }


}
