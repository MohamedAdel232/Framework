package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P05_OrderingLocationsAdminPage {
    private final By addButtonLocator = By.cssSelector("[title=\"Add new ordering location\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By hl7ValueTextFieldLocator = By.cssSelector("[formcontrolname=\"hl7Value\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By cancelButtonLocator = By.cssSelector("[title=\"Cancel\"]");
    private final By orderingLocationNameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");

    private final By yesButtonLocator = By.cssSelector("[title=\"Yes\"]");
    private final By orderingLocationAddedMessageLocator = By.cssSelector("[aria-label=\"New ordering location has been added successfully\"]");
    private final By orderingLocationEditedMessageLocator = By.cssSelector("[aria-label=\"Selected ordering location has been updated successfully\"]");
    private final By orderingLocationDeletedMessageLocator = By.cssSelector("[aria-label=\"Selected ordering location has been deleted successfully\"]");
    private final By emptyNameFieldMessageLocator = By.cssSelector("[aria-label='Ordering location name cannot be empty or contain spaces only, please enter a valid name']");
    private final By emptyHL7ValueFieldMessageLocator = By.cssSelector("[aria-label='Ordering location HL7 value cannot be empty or contain spaces only, please enter a valid HL7 value']");

    private final DriverFactory driver;

    public P05_OrderingLocationsAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Add Ordering Location button")
    public P05_OrderingLocationsAdminPage clickOnAddOrderingLocationButton() {
        LogsUtils.info("Clicking on Add button");
        driver.elementUtils().clickOnElement(addButtonLocator);
        return this;
    }

    @Step("Enter Ordering Location name")
    public P05_OrderingLocationsAdminPage enterOrderingLocationName(String name) {
        LogsUtils.info("Entering Ordering Location name: " + name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Enter Ordering Location HL7 Value")
    public P05_OrderingLocationsAdminPage enterOrderingLocationHL7Value(String hl7Value) {
        LogsUtils.info("Entering Ordering Location HL7 Value: " + hl7Value);
        driver.elementUtils().sendDataToElement(hl7ValueTextFieldLocator, hl7Value);
        return this;
    }

    @Step("Click on Save button")
    public P05_OrderingLocationsAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Cancel button")
    public P05_OrderingLocationsAdminPage clickOnCancelButton() {
        LogsUtils.info("Clicking on Cancel button");
        driver.elementUtils().clickOnElement(cancelButtonLocator);
        return this;
    }

    @Step("Search for Ordering Location by name")
    public P05_OrderingLocationsAdminPage searchForOrderingLocationByName(String name) {
        LogsUtils.info("Searching for Ordering Location by name: " + name);
        driver.elementUtils().sendDataToElement(orderingLocationNameSearchFieldLocator, name);
        return this;
    }

    @Step("Click on Edit button")
    public P05_OrderingLocationsAdminPage clickOnEditButton(String orderingLocationName) throws InterruptedException {
        Thread.sleep(600);
        LogsUtils.info("Clicking on Edit button for Ordering Location: " + orderingLocationName);
        By editButtonLocator = By.xpath("//td[.='" + orderingLocationName + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P05_OrderingLocationsAdminPage clickOnDeleteButton(String orderingLocationName) {
        LogsUtils.info("Clicking on Delete button for Ordering Location: " + orderingLocationName);
        By deleteButtonLocator = By.xpath("//td[.='" + orderingLocationName + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes button")
    public P05_OrderingLocationsAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Assert visibility of Ordering Location Added Alert")
    public void assertVisibilityOfOrderingLocationAddedAlert() {
        LogsUtils.info("Asserting visibility of Ordering Location Added Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(orderingLocationAddedMessageLocator),
                "Ordering Location added alert not visible"
        );
    }

    @Step("Assert visibility of Ordering Location Edited Alert")
    public void assertVisibilityOfOrderingLocationEditedAlert() {
        LogsUtils.info("Asserting visibility of Ordering Location Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(orderingLocationEditedMessageLocator),
                "Ordering Location edited alert not visible"
        );
    }

    @Step("Assert visibility of Ordering Location Deleted Alert")
    public void assertVisibilityOfOrderingLocationDeletedAlert() {
        LogsUtils.info("Asserting visibility of Ordering Location Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(orderingLocationDeletedMessageLocator),
                "Ordering Location deleted alert not visible"
        );
    }

    @Step("Assert visibility of empty name field message")
    public void assertVisibilityOfEmptyNameFieldMessage() {
        LogsUtils.info("Asserting visibility of empty name field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyNameFieldMessageLocator),
                "Empty name field message not visible"
        );
    }

    @Step("Assert visibility of empty HL7 value field message")
    public void assertVisibilityOfEmptyHL7ValueFieldMessage() {
        LogsUtils.info("Asserting visibility of empty HL7 value field message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyHL7ValueFieldMessageLocator),
                "Empty HL7 value field message not visible"
        );
    }
} 