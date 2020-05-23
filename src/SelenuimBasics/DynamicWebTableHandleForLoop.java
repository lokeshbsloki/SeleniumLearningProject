package SelenuimBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandleForLoop {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ui.freecrm.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='E-mail address']")).sendKeys("lokeshbs1993@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Lokeshbscrm@1");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
		Thread.sleep(5000);
		//  //tr[@class='warning']//td[1]  //tr[1]//td[1]
		//  //tr[2]//td[1]
		//   //tr[3]//td[1]
		
		
		//method-1
//		String before_xpath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr[";
//				
//	    String after_xpath="]/td[2]";	
//		for(int i=1;i<=3;i++)
//		{
//			String name = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
//			System.out.println("name is = "+name);
//			
//			if(name.contains("anusha 87657487574 m"))
//			{
//				driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr["+i+"]/td[1]")).click();
//			}
//		} lokesh 8618958043 bs
		
		//method-2
		driver.findElement(By.xpath("//td[contains(text(),'anusha 87657487574 m')]//preceding-sibling::td")).click();
		driver.findElement(By.xpath("//td[contains(text(),'lokesh 8618958043 bs')]//preceding-sibling::td")).click();

		
		
		
	
	}
}
