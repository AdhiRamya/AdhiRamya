package rahul.shettyTestcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtentActivity.ExtenReporterNg;
import base.Test.BaseTest;

public class Listeners extends BaseTest implements ITestListener {
	ExtenReporterNg Ex = new ExtenReporterNg();
	ExtentReports exten = Ex.getReport();
	
	

	
	ExtentTest tests;
	//BaseTest Bt = new BaseTest();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub 
		ITestListener.super.onTestStart(result);
		tests = (exten.createTest(result.getMethod().getMethodName()));
		tests.log(Status.PASS, "TestStared");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		tests.log(Status.PASS, "Testpassed");

	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
	   tests.fail(result.getThrowable());
	   WebDriver driver=null;
	try {
		driver= (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	   try {
		getScreenShot(result.getMethod().getMethodName(),driver);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	   
	

	


	// TODO Auto-generated method stub

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		exten.flush();
	}

}
