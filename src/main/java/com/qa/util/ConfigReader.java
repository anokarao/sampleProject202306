package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private Properties prop;

	public Properties readConfig() {
		try {
			FileInputStream fis=new FileInputStream("./src/test/resources/config/config.properties");
			prop=new Properties();
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
