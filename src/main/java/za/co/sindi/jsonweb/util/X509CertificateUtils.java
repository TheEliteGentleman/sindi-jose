/**
 * 
 */
package za.co.sindi.jsonweb.util;

import java.io.ByteArrayInputStream;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import za.co.sindi.codec.Base64Codec;
import za.co.sindi.codec.exception.DecodingException;
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
	
	public static X509Certificate base64Decode(final byte[] encodedBytes) throws CertificateException, DecodingException {
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
		return (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(BASE64_CODEC.decode(encodedBytes)));
	}
	
	public static byte[] getSHA1Thumbprint(X509Certificate certificate) throws CertificateEncodingException, NoSuchAlgorithmException {
		return DigestUtils.sha1Digest(certificate.getEncoded());
	}
	
	public static byte[] getSHA256Thumbprint(X509Certificate certificate) throws CertificateEncodingException, NoSuchAlgorithmException {
		return DigestUtils.sha256Digest(certificate.getEncoded());
	}
	
	public static String getBase64URLSHA1Thumbprint(X509Certificate certificate) throws CertificateEncodingException, NoSuchAlgorithmException, EncodingException {
		return new String(Base64URLUtils.base64UrlEncode(getSHA1Thumbprint(certificate)));
	}
	
	public static String getBase64URLSHA256Thumbprint(X509Certificate certificate) throws CertificateEncodingException, NoSuchAlgorithmException, EncodingException {
		return new String(Base64URLUtils.base64UrlEncode(getSHA256Thumbprint(certificate)));
	}
}
