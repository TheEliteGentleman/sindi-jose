/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwt;

import za.co.sindi.jsonweb.JWObjectBuilder;
import za.co.sindi.jsonweb.NumericDate;
import za.co.sindi.jsonweb.StringOrURI;

/**
 * @author Bienfait Sindi
 * @since 25 May 2017
 *
 */
public interface JWTClaimsObjectBuilder extends JWObjectBuilder<JWTClaims> {

	public JWTClaimsObjectBuilder setIssuer(final StringOrURI issuer);
	
	public JWTClaimsObjectBuilder setSubject(final StringOrURI subject);
	
	public JWTClaimsObjectBuilder setExpirationTime(final NumericDate expirationTime);
	
	public JWTClaimsObjectBuilder setNotBefore(final NumericDate notBefore);
	
	public JWTClaimsObjectBuilder setIssuedAt(final NumericDate issuedAt);
	
	public JWTClaimsObjectBuilder setJwtID(final String jwtID);
}
