package org.xde.Xrefresh.ExtentListeners;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class ExtentListeners implements ITestListener {

	static Date d = new Date();
	static String fileName = "XRefresh_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	
	public static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"\\reports\\"+fileName);
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	

	public void onTestStart(ITestResult result) {
				
		ExtentTest test = extent.createTest(result.getTestClass().getName()+" @TestCase : "+result.getMethod().getMethodName());        
		testReport.set(test);

	}

	public void onTestSuccess(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		
		testReport.get().pass(m);
		
		ExtentManager.captureScreenshot();
		try {			
			testReport.get().pass(logText,MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		
		
		String excepionMessage=Arrays.toString(result.getThrowable().getStackTrace());
		testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
				+ "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
		
		try {

			ExtentManager.captureScreenshot();
			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName)
							.build());
		} catch (IOException e) {

		}
		
		String failureLogg="TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m);

	}

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReport.get().skip(m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		

	}

	public void onFinish(ITestContext context) {
				
			try {
				extent.flush();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
