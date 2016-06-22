/**
 * 
 */
package za.co.sindi.jsonweb.jose;

/**
 * @author Bienfait Sindi
 * @since 12 May 2016
 *
 */
public final class Constants {

	private Constants() {
		throw new AssertionError("Private Constructor.");
	}
	
	public static final String JOSE_HEADER_ALGORITHM = "alg";
	public static final String JOSE_HEADER_JWK_SET_URL = "jku";
	public static final String JOSE_HEADER_JWK = "jwk";
	public static final String JOSE_HEADER_KEY_ID = "kid";
	public static final String JOSE_HEADER_X509_URL = "x5u";
	public static final String JOSE_HEADER_X509_CERTIFICATE_CHAIN = "x5c";
	public static final String JOSE_HEADER_X509_CERTIIFICATE_SHA1_THUMBPRINT = "x5t";
	public static final String JOSE_HEADER_X509_CERTIFICATE_SHA256_THUMBPRINT = "x5t#S256";
	public static final String JOSE_HEADER_TYPE = "typ";
	public static final String JOSE_HEADER_CONTENT_TYPE = "cty";
	public static final String JOSE_HEADER_CRITICAL = "crit";
}
