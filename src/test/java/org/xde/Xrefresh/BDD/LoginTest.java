package org.xde.Xrefresh.BDD;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xde.Xrefresh.PageObjects.OfficeHomePage;
import org.xde.Xrefresh.PageObjects.OfficeLoginPage;
import org.xde.Xrefresh.Utils.Constants;
import org.xde.Xrefresh.Utils.DataProviders;
import org.xde.Xrefresh.Utils.DataUtil;
import org.xde.Xrefresh.Utils.DriverManager;
import org.xde.Xrefresh.Utils.ExcelReader;


public class LoginTest extends BaseRemoteTest{
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void loginTest(Hashtable<String,String> data) throws InterruptedException{
		
		//System.out.println(" Inside TC1 , browser = "+data.get("browser"));
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "LoginTest", data.get("Runmode"), excel);
		
		  OpenBrowser(data.get("browser"));
		  
		  logInfo("Application Launched on "+data.get("browser"));
		  
		  OfficeHomePage home = new OfficeHomePage().launchApplication("https://www.office.com"); 
		  OfficeLoginPage login = home.gotoLogin(); 
		  login.doLogin(data.get("username"),data.get("password"));
		  
		  logInfo("UserName = "+data.get("username")+" Password = "+data.get("password")+" used for Login");
		 		 	  
		  logInfo(" Title of Page "+DriverManager.getDriver().getTitle());		
			
	}
	
	@AfterMethod()
	public void quit() {
		logInfo("Test Case Completed");
		closeBrowser();	
	}
	
	@DataProvider(parallel=true)
	public Object[][] getData() {
		Object [][]dt = new Object[1][3];
		
		dt[0][0]= "ayancoolbuddy@gmail.com";
		dt[0][1] = "ag0056321" ;
		dt[0][2] = "chrome" ;
		
		return dt;
	}

}
