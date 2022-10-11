package com.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
    HomePage homePage;
    Logger log=Logger.getLogger(LoginPageTest.class);
	public LoginPageTest() {
		super();
		System.out.println("Super class constructor in the Test base class is called");
	}

	@BeforeMethod()
	public void setup() {
		initialization();
		loginpage = new LoginPage();

	}

	@Test(priority=1)
	public void ValidateTitleOfLoginPage() {
		log.info("**************Validating Login page title:***************** ");
		
		String title=loginpage.getTitle();
		Assert.assertEquals(title,"Free CRM - CRM software for customer relationship management, sales, and support.");

	}
	
	@Test(priority=2)
	public void ValidateLogo() {
		log.info("**************Validating logo of login page:***************** ");
	boolean result=	loginpage.CRMLogo();
    Assert.assertEquals(result, true);		
	}
	
	@Test(priority=3)
	public void ValidateSignuplink() {
		log.info("**************Validating prence of Signup link***************** ");
		boolean result1=loginpage.signup();
		Assert.assertTrue(result1);
	}
	@Test(priority=4)
	public void LoginCheck() {
		log.info("**************entering username and password***************** ");
		homePage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}

	@AfterMethod()
	public void tearDown() {
		log.info("**************Closing browser***************** ");
		driver.quit();
	}
}
