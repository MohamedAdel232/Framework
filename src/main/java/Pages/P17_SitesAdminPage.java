package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P17_SitesAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new site\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By hl7SiteNameTextFieldLocator = By.cssSelector("[formcontrolname=\"hl7SiteName\"]");
    private final By activeCheckboxLocator = By.cssSelector("[formcontrolname=\"active\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By cancelButtonLocator = By.cssSelector("[title=\"Cancel\"]");
    private final By nameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By siteAddedMessageLocator = By.cssSelector("[aria-label=\"New Site has been added successfully\"]");
    private final By siteEditedMessageLocator = By.cssSelector("[aria-label=\"Selected Site has been updated successfully\"]");
    private final By siteDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected Site has been deleted successfully\"]");
    private final By emptyNameFieldMessageLocator = By.cssSelector("[aria-label='Site name cannot be empty or contain spaces only, please enter a valid name.']");
    private final By emptyHL7SiteNameFieldMessageLocator = By.cssSelector("[aria-label='HL7 site name cannot be empty or contain spaces only, please enter a valid name']");

    private final DriverFactory driver;

    public P17_SitesAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add Site button")
    public P17_SitesAdminPage clickOnAddSiteButton() {
        LogsUtils.info("Clicking on Add button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter Site Name")
    public P17_SitesAdminPage enterSiteName(String name) {
        LogsUtils.info("Entering Site Name: " + name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Enter HL7 Site Name")
    public P17_SitesAdminPage enterHL7SiteName(String hl7SiteName) {
        LogsUtils.info("Entering HL7 Site Name: " + hl7SiteName);
        driver.elementUtils().sendDataToElement(hl7SiteNameTextFieldLocator, hl7SiteName);
        return this;
    }

    @Step("Click Active Checkbox")
    public P17_SitesAdminPage clickActiveCheckbox() {
        LogsUtils.info("Clicking Active Checkbox");
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Save button")
    public P17_SitesAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Cancel button")
    public P17_SitesAdminPage clickOnCancelButton() {
        LogsUtils.info("Clicking on Cancel button");
        driver.elementUtils().clickOnElement(cancelButtonLocator);
        return this;
    }

    @Step("Search for Site")
    public P17_SitesAdminPage searchForSite(String name) {
        LogsUtils.info("Searching for Site: " + name);
        driver.elementUtils().sendDataToElement(nameSearchFieldLocator, name);
        return this;
    }

    @Step("Click on Edit button")
    public P17_SitesAdminPage clickOnEditButton(String name)  {
        LogsUtils.info("Clicking on Edit button for Site: " + name);
        By editButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P17_SitesAdminPage clickOnDeleteButton(String name)  {
        LogsUtils.info("Clicking on Delete button for Site: " + name);
        By deleteButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P17_SitesAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Assert visibility of Site Added Alert")
    public void assertVisibilityOfSiteAddedAlert() {
        LogsUtils.info("Asserting visibility of Site Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(siteAddedMessageLocator),
                "Site added alert not visible"
        );
    }

    @Step("Assert visibility of Site Edited Alert")
    public void assertVisibilityOfSiteEditedAlert() {
        LogsUtils.info("Asserting visibility of Site Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(siteEditedMessageLocator),
                "Site edited alert not visible"
        );
    }

    @Step("Assert visibility of Site Deleted Alert")
    public void assertVisibilityOfSiteDeletedAlert() {
        LogsUtils.info("Asserting visibility of Site Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(siteDeletedMessageLocator),
                "Site deleted alert not visible"
        );
    }

    @Step("Assert visibility of empty name field message")
    public void assertVisibilityOfEmptyNameFieldMessage() {
        LogsUtils.info("Asserting visibility of empty name field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyNameFieldMessageLocator),
                "Empty name field message not visible"
        );
    }

    @Step("Assert visibility of empty HL7 Site name field message")
    public void assertVisibilityOfEmptyHL7SiteNameFieldMessage() {
        LogsUtils.info("Asserting visibility of empty HL7 Site name field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyHL7SiteNameFieldMessageLocator),
                "Empty HL7 Site name field message not visible"
        );
    }
}
