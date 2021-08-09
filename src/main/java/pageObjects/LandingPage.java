package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By loginkey =By.cssSelector("a[href='https://courses.rahulshettyacademy.com/sign_in']");
	By pageText =By.xpath("//h2[contains(text(),'Featured Courses')]");
	

	public LandingPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public String ValidateLoginTitle() 
	{
		return driver.getTitle();
	}

	public WebElement getLogin()
	{
		return driver.findElement(loginkey);
 
	}
	
	public WebElement pageTextValidation()
	{
		return driver.findElement(pageText);
	}
}
