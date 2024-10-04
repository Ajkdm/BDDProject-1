package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='Open Menu']")
	WebElement menu;
	
	@FindBy(id="")
	WebElement b;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutButton;
	
	public void clickOnMenu() 
	{
		menu.click();	
	}
	
	public void clickOnLogoutButton() 
	{
		logoutButton.click();	
	}
}
