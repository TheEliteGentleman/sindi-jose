/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwe;

/**
 * @author Bienfait Sindi
 * @since 01 April 2016
 *
 */
public final class Constants {

	private Constants() {
		throw new AssertionError("Private Constructor.");
	}
	
	//JWE Headers
//	public static final String JWE_HEADER_ALGORITHM = "alg";
	public static final String JWE_HEADER_ENCRYPTION_ALGORITHM = "enc";
	public static final String JWE_HEADER_COMPRESSION_ALGORITHM = "zip";
//	public static final String JWE_HEADER_JWK_SET_URL = "jku";
//	public static final String JWE_HEADER_KEY_ID = "kid";
//	public static final String JWE_HEADER_X509_URL = "x5u";
//	public static final String JWE_HEADER_X509_CERTIFICATE_CHAIN = "x5c";
//	public static final String JWE_HEADER_X509_SHA1_THUMBPRINT = "x5t";
//	public static final String JWE_HEADER_X509_SHA256_THUMBPRINT = "x5t#S256";
//	public static final String JWE_HEADER_TYPE = "typ";
//	public static final String JWE_HEADER_CONTENT_TYPE = "cty";
//	public static final String JWE_HEADER_CRITICAL = "crit";
	
	public static final String JWE_ENC_A128CBC_HS256 = "A128CBC-HS256";
	public static final String JWE_ENC_A192CBC_HS384 = "A192CBC-HS384";
	public static final String JWE_ENC_A256CBC_HS512 = "A256CBC-HS512";
	public static final String JWE_ENC_A128GCM = "A128GCM";
	public static final String JWE_ENC_A192GCM = "A192GCM";
	public static final String JWE_ENC_A256GCM = "A256GCM";
	
	public static final String JWE_JCA_A128CBC_HS256 = "AES/CBC/PKCS5Padding";
	public static final String JWE_JCA_A192CBC_HS384 = "AES/CBC/PKCS5Padding";
	public static final String JWE_JCA_A256CBC_HS512 = "AES/CBC/PKCS5Padding";
	public static final String JWE_JCA_A128GCM = "AES/GCM/NoPadding";
	public static final String JWE_JCA_A192GCM = "AES/GCM/NoPadding";
	public static final String JWE_JCA_A256GCM = "AES/GCM/NoPadding";
	
}
