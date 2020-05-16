package SelenuimBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
		
		//input id=dynamic
		//id=test_123
		//id=test_345 after refresh
		//contains
		driver.findElement(By.xpath("//input[contains(@id,'test_')]"));
		//starts-with
		driver.findElement(By.xpath("//input[starts-with(@id,'test_')]"));
		//id=123_test
		//id=345_test
		//ends-with
		driver.findElement(By.xpath("//input[ends-with(@id,'_test')]"));
		
		//contains(text(),'visible text')
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));
	}
}
