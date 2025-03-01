package utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * @author luchao
 * @date 2022/10/14
 */
public class DateUtils {

    private final static String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static long getCurrentTimeMillis(){
        return System.currentTimeMillis();
    }

    /**
     * 获取月份的第一时间
     */
    public static Long getFirstTimeOfMonth(Long dateTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(dateTime));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime();
    }

    /**
     * 获取月份的最后时间
     */
    public static Long getLastTimeOfMonth(Long dateTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(dateTime));
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime() - 1;
    }

    /**
     * 获取月份的开始时间
     *
     * @param time  月份中的某一个时间戳
     * @param index 月份的前几个月或者后几个月
     * @return
     */
    public static Date getMonthFirstTime(Long time, int index) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        // 默认为本月
        c.add(Calendar.MONTH, index);
        c.set(Calendar.DAY_OF_MONTH, 1);
        //设置为1号,当前日期既为该月第一天

        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    /**
     * 获取月份的最后时间
     *
     * @param time  月份中的某一个时间戳
     * @param index 月份的前几个月或者后几个月
     * @return
     */
    public static Date getMonthLastTime(Long time, int index) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        c.add(Calendar.MONTH, index);

        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        c.set(Calendar.HOUR_OF_DAY, 24);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.MILLISECOND, 0);

        c.setTimeInMillis(c.getTimeInMillis() - 1);
        return c.getTime();
    }

    /**
     * 获取当天的第一时刻
     * */
    public static long getBeginTimeOfDay(long time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(time));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime().getTime();
    }

    /**
     * 获取当天的最后时刻
     * */
    public static long getLastTimeOfDay(long time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(time));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime().getTime();
    }

    /**
     * 将日期字符串转换为毫秒时间戳
     */
    public static String getFormatTime(Long time) {
        if(Objects.isNull(time)){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
        return sdf.format(new Date(time));
    }

    /**
     * 获取昨天的最后时刻
     * */
    public static long getYesterdayLastTime(long millSecond){
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(millSecond);
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.MILLISECOND, 0);
        return instance.getTimeInMillis() - 1;
    }

    /**
     * 获取当前小时
     * */
    public static int getHour(){
        Calendar instance = Calendar.getInstance();
        return instance.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 将日期字符串转换为毫秒时间戳
     */
    public static long getFormatTime(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
        try {
            return sdf.parse(dateStr).getTime();
        }catch (ParseException e){
            throw new RuntimeException(e);
        }
    }


}
