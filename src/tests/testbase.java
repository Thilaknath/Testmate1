package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class testbase {

	// Reading the property files.
	public static Properties CONFIG = null;
	public static Properties OR = null;
	public static WebDriver dr = null;
	public static EventFiringWebDriver driver = null;
	public static boolean isloggedin = false;

	public void initialize() throws IOException {
		if (driver == null) {
			// Initializing Configuration File
			CONFIG = new Properties();
			FileInputStream fn = new FileInputStream(
					System.getProperty("user.dir")
							+ "//src//config//config.properties");
			CONFIG.load(fn);
			// Initializing OR File
			OR = new Properties();
			fn = new FileInputStream(System.getProperty("user.dir")
					+ "//src//config//OR.properties");
			OR.load(fn);
			// Initialize the webdriver
			if (CONFIG.getProperty("browser").equals("Firefox")) {
				dr = new FirefoxDriver();
			} else if (CONFIG.getProperty("browser").equals("Firefox")) {
				dr = new ChromeDriver();
			}
			
			//loading the Xcel file
			
			driver = new EventFiringWebDriver(dr);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	public static WebElement getObject(String xpathKey){
		try {
		return driver.findElement(By.xpath(OR.getProperty(xpathKey)));
	}catch(Throwable T){
		//Report Error
	}
		return null;
}
}
