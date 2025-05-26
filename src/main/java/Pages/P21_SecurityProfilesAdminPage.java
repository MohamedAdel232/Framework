package Pages;

import Factories.DriverFactory;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P21_SecurityProfilesAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new security profile\"]");
    private final By nameFieldLocator = By.cssSelector("[formcontrolname=\"securityProfileName\"]");
    private final By saveButtonLocator = By.cssSelector(".btn-icode[title=\"Save\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By searchFieldLocator = By.cssSelector("input[aria-label=\"Security Profile Name Filter\"]");
    private final By expandArrowsLocator = By.xpath("//kendo-svgicon[@class=\"k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted\"]");
    private final By allCheckboxesLocator = By.xpath("//input[@class=\"k-checkbox k-checkbox-md k-rounded-md\"]");
    private final By securityProfileAddedMessageLocator = By.cssSelector("[aria-label=\"Security profile has been added successfully\"]");
    private final By securityProfileEditedMessageLocator = By.cssSelector("[aria-label=\"Security profile has been edited successfully\"]");
    private final By securityProfileDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected security profile has been deleted successfully\"]");
    private final DriverFactory driver;

    public P21_SecurityProfilesAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add button")
    public P21_SecurityProfilesAdminPage clickOnAddButton() {
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter security profile name")
    public P21_SecurityProfilesAdminPage enterName(String name) {
        driver.elementUtils().sendDataToElement(nameFieldLocator, name);
        return this;
    }

    @Step("Expand all permission groups")
    public P21_SecurityProfilesAdminPage expandAllPermissionGroups() {
        boolean flag = true;
        while (flag) {
            try {
                driver.elementUtils().clickOnElement(expandArrowsLocator);
            } catch (Exception e) {
                flag = false;
            }
        }
        return this;
    }

    @Step("Check all permission checkboxes")
    public P21_SecurityProfilesAdminPage checkAllPermissions() {
        boolean flag = true;
        while (flag) {
            try {
                driver.elementUtils().clickOnElement(allCheckboxesLocator);
            } catch (Exception e) {
                flag = false;
            }
        }
        return this;
    }

    @Step("Click on Save button")
    public P21_SecurityProfilesAdminPage clickOnSaveButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P21_SecurityProfilesAdminPage clickOnYesButton() {
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P21_SecurityProfilesAdminPage clickOnEditButton(String profileName) {
        By editButtonLocator = By.xpath("//td[.='" + profileName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P21_SecurityProfilesAdminPage clickOnDeleteButton(String profileName) {
        By deleteButtonLocator = By.xpath("//td[.='" + profileName + "']/following-sibling::td//span[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Search for Security Profile")
    public P21_SecurityProfilesAdminPage searchForSecurityProfile(String profileName) {
        driver.elementUtils().sendDataToElement(searchFieldLocator, profileName);
        return this;
    }

    @Step("Verify Security Profile added message")
    public void assertVisibilityOfSecurityProfileAddedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(securityProfileAddedMessageLocator),
                "Security Profile added alert not visible"
        );
    }

    @Step("Verify Security Profile edited message")
    public void assertVisibilityOfSecurityProfileEditedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(securityProfileEditedMessageLocator),
                "Security Profile edited alert not visible"
        );
    }

    @Step("Verify Security Profile deleted message")
    public void assertVisibilityOfSecurityProfileDeletedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(securityProfileDeletedMessageLocator),
                "Security Profile deleted alert not visible"
        );
    }
} 