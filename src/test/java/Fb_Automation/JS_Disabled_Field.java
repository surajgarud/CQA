package Fb_Automation;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JS_Disabled_Field {
	public WebDriver driver;
	public JavascriptExecutor java;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\suraj\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		java = (JavascriptExecutor)driver;
	}
	@Test
	public void Disabled_Field() throws InterruptedException {
		driver.get("file:///C:/Users/suraj/Desktop/JS.html");
		java.executeScript("document.getElementById('t1').value='Garud'");
		Thread.sleep(3000);
		java.executeScript("document.getElementById('t2').value='GARUD'");
		Thread.sleep(3000);
		java.executeScript("document.getElementById('t2').type='radio'");
		Thread.sleep(3000);
		driver.close();
		
	}
	@Test
	public void Scroll() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		java.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		java.executeScript("window.scrollBy(0,-200)");
		Thread.sleep(2000);
		driver.close();
	}
	
}
