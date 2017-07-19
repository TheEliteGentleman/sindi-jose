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
public interface JWSComputationCryptographicAlgorithm extends JWSCryptographicAlgorithm {

	public void initSign(final Key key) throws GeneralSecurityException;
	public byte[] compute() throws GeneralSecurityException;
}
