/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

import za.co.sindi.jsonweb.Base64URLBytes;

/**
 * @author Bienfait Sindi
 * @since 08 April 2016
 *
 */
public interface SymmetricJWK extends JWK {

	public Base64URLBytes getKeyValue();
}
