package Pages;

import Factories.DriverFactory;
import Utilities.DataBaseUtils;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

public class P02_UsersAdminPage {
    private final By sitesButtonLocator = By.cssSelector("[routerlink=\"/admin/sites\"]");
    private final By groupsButtonLocator = By.cssSelector("[routerlink=\"/admin/groups\"]");
    private final By specialtiesButtonLocator = By.cssSelector("[routerlink=\"/admin/specialties\"]");
    private final By configurationsButtonLocator = By.xpath("//span[.=\"Configurations\"] /..");
    private final By pacsServersButtonLocator = By.cssSelector("[routerlink=\"/admin/pacsservers\"]");
    private final By activeDirectoriesButtonLocator = By.cssSelector("[routerlink=\"/admin/activedirectories\"]");
    private final By webConferencingToolsButtonLocator = By.cssSelector("[routerlink=\"/admin/webconferencingtools\"]");
    private final By hl7ConfigurationsButtonLocator = By.xpath("//span[.=\"HL7 Configurations\"] /..");
    private final By hl7NodesButtonLocator = By.cssSelector("[routerlink=\"/admin/hl7nodes\"]");
    private final By pacsViewersButtonLocator = By.cssSelector("[routerlink=\"/admin/pacsviewers\"]");
    private final By thirdPartyApplicationsButtonLocator = By.cssSelector("[routerlink=\"/admin/3rdpartyapplications\"]");
    private final By destinationsButtonLocator = By.cssSelector("[routerlink=\"/admin/destinations\"]");
    private final By emailSettingsButtonLocator = By.xpath("//span[.=\"Email Settings\"] /..");
    private final By emailServersButtonLocator = By.cssSelector("[routerlink=\"/admin/emailservers\"]");
    private final By emailTemplateManagerButtonLocator = By.cssSelector("[routerlink=\"/admin/emailtemplates\"]");
    private final By oruProfilesButtonLocator = By.cssSelector("[routerlink=\"/admin/oruprofiles\"]");

    private final By addButtonLocator = By.cssSelector("[title=\"Add new user\"]");
    private final By userRoleDropdownLocator = By.cssSelector("[formcontrolname=\"userRole\"]");
    private final By usernameTextFieldLocator = By.cssSelector("[formcontrolname=\"username\"]");
    private final By fullNameTextFieldLocator = By.cssSelector("[formcontrolname=\"fullName\"]");
    private final By passwordTextFieldLocator = By.cssSelector("[formcontrolname=\"password\"]");
    private final By confirmPasswordTextFieldLocator = By.cssSelector("[formcontrolname=\"confirmPassword\"]");
    private final By emailTextFieldLocator = By.cssSelector("[formcontrolname=\"email\"]");
    private final By activeCheckboxLocator = By.cssSelector("[title=\"Active User\"]");
    private final By siteDropdownLocator = By.cssSelector("[formcontrolname=\"siteId\"]");
    private final By regionalAccessCheckboxLocator = By.cssSelector("[formcontrolname=\"regionalAccess\"]");
    private final By pacsUsernameTextFieldLocator = By.cssSelector("[formcontrolname=\"pacsUsername\"]");
    private final By risUserIDTextFieldLocator = By.cssSelector("[formcontrolname=\"risUserID\"]");
    private final By msTeamsIDTextFieldLocator = By.cssSelector("[formcontrolname=\"msTeamsId\"]");
    private final By mdtCoordinatorCheckboxLocator = By.cssSelector("[formcontrolname=\"msTeamsId\"]");
    private final By groupDropdownLocator = By.cssSelector("[formcontrolname=\"groupId\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By backButtonLocator = By.cssSelector("[title=\"Back\"]");
    private final By usernameSearchFieldLocator = By.cssSelector("input[aria-label=\"Username Filter\"]");
    private final By yesButtonLocator = By.xpath("//button[.=\"Yes\"]");
    private final By okButtonLocator = By.xpath("//button[.=\"OK\"]");

    private final By userEditedMessageLocator = By.xpath("//p [.=\"User has been updated successfully\"]");
    private final By userDeletedMessageLocator = By.xpath("//p [.=\"Selected user has been deleted successfully\"]");

    private final By emptyUserRoleMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" User role is required \"]");

