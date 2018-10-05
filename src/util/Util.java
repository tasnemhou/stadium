package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class Util {

	//给密码加密
	public static String getMd5(String pwd) {
		String password = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");
			BASE64Encoder encoder = new BASE64Encoder();
			byte[] digest = md5.digest(pwd.getBytes("utf-8"));
			password = encoder.encode(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			e.getMessage();
		}
		
		return password;
	}
}
