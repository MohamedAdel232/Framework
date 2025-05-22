package Pages;

import Factories.DriverFactory;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public class P14_MyLecturesPage {
    private final By newButtonLocator = By.cssSelector("[title=\"Add new lecture\"]");
    private final By titleTextFieldLocator = By.cssSelector("[formcontrolname=\"title\"]");
    private final By anatomyDropdownLocator = By.cssSelector("[formcontrolname=\"anatomy\"]");
    private final By subspecialtyDropdownLocator = By.cssSelector("[formcontrolname=\"subspeciality\"]");
    private final By publicCheckboxLocator = By.cssSelector("[title=\"Public\"]");
    private final By selectFilesButtonLocator = By.cssSelector("[type=\"file\"]");
    private final By notesTextFieldLocator = By.cssSelector("[formcontrolname=\"note\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By myLectureSearchFieldLocator = By.cssSelector("input[aria-label=\"Title Filter\"]");
    private final By noDataFoundMessageLocator = By.xpath("//div[text()=\"No data found\"]");
    private final By editButtonLocator = By.cssSelector("[title=\"Edit lecture\"]");
    private final By deleteButtonLocator = By.cssSelector("[title=\"Delete lecture\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By lectureAddedMessageLocator = By.cssSelector("[aria-label=\"Lecture added successfully\"]");
    private final By lectureEditedMessageLocator = By.cssSelector("[aria-label=\"Selected lecture has been updated successfully\"]");
    private final By lectureDeletedMessageLocator = By.cssSelector("[aria-label=\"The selected lecture has been deleted successfully\"]");
    
    private final DriverFactory driver;

    public P14_MyLecturesPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on New button")
    public P14_MyLecturesPage clickOnNewButton() {
        driver.elementUtils().clickOnElement(newButtonLocator);
        return this;
    }

    @Step("Enter title")
    public P14_MyLecturesPage enterTitle(String title) {
        driver.elementUtils().sendDataToElement(titleTextFieldLocator, title);
        return this;
    }

    @Step("Select anatomy")
    public P14_MyLecturesPage selectAnatomy() {
        driver.elementUtils().clickOnElement(anatomyDropdownLocator);
        By anatomyOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(anatomyOptionLocator);
        return this;
    }

    @Step("Select subspecialty")
    public P14_MyLecturesPage selectSubspecialty() {
        driver.elementUtils().clickOnElement(subspecialtyDropdownLocator);
        By subspecialtyOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(subspecialtyOptionLocator);
        return this;
    }

    @Step("Check public checkbox")
    public P14_MyLecturesPage checkPublicCheckbox() {
        driver.elementUtils().clickOnElement(publicCheckboxLocator);
        return this;
    }

    @Step("Upload a file")
    public P14_MyLecturesPage uploadFile(String filePath) {
        driver.elementUtils().uploadFile(selectFilesButtonLocator, filePath);
        return this;
    }

    @Step("Enter notes")
    public P14_MyLecturesPage enterNotes(String notes) {
        driver.elementUtils().sendDataToElement(notesTextFieldLocator, notes);
        return this;
    }

    @Step("Click on Save button")
    public P14_MyLecturesPage clickOnSaveButton() {
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Check lecture checkbox's")
    public P14_MyLecturesPage checkLectureCheckbox(String lectureTitle) {
        By checkboxLocator = RelativeLocator.with(By.cssSelector("[type=\"checkbox\"]"))
                .toLeftOf(By.xpath("//div[contains(text(), \"" + lectureTitle + "\")]"));
        driver.elementUtils().clickOnElement(checkboxLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P14_MyLecturesPage clickOnEditButton() {
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P14_MyLecturesPage clickOnDeleteButton() {
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P14_MyLecturesPage clickOnYesButton() {
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Search for a my lecture")
    public P14_MyLecturesPage searchForMyLecture(String lectureTitle) {
        driver.elementUtils().sendDataToElement(myLectureSearchFieldLocator, lectureTitle);
        return this;
    }

    @Step("Verify visibility of my lecture")
    public void assertVisibilityOfMyLecture(String lectureTitle) {
        By publicLectureLocator = By.xpath("//div[contains(text(), \"" + lectureTitle + "\")]");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(publicLectureLocator),
                "My lecture is not visible"
        );
    }

    @Step("Verify No data found message")
    public void assertVisibilityOfNoDataFoundMessage() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(noDataFoundMessageLocator),
                "No data found message is not visible"
        );
    }

    @Step("Verify Lecture added message")
    public void assertVisibilityOfLectureAddedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(lectureAddedMessageLocator),
                "Lecture added alert not visible"
        );
    }

    @Step("Verify Lecture edited message")
    public void assertVisibilityOfMyLectureEditedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(lectureEditedMessageLocator),
                "Lecture edited alert not visible"
        );
    }

    @Step("Verify Lecture deleted message")
    public void assertVisibilityOfMyLectureDeletedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(lectureDeletedMessageLocator),
                "Lecture deleted alert not visible"
        );
    }
}