    private final By emptyUsernameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Username is required \"]");
    private final By spacesOnlyUsernameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Username cannot be less than three characters \"]");
    private final By lessThanThreeCharacterUsernameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Username cannot be less than three characters \"]");
    private final By noSpacesUsernameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Username cannot contain white spaces \"]");

    private final By emptyFullNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Full name is required \"]");
    private final By spacesOnlyFullNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Full name cannot contain white spaces only \"]");

    private final By emptyPasswordMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Password is required \"]");
    private final By invalidPasswordMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Password must be at least 6 characters long and include a mix of upper and lower case letters, numbers, and special characters \"]");

    private final By emptyConfirmPasswordMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Confirm password is required \"]");
    private final By passwordMismatchMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Passwords must match \"]");

    private final By emptyEmailMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Email is required \"]");
    private final By npSpacesEmailMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Email cannot contain white spaces \"]");
    private final By invalidEmailMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Email is invalid \"]");

    private final By emptySiteMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Site is required \"]");

    private final By emptyPACSUsernameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" PACS username is required \"]");
    private final By noSpacesPACSUsernameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" PACS username cannot contain white spaces \"]");

    private final By emptyRISUserIDMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" RIS User ID is required \"]");
    private final By noSpacesRISUserIDMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" RIS User ID cannot contain white spaces \"]");

    private final By emptyGroupMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Group is required \"]");

    private final DriverFactory driver;

    public P02_UsersAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Sites button")
    public P03_SitesAdminPage clickOnSitesButton() {
        LogsUtils.info("Clicking on Sites button");
        driver.elementUtils().clickOnElement(sitesButtonLocator);
        return new P03_SitesAdminPage(driver);
    }

    @Step("Click on Groups button")
    public P04_GroupsAdminPage clickOnGroupsButton() {
        LogsUtils.info("Clicking on Groups button");
        driver.elementUtils().clickOnElement(groupsButtonLocator);
        return new P04_GroupsAdminPage(driver);
    }

    @Step("Click on Specialties button")
    public P05_SpecialtiesAdminPage clickOnSpecialtiesButton() {
        LogsUtils.info("Clicking on Specialties button");
        driver.elementUtils().clickOnElement(specialtiesButtonLocator);
        return new P05_SpecialtiesAdminPage(driver);
    }

    @Step("Click on Configurations button")
    public P02_UsersAdminPage clickOnConfigurationsButton() {
        LogsUtils.info("Clicking on Configurations button");
        driver.elementUtils().clickOnElement(configurationsButtonLocator);
        return new P02_UsersAdminPage(driver);
    }

    @Step("Click on PACS Servers button")
    public P06_PACSServersAdminPage clickOnPACSServersButton() {
        LogsUtils.info("Clicking on PACS Servers button");
        driver.elementUtils().clickOnElement(pacsServersButtonLocator);
        return new P06_PACSServersAdminPage(driver);
    }

    @Step("Click on Active Directories button")
    public P07_ActiveDirectoriesAdminPage clickOnActiveDirectoriesButton() {
        LogsUtils.info("Clicking on Active Directories button");
        driver.elementUtils().clickOnElement(activeDirectoriesButtonLocator);
        return new P07_ActiveDirectoriesAdminPage(driver);
    }

    @Step("Click on Web Conferencing Tools button")
    public P08_WebConferencingToolsAdminPage clickOnWebConferencingToolsButton() {
        LogsUtils.info("Clicking on Web Conferencing Tools button");
        driver.elementUtils().clickOnElement(webConferencingToolsButtonLocator);
        return new P08_WebConferencingToolsAdminPage(driver);
    }

    @Step("Click on HL7 Configurations button")
    public P02_UsersAdminPage clickOnHL7ConfigurationsButton() {
        LogsUtils.info("Clicking on HL7 Configurations button");
        driver.elementUtils().clickOnElement(hl7ConfigurationsButtonLocator);
        return new P02_UsersAdminPage(driver);
    }

    @Step("Click on HL7 Nodes button")
    public P09_HL7NodesAdminPage clickOnHL7NodesButton() {
        LogsUtils.info("Clicking on HL7 Nodes button");
        driver.elementUtils().clickOnElement(hl7NodesButtonLocator);
        return new P09_HL7NodesAdminPage(driver);
    }

    @Step("Click on PACS Viewers button")
    public P10_PACSViewersAdminPage clickOnPACSViewersButton() {
        LogsUtils.info("Clicking on PACS Viewers button");
        driver.elementUtils().clickOnElement(pacsViewersButtonLocator);
        return new P10_PACSViewersAdminPage(driver);

    }

    @Step("Click on Third Party Applications button")
    public P11_ThirdPartyApplicationsAdminPage clickOnThirdPartyApplicationsButton() {
        LogsUtils.info("Clicking on Third Party Application button");
        driver.elementUtils().clickOnElement(thirdPartyApplicationsButtonLocator);
        return new P11_ThirdPartyApplicationsAdminPage(driver);
    }

    @Step("Click on Destinations button")
    public P12_DestinationsAdminPage clickOnDestinationsButton() {
        LogsUtils.info("Clicking on Destinations button");
        driver.elementUtils().clickOnElement(destinationsButtonLocator);
        return new P12_DestinationsAdminPage(driver);
    }

    @Step("Click on Email Settings button")
    public P02_UsersAdminPage clickOnEmailSettingsButton() {
        LogsUtils.info("Clicking on Email Settings button");
        driver.elementUtils().clickOnElement(emailSettingsButtonLocator);
        return new P02_UsersAdminPage(driver);
    }

    @Step("Click on Email Servers button")
    public P13_EmailServersAdminPage clickOnEmailServersButton() {
        LogsUtils.info("Clicking on Email Servers button");
        driver.elementUtils().clickOnElement(emailServersButtonLocator);
        return new P13_EmailServersAdminPage(driver);
    }

    @Step("Click on Email Template Manager button")
    public P14_EmailTemplateManagerAdminPage clickOnEmailTemplateManagerButton() {
        LogsUtils.info("Clicking on Email Template Manager button");
        driver.elementUtils().clickOnElement(emailTemplateManagerButtonLocator);
        return new P14_EmailTemplateManagerAdminPage(driver);
    }

    @Step("Click on ORU Profiles button")
    public P15_ORUProfilesAdminPage clickOnORUProfilesButton() {
        LogsUtils.info("Clicking on ORU Profiles button");
        driver.elementUtils().clickOnElement(oruProfilesButtonLocator);
        return new P15_ORUProfilesAdminPage(driver);
    }

    @Step("Click on Add User button")
    public P02_UsersAdminPage clickOnAddButton() {
        LogsUtils.info("Clicking on Add User button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Select User Role")
    public P02_UsersAdminPage selectUserRole(String userRole) {
        LogsUtils.info("Selecting User Role from dropdown");
        driver.elementUtils().clickOnElement(userRoleDropdownLocator);
        By userRoleOptionLocator = By.xpath("//li [.=\" " + userRole + " \"]");
        driver.elementUtils().clickOnElement(userRoleOptionLocator);
        return this;
    }

    @Step("Click on User Role Dropdown")
    public P02_UsersAdminPage clickOnUserRoleDropdown() {
        LogsUtils.info("Clicking on User Role Dropdown");
        driver.elementUtils().clickOnElement(userRoleDropdownLocator);
        return this;
    }

    @Step("Enter Username")
    public P02_UsersAdminPage enterUsername(String Username) {
        LogsUtils.info("Entering Username: " + Username);
        driver.elementUtils().sendDataToElement(usernameTextFieldLocator, Username);
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
        LogsUtils.info("Entering Password: " + password);
        driver.elementUtils().sendDataToElement(passwordTextFieldLocator, password);
        return this;
    }

    @Step("Enter Confirm Password")
    public P02_UsersAdminPage enterConfirmPassword(String confirmPassword) {
        LogsUtils.info("Entering Confirm Password: " + confirmPassword);
        driver.elementUtils().sendDataToElement(confirmPasswordTextFieldLocator, confirmPassword);
        return this;
    }

    @Step("Enter Email")
    public P02_UsersAdminPage enterEmail(String email) {
        LogsUtils.info("Entering Email: " + email);
        driver.elementUtils().sendDataToElement(emailTextFieldLocator, email);
        return this;
    }

    @Step("Click on Active Checkbox")
    public P02_UsersAdminPage clickOnActiveCheckbox() {
        LogsUtils.info("Clicking on Active Checkbox");
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Select site")
    public P02_UsersAdminPage selectSite(String site) {
        LogsUtils.info("Selecting site from dropdown");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        By siteOptionLocator = By.xpath("//li [.=\" " + site + " \"]");
        driver.elementUtils().scrollToElement(siteOptionLocator);
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Click on Site Dropdown")
    public P02_UsersAdminPage clickOnSiteDropdown() {
        LogsUtils.info("Clicking on Site Dropdown");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        return this;
    }

    @Step("Click on Regional Access Checkbox")
    public P02_UsersAdminPage clickOnRegionalAccessCheckbox() {
        LogsUtils.info("Clicking on Regional Access Checkbox");
        driver.elementUtils().clickOnElement(regionalAccessCheckboxLocator);
        return this;
    }

    @Step("Enter PACS Username")
    public P02_UsersAdminPage enterPACSUsername(String pacsUsername) {
        LogsUtils.info("Entering PACS Username: " + pacsUsername);
        driver.elementUtils().sendDataToElement(pacsUsernameTextFieldLocator, pacsUsername);
        return this;
    }

    @Step("Enter RIS User ID")
    public P02_UsersAdminPage enterRISUserID(String risUserID) {
        LogsUtils.info("Entering RIS User ID: " + risUserID);
        driver.elementUtils().sendDataToElement(risUserIDTextFieldLocator, risUserID);
        return this;
    }

    @Step("Enter MS Teams ID")
    public P02_UsersAdminPage enterMSTeamsID(String msTeamsID) {
        LogsUtils.info("Entering MS Teams ID: " + msTeamsID);
        driver.elementUtils().sendDataToElement(msTeamsIDTextFieldLocator, msTeamsID);
        return this;
    }

    @Step("Click on MDT Coordinator Checkbox")
    public P02_UsersAdminPage clickOnMDTCoordinatorCheckbox() {
        LogsUtils.info("Clicking on MDT Coordinator Checkbox");
        driver.elementUtils().clickOnElement(mdtCoordinatorCheckboxLocator);
        return this;
    }

    @Step("Select Group")
    public P02_UsersAdminPage selectGroup() {
        LogsUtils.info("Selecting group from dropdown");
        driver.elementUtils().clickOnElement(groupDropdownLocator);
        By groupOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(groupOptionLocator);
        return this;
    }

    @Step("Click on Group Dropdown")
    public P02_UsersAdminPage clickOnGroupDropdown() {
        LogsUtils.info("Clicking on Group Dropdown");
        driver.elementUtils().clickOnElement(groupDropdownLocator);
        return this;
    }

    @Step("Click on Save Button")
    public P02_UsersAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save Button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Back Button")
    public P02_UsersAdminPage clickOnBackButton() {
        LogsUtils.info("Clicking on Back Button");
        driver.elementUtils().clickOnElement(backButtonLocator);
        return this;
    }

    @Step("Search for User by Username")
    public P02_UsersAdminPage searchForUserByUsername(String username) {
        LogsUtils.info("Searching for User by Username: " + username);
        driver.elementUtils().sendDataToElement(usernameSearchFieldLocator, username);
        return this;
    }

    @Step("Click on Edit button")
    public P02_UsersAdminPage clickOnEditButton(String name) {
        LogsUtils.info("Clicking on Edit button for User: " + name);
        By editButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P02_UsersAdminPage clickOnDeleteButton(String name) {
        LogsUtils.info("Clicking on Delete button for User: " + name);
        By deleteButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes Button")
    public P02_UsersAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes Button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on OK Button")
    public P02_UsersAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK Button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Select a Site with a Group")
    public String selectSiteWithGroup() {
        LogsUtils.info("Selecting a Site with a Group");
        DataBaseUtils.configure("jdbc:postgresql://192.168.2.91:5432/icode-MDT1", "postgres", "P@ssw0rd@Lotus");
        List<List<Object>> sites = DataBaseUtils.executeSelect("SELECT name FROM sites WHERE id = (SELECT siteid FROM groups LIMIT 1);");
        DataBaseUtils.closeConnection();
        return sites.getFirst().getFirst().toString();
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

    @Step("Assert visibility of Empty User Role Message")
    public void assertVisibilityOfEmptyUserRoleMessage() {
        LogsUtils.info("Asserting visibility of Empty User Role Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyUserRoleMessageLocator),
                "Empty User Role message not visible"
        );
    }

    @Step("Assert visibility of Empty Username Message")
    public void assertVisibilityOfEmptyUsernameMessage() {
        LogsUtils.info("Asserting visibility of Empty Username Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyUsernameMessageLocator),
                "Empty Username message not visible"
        );
    }

    @Step("Assert visibility of Spaces Only Username Message")
    public void assertVisibilityOfSpacesOnlyUsernameMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only Username Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyUsernameMessageLocator),
                "Spaces Only Username message not visible"
        );
    }

    @Step("Assert visibility of Less Than Three Character Username Message")
    public void assertVisibilityOfLessThanThreeCharacterUsernameMessage() {
        LogsUtils.info("Asserting visibility of Less Than Three Character Username Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(lessThanThreeCharacterUsernameMessageLocator),
                "Less Than Three Character Username message not visible"
        );
    }

    @Step("Assert visibility of No Spaces Username Message")
    public void assertVisibilityOfNoSpacesUsernameMessage() {
        LogsUtils.info("Asserting visibility of No Spaces Username Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(noSpacesUsernameMessageLocator),
                "No Spaces Username message not visible"
        );
    }

    @Step("Assert visibility of Empty Full Name Message")
    public void assertVisibilityOfEmptyFullNameMessage() {
        LogsUtils.info("Asserting visibility of Empty Full Name Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyFullNameMessageLocator),
                "Empty Full Name message not visible"
        );
    }

    @Step("Assert visibility of Spaces Only Full Name Message")
    public void assertVisibilityOfSpacesOnlyFullNameMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only Full Name Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyFullNameMessageLocator),
                "Spaces Only Full Name message not visible"
        );
    }

    @Step("Assert visibility of Empty Password Message")
    public void assertVisibilityOfEmptyPasswordMessage() {
        LogsUtils.info("Asserting visibility of Empty Password Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyPasswordMessageLocator),
                "Empty Password message not visible"
        );
    }

    @Step("Assert visibility of Invalid Password Message")
    public void assertVisibilityOfInvalidPasswordMessage() {
        LogsUtils.info("Asserting visibility of Invalid Password Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(invalidPasswordMessageLocator),
                "Invalid Password message not visible"
        );
    }

    @Step("Assert visibility of Empty Confirm Password Message")
    public void assertVisibilityOfEmptyConfirmPasswordMessage() {
        LogsUtils.info("Asserting visibility of Empty Confirm Password Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyConfirmPasswordMessageLocator),
                "Empty Confirm Password message not visible"
        );
    }

    @Step("Assert visibility of Password Mismatch Message")
    public void assertVisibilityOfPasswordMismatchMessage() {
        LogsUtils.info("Asserting visibility of Password Mismatch Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(passwordMismatchMessageLocator),
                "Password Mismatch message not visible"
        );
    }

    @Step("Assert visibility of Empty Email Message")
    public void assertVisibilityOfEmptyEmailMessage() {
        LogsUtils.info("Asserting visibility of Empty Email Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyEmailMessageLocator),
                "Empty Email message not visible"
        );
    }

    @Step("Assert visibility of No Spaces Email Message")
    public void assertVisibilityOfNoSpacesEmailMessage() {
        LogsUtils.info("Asserting visibility of No Spaces Email Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(npSpacesEmailMessageLocator),
                "No Spaces Email message not visible"
        );
    }

    @Step("Assert visibility of Invalid Email Message")
    public void assertVisibilityOfInvalidEmailMessage() {
        LogsUtils.info("Asserting visibility of Invalid Email Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(invalidEmailMessageLocator),
                "Invalid Email message not visible"
        );
    }

    @Step("Assert visibility of Empty Site Message")
    public void assertVisibilityOfEmptySiteMessage() {
        LogsUtils.info("Asserting visibility of Empty Site Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySiteMessageLocator),
                "Empty Site message not visible"
        );
    }

    @Step("Assert visibility of Empty PACS Username Message")
    public void assertVisibilityOfEmptyPACSUsernameMessage() {
        LogsUtils.info("Asserting visibility of Empty PACS Username Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyPACSUsernameMessageLocator),
                "Empty PACS Username message not visible"
        );
    }

    @Step("Assert visibility of No Spaces PACS Username Message")
    public void assertVisibilityOfNoSpacesPACSUsernameMessage() {
        LogsUtils.info("Asserting visibility of No Spaces PACS Username Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(noSpacesPACSUsernameMessageLocator),
                "No Spaces PACS Username message not visible"
        );
    }

    @Step("Assert visibility of Empty RIS User ID Message")
    public void assertVisibilityOfEmptyRISUserIDMessage() {
        LogsUtils.info("Asserting visibility of Empty RIS User ID Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyRISUserIDMessageLocator),
                "Empty RIS User ID message not visible"
        );
    }

    @Step("Assert visibility of No Spaces RIS User ID Message")
    public void assertVisibilityOfNoSpacesRISUserIDMessage() {
        LogsUtils.info("Asserting visibility of No Spaces RIS User ID Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(noSpacesRISUserIDMessageLocator),
                "No Spaces RIS User ID message not visible"
        );
    }

    @Step("Assert visibility of Empty Group Message")
    public void assertVisibilityOfEmptyGroupMessage() {
        LogsUtils.info("Asserting visibility of Empty Group Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyGroupMessageLocator),
                "Empty Group message not visible"
        );
    }
}