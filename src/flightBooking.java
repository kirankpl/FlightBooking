import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class flightBooking {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        // Set the ChromeDriver path and initialize WebDriver
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void selectOriginAndDestination() {
        // Select the origin city
        WebElement originDropdown = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
        originDropdown.click();
        WebElement blrOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@value='BLR']")));
        blrOption.click();

        // Select the destination city
        WebElement maaOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@value='MAA'])[2]")));
        maaOption.click();
    }

    @Test
    public void selectFamilyCheckbox() {
        // Select 'Friends and Family' checkbox
        WebElement familyCheckbox = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));
        familyCheckbox.click();
    }

    @Test
    public void autoSuggestCountryInput() throws InterruptedException {
        // Interact with the auto-suggest country input
        WebElement countryInput = driver.findElement(By.id("autosuggest"));
        countryInput.sendKeys("Ind");
        Thread.sleep(2000); // Waiting for the options to appear

        List<WebElement> countryOptions = driver.findElements(By.className("ui-menu-item"));
        for (WebElement option : countryOptions) {
            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }
        }
    }

    @Test
    public void selectCurrency() {
        // Select a currency from the dropdown
        WebElement currencyDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select currencySelect = new Select(currencyDropdown);
        currencySelect.selectByVisibleText("INR");
        System.out.println("Selected Currency: " + currencySelect.getFirstSelectedOption().getText());
    }

    @Test
    public void selectNumberOfAdults() throws InterruptedException {
        // Increase the number of adults to 5
        driver.findElement(By.id("divpaxinfo")).click(); // Open the passenger dropdown
        Thread.sleep(1000); // Wait for the dropdown to open

        for (int i = 1; i < 5; i++) { // Loop to increment adult count
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click(); // Close the dropdown
        System.out.println("Number of adults: " + driver.findElement(By.id("divpaxinfo")).getText());
    }

    @Test
    public void selectSeniorCitizenDiscount() {
        // Assert that the Senior Citizen Discount checkbox is not selected, then select it
        WebElement seniorCitizenCheckbox = driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount"));
        Assert.assertFalse(seniorCitizenCheckbox.isSelected()); // Assertion to check it's not selected
        seniorCitizenCheckbox.click();
        Assert.assertTrue(seniorCitizenCheckbox.isSelected()); // Assertion to check it's selected now
    }

    @Test
    public void checkDatePickerEnabled() {
        // Check if the date picker is enabled
        boolean isDatePickerEnabled = driver.findElement(By.className("ui-datepicker-trigger")).isEnabled();
        System.out.println("Date picker enabled: " + isDatePickerEnabled);
    }

    @AfterClass
    public void tearDown() {
        // Close the browser after test completion
        if (driver != null) {
            driver.quit();
        }
    }
}
