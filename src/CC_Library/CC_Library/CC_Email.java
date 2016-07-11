package CC_Library;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import javax.*;

// TODO: Auto-generated Javadoc
/**
 * The Class CC_Email.
 */
public class CC_Email {
	 
	/**
	 * Send email.
	 *
	 * @param strRecipient the str recipient
	 * @param strSubject the str subject
	 * @param strMessage the str message
	 * @param strFrom the str from
	 * @throws EmailException the email exception
	 */
	public static void sendEmail(String strRecipient, String strSubject, String strMessage , String strFrom) throws EmailException{
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		//email.setAuthenticator(new DefaultAuthenticator("", ""));
		email.setTLS(true);
		email.setFrom(strFrom);
		email.setSubject(strSubject);
		email.setMsg(strMessage);
		email.addTo(strRecipient);
		email.send();
	}
}
