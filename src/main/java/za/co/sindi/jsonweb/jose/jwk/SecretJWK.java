/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

import java.security.GeneralSecurityException;

import javax.crypto.SecretKey;

/**
 * @author Bienfait Sindi
 * @since 06 April 2016
 *
 */
public interface SecretJWK extends JWK {

	public SecretKey toJCASecretKey() throws GeneralSecurityException;
}
