/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwe.impl;

import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.Provider;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.jose.jwe.AbstractJWECryptographicAlgorithm;
import za.co.sindi.jsonweb.jose.jwe.JWEAlgorithm;
import za.co.sindi.jsonweb.jose.jwe.JWEUnwrappingCryptographicAlgorithm;
import za.co.sindi.jsonweb.jose.jwe.JWEWrappingCryptographicAlgorithm;

/**
 * @author Bienfait Sindi
 * @since 12 July 2017
 *
 */
public abstract class JWEKeyWrappingCryptographicAlgorithm extends AbstractJWECryptographicAlgorithm implements JWEWrappingCryptographicAlgorithm, JWEUnwrappingCryptographicAlgorithm {

	private int minimumKeyBitLength;

	/**
	 * @param algorithm
	 * @param minimumKeyBitLength
	 * @throws GeneralSecurityException
	 */
	protected JWEKeyWrappingCryptographicAlgorithm(JWEAlgorithm algorithm, int minimumKeyBitLength) throws GeneralSecurityException {
		super(algorithm);
		this.minimumKeyBitLength = minimumKeyBitLength;
	}

	/**
	 * @param algorithm
	 * @param provider
	 * @param minimumKeyBitLength
	 * @throws GeneralSecurityException
	 */
	protected JWEKeyWrappingCryptographicAlgorithm(JWEAlgorithm algorithm, String provider, int minimumKeyBitLength) throws GeneralSecurityException {
		super(algorithm, provider);
		this.minimumKeyBitLength = minimumKeyBitLength;
	}

	/**
	 * @param algorithm
	 * @param provider
	 * @param minimumKeyBitLength
	 * @throws GeneralSecurityException
	 */
	protected JWEKeyWrappingCryptographicAlgorithm(JWEAlgorithm algorithm, Provider provider, int minimumKeyBitLength) throws GeneralSecurityException {
		super(algorithm, provider);
		this.minimumKeyBitLength = minimumKeyBitLength;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithm#validateKey(java.security.Key, java.lang.Class)
	 */
	private void validateKey(Key key) {
		// TODO Auto-generated method stub
		PreConditions.checkArgument(key != null, "An encryption key is required.");
		PreConditions.checkArgument(key instanceof SecretKey, "A Secret key is required.");
		PreConditions.checkState(key.getEncoded().length * 8 >= minimumKeyBitLength, "A key of size " + minimumKeyBitLength + " bits or larger MUST be used with these algorithms. Please see Section 4.4 of the RFC 7518 - JWA Specification.");
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
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEWrappingCryptographicAlgorithm#wrap(java.security.Key)
	 */
	@Override
	public byte[] wrap(Key key) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		PreConditions.checkArgument(key != null, "A wrap key is required.");
		return CIPHER.wrap(key);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEUnwrappingCryptographicAlgorithm#unwrap(byte[])
	 */
	@Override
	public Key unwrap(byte[] wrappedKey) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		return CIPHER.unwrap(wrappedKey, getAlgorithm().getJcaAlgorithmName(), Cipher.SECRET_KEY);
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
