package com.wmg.ddd.dotdy.util;

import java.text.DecimalFormat;

public class DataFormatUtil{
	
	public static DecimalFormat double_2digit = new DecimalFormat("######0.00");

	public static String generateBpIdByTargetId(String target_id, int no){
		return target_id+"b"+no;
	}

	public static String generateExtracostIdByTargetId(String target_id, int no){
		return target_id+"e"+no;
	}
}