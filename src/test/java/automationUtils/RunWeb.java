package automationUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RunWeb {
	private String frameworkDirectory = System.getProperty("user.dir");
	protected WebDriver driver;
	
	public RunWeb(String webBrowser) {
		initializeWebDriver(webBrowser);
	}
	
	public void initializeWebDriver(String webBrowser) {
		webBrowser = webBrowser.toLowerCase();
		switch (webBrowser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", frameworkDirectory + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "edge":
			System.out.println(frameworkDirectory + "\\browserDrivers\\msedgedriver.exe");
			driver = new FirefoxDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", frameworkDirectory + "\\browserDrivers\\geckodriver.exe");
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("improper settings for WebBrowser, using default webbrowser (Chrome)");
			System.setProperty("webdriver.chrome.driver", frameworkDirectory + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
	}
	
	public static void main(String[] args) {
		RunWeb r = new RunWeb("chrome");
		r.initializeWebDriver("chrome");
	}
}
