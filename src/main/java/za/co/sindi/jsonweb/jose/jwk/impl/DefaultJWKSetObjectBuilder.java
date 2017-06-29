/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk.impl;

import za.co.sindi.jsonweb.jose.jwk.JWK;
import za.co.sindi.jsonweb.jose.jwk.JWKSet;
import za.co.sindi.jsonweb.jose.jwk.JWKSetObjectBuilder;

/**
 * @author Bienfait Sindi
 * @since 25 May 2017
 *
 */
public class DefaultJWKSetObjectBuilder implements JWKSetObjectBuilder {

	private JWKKeySet jwkSet;
	
	/**
	 * 
	 */
	public DefaultJWKSetObjectBuilder() {
		super();
		// TODO Auto-generated constructor stub
		jwkSet = new JWKKeySet();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.JWObjectBuilder#build()
	 */
	@Override
	public JWKSet build() {
		// TODO Auto-generated method stub
		return jwkSet;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKSetObjectBuilder#addKey(za.co.sindi.jsonweb.jose.jwk.JWK)
	 */
	@Override
	public JWKSetObjectBuilder addKey(JWK key) {
		// TODO Auto-generated method stub
		jwkSet.addKey(key);
		return this;
	}
}
