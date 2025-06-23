package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P08_DICOMOriginsAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"New DICOM Origin\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By aeTitleTextFieldLocator = By.cssSelector("[formcontrolname=\"aeTitle\"]");
    private final By sendingAETitleTextFieldLocator = By.cssSelector("[formcontrolname=\"sendingAETitle\"]");
    private final By institutionDropdownLocator = By.cssSelector("[formcontrolname=\"institution\"]");
    private final By locationDropdownLocator = By.cssSelector("[formcontrolname=\"location\"]");
    private final By aiCheckboxLocator = By.id("ai");
    private final By activeCheckboxLocator = By.id("active");
    private final By saveButtonLocator = By.xpath("//span[.=' Save ']");
    private final By nameSearchTextFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By okButtonLocator = By.xpath("//button [.='OK']");
    private final By yesButtonLocator = By.xpath("//button[.='Yes']");
    private final By closeButtonLocator = By.cssSelector("[title=\"Close\"]");

    private final By dicomOriginAddedMessageLocator = By.xpath("//p [.='DICOM origin has been added successfully.']");
    private final By dicomOriginEditedMessageLocator = By.xpath("//p [.='The selected DICOM origin has been updated successfully.']");
    private final By dicomOriginDeletedMessageLocator = By.xpath("//p [.='The selected DICOM origin has been deleted successfully.']");

    private final By nameIsRequiredMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' Name is required ']");
    private final By nameCannotContainWhiteSpacesOnlyMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' Name cannot contain white spaces only ']");

    private final By aeTitleIsRequiredMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' AE title is required ']");
    private final By aeTitleCannotContainWhiteSpacesMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' AE title cannot contain spaces ']");

    private final By sendingAETitleIsRequiredMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' Sending AE title is required ']");
    private final By sendingAETitleCannotContainWhiteSpacesMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' Sending AE title cannot contain spaces ']");

    private final By institutionIsRequiredMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' Institution is required ']");

    private final By pleaseSelectAtLeastOneLocationMessageLocator = By.xpath("//div [@class='text-danger ng-star-inserted'][.=' Please select at least one Location ']");

    private final DriverFactory driver;

    public P08_DICOMOriginsAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add Button")
    public P08_DICOMOriginsAdminPage clickOnAddButton() {
        LogsUtils.info("Clicking on Add Button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter Name")
    public P08_DICOMOriginsAdminPage enterName(String name) {
        LogsUtils.info("Entering Name:", name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Enter AE Title")
    public P08_DICOMOriginsAdminPage enterAETitle(String aeTitle) {
        LogsUtils.info("Entering AE Title:", aeTitle);
        driver.elementUtils().sendDataToElement(aeTitleTextFieldLocator, aeTitle);
        return this;
    }

    @Step("Enter Sending AE Title")
    public P08_DICOMOriginsAdminPage enterSendingAETitle(String sendingAETitle) {
        LogsUtils.info("Entering Sending AE Title:", sendingAETitle);
        driver.elementUtils().clearElement(sendingAETitleTextFieldLocator);
        driver.elementUtils().sendDataToElement(sendingAETitleTextFieldLocator, sendingAETitle);
        return this;
    }

    @Step("Select Institution")
    public P08_DICOMOriginsAdminPage selectInstitution(String institution) {
        LogsUtils.info("Selecting Institution:", institution);
        driver.elementUtils().clickOnElement(institutionDropdownLocator);
        By institutionOptionLocator = By.xpath("//li[.=' " + institution + " ']");
        driver.elementUtils().clickOnElement(institutionOptionLocator);
        return this;
    }

    @Step("Click on Institution Dropdown")
    public P08_DICOMOriginsAdminPage clickOnInstitutionDropdown() {
        LogsUtils.info("Clicking on Institution Dropdown");
        driver.elementUtils().clickOnElement(institutionDropdownLocator);
        return this;
    }

    @Step("Select Location")
    public P08_DICOMOriginsAdminPage selectLocation() {
        LogsUtils.info("Selecting Location");
        driver.elementUtils().clickOnElement(locationDropdownLocator);
        By locationOptionLocator = By.xpath("(//li[@role='option'])[1]");
        driver.elementUtils().clickOnElement(locationOptionLocator);
        return this;
    }

    @Step("Click On Location Dropdown")
    public P08_DICOMOriginsAdminPage clickOnLocationDropdown() {
        LogsUtils.info("Clicking On Location Dropdown");
        driver.elementUtils().clickOnElement(locationDropdownLocator);
        return this;
    }

    @Step("Check AI Checkbox")
    public P08_DICOMOriginsAdminPage checkAICheckbox() {
        LogsUtils.info("Check AI Checkbox");
        driver.elementUtils().checkCheckboxJS(aiCheckboxLocator);
        return this;
    }

    @Step("Uncheck AI Checkbox")
    public P08_DICOMOriginsAdminPage uncheckAICheckbox() {
        LogsUtils.info("Uncheck AI Checkbox");
        driver.elementUtils().uncheckCheckboxJS(aiCheckboxLocator);
        return this;
    }

    @Step("Check Active Checkbox")
    public P08_DICOMOriginsAdminPage checkOnActiveCheckbox() {
        LogsUtils.info("Check Active Checkbox");
        driver.elementUtils().checkCheckboxJS(activeCheckboxLocator);
        return this;
    }

    @Step("Uncheck Active Checkbox")
    public P08_DICOMOriginsAdminPage uncheckOnActiveCheckbox() {
        LogsUtils.info("Uncheck Active Checkbox");
        driver.elementUtils().uncheckCheckboxJS(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Save Button")
    public P08_DICOMOriginsAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save Button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Search for DICOM Origin by Name")
    public P08_DICOMOriginsAdminPage searchForDICOMOriginByName(String name) {
        LogsUtils.info("Searching for DICOM Origin:", name);
        driver.elementUtils().sendDataToElement(nameSearchTextFieldLocator, name);
        return this;
    }

    @Step("Click on OK Button")
    public P08_DICOMOriginsAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK Button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Click on Yes Button")
    public P08_DICOMOriginsAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes Button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on Close Button")
    public P08_DICOMOriginsAdminPage clickOnCloseButton() {
        LogsUtils.info("Clicking on Close Button");
        driver.elementUtils().clickOnElement(closeButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P08_DICOMOriginsAdminPage clickOnEditButton(String originName) {
        LogsUtils.info("Clicking on Edit Button for DICOM Origin: " + originName);
        By editButtonLocator = By.xpath("//td[.='" + originName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P08_DICOMOriginsAdminPage clickOnDeleteButton(String originName) {
        LogsUtils.info("Clicking on Delete Button for DICOM Origin: " + originName);
        By deleteButtonLocator = By.xpath("//td[.='" + originName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Assert DICOM Origin Added Message")
    public void assertDICOMOriginAddedMessage(String expectedMessage) {
        LogsUtils.info("Asserting DICOM Origin Added Message");
        String actualMessage = driver.elementUtils().getDataFromElement(dicomOriginAddedMessageLocator);
        LogsUtils.info("Expected DICOM Origin Added Message:", expectedMessage);
        LogsUtils.info("Actual DICOM Origin Added Message:", actualMessage);
        SoftAssertUtils.softAssertEquals(actualMessage, expectedMessage, "Wrong DICOM Origin Added Message");
    }

    @Step("Assert DICOM Origin Edited Message")
    public void assertDICOMOriginEditedMessage(String expectedMessage) {
        LogsUtils.info("Asserting DICOM Origin Edited Message");
        String actualMessage = driver.elementUtils().getDataFromElement(dicomOriginEditedMessageLocator);
        LogsUtils.info("Expected DICOM Origin Edited Message:", expectedMessage);
        LogsUtils.info("Actual DICOM Origin Edited Message:", actualMessage);
        SoftAssertUtils.softAssertEquals(actualMessage, expectedMessage, "Wrong DICOM Origin Edited Message");
    }

    @Step("Assert DICOM Origin Deleted Message")
    public void assertDICOMOriginDeletedMessage(String expectedMessage) {
        LogsUtils.info("Asserting DICOM Origin Deleted Message");
        String actualMessage = driver.elementUtils().getDataFromElement(dicomOriginDeletedMessageLocator);
        LogsUtils.info("Expected DICOM Origin Deleted Message:", expectedMessage);
        LogsUtils.info("Actual DICOM Origin Deleted Message:", actualMessage);
        SoftAssertUtils.softAssertEquals(actualMessage, expectedMessage, "Wrong DICOM Origin Deleted Message");
    }

    @Step("Assert Visibility of Name is Required Message")
    public void assertVisibilityOfNameIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of Name Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(nameIsRequiredMessageLocator),
                "Name Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of Name Cannot Contain White Spaces Only Message")
    public void assertVisibilityOfNameCannotContainWhiteSpacesOnlyMessage() {
        LogsUtils.info("Asserting Visibility Of Name Cannot Contain White Spaces Only Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(nameCannotContainWhiteSpacesOnlyMessageLocator),
                "Name Cannot Contain White Spaces Only Message is not Displayed");
    }

    @Step("Assert Visibility of AE Title is Required Message")
    public void assertVisibilityOfAETitleIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of AE Title Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(aeTitleIsRequiredMessageLocator),
                "AE Title Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of AE Title Cannot Contain White Spaces Message")
    public void assertVisibilityOfAETitleCannotContainWhiteSpacesMessage() {
        LogsUtils.info("Asserting Visibility Of AE Title Cannot Contain White Spaces Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(aeTitleCannotContainWhiteSpacesMessageLocator),
                "AE Title Cannot Contain White Spaces Message is not Displayed");
    }

    @Step("Assert Visibility of Sending AE Title is Required Message")
    public void assertVisibilityOfSendingAETitleIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of Sending AE Title Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(sendingAETitleIsRequiredMessageLocator),
                "Sending AE Title Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of Sending AE Title Cannot Contain White Spaces Message")
    public void assertVisibilityOfSendingAETitleCannotContainWhiteSpacesMessage() {
        LogsUtils.info("Asserting Visibility Of Sending AE Title Cannot Contain White Spaces Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(sendingAETitleCannotContainWhiteSpacesMessageLocator),
                "Sending AE Title Cannot Contain White Spaces Message is not Displayed");
    }

    @Step("Assert Visibility of Institution is Required Message")
    public void assertVisibilityOfInstitutionIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of Institution Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(institutionIsRequiredMessageLocator),
                "Institution Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of Please Select At Least One Location Message")
    public void assertVisibilityOfPleaseSelectAtLeastOneLocationMessage() {
        LogsUtils.info("Asserting Visibility Of Please Select At Least One Location Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(pleaseSelectAtLeastOneLocationMessageLocator),
                "Please Select At Least One Location Message is not Displayed");
    }
} 