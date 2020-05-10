package org.xde.Xrefresh.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExcelPage extends BasePage {

	@FindBy(xpath="//*[@title='New blank workbook']")
	public WebElement newBlankWkBk;
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(newBlankWkBk);
	}

}
