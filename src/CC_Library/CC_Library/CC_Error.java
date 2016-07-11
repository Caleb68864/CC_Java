package CC_Library;

import org.apache.commons.mail.EmailException;
import CC_Library.CC_Email;

// TODO: Auto-generated Javadoc
/**
 * The Class CC_Error.
 */
public class CC_Error {
	
	/**
	 * Send error.
	 *
	 * @param strError the str error
	 * @param strApplication the str application
	 */
	public static void SendError(String strError, String strApplication){
		try {
			String strRecipient = "caleb@calebscomputers.com";
			String strFrom = "error@calebscomputers.com";
			String strSubject ="Error From " + strApplication;
			String strMessage = strError;
			CC_Email.sendEmail(strRecipient, strSubject, strMessage, strFrom);
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
