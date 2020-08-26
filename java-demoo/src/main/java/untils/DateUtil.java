package untils;


import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/** 对按指定格式对日期进行转换 */
public class DateUtil {
  /** 默认的日期格式 */
  public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

  public static final String DEFAULT_DATE_FORMAT_CN = "yyyy.MM.dd";
  public static final String FMT_DATE_YYYYMMDD_HHMMSS_STR = "yyyy-MM-dd HH:mm:ss";
  public static final String FMT_DATE_YYYYMMDD_HHMMSSSSS_STR = "yyyy-MM-dd HH:mm:ss SSS"; // TODO
  public static final String FMT_DATE_YMD_CHN = "yyyy年MM月dd日";
  public static final int FMT_DATE_YYYY = 0;
  public static final int FMT_DATE_YYYYMMDD = 1;
  public static final int FMT_DATE_YYYYMMDD_HHMMSS = 2;
  public static final int FMT_DATE_HHMMSS = 3;
  public static final int FMT_DATE_HHMM = 4;
  public static final int FMT_DATE_SPECIAL = 5;
  public static final int FMT_DATE_MMDD = 6;
  public static final int FMT_DATE_YYYYMMDDHHMM = 7;
  public static final int FMT_DATE_MMDD_HHMM = 8;
  public static final int FMT_DATE_MMMDDD = 9;
  public static final int FMT_DATE_YYYYMMDDHHMM_NEW = 10;
  public static final int FMT_DATE_YYYY年MM月DD日 = 11;
  public static final int FMT_DATE_YYYYMMDDHHMMSS = 12;
  public static final int FMT_DATE_YYMMDD = 13;
  public static final int FMT_DATE_YYMMDDHH = 14;
  public static final int FMT_DATE_YYYYMMDDHHMMSSSSS = 15;
  public static final String FMT_DATE_YMDHMS_CHN = "yyyy年MM月dd日HH时mm分ss秒";
  public static SimpleDateFormat SDF_YYYY_MM_DD = new SimpleDateFormat("yyyy年MM月dd日");

  /**
   * 按自定义日期格式格式化日期
   *
   * @return 格式化后的日期字符串，如果传入的日期对象为NULL，返回空字符串
   */
  public static String formatDate(Date target, String format) {
    if (target == null) {
      return "";
    }
    return new SimpleDateFormat(format).format(target);
  }

  /**
   * 按默认日期格式 格式化日期
   *
   * @return 格式化后的日期字符串，如果传入的日期对象为NULL，返回空字符串
   */
  public static String formatDate(Date target) {
    return formatDate(target, DEFAULT_DATE_FORMAT);
  }

  /** 格式化日期 */
  public static String formatDate(Date date, int nFmt) {
    SimpleDateFormat fmtDate = new SimpleDateFormat();
    switch (nFmt) {
      default:
      case FMT_DATE_YYYY:
        fmtDate.applyLocalizedPattern("yyyy");
        break;
      case FMT_DATE_YYYYMMDD:
        fmtDate.applyPattern("yyyy-MM-dd");
        break;
      case FMT_DATE_YYYYMMDD_HHMMSS:
        fmtDate.applyPattern("yyyy-MM-dd HH:mm:ss");
        break;
      case FMT_DATE_HHMM:
        fmtDate.applyPattern("HH:mm");
        break;
      case FMT_DATE_HHMMSS:
        fmtDate.applyPattern("HH:mm:ss");
        break;
      case FMT_DATE_SPECIAL:
        fmtDate.applyPattern("yyyyMMdd");
        break;
      case FMT_DATE_MMDD:
        fmtDate.applyPattern("MM-dd");
        break;
      case FMT_DATE_YYYYMMDDHHMM:
        fmtDate.applyPattern("yyyy-MM-dd HH:mm");
        break;
      case FMT_DATE_MMDD_HHMM:
        fmtDate.applyPattern("MM-dd HH:mm");
        break;
      case FMT_DATE_MMMDDD:
        fmtDate.applyPattern("MM月dd日");
        break;
      case DateUtil.FMT_DATE_YYYYMMDDHHMM_NEW:
        fmtDate.applyPattern("yyyyMMddHHmm");
        break;
      case DateUtil.FMT_DATE_YYYY年MM月DD日:
        fmtDate.applyPattern("yyyy年MM月dd日");
        break;
      case DateUtil.FMT_DATE_YYYYMMDDHHMMSS:
        fmtDate.applyPattern("yyyyMMddHHmmss");
        break;
      case FMT_DATE_YYMMDD:
        fmtDate.applyPattern("yyMMdd");
        break;
      case FMT_DATE_YYMMDDHH:
        fmtDate.applyPattern("yyyyMMddHH");
        break;
      case DateUtil.FMT_DATE_YYYYMMDDHHMMSSSSS:
        fmtDate.applyPattern("yyyyMMddHHmmssSSS");
        break;
    }
    return fmtDate.format(date);
  }

