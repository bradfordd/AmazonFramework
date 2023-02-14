package automationUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class RunWeb {
	public String frameworkDirectory = System.getProperty("user.dir");
	public WebDriver driver;
	
//	@Before
//	public void beforeScenario() {
//	  tomcat.start();
//	  tomcat.deploy("munger");
//	}
	
	public void initializeWebDriver(String webBrowser) {
		webBrowser = webBrowser.toLowerCase();
		switch (webBrowser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", frameworkDirectory + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			break;
		case "edge":
			System.out.println(frameworkDirectory + "\\browserDrivers\\msedgedriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", frameworkDirectory + "\\browserDrivers\\geckodriver.exe");
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			break;
		default:
			System.out.println("improper settings for WebBrowser, using default webbrowser (Chrome)");
			System.setProperty("webdriver.chrome.driver", frameworkDirectory + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			break;
		}
	}
	
	
}
