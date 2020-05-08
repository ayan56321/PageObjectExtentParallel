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
	
	
	public OfficeLoginPage doLogin(String username, String password) throws InterruptedException {
		//userNameField.sendKeys(username);
		type(userNameField, username, "UserName");
		
		//nextButton.click();
		click(nextButton,"Next Button");
		
		//passwordField.wait();
		Thread.sleep(5000);
		
		//passwordField.sendKeys(password);
		type(passwordField, password, "PassWord");
		
		//logInButton.click();
		click(logInButton,"LogIn Button");
		
		
		return this ;
		
	}


	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.elementToBeClickable(userNameField);
	}
	

}
