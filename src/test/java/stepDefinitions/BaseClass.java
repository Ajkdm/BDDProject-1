package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class BaseClass
{
	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public static Logger log;
}
