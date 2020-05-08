package org.xde.Xrefresh.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.xde.Xrefresh.Utils.*;

public class OfficeHomePage extends BasePage {
	
	/*
	 * WebDriver driver ;
	 * 
	 * public OfficeHomePage(WebDriver driver) { this.driver = driver ;
	 * PageFactory.initElements(driver, this); }
	 */
	
	
	@FindBy(xpath="//*[@id='hero-banner-sign-in-to-office-365-link']")
	public WebElement SignInButton ;
	
	public  OfficeHomePage launchApplication(String URL) {
		
		DriverManager.getDriver().navigate().to(URL);
		return (OfficeHomePage) OpenPage(OfficeHomePage.class);
		
	}
		
	public OfficeLoginPage gotoLogin() {		
		//SignInButton.click();
		click(SignInButton,"Sign In");
		return (OfficeLoginPage) OpenPage(OfficeLoginPage.class);
		
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(SignInButton);
	}

}
