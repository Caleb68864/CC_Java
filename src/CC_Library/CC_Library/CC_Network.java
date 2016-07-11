package CC_Library;

import java.net.InetAddress;
import java.net.UnknownHostException;

// TODO: Auto-generated Javadoc
/**
 * The Class CC_Network.
 */
public class CC_Network {

	/**
	 * Gets the local ip.
	 * 
	 * @return the local ip
	 */
	public static String getLocalIP() {
		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
			String strIPaddress = ip.getHostAddress();
			return strIPaddress;
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return "Error UnknownHostException";
		}

	}

}
