package CC_Library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class CC_Random {
	private static Random rand = new Random();

	public static String randomLetter(Boolean blUppercase) {
		String strLetter = "a";
		String[] straAlphabet = new String[] { "a", "b", "c", "d", "e", "f",
				"g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };
		strLetter = straAlphabet[rand.nextInt(26)];
		if (blUppercase) {
			strLetter = strLetter.toUpperCase();
		} else {
			strLetter = strLetter.toLowerCase();
		}
		return strLetter;
	}

	public static String randomColor() {
		String strColor = "Black";
		ArrayList<String> alColors = new ArrayList<String>();
		alColors.add("Black");
		alColors.add("Blue");
		alColors.add("Orange");
		alColors.add("Red");
		alColors.add("White");
		alColors.add("Yellow");
		alColors.add("Pink");
		alColors.add("Purple");
		alColors.add("Green");
		alColors.add("Gray");
		alColors.add("Brown");
		String[] straColors = alColors.toArray(new String[alColors.size()]);
		strColor = straColors[rand.nextInt(straColors.length)];
		return strColor;
	}

	public static Color randomRGBColor() {
		Color cl;
		cl = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
		return cl;
	}

	public static DateTime randomDate() {
		DateTime dt = DateTime.now();
		int curYear = dt.getYear();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy");
		String strDate = null;
		String strMonth = CC_Numeric.Num0fCharacters(rand.nextInt(12) + 1, 2);
		int intDays = 0;
		int intSwitch = Integer.parseInt(strMonth);
		switch(intSwitch){
		case 1:
			intDays = 31;
			break;
		case 2:
			intDays = 28;
			break;
		case 3:
			intDays = 31;
			break;
		case 4:
			intDays = 30;
			break;
		case 5:
			intDays = 31;
			break;
		case 6:
			intDays = 30;
			break;
		case 7:
			intDays = 31;
			break;
		case 8:
			intDays = 30;
			break;
		case 9:
			intDays = 30;
			break;
		case 10:
			intDays = 31;
			break;
		case 11:
			intDays = 30;
			break;
		case 12:
			intDays = 31;
			break;
		}
		String strDay = CC_Numeric.Num0fCharacters(rand.nextInt(intDays) + 1, 2);
		String strYear = CC_Numeric.Num0fCharacters(
				rand.nextInt(curYear - 1000) + 1000, 4);
		strDate = strMonth;
		strDate += "/";
		strDate += strDay;
		strDate += "/";
		strDate += strYear;
		dt = fmt.parseDateTime(strDate);
		return dt;
	}

	public static int randomExcluded(int intMax, int[] intExcludedNubmers) {
		int intReturn = 0;
		if (intMax == 0) {
			intReturn = rand.nextInt();
		} else {
			intReturn = rand.nextInt(intMax);
		}
		Boolean blGo = false;
		while (blGo == false) {
			intReturn = rand.nextInt();
			if (intReturn < 0) {
				intReturn = intReturn * -1;
			}
			for (int i = 0; i < intExcludedNubmers.length; i++) {
				if (intReturn != intExcludedNubmers[i]) {
					blGo = true;
				}
			}
		}
		return intReturn;
	}
}
