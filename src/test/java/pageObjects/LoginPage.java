package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@name='user-name']")
	WebElement email;
	
	@FindBy(xpath="//*[@name='password']")
	WebElement pasword;
	
	@FindBy(xpath="//input[@name='login-button']")
	WebElement loginButton;
	
	public void enterEmail(String userName) 
	{
		email.clear();
		email.sendKeys(userName);	
	}
	
	public void enterPassword(String password) 
	{
		pasword.clear();
		pasword.sendKeys(password);
	}
	
	public void clickOnLoginButton() 
	{
		loginButton.click();
	}
	
	
	
}
