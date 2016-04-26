import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;



public class MD5Util {
	public static String md5(String msg) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md.digest(msg.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
}
