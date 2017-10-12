package com.daqsoft.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {

    public static final SimpleDateFormat TIME_SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat DATE_CUR_FORMAT = new SimpleDateFormat("yyyy年MM月dd日");
    public static final SimpleDateFormat MONTH_SDF = new SimpleDateFormat("yyyy-MM");
    public static final SimpleDateFormat MONTH = new SimpleDateFormat("MM");
    public static final SimpleDateFormat MONTH_CUR_SDF = new SimpleDateFormat("yyyy年MM月");
    public static final SimpleDateFormat YEAR_SDF = new SimpleDateFormat("yyyy");
    public static final SimpleDateFormat YEAR_CUR_SDF = new SimpleDateFormat("yyyy年");
    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    /**
     * 获取当前日期
     *
     * @return
     */
    public static String getCurDateStr() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
    /**
     * 获取当前时间
     *
     * @return yyyy-MM-dd
     */
    public static String getCurDateTimeStr() {
        Date date = new Date();
        return TIME_SDF.format(date);
    }

    /**
     * 获取当前日期
     * @return yyyy年MM月dd日
     */
    public static String getCurDateStrFormat() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return DATE_CUR_FORMAT.format(date);
    }

    /**
     * 获取当前月份
     * @return yyyy-MM
     */
    public static String getCurMonthStr() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        return sdf.format(date);
    }

    /**
     * 返回当前月份数字
     * @return MM
     */
    public static String getCurMonthNumStr() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        return sdf.format(date);
    }

    /**
     * 获取对应月份
     * @param date 日期
     * @return
     */
    public static String getCurMonthStr(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat sdfdd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date nowdate = sdfdd.parse(date);
            return sdf.format(nowdate);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取当前月份
     * @return yyyy年MM月
     */
    public static String getCurMonthStrFormat() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
        return MONTH_CUR_SDF.format(date);
    }

    /**
     * 获取当前年份
     * @return yyyy
     */
    public static String getCurYearStr() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return YEAR_SDF.format(date);
    }

    /**
     * 获取当前年份
     * @return yyyy年
     */
    public static String getCurYearFormat() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年");
        return YEAR_CUR_SDF.format(date);
    }

    /**
     * 获取当前时间（小时）
     * @return yyyy-MM-dd HH
     */
    public static String getCurHourStr() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        return sdf.format(date);
    }

    /**
     * 获取当前小时数
     * @return HH
     */
    public static String getCurSimpleHourStr() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        return sdf.format(date);
    }

    /**
     * 判断是否是指定格式时间字符串
     *
     * @param dateStr 时间字符串
     * @param format  格式
     * @return flag
     */
    public static boolean isDateStr(String dateStr, String format) {
        boolean flag = false;
        if (dateStr == null || format == null) {
            return flag;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            sdf.parse(dateStr);
            flag = true;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return flag;
    }
    /**
     * 时间字符串转化为时间
     *
     * @param dateStr 时间字符串
     * @param format  对应时间格式
     * @return date
     */
    public static Date strToDate(String dateStr, String format) {
        Date date = null;
        SimpleDateFormat sdf1 = new SimpleDateFormat(format);
        try {
            date = sdf1.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    /**
     * 获取年中月份的列表
     *  01  02  03 ...
     * @return
     */
    public static List<String> getMonthList(){
        List<String> monthList = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            if (i > 9) {
                monthList.add(i+"");
            } else {
                monthList.add("0" + i);
            }
        }
        return monthList;
    }

    /**
     * 获取两个年份之间年份列表（包含开始和结束）
     * @param start 开始年份字符串 格式 yyyy
     * @param end 结束年份字符串 格式 yyyy
     * @return
     */
    public static List<String> getYearList(String start, String end){
        List<String> years = new ArrayList<>();
        try {
            Integer startYear = Integer.valueOf(start);
            Integer endYear = Integer.valueOf(end);
            for(Integer i = startYear; i <= endYear; i++){
                years.add(i+"");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return years;
    }
    /**
     * 通过当前时间获取当前是第几季度
     * @return 第N季度
     */
    public static String getCurrentQuarter()
    {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        String quarter = "";
        if (currentMonth >= 1 && currentMonth <= 3)
            quarter = "一";
        else if (currentMonth >= 4 && currentMonth <= 6)
            quarter = "二";
        else if (currentMonth >= 7 && currentMonth <= 9)
            quarter = "三";
        else if (currentMonth >= 10 && currentMonth <= 12)
            quarter = "四";
        String res = "第" + quarter + "季度";
        return res;
    }

    /**
     * 通过当前时间获取当前是第几季度 返回int类型
     *
     * @return 1、2、3、4
     */
    public static String getNumberCurrentQuarter() {
        Calendar c = Calendar.getInstance();
        int currentMonth = c.get(Calendar.MONTH) + 1;
        String quarter = "";
        if (currentMonth >= 1 && currentMonth <= 3)
            quarter = "1";
        else if (currentMonth >= 4 && currentMonth <= 6)
            quarter = "2";
        else if (currentMonth >= 7 && currentMonth <= 9)
            quarter = "3";
        else if (currentMonth >= 10 && currentMonth <= 12)
            quarter = "4";

        return quarter;
    }
    /**
     * 获取传入年份对应的每个季度的月份值
     *
     * @return
     */
    public static List<Map> getQuarterMonthByYear(String year) {
        List<Map> resList = new ArrayList<>();
        Integer[] quarters = {1,2,3,4};
        String[] months = {"01","02","03","04","05","06","07","08","09","10","11","12"};
        for (Integer quarter : quarters){
            Map<Object, Object> quarterMap = new HashMap<>();
            List<String> monthList = new ArrayList<>();
            for(int i = 0; i <=2; i++){
                monthList.add(months[i+(quarter*3-3)]);
            }
            quarterMap.put("quarter", quarter);
            quarterMap.put("months", monthList);
            resList.add(quarterMap);
        }
        return resList;
    }
    /**
     * 当前日期减去相应天数，得到的日期
     * @param days
     * @return
     * @throws ParseException
     */
    public static String getHistDate(int days) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.DATE, date.get(Calendar.DATE) - days);
        Date endDate = sdf.parse(sdf.format(date.getTime()));
        return sdf.format(endDate);
    }
    /**
     *当前日期减去相应月数，得到的月份
     * @param month
     * @return
     * @throws ParseException
     */
    public static String getHistMonth(int month) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date beginDate = new Date();
        Calendar date = Calendar.getInstance();
        date.setTime(beginDate);
        date.set(Calendar.MONTH, date.get(Calendar.MONTH) - month);
        Date endDate = sdf.parse(sdf.format(date.getTime()));
        return sdf.format(endDate);
    }

    /**
     * 格式化时间
     * @param date 日期
     * @param pattern 格式
     * @return
     */
    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }
}
