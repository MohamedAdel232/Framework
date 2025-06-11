package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P05_SpecialtiesAdminPage {
    private final By addNewSpecialtyButtonLocator = By.cssSelector("[title=\"Add new specialty\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By siteDropdownLocator = By.cssSelector("[formcontrolname=\"sites\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By specialtyNameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By yesButtonLocator = By.xpath("//button[.=\"Yes\"]");
    private final By okButtonLocator = By.xpath("//button[.=\"OK\"]");
    private final By closeButtonLocator = By.cssSelector("[title=\"Close\"]");

    private final By specialtyAddedMessageLocator = By.xpath("//p [.=\"Specialty has been added successfully\"]");
    private final By specialtyEditedMessageLocator = By.xpath("//p [.=\"Selected specialty has been updated successfully\"]");
    private final By specialtyDeletedMessageLocator = By.xpath("//p [.=\"Selected specialty has been deleted successfully\"]");

    private final By emptySpecialtyNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name is required \"]");
    private final By emptySiteMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Please select at least one site \"]");

    private final By spacesOnlySpecialtyNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name can't contain only white space \"]");

    private final DriverFactory driver;

    public P05_SpecialtiesAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add New Specialty Button")
    public P05_SpecialtiesAdminPage clickOnAddNewSpecialtyButton() {
        LogsUtils.info("Clicking on Add New Specialty Button");
        driver.elementUtils().clickOnElement(addNewSpecialtyButtonLocator);
        return this;
    }

    @Step("Enter Specialty Name: {specialtyName}")
    public P05_SpecialtiesAdminPage enterSpecialtyName(String specialtyName) {
        LogsUtils.info("Entering Specialty Name: " + specialtyName);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, specialtyName);
        return this;
    }

    @Step("Select Site")
    public P05_SpecialtiesAdminPage selectSite() {
        LogsUtils.info("Selecting Site");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Click on Site Dropdown")
    public P05_SpecialtiesAdminPage clickOnSiteDropdown() {
        LogsUtils.info("Clicking on Site Dropdown");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        return this;
    }

    @Step("Click on Save Button")
    public P05_SpecialtiesAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save Button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Search Specialty by Name: {specialtyName}")
    public P05_SpecialtiesAdminPage searchSpecialtyByName(String specialtyName) {
        LogsUtils.info("Searching Specialty by Name: " + specialtyName);
        driver.elementUtils().sendDataToElement(specialtyNameSearchFieldLocator, specialtyName);
        return this;
    }

    @Step("Click on Edit button")
    public P05_SpecialtiesAdminPage clickOnEditButton(String specialtyName) {
        LogsUtils.info("Clicking on Edit button for Specialty: " + specialtyName);
        By editButtonLocator = By.xpath("//td[.='" + specialtyName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P05_SpecialtiesAdminPage clickOnDeleteButton(String specialtyName) {
        LogsUtils.info("Clicking on Delete button for Specialty: " + specialtyName);
        By deleteButtonLocator = By.xpath("//td[.='" + specialtyName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes Button")
    public P05_SpecialtiesAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes Button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on OK Button")
    public P05_SpecialtiesAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK Button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Click on Close Button")
    public P05_SpecialtiesAdminPage clickOnCloseButton() {
        LogsUtils.info("Clicking on Close Button");
        driver.elementUtils().clickOnElement(closeButtonLocator);
        return this;
    }

    @Step("Assert visibility of Specialty Added Alert")
    public void assertVisibilityOfSpecialtyAddedAlert() {
        LogsUtils.info("Asserting visibility of Specialty Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(specialtyAddedMessageLocator),
                "Specialty added alert not visible"
        );
    }

    @Step("Assert visibility of Specialty Edited Alert")
    public void assertVisibilityOfSpecialtyEditedAlert() {
        LogsUtils.info("Asserting visibility of Specialty Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(specialtyEditedMessageLocator),
                "Specialty edited alert not visible"
        );
    }

    @Step("Assert visibility of Specialty Deleted Alert")
    public void assertVisibilityOfSpecialtyDeletedAlert() {
        LogsUtils.info("Asserting visibility of Specialty Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(specialtyDeletedMessageLocator),
                "Specialty deleted alert not visible"
        );
    }

    @Step("Assert visibility of Empty Specialty Name Message")
    public void assertVisibilityOfEmptySpecialtyNameMessage() {
        LogsUtils.info("Asserting visibility of Empty Specialty Name Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySpecialtyNameMessageLocator),
                "Empty specialty name message not visible"
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

    @Step("Assert visibility of Spaces Only Specialties Name Message")
    public void assertVisibilityOfSpacesOnlySiteNameMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only Specialties Name Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlySpecialtyNameMessageLocator),
                "Spaces only specialties name message not visible"
        );
    }
} 