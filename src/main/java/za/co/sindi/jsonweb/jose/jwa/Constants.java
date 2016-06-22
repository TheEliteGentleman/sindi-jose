/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwa;

/**
 * @author Bienfait Sindi
 * @since 31 March 2016
 *
 */
public final class Constants {

	private Constants() {
		throw new AssertionError("Private Constructor.");
	}
	
	//JWA - JWS
	public static final String JWA_HMAC_SHA_256 = "HS256";
	public static final String JWA_HMAC_SHA_384 = "HS384";
	public static final String JWA_HMAC_SHA_512 = "HS512";
	public static final String JWA_RSA_SHA_256 = "RS256";
	public static final String JWA_RSA_SHA_384 = "RS384";
	public static final String JWA_RSA_SHA_512 = "RS512";
	public static final String JWA_ECDSA_SHA_256 = "ES256";
	public static final String JWA_ECDSA_SHA_384 = "ES384";
	public static final String JWA_ECDSA_SHA_512 = "ES512";
	public static final String JWA_PSS_SHA_256 = "PS256";
	public static final String JWA_PSS_SHA_384 = "PS384";
	public static final String JWA_PSS_SHA_512 = "PS512";
	public static final String JWA_NONE = "none";
	
	//JCA - JWS
	public static final String JCA_HMAC_SHA_256 = "HmacSHA256";
	public static final String JCA_HMAC_SHA_384 = "HmacSHA384";
	public static final String JCA_HMAC_SHA_512 = "HmacSHA512";
	public static final String JCA_RSA_SHA_256 = "SHA256withRSA";
	public static final String JCA_RSA_SHA_384 = "SHA384withRSA";
	public static final String JCA_RSA_SHA_512 = "SHA512withRSA";
	public static final String JCA_ECDSA_SHA_256 = "SHA256withECDSA";
	public static final String JCA_ECDSA_SHA_384 = "SHA384withECDSA";
	public static final String JCA_ECDSA_SHA_512 = "SHA512withECDSA";
	public static final String JCA_PSS_SHA_256 = "SHA256withRSAandMGF1";
	public static final String JCA_PSS_SHA_384 = "SHA384withRSAandMGF1";
	public static final String JCA_PSS_SHA_512 = "SHA512withRSAandMGF1";
	public static final String JCA_NONE = null; //"null";
	
	//JWA - JWE
	public static final String JWE_RSA1_5 = "RSA1_5";
	public static final String JWE_RSA_OAEP = "RSA-OAEP";
	public static final String JWE_RSA_OAEP_256 = "RSA-OAEP-256";
	public static final String JWE_A128KW = "A128KW";
	public static final String JWE_A192KW = "A192KW";
	public static final String JWE_A256KW = "A256KW";
	public static final String JWE_DIR = "dir";
	public static final String JWE_ECDH_ES = "ECDH-ES";
	public static final String JWE_ECDH_ES_PLUS_A128KW = "ECDH-ES+A128KW";
	public static final String JWE_ECDH_ES_PLUS_A192KW = "ECDH-ES+A192KW";
	public static final String JWE_ECDH_ES_PLUS_A256KW = "ECDH-ES+A256KW";
	public static final String JWE_A128GCMKW = "A128GCMKW";
	public static final String JWE_A192GCMKW = "A192GCMKW";
	public static final String JWE_A256GCMKW = "A256GCMKW";
	public static final String JWE_PBES2_HS256_PLUS_A128KW = "PBES2-HS256+A128KW";
	public static final String JWE_PBES2_HS384_PLUS_A192KW = "PBES2-HS384+A192KW";
	public static final String JWE_PBES2_HS512_PLUS_A256KW = "PBES2-HS512+A256KW";
	
	//JCA - JWE
	public static final String JCA_RSA1_5 = "RSA/ECB/PKCS1Padding";
	public static final String JCA_RSA_OAEP = "RSA/ECB/OAEPWithSHA-1AndMGF1Padding";
	public static final String JCA_RSA_OAEP_256 = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding & MGF1ParameterSpec.SHA256";
	public static final String JCA_A128KW = "AESWrap"; //"AESWrap_128";
	public static final String JCA_A192KW = "AESWrap"; //"AESWrap_192";
	public static final String JCA_A256KW = "AESWrap"; //"AESWrap_256";
	public static final String JCA_DIR = null;
	public static final String JCA_ECDH_ES = "ECDH";
	public static final String JCA_ECDH_ES_PLUS_A128KW = "ECDH-ES+A128KW";
	public static final String JCA_ECDH_ES_PLUS_A192KW = "ECDH-ES+A192KW";
	public static final String JCA_ECDH_ES_PLUS_A256KW = "ECDH-ES+A256KW";
	public static final String JCA_A128GCMKW = "A128GCMKW";
	public static final String JCA_A192GCMKW = "A192GCMKW";
	public static final String JCA_A256GCMKW = "A256GCMKW";
	public static final String JCA_PBES2_HS256_PLUS_A128KW = "PBES2-HS256+A128KW";
	public static final String JCA_PBES2_HS384_PLUS_A192KW = "PBES2-HS384+A192KW";
	public static final String JCA_PBES2_HS512_PLUS_A256KW = "PBES2-HS512+A256KW";
}
