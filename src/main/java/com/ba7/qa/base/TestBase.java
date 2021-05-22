package com.ba7.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ba7.qa.util.TestUtil;
import com.ba7.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver; // declaring global variables
	public static Properties prop;
	public static EventFiringWebDriver event_driver;
	public static WebEventListener eventListener;

	public TestBase() { // constructor of class
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/ba7" + "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("Edge")) {
			System.setProperty("webdriver.msedge.driver", "C:\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		// Now create object of EventfiringWebDriver(driver)
		event_driver = new EventFiringWebDriver(driver);
		
		// Now register obj of WebEventListener and register with EventfiringWebDriver
		eventListener = new WebEventListener();
		event_driver.register(eventListener);
		driver=event_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}
}
