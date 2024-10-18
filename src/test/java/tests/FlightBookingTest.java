package test.java.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import main.java.pages.FlightBookingPage;
import main.java.utilities.CustomWebDriverManager;


public class FlightBookingTest {

    WebDriver driver;
    WebDriverWait wait;
    FlightBookingPage flightBookingPage;

    @BeforeClass
    public void setup() {
        driver = CustomWebDriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        flightBookingPage = new FlightBookingPage(driver, wait);

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    @Test
    public void testSelectOriginAndDestination() {
        flightBookingPage.selectOrigin("BLR");
        flightBookingPage.selectDestination("MAA");
    }

   @Test
    public void testFamilyCheckbox() {
        flightBookingPage.selectFamilyCheckbox();
    }

   @Test
    public void testAutoSuggestCountryInput() throws InterruptedException {
        flightBookingPage.autoSuggestCountry("India");
    }

   @Test
    public void testSelectCurrency() {
        flightBookingPage.selectCurrency("INR");
    }

   @Test
    public void testSelectNumberOfAdults() throws InterruptedException {
        flightBookingPage.selectNumberOfAdults(5);
    }

   @Test
    public void testSeniorCitizenDiscount() {
        flightBookingPage.selectSeniorCitizenDiscount();
    }

   @Test
    public void testDatePickerEnabled() {
        assert flightBookingPage.isDatePickerEnabled();
    }

   @AfterClass
    public void tearDown() {
	   CustomWebDriverManager.quitDriver();
    }
}
