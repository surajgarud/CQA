package Fb_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Frame {
	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\suraj\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void frame() throws InterruptedException {
		driver.get("file:///C:/Users/suraj/Desktop/frame2.html");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		driver.findElement(By.id("1")).sendKeys("Vikas");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.findElement(By.id("3")).sendKeys("Kamat");
		Thread.sleep(2000);
		driver.close();
	}

}
