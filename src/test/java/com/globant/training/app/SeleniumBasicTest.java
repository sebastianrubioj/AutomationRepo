package com.globant.training.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumBasicTest {
  private WebDriver mDriver;
  private WebDriverWait mWait;

  
  @BeforeMethod(alwaysRun = true)
  public void beforeMethod(){  
System.setProperty("webdriver.chrome.driver","./res/chromedriver.exe");
    	mDriver = new ChromeDriver();
  }

  @Test
  public void doGoogleSearch() {
	  mDriver.get("http://www.google.com");
	  Assert.assertEquals(mDriver.getTitle(), "Google");
  WebElement searchInput = mDriver.findElement(By.name("q"));
  mWait= new WebDriverWait(mDriver,10);
  
  //WebDriverWait mWait = mDriver.wait(10, seconds);
  searchInput.sendKeys("abc");
  searchInput.submit();
  WebElement searchTitle = mDriver.findElement(By.xpath("q"));
  mWait.until(ExpectedConditions.visibilityOf(searchInput.findElement(By.id("12"))));
  Assert.assertEquals(searchInput.getAttribute("Value"), "abc");
  }
  
  
  @AfterMethod(alwaysRun = true)
  public void afterMethod() {
     if(mDriver != null) mDriver.quit();
  }
}
