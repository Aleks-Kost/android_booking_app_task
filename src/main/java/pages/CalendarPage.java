package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Select dates']")
    private RemoteWebElement selectDatesButton;

    @AndroidFindBy(accessibility = "24 April 2024")
    private RemoteWebElement firstDate;
    @AndroidFindBy(accessibility = "28 April 2024")
    private RemoteWebElement secondDate;

    public CalendarPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean calendarIsDisplayed() {

        return selectDatesButton.isDisplayed();
    }
    @Step("First date is 24th April")
    public void clickFirstDate() {
        firstDate.click();
    }
    @Step("Second date is 28th April")
    public void clickSecondDate() {
        secondDate.click();
    }

    public boolean selectDatesButtonEnabled() {

        return selectDatesButton.isEnabled();
    }

    public void clickSelectDatesButton() {
        selectDatesButton.click();
    }
}
