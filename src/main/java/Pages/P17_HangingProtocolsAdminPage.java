package Pages;

import Factories.DriverFactory;
import Utilities.ClipboardUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P17_HangingProtocolsAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new hanging protocol\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By modalityTextFieldLocator = By.cssSelector("[formcontrolname=\"modality\"]");
    private final By autoDisplayPriorsCheckboxLocator = By.cssSelector("[formcontrolname=\"autoDisplayPriors\"]");
    private final By sitesDropdownLocator = By.cssSelector("[formcontrolname=\"sites\"]");
    private final By rowsTextFieldLocator = By.cssSelector("[formcontrolname=\"rows\"]");
    private final By columnsTextFieldLocator = By.cssSelector("[formcontrolname=\"columns\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By searchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By hangingProtocolAddedMessageLocator = By.cssSelector("[aria-label=\"Hanging protocol has been Added successfully\"]");
    private final By hangingProtocolEditedMessageLocator = By.cssSelector("[aria-label=\"Hanging protocol has been Updated successfully\"]");
    private final By hangingProtocolDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected hanging protocol has been deleted successfully\"]");

    private final DriverFactory driver;

    public P17_HangingProtocolsAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add button")
    public P17_HangingProtocolsAdminPage clickOnAddButton() {
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter name")
    public P17_HangingProtocolsAdminPage enterName(String name) {
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Enter modality")
    public P17_HangingProtocolsAdminPage enterModality(String modality) {
        driver.elementUtils().sendDataToElement(modalityTextFieldLocator, modality);
        return this;
    }

    @Step("Check Auto Display Priors checkbox")
    public P17_HangingProtocolsAdminPage checkAutoDisplayPriorsCheckbox() {
        driver.elementUtils().clickOnElement(autoDisplayPriorsCheckboxLocator);
        return this;
    }

    @Step("Select site")
    public P17_HangingProtocolsAdminPage selectSiteFromDropdown() {
        driver.elementUtils().clickOnElement(sitesDropdownLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Enter rows")
    public P17_HangingProtocolsAdminPage enterRows(String rows) {
        driver.elementUtils().clickOnElement(rowsTextFieldLocator);
        ClipboardUtils.copyToClipboard(rows);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Enter columns")
    public P17_HangingProtocolsAdminPage enterColumns(String columns) {
        driver.elementUtils().clickOnElement(columnsTextFieldLocator);
        ClipboardUtils.copyToClipboard(columns);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Click on Save button")
    public P17_HangingProtocolsAdminPage clickOnSaveButton() {
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P17_HangingProtocolsAdminPage clickOnYesButton() {
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P17_HangingProtocolsAdminPage clickOnEditButton(String hangingProtocolName) {
        By editButtonLocator = By.xpath("//td[.='" + hangingProtocolName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P17_HangingProtocolsAdminPage clickOnDeleteButton(String hangingProtocolName) {
        By deleteButtonLocator = By.xpath("//td[.='" + hangingProtocolName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Search for Hanging Protocol")
    public P17_HangingProtocolsAdminPage searchForHangingProtocol(String name) {
        driver.elementUtils().sendDataToElement(searchFieldLocator, name);
        return this;
    }

    @Step("Verify Hanging Protocol added message")
    public void assertVisibilityOfHangingProtocolAddedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(hangingProtocolAddedMessageLocator),
                "Hanging Protocol added alert not visible"
        );
    }

    @Step("Verify Hanging Protocol edited message")
    public void assertVisibilityOfHangingProtocolEditedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(hangingProtocolEditedMessageLocator),
                "Hanging Protocol edited alert not visible"
        );
    }

    @Step("Verify Hanging Protocol deleted message")
    public void assertVisibilityOfHangingProtocolDeletedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(hangingProtocolDeletedMessageLocator),
                "Hanging Protocol deleted alert not visible"
        );
    }
}