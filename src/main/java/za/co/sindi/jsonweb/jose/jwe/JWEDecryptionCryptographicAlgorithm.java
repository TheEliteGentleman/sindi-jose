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
public interface JWEDecryptionCryptographicAlgorithm extends JWECryptographicAlgorithm {

	public byte[] decrypt() throws GeneralSecurityException;
	public void initDecrypt(final Key key) throws GeneralSecurityException;
}
