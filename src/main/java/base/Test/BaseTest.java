package base.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	
	public WebDriver driver;
	Properties prop;
	@SuppressWarnings("deprecation")
	public WebDriver initalizeDriver() throws IOException
	{
		 
		
		prop = new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\ramya\\eclipse-workspace\\FrameWork\\src\\main\\java\\rahul\\config\\config.propertise");
		prop.load(fis);
	
		String browserName =	prop.getProperty("browser");
		
		String Adarsha = null;
		getScreenShot(Adarsha,driver);
		
	
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\geckodriver.exe");
			 
			driver= new FirefoxDriver();
			
		}
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
		return driver;
	}
  public void getScreenShot(String testname,WebDriver driver) throws IOException
  {
	 TakesScreenshot ts =(TakesScreenshot) driver;
	 File Source=ts.getScreenshotAs(OutputType.FILE);
	 String destination=System.getProperty("user.dir")+"\\reports"+testname+".png";
	 FileUtils.copyFile(Source, new File(destination));
  }}


  
	 
	  

