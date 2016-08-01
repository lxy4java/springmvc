package lxy.demo.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EncrypUtil {
	private static final String ALGORITHM_RSA = "RSA";
	private static final int MAX_ENCRYPT_SIZE = 245;
	private static final int MAX_DECRYPT_SIZE = 256;

	public static String decrypt(String decryptedMessage, String privateKey) {
		byte[] messageBytes = EncodingUtil.decodeBase64(decryptedMessage);
		return new String(decrypt(messageBytes, privateKey), EncodingUtil.DEFAULT_CHARSET_CLASS);
	}

	public static byte[] decrypt(byte[] decryptedMessage, String privateKey) {
		byte[] keyBytes = EncodingUtil.decodeBase64(privateKey);

		try {
			PKCS8EncodedKeySpec e = new PKCS8EncodedKeySpec(keyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PrivateKey priK = keyFactory.generatePrivate(e);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(2, priK);
			int decryptedMessageLen = decryptedMessage.length;
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int offSet = 0;

			for (int i = 0; decryptedMessageLen - offSet > 0; offSet = i * 256) {
				byte[] cache;
				if (decryptedMessageLen - offSet > 256) {
					cache = cipher.doFinal(decryptedMessage, offSet, 256);
				} else {
					cache = cipher.doFinal(decryptedMessage, offSet, decryptedMessageLen - offSet);
				}

				out.write(cache, 0, cache.length);
				++i;
			}

			byte[] decryptedData = out.toByteArray();
			out.close();
			return decryptedData;
		} catch (IOException arg12) {
			throw new IllegalArgumentException(arg12);
		} catch (NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException
				| NoSuchAlgorithmException arg13) {
			throw new IllegalStateException("failed to decrypt message, please check private key and message", arg13);
		} catch (InvalidKeySpecException | InvalidKeyException arg14) {
			throw new IllegalArgumentException(arg14);
		}
	}

	public static String encrypt(String encryptedMessage, String publicKey) {
		byte[] messageBytes = encryptedMessage.getBytes(EncodingUtil.DEFAULT_CHARSET_CLASS);
		return EncodingUtil.base64(encrypt(messageBytes, publicKey));
	}

	public static byte[] encrypt(byte[] encryptedMessage, String publicKey) {
		byte[] keyBytes = EncodingUtil.decodeBase64(publicKey);

		try {
			X509EncodedKeySpec e = new X509EncodedKeySpec(keyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PublicKey pubK = keyFactory.generatePublic(e);
			Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
			cipher.init(1, pubK);
			int encryptedMessageLen = encryptedMessage.length;
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int offSet = 0;

			for (int i = 0; encryptedMessageLen - offSet > 0; offSet = i * 245) {
				byte[] cache;
				if (encryptedMessageLen - offSet > 245) {
					cache = cipher.doFinal(encryptedMessage, offSet, 245);
				} else {
					cache = cipher.doFinal(encryptedMessage, offSet, encryptedMessageLen - offSet);
				}

				out.write(cache, 0, cache.length);
				++i;
			}

			byte[] encryptedData = out.toByteArray();
			out.close();
			return encryptedData;
		} catch (IOException arg12) {
			throw new IllegalArgumentException(arg12);
		} catch (NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException
				| NoSuchAlgorithmException arg13) {
			throw new IllegalStateException(arg13);
		} catch (InvalidKeySpecException | InvalidKeyException arg14) {
			throw new IllegalArgumentException(arg14);
		}
	}
}