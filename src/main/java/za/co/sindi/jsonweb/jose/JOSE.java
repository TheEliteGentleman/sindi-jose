/**
 * 
 */
package za.co.sindi.jsonweb.jose;

import za.co.sindi.jsonweb.jose.jwe.JWEObjectBuilder;
import za.co.sindi.jsonweb.jose.jwe.JWEObjectReader;
import za.co.sindi.jsonweb.jose.jwe.impl.DefaultJWEObjectBuilder;
import za.co.sindi.jsonweb.jose.jwe.impl.DefaultJWEObjectReader;
import za.co.sindi.jsonweb.jose.jwk.EllipticCurveJWK;
import za.co.sindi.jsonweb.jose.jwk.EllipticCurveJWKObjectBuilder;
import za.co.sindi.jsonweb.jose.jwk.JWKObjectReader;
import za.co.sindi.jsonweb.jose.jwk.JWKSetObjectBuilder;
import za.co.sindi.jsonweb.jose.jwk.JWKSetObjectReader;
import za.co.sindi.jsonweb.jose.jwk.RSAJWK;
import za.co.sindi.jsonweb.jose.jwk.RSAJWKObjectBuilder;
import za.co.sindi.jsonweb.jose.jwk.SymmetricJWK;
import za.co.sindi.jsonweb.jose.jwk.SymmetricJWKObjectBuilder;
import za.co.sindi.jsonweb.jose.jwk.impl.DefaultEllipticCurveJWKObjectBuilder;
import za.co.sindi.jsonweb.jose.jwk.impl.DefaultJWKSetObjectBuilder;
import za.co.sindi.jsonweb.jose.jwk.impl.DefaultJWKSetObjectReader;
import za.co.sindi.jsonweb.jose.jwk.impl.DefaultRSAJWKObjectBuilder;
import za.co.sindi.jsonweb.jose.jwk.impl.DefaultSymmetricJWKObjectBuilder;
import za.co.sindi.jsonweb.jose.jwk.impl.EllipticCurveJWKObjectReader;
import za.co.sindi.jsonweb.jose.jwk.impl.RSAJWKObjectReader;
import za.co.sindi.jsonweb.jose.jwk.impl.SymmetricJWKObjectReader;
import za.co.sindi.jsonweb.jose.jws.JWSObjectBuilder;
import za.co.sindi.jsonweb.jose.jws.JWSObjectReader;
import za.co.sindi.jsonweb.jose.jws.impl.DefaultJWSObjectBuilder;
import za.co.sindi.jsonweb.jose.jws.impl.DefaultJWSObjectReader;
import za.co.sindi.jsonweb.jose.jwt.JWTClaimsObjectBuilder;
import za.co.sindi.jsonweb.jose.jwt.JWTClaimsObjectReader;
import za.co.sindi.jsonweb.jose.jwt.impl.DefaultJWTClaimsObjectBuilder;
import za.co.sindi.jsonweb.jose.jwt.impl.DefaultJWTClaimsObjectReader;

/**
 * @author Bienfait Sindi
 * @since 15 May 2017
 *
 */
public final class JOSE {

	private JOSE() {
		throw new AssertionError("Private Constructor.");
	}
	
	public static JWEObjectBuilder createJWEObjectBuilder() {
		return new DefaultJWEObjectBuilder();
	}
	
	public static JWEObjectReader createJWEObjectReader() {
		return new DefaultJWEObjectReader();
	}
	
	public static JWSObjectBuilder createJWSObjectBuilder() {
		return new DefaultJWSObjectBuilder();
	}
	
	public static JWSObjectReader createJWSObjectReader() {
		return new DefaultJWSObjectReader();
	}
	
	public static EllipticCurveJWKObjectBuilder createEllipticCurveJWKObjectBuilder() {
		return new DefaultEllipticCurveJWKObjectBuilder();
	}
	
	public static JWKObjectReader<EllipticCurveJWK> createEllipticCurveJWKObjectReader() {
		return new EllipticCurveJWKObjectReader();
	}
	
	public static RSAJWKObjectBuilder createRSAJWKObjectBuilder() {
		return new DefaultRSAJWKObjectBuilder();
	}
	
	public static JWKObjectReader<RSAJWK> createRSAJWKObjectReader() {
		return new RSAJWKObjectReader();
	}
	
	public static SymmetricJWKObjectBuilder createSymmetricJWKObjectBuilder() {
		return new DefaultSymmetricJWKObjectBuilder();
	}
	
	public static JWKObjectReader<SymmetricJWK> createSymmetricJWKObjectReader() {
		return new SymmetricJWKObjectReader();
	}
	
	public static JWKSetObjectBuilder createJWKSetObjectBuilder() {
		return new DefaultJWKSetObjectBuilder();
	}
	
	public static JWKSetObjectReader createJWKSetObjectReader() {
		return new DefaultJWKSetObjectReader();
	}
	
	public static JWTClaimsObjectBuilder createJWTClaimsObjectBuilder() {
		return new DefaultJWTClaimsObjectBuilder();
	}
	
	public static JWTClaimsObjectReader createJWTClaimsObjectReader() {
		return new DefaultJWTClaimsObjectReader();
	}
}
