package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightBookingPage {
    WebDriver driver;
    WebDriverWait wait;

    public FlightBookingPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void selectOrigin(String originCode) {
        WebElement originDropdown = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
        originDropdown.click();
        WebElement originOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@value='" + originCode + "']")));
        originOption.click();
    }

    public void selectDestination(String destinationCode) {
        WebElement destinationOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@value='" + destinationCode + "'])[2]")));
        destinationOption.click();
    }

    public void selectFamilyCheckbox() {
        WebElement familyCheckbox = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));
        familyCheckbox.click();
    }

    public void autoSuggestCountry(String country) throws InterruptedException {
        WebElement countryInput = driver.findElement(By.id("autosuggest"));
        countryInput.sendKeys(country);
        Thread.sleep(2000); // Waiting for options to appear

        for (WebElement option : driver.findElements(By.className("ui-menu-item"))) {
            if (option.getText().equalsIgnoreCase(country)) {
                option.click();
                break;
            }
        }
    }

    public void selectCurrency(String currency) {
        WebElement currencyDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select currencySelect = new Select(currencyDropdown);
        currencySelect.selectByVisibleText(currency);
    }

    public void selectNumberOfAdults(int numAdults) throws InterruptedException {
        driver.findElement(By.id("divpaxinfo")).click(); // Open passenger dropdown
        Thread.sleep(1000);

        for (int i = 1; i < numAdults; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
    }

    public void selectSeniorCitizenDiscount() {
        WebElement seniorCitizenCheckbox = driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount"));
        if (!seniorCitizenCheckbox.isSelected()) {
            seniorCitizenCheckbox.click();
        }
    }

    public boolean isDatePickerEnabled() {
        return driver.findElement(By.className("ui-datepicker-trigger")).isEnabled();
    }
}
