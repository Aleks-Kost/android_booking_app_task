package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class SavedTabPage {

    protected AndroidDriver driver;

    @AndroidFindBy(accessibility = "Remove property from list")
    private RemoteWebElement savedProperty;
    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement backButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Search']")
    private RemoteWebElement searchTab;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='Sign in']")
    private RemoteWebElement signInTab;

    public SavedTabPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Property is displayed in the Saved tab")
    public boolean savedPropertyDisplayed() {

        return savedProperty.isDisplayed();
    }
    @Step("User is taken back to the Search page")
    public void clickBackButton() {
        backButton.click();
    }
    public void clickSearchTab() {
        searchTab.click();
    }
    public void clickSignInTab() {
        signInTab.click();
    }

}
