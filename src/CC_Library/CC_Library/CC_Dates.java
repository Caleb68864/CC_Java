package CC_Library;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class CC_Dates. Is for getting and formatting dates.
 */
public class CC_Dates {

	/**
	 * Gets the date.
	 * 
	 * @param strFormat
	 *            the str format
	 * @return the date
	 */
	public static String getDate(String strFormat) {
		Calendar currentDate = Calendar.getInstance();
		// Date Formats
		// "MM/dd/yyyy";
		// "MM/dd/yyyy HH:mm:ss";
		// "dd-MMM-yyyy HH:mm:ss";
		// "dd-MMM-yyyy";
		// "dd/MMM/yyyy HH:mm:ss";
		// "dd/MMM/yyyy";
		// "MMM/dd/yyyy";
		// "MM/dd/yyyy";
		SimpleDateFormat formatter = new SimpleDateFormat(strFormat);
		String dateNow = formatter.format(currentDate.getTime());
		return dateNow;
	}

	public static String formatDate(String strFormat, DateTime dtDate) {
		// Date Formats
		// "MM/dd/yyyy";
		// "MM/dd/yyyy HH:mm:ss";
		// "dd-MMM-yyyy HH:mm:ss";
		// "dd-MMM-yyyy";
		// "dd/MMM/yyyy HH:mm:ss";
		// "dd/MMM/yyyy";
		// "MMM/dd/yyyy";
		// "MM/dd/yyyy";
		DateTimeFormatter fmt = DateTimeFormat.forPattern(strFormat);
		return fmt.print(dtDate);
	}

	public static String addDays(String strDate, String strFormat,
			Integer intDays) throws ParseException {
		// Date Formats
		// "MM/dd/yyyy";
		// "MM/dd/yyyy HH:mm:ss";
		// "dd-MMM-yyyy HH:mm:ss";
		// "dd-MMM-yyyy";
		// "dd/MMM/yyyy HH:mm:ss";
		// "dd/MMM/yyyy";
		// "MMM/dd/yyyy";
		// "MM/dd/yyyy";
		String dt = strDate; // Start date
		SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(dt));
		c.add(Calendar.DATE, intDays); // number of days to add
		dt = sdf.format(c.getTime()); // dt is now the new date
		return dt;
	}

	public static String addDays(Date curDate, String strFormat, Integer intDays)
			throws ParseException {
		// Date Formats
		// "MM/dd/yyyy";
		// "MM/dd/yyyy HH:mm:ss";
		// "dd-MMM-yyyy HH:mm:ss";
		// "dd-MMM-yyyy";
		// "dd/MMM/yyyy HH:mm:ss";
		// "dd/MMM/yyyy";
		// "MMM/dd/yyyy";
		// "MM/dd/yyyy";
		String dt = null;
		SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
		Calendar c = Calendar.getInstance();
		c.setTime(curDate);
		c.add(Calendar.DATE, intDays); // number of days to add
		dt = sdf.format(c.getTime()); // dt is now the new date
		return dt;
	}

	public static Double DaysToMonths(Integer intDays) {
		Double dblMonths = (double) 0;
		dblMonths = (double) intDays / 30;
		return dblMonths;
	}

	public static Double MonthsToDays(Double dblMonths) {
		Double dblDays = (double) 0;
		dblDays = dblMonths * 30;
		return dblDays;
	}

	public static String getAge(int intYear, int intMonth, int intDay) {
		// DateTime dt = new DateTime();
		// int month = dt.getMonthOfYear();
		// String monthName = dt.monthOfYear().getAsText();
		// DateTime rounded = dt.dayOfMonth();
		// DateTime rounded = dt.year;
		String strAge = null;
		Date d = new Date();
		LocalDate dob = new LocalDate(intYear, intMonth, intDay);
		LocalDate date = new LocalDate(d);

		Period period = new Period(dob, date, PeriodType.yearMonthDay());
		if (period.getYears() > 0) {
			String strS;
			if (period.getYears() > 1) {
				strS = "s";
			} else {
				strS = "";
			}
			strAge = period.getYears() + " year" + strS + " and "
					+ period.getMonths() + " months";
		} else {
			String strS2 = null;
			if (period.getMonths() > 1) {
				strS2 = "s";
				strAge = period.getMonths() + " month" + strS2;
			} else if (period.getMonths() == 1) {
				strS2 = "";
				strAge = period.getMonths() + " month" + strS2;
			} else {
				strAge = "";
			}
		}
		;
		return strAge;
	}

	public static String getAge(DateTime dt) {
		String strAge = null;
		DateTime d = DateTime.now();
		LocalDate dob = new LocalDate(dt.getYear(), dt.getMonthOfYear(),
				dt.getDayOfMonth());
		LocalDate date = new LocalDate(d);

		Period period = new Period(dob, date, PeriodType.yearMonthDay());
		if (period.getYears() > 0) {
			String strS;
			if (period.getYears() > 1) {
				strS = "s";
			} else {
				strS = "";
			}
			strAge = period.getYears() + " year" + strS + " and "
					+ period.getMonths() + " months";
		} else {
			String strS2 = null;
			if (period.getMonths() > 1) {
				strS2 = "s";
				strAge = period.getMonths() + " month" + strS2;
			} else if (period.getMonths() == 1) {
				strS2 = "";
				strAge = period.getMonths() + " month" + strS2;
			} else {
				strAge = "";
			}
		}
		;
		return strAge;
	}

	public static DateTime sqlDate(String date) {
		DateTime dt = null;
		if (date == null) {
			dt = null;
		} else {
			dt = DateTime.parse(date);
		}
		return dt;
	}
}
