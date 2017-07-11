/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwe;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.Key;

import za.co.sindi.jsonweb.jose.jwa.CryptographicAlgorithm;

/**
 * @author Bienfait Sindi
 * @since 12 June 2017
 * 
 */
public interface JWEDecryptionCryptographicAlgorithm extends CryptographicAlgorithm<JWEAlgorithm> {

	public byte[] decrypt() throws GeneralSecurityException;
	public void initDecrypt(final Key key) throws GeneralSecurityException;
	public int update(ByteBuffer input, ByteBuffer output) throws GeneralSecurityException;
}
