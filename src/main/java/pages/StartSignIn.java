package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class StartSignIn {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign in for easier access to your trip details']")
    private RemoteWebElement signInText;
    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement closeSignInPage;

    public StartSignIn(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean signInPageDisplayed() {

        return signInText.isDisplayed();
    }

    public void clickCloseSignInPage() {
        closeSignInPage.click();
    }

}
