/**
 * 
 */
package za.co.sindi.jsonweb.util;

import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

import za.co.sindi.codec.Base64Codec;
import za.co.sindi.codec.exception.EncodingException;

/**
 * @author Bienfait Sindi
 * @since 10 April 2016
 *
 */
public final class X509CertificateUtils {

	private static final Base64Codec BASE64_CODEC = Base64Codec.getBase64Codec();
	
	private X509CertificateUtils() {
		throw new AssertionError("Private Constructor.");
	}
	
	public static String base64Encode(X509Certificate certificate) throws CertificateEncodingException, EncodingException {
		return new String(BASE64_CODEC.encode(certificate.getEncoded()));
	}
	
	public static byte[] getSHA1Thumbprint(X509Certificate certificate) throws CertificateEncodingException, NoSuchAlgorithmException {
		return DigestUtils.sha1Digest(certificate.getEncoded());
	}
	
	public static byte[] getSHA256Thumbprint(X509Certificate certificate) throws CertificateEncodingException, NoSuchAlgorithmException {
		return DigestUtils.sha256Digest(certificate.getEncoded());
	}
	
	public static String getBase64SHA1Thumbprint(X509Certificate certificate) throws CertificateEncodingException, NoSuchAlgorithmException, EncodingException {
		return new String(BASE64_CODEC.encode(getSHA1Thumbprint(certificate)));
	}
	
	public static String getBase64SHA256Thumbprint(X509Certificate certificate) throws CertificateEncodingException, NoSuchAlgorithmException, EncodingException {
		return new String(BASE64_CODEC.encode(getSHA256Thumbprint(certificate)));
	}
}
