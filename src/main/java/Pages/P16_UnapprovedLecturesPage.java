package Pages;

import Factories.DriverFactory;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P16_UnapprovedLecturesPage {
    private final By publicLectureSearchFieldLocator = By.cssSelector("input[aria-label=\"Title Filter\"]");
    private final By noDataFoundMessageLocator = By.xpath("//div[text()=\"No data found\"]");

    private final DriverFactory driver;

    public P16_UnapprovedLecturesPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Search for a unapproved lecture")
    public P16_UnapprovedLecturesPage searchForPublicLecture(String lectureTitle) {
        driver.elementUtils().sendDataToElement(publicLectureSearchFieldLocator, lectureTitle);
        return this;
    }

    @Step("Verify visibility of unapproved lecture")
    public void assertVisibilityOfPublicLecture(String lectureTitle) {
        By publicLectureLocator = By.xpath("//div[contains(text(), \"" + lectureTitle + "\")]");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(publicLectureLocator),
                "Unapproved lecture is not visible"
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
