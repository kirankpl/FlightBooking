import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicSelectionDemo {

    public static void main(String[] args) {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        // Use WebDriverWait with Duration
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            // Open the SpiceJet website
            driver.get("https://www.spicejet.com/");
            driver.manage().window().maximize();
            // Wait and click on the "From" link
            WebElement fromLink = wait.until(ExpectedConditions.elementToBeClickable(By.className("css-1cwyjr8")));
            fromLink.click();
            
            // Wait and click on the "BLR" link
            WebElement blrLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), 'BLR')]")));
            blrLink.click();
            
            // Wait and click on the "MAA" link
            WebElement maaLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), 'MAA')]")));
            maaLink.click();
            
            // Wait for the results to load (Adjust this based on actual page content)
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'results-container')]"))); 

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            //driver.quit();
        }
    }
}
