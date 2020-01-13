package com.hl.official.website.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.util.*;


public class DateUtil {
    //~ Static fields/initializers =============================================

	public static Log log = LogFactory.getLog(DateUtil.class);
	public static String ymdhPattern = "yyyyMMddHH";
	public static String datePattern = "yyyy-MM-dd";
	public static String timePattern = "HH:mm:ss";
	public static String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
	public static String dateTimeMinPattern = "yyyy-MM-dd HH:mm";
	public static String[] weekDays = {"周一","周二","周三","周四","周五","周六","周日"};

    //~ Methods ================================================================

    /**
     * Return default datePattern (yyyy-MM-dd)
     * @return a string representing the date pattern on the UI
     */
    public static String getDatePattern() {
        return datePattern;
    }

    /**
     * Return default dateTimePattern (yyyy-MM-dd HH:mm:ss)
     * @return a string representing the date pattern on the UI
     */
    public static String getDateTimePattern() {
        return dateTimePattern;
    }
    
    
    public static final String getDatePatternTime(Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate != null) {
            df = new SimpleDateFormat(dateTimePattern);
            returnValue = df.format(aDate);
        }
        return (returnValue);
    }
    
    /**
     * This method attempts to convert an Oracle-formatted date
     * in the form dd-MMM-yyyy to mm/dd/yyyy.
     *
     * @param aDate date from database as a string
     * @return formatted string for the ui
     */
    
    public static final String getDateSecondPatternTime(Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate != null) {
            df = new SimpleDateFormat(dateTimePattern);
            returnValue = df.format(aDate);
        }
        return (returnValue);
    }
    public static final String getDateMinPatternTime(Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate != null) {
            df = new SimpleDateFormat(dateTimeMinPattern);
            returnValue = df.format(aDate);
        }
        return (returnValue);
    }
    /**
     * 得到格式化的当前日期(yyyy-MM-dd HH:mm:ss)
     * @return
     */
    public static final String getPatternTime() {
        SimpleDateFormat df = new SimpleDateFormat(dateTimePattern);
            return df.format(new Date());
    }
    
    public static final String getDate(Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate != null) {
            df = new SimpleDateFormat(datePattern);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    

    /**
     * This method generates a string representation of a date/time
     * in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param strDate a string representation of a date
     * @return a converted Date object
     * @see SimpleDateFormat
     */
    public static final Date convertStringToDate(String aMask, String strDate)
   {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask);

        if (log.isDebugEnabled()) {
            log.debug("converting '" + strDate + "' to date with mask '"
                      + aMask + "'");
        }

        try {
            date = df.parse(strDate);
        } catch (Exception pe) {
            //log.error("ParseException: " + pe);
        }

        return (date);
    }
    public static final Date convertStringToDateTime(String aMask, String strDate) {
      SimpleDateFormat df = null;
      Date date = null;
      df = new SimpleDateFormat(aMask);

      if (log.isDebugEnabled()) {
          log.debug("converting '" + strDate + "' to date with mask '"
                    + aMask + "'");
      }

      try {
          date = df.parse(strDate);
      } catch (Exception pe) {
          //log.error("ParseException: " + pe);
      }

      return (date);
  }

    /**
     * This method returns the current date time in the format:
     * MM/dd/yyyy HH:MM a
     *
     * @param theTime the current time
     * @return the current date/time
     */
    public static String getTimeNow(Date theTime) {
        return getDateTime(timePattern, theTime);
    }

    /**
     * This method returns the current date in the format: MM/dd/yyyy
     * 
     * @return the current date
     * @throws ParseException
     */
    public static Calendar getToday()  {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat(datePattern);

        // This seems like quite a hack (date -> string -> date),
        // but it works ;-)
        String todayAsString = df.format(today);
        Calendar cal = new GregorianCalendar();
        cal.setTime(convertStringToDate(todayAsString));
        return cal;
    }
    
    /**
     * This method returns the current date in the format: MM/dd/yyyy
     * 
     * @return the input date
     * @throws ParseException
     */
    public static Calendar getCalendar(Date date) {
    	SimpleDateFormat df = new SimpleDateFormat(datePattern);

        // This seems like quite a hack (date -> string -> date),
        // but it works ;-)
        String todayAsString = df.format(date);
        Calendar cal = new GregorianCalendar();
        cal.setTime(convertStringToDate(todayAsString));
        return cal;
    }

    /**
     * This method generates a string representation of a date's date/time
     * in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param aDate a date object
     * @return a formatted string representation of the date
     * 
     * @see SimpleDateFormat
     */
    public static final String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
            log.error("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * This method generates a string representation of a date based
     * on the System Property 'dateFormat'
     * in the format you specify on input
     * 
     * @param aDate A date to convert
     * @return a string representation of the date
     */
    public static final String convertDateToString(Date aDate) {
        return getDateTime(datePattern, aDate);
    }

	/**
	 * 返回 yyyy-MM-dd HH:mm:ss
	 * @param aDate
	 * @return yyyy-MM-dd HH:mm:ss
	 */
    public static final String convertDateTimeToString(Date aDate) {
        return getDateTime(dateTimePattern, aDate);
    }

	/**
	 *
	 * @return  当前到秒的string 时间
	 */
	public static final String getCurrSecDateTimeToString() {
		return getDateTime(dateTimePattern, new Date());
	}

	public static final String convertDateToYMDHString(Date aDate) {
		return getDateTime(ymdhPattern, aDate);
	}
    public static final String convertSpecialDateTimeToString(String aMask, Date aDate)
    {
        return getDateTime(aMask, aDate);
  }

    /**
     * This method converts a String to a date using the datePattern
     * 
     * @param strDate the date to convert (in format MM/dd/yyyy)
     * @return a date object
     * 
     * @throws ParseException
     */
    public static Date convertStringToDate(String strDate)
       {
        Date aDate = null;

        try {
            if (log.isDebugEnabled()) {
                log.debug("converting date with pattern: " + datePattern);
            }

            aDate = convertStringToDate(datePattern, strDate);
        } catch (Exception pe) {
            log.error("Could not convert '" + strDate
                      + "' to a date, throwing exception");
            pe.printStackTrace();
        }

        return aDate;
    }
    public static Date convertStringToDateTime(String strDate) {
      Date aDate = null;

      try {
          if (log.isDebugEnabled()) {
              log.debug("converting date with pattern: " + datePattern);
          }

          aDate = convertStringToDate(dateTimePattern, strDate);
      } catch (Exception pe) {
          log.error("Could not convert '" + strDate
                    + "' to a date, throwing exception");
          pe.printStackTrace();
                  
      }

      return aDate;
  }
    public static final String simpleConvert(Date aDate){
        dateTimePattern ="yyyyMMddHHmmss";
        return getDateTime(dateTimePattern, aDate);
    }
    /**
	 * return the day far away day
	 * @param formart
	 * @param day
	 * @return
	 */
	public static String getDateSecondAwayToday(String currentDay, int day) throws Exception{
		Calendar cal = Calendar.getInstance();// today
		cal.setTime(convertStringToDate(currentDay));
		cal.add(Calendar.DATE, day); // move day
		return getDateTime(dateTimePattern, cal.getTime());
	}

	public static String getDateAwayToday(String currentDay, int day) throws Exception{
		Calendar cal = Calendar.getInstance();// today
		cal.setTime(convertStringToDate(currentDay));
		cal.add(Calendar.DATE, day); // move day
		return getDateTime(datePattern, cal.getTime());
	}
	public static String getDateAwayToday(Date currentDay, int day) throws Exception{
		Calendar cal = Calendar.getInstance();// today
		cal.setTime(currentDay);
		cal.add(Calendar.DATE, day); // move day
		return getDateTime(datePattern, cal.getTime());
	}
    /**
	 * return the month far away month
	 * @param formart
	 * @param month
	 * @return
	 */
	public static String getMonthAwayToday(String currentDay, int month) throws Exception{
		Calendar cal = Calendar.getInstance();// today
		cal.setTime(convertStringToDate(currentDay));
		cal.add(Calendar.MONDAY, month); // move month
		return getDateTime(datePattern, cal.getTime());
	}
	/**
	 * 返回一周的中文表示
	 * 调用方法：getWeekDays()
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String[] getWeekDays(){
		return weekDays;
	}
	
    
	/**
	 * 返回含当前日期的一周的日期
	 * 调用方法：getWeekDescriptArray(Date)
	 * 
	 * @param currentDay
	 * @return
	 * @throws Exception
	 */
	public static String[] getWeekDescriptArray(Date currentDay) throws Exception{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDay);
		int dayNumber = calendar.get(Calendar.DAY_OF_WEEK)-2;
		if(dayNumber==-1)
			dayNumber = 6;
		if(dayNumber != 0)
			calendar.add(Calendar.DATE, -dayNumber);
		String[] dayDescripts = new String[7];
		dayDescripts[0] = DateUtil.convertDateToString(calendar.getTime());
		for(int i=1; i < 7; i++)
		{
			calendar.add(Calendar.DATE, 1);
			dayDescripts[i] = DateUtil.convertDateToString(calendar.getTime());
		}
		return dayDescripts;
	}
    /**
     * 	返回指定格式的日期、时间值
     * 调用方法：getDateFormatStr("yyyyMMddhhmmssSSS");
     *
     * @param formart
     * @return
     */
	public static String getDateFormatStr(String formart) {
		return new SimpleDateFormat(formart).format(new Date());
	}

	/**
	 * 	返回yyyy-MM-dd HH:mm:ss格式当前格式值
	 * 调用方法：getDateFormatStr("yyyyMMddhhmmssSSS");
	 *
	 * @param
	 * @return
	 */
	public static String getCurrTimeYMM() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	
	/**
	 * 返回两时间间隔的分钟数，其中同一时间也算一分钟，比如"1984-11-25 11:22:30"到"1984-11-25 11:22:30"，就算1分钟
	 * @param startDate eg:1984-11-25 11:22:33
	 * @param stopDate  eg:2010-06-26 13:54:33
	 * @retur int 		eg:13455513
	 * @throws Exception
	 */
	public static int getMinuteBetweenDate(String startDate, String stopDate) throws Exception{
		if(startDate.compareTo(stopDate) > 0)
			throw new Exception("起始日期不能大于结束日期！");
		Calendar startCal = Calendar.getInstance();
		Calendar stopCal = Calendar.getInstance();
		if(startDate.length() > 19)
			startDate = startDate.substring(0, 19);
		if(stopDate.length() > 19)
			stopDate = stopDate.substring(0, 19);
		startCal.setTime(convertStringToDateTime(startDate));
		stopCal.setTime(convertStringToDateTime(stopDate));
		return (int)((stopCal.getTimeInMillis() - startCal.getTimeInMillis()) /(1000*60)) + 1;
	}
	
	/**
	 * 返回两时间间隔的天数，其中同一时间也算一个天，比如2月1号到2月1号，就算1天（1号）
	 * @param startDate
	 * @param stopDate
	 * @return
	 * @throws Exception
	 */
	public static int getDayBetweenDate(String startDate, String stopDate) throws Exception{
		if(startDate.compareTo(stopDate) > 0)
			throw new Exception("起始日期不能大于结束日期！");
		Calendar startCal = Calendar.getInstance();
		Calendar stopCal = Calendar.getInstance();
		if(startDate.length() > 10)
			startDate = startDate.substring(0, 10);
		if(stopDate.length() > 10)
			stopDate = stopDate.substring(0, 10);
		startCal.setTime(convertStringToDate(startDate));
		stopCal.setTime(convertStringToDate(stopDate));
		return (int)((stopCal.getTimeInMillis() - startCal.getTimeInMillis()) /(24*60*60*1000)) + 1;
	}
	/**
	 * 返回两时间间隔的月份，其中同一天也算一个月，比如2月1号到2月1号，就算1个月（2月）
	 * @param startDate
	 * @param stopDate
	 * @return
	 * @throws Exception
	 */
	public static int getMonthBetweenDate(boolean aboutDay, String startDate, String stopDate) throws Exception{
		if(startDate.compareTo(stopDate) > 0)
			throw new Exception("起始日期不能大于结束日期！");
		Calendar startCal = Calendar.getInstance();
		Calendar stopCal = Calendar.getInstance();
		startCal.setTime(convertStringToDate(startDate));
		stopCal.setTime(convertStringToDate(stopDate));
		int year = stopCal.get(Calendar.YEAR) - startCal.get(Calendar.YEAR);
		int month = stopCal.get(Calendar.MONTH) - startCal.get(Calendar.MONTH);
		int day = stopCal.get(Calendar.DAY_OF_MONTH) - startCal.get(Calendar.DAY_OF_MONTH);
		if(aboutDay)
			return year*12 + month + (day>=0?1:0);
		else
			return year*12 + month + 1;
	}
	/**
	 * 返回日期对应月份的一号的日期
	 * 调用方法：getMonthStartDate(Date)
	 * 
	 * @param currentDay
	 * @return
	 * @throws Exception
	 */
	public static String getMonthStartDate(Date currentDay){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDay);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return DateUtil.convertDateToString(calendar.getTime());
	}
	/**
	 * 返回日期对应月份的月末的日期
	 * 调用方法：getMonthStopDate(Date)
	 * 
	 * @param currentDay
	 * @return
	 * @throws Exception
	 */
	public static String getMonthStopDate(Date currentDay){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDay);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+1);
		calendar.set(Calendar.DAY_OF_MONTH, -1);
		return DateUtil.convertDateToString(calendar.getTime());
	}	
	/**
	 * 返回日期对应年份的年初的日期
	 * 调用方法：getMonthStartDate(Date)
	 * 
	 * @param currentDay
	 * @return
	 * @throws Exception
	 */
	public static String getYearStartDate(Date currentDay){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDay);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return DateUtil.convertDateToString(calendar.getTime());
	}
	/**
	 * 返回日期对应年份的年末的日期
	 * 调用方法：getMonthStopDate(Date)
	 * 
	 * @param currentDay
	 * @return
	 * @throws Exception
	 */
	public static String getYearStopDate(Date currentDay){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDay);
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)+1);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, -1);
		return DateUtil.convertDateToString(calendar.getTime());
	}
	/**
	 * 返回日期对应月份的所有周一的日期
	 * 调用方法：getAllMondayForMonth(Date)
	 * 
	 * @param currentDay
	 * @return
	 * @throws Exception
	 */
	public static List getAllMondayForMonth(Date currentDay){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDay);
		int monthNumber = calendar.get(Calendar.MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		int dayNumber = calendar.get(Calendar.DAY_OF_WEEK)-2;
		if(dayNumber==-1)
			dayNumber = 6;
		if(dayNumber != 0)
			calendar.add(Calendar.DATE, -dayNumber);
		List list = new ArrayList();
		do
		{
			list.add(DateUtil.convertDateToString(calendar.getTime()));
			calendar.add(Calendar.DATE, 7);
		}
		while(calendar.get(Calendar.MONTH) == monthNumber);
		return list;
	}

	/**
	 * 返回对应日期周一的日期
	 * 调用方法：getWeekStartDate(Date)
	 * 
	 * @param currentDay
	 * @return
	 * @throws Exception
	 */
	public static String getWeekStartDate(Date currentDay){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDay);
		int dayNumber = calendar.get(Calendar.DAY_OF_WEEK)-2;
		if(dayNumber==-1)
			dayNumber = 6;
		if(dayNumber != 0)
			calendar.add(Calendar.DATE, -dayNumber);
		return DateUtil.convertDateToString(calendar.getTime());
	}
	/**
	 * 返回日期对应月份的日期
	 * 调用方法：getAllMondayForMonth(Date)
	 * 
	 * @param currentDay
	 * @param Month
	 * @return
	 * @throws Exception
	 */
	public static String getMonthFromDay(Date currentDay,int Month){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDay);
		calendar.add(Calendar.MONTH, Month);
		return DateUtil.convertDateToString(calendar.getTime());
	}
    /**
     * 提前日期（天、时、分、秒）
     * 参数：
     * 当前时间 currentDateTime
     * 提前时间 int days ,int hours,int mins
     */
    public static String getCalcRollDateTime(String currentDateTime,int days ,int hours,int mins){
        //当前时间
        try{
            Date date = convertStringToDateTime(currentDateTime);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            
            long t2 = (days*24*60*60+hours*60*60+mins*60)*1000;
            
            long t1 = c.getTimeInMillis();
            Date ok = new Date(t1-t2);
            
            return convertDateTimeToString(ok);
        }catch(Exception ex){
            return "";
        }
    }
    public static final String convertDateHMTimeToString(Date aDate) {
        return getDateTime("yyyy-MM-dd HH:mm", aDate);
  }

	public static String getDateTimeMinPattern() {
		return dateTimeMinPattern;
	}
	/**
	 * 根据传入的参数 进行date天数加减
	 */
	public static String getSpDate(Date paramdate,String format,int dateArg)
	{
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(paramdate);
		calendar.add(Calendar.DATE, dateArg);
		String date=new SimpleDateFormat(format).format(calendar.getTime());
		return date;
	}
	/**
	 * 根据传入的参数 进行date天数加减
	 */
	public static String getSpDate(String format,int dateArg)
	{
		return getSpDate(new Date(),datePattern,dateArg);
	}
	/**
	 * 根据传入的参数 进行date天数加减
	 */
	public static String getSpDate(int dateArg)
	{
		return getSpDate(datePattern,dateArg);
	}
	public static String getSpDate(Date paramdate,int dateArg)
	{
		return getSpDate(paramdate,datePattern,dateArg);
	}

	/**
	 * 根据传入的参数 进行date天数加减 得到特定的日期
	 * @param paramdate
	 * @param dateArg
	 * @author chenyun
	 * @return Date
	 */
	public static Date getCustomDate(Date paramdate,int dateArg)
	{
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(paramdate);
		calendar.add(Calendar.DATE, dateArg);
		return calendar.getTime();
	}

	/**
	 * 返回当日的月份的一号的日期
	 * @param date
	 * @author chenyun
	 * @return Date
	 */
	public static Date getThisMonthStartDate(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}

	/**
	 * 返回上月份的一号的日期
	 * @param date
	 * @author chenyun
	 * @return
	 */
	public static Date getLastMonthStartDate(Date date){
		//获取前月的第一天
		Calendar   cal_1=Calendar.getInstance();//获取当前日期
		cal_1.add(Calendar.MONTH, -1);
		cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
		System.out.println("-----1------firstDay:"+cal_1.getTime());
		return cal_1.getTime();
	}

	/**
	 * 返回上月份的最后一天的日期
	 * @param date
	 * @author chenyun
	 * @return
	 */
	public static Date getLastMonthEndDate(Date date){
		//获取前月的最后一天
		Calendar cale = Calendar.getInstance();
		cale.set(Calendar.DAY_OF_MONTH,0);//设置为1号,当前日期既为本月第一天
		System.out.println("-----2------lastDay:"+cale.getTime());
		return cale.getTime();
	}

    public static void main(String[] args) throws Exception {
//        System.out.println(getMonthAwayToday("2019-04-10 19:45:12", 2));
//		System.out.println(getMonthFromDay(new Date(), 0));
//		System.out.println(getSpDate(-1));
		String time = DateUtil.getSpDate(-1);
		Date startdate = DateUtil.convertStringToDate(DateUtil.dateTimePattern,time+" 00:00:00");
		Date enddate = DateUtil.convertStringToDate(DateUtil.dateTimePattern,time+" 23:59:59");
		long starttime=startdate.getTime()/1000;
		long endtime=enddate.getTime()/1000;
		long l=endtime-starttime;
		System.out.println(l);
	}
}