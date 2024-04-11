package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class CurrencyPage {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Currency']")
    private RemoteWebElement confirmCurrencyPage;
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private RemoteWebElement currencyInputField;
    @AndroidFindBy(xpath = "//android.view.View[2]/android.view.View/android.widget.TextView[2]")
    private RemoteWebElement confirmInput;
    @AndroidFindBy(xpath = "//android.view.View[2]/android.widget.TextView[2]")
    private RemoteWebElement confirmChangedCurrency;

    public CurrencyPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean currencyDisplayed() {

        return confirmCurrencyPage.isDisplayed();
    }
    @Step("Entered currency is: {0}")
    public void enterCurrency(String currency) {
        currencyInputField.clear();
        currencyInputField.sendKeys(currency);
    }
    public String getCurrencyInput() {
        return confirmInput.getText();
    }

    public void clickCurrencyInput() {
        confirmInput.click();
    }
    @Step("Currency is changed to: Euro ")
    public String getChangedCurrency() {
        return confirmChangedCurrency.getText();
    }

}
