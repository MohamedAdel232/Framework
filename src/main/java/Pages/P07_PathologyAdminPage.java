package Pages;

import Factories.DriverFactory;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public class P07_PathologyAdminPage {
    private final By addButtonLocator = By.cssSelector("[title='Add new pathology']");
    private final By nameFieldLocator = RelativeLocator.with(By.tagName("input")).toRightOf(By.xpath("//label[contains(text(), 'Name')]"));
    private final By acrCodeFieldLocator = By.cssSelector("[formcontrolname='acrCode']");
    private final By anatomyDropdownLocator = By.cssSelector("[formcontrolname='anatomyID']");
    private final By saveButtonLocator = By.cssSelector("[title='Save']");
    private final By pathologyAddedMessageLocator = By.cssSelector("[aria-label='Pathology has been added successfully']");
    private final By pathologyEditedMessageLocator = By.cssSelector("[aria-label='Selected pathology has been edited successfully']");
    private final By pathologyDeletedMessageLocator = By.cssSelector("[aria-label='Selected pathology has been deleted successfully']");
    private final By yesButtonLocator = By.cssSelector("[title='Yes']");
    private final By pathologyNameSearchFieldLocator = By.cssSelector("input[aria-label=\"Pathology Name Filter\"]");

    private final DriverFactory driver;

    public P07_PathologyAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add button")
    public P07_PathologyAdminPage clickOnAddButton() {
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter name")
    public P07_PathologyAdminPage enterName(String name) {
        driver.elementUtils().sendDataToElement(nameFieldLocator, name);
        return this;
    }

    @Step("Enter name")
    public P07_PathologyAdminPage enterACRCode(String acrCode) {
        driver.elementUtils().sendDataToElement(acrCodeFieldLocator, acrCode);
        return this;
    }

    @Step("Select anatomy")
    public P07_PathologyAdminPage selectAnatomy() {
        driver.elementUtils().clickOnElement(anatomyDropdownLocator);
        By anatomyOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(anatomyOptionLocator);
        return this;
    }

    @Step("Click on Save button")
    public P07_PathologyAdminPage clickOnSaveButton() {
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P07_PathologyAdminPage clickOnEditButton(String anatomy) {
        By editButtonLocator = By.xpath("//div[text()=\"" + anatomy + "\"]//../following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P07_PathologyAdminPage clickOnDeleteButton(String anatomy) {
        By deleteButtonLocator = By.xpath("//div[text()=\"" + anatomy + "\"]//../following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P07_PathologyAdminPage clickOnYesButton() {
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Search for Pathology")
    public P07_PathologyAdminPage searchForPathology(String anatomy) {
        driver.elementUtils().sendDataToElement(pathologyNameSearchFieldLocator, anatomy);
        return this;
    }

    @Step("Assert visibility of Pathology Added Alert")
    public void assertVisibilityOfPathologyAddedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(pathologyAddedMessageLocator),
                "Pathology edited alert not visible"
        );
    }

    @Step("Assert visibility of Pathology Edited Alert")
    public void assertVisibilityOfPathologyEditedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(pathologyEditedMessageLocator),
                "Pathology edited alert not visible"
        );
    }

    @Step("Assert visibility of Pathology Deleted Alert")
    public void assertVisibilityOfPathologyDeletedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(pathologyDeletedMessageLocator),
                "Pathology edited alert not visible"
        );
    }
}