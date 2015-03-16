package com.testSamsung;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.log4testng.Logger;

public class MenuTests {

	public WebDriver driver;
	public static String baseUrl = "http://www.samsung.com/us/";
	public static Logger log = Logger.getLogger(MenuTests.class);
		
  @BeforeClass
  public void beforeClass() {
	  PropertyConfigurator.configure("log4j.properties");
	  log.info("Starting Firefox browser");
	  //driver = new FirefoxDriver();
	  //driver.manage().window().maximize();
	  log.info("Navigating to Samsung US website");
	  //driver.get(baseUrl);
  }

  @Test
  public void testTVMenu() {
	  log.info("Running the TV menu test");
/*	  MainMenu.subsubMnuElement(driver, "Shop Products", "TVs", "4K SUHD TVs").click();
/*	  checkOverlayAndClose();
	  MainMenu.subsubMnuElement(driver, "Shop Products", "TVs", "4K UHD TVs").click();
	  checkOverlayAndClose();
	  MainMenu.subsubMnuElement(driver, "Shop Products", "TVs", "LED TVs").click();
	  checkOverlayAndClose();
	  MainMenu.subsubMnuElement(driver, "Shop Products", "TVs", "Plasma TVs").click();
	  checkOverlayAndClose();
	  MainMenu.subsubMnuElement(driver, "Shop Products", "TVs", "Smart Signage TVs").click();
	  driver.navigate().back();
	  MainMenu.subsubMnuElement(driver, "Shop Products", "TVs", "See All TVs").click();  */
  }
  
  public void checkOverlayAndClose()
  {
	  WebElement overlayFeedback;
	  try{
		  overlayFeedback= driver.findElement(By.id("fsrOverlay"));
	  }
	  catch (NoSuchElementException e){
	  	return;
	  }
	  if (overlayFeedback.isDisplayed())
		  driver.findElement(By.className("fsrCloseBtn")).click();
  }
  
  @AfterClass
  public void afterClass() {
	  log.info("Closing the browser");
	  //driver.close();
	  //driver.quit();
  }

}