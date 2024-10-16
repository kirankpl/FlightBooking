import java.time.Duration;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;



public class seleniumLocators {
	@Test
	
	public static void main(String[] args) throws InterruptedException {
		
		connection();
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://rahulshettyacademy.com/locatorspractice");
		
		
		String name1="Kiran Karippal";
		
		//driver.findElement(By.id("inputUsername")).sendKeys("kirankarippal");
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("kirankarippal");
		driver.findElement(By.name("inputPassword")).sendKeys("test123");
		
		//Thread.sleep(5000);
		
		//driver.findElement(By.className("signInBtn")).click();
		driver.findElement(By.cssSelector("button.signInBtn")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String name = driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/form/p")).getText();
		System.out.println(name);
		
		driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/form/div[2]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/input[1]")).sendKeys("Kiran");
		driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/input[2]")).sendKeys("kiran@google.com");
		driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/input[3]")).sendKeys("9876543210");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/div/button[2]")).click();
		Thread.sleep(1000);
		String password=driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/p")).getText();
		
		driver.findElement(By.className("go-to-login-btn")).click();
		
		System.out.println(password);
		
		
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys(name1);
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		
		List<WebElement> chkboxes=driver.findElements(By.cssSelector("input[type='checkbox']"));

		int size=chkboxes.size();

		for (int i=0; i<size; i++) {

		chkboxes.get(i).click();

		}
		
		//driver.findElement(By.name("chkboxOne")).click();
		//driver.findElement(By.name("chkboxOne")).click();
		driver.findElement(By.className("submit")).click();
		
		
		//Thread.sleep(5000);
		
		//driver.close();
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(),"Hello "+ name1+",");
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		
		//Thread.sleep(10000);
		
		driver.close();
		
	}
	@Test
	public static void connection()
	{
		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://rahulshettyacademy.com/locatorspractice");
	}

}
