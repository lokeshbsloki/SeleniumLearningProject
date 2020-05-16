package SelenuimBasics;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileDownloadPopUp {

	public static void main(String[] args) {
		
		String downloadpath="G:\\Selenium\\downloadfile";
		
		Map<String,Object> chromeopts=new HashMap<String, Object>();
		chromeopts.put("profile.default_content_settings.popups", 0);
		chromeopts.put("download.default_directory",downloadpath);
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", chromeopts);
		
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		
		driver.get("https://skpatro.github.io/demo/links/");
		driver.findElement(By.xpath("//div[@class='download']//input[@class='btn']")).click();
		
	}
}
