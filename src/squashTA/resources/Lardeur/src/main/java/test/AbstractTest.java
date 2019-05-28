package test;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public abstract class AbstractTest {

	protected static WebDriver driver;
	

	public AbstractTest() {
		String browser ="${CPG_CUF_browser}";
		
		if(browser.equalsIgnoreCase("IE"))

			{
			 File file = new File("C:/DriverAutomatisation/IEDriverServer_Win32_3.14.0/IEDriverServer.exe");
		        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		        driver = new InternetExplorerDriver();
			}
		else if(browser.equalsIgnoreCase("Chrome"))
			{
			System.setProperty("webdriver.chrome.driver", "C:/chromedriver2_43/chromedriver.exe");
			driver = new ChromeDriver();
			}
		else if(browser.equalsIgnoreCase("Firefox"))
			{

	       String geckoDriverPath = "C:/geckoDriver/geckodriver-v0.24.0-win64/geckodriver.exe";
	       System.setProperty("webdriver.gecko.driver",geckoDriverPath);

	       driver = new FirefoxDriver();

			}
		
//		
//		
//		System.setProperty("webdriver.chrome.driver", "C:/chromedriver2_43/chromedriver.exe");
//		driver = new ChromeDriver();
//		
//		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.wowhead.com/");	
		
		
		
	}
	@After
	public void close() {
		driver.close();
	}
	
}
