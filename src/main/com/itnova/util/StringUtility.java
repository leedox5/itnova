package com.itnova.util;

import java.util.Arrays;
import java.util.List;

public class StringUtility {

	public static boolean isContains(String inputString, String[] items) {
		List<String> itemList = Arrays.asList(items);
		
		return itemList.contains(inputString);
	}

	public static boolean isContainStr(String source, String[] items) {
		for(String item : items) {
			if(source.contains(item)) {
				return true;
			}
		}
		return false;
	}

	public static String hintList(String source, String[] hints) {
		String ret = "";
		if(source.equals("")) {
			ret = "No suggestion!";
		} else {
			for(String hint : hints) {
				if(hint.toLowerCase().startsWith(source.toLowerCase())) {
					ret += ret.equals("") ? hint :  "," + hint;
				}
			}
		}
		return ret.equals("") ? "No suggestion!" : ret;
	}
}
