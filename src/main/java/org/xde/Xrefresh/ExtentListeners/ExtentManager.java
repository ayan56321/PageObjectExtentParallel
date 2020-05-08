package org.xde.Xrefresh.ExtentListeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.xde.Xrefresh.Utils.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {

	private static ExtentReports extent;	
	

	    public static ExtentReports createInstance(String fileName) {
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
	        
	        System.out.println("In the instance - ExtentManager");
	       
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(fileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName("XRefresh_Suite_Regression");
	        
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Automation Tester", "Ayan Ghosh");
	        extent.setSystemInfo("Organization", "TCS");
	        extent.setSystemInfo("Build no", "W2A-1234");
	        
	        System.out.println(extent);
	        
	        return extent;
	    }

	    
	    public static String screenshotPath;
		public static String screenshotName;
		
		public static void captureScreenshot() {

			File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

			Date d = new Date();
			screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

			try {
				FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		}
	

	}
