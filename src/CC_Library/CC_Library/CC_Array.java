package CC_Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import CC_Library.CC_Test;

// TODO: Auto-generated Javadoc
/**
 * The Class CC_Array.
 */
public class CC_Array {

	/**
	 * Int no duplicates.
	 * 
	 * @param myArray
	 *            the my array
	 * @return true, if successful
	 */
	public static boolean intNoDuplicates(Integer[] myArray) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(myArray));
		Set<Integer> set = new HashSet<Integer>(list);
		if (set.size() < myArray.length) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Str no duplicates.
	 * 
	 * @param myArray
	 *            the my array
	 * @return true, if successful
	 */
	public static boolean strNoDuplicates(String[] myArray) {
		List<String> list = new ArrayList<String>(Arrays.asList(myArray));
		Set<String> set = new HashSet<String>(list);
		if (set.size() < myArray.length) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Dbl no duplicates.
	 * 
	 * @param myArray
	 *            the my array
	 * @return true, if successful
	 */
	public static boolean dblNoDuplicates(Double[] myArray) {
		List<Double> list = new ArrayList<Double>(Arrays.asList(myArray));
		Set<Double> set = new HashSet<Double>(list);
		if (set.size() < myArray.length) {
			return false;
		} else {
			return true;
		}
	}

	public static void printArray(String[] stra, boolean bMsg) {
		if (bMsg) {
			for (int i = 0; i < stra.length; i++) {
				CC_Test.MsgBox(stra[i]);
			}
		} else {
			for (int i = 0; i < stra.length; i++) {
				System.out.println(stra[i]);
			}
		}
	}
}
