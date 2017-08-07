package com.kebodev.property;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyHandler {

	
	public static String getPropertyByName(String propertyName) {
	Properties prop = new Properties();
	InputStream input = null;
	
	try {
		input = new FileInputStream("batorFrontProp.properties");
		prop.load(input);
		return prop.getProperty(propertyName);

	} catch (IOException ex) {
		ex.printStackTrace();
		
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	return null;
	}
}
