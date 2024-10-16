import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;





public class SeleIntroduction {



public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");

WebDriver driver =new ChromeDriver();

driver.get("http://rahulshettyacademy.com/dropdownsPractise/"); //URL in the browser
















//  //a[@value='MAA']  - Xpath for chennai

//  //a[@value='BLR']
/*
driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

driver.findElement(By.xpath("//a[@value='BLR']")).click();

Thread.sleep(2000);

//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

driver.findElement(By.id("ui-datepicker-trigger\r\n")).sendKeys("18/08/2023");


WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

Select dropdown = new Select(staticDropdown);
dropdown.selectByIndex(3);
System.out.println(dropdown.getFirstSelectedOption().getText());
*/
//WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

Thread.sleep(2000);
System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
driver.findElement(By.id("divpaxinfo")).click();
Thread.sleep(1000);
for (int i=1;i<=5;i++) {
	driver.findElement(By.id("hrefIncAdt")).click();
}

System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

}




}

