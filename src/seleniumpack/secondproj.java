package seleniumpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class secondproj {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\citi_icg\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://uat1.citidirect.com/login/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	
		driver.navigate().refresh();
		int frameSize= driver.findElements(By.tagName("iframe")).size();
		
		System.out.println(frameSize);
		
		
		
		//System.out.println(header)
		
		//driver.findElement(By.name("userid")).sendKeys("smsv2702");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		String header =driver.findElement(By.xpath("//span[text()='Welcome to CitiDirect']")).getText();
		System.out.println(header);
		driver.findElement(By.xpath("//input[@name='userid']")).sendKeys("smsv2702");
		
		driver.findElement(By.id("btnSignin")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//label[text()='Challenge Response ']")).click();
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@aria-label='linkToken']")).click();
		 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='displayPassword']")).sendKeys("citi1234");
		
		driver.findElement(By.xpath("//span[@class='togglePwdDisplay hideSecPwdEye']")).click();
		
		driver.findElement(By.xpath("//button[@type='submitType']")).click();
		
		driver.findElement(By.xpath("//*[@id='btnSMSLink']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("33333333");
		
		driver.findElement(By.xpath("//button[@type='submitType']")).click();
		
		//driver.quit();
	
		
		driver.close();
	}

}
