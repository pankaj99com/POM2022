package com.qa.testcases;

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
		String title=loginpage.getTitle();
		Assert.assertEquals(title,"Free CRM - CRM software for customer relationship management, sales, and support.");

	}
	
	@Test(priority=2)
	public void ValidateLogo() {
	boolean result=	loginpage.CRMLogo();
    Assert.assertEquals(result, true);		
	}
	
	@Test(priority=3)
	public void ValidateSignuplink() {
		boolean result1=loginpage.signup();
		Assert.assertTrue(result1);
	}
	@Test(priority=4)
	public void LoginCheck() {
		homePage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
}
