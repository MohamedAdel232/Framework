package Pages;

import Factories.DriverFactory;
import Utilities.DataBaseUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public class P16_UnapprovedLecturesPage {
    private final By unapprovedLectureSearchFieldLocator = By.cssSelector("input[aria-label=\"Title Filter\"]");
    private final By noDataFoundMessageLocator = By.xpath("//div[text()=\"No data found\"]");
    private final By approveButtonLocator = By.cssSelector("[title=\"Approve\"]");
    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By lectureApprovedMessageLocator = By.cssSelector("[aria-label=\"The selected lecture has been approved successfully. The original lecture was not affected\"]");

    private final DriverFactory driver;

    public P16_UnapprovedLecturesPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Search for a unapproved lecture")
    public P16_UnapprovedLecturesPage searchForPublicLecture(String lectureTitle) {
        driver.elementUtils().sendDataToElement(unapprovedLectureSearchFieldLocator, lectureTitle);
        return this;
    }

    @Step("Make lecture unapproved")
    public P16_UnapprovedLecturesPage makeLectureUnapproved(String lectureTitle) {
        DataBaseUtils.configure("jdbc:postgresql://192.168.2.97:5432/icode-tfs", "postgres", "P@ssw0rd@Lotus");
        DataBaseUtils.executeUpdate("UPDATE lecture SET ispublic = true WHERE title = '" + lectureTitle + "';");
        DataBaseUtils.closeConnection();
        return this;
    }

    @Step("Click on Approve button")
    public P16_UnapprovedLecturesPage clickOnApproveButton() {
        driver.elementUtils().clickOnElement(approveButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P16_UnapprovedLecturesPage clickOnYesButton() {
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Check lecture checkbox's")
    public P16_UnapprovedLecturesPage checkLectureCheckbox(String lectureTitle) {
        By checkboxLocator = RelativeLocator.with(By.cssSelector("[type=\"checkbox\"]"))
                .toLeftOf(By.xpath("//div[contains(text(), \"" + lectureTitle + "\")]"));
        driver.elementUtils().clickOnElement(checkboxLocator);
        return this;
    }

    @Step("Verify visibility of unapproved lecture")
    public void assertVisibilityOfUnapprovedLecture(String lectureTitle) {
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

    @Step("Verify Lecture approved message")
    public void assertVisibilityOfLectureApprovedAlert() {
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(lectureApprovedMessageLocator),
                "Lecture approved alert not visible"
        );
    }
}
