/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws;

import java.security.GeneralSecurityException;
import java.security.Key;

/**
 * @author Bienfait Sindi
 * @since 12 June 2017
 * 
 */
public interface JWSVerificationCryptographicAlgorithm extends JWSCryptographicAlgorithm {

	public void initVerify(final Key key) throws GeneralSecurityException;
	public boolean verify(final byte[] signature) throws GeneralSecurityException;
	public boolean verify(final byte[] signature, int offset, int length) throws GeneralSecurityException;
}
