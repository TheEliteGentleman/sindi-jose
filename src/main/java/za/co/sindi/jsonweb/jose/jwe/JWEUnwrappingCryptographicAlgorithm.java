/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwe;

import java.security.GeneralSecurityException;
import java.security.Key;

/**
 * @author Bienfait Sindi
 * @since 12 June 2017
 * 
 */
public interface JWEUnwrappingCryptographicAlgorithm extends JWECryptographicAlgorithm {

	public Key unwrap(final byte[] wrappedKey) throws GeneralSecurityException;
	public void initUnwrap(final Key key) throws GeneralSecurityException;
}
