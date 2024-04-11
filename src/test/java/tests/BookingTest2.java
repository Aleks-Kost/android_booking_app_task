package tests;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DriverSetup;
import utilities.Helpers;

public class BookingTest2 extends DriverSetup {

    @Test(testName = "Booking Test 2")
    public void bookingTest2() {

        Assert.assertTrue(notificationPage.notificationPageDisplayed(), "Notification start page is not displayed");

        notificationPage.clickCloseNotificationPage();
        Assert.assertTrue(startSignIn.signInPageDisplayed(), "Sign In start page is not displayed");

        startSignIn.clickCloseSignInPage();
        Assert.assertTrue(searchPage.searchPageDisplayed(), "Main Search page is not displayed");

        savedTabPage.clickSignInTab();
        Assert.assertTrue(signInPage.signInPageDisplayed(), "Sign In page is not displayed");

        signInPage.clickGeniusLoyaltyField();
        Assert.assertTrue(geniusLoyaltyPage.geniusLoyaltyPageDisplayed(), "Genius loyalty page is not displayed");

        helpers.swipeVertically(driver, Helpers.Directions.UP);
        helpers.swipeVertically(driver, Helpers.Directions.UP);
        helpers.swipeVertically(driver, Helpers.Directions.UP);
        helpers.swipeVertically(driver, Helpers.Directions.UP);

        geniusLoyaltyPage.clickAboutField();

        geniusLoyaltyPage.swipeToGeniusLevel3();
        Assert.assertTrue(geniusLoyaltyPage.geniusLevel3Displayed(), "Genius Level 3 is not displayed");

        geniusLoyaltyPage.clickGotItButton();
        Assert.assertTrue(geniusLoyaltyPage.geniusLoyaltyPageDisplayed(), "Genius loyalty page is not displayed");

        geniusLoyaltyPage.clickBackButton();

        signInPage.clickSearchButton();
        Assert.assertTrue(searchPage.searchPageDisplayed(), "Search page is not displayed");

        searchPage.clickCarRental();
        Assert.assertTrue(carRentalPage.carRentalPageDisplayed(), "Car rental page is not displayed");

        carRentalPage.clickReturn();
        Assert.assertTrue(carRentalPage.pickUpDisplayed(), "Pickup input field is displayed");
        Assert.assertTrue(carRentalPage.dropOffDisplayed(), "Drop-off field is displayed");

        carRentalPage.clickPickUpLocation();
        carRentalPage.inputPickUpLocation("Skopje");
        Assert.assertEquals(carRentalPage.getResult(), "Skopje");
        carRentalPage.clickResult();

        carRentalPage.clickDropOffLocation();
        carRentalPage.inputDropOffLocation("Ohrid");
        Assert.assertEquals(carRentalPage.getResult(), "Ohrid");
        carRentalPage.clickResult();

        carRentalPage.clickSelectDate();

        carRentalPage.enterFirstDate();
        carRentalPage.enterSecondDate();
        carRentalPage.clickSelectDatesButton();

        carRentalPage.clickTimeOne();
        helpers.swipeVertically(driver, Helpers.Directions.DOWN);
        helpers.swipeVertically(driver, Helpers.Directions.DOWN);
        helpers.swipeVertically(driver, Helpers.Directions.DOWN);
        carRentalPage.selectTimeOne();
        carRentalPage.clickTimeTwo();
        carRentalPage.selectTimeTwo();

        carRentalPage.clickDriverAge("37");

        carRentalPage.clickSearch();

        resultsPage.clickFilterOptions();
        resultsPage.clickAutomatic();
        resultsPage.clickShowResults();
        Assert.assertTrue(resultsPage.automaticCar(), "Car is not automatic");
    }
}
