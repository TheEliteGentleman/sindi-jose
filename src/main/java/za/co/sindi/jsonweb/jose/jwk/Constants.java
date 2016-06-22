/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

/**
 * @author Bienfait Sindi
 * @since 01 April 2016
 *
 */
public final class Constants {

	private Constants() {
		throw new AssertionError("Private Constructor.");
	}
	
	public static final String JWK_KEYS = "keys";
	public static final String JWK_KEY_TYPE = "kty";
	public static final String JWK_PUBLIC_KEY_USE = "use";
	public static final String JWK_KEY_OPERATIONS = "key_ops";
	public static final String JWK_ALGORITHM = "alg";
	public static final String JWK_KEY_ID = "kid";
	public static final String JWK_X509_URL = "x5u";
	public static final String JWK_X509_CERTIFICATE_CHAIN = "x5c";
	public static final String JWK_X509_CERTIIFICATE_SHA1_THUMBPRINT = "x5t";
	public static final String JWK_X509_CERTIFICATE_SHA256_THUMBPRINT = "x5t#S256";
	
	public static final String CTY_JWK_SUBTYPE = "jwk+json";
	public static final String CTY_JWK = "application/" + CTY_JWK_SUBTYPE;
	
	public static final String KTY_EC = "EC";
	public static final String KTY_RSA = "RS";
	public static final String KTY_OCT = "oct";
	
	public static final String EC_PARAM_CURVE = "crv";
	public static final String EC_PARAM_X_COORDINATE = "x";
	public static final String EC_PARAM_Y_COORDINATE = "y";
	public static final String EC_PARAM_ECC_PRIVATE_KEY = "d";
	
	
	public static final String RSA_PARAM_MODULUS = "n";
	public static final String RSA_PARAM_EXPONENT_PUBLIC = "e";
	public static final String RSA_PARAM_EXPONENT_PRIVATE = "d";
	public static final String RSA_PARAM_FIRST_PRIME_FACTOR = "p";
	public static final String RSA_PARAM_SECOND_PRIME_FACTOR = "q";
	public static final String RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT = "dp";
	public static final String RSA_PARAM_SECOND_FACTOR_CRT_EXPONENT = "dq";
	public static final String RSA_PARAM_FIRST_CRT_COEFFICIENT = "qi";
	public static final String RSA_PARAM_OTH = "oth";
	public static final String RSA_PARAM_OTH_PRIME_FACTOR = "r";
	public static final String RSA_PARAM_OTH_FACTOR_CRT_EXPONENT = "d";
	public static final String RSA_PARAM_OTH_FACTOR_CRT_COEFFICIENT = "t";
	
	public static final String OCT_PARAM_KEY_VALUE = "k";
}
