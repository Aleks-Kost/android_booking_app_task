package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Search'])[1]")
    private RemoteWebElement searchButton;
    @AndroidFindBy(accessibility = "Enter your destination")
    private RemoteWebElement destinationField;
    @AndroidFindBy(xpath = "//android.widget.Button[3]")
    private RemoteWebElement roomsAndGuestsButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select rooms and guests']")
    private RemoteWebElement roomsAndGuestsPopUp;
    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc='Increase'])[1]")
    private RemoteWebElement roomsNumber;
    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc='Increase'])[2]")
    private RemoteWebElement adultsNumber;
    @AndroidFindBy(id = "com.booking:id/group_config_apply_button")
    private RemoteWebElement applyButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Car rental']")
    private RemoteWebElement carRental;

    public SearchPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Step("Search page is loaded")
    public boolean searchPageDisplayed() {
        return searchButton.isDisplayed();
    }
    public void inputDestinationField() {
        destinationField.click();
    }
    public void clickRoomsAndGuestsButton() {
        roomsAndGuestsButton.click();
    }
    public boolean roomsAndGuestsPopUpDisplayed() {
        return roomsAndGuestsPopUp.isDisplayed();
    }
    @Step("Number of rooms is: 2")
    public void clickRoomsNumber() {
        roomsNumber.click();
    }
    @Step("Number of adults is: 3")
    public void clickAdultsNumber() {
        adultsNumber.click();
    }
    public void clickApplyButton() {
        applyButton.click();
    }
    @Step("Search is performed")
    public void clickSearchButton() {
        searchButton.click();
    }
    @Step("Car Rental tab is clicked")
    public void clickCarRental() {
        carRental.click();
    }

}
