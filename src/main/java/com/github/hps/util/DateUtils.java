/**
 * Copyright &copy; 2012-2013 github.site All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.github.hps.util;

import com.google.common.collect.Lists;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * @author ThinkGem
 * @version 2013-3-15
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	
	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", 
		"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm","yyyyMMdd" };

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}


	/**
	 * 得到当前时间字符串 格式（yyyy-MM-dd）
	 * @param date
	 * @return
	 */
	public static String getDate(Date date){
		return  formatDate(date, "yyyy-MM-dd");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}
	
	/**
	 * 日期型字符串转化为日期 格式
	 * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", 
	 *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null){
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(24*60*60*1000);
	}
	
    
	public static Date getDateStart(Date date) {
		if(date==null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date= sdf.parse(formatDate(date, "yyyy-MM-dd")+" 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static Date getDateEnd(Date date) {
		if(date==null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date= sdf.parse(formatDate(date, "yyyy-MM-dd") +" 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
    /**
     * 将date日期按照某种类型+上某个值 比如  cal.add(Calendar.date,1)
     * @param date
     * @param type
     * @param num
     * @return
     */
    public static Date addDateByType(Date date, int type, int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(type, num);
        return cal.getTime();
    }



	/**
	 * 根据传入的日期 返回开始年和截止年
	 * @param date
	 * @param start 负数 如-5
	 * @param end 正数 如5
	 * @return
	 */
	public static List<String> getStartEndYear(Date date,Integer start,Integer end){
		List<String> list= Lists.newArrayList();
		for (int i=start;i<0;i++){
			list.add(DateUtils.formatDate(DateUtils.addDateByType(date, Calendar.YEAR ,i),"yyyy"));
		}
		list.add(DateUtils.formatDate(date,"yyyy"));
		for (int i=1;i<end+1;i++){
			list.add(DateUtils.formatDate(DateUtils.addDateByType(date, Calendar.YEAR ,i),"yyyy"));
		}
		return list;
	}

    /**
     * 获得一年中十二个月份
     * @return
     */
    public static List<Integer> getOneYearOfMonth(){
        List<Integer> monthList = Lists.newArrayList();
        for(int i=1;i<13;i++){
            monthList.add(i);
        }
        return monthList;
    }


	/**
	 * 获取传入时间的上月的第一天
	 * @param date
	 * @return
	 */
	public static Date getUpStartDay(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();//获得上月的第一天

	}

	/**
	 * 获取传入时间的月的最后一天
	 * @return
	 */
	public static Date getLastDay(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		return calendar.getTime();//获取本月最后一天
	}

	/**
	 * 获取传入时间的下一年
	 * @param date
	 * @return
	 */
	public static Date getNextYear(Date date){
		Calendar calendar =Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, 1);
		calendar.set(Calendar.DAY_OF_YEAR,1);
		return calendar.getTime();//获得下一年的第一天
	}
	
	/**
	 * 获得传入时间年的第一天
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfYear(Date date){
		Calendar calendar =Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, 0);
		calendar.set(Calendar.DAY_OF_YEAR,1);
		return calendar.getTime();//获得传入时间年的第一天
	}
	
	/**
	 * 获得传入时间年的最后一天
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfYear(Date date){
		Calendar calendar =Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, 1);
		calendar.set(Calendar.DAY_OF_YEAR,0);
		return calendar.getTime();//获得传入时间年的最后一天
	}

	
	/**
     * 获得本月的开始时间
     * @return
     */
    public  static Date getCurrentMonthStartTime(Integer year,Integer month) {
        SimpleDateFormat shortSdf= new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.YEAR,year);
            c.set(Calendar.MONTH,month-3);
            c.set(Calendar.DATE, 1);
            now = shortSdf.parse(shortSdf.format(c.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }
    
    /**
     * 当前月的结束时间
     * @return
     */
    public static  Date getCurrentMonthEndTime(Integer year,Integer month) {
        SimpleDateFormat shortSdf= new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat longSdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.YEAR,year);
            c.set(Calendar.MONTH,month-1);
            c.set(Calendar.DATE, 1);
            c.add(Calendar.MONTH, 1);
            c.add(Calendar.DATE, -1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }
	
    
    public static Date getLastDayOfMonth(Integer year, Integer month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DATE));
		return  cal.getTime();
	}
	public static Date getFirstDayOfMonth(Integer year, Integer month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH,cal.getMinimum(Calendar.DATE));
		return  cal.getTime();
	}

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
//		System.out.println(formatDate(parseDate("2010/3/6")));
//		System.out.println(getDate("yyyy年MM月dd日 E"));
//		long time = new Date().getTime()-parseDate("2012-11-19").getTime();
//		System.out.println(time/(24*60*60*1000));
	}
}
