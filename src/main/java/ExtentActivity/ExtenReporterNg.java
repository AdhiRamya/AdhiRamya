package ExtentActivity;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtenReporterNg {
	
	
	public static ExtentReports extent;
	public static ExtentReports getReport()
	{
	String path  =	System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter =new ExtentSparkReporter(path);
	reporter.config().setReportName("HomePageValidation");
	reporter.config().setDocumentTitle("TestResult");
	
	extent =new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Adarsha");
	return extent;
	}

	}
	
	


