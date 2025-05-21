package Pages;

import Factories.DriverFactory;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public class P13_ReferencesPage {
    private final By newButtonLocator = By.cssSelector("[title=\"Add new reference\"]");
    private final By titleTextFieldLocator = By.cssSelector("[formcontrolname=\"title\"]");
    private final By anatomyDropdownLocator = By.cssSelector("[formcontrolname=\"anatomyId\"]");
    private final By subspecialtyDropdownLocator = By.cssSelector("[formcontrolname=\"specialityId\"]");
    private final By selectFilesButtonLocator = By.cssSelector("[type=\"file\"]");
    private final By notesTextFieldLocator = By.cssSelector("[formcontrolname=\"note\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By editButtonLocator = By.cssSelector("[title=\"Edit reference\"]");
    private final By referenceAddedMessageLocator = By.cssSelector("[aria-label=\"Reference has been added successfully\"]");
    private final By referenceEditedMessageLocator = By.cssSelector("[aria-label=\"Selected reference has been edited successfully\"]");
    private final By referenceDeletedMessageLocator = By.cssSelector("[aria-label=\"The selected reference has been deleted successfully\"]");

    private final DriverFactory driver;

    public P13_ReferencesPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on New button")
    public P13_ReferencesPage clickOnNewButton() {
        driver.elementUtils().clickOnElement(newButtonLocator);
        return this;
    }

    @Step("Enter title")
    public P13_ReferencesPage enterTitle(String title) {
        driver.elementUtils().sendDataToElement(titleTextFieldLocator, title);
        return this;
    }

    @Step("Select anatomy")
    public P13_ReferencesPage selectAnatomy() {
        driver.elementUtils().clickOnElement(anatomyDropdownLocator);
        By anatomyOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(anatomyOptionLocator);
        return this;
    }

    @Step("Select subspecialty")
    public P13_ReferencesPage selectSubspecialty() {
        driver.elementUtils().clickOnElement(subspecialtyDropdownLocator);
        By subspecialtyOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(subspecialtyOptionLocator);
        return this;
    }

    @Step("Upload a file")
    public P13_ReferencesPage uploadFile(String filePath) {
        driver.elementUtils().uploadFile(selectFilesButtonLocator, filePath);
        return this;
    }

    @Step("Enter notes")
    public P13_ReferencesPage enterNotes(String notes) {
        driver.elementUtils().sendDataToElement(notesTextFieldLocator, notes);
        return this;
    }

    @Step("Click on Save button")
    public P13_ReferencesPage clickOnSaveButton() {
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P13_ReferencesPage clickOnEditButton(String referenceTitle) {
        By checkboxLocator = RelativeLocator.with(By.cssSelector("[type=\"checkbox\"]"))
                .toLeftOf(By.xpath("//div[contains(text(), \"" + referenceTitle + "\")]"));
        driver.elementUtils().clickOnElement(checkboxLocator);
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Verify Reference added message")
    public void assertVisibilityOfReferenceAddedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(referenceAddedMessageLocator),
                "Reference added alert not visible"
        );
    }

    @Step("Verify Reference edited message")
    public void assertVisibilityOfReferenceEditedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(referenceEditedMessageLocator),
                "Reference edited alert not visible"
        );
    }

    @Step("Verify Reference deleted message")
    public void assertVisibilityOfReferenceDeletedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(referenceDeletedMessageLocator),
                "Reference deleted alert not visible"
        );
    }
}
