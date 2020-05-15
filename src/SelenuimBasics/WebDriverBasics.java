package SelenuimBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {
	
	public static void main(String[] args) {
		
		//firefox
//        System.setProperty("webdriver.gecko.driver", "G:\\Selenium\\geckodriver.exe");		
//		WebDriver driver=new FirefoxDriver();
//		driver.get("https://www.google.com/");
//		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("lokesh good work");
		
		//for chrome
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
	   String title = driver.getTitle();
	 System.out.println("title of the page is = "+title);
	
	System.out.println("url = " +driver.getCurrentUrl());
	
	//System.out.println(driver.getPageSource());
     driver.close();		
	}

}
