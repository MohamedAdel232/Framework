package Pages;

import Factories.DriverFactory;
import Utilities.ClipboardUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P05_ActiveDirectoriesAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add active directory\"]");
    private final By nameFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By urlFieldLocator = By.cssSelector("[formcontrolname=\"url\"]");
    private final By portFieldLocator = By.cssSelector("[formcontrolname=\"port\"]");
    private final By siteDropdownLocator = By.cssSelector("[formcontrolname=\"sites\"]");
    private final By activeCheckboxLocator = By.cssSelector("input[title=\"Active\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By activeDirectoryAddedMessageLocator = By.cssSelector("[aria-label=\"Active directory has been added successfully\"]");
    private final By activeDirectoryEditedMessageLocator = By.cssSelector("[aria-label=\"Active directory has been edited successfully\"]");
    private final By activeDirectoryDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected active directory has been deleted successfully\"]");
    private final DriverFactory driver;

    public P05_ActiveDirectoriesAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add button")
    public P05_ActiveDirectoriesAdminPage clickOnAddButton() {
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter name")
    public P05_ActiveDirectoriesAdminPage enterName(String name) {
        driver.elementUtils().sendDataToElement(nameFieldLocator, name);
        return this;
    }

    @Step("Enter URL")
    public P05_ActiveDirectoriesAdminPage enterURL(String url) {
        driver.elementUtils().sendDataToElement(urlFieldLocator, url);
        return this;
    }

    @Step("Enter port")
    public P05_ActiveDirectoriesAdminPage enterPort(String port) {
        driver.elementUtils().clickOnElement(portFieldLocator);
        ClipboardUtils.copyToClipboard(port);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Select site")
    public P05_ActiveDirectoriesAdminPage selectSite() {
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Click on Active checkbox")
    public P05_ActiveDirectoriesAdminPage clickOnActiveCheckbox() {
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Save button")
    public P05_ActiveDirectoriesAdminPage clickOnSaveButton() {
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P05_ActiveDirectoriesAdminPage clickOnEditButton(String activeDirectoryName) {
        By editButtonLocator = By.xpath("//td[.='" + activeDirectoryName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P05_ActiveDirectoriesAdminPage clickOnDeleteButton(String activeDirectoryName) {
        By deleteButtonLocator = By.xpath("//td[.='" + activeDirectoryName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P05_ActiveDirectoriesAdminPage clickOnYesButton() {
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Verify Active Directory added message")
    public void assertVisibilityOfActiveDirectoryAddedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(activeDirectoryAddedMessageLocator),
                "Site added alert not visible"
        );
    }

    @Step("Verify Active Directory edited message")
    public void assertVisibilityOfActiveDirectoryEditedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(activeDirectoryEditedMessageLocator),
                "Site edited alert not visible"
        );
    }

    @Step("Verify Active Directory deleted message")
    public void assertVisibilityOfActiveDirectoryDeletedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(activeDirectoryDeletedMessageLocator),
                "Site deleted alert not visible"
        );
    }
}
