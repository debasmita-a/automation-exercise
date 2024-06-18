package basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import driverfactory.DriverFactory;
import driverfactory.PropertiesReader;
import testclasses.SignupLoginPage;

public class BaseTest {

	WebDriver driver;
	Properties prop;
	PropertiesReader reader;
	DriverFactory df;
	public SignupLoginPage loginPage;
	
	@BeforeTest
	public void setup() {
		reader = new PropertiesReader();
		prop = reader.init_prop();
		df = new DriverFactory();
		driver = df.init_driver(prop);
	}
	
	@AfterTest
	public void teardown() {
		//driver.quit();
	}
}
