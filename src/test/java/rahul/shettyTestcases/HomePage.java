 package rahul.shettyTestcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.Test.BaseTest;
import pageObjects.LandingPage;
import pageObjects.SignIn;

public class HomePage extends BaseTest{
	
	LandingPage lp;
	SignIn Si;
WebDriver driver;

	@BeforeMethod
	public void setup() throws IOException
	{

		driver=initalizeDriver();
	lp= new LandingPage(driver);
	Si= new SignIn(driver);
	}
	@Test(priority=1)
	public void TitlepageValidation()
	{
	String title = lp.ValidateLoginTitle();
	Assert.assertEquals(title,"Rahul Shetty Academy");
	}
	
	@Test(priority=2)
	public void log()
	{  
	lp.getLogin().click();
	}
	@Test(dataProvider="getData")
	public void SignInPage(String email,String Password)
	{
    lp.getLogin().click();
	Si.getEmail().sendKeys(email);
	Si.getPassword().sendKeys(Password);
	Si.getEnter().click();
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[1][2];
		data[0][0]="adarshags1992@gmail.com";
		data[0][1]="Havish@123";
		return data;
		
	}
	
	@AfterMethod
	public void windup()
	{
		driver.quit();
	
	}

	}


