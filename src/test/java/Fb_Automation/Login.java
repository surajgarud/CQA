package Fb_Automation;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
	
	public WebDriver driver;   //Upcasting//
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\suraj\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void login() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		String source = driver.getPageSource();
		String URL = driver.getCurrentUrl();
		System.out.println(title);
		System.out.println(source);
		System.out.println(URL);
		Thread.sleep(3000);
		driver.close();
	}
	@Test
	public void navigate() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.navigate().to("https://github.com/");
		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().forward();
		//driver.close();
	}
	@Test
	public void locators() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("surajgarud49@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("pass")).sendKeys("Suraj@123");
		Thread.sleep(1000);
		driver.findElement(By.name("login")).click();
		Thread.sleep(12000);
		driver.close();
	}

	@Test
	public void CSStype() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("surajgarud95@gmail.com");
		driver.findElement(By.linkText("Forgotten password?")).click();
		driver.close();
	}
	@Test
	public void CSSid() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[id='email']")).sendKeys("surajgarud95@gmail.com");
		driver.findElement(By.partialLinkText("Forgotten")).click();
		driver.close();
	}
	@Test
	public void CSSclass() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[class='inputtext _55r1 _6luy']")).sendKeys("surajgarud95@gmail.com");
		Thread.sleep(3000);
		driver.close();
	}
	@Test
	public void screenshot() throws IOException, InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.id("email"));
		element.sendKeys("surajgarud49@gmail.com");
		TakesScreenshot ts = (TakesScreenshot)driver;      //Down Casting//
		File file = ts.getScreenshotAs(OutputType.FILE);
		File Afile = new File("C:\\Users\\suraj\\eclipse-workspace\\Automation_FB\\FB_Screenshot\\"+"FB_SS.png");
		FileHandler.copy(file,Afile);
		Thread.sleep(3000);
		driver.close();
	}
	@Test
	public void scroll() throws AWTException, InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Robot robot = new Robot();
		robot.mouseWheel(2);
		Thread.sleep(2000);
		robot.mouseWheel(-1);
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test
	public void Mousemove() throws AWTException, InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Robot robot = new Robot();
		robot.mouseMove(100, 600);
		Thread.sleep(3000);
		driver.close();
	}
	@Test
	public void keyboardOP() throws AWTException, InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyPress(KeyEvent.VK_U);
		robot.keyRelease(KeyEvent.VK_U);
		robot.keyPress(KeyEvent.VK_R);
		robot.keyRelease(KeyEvent.VK_R);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_J);
		robot.keyRelease(KeyEvent.VK_J);
		Thread.sleep(3000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		driver.findElement(By.xpath("//div[contains(@class,'_9lsb _9ls8')]")).click();
		Thread.sleep(3000);
		driver.close();
	}
	@Test
	public void XpathPass() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='password'][@id='pass']")).sendKeys("suraj");
		
	}
	

}
