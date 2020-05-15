package SelenuimBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcepts {
	
	
	public static void main(String[] args) throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://login.yahoo.com/");
		driver.findElement(By.id("login-username")).sendKeys("lokeshbs1993@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='login-signin']")).click();
		
		
	}

}
