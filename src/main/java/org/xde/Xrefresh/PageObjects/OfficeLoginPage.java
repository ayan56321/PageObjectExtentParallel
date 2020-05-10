package org.xde.Xrefresh.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OfficeLoginPage extends BasePage{
	
	/*
	 * public OfficeLoginPage(WebDriver driver) { PageFactory.initElements(driver,
	 * this); }
	 */
	
	
	@FindBy(xpath="//*[@name='loginfmt']")
	public WebElement userNameField ;
	
	@FindBy(xpath="//*[@id='idSIButton9']")
	public WebElement nextButton ;
	
	@FindBy(xpath="//*[@name='passwd']")
	public WebElement passwordField ;
	
	@FindBy(xpath="//*[@id='idSIButton9']")
	public WebElement logInButton ;
	
	
	public OfficeLoginPage doLoginasInvalidUser(String username, String password) throws InterruptedException {
		
		type(userNameField, username, "UserName");
		
		click(nextButton,"Next Button");
		
		Thread.sleep(5000);
		
		type(passwordField, password, "PassWord");
		click(logInButton,"LogIn Button");
		
		return this ;
	}
	
public OfficeAppPage doLoginasvalidUser(String username, String password) throws InterruptedException {
		
		type(userNameField, username, "UserName");
		
		click(nextButton,"Next Button");
		
		Thread.sleep(5000);
		
		type(passwordField, password, "PassWord");
		click(logInButton,"LogIn Button");
		
		return (OfficeAppPage) OpenPage(OfficeAppPage.class);
	}


	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.elementToBeClickable(userNameField);
	}
	

}
