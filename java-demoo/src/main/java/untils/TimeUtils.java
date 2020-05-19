package untils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间格式化/处理工具类
 * <p>
 * Title: TimeUtils
 * </p>
 * <p>
 * Description:
 * </p>
 *
 * @author Tianyu Xiao
 * @date 2019年3月20日
 */
public class TimeUtils {
    /**
     * 转换格式1：通用转换格式：yyyy-MM-dd HH:mm:ss
     */
    public static final String CURRENT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 转换格式2：年-月-日
     */
    public static final String YYYYMMDD_PATTERN = "yyyy-MM-dd";

    /**
     * 星期几
     */
    private static final String weekNames[] = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

    /**
     * 获取 获取格式转换器(带格式)
     * <p>
     * Description:
     * </p>
     *
     * @author Tianyu Xiao
     * @date 2019年3月20日下午7:03:04
     */
    private static SimpleDateFormat getSimpleDateFormat(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    /**
     * 获取 获取格式转换器(不带格式)
     * <p>
     * Description:
     * </p>
     *
     * @author Tianyu Xiao
     * @date 2019年3月20日下午11:16:45
     */
    private static SimpleDateFormat getSimpleDateFormat() {
        return new SimpleDateFormat();
    }

    /**
     * 根据时间类型转为字符串类型
     * <p>
     * Description:
     * </p>
     *
     * @author Tianyu Xiao
     * @date 2019年3月20日下午7:03:33
     */
    public static String dateFormatWithPattern(Date date, String pattern) {
        return getSimpleDateFormat(pattern).format(date);
    }

    /**
     * 根据字符串转化为日期类型
     * <p>
     * Description:
     * </p>
     *
     * @author Tianyu Xiao
     * @date 2019年3月20日下午11:17:32
     */
    public static Date dateFormatWithPattern(String date) throws ParseException {
        return getSimpleDateFormat(CURRENT_PATTERN).parse(date);
    }

    /**
     * 根据格式将字符串转换为日期类型
     * <p>
     * Description:
     * </p>
     *
     * @author Tianyu Xiao
     * @date 2019年3月22日下午10:41:13
     */
    public static Date dateFormatWithPatternWithPattern(String date, String pattern) throws ParseException {
        return getSimpleDateFormat(pattern).parse(date);
    }

    /**
     * 获取前n天日期的字符串
     * <p>
     * Description:
     * </p>
     *
     * @author Tianyu Xiao
     * @date 2019年3月20日下午9:24:59
     */
    public static String getBeforeDayString(Date date, int day, String pattern) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -day);
        date = calendar.getTime();
        String dateString = getSimpleDateFormat(pattern).format(date);
        return dateString;
    }

    /**
     * 获取后n天日期的字符串
     * <p>
     * Description:
     * </p>
     *
     * @author Tianyu Xiao
     * @date 2019年3月27日下午1:01:47
     */
    public static String getNextDayString(Date date, int day, String pattern) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        date = calendar.getTime();
        String dateString = getSimpleDateFormat(pattern).format(date);
        return dateString;
    }

    /**
     * 获取当前时间的前N小时
     * <p>
     * Description:
     * </p>
     *
     * @author Tianyu Xiao
     * @date 2019年3月20日下午11:13:20
     */
    public static String getBeforeHourDay(Date date, int hour, String pattern) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, -hour);
        date = calendar.getTime();
        String dateString = getSimpleDateFormat(pattern).format(date);
        return dateString;
    }

    /**
     * 获取当前时间的后N小时
     * <p>
     * Description:
     * </p>
     *
     * @author Tianyu Xiao
     * @date 2019年3月20日下午11:14:48
     */
    public static String getNextHourDay(Date date, int hour, String pattern) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hour);
        date = calendar.getTime();
        String dateString = getSimpleDateFormat(pattern).format(date);
        return dateString;
    }

    /**
     * 获取当前时间的前n个月
     * <p>
     * Description:
     * </p>
     *
     * @author Tianyu Xiao
     * @date 2019年3月21日下午12:37:55
     */
    public static String getBeforeMonthDay(Date date, int n, String pattern) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -n);
        date = calendar.getTime();
        String dateString = getSimpleDateFormat(pattern).format(date);
        return dateString;
    }

    /**
     * 获取一个月的最后一天
     * <p>
     * Description:
     * </p>
     *
     * @author Tianyu Xiao
     * @date 2019年3月21日下午1:23:06
     */
    public static String getLastDayOfMonth(Date date, String pattern) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        String lastDay = getSimpleDateFormat(pattern).format(calendar.getTime());
        return lastDay;
    }

    /**
     * 获取一个月的第一天
     * <p>
     * Description:
     * </p>
     *
     * @author Tianyu Xiao
     * @date 2019年3月21日下午1:23:06
     */
    public static String getFirstDayOfMonth(Date date, String pattern) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        String lastDay = getSimpleDateFormat(pattern).format(calendar.getTime());
        return lastDay;
    }

    /**
     * 获取这一天是周几
     * <p>
     * Description:
     * </p>
     *
     * @author Tianyu Xiao
     * @date 2019年3月22日下午10:18:07
     */
    public static String getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek < 0)
            dayOfWeek = 0;
        return weekNames[dayOfWeek];
    }

    /**
     * 判断两个日期相差得天数
     * day1:前面得天数
     * day2:后面得天数
     * <p>Description: </p>
     *
     * @author Tianyu Xiao
     * @date 2019年3月29日下午1:26:04
     */
    public static long getTwoDayDifference(String day1, String day2) throws ParseException {
        Date oDate = dateFormatWithPatternWithPattern(day1, YYYYMMDD_PATTERN);
        Date fDate = dateFormatWithPatternWithPattern(day2, YYYYMMDD_PATTERN);
        long days = (fDate.getTime() - oDate.getTime()) / (1000 * 3600 * 24);
        return days;
    }


    public static void main(String[] args) throws ParseException {
        //String res = stringDateFormat("2019-10-14-14:43:04", "yyyy-MM-dd-HH:mm:ss", "yyyy-MM-dd HH:mm:ss");
        Date date = dateFormatWithPattern("2019-12-31 14:43:04");
        System.out.println(isLastDayOfMonth(date));
    }

    /**
     * 将旧时间格式转换新时间格式
     * <p>Description: </p>
     *
     * @author Tianyu Xiao
     * @date 2019年10月21日下午2:51:09
     */
    public static String stringDateFormat(String date, String oldPattern, String newPattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = getSimpleDateFormat(oldPattern);
        Date dateTime = simpleDateFormat.parse(date);
        simpleDateFormat = getSimpleDateFormat(newPattern);
        return simpleDateFormat.format(dateTime);
    }

    /**
     * 判断该日期是否是该月的第一天
     * <p>Description: </p>
     *
     * @author Tianyu Xiao
     * @date 2019年12月2日下午8:37:19
     */
    public static boolean isFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.MONTH));
        return calendar.get(Calendar.DAY_OF_MONTH) == 1;
    }

    /**
     * 判断该日期是否是该月的最后一天
     * <p>Description: </p>
     *
     * @author Tianyu Xiao
     * @date 2019年12月2日下午8:36:58
     */
    public static boolean isLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH) == calendar
                .getActualMaximum(Calendar.DAY_OF_MONTH);
    }

}
