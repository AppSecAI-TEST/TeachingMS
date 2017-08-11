package com.soft.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <p>ClassName:     TimeTools
 * <p>Description:   时间处理小工具
 * <p>Version        V1.0
 */
public class TimeTools {

    /**
     * 清除日历的小时，分钟，秒和毫秒字段.
     * 注意本函数返回的实例和入参传入的是同一个
     *
     * @param c 待处理的日历
     * @return 处理后的日历 calendar
     */
    public static Calendar clearCalendarHMS(Calendar c) {
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return c;
    }

    /**
     * 清除日历的小时，分钟，秒和毫秒字段.
     * 注意本函数返回的实例和入参传入的是同一个
     *
     * @param d 待处理的日期
     * @return 处理后的日期 date
     */
    public static Date clearCalendarHMS(Date d) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        d = c.getTime();
        return d;
    }

    /**
     * 客户端时间格式转化为秒。
     *
     * @param clientTime 客户端时间
     * @return 秒 long
     */
    public static Long clientTime2Seconds(BigDecimal clientTime) {
        Integer days = (clientTime.intValue() / 1000000);
        Integer hours = ((clientTime.intValue() % 1000000) / 1000);
        Integer minutes = (clientTime.intValue() % 1000);

        return (long)days * 24 * 60 * 60 + hours * 60 * 60 + minutes * 60;
    }

    /**
     * 取当天最后时刻
     * 注意本函数返回的实例和入参传入的是同一个
     *
     * @param date 待处理的日期
     * @return 处理后的日期 date
     */
    public static Date paddingCalendarHMS(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 59);
        date = c.getTime();
        return date;
    }

    /**
     * 取当天最后时刻
     * 注意本函数返回的实例和入参传入的是同一个
     *
     * @param strDate 待处理的日期
     * @return 处理后的日期 day end time hms
     */
    public static Date getDayEndTimeHMS(String strDate) {
        //日期格式处理
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dEndDate = null;
            try {
                dEndDate = sdf.parse(strDate + " 23:59:59");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        return dEndDate;
    }

    /**
     * 取当天最初时刻
     * 注意本函数返回的实例和入参传入的是同一个
     *
     * @param strDate 待处理的日期
     * @return 处理后的日期 day initial time hms
     */
    public static Date getDayInitialTimeHMS(String strDate) {
        //日期格式处理
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dStartDate = null;
        try {
            dStartDate = sdf.parse(strDate + " 00:00:00");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dStartDate;
    }

    /**
     * 取当前日期后一天时间
     *
     * @param date 待处理的日期
     * @return 处理后的日期 next day
     */
    public static Date getNextDay(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);//把日期往后增加一天.整数往后推,负数往前移动
        return calendar.getTime();//这个时间就是日期往后推一天的结果
    }

    /**
     * 日期String类型转Date类型
     *
     * @param date 待处理的日期
     * @return 处理后的日期 string to date
     * @throws ParseException the parse exception
     */
    public static Date getStringToDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(date);
    }

    /**
     * 日期Date类型转String类型
     *
     * @param date 待处理的日期
     * @return 处理后的日期 date to string
     */
    public static String getDateToString(Object date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

}
