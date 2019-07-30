package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	Properties prop; 
	
	public ConfigReader() throws Exception {
		String filepath = System.getProperty("user.dir") + "/Configurations/config.properties";
		
		File src = new File(filepath);
		
		FileInputStream fis = new FileInputStream(src);
		
		prop = new Properties();
		
		prop.load(fis);
		
	}
	
	public String readBaseUrl() {
		return prop.getProperty("baseUrl");
	}
	
	public String readApi() {
		return prop.getProperty("apiReq");
	}
	
	public String getBaseInsta() {
		return prop.getProperty("baseUrlInsta");
	}
	
	public String getLoginInsta() {
		return prop.getProperty("loginAPI");
	}
}
