package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@src='https://classic.freecrm.com/img/logo.png']")
	WebElement CRM_Logo;
	
	@FindBy(xpath="//a[normalize-space()='Sign Up']")
	WebElement signup;
	
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean signup() {
		return signup.isDisplayed();
	}
	
	public boolean CRMLogo() {
		return CRM_Logo.isDisplayed();
		
	}
	
	public HomePage login(String un,String pw) {
		
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		
		return new HomePage();
	}


}
