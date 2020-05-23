package SelenuimBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://login.yahoo.com/account/create?src=noSrc&specId=yidReg");
		
		boolean b1 = driver.findElement(By.xpath("//button[@id='reg-submit-button']")).isDisplayed();
		
		System.out.println("continue button displayed or not = "+b1);
		
		boolean b2 = driver.findElement(By.xpath("//button[@id='reg-submit-button']")).isEnabled();
		System.out.println("continue button enabled or disabled = "+b2);

		
	}
}
