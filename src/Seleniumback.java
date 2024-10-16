import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Seleniumback {
	public static void main(String[] args) throws InterruptedException {

		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");

		WebDriver driver =new ChromeDriver();

		driver.get("http://rahulshettyacademy.com"); //URL in the browser
		
		
		
		driver.close();
	}
	
}
