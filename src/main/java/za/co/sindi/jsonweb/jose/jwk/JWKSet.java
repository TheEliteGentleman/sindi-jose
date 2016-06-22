/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

import za.co.sindi.jsonweb.JWObject;

/**
 * @author Bienfait Sindi
 * @since 01 April 2016
 *
 */
public interface JWKSet extends JWObject {

	public JWK[] getAllKeys();
	
	public void addKey(JWK key);
	
	public void removeKey(JWK key);
}
