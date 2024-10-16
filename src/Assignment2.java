import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		System.out.println("PART 1");
		System.out.println("------------------------------------------------");
		driver.findElement(By.name("name")).sendKeys("Kiran");
		System.out.println("Name: "+driver.findElement(By.name("name")).getText());
		driver.findElement(By.name("email")).sendKeys("Kirankarippal@gmail.com");
		System.out.println("Email: "+driver.findElement(By.name("name")).getText());
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("12345678");
		driver.findElement(By.cssSelector("input[type=checkbox]")).click();
		System.out.println(" Is checkbox selected :"+driver.findElement(By.cssSelector("input[type=checkbox]")).isSelected());
		
		  Select dropdown = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
	      dropdown.selectByVisibleText("Male");
	        System.out.println("Gender Selected: " + dropdown.getFirstSelectedOption().getText());
	        
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("14-07-1995");
		driver.findElement(By.cssSelector("input[type=submit]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Set a maximum timeout of 10 seconds
		WebElement element = wait.pollingEvery(Duration.ofMillis(500))           // Poll every 500 milliseconds
		                         .until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));
		
		System.out.println(element.getText());

		
	}

}
