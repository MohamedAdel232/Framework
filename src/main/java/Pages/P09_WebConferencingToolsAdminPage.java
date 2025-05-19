package Pages;

import Factories.DriverFactory;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P09_WebConferencingToolsAdminPage {
    private final By addButtonLocator = By.cssSelector("[title='Add Conferencing Tool']");
    private final By typeDropdownLocator = By.cssSelector("[formcontrolname='type']");
    private final By nameFieldLocator = By.cssSelector("[formcontrolname='name']");
    private final By applicationIdFieldLocator = By.cssSelector("[formcontrolname='applicationId']");
    private final By directoryIdFieldLocator = By.cssSelector("[formcontrolname='directoryId']");
    private final By clientSecretFieldLocator = By.cssSelector("[formcontrolname='clientSecret']");
    private final By siteFieldLocator = By.cssSelector("[formcontrolname=\"sites\"]");
    private final By activeCheckboxLocator = By.cssSelector("input[title=\"Active\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By webConferencingToolsAddedMessageLocator = By.cssSelector("[aria-label=\"Web conferencing tool has been added successfully\"]");
    private final By webConferencingToolsEditedMessageLocator = By.cssSelector("[aria-label=\"Selected web conferencing tool has been edited successfully\"]");
    private final By webConferencingToolsDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected web conferencing tool has been deleted successfully\"]");

    private final DriverFactory driver;

    public P09_WebConferencingToolsAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add button")
    public P09_WebConferencingToolsAdminPage clickOnAddButton() {
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Select type")
    public P09_WebConferencingToolsAdminPage selectType() {
        driver.elementUtils().clickOnElement(typeDropdownLocator);
        By typeOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(typeOptionLocator);
        return this;
    }

    @Step("Enter name")
    public P09_WebConferencingToolsAdminPage enterName(String name) {
        driver.elementUtils().sendDataToElement(nameFieldLocator, name);
        return this;
    }

    @Step("Enter application ID")
    public P09_WebConferencingToolsAdminPage enterApplicationId(String applicationId) {
        driver.elementUtils().sendDataToElement(applicationIdFieldLocator, applicationId);
        return this;
    }

    @Step("Enter directory ID")
    public P09_WebConferencingToolsAdminPage enterDirectoryId(String directoryId) {
        driver.elementUtils().sendDataToElement(directoryIdFieldLocator, directoryId);
        return this;
    }

    @Step("Enter client secret")
    public P09_WebConferencingToolsAdminPage enterClientSecret(String clientSecret) {
        driver.elementUtils().sendDataToElement(clientSecretFieldLocator, clientSecret);
        return this;
    }

    @Step("Select site")
    public P09_WebConferencingToolsAdminPage selectSite() {
        driver.elementUtils().clickOnElement(siteFieldLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Click on Active checkbox")
    public P09_WebConferencingToolsAdminPage clickOnActiveCheckbox() {
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Save button")
    public P09_WebConferencingToolsAdminPage clickOnSaveButton() {
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P09_WebConferencingToolsAdminPage clickOnYesButton() {
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P09_WebConferencingToolsAdminPage clickOnEditButton(String dicomDestinationName) {
        By editButtonLocator = By.xpath("//td[.='" + dicomDestinationName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P09_WebConferencingToolsAdminPage clickOnDeleteButton(String dicomDestinationName) {
        By deleteButtonLocator = By.xpath("//td[.='" + dicomDestinationName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Verify Web Conferencing Tools added message")
    public void assertVisibilityOfWebConferencingToolsAddedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(webConferencingToolsAddedMessageLocator),
                "Web Conferencing Tools added alert not visible"
        );
    }

    @Step("Verify Web Conferencing Tools edited message")
    public void assertVisibilityOfWebConferencingToolsEditedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(webConferencingToolsEditedMessageLocator),
                "Web Conferencing Tools edited alert not visible"
        );
    }

    @Step("Verify Web Conferencing Tools deleted message")
    public void assertVisibilityOfWebConferencingToolsDeletedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(webConferencingToolsDeletedMessageLocator),
                "Web Conferencing Tools deleted alert not visible"
        );
    }

}
