package Spotify.Automation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {

	

	
	
	@Test
	public void user() {
		System.out.println("****user****");
	}
	
	
	@BeforeTest
	public void BeforeTest() {
		System.out.println("BeforeTest");
	}
	
	
	@BeforeClass
	public void BeforeClass() {
		System.out.println("BeforeClass");
	}
	
	
	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("BeforeMethod");
	}
	
	
	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("BeforeSuite");
	}
	@AfterTest
	public void AfterTest() {
		System.out.println("AfterTest");
	}
	
	
	@AfterClass
	public void AfterClass() {
		System.out.println("AfterClass");
	}
	
	
	@AfterMethod
	public void AfterMethod() {
		System.out.println("AfterMethod");
	}
	
	
	@AfterSuite
	public void AfterSuite() {
		System.out.println("AfterSuite");
	}
	
}
