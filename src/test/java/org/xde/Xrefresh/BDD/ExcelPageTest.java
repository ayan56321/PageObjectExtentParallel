package org.xde.Xrefresh.BDD;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.xde.Xrefresh.PageObjects.OfficeAppPage;
import org.xde.Xrefresh.PageObjects.OfficeHomePage;
import org.xde.Xrefresh.PageObjects.OfficeLoginPage;
import org.xde.Xrefresh.Utils.Constants;
import org.xde.Xrefresh.Utils.DataProviders;
import org.xde.Xrefresh.Utils.DataUtil;
import org.xde.Xrefresh.Utils.DriverManager;
import org.xde.Xrefresh.Utils.ExcelReader;

public class ExcelPageTest extends BaseRemoteTest {
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void validateExcelpageTest(Hashtable<String,String> data) throws InterruptedException{		
		 
		System.out.println(" Inside TC2 , browser = "+data.get("browser"));
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "ExcelPageTest", data.get("Runmode"), excel);
		
		  OpenBrowser(data.get("browser"));
		  
		  logInfo("Application Launched on "+data.get("browser"));
		  
		  OfficeHomePage home = new OfficeHomePage().launchApplication("https://www.office.com"); 
		  OfficeLoginPage login = home.gotoLogin(); 		  
		  
		  OfficeAppPage app = login.doLoginasvalidUser(getDefaultUsername(),getDefaultpassword());
		 
		  logInfo("UserName = "+getDefaultUsername()+" Password = "+getDefaultpassword()+" used for Login");
		  app.gotoExcel();
		  
		  logInfo(" Title of Page "+DriverManager.getDriver().getTitle());		
			
	}
	
	@AfterMethod()
	public void quit() {
		logInfo("Test Case Completed");
		closeBrowser();	
	}

}