  /**
   * 将字符串格式化为日期对象
   *
   * @return 如果date为空或格式不标准，返回NULL，否则返回对应的日期对象
   */
  public static Date formatToDate(String date, String format) {
    try {
      if (StringUtils.isBlank(date)) {
        return null;
      }

      SimpleDateFormat sorceFmt = new SimpleDateFormat(format);
      return new Date(sorceFmt.parse(date).getTime());
    } catch (ParseException e) {
      return null;
    }
  }

  /** 将字符串格式化为日期对象 */
  public static Timestamp formatToTimestamp(String dateStr, String format) {
    try {
      SimpleDateFormat sorceFmt = new SimpleDateFormat(format);
      return new Timestamp(sorceFmt.parse(dateStr).getTime()); // 一天的时间24*3600*1000
    } catch (ParseException e) {
      return null;
    }
  }

  /**
   * 将Timestamp对象格式化
   *
   * @return 格式化后的日期字符串，如果传入的Timestamp对象为NULL，返回空字符串
   */
  public static String formatTimestamp(Timestamp time, String format) {
    if (time == null) {
      return "";
    }
    return new SimpleDateFormat(format).format(time);
  }

  public static Date getYesterDay() {
    return dateAddDays(new Date(), -1);
  }

  public static Date getFirstTimeInDay(Date dateTime) {
    String simpleString = formatDate(dateTime, "yyyyMMdd");
    return formatToDate(simpleString, "yyyyMMdd");
  }

