package CC_Library;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import CC_Library.CC_Strings.TextTransfer;

public class CC_Test {
	public static void testMessageBox() {
		Component frame = null;
		JOptionPane.showMessageDialog(frame,
				"Wherever you put this it is working");
	}

	public static void MsgBox(String string) {
		Component frame = null;
		int mc = JOptionPane.QUESTION_MESSAGE;
		String opts[] = { "Ok", "Copy" };
		// JOptionPane.showMessageDialog(frame, string);
		int ch = JOptionPane.showOptionDialog(frame, string, "CC_Test Message Box", 0,
				mc, null, opts, opts[0]);
		if(ch > 0){
			switch(ch){
			case 1:
				TextTransfer textTransfer = new TextTransfer();
				textTransfer.setClipboardContents(string);
				break;
			}
		}
	}
	
	public static void printStringArrayList(ArrayList<String> al){
		for(int i = 0; i < al.size(); i++){
			System.out.println(al.get(i).toString());
		}
	}
	
	public static void printIntegerArrayList(ArrayList<Integer> al){
		for(int i = 0; i < al.size(); i++){
			System.out.println(al.get(i).toString());
		}
	}
}
