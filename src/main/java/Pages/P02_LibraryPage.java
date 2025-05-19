package Pages;

import Factories.DriverFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P02_LibraryPage {
    private final By libraryButtonLocator = By.xpath("//span[text()=\"Library\"] /..");
    private final By iCodeAdministrationButtonLocator = By.xpath("//span[text()=\"iCode Administration\"] /..");
    private final By sitesButtonLocator = By.cssSelector("[href=\"/iCodeTFS/admin/sites\"]");
    private final By usersManagementButtonLocator = By.xpath("//span[text()=\"Users Management\"] /..");
    private final By userGroupsButtonLocator = By.cssSelector("[href=\"/iCodeTFS/admin/usergroups\"]");
    private final By generalConfigButtonLocator = By.xpath("//span[text()=\"General Configuration\"] /..");
    private final By activeDirectoriesButtonLocator = By.cssSelector("[href=\"/iCodeTFS/admin/activedirectories\"]");
    private final By anatomyButtonLocator = By.cssSelector("[href=\"/iCodeTFS/anatomies\"]");
    private final By pathologyButtonLocator = By.cssSelector("[href=\"/iCodeTFS/pathologies\"]");
    private final By dicomConfigButtonLocator = By.xpath("//span[text()=\"DICOM Configuration\"] /..");
    private final By dicomDestinationsButtonLocator = By.cssSelector("[href=\"/iCodeTFS/dicom/destinations\"]");
    private final By webConferencingToolsButtonLocator = By.cssSelector("[href=\"/iCodeTFS/admin/webconferencingtools\"]");
    private final By hl7ConfigButtonLocator = By.xpath("//span[text()=\"HL7 Configuration\"] /..");
    private final By hl7NodesButtonLocator = By.cssSelector("[href=\"/iCodeTFS/hl7/hl7nodes\"]");
    private final By pacsServersButtonLocator = By.cssSelector("[href=\"/iCodeTFS/pacsservers\"]");


    private final DriverFactory driver;

    public P02_LibraryPage(DriverFactory driver) {
        this.driver = driver;
    }

    @Step("Click on Library button")
    public P02_LibraryPage clickOnLibraryButton() throws InterruptedException {
        //Thread.sleep(1000);
        driver.elementUtils().clickOnElement(libraryButtonLocator);
        return this;
    }

    @Step("Click on iCode Administration button")
    public P02_LibraryPage clickOnICodeAdministrationButton() throws InterruptedException {
        //Thread.sleep(1000);
        driver.elementUtils().clickOnElement(iCodeAdministrationButtonLocator);
        return this;
    }

    @Step("Click on Sites button")
    public P03_SitesAdminPage clickOnSitesButton() {
        driver.elementUtils().clickOnElement(sitesButtonLocator);
        return new P03_SitesAdminPage(driver);
    }

    @Step("Click on Users Management button")
    public P02_LibraryPage clickOnUsersManagementButton() throws InterruptedException {
//        Thread.sleep(1000);
        driver.elementUtils().clickOnElement(usersManagementButtonLocator);
        return this;
    }

    @Step("Click on User Groups button")
    public P04_UserGroupsAdminPage clickOnUserGroupsButton() {
        driver.elementUtils().clickOnElement(userGroupsButtonLocator);
        return new P04_UserGroupsAdminPage(driver);
    }

    @Step("Click on General Configuration button")
    public P02_LibraryPage clickOnGeneralConfigButton() {
        driver.elementUtils().clickOnElement(generalConfigButtonLocator);
        return new P02_LibraryPage(driver);
    }

    @Step("Click on Active Directories button")
    public P05_ActiveDirectoriesAdminPage clickOnActiveDirectoriesButton() {
        driver.elementUtils().clickOnElement(activeDirectoriesButtonLocator);
        return new P05_ActiveDirectoriesAdminPage(driver);
    }

    @Step("Click on Anatomy button")
    public P06_AnatomyAdminPage clickOnAnatomyButton() {
        driver.elementUtils().clickOnElement(anatomyButtonLocator);
        return new P06_AnatomyAdminPage(driver);
    }

    @Step("Click on Pathology button")
    public P07_PathologyAdminPage clickOnPathologyButton() {
        driver.elementUtils().clickOnElement(pathologyButtonLocator);
        return new P07_PathologyAdminPage(driver);
    }

    @Step("Click on DICOM Configuration button")
    public P02_LibraryPage clickOnDICOMConfigButton() {
        driver.elementUtils().clickOnElement(dicomConfigButtonLocator);
        return this;
    }

    @Step("Click on DICOM Destinations button")
    public P08_DICOMDestinationsAdminPage clickOnDICOMDestinationsButton() {
        driver.elementUtils().clickOnElement(dicomDestinationsButtonLocator);
        return new P08_DICOMDestinationsAdminPage(driver);
    }

    @Step("Click on Web Conferencing Tools button")
    public P09_WebConferencingToolsAdminPage clickOnWebConferencingToolsButton() {
        driver.elementUtils().clickOnElement(webConferencingToolsButtonLocator);
        return new P09_WebConferencingToolsAdminPage(driver);
    }

    @Step("Click on HL7 Configuration button")
    public P02_LibraryPage clickOnHL7ConfigButton() {
        driver.elementUtils().clickOnElement(hl7ConfigButtonLocator);
        return this;
    }

    @Step("Click on HL7 Nodes button")
    public P10_HL7NodesAdminPage clickOnHL7NodesButton() {
        driver.elementUtils().clickOnElement(hl7NodesButtonLocator);
        return new P10_HL7NodesAdminPage(driver);
    }

    @Step("Click on PACS Servers button")
    public P11_PACSServersAdminPage clickOnPACSServersButton() {
        driver.elementUtils().clickOnElement(pacsServersButtonLocator);
        return new P11_PACSServersAdminPage(driver);
    }
}