  public static Date dateAddHours(Date date, int addHours) {
    Date newDate = null;
    try {
      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      cal.add(Calendar.HOUR, addHours);
      newDate = cal.getTime();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    return newDate;
  }

  /**
   * 通过时间秒毫秒数判断两个时间的间隔
   *
   * @param startTime
   * @param endTime
   * @return
   */
  public static int differentDaysByMillisecond(Date startTime, Date endTime) {
    int days =
        (int)
            ((getFirstTimeInDay(endTime).getTime() - getFirstTimeInDay(startTime).getTime())
                / (1000 * 3600 * 24));
    return days;
  }

  public static Date dateAddDays(Date date, int addDays) {
    Date newDate = null;
    try {
      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      cal.add(Calendar.DATE, addDays);
      newDate = cal.getTime();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    return newDate;
  }

  public static Date dateAddMinutes(Date date, int addMinutes) {
    Date newDate = null;
    try {
      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      cal.add(Calendar.MINUTE, addMinutes);
      newDate = cal.getTime();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    return newDate;
  }

  public static Date dateAddDays(String date, String format, int addDays) {
    Date d = formatToDate(date, format);
    return dateAddDays(d, addDays);
  }

  public static String dateAddDays2String(
      String date, String sourceFormat, String destFormat, int addDays) {
    Date d = dateAddDays(date, sourceFormat, addDays);
    return DateUtil.formatDate(d, destFormat);
  }

  public static Timestamp getCurrentTimestamp() {
    return new Timestamp(System.currentTimeMillis());
  }

  /** 获得形如1Y2M3D字符串代表的时间间隔，天数 如果输入只是一个整数则代表天数 */
  public static long getDays(String intervalString) {
    if (StringUtils.isBlank(intervalString)) {
      return -1;
    }
    if (!Pattern.compile(
            "^(\\d+(Y|y)?)?(\\d+(M|m)?)?(\\d+(D|d)?)$|^(\\d+(Y|y)?)?(\\d+(M|m)?)$|^(\\d+(Y|y)?)$")
        .matcher(intervalString)
        .find()) {
      return -1;
    }
    int yearInterval = 0;
    int monthInterval = 0;
    int dayInterval = 0;
    String[] intervals = intervalString.split("[YyMmDd]");
    if (intervalString.toUpperCase().contains("Y")) {
      yearInterval = Integer.valueOf(intervals[0]);
      if (intervalString.toUpperCase().contains("M")) {
        monthInterval = Integer.valueOf(intervals[1]);
        if (intervalString.toUpperCase().contains("D")) {
          dayInterval = Integer.valueOf(intervals[2]);
        }
      } else if (intervalString.toUpperCase().contains("D")) {
        dayInterval = Integer.valueOf(intervals[1]);
      }

    } else if (intervalString.toUpperCase().contains("M")) {
      monthInterval = Integer.valueOf(intervals[0]);
      if (intervalString.toUpperCase().contains("D")) {
        dayInterval = Integer.valueOf(intervals[1]);
      }
    } else {
      dayInterval = Integer.valueOf(intervals[0]);
    }
    Date now = getCurrentTimestamp();
    Date to = dateAddYears(now, yearInterval);
    to = DateUtil.dateAddType(to, monthInterval, Calendar.MONTH);
    to = DateUtil.dateAddDays(to, dayInterval);

    return DateUtil.getDaysInterval(now, to);
  }

  /** 获得当前时间的n毫秒前和n毫秒后 */
  public static Date getIntervalDateMillseconds(Date origin, long intervals) {
    return new Date(origin.getTime() + intervals);
  }

  /** 获得当前时间的n天前或后 */
  public static Date getIntervalDate(Date origin, long intervals) {
    return new Date(origin.getTime() + intervals * 86400000);
  }

  /**
   * 求日期间隔
   *
   * @return 间隔天数
   */
  public static Long getDaysInterval(String startDate, String endDate, String format) {
    String f = null;
    if (format == null) {
      f = DEFAULT_DATE_FORMAT;
    } else {
      f = format;
    }
    Date start = null;
    Date end = null;
    start = formatToDate(startDate, f);
    end = formatToDate(endDate, f);
    return getDaysInterval(start, end);
  }

  public static Long getDaysInterval(Date startDate, Date endDate) {
    if (startDate == null && endDate == null) {
      return null;
    }
    long begin = startDate.getTime();
    long end = endDate.getTime();
    long inter = end - begin;
    if (inter < 0) {
      inter = inter * (-1);
    }
    long dateMillSec = 24 * 60 * 60 * 1000;
    long dateCnt = inter / dateMillSec;
    long remainder = inter % dateMillSec;
    if (remainder != 0) {
      dateCnt++;
    }
    return dateCnt;
  }

  /**
   * 求保单持有天数（计算规则，保单出单第二天零时保单生效，第二天过完算一天）
   *
   * @return 持有天数
   */
  public static Long getHoldOrderDays(Date currDate, Date orderDate) {

    if (currDate == null) {
      currDate = new Date();
    }
    Calendar cal = Calendar.getInstance(); // 获取当前日期
    cal.setTime(orderDate);
    cal.add(Calendar.DAY_OF_MONTH, 1); // 出单时间加1天为保单生效时间
    String endStr =
        DateUtil.formatTimestamp(new Timestamp(cal.getTimeInMillis()), DEFAULT_DATE_FORMAT);

    Date end = formatToDate(endStr, DEFAULT_DATE_FORMAT);
    return getDaysInterval(currDate, end) - 1;
  }

  public static int getAge(Date birth) {
    Calendar c = Calendar.getInstance();
    int thisYear = c.get(Calendar.YEAR);
    int birthYear = birth.getYear() + 1900;
    int thisMonth = c.get(Calendar.MONTH);
    int birthMonth = birth.getMonth();
    int thisDate = c.get(Calendar.DATE);
    int birthDate = birth.getDate();
    if (thisMonth < birthMonth) // 今年还没过生日
    {
      return thisYear - birthYear - 1;
    } else if (thisMonth > birthMonth) {
      return thisYear - birthYear;
    } else if (thisDate < birthDate) // 在生日月份没到具体日子
    {
      return thisYear - birthYear - 1;
    } else {
      return thisYear - birthYear;
    }
  }

  /**
   * 计算年龄
   *
   * @param birth 出生日期，yyyy-MM-dd格式
   */
  public static int getAge(String birth) {
    Date birthday = DateUtil.formatToDate(birth, "yyyyMMdd");
    return getAge(birthday);
  }

  /** 计算到指定日期时的年龄 */
  public static int getAgeOfFixedDay(String birth, String fixedDay) {

    Date birthDay = DateUtil.formatToDate(birth, "yyyy-MM-dd");
    int birthYear = birthDay.getYear() + 1900;
    int birthMonth = birthDay.getMonth();
    int birthDate = birthDay.getDate();

    Date theDay = DateUtil.formatToDate(fixedDay, "yyyy-MM-dd");
    int thisYear = theDay.getYear() + 1900;
    int thisMonth = theDay.getMonth();
    int thisDate = theDay.getDate();

    if (thisMonth < birthMonth) // 今年还没过生日
    {
      return thisYear - birthYear - 1;
    } else if (thisMonth > birthMonth) {
      return thisYear - birthYear;
    } else if (thisDate < birthDate) // 在生日月份没到具体日子
    {
      return thisYear - birthYear - 1;
    } else {
      return thisYear - birthYear;
    }
  }

  /** 取得下一个生日（只限yyyy-MM-dd） */
  public static String getNextBirth(String birth) {
    Date now = new Date();
    String today = DateUtil.formatDate(now);
    String thisMMDD = today.substring(5);
    String birthMMDD = birth.substring(5);
    String result = "";
    if (thisMMDD.compareTo(birthMMDD) < 0) // 生日未到
    {
      result = Integer.parseInt(today.substring(0, 4)) + "-" + birthMMDD;
    } else {
      result = Integer.parseInt(today.substring(0, 4)) + 1 + "-" + birthMMDD;
    }
    if (result.endsWith("02-29")) {
      result = result.substring(0, 5) + "03-01";
    }
    return result;
  }

  public static String dateAddType(
      String date, String sourceFormat, String destFormat, int addDates, int addType) {
    Date d = dateAddType(date, sourceFormat, addDates, addType);
    if (d == null) return null;
    return DateUtil.formatDate(d, destFormat);
  }

  public static Date dateAddType(String date, String format, int addDates, int addType) {
    Date d = formatToDate(date, format);
    if (d == null) {
      return null;
    }
    return dateAddType(d, addDates, addType);
  }

  public static Date dateAddType(Date date, int addNums, int addType) {
    Date newDate = null;
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(addType, addNums);
    newDate = cal.getTime();
    return newDate;
  }

  public static Date dateAddMonths(Date date, int addMonths) {
    Date newDate = null;
    try {
      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      cal.add(Calendar.MONTH, addMonths);
      newDate = cal.getTime();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    return newDate;
  }

  public static Date dateAddYears(Date date, int addYears) {
    Date newDate = null;
    try {
      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      cal.add(Calendar.YEAR, addYears);
      newDate = cal.getTime();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    return newDate;
  }

  public static Date dateAddYears(String date, String format, int addYears) {
    Date d = formatToDate(date, format);
    if (d == null) return null;
    return dateAddYears(d, addYears);
  }

  public static String dateAddYears(
      String date, String sourceFormat, String destFormat, int addYears) {
    Date d = dateAddYears(date, sourceFormat, addYears);
    if (d == null) return null;
    return DateUtil.formatDate(d, destFormat);
  }

  public static long getSecLengthTwoTimestamp(Timestamp t1, Timestamp t2) {
    long l = t1.getTime() - t2.getTime();
    if (l < 0) {
      l = -l;
    }
    return l / 1000;
  }

  /** 获得指定时间间隔的timestamp */
  public static Timestamp getIntervalTimestamp(Timestamp ts, int minutes) {
    return new Timestamp(ts.getTime() + minutes * 60 * 1000);
  }

  public static Timestamp getmsIntervalTimestamp(Timestamp ts, long msec) {
    return new Timestamp(ts.getTime() + msec);
  }

  public static Timestamp getIntervalTimestamp(Timestamp ts, long minutes) {
    return new Timestamp(ts.getTime() + minutes * 60 * 1000);
  }

  public static Timestamp getBeforeTimestamp(Timestamp ts, long minutes) {
    return new Timestamp(ts.getTime() - minutes * 60 * 1000);
  }

  public static Timestamp getDaysIntervalTimestamp(Timestamp ts, int days) {
    return new Timestamp(ts.getTime() + days * 24 * 60 * 60 * 1000L);
  }

  public static Timestamp getTimestamp(Date date) {
    if (date == null) return null;
    else return new Timestamp(date.getTime());
  }

  /** 返回指定的时间戳是否在当天 */
  public static boolean isInToday(Timestamp ts) {
    String s = formatTimestamp(ts, DEFAULT_DATE_FORMAT);
    String today = formatTimestamp(getCurrentTimestamp(), DEFAULT_DATE_FORMAT);
    return s.equals(today);
  }

  /** 传入需要计算的时间，得到截止时间的剩下天数和小时数 */
  public static String getLeftDayNumberFromNowToOneDay(Timestamp t) {
    if (t == null) {
      return ":";
    }
    long tmp = t.getTime() - System.currentTimeMillis();
    long day = tmp / (1000 * 60 * 60 * 24);
    long hour = (tmp / (1000 * 60 * 60)) % 24;
    return day + ":" + hour;
  }

  /**
   * 求保单自然持有天数（计算规则，保单出单第二天零时保单生效，第二天过完算一天）
   *
   * <p>例如，假定客户是1月17日购买，1月18日零点生效，2月17日24点满1个完整的自然月，2月18日就算是1个月零1天了，以此类推，4月18日就是3个月零1天，也就是这一天就可以领取/退保了。
   * 遇到2月规则不变，比如1月29日购买 ，2月28日满1个完整的自然月，3月1日期算1个月零1天
   *
   * @return 持有天数
   */
  public static String getNativeHoldOrderDays(Date currDate, Date orderDate) {
    Calendar orderCal = Calendar.getInstance(); // 获取当前日期
    orderCal.setTime(orderDate);
    orderCal.add(Calendar.DAY_OF_MONTH, 1); // 出单时间加1天为保单生效时间
    String endStr =
        DateUtil.formatTimestamp(new Timestamp(orderCal.getTimeInMillis()), DEFAULT_DATE_FORMAT);
    Date end = formatToDate(endStr, DEFAULT_DATE_FORMAT);
    orderCal.setTime(end);

    String nowDate = DateUtil.formatTimestamp(DateUtil.getCurrentTimestamp(), DEFAULT_DATE_FORMAT);
    Date now = formatToDate(nowDate, DEFAULT_DATE_FORMAT);
    if (orderCal.getTime().compareTo(now) >= 0) {
      return "0天";
    }

    Calendar currCal = Calendar.getInstance();
    currCal.setTime(currDate);
    // 处理掉时分秒取整
    String startDate =
        DateUtil.formatTimestamp(new Timestamp(currCal.getTimeInMillis()), DEFAULT_DATE_FORMAT);
    Date start = formatToDate(startDate, DEFAULT_DATE_FORMAT);
    currCal.setTime(start);
    int[] times = getNeturalAge(orderCal, currCal);
    if (times[0] == 0) {
      if (times[1] == 0) {
        return times[2] + "天";
      } else {
        if (times[2] == 0) {
          return times[1] + "月";
        } else {
          return times[1] + "月" + times[2] + "天";
        }
      }
    } else {
      if (times[1] == 0) {
        return times[0] + "年" + times[2] + "天";
      } else {
        if (times[2] == 0) {
          return times[0] + "年" + times[1] + "月";
        } else {
          return times[0] + "年" + times[1] + "月" + times[2] + "天";
        }
      }
    }
  }

  public static int[] getNeturalAge(Calendar calendarBirth, Calendar calendarNow) {
    int diffYears = 0, diffMonths, diffDays;
    int dayOfBirth = calendarBirth.get(Calendar.DAY_OF_MONTH);
    int dayOfNow = calendarNow.get(Calendar.DAY_OF_MONTH);
    if (dayOfBirth <= dayOfNow) {
      diffMonths = getMonthsOfAge(calendarBirth, calendarNow);
      diffDays = dayOfNow - dayOfBirth;
      // if (diffMonths == 0)
      // diffDays++;
    } else {
      if (isEndOfMonth(calendarBirth)) // 开始日期为月底
      {
        if (isEndOfMonth(calendarNow)) // 结束日志为月底
        {
          diffMonths = getMonthsOfAge(calendarBirth, calendarNow);
          diffDays = 0;
        } else {
          calendarNow.add(Calendar.MONTH, -1);
          diffMonths = getMonthsOfAge(calendarBirth, calendarNow);
          diffDays = dayOfNow + 1;
        }
      } else {
        if (isEndOfMonth(calendarNow)) {
          diffMonths = getMonthsOfAge(calendarBirth, calendarNow);
          diffDays = 0;
        } else {
          calendarNow.add(Calendar.MONTH, -1); // 上个月
          diffMonths = getMonthsOfAge(calendarBirth, calendarNow);
          // 获取上个月最大的一天
          int maxDayOfLastMonth = calendarNow.getActualMaximum(Calendar.DAY_OF_MONTH);
          if (maxDayOfLastMonth > dayOfBirth) {
            diffDays = maxDayOfLastMonth - dayOfBirth + dayOfNow;
          } else {
            diffDays = dayOfNow;
          }
        }
      }
    }
    // 计算月份时，没有考虑年
    diffYears = diffMonths / 12;
    diffMonths = diffMonths % 12;
    return new int[] {diffYears, diffMonths, diffDays};
  }

  /** 获取两个日历的月份之差 */
  public static int getMonthsOfAge(Calendar calendarBirth, Calendar calendarNow) {
    return (calendarNow.get(Calendar.YEAR) - calendarBirth.get(Calendar.YEAR)) * 12
        + calendarNow.get(Calendar.MONTH)
        - calendarBirth.get(Calendar.MONTH);
  }

  /** 判断这一天是否是月底 */
  public static boolean isEndOfMonth(Calendar calendar) {
    int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
    if (dayOfMonth == calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) return true;
    return false;
  }

  /**
   * 保单自然持有天数转换为非自然数字天数，1月按30天、1年按365天计算
   *
   * <p>例如，假定客户是1月17日购买，1月18日零点生效，2月17日24点满1个完整的自然月，2月18日就算是1个月零1天了，以此类推，4月18日就是3个月零1天，也就是这一天就可以领取/退保了。
   * 遇到2月规则不变，比如1月29日购买 ，2月28日满1个完整的自然月，3月1日期算1个月零1天
   *
   * @return 持有天数
   */
  public static Integer getConverHoldOrderDays(Date currDate, Date orderDate) {

    if (currDate == null) {
      currDate = new Date();
    }
    Calendar orderCal = Calendar.getInstance(); // 获取当前日期
    orderCal.setTime(orderDate);
    orderCal.add(Calendar.DAY_OF_MONTH, 1); // 出单时间加1天为保单生效时间
    String endStr =
        DateUtil.formatTimestamp(new Timestamp(orderCal.getTimeInMillis()), DEFAULT_DATE_FORMAT);
    Date end = formatToDate(endStr, DEFAULT_DATE_FORMAT);
    orderCal.setTime(end);

    String nowDate = DateUtil.formatTimestamp(DateUtil.getCurrentTimestamp(), DEFAULT_DATE_FORMAT);
    Date now = formatToDate(nowDate, DEFAULT_DATE_FORMAT);
    if (orderCal.getTime().compareTo(now) >= 0) {
      return 0;
    }

    Calendar currCal = Calendar.getInstance();
    currCal.setTime(currDate);
    // 处理掉时分秒取整
    String startDate =
        DateUtil.formatTimestamp(new Timestamp(currCal.getTimeInMillis()), DEFAULT_DATE_FORMAT);
    Date start = formatToDate(startDate, DEFAULT_DATE_FORMAT);
    currCal.setTime(start);
    int[] times = getNeturalAge(orderCal, currCal);
    if (times[0] == 0) {
      if (times[1] == 0) {
        return times[2];
      } else {
        if (times[2] == 0) {
          return times[1] * 30;
        } else {
          return times[1] * 30 + times[2];
        }
      }
    } else {
      if (times[1] == 0) {
        return times[0] * 365 + times[2];
      } else {
        if (times[2] == 0) {
          return times[0] * 365 + times[1] * 30;
        } else {
          return times[0] * 365 + times[1] * 30 + times[2];
        }
      }
    }
  }

  public static String getLcHoldOrderDays(int prctId, Date currDate, Date orderDate) {
    if (prctId == 5401 || prctId == 5403) {
      return getNativeHoldOrderDays(currDate, orderDate);
    } else if (prctId == 5402 || prctId == 5404 || prctId == 5105 || prctId == 5102) {
      return getHoldOrderDays(currDate, orderDate) + "天";
    }
    return "";
  }

  public static String getLcHoldOrderDays(int prctId, Date orderDate) {
    Date currDate = new Date();
    if (prctId == 5401 || prctId == 5403) {
      return getNativeHoldOrderDays(currDate, orderDate);
    } else if (prctId == 5402 || prctId == 5404 || prctId == 5405 || prctId == 5102) {
      return getHoldOrderDays(currDate, orderDate) + "天";
    }
    return "";
  }

  public static Timestamp addDays(Timestamp timestamp, int days) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(timestamp.getTime());
    calendar.add(Calendar.DAY_OF_YEAR, days);
    return new Timestamp(calendar.getTimeInMillis());
  }

  public static Timestamp addMinutes(Timestamp timestamp, int minutes) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(timestamp.getTime());
    calendar.add(Calendar.MINUTE, minutes);
    return new Timestamp(calendar.getTimeInMillis());
  }

  public static Timestamp addSeconds(Timestamp timestamp, int seconds) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(timestamp.getTime());
    calendar.add(Calendar.SECOND, seconds);
    return new Timestamp(calendar.getTimeInMillis());
  }

  /** 当天的结束时间 */
  public static Long endOfTodDay() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 59);
    calendar.set(Calendar.MILLISECOND, 999);
    Date date = calendar.getTime();
    return date.getTime();
  }

