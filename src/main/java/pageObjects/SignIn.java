package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignIn {
	
	public WebDriver driver;

	By email =By.xpath("//input[@id='user_email']");
	By Password =By.xpath("//input[@id='user_password']");
	By login =By.ByClassName.cssSelector("input[type='submit']");
	
	public SignIn(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public SignIn() {
		
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	
	public WebElement getPassword()
	{
		return driver.findElement(Password);
	
	}
	public WebElement getEnter()
	{
		return driver.findElement(login);
	
	}

	public SignIn click() {
	
		return null;
	}
}
