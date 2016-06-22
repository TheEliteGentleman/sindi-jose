/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwt;

import za.co.sindi.jsonweb.JWObject;
import za.co.sindi.jsonweb.NumericDate;
import za.co.sindi.jsonweb.StringOrURI;

/**
 * @author Bienfait Sindi
 * @since 31 March 2016
 *
 */
public interface JWTClaims extends JWObject {

	public StringOrURI getIssuer();
	public void setIssuer(final StringOrURI issuer);
	
	public StringOrURI getSubject();
	public void setSubject(final StringOrURI subject);
	
	public NumericDate getExpirationTime();
	public void setExpirationTime(final NumericDate expirationTime);
	
	public NumericDate getNotBefore();
	public void setNotBefore(final NumericDate notBefore);
	
	public NumericDate getIssuedAt();
	public void setIssuedAt(final NumericDate issuedAt);
	
	public String getJwtID();
	public void setJwtID(final String jwtID);
}
