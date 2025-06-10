package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P04_GroupsAdminPage {
    private final By addNewGroupButtonLocator = By.cssSelector("[title=\"Add new group\"]");
    private final By groupNameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By siteDropdownLocator = By.cssSelector("[formcontrolname=\"sites\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By groupNameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By yesButtonLocator = By.xpath("//button[.=\"Yes\"]");
    private final By okButtonLocator = By.xpath("//button[.=\"OK\"]");
    private final By closeButtonLocator = By.cssSelector("[title=\"Close\"]");

    private final By groupAddedMessageLocator = By.xpath("//p [.=\"Group has been added successfully\"]");
    private final By groupEditedMessageLocator = By.xpath("//p [.=\"Group has been updated successfully\"]");
    private final By groupDeletedMessageLocator = By.xpath("//p [.=\"Selected Group has been deleted successfully\"]");

    private final By emptyGroupNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name is required \"]");
    private final By emptySiteMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Please select at least one site \"]");

    private final DriverFactory driver;

    public P04_GroupsAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add New Group Button")
    public P04_GroupsAdminPage clickOnAddNewGroupButton() {
        LogsUtils.info("Clicking on Add New Group Button");
        driver.elementUtils().clickOnElement(addNewGroupButtonLocator);
        return this;
    }

    @Step("Enter Group Name: {groupName}")
    public P04_GroupsAdminPage enterGroupName(String groupName) {
        LogsUtils.info("Entering Group Name: " + groupName);
        driver.elementUtils().sendDataToElement(groupNameTextFieldLocator, groupName);
        return this;
    }

    @Step("Enter Site: {site}")
    public P04_GroupsAdminPage selectSite() {
        LogsUtils.info("Entering Site");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Click on Site Dropdown")
    public P04_GroupsAdminPage clickOnSiteDropdown() {
        LogsUtils.info("Clicking on Site Dropdown");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        return this;
    }

    @Step("Click on Save Button")
    public P04_GroupsAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save Button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Search Group by Name: {groupName}")
    public P04_GroupsAdminPage searchGroupByName(String groupName) {
        LogsUtils.info("Searching Group by Name: " + groupName);
        driver.elementUtils().sendDataToElement(groupNameSearchFieldLocator, groupName);
        return this;
    }

    @Step("Click on Edit button")
    public P04_GroupsAdminPage clickOnEditButton(String groupName) {
        LogsUtils.info("Clicking on Edit button for Group: " + groupName);
        By editButtonLocator = By.xpath("//td[.='" + groupName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P04_GroupsAdminPage clickOnDeleteButton(String groupName) {
        LogsUtils.info("Clicking on Delete button for Group: " + groupName);
        By deleteButtonLocator = By.xpath("//td[.='" + groupName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes Button")
    public P04_GroupsAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes Button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on OK Button")
    public P04_GroupsAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK Button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Click on Close Button")
    public P04_GroupsAdminPage clickOnCloseButton() {
        LogsUtils.info("Clicking on Close Button");
        driver.elementUtils().clickOnElement(closeButtonLocator);
        return this;
    }

    @Step("Assert visibility of Group Added Alert")
    public void assertVisibilityOfGroupAddedAlert() {
        LogsUtils.info("Asserting visibility of Group Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(groupAddedMessageLocator),
                "Group added alert not visible"
        );
    }

    @Step("Assert visibility of Group Edited Alert")
    public void assertVisibilityOfGroupEditedAlert() {
        LogsUtils.info("Asserting visibility of Group Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(groupEditedMessageLocator),
                "Group edited alert not visible"
        );
    }

    @Step("Assert visibility of Group Deleted Alert")
    public void assertVisibilityOfGroupDeletedAlert() {
        LogsUtils.info("Asserting visibility of Group Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(groupDeletedMessageLocator),
                "Group deleted alert not visible"
        );
    }

    @Step("Assert visibility of Empty Group Name Message")
    public void assertVisibilityOfEmptyGroupNameMessage() {
        LogsUtils.info("Asserting visibility of Empty Group Name Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyGroupNameMessageLocator),
                "Empty group name message not visible"
        );
    }

    @Step("Assert visibility of Empty Site Message")
    public void assertVisibilityOfEmptySiteMessage() {
        LogsUtils.info("Asserting visibility of Empty Site Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySiteMessageLocator),
                "Empty site message not visible"
        );
    }
} 