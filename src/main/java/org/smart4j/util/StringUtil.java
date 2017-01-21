package org.smart4j.util;

import org.apache.maven.shared.utils.StringUtils;

public final class StringUtil {
	public static boolean isNotEmpty(String str){
		return !StringUtils.isEmpty(str);
	}
	public static boolean isEmpty(String str){
		if (str != null){
			str =str.trim();
		}
		return StringUtils.isEmpty(str);
	}
}
