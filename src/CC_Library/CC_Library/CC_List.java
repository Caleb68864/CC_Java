package CC_Library;

import java.util.List;

public class CC_List {
	public static void printList(List<String> list, boolean bMsg){
		String[] stra = (String[]) list.toArray();
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
