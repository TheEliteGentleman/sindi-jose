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

	public void initDecrypt(final Key key) throws GeneralSecurityException;
	public byte[] decrypt(final byte[] encryptedData) throws GeneralSecurityException;
	public byte[] decrypt(final byte[] encryptedData, int offset, int length) throws GeneralSecurityException;
	public int update(ByteBuffer input, ByteBuffer output) throws GeneralSecurityException;
}
