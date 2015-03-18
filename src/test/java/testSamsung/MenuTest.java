package test.java.testSamsung;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


public class MenuTest {

	public WebDriver driver;
	public static String baseUrl = "http://www.samsung.com/us/";
	public static Logger logger = Logger.getLogger(MenuTest.class);
		
  @BeforeClass
  public void beforeClass() {
	  PropertyConfigurator.configure("log4j.properties");
	  logger.info("Starting Firefox browser");
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  logger.info("Navigating to Samsung US website");
	  driver.get(baseUrl);
  }

  @Test
  public void testTVMenu() {
	  logger.info("Running the TV menu test");
	  MainMenu.subsubMnuElement(driver, "Shop Products", "TVs", "4K SUHD TVs").click();
	  checkOverlayAndClose();
	  MainMenu.subsubMnuElement(driver, "Shop Products", "TVs", "4K UHD TVs").click();
	  checkOverlayAndClose();
	  MainMenu.subsubMnuElement(driver, "Shop Products", "TVs", "LED TVs").click();
	  checkOverlayAndClose();
	  MainMenu.subsubMnuElement(driver, "Shop Products", "TVs", "Plasma TVs").click();
	  checkOverlayAndClose();
	  MainMenu.subsubMnuElement(driver, "Shop Products", "TVs", "Smart Signage TVs").click();
	  driver.navigate().back();
	  MainMenu.subsubMnuElement(driver, "Shop Products", "TVs", "See All TVs").click();  
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
	  logger.info("Closing the browser");
	  driver.close();
	  driver.quit();
  }

}