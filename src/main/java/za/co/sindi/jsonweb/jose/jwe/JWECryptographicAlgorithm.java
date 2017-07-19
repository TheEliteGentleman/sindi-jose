/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwe;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

import javax.crypto.ShortBufferException;

import za.co.sindi.jsonweb.jose.jwa.CryptographicAlgorithm;

/**
 * @author Bienfait Sindi
 * @since 17 July 2017
 *
 */
public interface JWECryptographicAlgorithm extends CryptographicAlgorithm<JWEAlgorithm> {

	public void updateAAD(final byte[] src);
	public void updateAAD(final byte[] src, int offset, int length);
	public void updateAAD(final ByteBuffer src);
	public byte[] update(final byte[] input);
	public int update(ByteBuffer input, ByteBuffer output) throws GeneralSecurityException;
	public byte[] update(final byte[] input, int offset, int length);
	public int update(final byte[] input, int offset, int length, byte[] output) throws ShortBufferException;
	public int update(final byte[] input, int inputOffset, int inputLength, byte[] output, int outputOffset) throws ShortBufferException;
}
