package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class NotificationPage {

    protected AndroidDriver driver;

    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement closeNotificationPage;

    public NotificationPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean notificationPageDisplayed() {

        return closeNotificationPage.isDisplayed();
    }

    public void clickCloseNotificationPage() {
        closeNotificationPage.click();
    }
}
