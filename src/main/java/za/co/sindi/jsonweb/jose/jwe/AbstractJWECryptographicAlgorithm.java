/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwe;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.ShortBufferException;

import za.co.sindi.jsonweb.jose.jwa.AbstractCryptographicAlgorithm;

/**
 * @author Bienfait Sindi
 * @since 12 June 2017
 *
 */
public abstract class AbstractJWECryptographicAlgorithm extends AbstractCryptographicAlgorithm<JWEAlgorithm> implements JWECryptographicAlgorithm {
	
	protected final Cipher CIPHER;

	/**
	 * @param algorithm
	 * @param provider
	 * @throws NoSuchAlgorithmException 
	 * @throws NoSuchProviderException 
	 */
	protected AbstractJWECryptographicAlgorithm(JWEAlgorithm algorithm) throws GeneralSecurityException {
		this(algorithm, (String)null);
	}
	
	/**
	 * @param algorithm
	 * @param provider
	 * @param miminumKeyLength
	 * @throws NoSuchAlgorithmException 
	 */
	protected AbstractJWECryptographicAlgorithm(JWEAlgorithm algorithm, final String provider) throws GeneralSecurityException {
		this(algorithm, Security.getProvider(provider));
	}
	
	/**
	 * @param algorithm
	 * @param provider
	 * @throws NoSuchAlgorithmException 
	 */
	protected AbstractJWECryptographicAlgorithm(JWEAlgorithm algorithm, Provider provider) throws GeneralSecurityException {
		super(algorithm);
		CIPHER = provider != null ? Cipher.getInstance(algorithm.getJcaAlgorithmName(), provider) : Cipher.getInstance(algorithm.getJcaAlgorithmName());
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithm#updateAAD(byte[])
	 */
	@Override
	public void updateAAD(byte[] src) {
		// TODO Auto-generated method stub
		CIPHER.updateAAD(src);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithm#updateAAD(byte[], int, int)
	 */
	@Override
	public void updateAAD(byte[] src, int offset, int length) {
		// TODO Auto-generated method stub
		CIPHER.updateAAD(src, offset, length);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithm#updateAAD(java.nio.ByteBuffer)
	 */
	@Override
	public void updateAAD(ByteBuffer src) {
		// TODO Auto-generated method stub
		CIPHER.updateAAD(src);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithm#update(byte[])
	 */
	@Override
	public byte[] update(byte[] input) {
		// TODO Auto-generated method stub
		return CIPHER.update(input);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithm#update(java.nio.ByteBuffer, java.nio.ByteBuffer)
	 */
	@Override
	public int update(ByteBuffer input, ByteBuffer output) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		return CIPHER.update(input, output);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithm#update(byte[], int, int)
	 */
	@Override
	public byte[] update(byte[] input, int offset, int length) {
		// TODO Auto-generated method stub
		return CIPHER.update(input, offset, length);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithm#update(byte[], int, int, byte[])
	 */
	@Override
	public int update(byte[] input, int offset, int length, byte[] output) throws ShortBufferException {
		// TODO Auto-generated method stub
		return CIPHER.update(input, offset, length, output);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithm#update(byte[], int, int, byte[], int)
	 */
	@Override
	public int update(byte[] input, int inputOffset, int inputLength, byte[] output, int outputOffset) throws ShortBufferException {
		// TODO Auto-generated method stub
		return CIPHER.update(input, inputOffset, inputLength, output, outputOffset);
	}
}
