package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P11_ThirdPartyApplicationsAdminPage {
    private final By addNewThirdPartyApplicationButtonLocator = By.cssSelector("[title=\"Add new ThirdPartyApp\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By siteDropdownLocator = By.cssSelector("[formcontrolname=\"sites\"]");
    private final By urlTextFieldLocator = By.cssSelector("[formcontrolname=\"url\"]");
    private final By getRadioButtonLocator = By.cssSelector("[title=\"Get\"]");
    private final By postRadioButtonLocator = By.cssSelector("[title=\"Post\"]");
    private final By tooltipTextFieldLocator = By.cssSelector("[formcontrolname=\"tooltip\"]");
    private final By activeCheckboxLocator = By.cssSelector("[title=\"Active\"]");
    private final By addNewParameterButtonLocator = By.cssSelector("[title=\"New Parameter\"]");
    private final By keyTextFieldLocator = By.cssSelector("[formcontrolname=\"key\"]");
    private final By constantRadioButtonLocator = By.cssSelector("[title=\"Constant\"]");
    private final By variableRadioButtonLocator = By.cssSelector("[title=\"Variable\"]");
    private final By valueTextFieldLocator = By.cssSelector("[formcontrolname=\"value\"]");
    private final By saveParameterButtonLocator = By.xpath("(//button [@title=\"Save\"])[2]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By okButtonLocator = By.xpath("//button[.=\"OK\"]");
    private final By yesButtonLocator = By.xpath("//button[.=\"Yes\"]");
    private final By closeButtonLocator = By.cssSelector("[title=\"Close\"]");
    private final By backButtonLocator = By.cssSelector("[title=\"Back\"]");
    private final By nameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");

    private final By thirdPartyApplicationEditedMessageLocator = By.xpath("//p [.=\"Third Party Application updated successfullly\"]");
    private final By thirdPartyApplicationDeletedMessageLocator = By.xpath("//p [.=\"Selected URL has been deleted successfully\"]");

    private final By emptyNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name is required \"]");
    private final By emptyURLMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" URL is required \"]");
    private final By emptySiteMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Sites are required \"]");
    private final By emptyKeyMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Key is required \"]");
    private final By emptyValueMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Value is required \"]");

    private final By spacesOnlyNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name cannot contain spaces only \"]");
    private final By spacesOnlyURLMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" URL cannot contain spaces only \"]");
    private final By spacesOnlyKeyMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Key cannot contain spaces only \"]");
    private final By spacesOnlyValueMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Value cannot contain spaces only \"]");

    private final By invalidURLMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Invalid URL \"]");

    private final DriverFactory driver;

    public P11_ThirdPartyApplicationsAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add New Third Party Application Button")
    public P11_ThirdPartyApplicationsAdminPage clickOnAddNewThirdPartyApplicationButon() {
        LogsUtils.info("Clicking on Add New Third Party Allication Button");
        driver.elementUtils().clickOnElement(addNewThirdPartyApplicationButtonLocator);
        return this;
    }

    @Step("Enter Name: {name}")
    public P11_ThirdPartyApplicationsAdminPage enterName(String name) {
        LogsUtils.info("Entering Name: " + name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Select Site")
    public P11_ThirdPartyApplicationsAdminPage selectSite() {
        LogsUtils.info("Selecting Site");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Click on Site Dropdown")
    public P11_ThirdPartyApplicationsAdminPage clickOnSiteDropdown() {
        LogsUtils.info("Clicking on Site Dropdown");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        return this;
    }

    @Step("Enter URL: {URL}")
    public P11_ThirdPartyApplicationsAdminPage enterURL(String URL) {
        LogsUtils.info("Entering URL: " + URL);
        driver.elementUtils().sendDataToElement(urlTextFieldLocator, URL);
        return this;
    }

    @Step("Select Method")
    public P11_ThirdPartyApplicationsAdminPage selectMethod(String method) {
        LogsUtils.info("Selecting a method:", method);
        if (method.equalsIgnoreCase("get")) {
            driver.elementUtils().clickOnElement(getRadioButtonLocator);
        } else {
            driver.elementUtils().clickOnElement(postRadioButtonLocator);
        }
        return this;
    }

    @Step("Enter Tooltip: {Tooltip}")
    public P11_ThirdPartyApplicationsAdminPage enterTooltip(String tooltip) {
        LogsUtils.info("Entering Tooltip: " + tooltip);
        driver.elementUtils().sendDataToElement(tooltipTextFieldLocator, tooltip);
        return this;
    }

    @Step("Check Active checkbox")
    public P11_ThirdPartyApplicationsAdminPage checkActiveCheckbox() {
        LogsUtils.info("Checking Active checkbox");
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Add New Parameter Button")
    public P11_ThirdPartyApplicationsAdminPage clickOnAddNewParameterButton() {
        LogsUtils.info("Clicking on Add New Parameter Button");
        driver.elementUtils().clickOnElement(addNewParameterButtonLocator);
        return this;
    }

    @Step("Enter Key: {Key}")
    public P11_ThirdPartyApplicationsAdminPage enterKey(String key) {
        LogsUtils.info("Entering Key: " + key);
        driver.elementUtils().sendDataToElement(keyTextFieldLocator, key);
        return this;
    }

    @Step("Select Type")
    public P11_ThirdPartyApplicationsAdminPage selectType(String type) {
        LogsUtils.info("Selecting a type:", type);
        if (type.equalsIgnoreCase("constant")) {
            driver.elementUtils().clickOnElement(constantRadioButtonLocator);
        } else {
            driver.elementUtils().clickOnElement(variableRadioButtonLocator);
        }
        return this;
    }

    @Step("Enter Value: {value}")
    public P11_ThirdPartyApplicationsAdminPage enterValue(String value) {
        LogsUtils.info("Entering Key: " + value);
        driver.elementUtils().sendDataToElement(valueTextFieldLocator, value);
        return this;
    }

    @Step("Select Value")
    public P11_ThirdPartyApplicationsAdminPage selectValue() {
        LogsUtils.info("Selecting Value");
        driver.elementUtils().clickOnElement(valueTextFieldLocator);
        By valueOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(valueOptionLocator);
        return this;
    }

    @Step("Click on Save Parameter Button")
    public P11_ThirdPartyApplicationsAdminPage clickOnSaveParameterButton() {
        LogsUtils.info("Clicking on Save Parameter Button");
        driver.elementUtils().clickOnElement(saveParameterButtonLocator);
        return this;
    }

    @Step("Click on Save Button")
    public P11_ThirdPartyApplicationsAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save Button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P11_ThirdPartyApplicationsAdminPage clickOnEditButton(String name) {
        LogsUtils.info("Clicking on Edit button for Third Party Application: " + name);
        By editButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P11_ThirdPartyApplicationsAdminPage clickOnDeleteButton(String name) {
        LogsUtils.info("Clicking on Delete button for Third Party Application: " + name);
        By deleteButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes Button")
    public P11_ThirdPartyApplicationsAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes Button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on OK Button")
    public P11_ThirdPartyApplicationsAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK Button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Click on Close Button")
    public P11_ThirdPartyApplicationsAdminPage clickOnCloseButton() {
        LogsUtils.info("Clicking on Close Button");
        driver.elementUtils().clickOnElement(closeButtonLocator);
        return this;
    }

    @Step("Click on Back Button")
    public P11_ThirdPartyApplicationsAdminPage clickOnBackButton() {
        LogsUtils.info("Clicking on Back Button");
        driver.elementUtils().clickOnElement(backButtonLocator);
        return this;
    }

    @Step("Search Third Party Application by Name: {name}")
    public P11_ThirdPartyApplicationsAdminPage searchThirdPartyApplicationByName(String name) {
        LogsUtils.info("Searching Third Party Application by Name: " + name);
        driver.elementUtils().sendDataToElement(nameSearchFieldLocator, name);
        return this;
    }

    @Step("Assert visibility of Third Party Application Edited Alert")
    public void assertVisibilityOfThirdPartyApplicationEditedAlert() {
        LogsUtils.info("Asserting visibility of Third Party Application Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(thirdPartyApplicationEditedMessageLocator),
                "Third Party Application edited alert not visible"
        );
    }

    @Step("Assert visibility of Third Party Application Deleted Alert")
    public void assertVisibilityOfThirdPartyApplicationDeletedAlert() {
        LogsUtils.info("Asserting visibility of Third Party Application Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(thirdPartyApplicationDeletedMessageLocator),
                "Third Party Application deleted alert not visible"
        );
    }

    @Step("Assert visibility of Empty Name Message")
    public void assertVisibilityOfEmptyNameMessage() {
        LogsUtils.info("Asserting visibility of Empty Name Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyNameMessageLocator),
                "Empty name message not visible"
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

    @Step("Assert visibility of Empty URL Message")
    public void assertVisibilityOfEmptyURLMessage() {
        LogsUtils.info("Asserting visibility of Empty URL Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyURLMessageLocator),
                "Empty URL message not visible"
        );
    }

    @Step("Assert visibility of Empty Key Message")
    public void assertVisibilityOfEmptyKeyMessage() {
        LogsUtils.info("Asserting visibility of Empty Key Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyKeyMessageLocator),
                "Empty Key message not visible"
        );
    }

    @Step("Assert visibility of Empty Value Message")
    public void assertVisibilityOfEmptyValueMessage() {
        LogsUtils.info("Asserting visibility of Empty Value Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyValueMessageLocator),
                "Empty Value message not visible"
        );
    }

    @Step("Assert visibility of Spaces Only Name Message")
    public void assertVisibilityOfSpacesOnlyNameMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only Name Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyNameMessageLocator),
                "Spaces only name message not visible"
        );
    }

    @Step("Assert visibility of Spaces Only URL Message")
    public void assertVisibilityOfSpacesOnlyURLMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only URL Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyURLMessageLocator),
                "Spaces only URL message not visible"
        );
    }

    @Step("Assert visibility of Spaces Only Key Message")
    public void assertVisibilityOfSpacesOnlyKeyMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only Key Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyKeyMessageLocator),
                "Spaces only Key message not visible"
        );
    }

    @Step("Assert visibility of Spaces Only Value Message")
    public void assertVisibilityOfSpacesOnlyValueMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only Value Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyValueMessageLocator),
                "Spaces only Value message not visible"
        );
    }

    @Step("Assert visibility of Invalid URL Message")
    public void assertVisibilityOfInvalidURLMessage() {
        LogsUtils.info("Asserting visibility of Invalid URL Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(invalidURLMessageLocator),
                "Invalid URL message not visible"
        );
    }
}

