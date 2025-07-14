package Pages;

import Factories.DriverFactory;
import Utilities.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.awt.*;
import java.util.List;

public class P02_UsersAdminPage {
    private final By institutionsButtonLocator = By.cssSelector("[routerlink=\"/admin/institutions\"]");
    private final By locationsButtonLocator = By.cssSelector("[routerlink=\"/admin/locations\"]");
    private final By dicomButtonLocation = By.xpath("//span[.=\"DICOM\"]/..");
    private final By dicomNodesButtonLocator = By.cssSelector("[routerlink=\"/admin/dicomnodes\"]");
    private final By pacsServerButtonLocator = By.cssSelector("[routerlink=\"/admin/pacsservers\"]");
    private final By dicomDestinationsButtonLocator = By.cssSelector("[routerlink=\"/admin/dicomdestinations\"]");
    private final By dicomOriginsButtonLocator = By.cssSelector("[routerlink=\"/admin/dicomorigins\"]");
    private final By hl7ConfigurationButtonLocator = By.xpath("//span[.=\"HL7 Configuration\"]/..");
    private final By hl7NodesButtonLocator = By.cssSelector("[routerlink=\"/admin/hl7nodes\"]");
    private final By configurationsButtonLocator = By.xpath("//span[.=\"Configurations\"]/..");
    private final By activeDirectoriesButtonLocator = By.cssSelector("[routerlink=\"/admin/activedirectories\"]");
    private final By ormProfilesButtonLocator = By.cssSelector("[routerlink=\"/admin/ormprofiles\"]");

    private final By addButtonLocator = By.id("addNewUser");
    private final By usernameFieldLocator = By.cssSelector("[formcontrolname=\"userName\"]");
    private final By fullNameFieldLocator = By.cssSelector("[formcontrolname=\"fullName\"]");
    private final By passwordFieldLocator = By.cssSelector("[formcontrolname=\"password\"]");
    private final By confirmPasswordFieldLocator = By.cssSelector("[formcontrolname=\"confirmPassword\"]");
    private final By userTypeDropdownLocator = By.cssSelector("[formcontrolname=\"userType\"]");
    private final By emailFieldLocator = By.cssSelector("[formcontrolname=\"email\"]");
    private final By institutionDropdownLocator = By.cssSelector("[formcontrolname=\"institution\"]");
    private final By locationDropdownLocator = By.cssSelector("[formcontrolname=\"location\"]");
    private final By activeCheckboxLocator = By.id("customCheck1");
    private final By regionalAccessCheckboxLocator = By.id("regional");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By backButtonLocator = By.cssSelector("[title=\"Back\"]");
    private final By nameSearchFieldLocator = By.cssSelector("input[aria-label=\"Username Filter\"]");
    private final By yesButtonLocator = By.xpath("//button [.=\"Yes\"]");
    private final By okButtonLocator = By.xpath("//button [.=\"OK\"]");
    private final By exportButtonLocator = By.cssSelector("[title=\"Export users to CSV file\"]");

    private final By userAddedMessageLocator = By.xpath("//p [.=\"Entered user has been added successfully\"]");
    private final By userEditedMessageLocator = By.xpath("//p [.=\"Selected user has been edited successfully.\"]");
    private final By userDeletedMessageLocator = By.xpath("//p [.=\"Selected user has been deleted successfully.\"]");

