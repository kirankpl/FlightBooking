import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;



public class Assignement1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//#1 : 
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
		driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		if ((driver.findElement(By.id("checkBoxOption1")).isSelected())==true)
		{
			driver.findElement(By.id("checkBoxOption1")).click();
		}
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		
		
		
		List<WebElement> elements=driver.findElements(By.cssSelector("input[type=checkbox]"));
		//List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int checkboxes=elements.size();
		System.out.println("No of checkboxes = " + checkboxes);
		//List<WebElement> elements=driver.findElements(By.cssSelector("input[type=checkbox]"));
		for( WebElement element :  elements)
		{
			System.out.println(element);
		}
		

	}

}
