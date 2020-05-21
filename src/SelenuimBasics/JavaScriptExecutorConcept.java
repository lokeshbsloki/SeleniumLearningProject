package SelenuimBasics;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ui.freecrm.com/");
		driver.findElement(By.xpath("//input[@placeholder='E-mail address']")).sendKeys("lokeshbs1994@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Lokeshbscrm@1");
		WebElement element = driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
		//to highlight element
		flash(element, driver);
		//to draw border around element
		drawBorder(element, driver);
		
		//to take screenshot
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("G:\\MyJavaProject\\SeleniumSessions\\Screenshots\\google.png"));
		
		//to generate alert pop up
		generateAlertPopup(driver, "there is a problem in login button");
		
		//handle alert popup
		driver.switchTo().alert().accept();
		
		//click by javascript executor
		clickOnElementByJavaScriptExecutor(element, driver);
		
		//to refresh browser
		//1.selenium api
		driver.navigate().refresh();
		//2.by using JSE
		Thread.sleep(3000);
		refreshBrowserByJSE(driver);
		
		//to get title
		String Title = getTitleByJSE(driver);
		System.out.println("title of the page is "+Title);
		
		//to get inner text
		String pagetext = getPageInnerTextByJSE(driver);
		System.out.println("page text is = "+pagetext);
		
		//to scroll page till complete down
		scrollPageDownByJSE(driver);
		
		
	}
	public static void flash(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String bgmcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 100; i++) {
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgmcolor, element, driver);
		}
	}
	public static void changeColor(String color, WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		
	}
	
	public static void drawBorder(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
        js.executeScript("arguments[0].style.border = '3px solid red'", element);

	}
	
	public static void generateAlertPopup(WebDriver driver, String message)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
        js.executeScript("alert('"+message+"')");
	}
	
	public static void clickOnElementByJavaScriptExecutor(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void refreshBrowserByJSE(WebDriver driver)
	{
	
		JavascriptExecutor js=((JavascriptExecutor)driver);
        js.executeScript("history.go(0)");
	}
	
	public static String getTitleByJSE(WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
       String title = js.executeScript("return document.title").toString();	
       return title;
	}
	
	public static String getPageInnerTextByJSE(WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
       String innertext = js.executeScript("return document.documentElement.innerText;").toString();	
       return innertext;
	}
	
	public static void scrollPageDownByJSE(WebDriver driver)
	{
	
		JavascriptExecutor js=((JavascriptExecutor)driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scrollIntoViewByJSE(WebDriver driver,WebElement element)
	{
	
		JavascriptExecutor js=((JavascriptExecutor)driver);
        js.executeScript("arguments[0].scrollIntoView(true)",element);
	}

}
