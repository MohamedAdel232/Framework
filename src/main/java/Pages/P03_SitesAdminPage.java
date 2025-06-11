package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P03_SitesAdminPage {
    private final By addNewSiteButtonLocator = By.cssSelector("[title=\"Add new site\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By hl7SiteNameTextFieldLocator = By.cssSelector("[formcontrolname=\"hl7SiteName\"]");
    private final By pacsCallingAETitleTextFieldLocator = By.cssSelector("[formcontrolname=\"callingAEtitle\"]");
    private final By mdtKeywordsTextFieldLocator = By.cssSelector("[formcontrolname=\"item\"]");
    private final By activeCheckboxLocator = By.cssSelector("[formcontrolname=\"active\"]");
    private final By enableTwoFactorAuthenticationCheckboxLocator = By.cssSelector("[formcontrolname=\"enableTwoFactor\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By nameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By yesButtonLocator = By.xpath("//button[.=\"Yes\"]");
    private final By okButtonLocator = By.xpath("//button[.=\"OK\"]");
    private final By closeButtonLocator = By.cssSelector("[title=\"Close\"]");

    private final By siteAddedMessageLocator = By.xpath("//p [.=\"Site has been added successfully\"]");
    private final By siteEditedMessageLocator = By.xpath("//p [.=\"Site has been updated successfully\"]");
    private final By siteDeletedMessageLocator = By.xpath("//p [.=\"Selected site has been deleted successfully\"]");

    private final By emptySiteNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name is required \"]");
    private final By emptyHL7SiteNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" HL7 site name is required \"]");
    private final By emptyPacsCallingAETitleMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" AE Title is required \"]");

    private final By spacesOnlySiteNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name cannot contain white spaces \"]");
    private final By spacesOnlyHL7SiteNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" HL7 site name cannot contain white spaces only \"]");
    private final By spacesOnlyPacsCallingAETitleMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" PACS calling AE title cannot contain white spaces only \"]");

    private final DriverFactory driver;

    public P03_SitesAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add New Site Button")
    public P03_SitesAdminPage clickOnAddNewSiteButton() {
        LogsUtils.info("Clicking on Add New Site Button");
        driver.elementUtils().clickOnElement(addNewSiteButtonLocator);
        return this;
    }

    @Step("Enter Site Name: {siteName}")
    public P03_SitesAdminPage enterSiteName(String siteName) {
        LogsUtils.info("Entering Site Name: " + siteName);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, siteName);
        return this;
    }

    @Step("Enter HL7 Site Name: {hl7SiteName}")
    public P03_SitesAdminPage enterHL7SiteName(String hl7SiteName) {
        LogsUtils.info("Entering HL7 Site Name: " + hl7SiteName);
        driver.elementUtils().sendDataToElement(hl7SiteNameTextFieldLocator, hl7SiteName);
        return this;
    }

    @Step("Enter PACS Calling AE Title: {callingAETitle}")
    public P03_SitesAdminPage enterPacsCallingAETitle(String callingAETitle) {
        LogsUtils.info("Entering PACS Calling AE Title: " + callingAETitle);
        driver.elementUtils().sendDataToElement(pacsCallingAETitleTextFieldLocator, callingAETitle);
        return this;
    }

    @Step("Enter MDT Keywords: {keywords}")
    public P03_SitesAdminPage enterMdtKeywords(String keywords) {
        LogsUtils.info("Entering MDT Keywords: " + keywords);
        driver.elementUtils().sendDataToElement(mdtKeywordsTextFieldLocator, keywords);
        return this;
    }

    @Step("Check Active Checkbox")
    public P03_SitesAdminPage checkActiveCheckbox() {
        LogsUtils.info("Checking Active Checkbox");
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Check Enable Two Factor Authentication Checkbox")
    public P03_SitesAdminPage checkEnableTwoFactorAuthenticationCheckbox() {
        LogsUtils.info("Checking Enable Two Factor Authentication Checkbox");
        driver.elementUtils().clickOnElement(enableTwoFactorAuthenticationCheckboxLocator);
        return this;
    }

    @Step("Click on Save Button")
    public P03_SitesAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save Button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Search Site by Name: {siteName}")
    public P03_SitesAdminPage searchSiteByName(String siteName) {
        LogsUtils.info("Searching Site by Name: " + siteName);
        driver.elementUtils().sendDataToElement(nameSearchFieldLocator, siteName);
        return this;
    }

    @Step("Click on Edit button")
    public P03_SitesAdminPage clickOnEditButton(String siteName) {
        LogsUtils.info("Clicking on Edit button for Site: " + siteName);
        By editButtonLocator = By.xpath("//td[.='" + siteName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P03_SitesAdminPage clickOnDeleteButton(String siteName) {
        LogsUtils.info("Clicking on Delete button for Site: " + siteName);
        By deleteButtonLocator = By.xpath("//td[.='" + siteName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes Button")
    public P03_SitesAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes Button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on OK Button")
    public P03_SitesAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK Button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Click on Close Button")
    public P03_SitesAdminPage clickOnCloseButton() {
        LogsUtils.info("Clicking on Close Button");
        driver.elementUtils().clickOnElement(closeButtonLocator);
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

    @Step("Assert visibility of Empty Site Name Message")
    public void assertVisibilityOfEmptySiteNameMessage() {
        LogsUtils.info("Asserting visibility of Empty Site Name Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySiteNameMessageLocator),
                "Empty site name message not visible"
        );
    }

    @Step("Assert visibility of Empty HL7 Site Name Message")
    public void assertVisibilityOfEmptyHL7SiteNameMessage() {
        LogsUtils.info("Asserting visibility of Empty HL7 Site Name Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyHL7SiteNameMessageLocator),
                "Empty HL7 site name message not visible"
        );
    }

    @Step("Assert visibility of Empty PACS Calling AE Title Message")
    public void assertVisibilityOfEmptyPacsCallingAETitleMessage() {
        LogsUtils.info("Asserting visibility of Empty PACS Calling AE Title Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyPacsCallingAETitleMessageLocator),
                "Empty PACS calling AE title message not visible"
        );
    }

    @Step("Assert visibility of Spaces Only Site Name Message")
    public void assertVisibilityOfSpacesOnlySiteNameMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only Site Name Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlySiteNameMessageLocator),
                "Spaces only site name message not visible"
        );
    }

    @Step("Assert visibility of Spaces Only HL7 Site Name Message")
    public void assertVisibilityOfSpacesOnlyHL7SiteNameMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only HL7 Site Name Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyHL7SiteNameMessageLocator),
                "Spaces only HL7 site name message not visible"
        );
    }

    @Step("Assert visibility of Spaces Only PACS Calling AE Title Message")
    public void assertVisibilityOfSpacesOnlyPacsCallingAETitleMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only PACS Calling AE Title Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyPacsCallingAETitleMessageLocator),
                "Spaces only PACS calling AE title message not visible"
        );
    }
}

