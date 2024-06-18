package driverfactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	
	Properties prop;
	
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream input = new FileInputStream("./src/test/resources/configs/config.properties");
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