    private final By usernameIsRequiredMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Username is required \"]");
    private final By usernameMustBeAtLeast3CharactersMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Username must be at least 3 characters \"]");
    private final By usernameCannotContainSpacesMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Username can not contain spaces \"]");
    private final By usernameMustBeLessThanOrEquals50CharactersMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=' Username must be less than or equals 50 characters\" ']");
    private final By usernameCannotContainBackslashForwardSlashOrAmpersandMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\"  Username cannot contain backslash (\\), forward slash (/) or ampersand (&) \"]");

    private final By fullNameIsRequiredMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Full name is required \"]");
    private final By fullNameCannotContainWhiteSpacesOnlyMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Full name cannot contain white spaces only \"]");

    private final By passwordIsRequiredMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Password is required \"]");
    private final By passwordMustBeAtLeast6CharactersMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Password must be at least 6 characters \"]");
    private final By passwordMustBeLessThanOrEquals32CharactersMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Password must be less than or equals 32 characters \"]");

    private final By confirmPasswordIsRequiredMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Confirm password is required \"]");
    private final By passwordsMustMatchMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Passwords must match \"]");

    private final By userTypeIsRequiredMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" User type is required \"]");

    private final By emailIsRequiredMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Email is required \"]");
    private final By invalidEmailMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Invalid email \"]");

    private final By institutionIsRequiredMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Institution is required \"]");

    private final By locationIsRequiredMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Location is required \"]");

    private final DriverFactory driver;

    public P02_UsersAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Institution Button")
    public P03_InstitutionsAdminPage clickOnInstitutionButton() {
        LogsUtils.info("Clicking on Institution Button");
        driver.elementUtils().clickOnElement(institutionsButtonLocator);
        return new P03_InstitutionsAdminPage(driver);
    }

    @Step("Click on Location Button")
    public P04_LocationsAdminPage clickOnLocationButton() {
        LogsUtils.info("Clicking on Location Button");
        driver.elementUtils().clickOnElement(locationsButtonLocator);
        return new P04_LocationsAdminPage(driver);
    }

    @Step("Click on DICOM Button")
    public P02_UsersAdminPage clickOnDICOMButton() {
        LogsUtils.info("Clicking on DICOM Button");
        driver.elementUtils().clickOnElement(dicomButtonLocation);
        return this;
    }

    @Step("Click on DICOM Nodes Button")
    public P05_DICOMNodesAdminPage clickOnDICOMNodesButton() {
        LogsUtils.info("Clicking on DICOM Nodes Button");
        driver.elementUtils().clickOnElement(dicomNodesButtonLocator);
        return new P05_DICOMNodesAdminPage(driver);
    }

    @Step("Click on PACS Server Button")
    public P06_PACSServerAdminPage clickOnPACSServerButton() {
        LogsUtils.info("Clicking on PACS Server Button");
        driver.elementUtils().clickOnElement(pacsServerButtonLocator);
        return new P06_PACSServerAdminPage(driver);
    }

    @Step("Click on DICOM Destinations Button")
    public P07_DICOMDestinationsAdminPage clickOnDICOMDestinationsButton() {
        LogsUtils.info("Clicking on DICOM Destinations Button");
        driver.elementUtils().clickOnElement(dicomDestinationsButtonLocator);
        return new P07_DICOMDestinationsAdminPage(driver);
    }

    @Step("Click on DICOM Origins Button")
    public P08_DICOMOriginsAdminPage clickOnDICOMOriginsButton() {
        LogsUtils.info("Clicking on DICOM Origins Button");
        driver.elementUtils().clickOnElement(dicomOriginsButtonLocator);
        return new P08_DICOMOriginsAdminPage(driver);
    }

    @Step("Click on HL7 Configuration Button")
    public P02_UsersAdminPage clickOnHL7ConfigurationButton() {
        LogsUtils.info("Clicking on HL7 Configuration Button");
        driver.elementUtils().clickOnElement(hl7ConfigurationButtonLocator);
        return this;
    }

    @Step("Click on HL7 Nodes Button")
    public P09_HL7NodesAdminPage clickOnHL7NodesButton() {
        LogsUtils.info("Clicking on HL7 Nodes Button");
        driver.elementUtils().clickOnElement(hl7NodesButtonLocator);
        return new P09_HL7NodesAdminPage(driver);
    }

    @Step("Click on Configurations Button")
    public P02_UsersAdminPage clickOnConfigurationsButton() {
        LogsUtils.info("Clicking on Configurations Button");
        driver.elementUtils().clickOnElement(configurationsButtonLocator);
        return this;
    }

    @Step("Click on Active Directories Button")
    public P10_ActiveDirectoriesAdminPage clickOnActiveDirectoriesButton() {
        LogsUtils.info("Clicking on Active Directories Button");
        driver.elementUtils().clickOnElement(activeDirectoriesButtonLocator);
        return new P10_ActiveDirectoriesAdminPage(driver);
    }

