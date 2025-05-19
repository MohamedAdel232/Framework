package Pages;

import Factories.DriverFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public class P06_AnatomyAdminPage {
    private final By addButtonLocator = By.cssSelector("[title='Add new anatomy']");
    private final By nameFieldLocator = RelativeLocator.with(By.tagName("input")).toRightOf(By.xpath("//label[contains(text(), 'Name')]"));
    private final By acrCodeFieldLocator = By.cssSelector("[formcontrolname='acrCode']");
    private final By saveButtonLocator = By.cssSelector("[title='Save']");
    private final By anatomyAddedMessageLocator = By.cssSelector("[aria-label='Anatomy has been added successfully']");
    private final By anatomyEditedMessageLocator = By.cssSelector("[aria-label='Selected anatomy has been edited successfully']");
    private final By anatomyDeletedMessageLocator = By.cssSelector("[aria-label='Selected anatomy has been deleted successfully']");
    private final By yesButtonLocator = By.cssSelector("[title='Yes']");
    private final By anatomyNameSearchFieldLocator = By.cssSelector("input[aria-label=\"Anatomy Name Filter\"]");

    private final DriverFactory driver;

    public P06_AnatomyAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add button")
    public P06_AnatomyAdminPage clickOnAddButton() {
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter name")
    public P06_AnatomyAdminPage enterName(String name) {
        driver.elementUtils().sendDataToElement(nameFieldLocator, name);
        return this;
    }

    @Step("Enter name")
    public P06_AnatomyAdminPage enterACRCode(String acrCode) {
        driver.elementUtils().sendDataToElement(acrCodeFieldLocator, acrCode);
        return this;
    }

    @Step("Click on Save button")
    public P06_AnatomyAdminPage clickOnSaveButton() {
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P06_AnatomyAdminPage clickOnEditButton(String anatomy) {
        By editButtonLocator = By.xpath("//div[text()=\"" + anatomy + "\"]//../following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P06_AnatomyAdminPage clickOnDeleteButton(String anatomy) {
        By deleteButtonLocator = By.xpath("//div[text()=\"" + anatomy + "\"]//../following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P06_AnatomyAdminPage clickOnYesButton() {
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Search for Anatomy")
    public P06_AnatomyAdminPage searchForAnatomy(String anatomy) {
        driver.elementUtils().sendDataToElement(anatomyNameSearchFieldLocator, anatomy);
        return this;
    }

    @Step("Assert visibility of Anatomy Added Alert")
    public P06_AnatomyAdminPage assertVisibilityOfAnatomyAddedAlert() {
        driver.elementUtils().verifyVisibilityOfElement(anatomyAddedMessageLocator);
        return this;
    }

    @Step("Assert visibility of Anatomy Edited Alert")
    public P06_AnatomyAdminPage assertVisibilityOfAnatomyEditedAlert() {
        driver.elementUtils().verifyVisibilityOfElement(anatomyEditedMessageLocator);
        return this;
    }

    @Step("Assert visibility of Anatomy Deleted Alert")
    public P06_AnatomyAdminPage assertVisibilityOfAnatomyDeletedAlert() {
        driver.elementUtils().verifyVisibilityOfElement(anatomyDeletedMessageLocator);
        return this;
    }
}
