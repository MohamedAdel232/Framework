package Pages;

import Factories.DriverFactory;
import Utilities.ClipboardUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P18_ImagePresetsAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new image preset\"]");
    private final By presetMenuNameFieldLocator = By.xpath("(//input[@formcontrolname=\"name\"])[1]");
    private final By modalityDropdownLocator = By.cssSelector("[formcontrolname=\"modality\"]");
    private final By siteDropdownLocator = By.cssSelector("[formcontrolname=\"sites\"]");
    private final By presetNameFieldLocator = By.xpath("(//input[@formcontrolname=\"name\"])[2]");
    private final By wlFieldLocator = By.cssSelector("[formcontrolname=\"level\"]");
    private final By wwFieldLocator = By.cssSelector("[formcontrolname=\"width\"]");
    private final By shortcutDropdownLocator = By.cssSelector("[formcontrolname=\"shortcut\"]");
    private final By addPresetsButtonLocator = By.cssSelector("[title=\"Add\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By searchFieldLocator = By.cssSelector("input[aria-label=\"Presets Menu Name Filter\"]");
    private final By imagePresetAddedMessageLocator = By.cssSelector("[aria-label=\"Image preset has been Added successfully\"]");
    private final By imagePresetEditedMessageLocator = By.cssSelector("[aria-label=\"Image preset has been Updated successfully\"]");
    private final By imagePresetDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected image preset has been deleted successfully\"]");

    private final DriverFactory driver;

    public P18_ImagePresetsAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add button")
    public P18_ImagePresetsAdminPage clickOnAddButton() {
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter preset menu name")
    public P18_ImagePresetsAdminPage enterPresetMenuName(String presetMenuName) {
        driver.elementUtils().sendDataToElement(presetMenuNameFieldLocator, presetMenuName);
        return this;
    }

    @Step("Select modality")
    public P18_ImagePresetsAdminPage selectModality() {
        driver.elementUtils().clickOnElement(modalityDropdownLocator);
        By modalityOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(modalityOptionLocator);
        return this;
    }

    @Step("Select site")
    public P18_ImagePresetsAdminPage selectSite() {
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Enter preset name")
    public P18_ImagePresetsAdminPage enterPresetName(String presetName) {
        driver.elementUtils().sendDataToElement(presetNameFieldLocator, presetName);
        return this;
    }

    @Step("Enter WL value")
    public P18_ImagePresetsAdminPage enterWL(String wl) {
        driver.elementUtils().clickOnElement(wlFieldLocator);
        ClipboardUtils.copyToClipboard(wl);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Enter WW value")
    public P18_ImagePresetsAdminPage enterWW(String ww) {
        driver.elementUtils().clickOnElement(wwFieldLocator);
        ClipboardUtils.copyToClipboard(ww);
        driver.clipboardUtils().pasteFromClipboard();
        return this;
    }

    @Step("Select shortcut")
    public P18_ImagePresetsAdminPage selectShortcut() {
        driver.elementUtils().clickOnElement(shortcutDropdownLocator);
        By shortcutOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(shortcutOptionLocator);
        return this;
    }

    @Step("Click on Add Presets button")
    public P18_ImagePresetsAdminPage clickOnAddPresetsButton() {
        driver.elementUtils().clickOnElement(addPresetsButtonLocator);
        return this;
    }

    @Step("Click on Save button")
    public P18_ImagePresetsAdminPage clickOnSaveButton() {
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P18_ImagePresetsAdminPage clickOnYesButton() {
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P18_ImagePresetsAdminPage clickOnEditButton(String presetName) {
        By editButtonLocator = By.xpath("//td[.='" + presetName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P18_ImagePresetsAdminPage clickOnDeleteButton(String presetName) {
        By deleteButtonLocator = By.xpath("//td[.='" + presetName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Search for Image Preset")
    public P18_ImagePresetsAdminPage searchForImagePreset(String presetName) {
        driver.elementUtils().sendDataToElement(searchFieldLocator, presetName);
        return this;
    }

    @Step("Verify Image Preset added message")
    public void assertVisibilityOfImagePresetAddedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(imagePresetAddedMessageLocator),
                "Image Preset added alert not visible"
        );
    }

    @Step("Verify Image Preset edited message")
    public void assertVisibilityOfImagePresetEditedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(imagePresetEditedMessageLocator),
                "Image Preset edited alert not visible"
        );
    }

    @Step("Verify Image Preset deleted message")
    public void assertVisibilityOfImagePresetDeletedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(imagePresetDeletedMessageLocator),
                "Image Preset deleted alert not visible"
        );
    }
} 