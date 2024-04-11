package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.Listeners;
import pages.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

@Listeners({ ITestListenerUtility.class })

public class DriverSetup extends ConfigReader{

    public static AndroidDriver driver;
    public DesiredCapabilities capabilities = new DesiredCapabilities();

    protected Helpers helpers;

    protected NotificationPage notificationPage;
    protected StartSignIn startSignIn;
    protected SearchPage searchPage;
    protected DestinationSearchPage destinationSearchPage;
    protected CalendarPage calendarPage;
    protected ResultsPage resultsPage;
    protected SavedTabPage savedTabPage;
    protected SignInPage signInPage;
    protected SettingsPage settingsPage;
    protected CurrencyPage currencyPage;
    protected GeniusLoyaltyPage geniusLoyaltyPage;
    protected CarRentalPage carRentalPage;

    @BeforeMethod
    public void setUp() {
        capabilities.setPlatform(Platform.ANDROID);
        capabilities.setCapability(UiAutomator2Options.AVD_OPTION, getProperty("device.name"));
        capabilities.setCapability(UiAutomator2Options.APP_OPTION, getProperty("path.to.app"));
        capabilities.setCapability(UiAutomator2Options.AUTOMATION_NAME_OPTION, getProperty("automation.name"));
        capabilities.setCapability(UiAutomator2Options.APP_PACKAGE_OPTION, getProperty("app.package"));
        capabilities.setCapability(UiAutomator2Options.APP_ACTIVITY_OPTION, getProperty("app.activity"));
        capabilities.setCapability(UiAutomator2Options.NO_RESET_OPTION, false);
        capabilities.setCapability(UiAutomator2Options.FULL_RESET_OPTION, true);
        capabilities.setCapability(UiAutomator2Options.SKIP_DEVICE_INITIALIZATION_OPTION, true);

        try {
            driver = new AndroidDriver(new URI(GlobalVariables.localAppiumServerUrl).toURL(), capabilities);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        helpers = new Helpers();

        notificationPage = new NotificationPage(driver);
        startSignIn = new StartSignIn(driver);
        searchPage = new SearchPage(driver);
        destinationSearchPage = new DestinationSearchPage(driver);
        calendarPage = new CalendarPage(driver);
        resultsPage = new ResultsPage(driver);
        savedTabPage = new SavedTabPage(driver);
        signInPage = new SignInPage(driver);
        settingsPage = new SettingsPage(driver);
        currencyPage = new CurrencyPage(driver);
        geniusLoyaltyPage = new GeniusLoyaltyPage(driver);
        carRentalPage = new CarRentalPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
