/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

import za.co.sindi.jsonweb.jose.jwa.CryptographicAlgorithm;

/**
 * @author Bienfait Sindi
 * @since 17 July 2017
 *
 */
public interface JWSCryptographicAlgorithm extends CryptographicAlgorithm<JWSAlgorithm> {

	public void update(byte[] input) throws GeneralSecurityException;
	public void update(byte[] input, int offset, int length) throws GeneralSecurityException;
	public void update(ByteBuffer input) throws GeneralSecurityException;
}
