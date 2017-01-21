package org.smart4j.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @author xianming
 *
 */
public final class PropsUtil {
	private static Logger logger = LoggerFactory.getLogger(PropsUtil.class);
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public static Properties loadProperties(String fileName) {
		Properties props = null;
		InputStream is = null;
		
		try{
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);			
			if (null == is){
				throw new FileNotFoundException(fileName);
			}
			props = new Properties();
			props.load(is);
			
		} catch(IOException e){
			logger.error("Can't load properties " + fileName);
		}
		return props;
	}
	/**
	 * 
	 * @param props
	 * @param key
	 * @return
	 */
	public static String getString(Properties props,String key){
		return getString(props,key,"");
	}
	public static String getString(Properties props,String key,String defaultValue){
		String value = defaultValue;
		if (props.containsKey(key)){
			value = props.getProperty(key);
		}
		return value;
	}
	
	public static int getInt(Properties props,String key){
		return getInt(props,key,0);
	}
	
	public  static int getInt(Properties props,String key,int DefaultValue){
		int value = DefaultValue;
		if (props.containsKey(key)){
			value = CastUtil.castInt(props.getProperty(key));
		}
		return value;
	}
	public static boolean getBoolean(Properties props,String key){
		return getBoolean(props,key,false);
	}
	public static boolean getBoolean(Properties props,String key, Boolean defaultValue){
		Boolean value = defaultValue;
		if (props.containsKey(key)){
			value = CastUtil.castBoolean(props.getProperty(key));
		}
		return value;
	}
}
