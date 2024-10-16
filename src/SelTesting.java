
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class SelTesting {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");

		WebDriver driver =new ChromeDriver();
		/*
		driver.get("https://formy-project.herokuapp.com/scroll");
		WebElement name=driver.findElement(By.id("name"));
		name.sendKeys("kiran");
		WebElement date=driver.findElement(By.id("date"));
		date.sendKeys("22/01/2024");
		*/
		/*
		driver.get("https://formy-project.herokuapp.com/switch-window");
		WebElement newtab=driver.findElement(By.id("new-tab-button"));
		newtab.click();
		String handle=driver.getWindowHandle();
		
		for(String handle1: driver.getWindowHandles())
		{
			driver.switchTo().window(handle1);
		}
		
		Thread.sleep(1000);
		driver.switchTo().window(handle);
		
		*/
		driver.get("https://formy-project.herokuapp.com/modal");
		WebElement open=driver.findElement(By.id("modal-button"));
		open.click();
		Thread.sleep(1000);
		WebElement close=driver.findElement(By.id("close-button"));
		close.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String s;
		js.executeScript("arguments[0].click();",close);
		
		
	}
}
