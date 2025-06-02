package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P02_SitesPage {
    private final By addButtonLocator = By.cssSelector("[title='Add new site']");
    private final By nameFieldLocator = By.cssSelector("[formcontrolname='name']");
    private final By hl7SiteNameFieldLocator = By.cssSelector("[formcontrolname='hl7SiteName']");
    private final By activeCheckboxLocator = By.cssSelector("[title='Active']");
    private final By saveButtonLocator = By.cssSelector("[title='Save']");
    private final By cancelButtonLocator = By.cssSelector("[title='Cancel']");
    private final By editButtonLocator = By.cssSelector("[title='Edit']");
    private final By deleteButtonLocator = By.cssSelector("[title='Delete']");
    private final By yesButtonLocator = By.cssSelector("[title='Yes']");
    private final By noButtonLocator = By.cssSelector("[title='No']");
    private final By deleteConfirmationButtonLocator = By.cssSelector("[title='Delete']");
    private final By emptySiteNameMessageLocator = By.cssSelector("[aria-label=\"Site name cannot be empty or contain spaces only, please enter a valid name.\"]");
    private final By emptyHl7SiteNameMessageLocator = By.cssSelector("[aria-label=\"HL7 site name cannot be empty or contain spaces only, please enter a valid name\"]");
    private final By duplicateSiteNameMessageLocator = By.cssSelector("[aria-label=\"Entered site is already existing, please enter another name\"]");
    private final By siteAddedMessageLocator = By.cssSelector("[aria-label=\"New Site has been added successfully\"]");
    private final By siteEditedMessageLocator = By.cssSelector("[aria-label=\"Selected Site has been updated successfully\"]");
    private final By siteDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected Site has been deleted successfully\"]");
    private final By siteNameSearchFieldLocator = By.cssSelector("[aria-label=\"Name Filter\"]");

    private final DriverFactory driver;

    public P02_SitesPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add button")
    public P02_SitesPage clickAddButton() {
        LogsUtils.info("Clicking on Add button to add a new site");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter site name")
    public P02_SitesPage enterSiteName(String siteName) {
        LogsUtils.info("Entering site name");
        driver.elementUtils().sendDataToElement(nameFieldLocator, siteName);
        return this;
    }

    @Step("Enter HL7 site name")
    public P02_SitesPage enterHl7SiteName(String hl7SiteName) {
        LogsUtils.info("Entering HL7 site name");
        driver.elementUtils().sendDataToElement(hl7SiteNameFieldLocator, hl7SiteName);
        return this;
    }

    @Step("Click on Save button")
    public P02_SitesPage clickSaveButton() {
        LogsUtils.info("Clicking on Save button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Cancel button")
    public P02_SitesPage clickCancelButton() {
        LogsUtils.info("Clicking on Cancel button");
        driver.elementUtils().clickOnElement(cancelButtonLocator);
        return this;
    }
    @Step("Click on Edit button")
    public P02_SitesPage clickEditButton() {
        LogsUtils.info("Clicking on Edit button");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }
    @Step("Click on Delete button")
    public P02_SitesPage clickDeleteButton() {
        LogsUtils.info("Clicking on Delete button");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }
    @Step("Click on Yes button")
    public P02_SitesPage clickYesButton() {
        LogsUtils.info("Clicking on Yes button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }
    @Step("Click on No button")
    public P02_SitesPage clickNoButton() {
        LogsUtils.info("Clicking on No button");
        driver.elementUtils().clickOnElement(noButtonLocator);
        return this;
    }
    @Step("Enter site name to search")
    public P02_SitesPage enterSiteNameToSearch(String siteName){
        LogsUtils.info("Entering site name to search");
        driver.elementUtils().sendDataToElement(siteNameSearchFieldLocator, siteName);
        return this;
    }
    @Step("Assert visibility of site added alert")
    public void assertVisibilityOfSiteAddedAlert() {
        LogsUtils.info("Asserting visibility of site added alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(siteAddedMessageLocator),
                "Site added alert not visible"
        );
    }

    @Step("Assert visibility of site edited alert")
    public void assertVisibilityOfSiteEditedAlert() {
        LogsUtils.info("Asserting visibility of site edited alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(siteEditedMessageLocator),
                "Site edited alert not visible"
        );
    }
    @Step("Assert visibility of site deleted alert")
    public void assertVisibilityOfSiteDeletedAlert() {
        LogsUtils.info("Asserting visibility of site deleted alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(siteDeletedMessageLocator),
                "Site deleted alert not visible"
        );
    }
    @Step("Assert visibility of empty site name alert")
    public void assertVisibilityOfEmptySiteNameAlert() {
        LogsUtils.info("Asserting visibility of empty site name alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySiteNameMessageLocator),
                "Empty site name alert not visible"
        );
    }
    @Step("Assert visibility of empty HL7 site name alert")
    public void assertVisibilityOfEmptyHl7SiteNameAlert()                {
        LogsUtils.info("Asserting visibility of empty HL7 site name alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyHl7SiteNameMessageLocator),
                "Empty HL7 site name alert not visible"
        );
    }
    @Step("Assert visibility of duplicate site name alert")
    public void assertVisibilityOfDuplicateSiteNameAlert() {
        LogsUtils.info("Asserting visibility of duplicate site name alert");
        SoftAssertUtils.softAssertTrue(
        driver.elementUtils().verifyVisibilityOfElement(duplicateSiteNameMessageLocator),
                "Duplicate site name alert not visible"
        );
    }

}
