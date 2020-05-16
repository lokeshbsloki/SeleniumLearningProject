package SelenuimBasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropFile {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		Properties prop = new Properties();

		FileInputStream ip = new FileInputStream(
				"G:\\MyJavaProject\\SeleniumSessions\\src\\SelenuimBasics\\config.properties");

		prop.load(ip);

		System.out.println("name is = " + prop.getProperty("name"));

		System.out.println("age is = " + prop.getProperty("age"));
		
		String url = prop.getProperty("url");
		System.out.println("url is = " +url );

		String browser = prop.getProperty("browser");
		System.out.println("browser is = " + browser);

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "G:\\Selenium\\chromedriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get(url);
	}

}
