package Fb_Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tables {
	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\suraj\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void WebTable() {
		driver.get("C:\\Users\\suraj\\Desktop\\Table.html");
		driver.manage().window().maximize();
		List<WebElement> web = driver.findElements(By.xpath("//tr"));
		int TotalRows= web.size();
		System.out.println("total Rows:"+ TotalRows);	
	}
	@Test
	public void WebTableCLM() {
		driver.get("C:\\Users\\suraj\\Desktop\\Table.html");
		driver.manage().window().maximize();
		List<WebElement> web = driver.findElements(By.xpath("//th"));
		int TotalColumn= web.size();
		System.out.println("total Column:"+ TotalColumn);		
	}
	
	@Test
	public void WebTableCell() {
		driver.get("C:\\Users\\suraj\\Desktop\\Table.html");
		driver.manage().window().maximize();
		List<WebElement> web = driver.findElements(By.xpath("//td"));
		int TotalCells= web.size();
		System.out.println("total Column:"+ TotalCells);		
	}

}
