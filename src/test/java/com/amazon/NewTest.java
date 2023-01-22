package com.amazon;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;


public class NewTest {
	public WebDriver w ;
	public static String nokia105Mobile;
	static HttpURLConnection http = null;
	static int response =200;


	
  @BeforeMethod(groups="default")
  public void beforeMethod() {
	  System.out.println(System.currentTimeMillis());
	  System.out.println(ClassA.getInstance());
  }

  @AfterMethod(groups="default")
  public void afterMethod() {
	  System.out.println(System.currentTimeMillis());
  }

  @Parameters({"browser"})
  @BeforeClass(groups="default")
  public void beforeClass(String name) {
	 
	  SoftAssert s = new SoftAssert();
	  s.assertTrue(false);
//	  Assert.assertTrue(false);
	  if(name.equals("chrome")) {
	  WebDriverManager.chromedriver().setup();
	  w = new ChromeDriver();
	  }
	  else {
		  WebDriverManager.edgedriver().setup();
		  w = new EdgeDriver();
	  }
	  w.get("https://www.snapdeal.com/");
  }

  @AfterClass(groups="default")
  public void afterClass() {
	  w.quit();
  }
  @Parameters({"searchable"})
  @Test(priority=-1,groups="smoke")
  public void search(@Optional("Nokia")String search)
  {
	  
	  WebElement sear = w.findElement(By.id("inputValEnter"));
	  sear.sendKeys(search,Keys.ENTER);
	  sear.clear();
	  WebDriverWait e = new WebDriverWait(w, 10);
  }
  
  
  @Test(priority=2,groups="smoke")
  public void nokia105() {
	  WebElement nokia = w.findElement(By.xpath("(//p[contains(text(),'Nokia Nokia105')])[2]"));
	  nokia105Mobile = nokia.getText();
	  boolean displayed = nokia.isDisplayed();
	  boolean enabled = nokia.isEnabled();
	  boolean selected = nokia.isSelected();
	  Assert.assertTrue(displayed);
	nokia.click();  
  }
  @Test(priority=3,groups = "sanity")
  public void wHandling() {
	  String parenturl = w.getWindowHandle();
	  Set<String> child = w.getWindowHandles();
	  for (String x : child) {
		  if(!parenturl.equals(x)) {
			  w.switchTo().window(x);
		  }
		Assert.assertTrue(false);
	}

  }
  @Test(priority=4)
  public void buyNow() {
	  WebElement nokia2 = w.findElement(By.xpath("//h1[contains(text(),'Nokia Nokia105')]"));
	  String nokiaout = nokia2.getText();
	  Assert.assertEquals(nokia105Mobile, nokiaout);
  }
  @Test(priority =5,groups = "sanity")
  public void broke() {
		System.out.println("broke");
  }
  @Test(priority =6,groups = "sanity")
  public void broke1() {
		System.out.println("broke 1");
		
		
		
}
  
  }
