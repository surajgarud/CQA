package Fb_Automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Selectmethod {
	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\suraj\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
    @Test
	public void select() throws InterruptedException {
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("Create new account")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		Thread.sleep(3000);
		WebElement list = driver.findElement(By.id("day"));
		Select s = new Select(list);
		List<WebElement> options = s.getOptions();
		int size = options.size();
		System.out.println("Number of elements:"+size);
		for (WebElement obj : options) {
			String text = obj.getText();
			System.out.println(text);
		}
	}
    @Test
    public void byId() {
    	driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("Create new account")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement list = driver.findElement(By.id("day"));
		Select s = new Select(list);
		s.selectByIndex(2);
    }
    @Test
    public void byValue() {
    	driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("Create new account")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement list = driver.findElement(By.id("day"));
		Select s = new Select(list);
		s.selectByValue("6");
    }
    
    @Test
    public void byVisibletext() {
    	driver.get("file:///C:/Users/suraj/Desktop/Select.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement list = driver.findElement(By.id("mtr"));
		Select s = new Select(list);
		s.selectByVisibleText("VADA");
    }

	@Test
	public void sele() {
		driver.get("file:///C:/Users/suraj/Desktop/Select.html");
	driver.manage().window().maximize();
	WebElement list = driver.findElement(By.id("mtr"));
	Select s = new Select(list);
	List<WebElement> options = s.getOptions();
	int size = options.size();
	System.out.println("Number of elements present inside the listbox is : "+ size);
		for (WebElement webElement : options) {
			String text = webElement.getText();
			System.out.println(text);
			}	
	}

}
