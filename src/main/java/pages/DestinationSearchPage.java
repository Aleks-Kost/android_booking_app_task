package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class DestinationSearchPage {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter destination']")
    private RemoteWebElement enterDestination;
    @AndroidFindBy(xpath = "//android.view.View[1]/android.widget.TextView[1]")
    private RemoteWebElement displayCity;

    public DestinationSearchPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean enterDestinationDisplayed() {

        return enterDestination.isDisplayed();
    }
    @Step("Entered destination is: {0}")
    public void enterDestinationInput(String destination){
        enterDestination.clear();
        enterDestination.sendKeys(destination);
    }

    public String getDestination() {
        return displayCity.getText();
    }
    public void clickDisplayedCity(){
        displayCity.click();
    }

}
