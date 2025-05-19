package Pages;

import Factories.DriverFactory;
import Utilities.ClipboardUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P08_DICOMDestinationsAdminPage {
    private final By addButtonLocator = By.cssSelector("[title='Add new DICOM destination']");
    private final By nameFieldLocator = By.cssSelector("[formcontrolname='name']");
    private final By ipAddressFieldLocator = By.cssSelector("[formcontrolname='ip']");
    private final By aeTitleFieldLocator = By.cssSelector("[formcontrolname='aeTitle']");
    private final By portFieldLocator = By.cssSelector("[formcontrolname=\"port\"]");
    private final By siteFieldLocator = By.cssSelector("[formcontrolname=\"sites\"]");
    private final By activeCheckboxLocator = By.cssSelector("input[title=\"Active\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By dicomDestinationAddedMessageLocator = By.cssSelector("[aria-label=\"DICOM destination has been added successfully\"]");
    private final By dicomDestinationEditedMessageLocator = By.cssSelector("[aria-label=\"DICOM destination has been edited successfully\"]");
    private final By dicomDestinationDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected DICOM destination has been deleted successfully\"]");

    private final DriverFactory driver;

    public P08_DICOMDestinationsAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add button")
    public P08_DICOMDestinationsAdminPage clickOnAddButton() {
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter name")
    public P08_DICOMDestinationsAdminPage enterName(String name) {
        driver.elementUtils().sendDataToElement(nameFieldLocator, name);
        return this;
    }

    @Step("Enter IP address")
    public P08_DICOMDestinationsAdminPage enterIPAddress(String ipAddress) {
        driver.elementUtils().sendDataToElement(ipAddressFieldLocator, ipAddress);
        return this;
    }

    @Step("Enter AE Title")
    public P08_DICOMDestinationsAdminPage enterAETitle(String aeTitle) {
        driver.elementUtils().sendDataToElement(aeTitleFieldLocator, aeTitle);
        return this;
    }

    @Step("Enter port")
    public P08_DICOMDestinationsAdminPage enterPort(String port) {
        driver.elementUtils().clickOnElement(portFieldLocator);
        ClipboardUtils.copyToClipboard(port);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Select site")
    public P08_DICOMDestinationsAdminPage selectSite() {
        driver.elementUtils().clickOnElement(siteFieldLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Click on Active checkbox")
    public P08_DICOMDestinationsAdminPage clickOnActiveCheckbox() {
        driver.elementUtils().clickOnElement(activeCheckboxLocator);
        return this;
    }

    @Step("Click on Save button")
    public P08_DICOMDestinationsAdminPage clickOnSaveButton() {
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P08_DICOMDestinationsAdminPage clickOnYesButton() {
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P08_DICOMDestinationsAdminPage clickOnEditButton(String dicomDestinationName) {
        By editButtonLocator = By.xpath("//td[.='" + dicomDestinationName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P08_DICOMDestinationsAdminPage clickOnDeleteButton(String dicomDestinationName) {
        By deleteButtonLocator = By.xpath("//td[.='" + dicomDestinationName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Verify DICOM Destination added message")
    public void assertVisibilityOfDICOMDestinationAddedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(dicomDestinationAddedMessageLocator),
                "DICOM Destination added alert not visible"
        );
    }

    @Step("Verify DICOM Destination edited message")
    public void assertVisibilityOfDICOMDestinationEditedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(dicomDestinationEditedMessageLocator),
                "DICOM Destination edited alert not visible"
        );
    }

    @Step("Verify DICOM Destination deleted message")
    public void assertVisibilityOfDICOMDestinationDeletedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(dicomDestinationDeletedMessageLocator),
                "DICOM Destination deleted alert not visible"
        );
    }
}
