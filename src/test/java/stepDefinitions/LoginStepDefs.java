package stepDefinitions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginStepDefs extends BaseClass
{
	@Before
	public void setup1() 
	{
		log=LogManager.getLogger(this.getClass());
		
	}
	
	@After
	public void takeScreenShot(Scenario sc) 
	{
		if(sc.isFailed()==true) 
		{
			final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(screenshot, "image/png", sc.getName());
		}
	}
	
	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() 
	{
		log.info("Lanching chrome browser");
		loginPage=new LoginPage(driver);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("user opens URL {string}")
	public void user_opens_url(String url) 
	{
		log.info("Lanching url");
		//loginPage=new LoginPage(driver);
	    driver.get(url);
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String userName, String password) throws InterruptedException
	{
		loginPage=new LoginPage(driver);
		loginPage.enterEmail(userName);
		Thread.sleep(3000);
		loginPage.enterPassword(password);
	}

	@When("click on login button")
	public void click_on_login_button() 
	{
		//loginPage=new LoginPage(driver);
		loginPage.clickOnLoginButton();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle)
	{
		homePage=new HomePage(driver);
	   String actualTitle=driver.getTitle();
	   Assert.assertEquals(actualTitle, expectedTitle);
	}

	@When("user clicks on logout button")
	public void user_clicks_on_logout_button() 
	{
		homePage=new HomePage(driver);
		homePage.clickOnMenu();
		homePage.clickOnLogoutButton();
	}

	@Then("close browser")
	public void close_browser() 
	{
	   homePage=new HomePage(driver);
	   driver.close();
	}
}
