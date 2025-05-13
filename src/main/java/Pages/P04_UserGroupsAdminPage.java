package Pages;

import Factories.DriverFactory;
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
    public P04_UserGroupsAdminPage selectSecurityProfile(String securityProfile) {
        driver.elementUtils().clickOnElement(securityProfileDropdownLocator);
        By securityProfileOptionLocator = By.xpath("//span [.=\"" + securityProfile + "\"]");
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
        By editButtonLocator = By.xpath("//td[.='" + userGroups + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P04_UserGroupsAdminPage clickOnYesButton() {
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Assert visibility of User Group Added Alert")
    public P04_UserGroupsAdminPage assertVisibilityOfUserGroupAddedAlert() {
        driver.elementUtils().verifyVisibilityOfElement(userGroupAddedMessageLocator);
        return this;
    }

    @Step("Assert visibility of User Group Edited Alert")
    public P04_UserGroupsAdminPage assertVisibilityOfUserGroupEditedAlert() {
        driver.elementUtils().verifyVisibilityOfElement(userGroupEditedMessageLocator);
        return this;
    }

    @Step("Assert visibility of User Group Deleted Alert")
    public P04_UserGroupsAdminPage assertVisibilityOfUserGroupDeletedAlert() {
        driver.elementUtils().verifyVisibilityOfElement(userGroupDeletedMessageLocator);
        return this;
    }
}
