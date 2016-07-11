package CC_Library;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class CC_UrlDownload.
 */
public class CC_UrlDownload {
	
	/**
	 * Download url.
	 *
	 * @param strURL the str url
	 * @param strDirectory the str directory
	 * @param strFilename the str filename
	 */
	public static void downloadURL(String strURL, String strDirectory,
			String strFilename) {
		try {
			/*
			 * Get a connection to the URL and start up a buffered reader.
			 */
			long startTime = System.currentTimeMillis();

			System.out.println("Connecting to " + strURL + "...\n");

			URL url = new URL(strURL);
			url.openConnection();
			InputStream reader = url.openStream();

			/*
			 * Setup a buffered file writer to write out what we read from the
			 * website.
			 */
			FileOutputStream writer = new FileOutputStream(strDirectory + "/"
					+ strFilename);
			byte[] buffer = new byte[153600];
			int totalBytesRead = 0;
			int bytesRead = 0;

			System.out.println("Reading file 150KB blocks at a time.\n");

			while ((bytesRead = reader.read(buffer)) > 0) {
				writer.write(buffer, 0, bytesRead);
				buffer = new byte[153600];
				totalBytesRead += bytesRead;
			}

			long endTime = System.currentTimeMillis();

			System.out.println("Done. "
					+ (new Integer(totalBytesRead).toString())
					+ " bytes read ("
					+ (new Long(endTime - startTime).toString())
					+ " millseconds).\n");
			writer.close();
			reader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Download ur l_no output.
	 *
	 * @param strURL the str url
	 * @param strDirectory the str directory leave 
	 * @param strFilename the str filename leave null to use existing file name.
	 */
	public static void downloadURL_noOutput(String strURL, String strDirectory,
			String strFilename) {
		String strPath = null;
		try {
			/*
			 * Get a connection to the URL and start up a buffered reader.
			 */

			URL url = new URL(strURL);
			url.openConnection();
			
			if(strFilename == null){
				File f = new File(url.getFile());
				strPath = strDirectory + "/" + f.getName();
			}else{
				strPath = strDirectory + "/" + strFilename;
			}
			
			InputStream reader = url.openStream();
			
			/*
			 * Setup a buffered file writer to write out what we read from the
			 * website.
			 */
			FileOutputStream writer = new FileOutputStream(strPath);
			byte[] buffer = new byte[153600];
			int bytesRead = 0;

			while ((bytesRead = reader.read(buffer)) > 0) {
				writer.write(buffer, 0, bytesRead);
				buffer = new byte[153600];
			}

			writer.close();
			reader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the web site source.
	 *
	 * @param strWebsite the str website
	 * @return the web site source
	 */
	public static String getWebSiteSource(String strWebsite) {

		try {

			URL url = new URL(strWebsite);
			URLConnection urlc = url.openConnection();

			BufferedInputStream buffer = new BufferedInputStream(
					urlc.getInputStream());

			StringBuilder builder = new StringBuilder();
			int byteRead;
			while ((byteRead = buffer.read()) != -1)
				builder.append((char) byteRead);

			buffer.close();

			String strOutput = builder.toString();

			return strOutput;

		} catch (MalformedURLException ex) {
			ex.printStackTrace();
			return "Error MalformedURLException";
		} catch (IOException ex) {
			ex.printStackTrace();
			return "Error IOException";
		}

	}

	/**
	 * List links.
	 *
	 * @param strWebsite the str website
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void ListLinks(String strWebsite) throws IOException {

		String url = strWebsite;
		print("Fetching %s...", url);

		Document doc = Jsoup.connect(url).get();
		Elements links = doc.select("a[href]");
		Elements media = doc.select("[src]");
		Elements imports = doc.select("link[href]");

		print("\nMedia: (%d)", media.size());
		for (Element src : media) {
			if (src.tagName().equals("img"))
				print(" * %s: <%s> %sx%s (%s)", src.tagName(),
						src.attr("abs:src"), src.attr("width"),
						src.attr("height"), trim(src.attr("alt"), 20));
			else
				print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
		}

		print("\nImports: (%d)", imports.size());
		for (Element link : imports) {
			print(" * %s <%s> (%s)", link.tagName(), link.attr("abs:href"),
					link.attr("rel"));
		}

		print("\nLinks: (%d)", links.size());
		for (Element link : links) {
			print(" * a: <%s>  (%s)", link.attr("abs:href"),
					trim(link.text(), 35));
		}
	}

	/**
	 * Gets the image links.
	 *
	 * @param strWebsite the str website
	 * @return the image links
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String[] getImageLinks(String strWebsite) throws IOException {
		String url = strWebsite;

		ArrayList<String> strlLinks;
		String[] straImgForamts;
		Integer i = 0;
		Document doc = Jsoup.connect(url).get();
		Elements links = doc.select("a[href]");

		strlLinks = new ArrayList<String>();
		straImgForamts = new String[5];
		straImgForamts[0] = ".gif";
		straImgForamts[1] = ".png";
		straImgForamts[2] = ".jpg";
		straImgForamts[3] = ".jpeg";
		straImgForamts[4] = ".tiff";

		for (Element link : links) {
			Integer intTest = 0;
			String strLink = null;
			strLink = PrintToString("%s", link.attr("abs:href"));
			for (int j = 0; j < straImgForamts.length; j++) {
				boolean bolIndex = strLink.indexOf(straImgForamts[j]) > 0;
				if (bolIndex) {
					intTest++;
				}
			}
			if (intTest > 0) {
				strlLinks.add(strLink);
			}
			i++;
		}
		String[] straLinks = strlLinks.toArray(new String[strlLinks.size()]);
		return straLinks;
	}

	/**
	 * Prints the to string.
	 *
	 * @param msg the msg
	 * @param args the args
	 * @return the string
	 */
	private static String PrintToString(String msg, Object... args) {
		String strResult = String.format(msg, args);
		return strResult;
	}

	/**
	 * Prints the.
	 *
	 * @param msg the msg
	 * @param args the args
	 */
	private static void print(String msg, Object... args) {
		System.out.println(String.format(msg, args));
	}

	/**
	 * Trim.
	 *
	 * @param s the s
	 * @param width the width
	 * @return the string
	 */
	private static String trim(String s, int width) {
		if (s.length() > width)
			return s.substring(0, width - 1) + ".";
		else
			return s;
	}
	public static boolean validateURL(String strURL){
		try {
		    URL url = new URL(strURL);
		    URLConnection conn = url.openConnection();
		    conn.connect();
		} catch (MalformedURLException e) {
		    // the URL is not in a valid form
			return false;
		} catch (IOException e) {
		    // the connection couldn't be established
			return false;
		}
		return true;
	}
}
