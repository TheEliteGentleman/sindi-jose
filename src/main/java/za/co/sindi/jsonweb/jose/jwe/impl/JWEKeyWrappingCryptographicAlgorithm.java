/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwe.impl;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.Provider;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.jose.jwe.JWEAlgorithm;
import za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithm;
import za.co.sindi.jsonweb.jose.jwe.JWEUnwrappingCryptographicAlgorithm;
import za.co.sindi.jsonweb.jose.jwe.JWEWrappingCryptographicAlgorithm;

/**
 * @author Bienfait Sindi
 * @since 12 July 2017
 *
 */
public abstract class JWEKeyWrappingCryptographicAlgorithm extends JWECryptographicAlgorithm implements JWEWrappingCryptographicAlgorithm, JWEUnwrappingCryptographicAlgorithm {

	private final int MINIMUM_KEY_BIT_LENGTH = 2048;
	
	/**
	 * @param algorithm
	 * @throws GeneralSecurityException 
	 */
	protected JWEKeyWrappingCryptographicAlgorithm(JWEAlgorithm algorithm) throws GeneralSecurityException {
		super(algorithm);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param algorithm
	 * @param provider
	 * @throws GeneralSecurityException
	 */
	public JWEKeyWrappingCryptographicAlgorithm(JWEAlgorithm algorithm, Provider provider) throws GeneralSecurityException {
		super(algorithm, provider);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param algorithm
	 * @param provider
	 * @throws GeneralSecurityException
	 */
	public JWEKeyWrappingCryptographicAlgorithm(JWEAlgorithm algorithm, String provider) throws GeneralSecurityException {
		super(algorithm, provider);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithm#validateKey(java.security.Key, java.lang.Class)
	 */
	private void validateKey(Key key) {
		// TODO Auto-generated method stub
		PreConditions.checkArgument(key != null, "An encryption key is required.");
		PreConditions.checkArgument(key instanceof SecretKey, "A Secret key is required.");
		PreConditions.checkState(key.getEncoded().length * 8 >= MINIMUM_KEY_BIT_LENGTH, "A key of size " + MINIMUM_KEY_BIT_LENGTH + " bits or larger MUST be used with these algorithms. Please see Section 4.2 and section 4.3 of the RFC 7518 - JWA Specification.");
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEWrappingCryptographicAlgorithm#initWrap(java.security.Key)
	 */
	@Override
	public void initWrap(Key key) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		validateKey(key);
		CIPHER.init(Cipher.WRAP_MODE, key);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEWrappingCryptographicAlgorithm#wrap()
	 */
	@Override
	public byte[] wrap() throws GeneralSecurityException {
		// TODO Auto-generated method stub
		return CIPHER.doFinal();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEEncryptionCryptographicAlgorithm#update(java.nio.ByteBuffer, java.nio.ByteBuffer)
	 */
	@Override
	public int update(ByteBuffer input, ByteBuffer output) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		return CIPHER.update(input, output);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwa.CryptographicAlgorithm#update(byte[])
	 */
	@Override
	public void update(byte[] input) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		CIPHER.update(input);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwa.CryptographicAlgorithm#update(byte[], int, int)
	 */
	@Override
	public void update(byte[] input, int offset, int length) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		CIPHER.update(input, offset, length);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEUnwrappingCryptographicAlgorithm#unwrap()
	 */
	@Override
	public byte[] unwrap() throws GeneralSecurityException {
		// TODO Auto-generated method stub
		return CIPHER.doFinal();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEUnwrappingCryptographicAlgorithm#initUnwrap(java.security.Key)
	 */
	@Override
	public void initUnwrap(Key key) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		validateKey(key);
		CIPHER.init(Cipher.UNWRAP_MODE, key);
	}
}
