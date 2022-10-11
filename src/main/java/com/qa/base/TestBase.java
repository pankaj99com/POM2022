package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop =new Properties();
	
	
	public TestBase() {
		/* Whenever this constructor is called then it will perform below actions for that classes from where it is called*/
		
		try {
			FileInputStream fis =new FileInputStream("C:\\Users\\pankaj.kumar\\workspace\\POM\\src\\main\\java\\com\\qa\\config\\config.properties");
			
			try {
				prop.load(fis);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
			
	}
	/* constructor block ends here*/
	
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\pankaj.kumar\\workspace\\POM\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\pankaj.kumar\\workspace\\POM\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		driver.get(prop.getProperty("url"));
		
		
	}
	

}
