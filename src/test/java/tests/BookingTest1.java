package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DriverSetup;

public class BookingTest1 extends DriverSetup {

    @Test(testName = "Booking Test 1")
    public void bookingTest1() {

        Assert.assertTrue(notificationPage.notificationPageDisplayed(), "Notification page is not displayed");

        notificationPage.clickCloseNotificationPage();
        Assert.assertTrue(startSignIn.signInPageDisplayed(), "Sign In page is not displayed");

        startSignIn.clickCloseSignInPage();
        Assert.assertTrue(searchPage.searchPageDisplayed(), "Search page is not displayed");

        searchPage.inputDestinationField();
        Assert.assertTrue(destinationSearchPage.enterDestinationDisplayed(), "Input destination field is not displayed");

        destinationSearchPage.enterDestinationInput("Skopje");
        Assert.assertEquals(destinationSearchPage.getDestination(), "Skopje");

        destinationSearchPage.clickDisplayedCity();
        Assert.assertTrue(calendarPage.calendarIsDisplayed(), "Calendar is not displayed");

        calendarPage.clickFirstDate();
        Assert.assertFalse(calendarPage.selectDatesButtonEnabled(), "Calendar button is enabled");

        calendarPage.clickSecondDate();
        Assert.assertTrue(calendarPage.selectDatesButtonEnabled(), "Calendar button is not enabled");

        calendarPage.clickSelectDatesButton();

        searchPage.clickRoomsAndGuestsButton();
        Assert.assertTrue(searchPage.roomsAndGuestsPopUpDisplayed(), "Rooms and guests pop-up is not displayed");

        searchPage.clickRoomsNumber();
        searchPage.clickAdultsNumber();
        searchPage.clickApplyButton();

        searchPage.clickSearchButton();
        Assert.assertEquals(resultsPage.getDestinationResult(), "Skopje");
        Assert.assertEquals(resultsPage.getDatesResult(), "Apr 24 - Apr 28");

        resultsPage.clickSaveProperty();
        Assert.assertTrue(resultsPage.confirmSavedProperty(), "Property is not saved");

        resultsPage.clickBack();
        Assert.assertTrue(resultsPage.searchPageDisplayed(), "User is back to search page");

        resultsPage.clickSavedTab();
        Assert.assertTrue(savedTabPage.savedPropertyDisplayed(), "Saved property is not displayed");

        savedTabPage.clickBackButton();
        savedTabPage.clickSearchTab();

        savedTabPage.clickSignInTab();
        Assert.assertTrue(signInPage.signInPageDisplayed(), "Sign In page is not displayed");

        Assert.assertEquals(signInPage.userIsNotSignedIn(), "Sign in or create account");

        signInPage.clickSettingsField();
        Assert.assertTrue(settingsPage.settingsDisplayed(), "Settings page is not displayed");

        settingsPage.clickCurrencyOption();
        Assert.assertTrue(currencyPage.currencyDisplayed(), "Currency page is not displayed");

        currencyPage.enterCurrency("Euro");
        Assert.assertEquals(currencyPage.getCurrencyInput(), "Euro");

        currencyPage.clickCurrencyInput();
        Assert.assertEquals(currencyPage.getChangedCurrency(), "Euro (€)");

        settingsPage.clickPrivacyPolicy();
        Assert.assertTrue(settingsPage.privacyPolicyDisplayed(), "Privacy and Cookies policy page is not displayed");

    }
}
