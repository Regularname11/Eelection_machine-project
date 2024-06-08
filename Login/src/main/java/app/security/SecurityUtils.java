package app.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class SecurityUtils {
	public static String getPasswordHashed(String password, String salt) {
		String result ="";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256"); 
			byte[] saltbytes= Base64.getDecoder().decode(salt);
			md.update(saltbytes);
			byte[] bytes = md.digest(password.getBytes());
			result = Base64.getEncoder().encodeToString(bytes);
		} catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return result;
	}
	public static String getSalt() {
		String result = "";
		SecureRandom rd = new SecureRandom();
		byte[] salt = new byte[16];
		rd.nextBytes(salt);
		result = Base64.getEncoder().encodeToString(salt);
		return result;
	}

	public static boolean ispasswordgood(String storedHAsh, String password, String storedSalt) {
		if(storedHAsh.equals(getPasswordHashed(password, storedSalt))) {
			return true;
		}
		return false;
		
	}
}
