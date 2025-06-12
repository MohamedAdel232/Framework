package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import Utilities.SoftAssertUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P10_PACSViewersAdminPage {
    private final By addNewPACSViewersButtonLocator = By.cssSelector("[title=\"New PACS Viewer\"]");
    private final By nameTextFieldLocator = By.cssSelector("[formcontrolname=\"name\"]");
    private final By urlRadioButtonLocator = By.cssSelector("[title=\"URL\"]");
    private final By webSocketRadioButtonLocator = By.cssSelector("[title=\"WebSocket\"]");
    private final By siteDropdownLocator = By.cssSelector("[formcontrolname=\"sites\"]");
    private final By pacsServerDropdownLocator = By.cssSelector("[formcontrolname=\"pacsservers\"]");
    private final By viewerURLTextFieldLocator = By.cssSelector("[formcontrolname=\"url\"]");
    private final By getRadioButtonLocator = By.cssSelector("[title=\"Get\"]");
    private final By postRadioButtonLocator = By.cssSelector("[title=\"Post\"]");
    private final By anonymisedCheckboxLocator = By.cssSelector("[formcontrolname=\"anonymized\"]");
    private final By encodedCheckboxLocator = By.cssSelector("[formcontrolname=\"encode\"]");
    private final By encryptedCheckboxLocator = By.cssSelector("[formcontrolname=\"encrypted\"]");
    private final By parameterKeyTextFieldLocator = By.cssSelector("[formcontrolname=\"encryptedParameterKey\"]");
    private final By uploadWebSocketFileButtonLocator = By.cssSelector("input[type=\"file\"]");
    private final By saveButtonLocator = By.cssSelector("[title=\"Save\"]");
    private final By yesButtonLocator = By.xpath("//button[.=\"Yes\"]");
    private final By okButtonLocator = By.xpath("//button[.=\"OK\"]");
    private final By closeButtonLocator = By.cssSelector("[title=\"Close\"]");
    private final By nameSearchFieldLocator = By.cssSelector("input[aria-label=\"Name Filter\"]");
    private final By webSocketTextFieldLocator = By.cssSelector("[formcontrolname=\"url\"]");

    private final By pacsViewersEditedMessageLocator = By.xpath("//p [.=\"PACS viewer has been updated successfully\"]");
    private final By pacsViewersDeletedMessageLocator = By.xpath("//p [.=\"Selected PACS viewer has been deleted successfully\"]");

    private final By emptyNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name is required \"]");
    private final By emptyViewerURLMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" PACS URL is required \"]");
    private final By emptyParameterKeyMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Parameter key is required \"]");
    private final By emptySiteMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Sites is required \"]");
    private final By emptyPACSServersMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" PACS Servers is required \"]");
    private final By emptyWebSocketFileMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" WebSocket file is required \"]");

    private final By spacesOnlyNameMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Name cannot contain spaces only \"]");
    private final By spacesOnlyViewerURLMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Viewer URL cannot contain spaces only \"]");
    private final By spacesOnlyParameterKeyMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Parameter key cannot contain spaces only \"]");

    private final By invalidViewerURLMessageLocator = By.xpath("//div [@class=\"text-danger ng-star-inserted\"][.=\" Invalid URL \"]");
    private final By invalidWebSocketFileMessageLocator = By.xpath("//p [.=\"Please upload a valid file ,JS only (.js)\"]");


    private final DriverFactory driver;

    public P10_PACSViewersAdminPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Sites Button")
    public P10_PACSViewersAdminPage clickOnAddNewPACSViewersButon() {
        LogsUtils.info("Clicking on Add New PACS Viewers Button");
        driver.elementUtils().clickOnElement(addNewPACSViewersButtonLocator);
        return this;
    }

    @Step("Enter Name: {name}")
    public P10_PACSViewersAdminPage enterPACSViewersName(String name) {
        LogsUtils.info("Entering Name: " + name);
        driver.elementUtils().sendDataToElement(nameTextFieldLocator, name);
        return this;
    }

    @Step("Select PACS Viewer Type")
    public P10_PACSViewersAdminPage selectPACSViewerType(String type) {
        LogsUtils.info("Selecting PACS Viewer Type:", type);
        if (type.equalsIgnoreCase("url")) {
            driver.elementUtils().clickOnElement(urlRadioButtonLocator);
        } else {
            driver.elementUtils().clickOnElement(webSocketRadioButtonLocator);
        }
        return this;
    }

    @Step("Select Site")
    public P10_PACSViewersAdminPage selectSite() {
        LogsUtils.info("Selecting Site");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[2]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Click on Site Dropdown")
    public P10_PACSViewersAdminPage clickOnSiteDropdown() {
        LogsUtils.info("Clicking on Site Dropdown");
        driver.elementUtils().clickOnElement(siteDropdownLocator);
        return this;
    }

    @Step("Select PACS Server")
    public P10_PACSViewersAdminPage selectPACSServer() {
        LogsUtils.info("Selecting PACS Server");
        driver.elementUtils().clickOnElement(pacsServerDropdownLocator);
        By siteOptionLocator = By.xpath("(//ul[@role=\"listbox\"] //li)[1]");
        driver.elementUtils().clickOnElement(siteOptionLocator);
        return this;
    }

    @Step("Click on PACS Server Dropdown")
    public P10_PACSViewersAdminPage clickOnPACSServerDropdown() {
        LogsUtils.info("Clicking on PACS Server Dropdown");
        driver.elementUtils().clickOnElement(pacsServerDropdownLocator);
        return this;
    }

    @Step("Enter Viewer URL: {url}")
    public P10_PACSViewersAdminPage enterViewerURL(String url) {
        LogsUtils.info("Entering Viewer URL: " + url);
        driver.elementUtils().sendDataToElement(viewerURLTextFieldLocator, url);
        return this;
    }

    @Step("Select Method")
    public P10_PACSViewersAdminPage selectMethod(String method) {
        LogsUtils.info("Selecting a method:", method);
        if (method.equalsIgnoreCase("get")) {
            driver.elementUtils().clickOnElement(getRadioButtonLocator);
        } else {
            driver.elementUtils().clickOnElement(postRadioButtonLocator);
        }
        return this;
    }

    @Step("Check Anonymised Checkbox")
    public P10_PACSViewersAdminPage checkAnonymisedCheckbox() {
        LogsUtils.info("Check Anonymised Checkbox");
        driver.elementUtils().clickOnElement(anonymisedCheckboxLocator);
        return this;
    }

    @Step("Check Encoded Checkbox")
    public P10_PACSViewersAdminPage checkEncodedCheckbox() {
        LogsUtils.info("Check Encoded Checkbox");
        driver.elementUtils().clickOnElement(encodedCheckboxLocator);
        return this;
    }

    @Step("Check Encrypted Checkbox")
    public P10_PACSViewersAdminPage checkEncryptedCheckbox() {
        LogsUtils.info("Check Encrypted Checkbox");
        driver.elementUtils().clickOnElement(encryptedCheckboxLocator);
        return this;
    }

    @Step("Enter Parameter Key: {parameterKey}")
    public P10_PACSViewersAdminPage enterParameterKey(String parameterKey) {
        LogsUtils.info("Entering Parameter Key: " + parameterKey);
        driver.elementUtils().sendDataToElement(parameterKeyTextFieldLocator, parameterKey);
        return this;
    }

    @Step("Upload WebSocket File")
    public P10_PACSViewersAdminPage uploadWebsocketFile(String filePath) {
        LogsUtils.info("Uploading Websocket File");
        driver.elementUtils().uploadFile(uploadWebSocketFileButtonLocator, filePath);
        return this;
    }

    @Step("Click on WebSocket Text Field")
    public P10_PACSViewersAdminPage clickOnWebSocketTextField() {
        LogsUtils.info("Clicking on WebSocket Text Field");
        driver.elementUtils().clickOnElement(webSocketTextFieldLocator);
        return this;
    }

    @Step("Click on Save Button")
    public P10_PACSViewersAdminPage clickOnSaveButton() {
        LogsUtils.info("Clicking on Save Button");
        driver.elementUtils().clickOnElement(saveButtonLocator);
        return this;
    }

    @Step("Click on Edit button")
    public P10_PACSViewersAdminPage clickOnEditButton(String name) {
        LogsUtils.info("Clicking on Edit button for PACS Viewer: " + name);
        By editButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Edit']");
        driver.elementUtils().clickOnElement(editButtonLocator);
        return this;
    }

    @Step("Click on Delete button")
    public P10_PACSViewersAdminPage clickOnDeleteButton(String name) {
        LogsUtils.info("Clicking on Delete button for PACS Viewer: " + name);
        By deleteButtonLocator = By.xpath("//td[.='" + name + "']/following-sibling::td//a[@title='Delete']");
        driver.elementUtils().clickOnElement(deleteButtonLocator);
        return this;
    }

    @Step("Click on Yes Button")
    public P10_PACSViewersAdminPage clickOnYesButton() {
        LogsUtils.info("Clicking on Yes Button");
        driver.elementUtils().clickOnElement(yesButtonLocator);
        return this;
    }

    @Step("Click on OK Button")
    public P10_PACSViewersAdminPage clickOnOkButton() {
        LogsUtils.info("Clicking on OK Button");
        driver.elementUtils().clickOnElement(okButtonLocator);
        return this;
    }

    @Step("Click on Close Button")
    public P10_PACSViewersAdminPage clickOnCloseButton() {
        LogsUtils.info("Clicking on Close Button");
        driver.elementUtils().clickOnElement(closeButtonLocator);
        return this;
    }

    @Step("Search PACS Viewers by Name: {name}")
    public P10_PACSViewersAdminPage searchPACSViewersByName(String name) {
        LogsUtils.info("Searching PACS Viewers by Name: " + name);
        driver.elementUtils().sendDataToElement(nameSearchFieldLocator, name);
        return this;
    }

    @Step("Assert visibility of PACS Viewers Edited Alert")
    public void assertVisibilityOfPACSViewersEditedAlert() {
        LogsUtils.info("Asserting visibility of PACS Viewers Edited Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(pacsViewersEditedMessageLocator),
                "PACS Viewers edited alert not visible"
        );
    }

    @Step("Assert visibility of PACS Viewers Deleted Alert")
    public void assertVisibilityOfPACSViewersDeletedAlert() {
        LogsUtils.info("Asserting visibility of PACS Viewers Deleted Alert");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(pacsViewersDeletedMessageLocator),
                "PACS Viewers deleted alert not visible"
        );
    }

    @Step("Assert visibility of Empty Name Message")
    public void assertVisibilityOfEmptyNameMessage() {
        LogsUtils.info("Asserting visibility of Empty Name Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyNameMessageLocator),
                "Empty name message not visible"
        );
    }

    @Step("Assert visibility of Empty Site Message")
    public void assertVisibilityOfEmptySiteMessage() {
        LogsUtils.info("Asserting visibility of Empty Site Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptySiteMessageLocator),
                "Empty site message not visible"
        );
    }

    @Step("Assert visibility of Empty PACS Server Message")
    public void assertVisibilityOfEmptyPACSServerMessage() {
        LogsUtils.info("Asserting visibility of Empty PACS Server Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyPACSServersMessageLocator),
                "Empty PACS Server message not visible"
        );
    }

    @Step("Assert visibility of Empty WebSocket File Message")
    public void assertVisibilityOfEmptyWebSocketFileMessage() {
        LogsUtils.info("Asserting visibility of Empty WebSocket File Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyWebSocketFileMessageLocator),
                "Empty WebSocket File message not visible"
        );
    }

    @Step("Assert visibility of Empty Viewer URL Message")
    public void assertVisibilityOfEmptyViewerURLMessage() {
        LogsUtils.info("Asserting visibility of Empty Viewer URL Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyViewerURLMessageLocator),
                "Empty Viewer URL message not visible"
        );
    }

    @Step("Assert visibility of Empty Parameter Key Message")
    public void assertVisibilityOfEmptyParameterKeyMessage() {
        LogsUtils.info("Asserting visibility of Empty Parameter Key Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(emptyParameterKeyMessageLocator),
                "Empty Parameter Key message not visible"
        );
    }

    @Step("Assert visibility of Spaces Only Name Message")
    public void assertVisibilityOfSpacesOnlyNameMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only Name Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyNameMessageLocator),
                "Spaces only name message not visible"
        );
    }

    @Step("Assert visibility of Spaces Only Viewer URL Message")
    public void assertVisibilityOfSpacesOnlyViewerURLMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only Viewer URL Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyViewerURLMessageLocator),
                "Spaces only Viewer URL message not visible"
        );
    }

    @Step("Assert visibility of Spaces Only Parameter Key Message")
    public void assertVisibilityOfSpacesOnlyParameterKeyMessage() {
        LogsUtils.info("Asserting visibility of Spaces Only Parameter Key Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(spacesOnlyParameterKeyMessageLocator),
                "Spaces only Parameter Key message not visible"
        );
    }

    @Step("Assert visibility of Invalid Viewer URL Message")
    public void assertVisibilityOfInvalidViewerURLMessage() {
        LogsUtils.info("Asserting visibility of Invalid Viewer URL Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(invalidViewerURLMessageLocator),
                "Invalid Viewer URL message not visible"
        );
    }

    @Step("Assert visibility of Invalid WebSocket File Message")
    public void assertVisibilityOfInvalidWebSocketFileMessage() {
        LogsUtils.info("Asserting visibility of Invalid WebSocket File Message");
        SoftAssertUtils.softAssertTrue(
                driver.elementUtils().verifyVisibilityOfElement(invalidWebSocketFileMessageLocator),
                "Invalid WebSocket File message not visible"
        );
    }
}
