package untils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @author CBeann
 * @create 2020-06-04 14:52
 */
public class LocalDateTimeUtils {
    //默认使用系统当前时区
    private static final ZoneId ZONE = ZoneId.systemDefault();


    /**
     * 转换格式1：通用转换格式：yyyy-MM-dd HH:mm:ss
     */
    public static final String YYYY_MM_DD_HH_MM_SS_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 转换格式2：年-月-日
     */
    public static final String YYYY_MMDD_PATTERN = "yyyy-MM-dd";


    //---------------->Local* fromat to String

    /**
     * @param format 获取的当前LocalDateTime并且格式化
     * @return
     */
    public static String NowLocalDateTimeByFormat(String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();
        return now.format(dateTimeFormatter);
    }

    /**
     * @param format 把LocalDateTime并且格式化
     * @return
     */
    public static String LocalDateTimeByFormat(LocalDateTime localDateTime, String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return localDateTime.format(dateTimeFormatter);
    }

    /**
     * @param format 把LocalDate并且格式化
     * @return
     */
    public static String LocalDateByFormat(LocalDate localDate, String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        return localDate.format(dateTimeFormatter);
    }


    //---------------->Date to Local*

    /**
     * 将Date转换成LocalDateTime
     *
     * @param d date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date d) {
        Instant instant = d.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZONE);
        return localDateTime;
    }


    /**
     * 将Date转换成LocalDate
     *
     * @param d date
     * @return
     */
    public static LocalDate dateToLocalDate(Date d) {
        Instant instant = d.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZONE);
        return localDateTime.toLocalDate();
    }

    /**
     * 将Date转换成LocalTime
     *
     * @param d date
     * @return
     */
    public static LocalTime dateToLocalTime(Date d) {
        Instant instant = d.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZONE);
        return localDateTime.toLocalTime();
    }


    //---------------->Local* to date

    /**
     * 将LocalDate转换成Date
     *
     * @param localDate
     * @return date
     */
    public static Date localDateToDate(LocalDate localDate) {
        Instant instant = localDate.atStartOfDay().atZone(ZONE).toInstant();
        return Date.from(instant);
    }

    /**
     * 将LocalDateTime转换成Date
     *
     * @param localDateTime
     * @return date
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        Instant instant = localDateTime.atZone(ZONE).toInstant();
        return Date.from(instant);
    }


    //---------------->string to Local*


    /**
     * 将相应格式yyyy-MM-dd的字符串转化为LocalDate
     *
     * @param time   string
     * @param format string
     * @return date
     */
    public static LocalDate stringToLocalDate(String time, String format) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern(format);
        if (YYYY_MMDD_PATTERN.equals(format)) {
            return LocalDate.parse(time, f);
        }
        return null;
    }

    /**
     * 将相应格式yyyy-MM-dd HH:mm:ss 的字符串转化为 LocalDateTime
     *
     * @param time   string
     * @param format string
     * @return date
     */
    public static LocalDateTime stringToLocalDateTime(String time, String format) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern(format);
        if (YYYY_MM_DD_HH_MM_SS_PATTERN.equals(format)) {
            return LocalDateTime.parse(time, f);
        }
        return null;
    }


    //---------------->getBefore LocalDateTime

    /**
     * before 参数小于0
     * after 大于0
     * =0 表示不大不小
     *
     * @param localDateTime
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param sencod
     * @return
     */
    public static LocalDateTime getBeforeOrAfterLocalDateTime(LocalDateTime localDateTime, int year, int month, int day, int hour, int minute, int sencod) {

        if (year != 0) {

            localDateTime = localDateTime.plusYears(year);


        }
        if (month != 0) {
            localDateTime = localDateTime.plusMonths(month);
        }
        if (day != 0) {
            localDateTime = localDateTime.plusDays(day);

        }
        if (hour != 0) {

            localDateTime = localDateTime.plusHours(hour);

        }
        if (minute != 0) {
            localDateTime = localDateTime.plusMinutes(minute);
        }
        if (sencod != 0) {
            localDateTime = localDateTime.plusSeconds(sencod);
        }

        return localDateTime;

    }


    /**
     * 获得LocalDateTime这个月的的第一天
     * @return
     */
    LocalDateTime getMonthFirstday(LocalDateTime localDateTime) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime date = localDateTime;
        LocalDateTime firstday = date.with(TemporalAdjusters.firstDayOfMonth());
        return firstday;
    }

    /**
     * 获得LocalDateTime这个月的最后一天
     * @return
     */
    LocalDateTime getMonthLastday(LocalDateTime localDateTime) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime date = localDateTime;
        LocalDateTime lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
        return lastDay;
    }

    /**
     * 获得Localdatetime的星期
     */
    public int  getWeekNum(LocalDateTime localDateTime){
        System.out.println("week is " + localDateTime.getDayOfWeek());
        System.out.println("week is " + localDateTime.getDayOfWeek().getValue());
        return localDateTime.getDayOfWeek().getValue();
    }


}
