package org.xde.Xrefresh.BDD;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	private WebDriver driver ;
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<>();
	
	public WebDriver getDriver(){
		return dr.get();
	}
	
	public void setDriver(WebDriver driver){
		dr.set(driver);
	}
	
	public void OpenBrowser(String browser){
		
		System.out.println("Browser = "+browser);
		
	if (browser.equals("chrome")){
		//System.out.println(System.getProperty("user.dir")+"\\resources\\executables\\chromedriver.exe");
		System.getProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	setDriver(driver);
	getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	getDriver().manage().window().maximize();
	
	getDriver().get("https://www.office.com");
	
		
	}
	
	public void closeBrowser(){
		getDriver().quit();
	}

}
