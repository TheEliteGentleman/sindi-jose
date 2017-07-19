/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwe.impl;

import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.Provider;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.jose.jwe.AbstractJWECryptographicAlgorithm;
import za.co.sindi.jsonweb.jose.jwe.JWEAlgorithm;
import za.co.sindi.jsonweb.jose.jwe.JWEDecryptionCryptographicAlgorithm;
import za.co.sindi.jsonweb.jose.jwe.JWEEncryptionCryptographicAlgorithm;

/**
 * @author Bienfait Sindi
 * @since 12 July 2017
 *
 */
public abstract class JWEKeyEncryptionCryptographicAlgorithm extends AbstractJWECryptographicAlgorithm implements JWEEncryptionCryptographicAlgorithm, JWEDecryptionCryptographicAlgorithm {

	private final int MINIMUM_KEY_BIT_LENGTH = 2048;
	
	/**
	 * @param algorithm
	 * @throws GeneralSecurityException 
	 */
	protected JWEKeyEncryptionCryptographicAlgorithm(JWEAlgorithm algorithm) throws GeneralSecurityException {
		super(algorithm);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param algorithm
	 * @param provider
	 * @throws GeneralSecurityException
	 */
	public JWEKeyEncryptionCryptographicAlgorithm(JWEAlgorithm algorithm, Provider provider) throws GeneralSecurityException {
		super(algorithm, provider);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param algorithm
	 * @param provider
	 * @throws GeneralSecurityException
	 */
	public JWEKeyEncryptionCryptographicAlgorithm(JWEAlgorithm algorithm, String provider) throws GeneralSecurityException {
		super(algorithm, provider);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithm#validateEncryptionKey(java.security.Key)
	 */
//	@Override
	protected void validateEncryptionKey(Key key) {
		// TODO Auto-generated method stub
//		super.validateEncryptionKey(key);
		PreConditions.checkArgument(key != null, "An encryption key is required.");
		PreConditions.checkArgument(key instanceof RSAPrivateKey, "A RSA Private Key Signature key is required.");
		validateKeyLength(key);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithm#validateDecryptionKey(java.security.Key)
	 */
//	@Override
	protected void validateDecryptionKey(Key key) {
		// TODO Auto-generated method stub
//		super.validateDecryptionKey(key);
		PreConditions.checkArgument(key != null, "An encryption key is required.");
		PreConditions.checkArgument(key instanceof RSAPublicKey, "A RSA Public Key Signature key is required.");
		validateKeyLength(key);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithm#validateKey(java.security.Key, java.lang.Class)
	 */
	protected void validateKeyLength(Key key) {
		// TODO Auto-generated method stub
		PreConditions.checkState(key.getEncoded().length * 8 >= MINIMUM_KEY_BIT_LENGTH, "A key of size " + MINIMUM_KEY_BIT_LENGTH + " bits or larger MUST be used with these algorithms. Please see Section 4.2 and section 4.3 of the RFC 7518 - JWA Specification.");
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEEncryptionCryptographicAlgorithm#initEncrypt(java.security.Key)
	 */
	@Override
	public void initEncrypt(Key key) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		validateEncryptionKey(key);
		CIPHER.init(Cipher.ENCRYPT_MODE, key);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEEncryptionCryptographicAlgorithm#encrypt()
	 */
	@Override
	public byte[] encrypt() throws GeneralSecurityException {
		// TODO Auto-generated method stub
		return CIPHER.doFinal();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEDecryptionCryptographicAlgorithm#decrypt()
	 */
	@Override
	public byte[] decrypt() throws GeneralSecurityException {
		// TODO Auto-generated method stub
		return CIPHER.doFinal();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEDecryptionCryptographicAlgorithm#initDecrypt(java.security.Key)
	 */
	@Override
	public void initDecrypt(Key key) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		validateDecryptionKey(key);
		CIPHER.init(Cipher.DECRYPT_MODE, key);
	}
}
