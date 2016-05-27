package com.song.util;
/**
 * 标签格式检测
 * @author Administrator
 *
 */
public class LabelValidate {
	public static boolean validate(String flag,String id){
		if(flag.equals(id.substring(0,1))) return true;
		else return false;
	}
}
