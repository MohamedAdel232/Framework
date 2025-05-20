package Pages;

import Factories.DriverFactory;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P12_UsersAdminPage {
    private final By addButtonLocator = By.cssSelector("[title='Add new user']");
    private final By usernameFieldLocator = By.cssSelector("[formcontrolname=\"username\"]");
    private final By fullNameFieldLocator = By.cssSelector("[formcontrolname=\"fullName\"]");
    private final By passwordFieldLocator = By.cssSelector("[formcontrolname=\"password\"]");
    private final By confirmPasswordFieldLocator = By.cssSelector("[formcontrolname=\"confirmPassword\"]");
    private final By emailFieldLocator = By.cssSelector("[formcontrolname=\"email\"]");
    private final By pacsUsernameFieldLocator = By.cssSelector("[formcontrolname=\"pacsUsername\"]");
    private final By userGroupDropdownLocator = By.cssSelector("[formcontrolname=\"groupIds\"]");
    private final By siteDropdownLocator = By.cssSelector("[formcontrolname=\"siteId\"]");
    private final By msTeamsIDFieldLocator = By.cssSelector("[formcontrolname=\"msTeamsID\"]");
    private final By statusCheckboxLocator = By.cssSelector("input[title=\"Active\"]");
    private final By saveButtonLocator = By.cssSelector("[title='Save']");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By usernameSearchFieldLocator = By.cssSelector("input[aria-label=\"Username Filter\"]");
    private final By userAddedMessageLocator = By.cssSelector("[aria-label=\"User has been added successfully\"]");
    private final By userEditedMessageLocator = By.cssSelector("[aria-label=\"User has been edited successfully\"]");
    private final By userDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected user has been deleted successfully.\"]");

    private final DriverFactory driver;

    public P12_UsersAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add button")
    public P12_UsersAdminPage clickOnAddButton() {
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter username")
    public P12_UsersAdminPage enterUsername(String username) {
        driver.elementUtils().sendDataToElement(usernameFieldLocator, username);
        return this;
    }

    @Step("Enter full name")
    public P12_UsersAdminPage enterFullName(String fullName) {
        driver.elementUtils().sendDataToElement(fullNameFieldLocator, fullName);
        return this;
    }

    @Step("Enter password")
    public P12_UsersAdminPage enterPassword(String password) {
        driver.elementUtils().sendDataToElement(passwordFieldLocator, password);
        return this;
    }

    @Step("Enter confirm password")
    public P12_UsersAdminPage enterConfirmPassword(String confirmPassword) {
        driver.elementUtils().sendDataToElement(confirmPasswordFieldLocator, confirmPassword);
        return this;
    }

    @Step("Enter email")
    public P12_UsersAdminPage enterEmail(String email) {
        driver.elementUtils().sendDataToElement(emailFieldLocator, email);
        return this;
    }

    @Step("Enter PACS username")
    public P12_UsersAdminPage enterPACSUsername(String pacsUsername) {
        driver.elementUtils().sendDataToElement(pacsUsernameFieldLocator, pacsUsername);
        return this;
    }

    @Step("Select user group")
    public P12_UsersAdminPage selectUserGroup(String userGroup) {
        driver.elementUtils().clickOnElement(userGroupDropdownLocator);
        By userGroupOptionLocator = By.xpath("//span[text()=\"" + userGroup + "\"]");
        driver.elementUtils().clickOnElement(userGroupOptionLocator);
        return this;
    }

    @Step("Select site")
    public P12_UsersAdminPage selectSite(String site) {
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        By siteOptionLocator = By.xpath("//span[text()=\"" + site + "\"]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Enter MS Teams ID")
    public P12_UsersAdminPage enterMSTeamsID(String msTeamsID) {
        driver.elementUtils().sendDataToElement(msTeamsIDFieldLocator, msTeamsID);
        return this;
    }

    @Step("Click on Active checkbox")
    public P12_UsersAdminPage clickOnStatusCheckbox() {
        driver.elementUtils().clickOnElement(statusCheckboxLocator);
        return this;
    }

    @Step("Click on Save button")
    public P12_UsersAdminPage clickOnSaveButton() {
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P12_UsersAdminPage clickOnYesButton() {
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Search for user")
    public P12_UsersAdminPage searchForUser(String username) {
        driver.elementUtils().sendDataToElement(usernameSearchFieldLocator, username);
        return this;
    }

    @Step("Click on Edit button")
    public P12_UsersAdminPage clickOnEditButton(String userName) {
        By editButtonLocator = By.xpath("//td[.='" + userName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P12_UsersAdminPage clickOnDeleteButton(String userName) {
        By deleteButtonLocator = By.xpath("//td[.='" + userName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Verify User added message")
    public void assertVisibilityOfUserAddedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(userAddedMessageLocator),
                "User added alert not visible"
        );
    }

    @Step("Verify User edited message")
    public void assertVisibilityOfUserEditedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(userEditedMessageLocator),
                "User edited alert not visible"
        );
    }

    @Step("Verify PACS Server deleted message")
    public void assertVisibilityOfUserDeletedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(userDeletedMessageLocator),
                "User deleted alert not visible"
        );
    }
}
