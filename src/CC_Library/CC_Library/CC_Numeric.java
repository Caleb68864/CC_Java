package CC_Library;

import java.text.DecimalFormat;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class CC_Numeric.
 */
public class CC_Numeric {

	/**
	 * Checks if is integer.
	 * 
	 * @param input
	 *            the input
	 * @return true, if is integer
	 */
	public static boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			System.out.println(e);
			return false;
		}
	}

	/**
	 * Checks if is double.
	 * 
	 * @param input
	 *            the input
	 * @return true, if is double
	 */
	public static boolean isDouble(String input) {
		try {
			Double.parseDouble(input);
			return true;
		} catch (NumberFormatException input1) {
			return false;
		}
	}

	/**
	 * Checks if is float.
	 * 
	 * @param input
	 *            the input
	 * @return true, if is float
	 */
	public static boolean isFloat(String input) {
		try {
			Float.parseFloat(input);
			return true;
		} catch (NumberFormatException input1) {
			return false;
		}
	}

	/**
	 * Checks if is long.
	 * 
	 * @param input
	 *            the input
	 * @return true, if is long
	 */
	public static boolean isLong(String input) {
		try {
			Long.parseLong(input);
			return true;
		} catch (NumberFormatException input1) {
			return false;
		}
	}

	/**
	 * Round decimals.
	 * 
	 * @param d
	 *            the d
	 * @param NumOfDec
	 *            the num of dec
	 * @return the string
	 */
	public static String roundDecimals(double d, int NumOfDec) {
		try {
			String DecF = "#.";
			for (int i = 0; i < NumOfDec; i++) {
				DecF = DecF + "0";
			}
			DecimalFormat Dform = new DecimalFormat(DecF);
			return Dform.format(d);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "0";
		}
	}

	/**
	 * Num0f characters.
	 * 
	 * @param number
	 *            the number
	 * @param NumOfChar
	 *            the num of char
	 * @return the string
	 */
	public static String Num0fCharacters(int number, int NumOfChar) {
		try {
			String formatted = String.format("%0" + NumOfChar + "d", number);
			return formatted;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "0";
		}
	}

	/**
	 * Random int.
	 * 
	 * @param intMin
	 *            the int min
	 * @param intMax
	 *            the int max
	 * @return the int
	 */
	public static int RandomInt(int intMin, int intMax) {
		Random aRandom = new Random();
		if (intMin > intMax) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		// get the range, casting to long to avoid overflow problems
		long range = (long) intMax - (long) intMin + 1;
		// compute a fraction of the range, 0 <= frac < range
		long fraction = (long) (range * aRandom.nextDouble());
		int intRand = (int) (fraction + intMin);
		return intRand;
	}

	/**
	 * To percent.
	 * 
	 * @param dblPercent1
	 *            the dbl percent1
	 * @return the double
	 */
	public static double toPercent(double dblPercent1) {
		double dblPercent2 = 0;
		dblPercent2 = dblPercent1 / 100;
		return dblPercent2;
	}

	/**
	 * Rank Number st, nd, rd, th.
	 * 
	 * @param intNum
	 * 
	 * @return String
	 */
	public static String numRank(int intNum) {
		String strReturn = null;
		String strRank = null;
		String strLast = null;
		Character chrLast = null;
		int intLast = 0;
		String strNum = Integer.toString(intNum);
		chrLast = strNum.charAt(strNum.length() - 1);
		strLast = Character.toString(chrLast);
		intLast = Integer.parseInt(strLast);
		if (intLast > 3 || intLast == 0) {
			strRank = "th";
		} else if (intLast == 3) {
			strRank = "rd";
		} else if (intLast == 2) {
			strRank = "nd";
		} else {
			strRank = "st";
		}
		strReturn = strNum + strRank;
		return strReturn;
	}

	public static String binaryToRoman(int binary) {
		// Program: Convert from binary (decimal) to roman numerals.
		// This is the model without any user interface.
		// Author : Fred Swartz
		// Date : 23 Jan 2006

		// Parallel arrays used in the conversion process.
		final String[] RCODE = { "M", "CM", "D", "CD", "C", "XC", "L", "XL",
				"X", "IX", "V", "IV", "I" };
		final int[] BVAL = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,
				1 };

		// ===========================================================
		// binaryToRoman
		if (binary <= 0 || binary >= 4000) {
			throw new NumberFormatException(
					"Value outside roman numeral range.");
		}
		String roman = ""; // Roman notation will be accumualated here.

		// Loop from biggest value to smallest, successively subtracting,
		// from the binary value while adding to the roman representation.
		for (int i = 0; i < RCODE.length; i++) {
			while (binary >= BVAL[i]) {
				binary -= BVAL[i];
				roman += RCODE[i];
			}
		}
		return roman;
	}
}
