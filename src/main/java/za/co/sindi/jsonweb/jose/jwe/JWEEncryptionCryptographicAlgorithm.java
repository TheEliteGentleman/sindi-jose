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
public interface JWEEncryptionCryptographicAlgorithm extends CryptographicAlgorithm<JWEAlgorithm> {

	public void initEncrypt(final Key key) throws GeneralSecurityException;
	public byte[] encrypt() throws GeneralSecurityException;
	public int update(ByteBuffer input, ByteBuffer output) throws GeneralSecurityException;
}
