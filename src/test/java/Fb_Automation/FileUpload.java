package Fb_Automation;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUpload {

	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\suraj\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void upload() throws InterruptedException {
		driver.get("http://nervgh.github.io/pages/angular-file-upload/examples/simple/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\suraj\\Documents\\ABSTRACT.pdf");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(3000);
		driver.close();
		
		
	}
	@Test
	public void UploadUsingTool() throws InterruptedException, IOException {
		driver.get("https://smallpdf.com/pdf-converter");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='l3tlg0-0 ggoliT']")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\suraj\\Documents\\FileUpload.exe");
		Thread.sleep(5000);
		driver.close();
	}
	@Test
	public void download() {
		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("4.8.0")).click();
	}
	@Test
	public void Childtab() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
	}
}
