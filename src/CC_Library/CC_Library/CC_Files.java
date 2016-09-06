package CC_Library;

import javax.swing.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.function.BooleanSupplier;

// TODO: Auto-generated Javadoc
/**
 * The Class CC_Files.
 */
public class CC_Files {

	/**
	 * Read text file.
	 * 
	 * @param inputFile
	 *            the input file
	 * @return the string
	 */
	public static String readTextFile(String inputFile) {
		String strFileText;
		String str;
		StringBuffer sb = new StringBuffer(10000);
		try {
			BufferedReader in = new BufferedReader(new FileReader(inputFile));
			while ((str = in.readLine()) != null) {
				sb.append(str);
			}
			in.close();
			strFileText = sb.toString();
			return strFileText;
		} catch (IOException e) {
			strFileText = "Oops it didn't work";
			return strFileText;
		}
	}

	/**
	 * Read text file lines to array.
	 * 
	 * @param inputFile
	 *            the input file
	 * @return the string array
	 */
	public static String[] readTextFileToArray(String inputFile) {
		ArrayList<String> alFileText = new ArrayList<String>();

		String str;
		try {
			BufferedReader in = new BufferedReader(new FileReader(inputFile));
			while ((str = in.readLine()) != null) {
				alFileText.add(str);
			}
			in.close();
			String[] strArray = (String[]) alFileText
					.toArray(new String[alFileText.size()]);
			return strArray;
		} catch (IOException e) {
			alFileText.add("Oops it didn't work");
			String[] strArray = (String[]) alFileText
					.toArray(new String[alFileText.size()]);
			return strArray;
		}
	}

	public static ArrayList<String> readTextFileToArrayList(String inputFile) {
		ArrayList<String> alFileText = new ArrayList<String>();

		String str;
		try {
			BufferedReader in = new BufferedReader(new FileReader(inputFile));
			while ((str = in.readLine()) != null) {
				alFileText.add(str);
			}
			in.close();

			return alFileText;
		} catch (IOException e) {
			alFileText.add("Oops it didn't work");
			return alFileText;
		}
	}

	/**
	 * File copy.
	 * 
	 * @param in
	 *            the in
	 * @param out
	 *            the out
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("resource")
	public static void fileCopy(File in, File out) throws IOException {
		FileChannel inChannel = new FileInputStream(in).getChannel();
		FileChannel outChannel = new FileOutputStream(out).getChannel();
		try {
			// inChannel.transferTo(0, inChannel.size(), outChannel);
			// original -- apparently has trouble copying large files on Windows

			// magic number for Windows, 64Mb - 32Kb)
			int maxCount = (64 * 1024 * 1024) - (32 * 1024);
			long size = inChannel.size();
			long position = 0;
			while (position < size) {
				position += inChannel
						.transferTo(position, maxCount, outChannel);
			}
		} finally {
			if (inChannel != null) {
				inChannel.close();
			}
			if (outChannel != null) {
				outChannel.close();
			}
		}
	}

	public static String fileChooser() {
		JFileChooser c = new JFileChooser();
		c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int rVal = c.showSaveDialog(c);
		if (rVal == JFileChooser.APPROVE_OPTION) {
			return c.getSelectedFile().toString();
		} else {
			return "";
		}
	}

	public static void writeTextFile(String filePath, String txt, Boolean bolAppend) {
		try {
			FileWriter outFile = new FileWriter(filePath,bolAppend);
			PrintWriter out = new PrintWriter(outFile);

			// Also could be written as follows on one line
			// Printwriter out = new PrintWriter(new FileWriter(args[0]));

			// Write text to file
			out.println(txt);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String nameOnly(String filename){
		int pos = filename.lastIndexOf(".");
		String justName = pos > 0 ? filename.substring(0, pos) : filename;

		return justName;
	}
}
