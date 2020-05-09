package org.xde.Xrefresh.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OfficeAppPage extends BasePage {
	
	@FindBy(xpath="//div[text()=' Excel ']")
	public WebElement Excel;
	
	@FindBy(xpath="//div[text()=' Outlook ']")
	public WebElement Outlook;
	
	@FindBy(xpath="//div[text()=' Skype ']")
	public WebElement Skype;
	
	@FindBy(xpath="//div[text()=' OneNote ']")
	public WebElement OneNote;
	
	@FindBy(xpath="//div[text()=' PowerPoint ']")
	public WebElement PowerPoint;
	
	@FindBy(xpath="//div[text()=' Calendar ']")
	public WebElement Calendar;
	
	@FindBy(xpath="//div[text()=' Word ']")
	public WebElement Word;
	
	
	public void gotoExcel() {
		click(Excel,"Excel Link");
	}
	
	public void gotoWord() {
		click(Word,"Word Link");
	}
	
	

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(Calendar);
	}

}
