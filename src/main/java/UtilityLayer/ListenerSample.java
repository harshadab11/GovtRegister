package UtilityLayer;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseLayer.BaseClass;



public class ListenerSample extends BaseClass implements ITestListener{
	ExtentReports extentReports;
	ExtentSparkReporter abc;
	ExtentTest extenttest;
	
	@Override
	public void onStart(ITestContext context) {
		extentReports= new ExtentReports();
//		String s1= new SimpleDateFormat("ddMMyyyy_HHmmss").format(new java.util.Date());
//		String suiteName=context.getSuite().getName();
		abc = new ExtentSparkReporter("user.dir"+"\\ExtentHTMLReports\\"+"a.html");
		extentReports.attachReporter(abc);	
	}

	@Override
	public void onTestStart(ITestResult result) {
		extenttest=extentReports.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		System.out.println("Test case Started name is "+methodname);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File f = ts.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat s = new SimpleDateFormat("ddMMyyyy_HHmmss");
		String date = s.format(new Date(0));
		String ActualDate= new SimpleDateFormat("ddMMyyyy").format(new Date(0));
		File Dest= new File(System.getProperty("user.dir")+"\\DecPassSS\\"+ActualDate+"\\"+methodname+date+".png");
		try {
			FileUtils.copyFile(f,Dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extenttest.log(com.aventstack.extentreports.Status.FAIL,"TC Fail name is"+result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extenttest.log(com.aventstack.extentreports.Status.SKIP,"TC Skip name is"+result.getMethod().getMethodName());
		
		
	}



	@Override
	public void onFinish(ITestContext context) {
	
		extentReports.flush();
	}
	

}
