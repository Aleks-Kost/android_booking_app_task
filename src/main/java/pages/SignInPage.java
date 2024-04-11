package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Helpers;

public class SignInPage extends Helpers {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign in or create account']")
    private RemoteWebElement confirmSignInPage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
    private RemoteWebElement settingsField;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Genius loyalty program']")
    private RemoteWebElement geniusLoyaltyField;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Search'])[1]")
    private RemoteWebElement searchButton;

    public SignInPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean signInPageDisplayed() {
        return confirmSignInPage.isDisplayed();
    }
    @Step("User is not signed in")
    public String userIsNotSignedIn() {
        return confirmSignInPage.getText();
    }
    @Step("Page is scroll down and Settings field is clicked")
    public void clickSettingsField() {
        swipeToElementVertically(driver, "Settings");
        settingsField.click();
    }
    @Step("Genius Loyalty field is clicked")
    public void clickGeniusLoyaltyField() {
        geniusLoyaltyField.click();
    }
    @Step("User navigates to Search page")
    public void clickSearchButton() {
        searchButton.click();
    }

}
