package SelenuimBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ui.freecrm.com/");
		driver.findElement(By.xpath("//input[@placeholder='E-mail address']")).sendKeys("lokeshbs1993@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Lokeshbscrm@1");
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		
		driver.switchTo().frame("FRAME NAME");
		//then we can continue working on that frame
		//perform some actions 
		
		//to switch back to main Html
		driver.switchTo().defaultContent();
	}
}
