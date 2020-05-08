package org.xde.Xrefresh.BDD;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;
import org.xde.Xrefresh.ExtentListeners.ExtentListeners;
import org.xde.Xrefresh.Utils.DriverFactory;
import org.xde.Xrefresh.Utils.DriverManager;

public class BaseRemoteTest {
	
	private WebDriver driver ;
	private Properties config = new Properties();
	
	private FileInputStream fis;
	public Logger log = Logger.getLogger(BaseRemoteTest.class);
	
	public boolean grid = true ;
	
	@BeforeSuite
	public void setUpFramework() {
		configureLogging();
		DriverFactory.setGridPath("http://localhost:4444/wd/hub");
		
		DriverFactory.setConfigPropertyFile(System.getProperty("user.dir")+"//resources//properties//Config.properties");
		
		
		if (System.getProperty("os.name").contains("Windows")) {
			DriverFactory.setChromeDriverPath(System.getProperty("user.dir")+"//resources//executables//chromedriver.exe");
			//DriverFactory.setGeckoDriverPath(System.getProperty("user.dir")+"//resources//executables//geckodriver.exe");			
		}
		
		try {
			fis = new FileInputStream(DriverFactory.getConfigPropertyFile());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			config.load(fis);
			log.info("Configuration File Loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void logInfo(String message) {
		System.out.println(" in the logInfo area "+message);
		ExtentListeners.testReport.get().info(message);
	}
	
	public void configureLogging() {
		String log4jConfigFile = System.getProperty("user.dir")+"//resources//properties//log4j.properties" ;
		PropertyConfigurator.configure(log4jConfigFile);
	}

	/*
	 * public static ThreadLocal<RemoteWebDriver> dr = new
	 * ThreadLocal<RemoteWebDriver>();
	 * 
	 * public WebDriver getDriver(){ return dr.get(); }
	 * 
	 * public void setDriver(RemoteWebDriver driver){ dr.set(driver); }
	 */
	public void OpenBrowser(String browser){
	
		if (System.getenv("ExecutionType")!=null && System.getenv("ExecutionType").equals("Grid")) {
			grid = true;
		}
		
	
	// Setting the Driver Mode as Remote / NonRemote
	DriverFactory.setRemote(grid);
	
	if (DriverFactory.isRemote()) {
		System.out.println("Remote Browser = "+browser);
		
		DesiredCapabilities cap = null ;
		
		if (browser.equals("chrome")){
			cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.ANY);
			
		}else if (browser.equals("firefox")){
			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.ANY);
		}
			
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			log.info("Grid Session Launched");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}else {
		System.out.println("Browser = "+browser);
		if (browser.equals("chrome")){
			//System.out.println(System.getProperty("user.dir")+"\\resources\\executables\\chromedriver.exe");
			//System.getProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
			
			System.getProperty("webdriver.chrome.driver",DriverFactory.getChromeDriverPath());
			driver = new ChromeDriver();
			log.info("Chrome Browser Launched");
		}
	}	
		
	DriverManager.setDriver(driver);
	DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	DriverManager.getDriver().manage().window().maximize();
	
	//DriverManager.getDriver().get("https://www.office.com");	
		
	}
	
	public void closeBrowser(){
		DriverManager.getDriver().quit();
	}

}
