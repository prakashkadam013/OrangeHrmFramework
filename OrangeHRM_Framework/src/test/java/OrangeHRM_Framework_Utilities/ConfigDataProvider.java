package OrangeHRM_Framework_Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	public static Properties prop;

	public ConfigDataProvider(String configPath) {
		
		try {
			FileInputStream fins = new FileInputStream(configPath);
			prop = new Properties();
			prop.load(fins);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getBrowser() {
		prop.getProperty("Browser");
	}
	
	
	public String getAppUrl() {
		 return prop.getProperty("Appurl");
	}
	
	public String getUsername() {
		return prop.getProperty("Username");
	}
	
	public String getPassword() {
		return prop.getProperty("Password");
	}
	
	
	
	
	
}
