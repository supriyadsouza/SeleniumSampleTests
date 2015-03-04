package com.testSamsung;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainMenu {
	public static WebElement element = null;
	
	public static WebElement mnuElement (WebDriver driver, String mnuTxt)
	{
		String xpath=null;
		switch (mnuTxt)
		{
		case "Shop Products": xpath= ".//nav[@role='navigation']//li[@data-category='Shop']/a"; break;
		}
		element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	public static WebElement subMnuElement (WebDriver driver, String mnuTxt, String subMnuTxt)
	{
		WebElement mnu = mnuElement (driver, mnuTxt);
		mnu.click();
		WebElement subMnu = null;
		
		switch (subMnuTxt)
		{
		case "Shop Samsung": 
			subMnu = mnu.findElement(By.xpath("..//li[@data-category='Shop Samsung']/a")); break;
		case "Cell Phones": 
			subMnu = mnu.findElement(By.xpath("..//li[@data-category='Cell Phones']/a")); break;
		case "TVs": 
			subMnu = mnu.findElement(By.xpath("..//li[@data-category='TVs']/a")); break;
		}
		return subMnu;
	}
	
	public static WebElement subsubMnuElement (WebDriver driver, String mnuTxt, String subMnuTxt, String subSubMnuTxt)
	{
		WebElement subMnu = subMnuElement(driver, mnuTxt, subMnuTxt);
		Actions action = new Actions(driver);
		action.moveToElement(subMnu).build().perform();
		WebElement subSubMnu = null;
		
		subSubMnu = subMnu.findElement(By.xpath("..//a[text()='"+subSubMnuTxt+"']"));
		return subSubMnu;
	}
}



