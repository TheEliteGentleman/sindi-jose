/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwe;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;

import javax.crypto.Cipher;

import za.co.sindi.common.utils.PreConditions;

/**
 * @author Bienfait Sindi
 * @since 12 June 2017
 *
 */
public abstract class JWECipherCryptographicAlgorithm extends JWECryptographicAlgorithm {

	private final Cipher CIPHER;

	/**
	 * @param algorithm
	 * @param provider
	 * @throws NoSuchAlgorithmException 
	 * @throws NoSuchProviderException 
	 */
	protected JWECipherCryptographicAlgorithm(JWEAlgorithm algorithm) throws GeneralSecurityException {
		this(algorithm, (String)null);
	}
	
	/**
	 * @param algorithm
	 * @param provider
	 * @param miminumKeyLength
	 * @throws NoSuchAlgorithmException 
	 */
	protected JWECipherCryptographicAlgorithm(JWEAlgorithm algorithm, final String provider) throws GeneralSecurityException {
		this(algorithm, Security.getProvider(provider));
	}
	
	/**
	 * @param algorithm
	 * @param provider
	 * @throws NoSuchAlgorithmException 
	 */
	protected JWECipherCryptographicAlgorithm(JWEAlgorithm algorithm, Provider provider) throws GeneralSecurityException {
		super(algorithm);
		CIPHER = provider != null ? Cipher.getInstance(algorithm.getJcaAlgorithmName(), provider) : Cipher.getInstance(algorithm.getJcaAlgorithmName());
	}
	
	protected void validateKey(final Key key, Class<? extends Key> keyClass) {
		PreConditions.checkArgument(key != null, "A Cipher key is required.");
		PreConditions.checkArgument(keyClass.isInstance(key), "A Cipher key is required of (" + keyClass.getSimpleName() + ").");
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEEncryptionCryptographicAlgorithm#initEncrypt(java.security.Key)
	 */
	@Override
	public void initEncrypt(Key key) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		validateKey(key, PrivateKey.class);
		CIPHER.init(Cipher.ENCRYPT_MODE, (PrivateKey) key);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEDecryptionCryptographicAlgorithm#initDecrypt(java.security.Key)
	 */
	@Override
	public void initDecrypt(Key key) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		validateKey(key, PublicKey.class);
		CIPHER.init(Cipher.DECRYPT_MODE, (PublicKey) key);
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
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEEncryptionCryptographicAlgorithm#update(java.nio.ByteBuffer, java.nio.ByteBuffer)
	 */
	@Override
	public int update(ByteBuffer input, ByteBuffer output) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		return CIPHER.update(input, output);
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
}
