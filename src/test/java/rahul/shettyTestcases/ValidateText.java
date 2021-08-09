package rahul.shettyTestcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Test.BaseTest;
import pageObjects.LandingPage;
import pageObjects.SignIn;

public class ValidateText extends BaseTest{
	WebDriver driver;
	LandingPage lp;
	SignIn Si;
	
	@BeforeMethod
	public void setup() throws IOException
	{
	driver=	initalizeDriver();
	lp= new LandingPage(driver);

     }
	@Test(priority=1)
	public void TitlepageValidation()
	{
	String title = lp.ValidateLoginTitle();
	System.out.println(title);
	Assert.assertEquals(title,"Rahul Shetty Academy");
	}

	
	@Test(priority=2)
	public void pageTextValid()
	
	{
	Assert.assertEquals(lp.pageTextValidation().getText(), "Featured Courses1");
	}
	
	@AfterMethod
	public void windup()
	{
		
		driver.quit();
	}
	


	}


