import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class Selectiondemo {
	@Test
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");

		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		String currency="INR";
		
		WebElement dropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select select=new Select(dropdown);
		select.selectByIndex(2);
		
		System.out.println(select.getFirstSelectedOption().getText());
		select.selectByVisibleText(currency);
		System.out.println(select.getFirstSelectedOption().getText());
		select.selectByValue("USD");
		System.out.println(select.getFirstSelectedOption().getText());
		
		System.out.println("--------------------------------------------------------------------");
		
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		int i=1;
		while(i<5)
		{
			
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
		Thread.sleep(1000);
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		//Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"6 Adult");
		
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		//Assert.assertFalse(true);System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		
		
		boolean isenabled=driver.findElement(By.className("ui-datepicker-trigger")).isEnabled();
		System.out.println("is enabled :" +isenabled);
		Thread.sleep(15000);
		//driver.close();
		
		
	}
	

}
