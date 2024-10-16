import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TableNavigationExample {

    public static void main(String[] args) {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            // Open the website
            driver.get("https://en.wikipedia.org/wiki/List_of_national_capitals");

            // Wait for the table to be loaded
            WebElement table = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@class, 'wikitable')]")));

            // Wait for the specific element for Haiti to be present
         // Locate the cell containing "Asia" and then find it within three columns in front
            WebElement spainElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[contains(@class, 'wikitable')]//td[contains(text(), 'Spain')]/preceding-sibling::td[2]")));
            Thread.sleep(2000);

            // Scroll the element into view
            js.executeScript("arguments[0].scrollIntoView(true);", spainElement);

            // Get the text of the Haiti element
            String spainText = spainElement.getText();

            // Print the Haiti text
            System.out.println("This is the data provided Country: " + spainText);

            // Optionally, get the row to extract additional information
            WebElement row = spainElement.findElement(By.xpath("./ancestor::tr"));
            String capital = row.findElement(By.xpath("td[1]")).getText(); // Adjust based on the actual column in the table
            String continent = row.findElement(By.xpath("td[3]")).getText(); // Adjust based on the actual column in the table

            // Display additional information if needed
            System.out.println("Capital: " + capital);
            System.out.println("Continent: " + continent);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
