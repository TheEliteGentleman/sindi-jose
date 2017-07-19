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
public interface JWEEncryptionCryptographicAlgorithm extends JWECryptographicAlgorithm {

	public void initEncrypt(final Key key) throws GeneralSecurityException;
	public byte[] encrypt() throws GeneralSecurityException;
}
