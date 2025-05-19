package Pages;

import Factories.DriverFactory;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P04_UserGroupsAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new user group\"]");
    private final By groupNameFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By securityProfileDropdownLocator = By.cssSelector("[formcontrolname=\"securityProfile\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By userGroupAddedMessageLocator = By.cssSelector("[aria-label=\"User group has been added successfully\"]");
    private final By userGroupEditedMessageLocator = By.cssSelector("[aria-label=\"User group has been edited successfully\"]");
    private final By userGroupDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected user group has been deleted successfully\"]");

    private final DriverFactory driver;

    public P04_UserGroupsAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add button")
    public P04_UserGroupsAdminPage clickOnAddButton() {
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter group name")
    public P04_UserGroupsAdminPage enterGroupName(String groupName) {
        driver.elementUtils().sendDataToElement(groupNameFieldLocator, groupName);
        return this;
    }

    @Step("Select security profile")
    public P04_UserGroupsAdminPage selectSecurityProfile() {
        driver.elementUtils().clickOnElement(securityProfileDropdownLocator);
        By securityProfileOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(securityProfileOptionLocator);
        return this;
    }

    @Step("Click on Save button")
    public P04_UserGroupsAdminPage clickOnSaveButton() {
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P04_UserGroupsAdminPage clickOnEditButton(String userGroups) {
        By editButtonLocator = By.xpath("//td[.='" + userGroups + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P04_UserGroupsAdminPage clickOnDeleteButton(String userGroups) {
        By deleteButtonLocator = By.xpath("//td[.='" + userGroups + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P04_UserGroupsAdminPage clickOnYesButton() {
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Assert visibility of User Group Added Alert")
    public void assertVisibilityOfUserGroupAddedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(userGroupAddedMessageLocator),
                "User Group added alert not visible"
        );
    }

    @Step("Assert visibility of User Group Edited Alert")
    public void assertVisibilityOfUserGroupEditedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(userGroupEditedMessageLocator),
                "User Group edited alert not visible"
        );
    }

    @Step("Assert visibility of User Group Deleted Alert")
    public void assertVisibilityOfUserGroupDeletedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(userGroupDeletedMessageLocator),
                "User Group deleted alert not visible"
        );
    }
}
