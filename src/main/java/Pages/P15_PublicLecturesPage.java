package Pages;

import Factories.DriverFactory;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P15_PublicLecturesPage {
    private final By publicLectureSearchFieldLocator = By.cssSelector("input[aria-label=\"Title Filter\"]");
    private final By noDataFoundMessageLocator = By.xpath("//div[text()=\"No data found\"]");
    private final By deleteButtonLocator = By.cssSelector("[title=\"Delete lecture\"]");

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
}
