package org.smart4j.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.jdbc.StringUtils;

public final class CastUtil {
	private static final Logger logger = LoggerFactory.getLogger(CastUtil.class);

	public static String castString(Object obj) {
		return castString(obj, "");
	}

	public static String castString(Object obj, String defaultValue) {
		return obj == null ? String.valueOf(obj) : defaultValue;
	}

	public static boolean castBoolean(Object obj) {
		return castBoolean(obj, false);
	}

	public static boolean castBoolean(Object obj, boolean defaultValue) {
		boolean value = defaultValue;
		if (null != obj) {
			value = Boolean.parseBoolean(castString(obj));
		}
		return value;
	}

	public static int castInt(Object obj) {
		return castInt(obj, 0);
	}

	public static int castInt(Object obj, int defaultValue) {
		int value = defaultValue;
		if (null != obj) {
			String strValue = castString(obj);
			if (StringUtil.isNotEmpty(strValue)) {
				try {
					value = Integer.parseInt(strValue);
				} catch (NumberFormatException e) {
					logger.error("Can't cast string to integer");
				}
			}
		}
		return value;
	}

	public static long castLong(Object obj) {
		return castLong(obj, 0L);
	}

	public static long castLong(Object obj, Long defaultValue) {
		long value = defaultValue;
		if (obj != null) {
			String strValue = castString(obj);
			if (StringUtil.isNotEmpty(strValue)) {
				try {
					value = Long.parseLong(strValue);
				} catch (NumberFormatException e) {
					logger.error("can't parse into long");
				}
			}
		}
		return value;
	}
	public static Double castDouble(Object obj){
		return castDouble(obj,0.00);
	}
	public static Double castDouble(Object obj,Double defaultValue){
		Double value = defaultValue;
		if (null != obj){
			String strValue = castString(obj);
			if (StringUtil.isNotEmpty(strValue)){
				try{
					value = Double.parseDouble(strValue);
				}catch(NumberFormatException e){
					logger.error("Can't format the data to double");
				}
			}
		}
		return value;
	}
}
