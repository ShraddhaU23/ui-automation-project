package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {
	
	public static String readProperty(Env env, String propertyName) {
		FileReader fileReader;
		Properties properties = new Properties();;
		File configFile = new File(System.getProperty("user.dir") + "\\config\\" + env + ".properties");
		try {
			fileReader = new FileReader(configFile);
			properties.load(fileReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = properties.getProperty(propertyName.toUpperCase());
		System.out.println(value);
		return value;
	}
}
