package org.xde.Xrefresh.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xde.Xrefresh.ExtentListeners.ExtentListeners;
import org.xde.Xrefresh.Utils.DriverManager;

public abstract class BasePage<T> {
	
	protected WebDriver driver;
	
	public BasePage() {
		this.driver = DriverManager.getDriver();	
	}
	
	public T OpenPage(Class<T> pageclass) {
		
		T page = null ;
		driver = DriverManager.getDriver();
		
		AjaxElementLocatorFactory ajaxElem = new AjaxElementLocatorFactory(driver,10);
		
		page=PageFactory.initElements(driver, pageclass);
		
		PageFactory.initElements(ajaxElem, page);
		
		ExpectedCondition pageLoadCondition = ((BasePage) page).getPageLoadCondition();
		waitForPagetoLoad(pageLoadCondition);
		
		return page;
		/*
		 * 1st - InitElements PageFactory
		 * 2nd - Defining PageLoad Condition
		 * 
		 */		
		
	}
	
	private void waitForPagetoLoad(ExpectedCondition pageLoadCondition) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(pageLoadCondition);
		
	}
	
	protected abstract ExpectedCondition getPageLoadCondition() ;
	
	public void click(WebElement element , String elementName) {		
		element.click();
		ExtentListeners.testReport.get().info("Clicking On "+elementName);
	}
	
	public void type(WebElement element , String value , String elementName) {
		
		element.sendKeys(value);;
		ExtentListeners.testReport.get().info("Entering Data "+value +" in "+elementName);
	}
	
	
	
}
