package lxy.demo.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Base64;

public final class EncodingUtil {
	public static final Charset DEFAULT_CHARSET_CLASS = Charset.forName("UTF-8");

	public static String base64(byte[] bytes) {
		return new String(Base64.getEncoder().encode(bytes), DEFAULT_CHARSET_CLASS);
	}

	public static byte[] base64(String text) {
		return Base64.getEncoder().encode(text.getBytes(DEFAULT_CHARSET_CLASS));
	}

	public static String decodeBase64(byte[] base64Bytes) {
		return new String(Base64.getDecoder().decode(base64Bytes), DEFAULT_CHARSET_CLASS);
	}

	public static byte[] decodeBase64(String base64Text) {
		return Base64.getDecoder().decode(base64Text.getBytes(DEFAULT_CHARSET_CLASS));
	}

	public static String urlEncode(String text) {
		try {
			return URLEncoder.encode(text, "UTF-8");
		} catch (UnsupportedEncodingException arg1) {
			throw new IllegalStateException(arg1);
		}
	}

	public static String urlDecode(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException arg1) {
			throw new IllegalStateException(arg1);
		}
	}

	public static String base64URLencode(byte[] textBytes) {
		return new String(Base64.getUrlEncoder().encode(textBytes), Charset.forName("UTF-8"));
	}

	public static String base64URLencode(String text) {
		return new String(base64URLencode(text.getBytes(Charset.forName("UTF-8"))));
	}

	public static String base64URLdecode(byte[] bytes) {
		return new String(Base64.getUrlDecoder().decode(bytes), Charset.forName("UTF-8"));
	}

	public static String base64URLdecode(String text) {
		return new String(base64URLdecode(text.getBytes(Charset.forName("UTF-8"))));
	}

	public static void main(String[] args) {
		String text = "A";
		System.out.println("base64:" + base64(text));
		System.out.println("decodeBase64:" + decodeBase64(base64(text)));
		System.out.println("urlEncode:" + urlEncode(text));
		System.out.println("urlDecode:" + urlDecode(urlEncode(text)));
		System.out.println("base64URLencode:" + base64URLencode(text));
		System.out.println("base64URLdecode:" + base64URLdecode(base64URLencode(text)));
	}
}