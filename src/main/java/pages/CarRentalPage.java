package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Helpers;

public class CarRentalPage extends Helpers {

    protected AndroidDriver driver;

    @AndroidFindBy(accessibility = "Enter a pick-up location")
    private RemoteWebElement confirmCarRentalPage;
    @AndroidFindBy(accessibility = "Selected, you will return the car to the same location")
    private RemoteWebElement selectReturn;
    @AndroidFindBy(accessibility = "Enter a pick-up location")
    private RemoteWebElement pickUpLocation;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Pickup location']")
    private RemoteWebElement enterPickUpLocation;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Drop-off location']")
    private RemoteWebElement enterDropOffLocation;
    @AndroidFindBy(accessibility = "Enter a drop-off location")
    private RemoteWebElement dropOffLocation;
    @AndroidFindBy(id = "com.booking:id/calendar_confirm")
    private RemoteWebElement selectDatesButton;
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[1]")
    private RemoteWebElement selectResult;
    @AndroidFindBy(xpath = "//android.widget.Button[3]")
    private RemoteWebElement selectDate;
    @AndroidFindBy(accessibility = "24 April 2024")
    private RemoteWebElement firstDate;
    @AndroidFindBy(accessibility = "27 April 2024")
    private RemoteWebElement secondDate;
    @AndroidFindBy(accessibility = "Pick-up time: 10:00:00.000")
    private RemoteWebElement timeOne;
    @AndroidFindBy(accessibility = "Drop-off time: 10:00:00.000")
    private RemoteWebElement timeTwo;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='8:15 AM']")
    private RemoteWebElement chooseTimeOne;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='11:00 AM']")
    private RemoteWebElement chooseTimeTwo;
    @AndroidFindBy(accessibility = "Enter the driver's age")
    private RemoteWebElement driverAge;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Search']")
    private RemoteWebElement searchButton;

    public CarRentalPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean carRentalPageDisplayed() {

        return confirmCarRentalPage.isDisplayed();
    }
    @Step("Return to same location button is clicked")
    public void clickReturn() {
        selectReturn.click();
    }
    @Step("Pickup location input field is displayed")
    public boolean pickUpDisplayed() {
        return pickUpLocation.isDisplayed();
    }
    @Step("Drop-off location input field is displayed")
    public boolean dropOffDisplayed() {
        return dropOffLocation.isDisplayed();
    }
    public void clickPickUpLocation (){
        pickUpLocation.click();
    }
    public void clickDropOffLocation () {
        dropOffLocation.click();
    }
    @Step("Location for pickup is: {0}")
    public void inputPickUpLocation(String pickup) {
        enterPickUpLocation.sendKeys(pickup);
    }
    @Step("Location for drop-off is: {0}")
    public void inputDropOffLocation(String dropoff) {
        enterDropOffLocation.sendKeys(dropoff);
    }
    public String getResult() {
        return selectResult.getText();
    }
    public void clickResult() {
        selectResult.click();
    }
    public void clickSelectDate() {
        selectDate.click();
    }
    @Step("Selected date is: 24 April")
    public void enterFirstDate() {
        firstDate.click();
    }
    @Step("Selected date is: 27 April")
    public void enterSecondDate() {
        secondDate.click();
    }
    public void clickSelectDatesButton() {
        selectDatesButton.click();
    }
    public void clickTimeOne() {
        timeOne.click();
    }
    @Step("Selected time is: 08:15 AM")
    public void selectTimeOne() {
        chooseTimeOne.click();
    }
    public void clickTimeTwo() {
        timeTwo.click();
    }
    @Step("Selected time is: 11:00 AM")
    public void selectTimeTwo() {
        chooseTimeTwo.click();
    }
    @Step("Driver age is: {0}")
    public void clickDriverAge(String age) {
        driverAge.click();
        Actions enterAge = new Actions(driver);
        enterAge.sendKeys(age).perform();
    }
    @Step("Search button is clicked")
    public void clickSearch() {
        searchButton.click();
    }

}
