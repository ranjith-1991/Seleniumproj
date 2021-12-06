package seleniumpack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstProg {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\citi_icg\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	
		driver.navigate().refresh();
		
		WebElement cart=driver.findElement(By.id("nav-cart"));
		cart.click();
		//WebElement username=driver.findElement(By.name("userId"));
		
		//username.sendKeys("Ke3081");
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[contains(text(),'Sell products')]")).click();
		
		driver.navigate().back();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("T shirt");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//*[@data-image-index='1']")).click();
		
		int frameSize= driver.findElements(By.tagName("iframe")).size();
		
		System.out.println(frameSize);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.switchTo().frame(1);
		
		String label_drop=driver.findElement(By.id("dropdown_selected_size_name")).getText();
		System.out.println(label_drop);
		//WebElement drop= driver.findElement(By.xpath("//*[@id='native_dropdown_selected_size_name']"));
		//*[@id='variation_size_name']//child::i[@class='a-icon a-icon-dropdown']
		
		//*[@id='dropdown_selected_size_name']//child::i[@class='a-icon a-icon-dropdown']
	
		Select sel = new Select(driver.findElement(By.xpath("//*[@id='native_dropdown_selected_size_name']")));
		
		
		sel.selectByVisibleText("Large");
		sel.selectByVisibleText("Medium");
		sel.selectByVisibleText("Small");
	
		List <WebElement>totalSize= sel.getOptions();
		
		int total=totalSize.size();
		System.out.println("Total number size available === "+total);
		
		for (WebElement e:totalSize) {
			String sizeList=e.getText();
			System.out.println("Size list available "+sizeList);
		}
		
		//System.out.println(drop);
		//driver.findElement(By.xpath("//a[contains(text(),'Medium')]")).click();
		
		String title= driver.findElement(By.xpath("//*[@id='productTitle']")).getText();	
		System.out.println(title);
		driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();
		
		System.out.println("added to cart successfully");
		
		//driver.quit();
	
		
		//driver.close();
	}

}
