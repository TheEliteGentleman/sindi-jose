/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws.impl;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.jose.jws.JWSAlgorithm;
import za.co.sindi.jsonweb.jose.jws.JWSSignatureCryptographicAlgorithm;

/**
 * @author Bienfait Sindi
 * @since 12 June 2017
 *
 */
public abstract class SHAwithRSAJWSCryptographicAlgorithm extends JWSSignatureCryptographicAlgorithm {

	private final int MINIMUM_KEY_BIT_LENGTH = 2048;

	/**
	 * @param algorithm
	 * @param provider
	 * @throws NoSuchAlgorithmException 
	 * @throws NoSuchProviderException 
	 */
	protected SHAwithRSAJWSCryptographicAlgorithm(JWSAlgorithm algorithm) throws NoSuchAlgorithmException, NoSuchProviderException {
		super(algorithm);
	}
	
	/**
	 * @param algorithm
	 * @param provider
	 * @param miminumKeyLength
	 * @throws NoSuchAlgorithmException 
	 */
	protected SHAwithRSAJWSCryptographicAlgorithm(JWSAlgorithm algorithm, final String provider) throws NoSuchAlgorithmException {
		super(algorithm, Security.getProvider(provider));
	}
	
	/**
	 * @param algorithm
	 * @param provider
	 * @throws NoSuchAlgorithmException 
	 */
	protected SHAwithRSAJWSCryptographicAlgorithm(JWSAlgorithm algorithm, Provider provider) throws NoSuchAlgorithmException {
		super(algorithm, provider);
	}
	
	@Override
	protected void validateKey(final Key key, Class<? extends Key> keyClass) {
		super.validateKey(key, keyClass);
//		PreConditions.checkArgument(key != null, "A Signature key is required.");
////		PreConditions.checkArgument(key instanceof PrivateKey, "A Signature Private key is required.");
//		PreConditions.checkArgument(keyClass.isInstance(key), "A Signature key is required of (" + keyClass.getSimpleName() + ").");
		PreConditions.checkState(key.getEncoded().length * 8 >= MINIMUM_KEY_BIT_LENGTH, "A key of size " + MINIMUM_KEY_BIT_LENGTH + " bits or larger MUST be used with these algorithms. Please see Section 3.2 of the RFC 7518 - JWA Specification.");
	}

	public static final class SHA256withRSAJWSCryptographicAlgorithm extends SHAwithRSAJWSCryptographicAlgorithm {

		/**
		 * @throws NoSuchAlgorithmException
		 */
		public SHA256withRSAJWSCryptographicAlgorithm() throws NoSuchAlgorithmException {
			this((Provider)null);
			// TODO Auto-generated constructor stub
		}
		
		/**
		 * @throws NoSuchAlgorithmException
		 */
		public SHA256withRSAJWSCryptographicAlgorithm(final String provider) throws NoSuchAlgorithmException {
			super(JWSAlgorithm.RS256, provider);
			// TODO Auto-generated constructor stub
		}
		
		/**
		 * @throws NoSuchAlgorithmException
		 */
		public SHA256withRSAJWSCryptographicAlgorithm(final Provider provider) throws NoSuchAlgorithmException {
			super(JWSAlgorithm.RS256, provider);
			// TODO Auto-generated constructor stub
		}
	}
	
	public static final class SHA384withRSAJWSCryptographicAlgorithm extends SHAwithRSAJWSCryptographicAlgorithm {

		/**
		 * @throws NoSuchAlgorithmException
		 */
		public SHA384withRSAJWSCryptographicAlgorithm() throws NoSuchAlgorithmException {
			this((Provider)null);
			// TODO Auto-generated constructor stub
		}
		
		/**
		 * @throws NoSuchAlgorithmException
		 */
		public SHA384withRSAJWSCryptographicAlgorithm(final String provider) throws NoSuchAlgorithmException {
			super(JWSAlgorithm.RS384, provider);
			// TODO Auto-generated constructor stub
		}
		
		/**
		 * @throws NoSuchAlgorithmException
		 */
		public SHA384withRSAJWSCryptographicAlgorithm(final Provider provider) throws NoSuchAlgorithmException {
			super(JWSAlgorithm.RS384, provider);
			// TODO Auto-generated constructor stub
		}
	}
	
	public static final class SHA512withRSAJWSCryptographicAlgorithm extends SHAwithRSAJWSCryptographicAlgorithm {

		/**
		 * @throws NoSuchAlgorithmException
		 */
		public SHA512withRSAJWSCryptographicAlgorithm() throws NoSuchAlgorithmException {
			this((Provider)null);
			// TODO Auto-generated constructor stub
		}
		
		/**
		 * @throws NoSuchAlgorithmException
		 */
		public SHA512withRSAJWSCryptographicAlgorithm(final String provider) throws NoSuchAlgorithmException {
			super(JWSAlgorithm.RS512, provider);
			// TODO Auto-generated constructor stub
		}
		
		/**
		 * @throws NoSuchAlgorithmException
		 */
		public SHA512withRSAJWSCryptographicAlgorithm(final Provider provider) throws NoSuchAlgorithmException {
			super(JWSAlgorithm.RS512, provider);
			// TODO Auto-generated constructor stub
		}
	}
}
