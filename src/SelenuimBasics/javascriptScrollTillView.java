package SelenuimBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javascriptScrollTillView {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://freecrm.co.in/");
		
		Thread.sleep(2000);
		WebElement element=driver.findElement(By.xpath("//span[contains(text(),'Register now')]"));
		scrollIntoViewByJSE(driver, element);
		Thread.sleep(2000);
element.click();

	}

	public static void scrollIntoViewByJSE(WebDriver driver,WebElement element)
	{
	
		JavascriptExecutor js=((JavascriptExecutor)driver);
        js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
}