//    @Step("Click on ORM Profiles Button")
//    public P11_ORMProfilesAdminPage clickOnORMProfilesButton() {
//        LogsUtils.info("Clicking on ORM Profiles Button");
//        driver.elementUtils().clickOnElement(ormProfilesButtonLocator);
//        return new P11_ORMProfilesAdminPage(driver);
//    }

    @Step("Click on Add Button")
    public P02_UsersAdminPage clickOnAddButton() {
        LogsUtils.info("Clicking on Add Button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter Username")
    public P02_UsersAdminPage enterUsername(String username) {
        LogsUtils.info("Entering Username:", username);
        driver.elementUtils().sendDataToElement(usernameFieldLocator, username);
        return this;
    }

    @Step("Enter Full Name")
    public P02_UsersAdminPage enterFullName(String fullName) {
        LogsUtils.info("Entering Full Name:", fullName);
        driver.elementUtils().sendDataToElement(fullNameFieldLocator, fullName);
        return this;
    }

    @Step("Enter Password")
    public P02_UsersAdminPage enterPassword(String password) {
        LogsUtils.info("Entering Password");
        driver.elementUtils().sendDataToElement(passwordFieldLocator, password);
        return this;
    }

    @Step("Enter Confirm Password")
    public P02_UsersAdminPage enterConfirmPassword(String confirmPassword) {
        LogsUtils.info("Entering Confirm Password");
        driver.elementUtils().sendDataToElement(confirmPasswordFieldLocator, confirmPassword);
        return this;
    }

    @Step("Select User Type")
    public P02_UsersAdminPage selectUserType(String userType) {
        LogsUtils.info("Selecting User Type:", userType);
        driver.elementUtils().clickOnElement(userTypeDropdownLocator);
        By userTypeOptionLocator = By.xpath("//li[.=\" " + userType + " \"]");
        driver.elementUtils().clickOnElement(userTypeOptionLocator);
        return this;
    }

    @Step("Click On User Type Dropdown")
    public P02_UsersAdminPage clickOnUserTypeDropdown() {
        LogsUtils.info("Click On User Type Dropdown");
        driver.elementUtils().clickOnElement(userTypeDropdownLocator);
        return this;
    }

    @Step("Enter Email")
    public P02_UsersAdminPage enterEmail(String email) {
        LogsUtils.info("Entering Email:", email);
        driver.elementUtils().sendDataToElement(emailFieldLocator, email);
        return this;
    }

    @Step("Select Institution")
    public P02_UsersAdminPage selectInstitution(String institution) {
        LogsUtils.info("Selecting Institution:", institution);
        driver.elementUtils().clickOnElement(institutionDropdownLocator);
        By institutionOptionLocator = By.xpath("//li[.=\" " + institution + " \"]");
        driver.elementUtils().clickOnElement(institutionOptionLocator);
        return this;
    }

    @Step("Click On Institution Dropdown")
    public P02_UsersAdminPage clickOnInstitutionDropdown() {
        LogsUtils.info("Clicking On Institution Dropdown");
        driver.elementUtils().clickOnElement(institutionDropdownLocator);
        return this;
    }

    @Step("Select Location")
    public P02_UsersAdminPage selectLocation() {
        LogsUtils.info("Selecting Location");
        driver.elementUtils().clickOnElement(locationDropdownLocator);
        By locationOptionLocator = By.xpath("(//li[@role=\"option\"])[1]");
        driver.elementUtils().clickOnElement(locationOptionLocator);
        return this;
    }

    @Step("Click On Location Dropdown")
    public P02_UsersAdminPage clickOnLocationDropdown() {
        LogsUtils.info("Clicking On Location Dropdown");
        driver.elementUtils().clickOnElement(locationDropdownLocator);
        return this;
    }

    @Step("Check Active Checkbox")
    public P02_UsersAdminPage checkActiveCheckbox() {
        LogsUtils.info("Check Active Checkbox");
        driver.elementUtils().checkCheckboxJS(activeCheckboxLocator);
        return this;
    }

    @Step("Uncheck Active Checkbox")
    public P02_UsersAdminPage uncheckActiveCheckbox() {
        LogsUtils.info("Uncheck Active Checkbox");
        driver.elementUtils().uncheckCheckboxJS(activeCheckboxLocator);
        return this;
    }

    @Step("Check Regional Access Checkbox")
    public P02_UsersAdminPage checkRegionalAccessCheckbox() {
        LogsUtils.info("Check Regional Access Checkbox");
        driver.elementUtils().checkCheckboxJS(regionalAccessCheckboxLocator);
        return this;
    }

    @Step("Uncheck Regional Access Checkbox")
    public P02_UsersAdminPage uncheckRegionalAccessCheckbox() {
        LogsUtils.info("Uncheck Regional Access Checkbox");
        driver.elementUtils().uncheckCheckboxJS(regionalAccessCheckboxLocator);
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

    @Step("Search for User by Name")
    public P02_UsersAdminPage searchForUserByName(String username) {
        LogsUtils.info("Searching for User:", username);
        driver.elementUtils().sendDataToElement(nameSearchFieldLocator, username);
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

    @Step("Click on Edit button")
    public P02_UsersAdminPage clickOnEditButton(String username) {
        LogsUtils.info("Clicking on Edit Button for User: " + username);
        By editButtonLocator = By.xpath("//td[.='" + username + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P02_UsersAdminPage clickOnDeleteButton(String username) {
        LogsUtils.info("Clicking on Delete Button for User: " + username);
        By deleteButtonLocator = By.xpath("//td[.='" + username + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Get Institution with Locations")
    public String getInstitutionWithLocations() {
        LogsUtils.info("Getting Institution with Locations");
        DataBaseUtils.configure("jdbc:postgresql://192.168.2.90:5432/paip", "postgres", "P@ssw0rd@Lotus");
        List<List<Object>> list = DataBaseUtils.executeSelect("select name from institutions where id = (select institutionid from locations limit 1 OFFSET 1);");
        DataBaseUtils.closeConnection();
        LogsUtils.info("Institution with Locations:", list.getFirst().getFirst().toString());
        return list.getFirst().getFirst().toString();
    }

    @Step("Click on Export Button")
    public P02_UsersAdminPage clickOnExportButton() throws AWTException, InterruptedException {
        LogsUtils.info("Clicking on Export Button");
        driver.elementUtils().clickOnElement(exportButtonLocator);
        Thread.sleep(500);
        RobotUtils.clickOnEnterButton();
        return this;
    }

    @Step("Get number of files before Export")
    public int getNumberOfFilesInDownloadsDirectory() {
        LogsUtils.info("Getting number of files before Export");
        String downloadsDirectoryPath = FilesUtils.getDownloadsDirectoryPath();
        return FilesUtils.getNumberOfFilesInDirectory(downloadsDirectoryPath);
    }

    @Step("Assert User Added Message")
    public void assertUserAddedMessage(String expectedUserAddedMessage) {
        LogsUtils.info("Asserting User Added Message");
        String actualUserAddedMessage = driver.elementUtils().getDataFromElement(userAddedMessageLocator);
        LogsUtils.info("Expected User Added Message:", expectedUserAddedMessage);
        LogsUtils.info("Actual User Added Message:", actualUserAddedMessage);
        SoftAssertUtils.softAssertEquals(actualUserAddedMessage, expectedUserAddedMessage,
                "Wrong User Added Message");
    }

    @Step("Assert User Edited Message")
    public void assertUserEditedMessage(String expectedUserEditedMessage) {
        LogsUtils.info("Asserting User Edited Message");
        String actualUserEditedMessage = driver.elementUtils().getDataFromElement(userEditedMessageLocator);
        LogsUtils.info("Expected User Edited Message:", expectedUserEditedMessage);
        LogsUtils.info("Actual User Edited Message:", actualUserEditedMessage);
        SoftAssertUtils.softAssertEquals(actualUserEditedMessage, expectedUserEditedMessage,
                "Wrong User Edited Message");
    }

    @Step("Assert User Deleted Message")
    public void assertUserDeletedMessage(String expectedUserDeletedMessage) {
        LogsUtils.info("Asserting User Deleted Message");
        String actualUserDeletedMessage = driver.elementUtils().getDataFromElement(userDeletedMessageLocator);
        LogsUtils.info("Expected User Deleted Message:", expectedUserDeletedMessage);
        LogsUtils.info("Actual User Deleted Message:", actualUserDeletedMessage);
        SoftAssertUtils.softAssertEquals(actualUserDeletedMessage, expectedUserDeletedMessage,
                "Wrong User Deleted Message");
    }

    @Step("Assert Visibility of Username is Required Message")
    public void assertVisibilityOfUsernameIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of Username Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(usernameIsRequiredMessageLocator),
                "Username Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of Username Must Be At Least 3 Characters Message")
    public void assertVisibilityOfUsernameMustBeAtLeast3CharactersMessage() {
        LogsUtils.info("Asserting Visibility Of Username Must Be At Least 3 Characters Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(usernameMustBeAtLeast3CharactersMessageLocator),
                "Username Must Be At Least 3 Characters Message is not Displayed");
    }

    @Step("Assert Visibility of Username Cannot Contain Spaces Message")
    public void assertVisibilityOfUsernameCannotContainSpacesMessage() {
        LogsUtils.info("Asserting Visibility Of Username Cannot Contain Spaces Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(usernameCannotContainSpacesMessageLocator),
                "Username Cannot Contain Spaces Message is not Displayed");
    }

    @Step("Assert Visibility of Username Must Be Less Than Or Equals 50 Characters Message")
    public void assertVisibilityOfUsernameMustBeLessThanOrEquals50CharactersMessage() {
        LogsUtils.info("Asserting Visibility Of Username Must Be Less Than Or Equals 50 Characters Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(usernameMustBeLessThanOrEquals50CharactersMessageLocator),
                "Username Must Be Less Than Or Equals 50 Characters Message is not Displayed");
    }

    @Step("Assert Visibility of Username Cannot Contain Backslash Forward Slash Or Ampersand Message")
    public void assertVisibilityOfUsernameCannotContainBackslashForwardSlashOrAmpersandMessage() {
        LogsUtils.info("Asserting Visibility Of Username Cannot Contain Backslash Forward Slash Or Ampersand Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(usernameCannotContainBackslashForwardSlashOrAmpersandMessageLocator),
                "Username Cannot Contain Backslash Forward Slash Or Ampersand Message is not Displayed");
    }

    @Step("Assert Visibility of Full Name is Required Message")
    public void assertVisibilityOfFullNameIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of Full Name Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(fullNameIsRequiredMessageLocator),
                "Full Name Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of Full Name Cannot Contain White Spaces Only Message")
    public void assertVisibilityOfFullNameCannotContainWhiteSpacesOnlyMessage() {
        LogsUtils.info("Asserting Visibility Of Full Name Cannot Contain White Spaces Only Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(fullNameCannotContainWhiteSpacesOnlyMessageLocator),
                "Full Name Cannot Contain White Spaces Only Message is not Displayed");
    }

    @Step("Assert Visibility of Password is Required Message")
    public void assertVisibilityOfPasswordIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of Password Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(passwordIsRequiredMessageLocator),
                "Password Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of Password Must Be At Least 6 Characters Message")
    public void assertVisibilityOfPasswordMustBeAtLeast6CharactersMessage() {
        LogsUtils.info("Asserting Visibility Of Password Must Be At Least 6 Characters Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(passwordMustBeAtLeast6CharactersMessageLocator),
                "Password Must Be At Least 6 Characters Message is not Displayed");
    }

    @Step("Assert Visibility of Password Must Be Less Than Or Equals 32 Characters Message")
    public void assertVisibilityOfPasswordMustBeLessThanOrEquals32CharactersMessage() {
        LogsUtils.info("Asserting Visibility Of Password Must Be Less Than Or Equals 32 Characters Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(passwordMustBeLessThanOrEquals32CharactersMessageLocator),
                "Password Must Be Less Than Or Equals 32 Characters Message is not Displayed");
    }

    @Step("Assert Visibility of Confirm Password is Required Message")
    public void assertVisibilityOfConfirmPasswordIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of Confirm Password Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(confirmPasswordIsRequiredMessageLocator),
                "Confirm Password Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of Passwords Must Match Message")
    public void assertVisibilityOfPasswordsMustMatchMessage() {
        LogsUtils.info("Asserting Visibility Of Passwords Must Match Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(passwordsMustMatchMessageLocator),
                "Passwords Must Match Message is not Displayed");
    }

    @Step("Assert Visibility of User Type is Required Message")
    public void assertVisibilityOfUserTypeIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of User Type Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(userTypeIsRequiredMessageLocator),
                "User Type Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of Email is Required Message")
    public void assertVisibilityOfEmailIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of Email Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(emailIsRequiredMessageLocator),
                "Email Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of Invalid Email Message")
    public void assertVisibilityOfInvalidEmailMessage() {
        LogsUtils.info("Asserting Visibility Of Invalid Email Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(invalidEmailMessageLocator),
                "Invalid Email Message is not Displayed");
    }

    @Step("Assert Visibility of Institution is Required Message")
    public void assertVisibilityOfInstitutionIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of Institution Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(institutionIsRequiredMessageLocator),
                "Institution Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of Location is Required Message")
    public void assertVisibilityOfLocationIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of Location Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(locationIsRequiredMessageLocator),
                "Location Is Required Message is not Displayed");
    }

    @Step("Assert Exporting Users")
    public void assertExportingUsers(int numberOfFilesBeforeExporting, int numberOfFilesAfterExporting) {
        LogsUtils.info("Assert Exporting Users");
        LogsUtils.info("Number of Files Before Exporting", String.valueOf(numberOfFilesBeforeExporting));
        LogsUtils.info("Number of Files After Exporting", String.valueOf(numberOfFilesAfterExporting));
        SoftAssertUtils.softAssertNotEquals(
                numberOfFilesBeforeExporting,
                numberOfFilesAfterExporting,
                "Failed to Export Users"
        );
    }
}