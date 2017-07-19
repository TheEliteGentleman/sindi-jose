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
public interface JWEWrappingCryptographicAlgorithm extends JWECryptographicAlgorithm {

	public void initWrap(final Key key) throws GeneralSecurityException;
	public byte[] wrap(final Key key) throws GeneralSecurityException;
}
