package driverfactory;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

	WebDriver driver;
	Properties prop;
	OptionsManager options;

	/**
	 * This method will return a driver object based on the browser name provided.
	 * 
	 * @return driver
	 */
	public WebDriver init_driver(Properties prop) {
		this.prop = prop;
		String browserName = prop.getProperty("browser");
		options = new OptionsManager();

		switch (browserName) {
		case "chrome": {
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("chrome");
			} else {
				driver = new ChromeDriver();
			}
			break;
		}
		case "edge": {
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("edge");
			} else {
				driver = new EdgeDriver();
			}
			break;
		}
		case "firefox": {
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("firefox");
			} else {
				driver = new FirefoxDriver();
			}
			break;
		}
		default:
			System.out.println("Please enter a correct browser name.." + browserName);
		}

		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		return driver;
	}

	private void init_remoteDriver(String browserName) {
		browserName = prop.getProperty("browser");
		try {
			switch (browserName) {
			case "chrome": {
				driver = new RemoteWebDriver(new URI(prop.getProperty("hubrul")).toURL(), options.getChromeOptions());
				break;
			}
			case "edge": {
				driver = new RemoteWebDriver(new URI(prop.getProperty("hubrul")).toURL(), options.getEdgeOptions());
				break;
			}
			case "firefox": {
				driver = new RemoteWebDriver(new URI(prop.getProperty("hubrul")).toURL(), options.getFirefoxDriver());
				break;
			}
			default:
				System.out.println("Please provide correct browser name.." + browserName);
			}
		} catch (URISyntaxException | MalformedURLException e) {
			e.printStackTrace();
		}

	}

	public void getScreenshot() {

	}
}
