/**
 * 
 */
package za.co.sindi.jsonweb.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Bienfait Sindi
 * @since 10 April 2016
 *
 */
public final class DigestUtils {

	private static final int STREAM_BUFFER_LENGTH = 1024;
	
	private DigestUtils() {
		throw new AssertionError("Private Constructor.");
	}
	
	private static void updateMessageDigest(MessageDigest digest, final InputStream data) throws IOException {
		final byte[] buffer = new byte[STREAM_BUFFER_LENGTH];
		int read = data.read(buffer, 0, STREAM_BUFFER_LENGTH);
		
		while (read > -1) {
		    digest.update(buffer, 0, read);
		    read = data.read(buffer, 0, STREAM_BUFFER_LENGTH);
		}
	}
	
	public static MessageDigest getMessageDigest(final String algorithm) throws NoSuchAlgorithmException {
		return MessageDigest.getInstance(algorithm);
	}
	
	public static MessageDigest getMD2MessageDigest() throws NoSuchAlgorithmException {
		return getMessageDigest("MD2");
	}
	
	public static MessageDigest getMD5MessageDigest() throws NoSuchAlgorithmException {
		return getMessageDigest("MD5");
	}
	
	public static MessageDigest getSHA1MessageDigest() throws NoSuchAlgorithmException {
		return getMessageDigest("SHA-1");
	}
	
	public static MessageDigest getSHA256MessageDigest() throws NoSuchAlgorithmException {
		return getMessageDigest("SHA-256");
	}
	
	public static MessageDigest getSHA384MessageDigest() throws NoSuchAlgorithmException {
		return getMessageDigest("SHA-384");
	}
	
	public static MessageDigest getSHA512MessageDigest() throws NoSuchAlgorithmException {
		return getMessageDigest("SHA-512");
	}
	
	public static byte[] md2Digest(final InputStream data) throws NoSuchAlgorithmException, IOException {
		MessageDigest digest = getMD2MessageDigest();
		updateMessageDigest(digest, data);
		return digest.digest();
	}
	
	public static byte[] md2Digest(final byte[] data) throws NoSuchAlgorithmException {
		return getMD2MessageDigest().digest(data);
	}
	
	public static byte[] md2Digest(final String data, final Charset charset) throws NoSuchAlgorithmException {
		return getMD2MessageDigest().digest(data.getBytes(charset));
	}
	
	public static byte[] md5Digest(final InputStream data) throws NoSuchAlgorithmException, IOException {
		MessageDigest digest = getMD5MessageDigest();
		updateMessageDigest(digest, data);
		return digest.digest();
	}
	
	public static byte[] md5Digest(final byte[] data) throws NoSuchAlgorithmException {
		return getMD5MessageDigest().digest(data);
	}
	
	public static byte[] md5Digest(final String data, final Charset charset) throws NoSuchAlgorithmException {
		return getMD5MessageDigest().digest(data.getBytes(charset));
	}
	
	public static byte[] sha1Digest(final InputStream data) throws NoSuchAlgorithmException, IOException {
		MessageDigest digest = getSHA1MessageDigest();
		updateMessageDigest(digest, data);
		return digest.digest();
	}
	
	public static byte[] sha1Digest(final byte[] data) throws NoSuchAlgorithmException {
		return getSHA1MessageDigest().digest(data);
	}
	
	public static byte[] sha1Digest(final String data, final Charset charset) throws NoSuchAlgorithmException {
		return getSHA1MessageDigest().digest(data.getBytes(charset));
	}
	
	public static byte[] sha256Digest(final InputStream data) throws NoSuchAlgorithmException, IOException {
		MessageDigest digest = getSHA256MessageDigest();
		updateMessageDigest(digest, data);
		return digest.digest();
	}
	
	public static byte[] sha256Digest(final byte[] data) throws NoSuchAlgorithmException {
		return getSHA256MessageDigest().digest(data);
	}
	
	public static byte[] sha256Digest(final String data, final Charset charset) throws NoSuchAlgorithmException {
		return getSHA256MessageDigest().digest(data.getBytes(charset));
	}
	
	public static byte[] sha384Digest(final InputStream data) throws NoSuchAlgorithmException, IOException {
		MessageDigest digest = getSHA384MessageDigest();
		updateMessageDigest(digest, data);
		return digest.digest();
	}
	
	public static byte[] sha384Digest(final byte[] data) throws NoSuchAlgorithmException {
		return getSHA384MessageDigest().digest(data);
	}
	
	public static byte[] sha384Digest(final String data, final Charset charset) throws NoSuchAlgorithmException {
		return getSHA384MessageDigest().digest(data.getBytes(charset));
	}
	
	public static byte[] sha512Digest(final InputStream data) throws NoSuchAlgorithmException, IOException {
		MessageDigest digest = getSHA512MessageDigest();
		updateMessageDigest(digest, data);
		return digest.digest();
	}
	
	public static byte[] sha512Digest(final byte[] data) throws NoSuchAlgorithmException {
		return getSHA512MessageDigest().digest(data);
	}
	
	public static byte[] sha512Digest(final String data, final Charset charset) throws NoSuchAlgorithmException {
		return getSHA512MessageDigest().digest(data.getBytes(charset));
	}
}
