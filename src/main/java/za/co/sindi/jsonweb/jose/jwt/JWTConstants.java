/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwt;

/**
 * @author Bienfait Sindi
 * @since 31 March 2016
 *
 */
public final class JWTConstants {

	private JWTConstants() {
		throw new AssertionError("Private constructor.");
	}
	
	public static final String JWT_CLAIM_ISSUER = "iss";
	
	public static final String JWT_CLAIM_SUBJECT = "sub";
	
	public static final String JWT_CLAIM_AUDIENCE = "aud";
	
	public static final String JWT_CLAIM_EXPIRATION_TIME = "exp";
	
	public static final String JWT_CLAIM_NOT_BEFORE = "nbf";
	
	public static final String JWT_CLAIM_ISSUED_AT = "iat";
	
	public static final String JWT_CLAIM_JWT_ID = "jti";
}
