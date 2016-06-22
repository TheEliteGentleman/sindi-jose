/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

import java.security.GeneralSecurityException;
import java.security.PrivateKey;

/**
 * @author Bienfait Sindi
 * @since 06 April 2016
 *
 */
public interface PrivateJWK extends JWK {

	public PrivateKey toJCAPrivateKey() throws GeneralSecurityException;
}
