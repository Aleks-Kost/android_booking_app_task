package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/searchbox_destination")
    private RemoteWebElement selectedDestination;
    @AndroidFindBy(id = "com.booking:id/searchbox_dates")
    private RemoteWebElement selectedDates;
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc='Save property to list'])[2]")
    private RemoteWebElement saveProperty;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Saved to My next trip']")
    private RemoteWebElement confirmSave;
    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement backToSearch;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Accommodation search box']")
    private RemoteWebElement searchBox;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Saved']")
    private RemoteWebElement savedTab;
    @AndroidFindBy(xpath = "//android.view.View/android.widget.TextView[@text='Filter']")
    private RemoteWebElement filterOptions;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Automatic']")
    private RemoteWebElement filterAutomatic;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Show results']")
    private RemoteWebElement showResultsButton;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='[icon]Automatic'])[1]")
    private RemoteWebElement confirmAutomatic;

    public ResultsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Step("Destination is Skopje")
    public String getDestinationResult() {
        return selectedDestination.getText();
    }
    @Step("Date is: Apr 24 - Apr 28")
    public String getDatesResult() {
        return selectedDates.getText();
    }
    @Step("Save/heart button is clicked")
    public void clickSaveProperty() {
        saveProperty.click();
    }
    public boolean confirmSavedProperty() {
        return confirmSave.isDisplayed();
    }
    @Step("User is taken back to the search page")
    public void clickBack() {
        backToSearch.click();
    }
    public boolean searchPageDisplayed() {
        return searchBox.isDisplayed();
    }
    @Step("Saved tab button is clicked")
    public void clickSavedTab() {
        savedTab.click();
    }
    public void clickFilterOptions() {
        filterOptions.click();
    }
    @Step("Click to filter cars by: Automatic")
    public void clickAutomatic() {
        filterAutomatic.click();
    }
    public void clickShowResults() {
        showResultsButton.click();
    }
    @Step("Car is filtered by: Automatic")
    public boolean automaticCar() {
        return confirmAutomatic.isDisplayed();
    }

}
