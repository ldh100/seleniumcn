package cn.seleniumcn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.Assert;

/**
@author Bruce Gu
**/
public class HelloworldWebdriverTestNG {
	
	public  static final String SELENIUMCN_LINK = "//div[@id='content_left']/table[@id='1']//h3/a";

	WebDriver driver;
	
	@Test
	public void testOne() throws Exception {	
		
		driver = new FirefoxDriver();
		
		driver.get("http://www.oooooooo.com");

		
		WebElement query = driver.findElement(By.name("wd"));
		query.sendKeys("selenium ������̳");

		WebElement btn = driver.findElement(By.id("su"));
		btn.click();
		Thread.sleep(5000);
		

		WebElement link = driver.findElement(By
				.xpath(SELENIUMCN_LINK));
		link.click();
		Thread.sleep(5000);
		
		driver.switchTo().window(driver.getWindowHandles().toArray(new String[0])[1]);
		
		String expectedTitle ="Selenium ������̳, Webdriver ������̳, Selenium2, �������,web�Զ�������";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);		

	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
}