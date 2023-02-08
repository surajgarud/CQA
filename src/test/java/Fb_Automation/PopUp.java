package Fb_Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUp {
	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\suraj\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void SeeAlert() throws InterruptedException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
		Alert alt = driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println(alt.getText());     //PRINT TEXT ON POPUP//
		alt.accept();
		   
		driver.close();
	}

	@Test
	public void SeeAlert5sec() throws InterruptedException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
		Thread.sleep(6000);
		Alert alt = driver.switchTo().alert();
		Thread.sleep(2000);
		alt.accept();
	}
	
	@Test
	public void SeeAlertConfirmBtn() throws InterruptedException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		driver.close();
	
	}
	@Test
	public void SeeAlertPromtbox() throws InterruptedException, AWTException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		Robot robot = new Robot();
		robot.mouseWheel(3);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//button[text()='Click me'])[4]")).click();  //Get Value By Index//
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("SURAJ");	
		Thread.sleep(3000);
		alert.accept();
		Thread.sleep(3000);
		driver.close();
		
		
	}
	@Test
	public void hidepopup() throws InterruptedException {
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("21")).click();
		Thread.sleep(2000);
		driver.close();
	}
	
	
	
	
	
	
	
	
//	@Test
//	public void explicitwai() throws InterruptedException {
//		driver.get("https://demoqa.com/alerts");
//		driver.manage().window().maximize();
//		WebDriverWait wait = new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("confirmButton")).click()));
//		Thread.sleep(2000);
//		Alert alert = driver.switchTo().alert();
//		alert.dismiss();
//		driver.close();
//	
//	}
}
