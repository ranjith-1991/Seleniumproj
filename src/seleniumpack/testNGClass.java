package seleniumpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGClass {
	
	@Test(priority=1)
	public void methodOne() {
		System.out.println("Second method");
	}
	
	@AfterTest
	public void methodTwo() {
		System.out.println("fourth method");
		
	}
	@Test(priority=2)
	public void newMethod() {
		System.out.println("Third method");
	}
	@BeforeTest
	public void newMethod1() {
		System.out.println("First method");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\citi_icg\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://uat1.citidirect.com/login/");
		driver.close();
	}
	
}
