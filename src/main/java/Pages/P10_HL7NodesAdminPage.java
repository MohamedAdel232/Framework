package Pages;

import Factories.DriverFactory;
import Utilities.ClipboardUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P10_HL7NodesAdminPage {
    private final By addButtonLocator = By.cssSelector("[title='Add new hl7 node']");
    private final By nameFieldLocator = By.cssSelector("[formcontrolname='name']");
    private final By portFieldLocator = By.cssSelector("[formcontrolname=\"port\"]");
    private final By descriptionFieldLocator = By.cssSelector("[formcontrolname=\"description\"]");
    private final By siteFieldLocator = By.cssSelector("[formcontrolname=\"sites\"]");
    private final By activeCheckboxLocator = By.cssSelector("input[title=\"Active\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By hl7NodeAddedMessageLocator = By.cssSelector("[aria-label=\"HL7 Node has been added successfully\"]");
    private final By hl7NodeEditedMessageLocator = By.cssSelector("[aria-label=\"HL7 Node has been updated successfully\"]");

    private final DriverFactory driver;

    public P10_HL7NodesAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add button")
    public P10_HL7NodesAdminPage clickOnAddButton() {
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter name")
    public P10_HL7NodesAdminPage enterName(String name) {
        driver.elementUtils().sendDataToElement(nameFieldLocator, name);
        return this;
    }

    @Step("Enter description")
    public P10_HL7NodesAdminPage enterDescription(String description) {
        driver.elementUtils().sendDataToElement(descriptionFieldLocator, description);
        return this;
    }

    @Step("Enter port")
    public P10_HL7NodesAdminPage enterPort(String port) {
        driver.elementUtils().clickOnElement(portFieldLocator);
        ClipboardUtils.copyToClipboard(port);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Select site")
    public P10_HL7NodesAdminPage selectSite() {
        driver.elementUtils().clickOnElement(siteFieldLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Click on Active checkbox")
    public P10_HL7NodesAdminPage clickOnActiveCheckbox() {
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Save button")
    public P10_HL7NodesAdminPage clickOnSaveButton() {
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P10_HL7NodesAdminPage clickOnYesButton() {
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P10_HL7NodesAdminPage clickOnEditButton(String hl7NodeName) {
        By editButtonLocator = By.xpath("//td[.='" + hl7NodeName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P10_HL7NodesAdminPage clickOnDeleteButton(String hl7NodeName) {
        By deleteButtonLocator = By.xpath("//td[.='" + hl7NodeName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Verify HL7 Node added message")
    public void assertVisibilityOfHL7NodeAddedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(hl7NodeAddedMessageLocator),
                "HL7 node added alert not visible"
        );
    }

    @Step("Verify HL7 Node edited message")
    public void assertVisibilityOfHL7NodeEditedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(hl7NodeEditedMessageLocator),
                "HL7 node edited alert not visible"
        );
    }

    @Step("Verify HL7 Node deleted message")
    public void assertVisibilityOfHL7NodeDeletedAlert(String hl7NodeName) {
        By hl7NodeDeletedMessageLocator = By.cssSelector("[aria-label='\"" + hl7NodeName + "\" node has been deleted successfully']");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(hl7NodeDeletedMessageLocator),
                "HL7 node deleted alert not visible"
        );
    }
}
