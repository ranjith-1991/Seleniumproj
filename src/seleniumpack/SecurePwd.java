package seleniumpack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SecurePwd {

	@Test
	public void citiDirect() throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\citi_icg\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://uat1.citidirect.com/login/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='userid']")).sendKeys("raus7396");
		
		driver.findElement(By.id("btnSignin")).click();
		
		driver.findElement(By.xpath("//input[@name='displayPassword']")).sendKeys("citi1234");
		
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//*[@class='togglePwdDisplay hideSecPwdEye']")).click();
		
		driver.findElement(By.xpath("//button[@type='submitType']")).click();
		
		//to accept alert during login multiple session
		
		Thread.sleep(5000);
		
		try {
			String alert_text=driver.switchTo().alert().getText();
			System.out.println("Alert messsage is "+alert_text);
			Alert alt = driver.switchTo().alert();
			alt.accept();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
				
		driver.findElement(By.xpath("//*[@id='AvatarContainer']")).click();
		
		String username=driver.findElement(By.xpath("//*[@id='Avatar']//li[@class='item header']")).getText();

		System.out.println(username);
		
		int frameSize= driver.findElements(By.tagName("iframe")).size();
		
		System.out.println(frameSize);
		
		driver.findElement(By.id("uifw-megamenu-103")).click();
		
		driver.findElement(By.id("sitemap-103-5101-5105")).click();
		
		WebElement popup_disclaimer= driver.findElement(By.xpath("//iframe[@src='/portal/disclaimer/show']"));
		
		driver.switchTo().frame(popup_disclaimer);
		
		driver.findElement(By.id("popup-disclaimer-accept")).click();
		
		driver.switchTo().parentFrame();
		
	//	WebElement payment_template= driver.findElement(By.xpath("//iframe[@id='idashboard']"));
		
		driver.switchTo().frame("idashboard");
		
		driver.findElement(By.xpath("//div[@class='c-button-set']//input[@type='button' and @value='Select Template']")).click();
		
		WebElement Template_lookup= driver.findElement(By.xpath("//iframe[@src='/CDCBEAPP2/CDCBEPMT/Static/HtmlSnippets/Lookup/LookupStartPage.html?redirect=%2FCDCBEAPP2%2FCDCBEPMT%2FLookups%2FPaymentSelectTemplateLibrary&lookupElementId=Header_SelectTemplates&getDataMethod=Cmb.UI.Core.Lookups.defaultPostDataGetter']"));
		
		driver.switchTo().frame(Template_lookup);
		
		//driver.switchTo().frame("SelectTemplatesBtnId_iframe");
		
		driver.findElement(By.xpath("//input[@value='Start New Search']")).click();		
		
		driver.findElement(By.xpath("//div[@id=\"OuterPanel_buttons_panel\"]//input[@type='button' and @value='Clear All']")).click();
		
		driver.findElement(By.xpath("//div[@id='OuterPanel_buttons_panel']//input[@type='button' and @value='Search']")).click();
		
		driver.findElement(By.xpath("//td[text()='930 PRE BEN']/preceding-sibling::td[2]")).click();
	
	/*
	 * driver.switchTo().frame(Template_lookup);
	 * 
	 * List<WebElement> checkbox=
	 * driver.findElements(By.xpath("//input[@type='checkbox']"));
	 * 
	 * System.out.println("Total number of checkboxes= "+checkbox.size()); for(int
	 * i=0;i<checkbox.size();i++) { WebElement ele =checkbox.get(i);
	 * 
	 * String id=ele.getAttribute("id");
	 * 
	 * if(id.equalsIgnoreCase("jqg_Results_Results_PROCESSED__400 Pre BKT")) {
	 * ele.click(); break; } }
	 */
		 
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//*[@type='button' and text()='Initiate Payment']")).click();
		
		
		for(int i=1;i<15;i++) {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='button' and @value='Submit and Copy']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='c-dialog-image c-dialog-rc-middle']//*[@type='button' and text()='OK']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='SubmitCopyPaymentMessageBtnId']")).click();
		
		System.out.println("Payment submitted successfully");
		}
		
		//driver.findElement(By.id("avatarLogout")).click();
		
		driver.close();
	}
}
