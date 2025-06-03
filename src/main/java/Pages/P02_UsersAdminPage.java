package Pages;

import Factories.DriverFactory;
import Utilities.LogsUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P02_UsersAdminPage {
    private final By generalConfigButtonLocator = By.xpath("//span[text()=\"General Configuration\"] /..");
    private final By worklistMappingButtonLocator = By.xpath("//span[text()=\"Worklist Mapping\"] /..");
    private final By patientTypeAdminButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/patienttype\"]");
    private final By studyPriorityAdminButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/studypriority\"]");
    private final By orderingLocationsAdminButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/orderinglocations\"]");
    private final By patientEligibilityAdminButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/patienteligibility\"]");
    private final By hl7ConfigurationButtonLocator = By.xpath("//span[text()=\" HL7 Configuration\"] /..");
    private final By systemSettingsButtonLocator = By.xpath("//span[text()=\"System Settings\"] /..");
    private final By hl7TriggersButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/hl7/triggers\"]");
    private final By systemTriggersButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/systemtriggers\"]");
    private final By modalityMappingButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/modalitymapping\"]");
    private final By cancellationReasonsButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/cancellationreasons\"]");
    private final By schedulingSuggestionsButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/schedulingsuggestions\"]");
    private final By sitesAdminButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/sites\"]");
    private final By protocolsButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/protocols\"]");
    private final By protocolGroupsButtonLocator = By.cssSelector("[href=\"/iCodeVettPro/admin/protocolgroups\"]");

    private final DriverFactory driver;

    public P02_UsersAdminPage(DriverFactory driver){
        this.driver = driver;
    }

    @Step("Click on General Configuration button")
    public P02_UsersAdminPage clickOnGeneralConfigButton() {
        LogsUtils.info("Clicking on General Configuration button");
        driver.elementUtils().clickOnElement(generalConfigButtonLocator);
        return new P02_UsersAdminPage(driver);
    }

    @Step("Click on Worklist Mapping button")
    public P02_UsersAdminPage clickOnWorklistMappingButton() {
        LogsUtils.info("Clicking on Worklist Mapping button");
        driver.elementUtils().clickOnElement(worklistMappingButtonLocator);
        return new P02_UsersAdminPage(driver);
    }

    @Step("Click on Patient Type Admin button")
    public P03_PatientTypeAdminPage clickOnPatientTypeAdminButton() {
        LogsUtils.info("Clicking on Patient Type Admin button");
        driver.elementUtils().clickOnElement(patientTypeAdminButtonLocator);
        return new P03_PatientTypeAdminPage(driver);
    }

    @Step("Click on Study Priority Admin button")
    public P04_StudyPriorityAdminPage clickOnStudyPriorityAdminButton() {
        LogsUtils.info("Clicking on Study Priority Admin button");
        driver.elementUtils().clickOnElement(studyPriorityAdminButtonLocator);
        return new P04_StudyPriorityAdminPage(driver);
    }


    @Step("Click on Ordering Locations Admin button")
    public P05_OrderingLocationsAdminPage clickOnOrderingLocationsAdminButton() {
        LogsUtils.info("Clicking on Ordering Locations Admin button");
        driver.elementUtils().clickOnElement(orderingLocationsAdminButtonLocator);
        return new P05_OrderingLocationsAdminPage(driver);
    }

    @Step("Click on Patient Eligibility Admin button")
    public P06_PatientEligibilityAdminPage clickOnPatientEligibilityAdminButton() {
        LogsUtils.info("Clicking on Patient Eligibility Admin button");
        driver.elementUtils().clickOnElement(patientEligibilityAdminButtonLocator);
        return new P06_PatientEligibilityAdminPage(driver);
    }


    @Step("Click on HL7 Configuration button")
    public P02_UsersAdminPage clickOnHL7ConfigurationButton() {
        LogsUtils.info("Clicking on HL7 Configuration button");
        driver.elementUtils().clickOnElement(hl7ConfigurationButtonLocator);
        return new P02_UsersAdminPage(driver);
    }

    @Step("Click on System Settings button")
    public P02_UsersAdminPage clickOnSystemSettingsButton() {
        LogsUtils.info("Clicking on System Settings button");
        driver.elementUtils().clickOnElement(systemSettingsButtonLocator);
        return new P02_UsersAdminPage(driver);
    }

    @Step("Click on HL7 Triggers button")
    public P07_HL7TriggersAdminPage clickOnHL7TriggersButton() {
        LogsUtils.info("Clicking on HL7 Triggers button");
        driver.elementUtils().clickOnElement(hl7TriggersButtonLocator);
        return new P07_HL7TriggersAdminPage(driver);
    }

    @Step("Click on System Triggers button")
    public P08_SystemTriggersAdminPage clickOnSystemTriggersButton() {
        LogsUtils.info("Clicking on System Triggers button");
        driver.elementUtils().clickOnElement(systemTriggersButtonLocator);
        return new P08_SystemTriggersAdminPage(driver);
    }

    @Step("Click on Modality Mapping button")
    public P09_ModalityMappingAdminPage clickOnModalityMappingButton() {
        LogsUtils.info("Clicking on Modality Mapping button");
        driver.elementUtils().clickOnElement(modalityMappingButtonLocator);
        return new P09_ModalityMappingAdminPage(driver);
    }

    @Step("Click on Cancellation Reasons button")
    public P10_CancellationReasonsAdminPage clickOnCancellationReasonsButton() {
        LogsUtils.info("Clicking on Cancellation Reasons button");
        driver.elementUtils().clickOnElement(cancellationReasonsButtonLocator);
        return new P10_CancellationReasonsAdminPage(driver);
    }

    @Step("Click on Scheduling Suggestions button")
    public P11_SchedulingSuggestionsAdminPage clickOnSchedulingSuggestionsButton() {
        LogsUtils.info("Clicking on Scheduling Suggestions button");
        driver.elementUtils().clickOnElement(schedulingSuggestionsButtonLocator);
        return new P11_SchedulingSuggestionsAdminPage(driver);
    }

    @Step("Click on Sites")
    public P02_SitesPage clickOnSitesButton() {
        LogsUtils.info("Clicking on General Configuration button");
        driver.elementUtils().clickOnElement(sitesAdminButtonLocator);
        return new P02_SitesPage(driver);
    }

    @Step("Click on Protocols button")
    public P12_ProtocolsAdminPage clickOnProtocolsButton() {
        LogsUtils.info("Clicking on Protocols button");
        driver.elementUtils().clickOnElement(protocolsButtonLocator);
        return new P12_ProtocolsAdminPage(driver);
    }

    @Step("Click on Protocol Groups button")
    public P13_ProtocolGroupsAdminPage clickOnProtocolGroupsButton() {
        LogsUtils.info("Clicking on Protocol Groups button");
        driver.elementUtils().clickOnElement(protocolGroupsButtonLocator);
        return new P13_ProtocolGroupsAdminPage(driver);
    }
}
