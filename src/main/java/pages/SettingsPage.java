package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
    private RemoteWebElement confirmSettings;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Currency']")
    private RemoteWebElement currencyOption;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']")
    private RemoteWebElement privacyPolicy;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy and Cookies policy']")
    private RemoteWebElement confirmPrivacyPolicy;

    public SettingsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean settingsDisplayed() {

        return confirmSettings.isDisplayed();
    }
    @Step("Currency tab is clicked")
    public void clickCurrencyOption() {

        currencyOption.click();
    }
    @Step("Privacy Policy tab is clicked")
    public void clickPrivacyPolicy() {

        privacyPolicy.click();
    }
    @Step("Privacy Policy page is displayed")
    public boolean privacyPolicyDisplayed() {

        return confirmPrivacyPolicy.isDisplayed();
    }

}
