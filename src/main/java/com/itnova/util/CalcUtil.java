package com.itnova.util;

public class CalcUtil {

	public static double getCompleteRate(int complete, int target, int exclude) {
		double c = complete;
		double t = target;
		double e = exclude;
		return Double.parseDouble(String.format("%.1f", c / (t - e) * 100));
	}

	public static String getCompleteRateStr(int c, int t, int e) {
		return Double.toString(getCompleteRate(c,t,e));
	}
	
}
