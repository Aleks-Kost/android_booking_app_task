package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Helpers;

public class GeniusLoyaltyPage extends Helpers{

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Genius loyalty program']")
    private RemoteWebElement confirmGeniusLoyaltyPage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='About Genius Levels']")
    private RemoteWebElement aboutField;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Genius Level 3']")
    private RemoteWebElement geniusLevel3;
    @AndroidFindBy(id = "com.booking:id/action_button")
    private RemoteWebElement gotItButton;
    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement backButton;

    public GeniusLoyaltyPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean geniusLoyaltyPageDisplayed() {

        return confirmGeniusLoyaltyPage.isDisplayed();
    }
    @Step("Page is scroll down to About Genius Levels and tab is clicked")
    public void clickAboutField() {
        aboutField.click();
    }
    @Step("Page is swiped right to Genius Levels 3")
    public void swipeToGeniusLevel3() {
        swipeToElementHorizontally(driver, "Genius Level 3");
    }
    @Step("Genius Level 3 field is displayed")
    public boolean geniusLevel3Displayed() {
        return geniusLevel3.isDisplayed();
    }
    @Step("Got it button is clicked")
    public void clickGotItButton() {
        gotItButton.click();
    }
    @Step("Go back button is clicked")
    public void clickBackButton() {
        backButton.click();
    }

}
