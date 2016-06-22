/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

import java.security.GeneralSecurityException;
import java.security.PublicKey;

/**
 * @author Bienfait Sindi
 * @since 06 April 2016
 *
 */
public interface PublicJWK extends JWK {

	public PublicKey toJCAPublicKey() throws GeneralSecurityException;
}
