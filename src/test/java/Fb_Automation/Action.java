package Fb_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Action {
	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\suraj\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void ContextClick() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement email = driver.findElement(By.id("passContainer"));
		Actions act = new Actions(driver);
		act.contextClick(email).perform();
		Thread.sleep(2000);
		driver.close();
	}
	
	@Test
	public void moveto() throws InterruptedException {
		driver.get("http://www.actimind.com/");
		driver.manage().window().maximize();
		WebElement pass = driver.findElement(By.partialLinkText("AREAS OF EXPERTISE"));
		Actions act = new Actions(driver);
		act.moveToElement(pass).perform();
		Thread.sleep(2000);
		driver.close();
	}
	@Test
	public void Drag_Drop() throws InterruptedException {
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement drg = driver.findElement(By.xpath("//div[contains(@class,'ui-widget-content ui-draggable ui-draggable-handle')]"));
		WebElement drp = driver.findElement(By.xpath("//p[text()='Drop here']"));
		Actions act = new Actions(driver);
		act.dragAndDrop(drg, drp).perform();
		Thread.sleep(5000);
		driver.close();
}
	@Test
	public void Drag_Drop1() throws InterruptedException {
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement drg = driver.findElement(By.xpath("//div[contains(@class,'ui-widget-content ui-draggable ui-draggable-handle')]"));
		WebElement drp = driver.findElement(By.xpath("//p[text()='Drop here']"));
		Actions act = new Actions(driver);
		act.moveToElement(drg).clickAndHold().perform();
		act.release(drp).perform();
		Thread.sleep(5000);
		driver.close();
	}
	@Test
	public void doublClick() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement email = driver.findElement(By.id("passContainer"));
		Actions act = new Actions(driver);
		act.doubleClick(email).perform();
		Thread.sleep(2000);
		driver.close();
	}

}
