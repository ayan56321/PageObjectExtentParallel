package org.xde.Xrefresh.BDD;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xde.Xrefresh.PageObjects.OfficeHomePage;
import org.xde.Xrefresh.PageObjects.OfficeLoginPage;
import org.xde.Xrefresh.Utils.DataProviders;
import org.xde.Xrefresh.Utils.DriverManager;

public class TestCase2 extends BaseRemoteTest{
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void doLogin(String username , String password , String browser) throws InterruptedException{
		
		System.out.println(" Inside TC2 , browser = "+browser);
		
		OpenBrowser(browser);
		
		
		  OfficeHomePage home = new OfficeHomePage(); 
		  OfficeLoginPage login = home.gotoLogin(); 
		  login.doLogin("ayancoolbuddy@gmail.com", "ag0056321");
		
			/*
			 * getDriver().findElement(By.xpath(
			 * "//*[@id='hero-banner-sign-in-to-office-365-link']")).click();
			 * 
			 * getDriver().findElement(By.xpath("//*[@name='loginfmt']")).sendKeys(username)
			 * ; getDriver().findElement(By.xpath("//*[@id='idSIButton9']")).click();
			 * 
			 * WebDriverWait wbWait = new WebDriverWait(getDriver(),10);
			 * wbWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * "//*[@name='passwd']")));
			 * 
			 * getDriver().findElement(By.xpath("//*[@name='passwd']")).sendKeys(password);
			 * getDriver().findElement(By.xpath("//*[@id='idSIButton9']")).click();
			 */
		 
		
		System.out.println(" Title of Page "+DriverManager.getDriver().getTitle()+" in TC2");
		
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
