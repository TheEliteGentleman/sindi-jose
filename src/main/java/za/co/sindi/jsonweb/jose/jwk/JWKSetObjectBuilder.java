/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

import za.co.sindi.jsonweb.JWObjectBuilder;

/**
 * @author Bienfait Sindi
 * @since 25 May 2017
 *
 */
public interface JWKSetObjectBuilder extends JWObjectBuilder<JWKSet> {
	
	public JWKSetObjectBuilder addKey(JWK key);
}
