/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwt.impl;

import za.co.sindi.jsonweb.NumericDate;
import za.co.sindi.jsonweb.StringOrURI;
import za.co.sindi.jsonweb.jose.jwt.JWTClaimsObjectBuilder;

/**
 * @author Bienfait Sindi
 * @since 25 May 2017
 *
 */
public class DefaultJWTClaimsObjectBuilder implements JWTClaimsObjectBuilder {
	
	private JWTClaims jwtClaims;
	
	/**
	 * 
	 */
	public DefaultJWTClaimsObjectBuilder() {
		jwtClaims = new JWTClaims();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.JWObjectBuilder#build()
	 */
	@Override
	public za.co.sindi.jsonweb.jose.jwt.JWTClaims build() {
		// TODO Auto-generated method stub
		return jwtClaims;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwt.JWTClaimsObjectBuilder#setIssuer(za.co.sindi.jsonweb.StringOrURI)
	 */
	@Override
	public JWTClaimsObjectBuilder setIssuer(StringOrURI issuer) {
		// TODO Auto-generated method stub
		jwtClaims.setIssuer(issuer);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwt.JWTClaimsObjectBuilder#setSubject(za.co.sindi.jsonweb.StringOrURI)
	 */
	@Override
	public JWTClaimsObjectBuilder setSubject(StringOrURI subject) {
		// TODO Auto-generated method stub
		jwtClaims.setSubject(subject);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwt.JWTClaimsObjectBuilder#setExpirationTime(za.co.sindi.jsonweb.NumericDate)
	 */
	@Override
	public JWTClaimsObjectBuilder setExpirationTime(NumericDate expirationTime) {
		// TODO Auto-generated method stub
		jwtClaims.setExpirationTime(expirationTime);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwt.JWTClaimsObjectBuilder#setNotBefore(za.co.sindi.jsonweb.NumericDate)
	 */
	@Override
	public JWTClaimsObjectBuilder setNotBefore(NumericDate notBefore) {
		// TODO Auto-generated method stub
		jwtClaims.setNotBefore(notBefore);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwt.JWTClaimsObjectBuilder#setIssuedAt(za.co.sindi.jsonweb.NumericDate)
	 */
	@Override
	public JWTClaimsObjectBuilder setIssuedAt(NumericDate issuedAt) {
		// TODO Auto-generated method stub
		jwtClaims.setIssuedAt(issuedAt);
		return this;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwt.JWTClaimsObjectBuilder#setJwtID(java.lang.String)
	 */
	@Override
	public JWTClaimsObjectBuilder setJwtID(String jwtID) {
		// TODO Auto-generated method stub
		jwtClaims.setJwtID(jwtID);
		return this;
	}
}
