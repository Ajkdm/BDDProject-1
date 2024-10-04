package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class Test1
{
	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	
	@Test(priority=1)
	public void user_launch_chrome_browser() 
	{
		loginPage=new LoginPage(driver);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(priority=2)
	public void user_opens_url() 
	{
		//url="https://admin-demo.nopcommerce.com/login";
		loginPage=new LoginPage(driver);
	    driver.get("https://admin-demo.nopcommerce.com/login");
	}

	@Test(priority=3)
	public void user_enters_email_as_and_password_as(String userName, String password) throws InterruptedException
	{
		//userName="admin@yourstore.com";
		//password="admin";
		loginPage=new LoginPage(driver);
		loginPage.enterEmail(userName);
		Thread.sleep(3000);
		loginPage.enterEmail(password);
	}

	@Test(priority=4)
	public void click_on_login_button() 
	{
		loginPage=new LoginPage(driver);
		//loginPage.clickOnLoginButton();
	}

	@Test(priority=5)
	public void page_title_should_be(String expectedTitle)
	{
		homePage=new HomePage(driver);
	   String actualTitle=driver.getTitle();
	   Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority=6)
	public void user_clicks_on_logout_button() 
	{
		homePage=new HomePage(driver);
		homePage.clickOnLogoutButton();
	}

	@Test(priority=7)
	public void close_browser() 
	{
	   homePage=new HomePage(driver);
	   driver.close();
	}
}
