package Pages;

import Factories.DriverFactory;
import Utilities.DataBaseUtils;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public class P03_InstitutionsAdminPage {
    private final By addButtonLocator = By.id("addNewInstitution");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By activeCheckboxLocator = By.id("active");
    private final By saveButtonLocator = By.xpath("//span [.=\" Save \"]");
    private final By nameSearchTextFieldLocator = RelativeLocator.with(By.tagName("input")).below(By.xpath("//span [contains(text(),\"Name\")]"));
    private final By okButtonLocator = By.xpath("//button [.=\"OK\"]");
    private final By yesButtonLocator = By.xpath("//button[.=\"Yes\"]");
    private final By closeButtonLocator = By.cssSelector("[title=\"Close\"]");

    private final By institutionAddedMessageLocator = By.xpath("//p [.=\"Entered institution has been added successfully\"]");
    private final By institutionEditedMessageLocator = By.xpath("//p [.=\"Updated successfully\"]");
    private final By institutionDeletedMessageLocator = By.xpath("//p [.=\"The selected institution has been deleted successfully\"]");

    private final By nameIsRequiredMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name is required \"]");
    private final By nameCannotContainWhiteSpacesMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name cannot contain white spaces \"]");

    private final DriverFactory driver;

    public P03_InstitutionsAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add Button")
    public P03_InstitutionsAdminPage clickOnAddButton() {
        LogsUtils.info("Clicking on Add Button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter Name")
    public P03_InstitutionsAdminPage enterName(String name) {
        LogsUtils.info("Entering Name:", name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Check Active Checkbox")
    public P03_InstitutionsAdminPage checkActiveCheckbox() {
        LogsUtils.info("Check Active Checkbox");
        driver.elementUtils().checkCheckboxJS(activeCheckboxLocator);
        return this;
    }

    @Step("Uncheck Active Checkbox")
    public P03_InstitutionsAdminPage uncheckActiveCheckbox() {
        LogsUtils.info("Uncheck Active Checkbox");
        driver.elementUtils().uncheckCheckboxJS(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Save Button")
    public P03_InstitutionsAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save Button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Search for Institution by Name")
    public P03_InstitutionsAdminPage searchForInstitutionByName(String name) {
        LogsUtils.info("Searching for Institution:", name);
        driver.elementUtils().sendDataToElement(nameSearchTextFieldLocator, name);
        return this;
    }

    @Step("Click on OK Button")
    public P03_InstitutionsAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK Button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Click on Yes Button")
    public P03_InstitutionsAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes Button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on Close Button")
    public P03_InstitutionsAdminPage clickOnCloseButton() {
        LogsUtils.info("Clicking on Close Button");
        driver.elementUtils().clickOnElement(closeButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P03_InstitutionsAdminPage clickOnEditButton(String institutionName) {
        LogsUtils.info("Clicking on Edit Button for Institution: " + institutionName);
        By editButtonLocator = By.xpath("//td[.='" + institutionName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Delete Institution Records in Modalities Table in the DB")
    public P03_InstitutionsAdminPage deleteInstitutionRecordsInModalitiesTableInTheDB(String institutionName) {
        LogsUtils.info("Delete Institution Records in Modalities Table in the DB");
        DataBaseUtils.configure("jdbc:postgresql://192.168.2.90:5432/paip", "postgres", "P@ssw0rd@Lotus");
        DataBaseUtils.executeUpdate("delete FROM modalities\n" +
                "WHERE institutionid IN (\n" +
                "    SELECT id FROM institutions WHERE name = '" + institutionName + "'\n" +
                ");");
        DataBaseUtils.closeConnection();
        return this;
    }

    @Step("Click on Delete button")
    public P03_InstitutionsAdminPage clickOnDeleteButton(String institutionName) {
        LogsUtils.info("Clicking on Delete Button for Institution: " + institutionName);
        By deleteButtonLocator = By.xpath("//td[.='" + institutionName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Assert Institution Added Message")
    public void assertInstitutionAddedMessage(String expectedInstitutionAddedMessage) {
        LogsUtils.info("Asserting Institution Added Message");
        String actualInstitutionAddedMessage = driver.elementUtils().getDataFromElement(institutionAddedMessageLocator);
        LogsUtils.info("Expected Institution Added Message:", expectedInstitutionAddedMessage);
        LogsUtils.info("Actual Institution Added Message:", actualInstitutionAddedMessage);
        SoftAssertUtils.softAssertEquals(actualInstitutionAddedMessage, expectedInstitutionAddedMessage,
                "Wrong Institution Added Message");
    }

    @Step("Assert Institution Edited Message")
    public void assertInstitutionEditedMessage(String expectedInstitutionEditedMessage) {
        LogsUtils.info("Asserting Institution Edited Message");
        String actualInstitutionEditedMessage = driver.elementUtils().getDataFromElement(institutionEditedMessageLocator);
        LogsUtils.info("Expected Institution Edited Message:", expectedInstitutionEditedMessage);
        LogsUtils.info("Actual Institution Edited Message:", actualInstitutionEditedMessage);
        SoftAssertUtils.softAssertEquals(actualInstitutionEditedMessage, expectedInstitutionEditedMessage,
                "Wrong Institution Edited Message");
    }

    @Step("Assert Institution Deleted Message")
    public void assertInstitutionDeletedMessage(String expectedInstitutionDeletedMessage) {
        LogsUtils.info("Asserting Institution Deleted Message");
        String actualInstitutionDeletedMessage = driver.elementUtils().getDataFromElement(institutionDeletedMessageLocator);
        LogsUtils.info("Expected Institution Deleted Message:", expectedInstitutionDeletedMessage);
        LogsUtils.info("Actual Institution Deleted Message:", actualInstitutionDeletedMessage);
        SoftAssertUtils.softAssertEquals(actualInstitutionDeletedMessage, expectedInstitutionDeletedMessage,
                "Wrong Institution Deleted Message");
    }

    @Step("Assert Visibility of Name is Required Message")
    public void assertVisibilityOfNameIsRequiredMessage() {
        LogsUtils.info("Asserting Visibility Of Name Is Required Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(nameIsRequiredMessageLocator),
                "Name Is Required Message is not Displayed");
    }

    @Step("Assert Visibility of Name Cannot Contain White Spaces Message")
    public void assertVisibilityOfNameCannotContainWhiteSpacesMessage() {
        LogsUtils.info("Asserting Visibility Of Name Cannot Contain White Spaces Message");
        SoftAssertUtils.softAssertTrue(driver.elementUtils().verifyVisibilityOfElement(nameCannotContainWhiteSpacesMessageLocator),
                "Name Cannot Contain White Spaces Message is not Displayed");
    }
}
