package driverfactory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	Properties prop;
	
	ChromeOptions co;
	EdgeOptions eo;
	FirefoxOptions fo;
	
	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) co.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) co.addArguments("--incognito");
		
		if(Boolean.parseBoolean(prop.getProperty("remote"))) {
			co.setCapability("browsername", "chrome");
		}
		return co;
	}
	
	public EdgeOptions getEdgeOptions() {
		eo = new EdgeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) eo.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) eo.addArguments("--incognito");
		
		if(Boolean.parseBoolean(prop.getProperty("remote"))) {
			co.setCapability("browsername", "edge");
		}
		return eo;
	}
	
	public FirefoxOptions getFirefoxDriver() {
		fo = new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("remote"))) {
			co.setCapability("browsername", "firefox");
		}
		return fo;
	}

}
