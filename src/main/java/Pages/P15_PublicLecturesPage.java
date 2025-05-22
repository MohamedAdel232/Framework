package Pages;

import Factories.DriverFactory;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public class P15_PublicLecturesPage {
    private final By publicLectureSearchFieldLocator = By.cssSelector("input[aria-label=\"Title Filter\"]");
    private final By noDataFoundMessageLocator = By.xpath("//div[text()=\"No data found\"]");
    private final By deleteButtonLocator = By.cssSelector("[title=\"Delete\"]");
    private final By lectureDeletedMessageLocator = By.cssSelector("[aria-label=\"The selected lecture has been deleted successfully. The original lecture was not affected\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");

    private final DriverFactory driver;

    public P15_PublicLecturesPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Search for a public lecture")
    public P15_PublicLecturesPage searchForPublicLecture(String lectureTitle) {
        driver.elementUtils().sendDataToElement(publicLectureSearchFieldLocator, lectureTitle);
        return this;
    }

    @Step("Click on Delete button")
    public P15_PublicLecturesPage clickOnDeleteButton() {
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P15_PublicLecturesPage clickOnYesButton() {
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Check lecture checkbox's")
    public P15_PublicLecturesPage checkLectureCheckbox(String lectureTitle) {
        By checkboxLocator = RelativeLocator.with(By.cssSelector("[type=\"checkbox\"]"))
                .toLeftOf(By.xpath("//div[contains(text(), \"" + lectureTitle + "\")]"));
        driver.elementUtils().clickOnElement(checkboxLocator);
        return this;
    }

    @Step("Verify visibility of public lecture")
    public void assertVisibilityOfPublicLecture(String lectureTitle) {
        By publicLectureLocator = By.xpath("//div[contains(text(), \"" + lectureTitle + "\")]");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(publicLectureLocator),
                "Public lecture is not visible"
        );
    }

    @Step("Verify No data found message")
    public void assertVisibilityOfNoDataFoundMessage() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(noDataFoundMessageLocator),
                "No data found message is not visible"
        );
    }

    @Step("Verify Lecture deleted message")
    public void assertVisibilityOfPublicLectureDeletedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(lectureDeletedMessageLocator),
                "Lecture deleted alert not visible"
        );
    }
}
