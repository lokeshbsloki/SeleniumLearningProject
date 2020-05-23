package SelenuimBasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;   
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https:www.google.com");
	    Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("testing");
	    Thread.sleep(2000);
	    List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']/li/descendant::div[@class='sbl1']"));
	    System.out.println("Total suggestions::::===>"+list.size());
		for(WebElement ele: list)
		{
			System.out.println(ele.getText());
		}
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("testing powder"))
			{
				list.get(i).click();
				break;
			}
		}
	}

}
