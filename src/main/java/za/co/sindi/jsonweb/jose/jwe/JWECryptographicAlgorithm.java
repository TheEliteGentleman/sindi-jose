/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwe;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;

import javax.crypto.Cipher;

import za.co.sindi.jsonweb.jose.jwa.AbstractCryptographicAlgorithm;

/**
 * @author Bienfait Sindi
 * @since 12 June 2017
 *
 */
public abstract class JWECryptographicAlgorithm extends AbstractCryptographicAlgorithm<JWEAlgorithm> {
	
	protected final Cipher CIPHER;

	/**
	 * @param algorithm
	 * @param provider
	 * @throws NoSuchAlgorithmException 
	 * @throws NoSuchProviderException 
	 */
	protected JWECryptographicAlgorithm(JWEAlgorithm algorithm) throws GeneralSecurityException {
		this(algorithm, (String)null);
	}
	
	/**
	 * @param algorithm
	 * @param provider
	 * @param miminumKeyLength
	 * @throws NoSuchAlgorithmException 
	 */
	protected JWECryptographicAlgorithm(JWEAlgorithm algorithm, final String provider) throws GeneralSecurityException {
		this(algorithm, Security.getProvider(provider));
	}
	
	/**
	 * @param algorithm
	 * @param provider
	 * @throws NoSuchAlgorithmException 
	 */
	protected JWECryptographicAlgorithm(JWEAlgorithm algorithm, Provider provider) throws GeneralSecurityException {
		super(algorithm);
		CIPHER = provider != null ? Cipher.getInstance(algorithm.getJcaAlgorithmName(), provider) : Cipher.getInstance(algorithm.getJcaAlgorithmName());
	}

//	protected void validateEncryptionKey(final Key key) {
//		PreConditions.checkArgument(key != null, "An encryption key is required.");
//	}
//	
//	protected void validateDecryptionKey(final Key key) {
//		PreConditions.checkArgument(key != null, "A decryption key is required.");
//	}
}