  public static void main(String[] args) {
    /* System.out.println(getNextBirth("1984-04-20")); */
    /*
     * Calendar cal = Calendar.getInstance();// 获取当前日期
     * cal.setTime(DateUtil.formatToDate("2013-11-26", DateUtil.DEFAULT_DATE_FORMAT)); Calendar cal1
     * = Calendar.getInstance();// 获取当前日期 cal1.setTime(DateUtil.formatToDate("2013-11-28",
     * DateUtil.DEFAULT_DATE_FORMAT));
     *
     * System.out.println(DateUtil.getNativeHoldOrderDays(cal1.getTime(), cal.getTime())); Integer
     * rewardScore = null; System.out.println(String.valueOf(rewardScore));
     * System.out.println(dateAddDays(DateUtil.formatTimestamp(DateUtil.getCurrentTimestamp(),
     * DateUtil.FMT_DATE_YYYYMMDD_HHMMSS_STR), DateUtil.FMT_DATE_YYYYMMDD_HHMMSS_STR, 1));
     * System.out.println(dateAddYears("2011-09-06 00:00:00", DateUtil.FMT_DATE_YYYYMMDD_HHMMSS_STR,
     * DateUtil.FMT_DATE_YYYYMMDD_HHMMSS_STR, 10));
     *
     * System.out.println(getBeforeTimestamp(new Timestamp(System.currentTimeMillis()), 60));
     */
    System.out.println(formatTimestamp(new Timestamp(System.currentTimeMillis()), "MM月dd日HH点"));

    Date date = new Date();
      String unlockTimeStr = DateUtil.formatDate(date, 12);
    System.out.println(unlockTimeStr);
      String substring = unlockTimeStr.substring(0, 8);
    System.out.println(substring);
  }
}
