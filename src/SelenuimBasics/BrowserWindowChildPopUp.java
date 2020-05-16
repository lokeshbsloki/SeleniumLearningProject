package SelenuimBasics;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowChildPopUp {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.dummysoftware.com/popupdummy_testpage.html");
		driver.findElement(By.xpath("//input[@name='PushButton']")).click();
		Thread.sleep(3000);
		Set<String> handler = driver.getWindowHandles();
		//to iterate set
		Iterator<String> it = handler.iterator();
		String parentwindowid = it.next();
		System.out.println("parent window id = "+parentwindowid);
		
		String childwindowid=it.next();
		System.out.println("child window id = "+childwindowid);
		driver.switchTo().window(childwindowid);
		System.out.println("child window title = "+driver.getTitle());
		driver.close();
		driver.switchTo().window(parentwindowid);
		System.out.println("parent title = "+driver.getTitle());
	}
}
