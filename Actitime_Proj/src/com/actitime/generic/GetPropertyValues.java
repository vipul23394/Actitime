package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author vipul
 *
 */
public class GetPropertyValues {	
	/**
	 * @description This Method is use to read the value from config.properties file based on key.
	 * @param key
	 * @return
	 */
	public static String getPropertyValue(String key){
		String value="";
		try{
		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("C:\\Users\\Anand\\workspace\\Actitime_Proj\\cofig.properties")));
	    value = prop.getProperty(key);
		}
		catch(IOException e){
			e.printStackTrace();
		}  
	    return value;
	}

}
