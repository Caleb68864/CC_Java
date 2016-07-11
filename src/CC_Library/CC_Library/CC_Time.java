package CC_Library;

// TODO: Auto-generated Javadoc
/**
 * The Class CC_Time.
 */
public class CC_Time {
	
	/**
	 * Milsec_to_ sec.
	 *
	 * @param longMiliseconds the long miliseconds
	 * @return the long
	 */
	public static long Milsec_to_Sec(long longMiliseconds){
		long longSeconds = 0;
		longSeconds = longMiliseconds / 1000;
		return longSeconds;
	}
	
	/**
	 * Milsec_to_ min.
	 *
	 * @param longMiliseconds the long miliseconds
	 * @return the long
	 */
	public static long Milsec_to_Min(long longMiliseconds){
		long longSeconds = 0;
		long longMinutes = 0;
		longSeconds = longMiliseconds / 1000;
		longMinutes = longSeconds / 60;
		return longMinutes;
	}
	
	/**
	 * Milsec_to_ hr.
	 *
	 * @param longMiliseconds the long miliseconds
	 * @return the long
	 */
	public static long Milsec_to_Hr(long longMiliseconds){
		long longSeconds = 0;
		long longMinutes = 0;
		long longHours = 0;
		longSeconds = longMiliseconds / 1000;
		longMinutes = longSeconds / 60;
		longHours = longMinutes / 60;
		return longHours;
	}
	
	/**
	 * Milsec_to_ time.
	 *
	 * @param longMiliseconds the long miliseconds
	 * @return the string
	 */
	public static String Milsec_to_Time(long longMiliseconds){
		String strTime = null;
		int intMilSeconds = 0;
		int intSeconds = 0;
		int intMinutes = 0;
		int intHours = 0;
		
		intHours = (int) Milsec_to_Hr(longMiliseconds);
		intMinutes = (int) Milsec_to_Min((longMiliseconds - Hr_to_Milsec(intHours)));
		intSeconds = (int) Milsec_to_Sec(longMiliseconds - Hr_to_Milsec(intHours) - Min_to_Milsec(intMinutes));
		intMilSeconds = (int) (longMiliseconds - Hr_to_Milsec(intHours) - Min_to_Milsec(intMinutes) - Sec_to_Milsec(intSeconds));
		
		strTime = CC_Numeric.Num0fCharacters(intHours, 2) + ":" + CC_Numeric.Num0fCharacters(intMinutes, 2) + ":" + CC_Numeric.Num0fCharacters(intSeconds, 2) + ":" + CC_Numeric.Num0fCharacters(intMilSeconds, 2);
		
		return strTime;
	}
	
	/**
	 * Sec_to_ min.
	 *
	 * @param longSeconds the long seconds
	 * @return the long
	 */
	public static long Sec_to_Min(long longSeconds){
		long longMinutes = 0;
		longMinutes = longSeconds / 60;
		return longMinutes;
	}
	
	/**
	 * Sec_to_ hr.
	 *
	 * @param longSeconds the long seconds
	 * @return the long
	 */
	public static long Sec_to_Hr(long longSeconds){
		long longMinutes = 0;
		long longHours = 0;
		longMinutes = longSeconds / 60;
		longHours = longMinutes / 60;
		return longHours;
	}
	
	/**
	 * Sec_to_ milsec.
	 *
	 * @param intSeconds the int seconds
	 * @return the long
	 */
	public static long Sec_to_Milsec(int intSeconds){
		long longMilsec = 0;

		longMilsec = intSeconds * 1000;
		return longMilsec;
	}
	
	/**
	 * Min_to_ milsec.
	 *
	 * @param intMinutes the int minutes
	 * @return the long
	 */
	public static long Min_to_Milsec(int intMinutes){
		long longMilsec = 0;
		long longSeconds = 0;

		longSeconds = intMinutes * 60;
		longMilsec = longSeconds * 1000;
		return longMilsec;
	}
	
	/**
	 * Min_to_ sec.
	 *
	 * @param intMinutes the int minutes
	 * @return the long
	 */
	public static long Min_to_Sec(int intMinutes){
		long longSeconds = 0;

		longSeconds = intMinutes * 60;
		return longSeconds;
	}
	
	/**
	 * Min_to_ hr.
	 *
	 * @param intMinutes the int minutes
	 * @return the int
	 */
	public static int Min_to_Hr(int intMinutes){
		int intHours = 0;

		intHours = intMinutes / 60;
		return intHours;
	}
	
	/**
	 * Hr_to_ milsec.
	 *
	 * @param intHours the int hours
	 * @return the long
	 */
	public static long Hr_to_Milsec(int intHours){
		long longMilsec = 0;
		long longSeconds = 0;
		long longMinutes = 0;

		longMinutes = intHours * 60;
		longSeconds = longMinutes * 60;
		longMilsec = longSeconds * 1000;
		return longMilsec;
	}
	
	/**
	 * Hr_to_ sec.
	 *
	 * @param intHours the int hours
	 * @return the long
	 */
	public static long Hr_to_Sec(int intHours){
		long longSeconds = 0;
		long longMinutes = 0;

		longMinutes = intHours * 60;
		longSeconds = longMinutes * 60;
		return longSeconds;
	}
	
	/**
	 * Hr_to_ min.
	 *
	 * @param intHours the int hours
	 * @return the long
	 */
	public static long Hr_to_Min(int intHours){
		long longMinutes = 0;

		longMinutes = intHours * 60;
		return longMinutes;
	}
}
