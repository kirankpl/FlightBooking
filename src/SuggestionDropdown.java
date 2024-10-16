import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SuggestionDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).click();
		
		driver.findElement(By.cssSelector("input[id='cctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
		
		
		
		driver.findElement(By.id("autosuggest")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		Thread.sleep(2000);
		List<WebElement> options=driver.findElements(By.className("ui-menu-item"));
		
		for(WebElement option : options)
		{
			System.out.println(option.getText());
			if(option.getText().equalsIgnoreCase("India"))
			{
				Thread.sleep(2000);
				option.click();
				continue;
			}
			else
			{
				//System.out.println(option.getText() + "  is not required");
			}
		}
		
		

	}

}
