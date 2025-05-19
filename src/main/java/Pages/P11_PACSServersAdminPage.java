package Pages;

import Factories.DriverFactory;
import Utilities.ClipboardUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P11_PACSServersAdminPage {
    private final By addButtonLocator = By.cssSelector("[title='Add new PACS server']");
    private final By nameFieldLocator = By.cssSelector("[formcontrolname='name']");
    private final By ipAddressFieldLocator = By.cssSelector("[formcontrolname='ip']");
    private final By aeTitleFieldLocator = By.cssSelector("[formcontrolname='aeTitle']");
    private final By portFieldLocator = By.cssSelector("[formcontrolname=\"port\"]");
    private final By issuerOfPatientIdFieldLocator = By.cssSelector("[formcontrolname=\"patientIdIssuer\"]");
    private final By siteFieldLocator = By.cssSelector("[formcontrolname=\"sites\"]");
    private final By activeCheckboxLocator = By.cssSelector("input[title=\"Active\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By pacsServerAddedMessageLocator = By.cssSelector("[aria-label=\"PACS server has been added successfully\"]");
    private final By pacsServerEditedMessageLocator = By.cssSelector("[aria-label=\"PACS server has been edited successfully\"]");
    private final By pacsServerDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected PACS server has been deleted successfully\"]");

    private final DriverFactory driver;

    public P11_PACSServersAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add button")
    public P11_PACSServersAdminPage clickOnAddButton() {
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter name")
    public P11_PACSServersAdminPage enterName(String name) {
        driver.elementUtils().sendDataToElement(nameFieldLocator, name);
        return this;
    }

    @Step("Enter IP address")
    public P11_PACSServersAdminPage enterIPAddress(String ipAddress) {
        driver.elementUtils().sendDataToElement(ipAddressFieldLocator, ipAddress);
        return this;
    }

    @Step("Enter AE Title")
    public P11_PACSServersAdminPage enterAETitle(String aeTitle) {
        driver.elementUtils().sendDataToElement(aeTitleFieldLocator, aeTitle);
        return this;
    }

    @Step("Enter port")
    public P11_PACSServersAdminPage enterPort(String port) {
        driver.elementUtils().clickOnElement(portFieldLocator);
        ClipboardUtils.copyToClipboard(port);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Enter issuer of patient ID")
    public P11_PACSServersAdminPage enterIssuerOfPatientId(String issuerOfPatientId) {
        driver.elementUtils().sendDataToElement(issuerOfPatientIdFieldLocator, issuerOfPatientId);
        return this;
    }

    @Step("Select site")
    public P11_PACSServersAdminPage selectSite() {
        driver.elementUtils().clickOnElement(siteFieldLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Click on Active checkbox")
    public P11_PACSServersAdminPage clickOnActiveCheckbox() {
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Save button")
    public P11_PACSServersAdminPage clickOnSaveButton() {
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P11_PACSServersAdminPage clickOnYesButton() {
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P11_PACSServersAdminPage clickOnEditButton(String pacsServerName) {
        By editButtonLocator = By.xpath("//td[.='" + pacsServerName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P11_PACSServersAdminPage clickOnDeleteButton(String pacsServerName) {
        By deleteButtonLocator = By.xpath("//td[.='" + pacsServerName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Verify PACS Server added message")
    public void assertVisibilityOfPacsServerAddedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(pacsServerAddedMessageLocator),
                "PACS Server added alert not visible"
        );
    }

    @Step("Verify PACS Server edited message")
    public void assertVisibilityOfPacsServerEditedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(pacsServerEditedMessageLocator),
                "PACS Server edited alert not visible"
        );
    }

    @Step("Verify PACS Server deleted message")
    public void assertVisibilityOfPacsServerDeletedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(pacsServerDeletedMessageLocator),
                "PACS Server deleted alert not visible"
        );
    }
}
