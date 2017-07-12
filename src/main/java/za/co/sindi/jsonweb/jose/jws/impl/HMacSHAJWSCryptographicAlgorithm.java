/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws.impl;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.util.Arrays;

import javax.crypto.Mac;
import javax.crypto.SecretKey;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.jose.jws.JWSAlgorithm;
import za.co.sindi.jsonweb.jose.jws.JWSCryptographicAlgorithm;

/**
 * @author Bienfait Sindi
 * @since 12 June 2017
 *
 */
public abstract class HMacSHAJWSCryptographicAlgorithm extends JWSCryptographicAlgorithm {

	private final Mac MAC;
	private final int miminumKeyLength;

	/**
	 * @param algorithm
	 * @param provider
	 * @param miminumKeyLength
	 * @throws NoSuchAlgorithmException 
	 * @throws NoSuchProviderException 
	 */
	protected HMacSHAJWSCryptographicAlgorithm(JWSAlgorithm algorithm, final int miminumKeyLength) throws NoSuchAlgorithmException, NoSuchProviderException {
		this(algorithm, (Provider)null, miminumKeyLength);
	}
	
	/**
	 * @param algorithm
	 * @param provider
	 * @param miminumKeyLength
	 * @throws NoSuchAlgorithmException 
	 */
	protected HMacSHAJWSCryptographicAlgorithm(JWSAlgorithm algorithm, final String provider, final int miminumKeyLength) throws NoSuchAlgorithmException {
		this(algorithm, Security.getProvider(provider), miminumKeyLength);
	}
	
	/**
	 * @param algorithm
	 * @param provider
	 * @param miminumKeyLength
	 * @throws NoSuchAlgorithmException 
	 */
	protected HMacSHAJWSCryptographicAlgorithm(JWSAlgorithm algorithm, Provider provider, final int miminumKeyLength) throws NoSuchAlgorithmException {
		super(algorithm);
		MAC = provider != null ? Mac.getInstance(algorithm.getJcaAlgorithmName(), provider) : Mac.getInstance(algorithm.getJcaAlgorithmName());
		this.miminumKeyLength = miminumKeyLength;
	}
	
	private void validateKey(final Key key) {
		PreConditions.checkArgument(key != null, "A MAC key is required.");
		PreConditions.checkArgument(key instanceof SecretKey, "A MAC Secret key is required.");
		PreConditions.checkState(key.getEncoded().length * 8 >= miminumKeyLength, "A key of the same size as the hash output (for instance, 256 bits for \"HS256\") or larger MUST be used with this algorithm. Please see Section 3.2 of the RFC 7518 - JWA Specification.");
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwa.CryptographicAlgorithm#initSign(java.security.Key)
	 */
	@Override
	public void initSign(Key key) throws InvalidKeyException {
		// TODO Auto-generated method stub
		validateKey(key);
		MAC.init(key);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSVerificationAlgorithm#initVerify(java.security.Key)
	 */
	@Override
	public void initVerify(Key key) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		validateKey(key);
		MAC.init(key);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwa.CryptographicAlgorithm#update(byte[])
	 */
	@Override
	public void update(byte[] input) {
		// TODO Auto-generated method stub
		MAC.update(input);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwa.CryptographicAlgorithm#update(byte[], int, int)
	 */
	@Override
	public void update(byte[] input, int offset, int length) {
		// TODO Auto-generated method stub
		MAC.update(input, offset, length);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwa.CryptographicAlgorithm#update(java.nio.ByteBuffer)
	 */
	@Override
	public void update(ByteBuffer input) {
		// TODO Auto-generated method stub
		MAC.update(input);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwa.CryptographicAlgorithm#compute()
	 */
	@Override
	public byte[] compute() throws GeneralSecurityException {
		// TODO Auto-generated method stub
		return MAC.doFinal();
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSSignatureVerificationAlgorithm#verify(byte[])
	 */
	@Override
	public boolean verify(byte[] signature) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		byte[] sig = compute();
		return Arrays.equals(sig, signature);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSSignatureVerificationAlgorithm#verify(byte[], int, int)
	 */
	@Override
	public boolean verify(byte[] signature, int offset, int length) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		byte[] signatureCopy = new byte[length];
		System.arraycopy(signature, offset, signatureCopy, 0, length);
		return verify(signatureCopy);
	}

	public static final class HMacSHA256JWSCryptographicAlgorithm extends HMacSHAJWSCryptographicAlgorithm {

		/**
		 * @throws NoSuchAlgorithmException
		 */
		public HMacSHA256JWSCryptographicAlgorithm() throws NoSuchAlgorithmException {
			this((Provider)null);
			// TODO Auto-generated constructor stub
		}
		
		/**
		 * @param provider
		 * @throws NoSuchAlgorithmException
		 * @throws NoSuchProviderException 
		 */
		public HMacSHA256JWSCryptographicAlgorithm(final String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
			super(JWSAlgorithm.HS256, provider, 256);
			// TODO Auto-generated constructor stub
		}
		
		/**
		 * @param provider
		 * @throws NoSuchAlgorithmException
		 */
		public HMacSHA256JWSCryptographicAlgorithm(final Provider provider) throws NoSuchAlgorithmException {
			super(JWSAlgorithm.HS256, provider, 256);
			// TODO Auto-generated constructor stub
		}
	}
	
	public static final class HMacSHA384JWSCryptographicAlgorithm extends HMacSHAJWSCryptographicAlgorithm {

		/**
		 * @throws NoSuchAlgorithmException
		 */
		public HMacSHA384JWSCryptographicAlgorithm() throws NoSuchAlgorithmException {
			this(null);
			// TODO Auto-generated constructor stub
		}
		
		/**
		 * @param provider
		 * @throws NoSuchAlgorithmException
		 */
		public HMacSHA384JWSCryptographicAlgorithm(final Provider provider) throws NoSuchAlgorithmException {
			super(JWSAlgorithm.HS384, provider, 384);
			// TODO Auto-generated constructor stub
		}
	}
	
	public static final class HMacSHA512JWSCryptographicAlgorithm extends HMacSHAJWSCryptographicAlgorithm {

		/**
		 * @throws NoSuchAlgorithmException
		 */
		public HMacSHA512JWSCryptographicAlgorithm() throws NoSuchAlgorithmException {
			this(null);
			// TODO Auto-generated constructor stub
		}
		
		/**
		 * @param provider
		 * @throws NoSuchAlgorithmException
		 */
		public HMacSHA512JWSCryptographicAlgorithm(final Provider provider) throws NoSuchAlgorithmException {
			super(JWSAlgorithm.HS512, provider, 512);
			// TODO Auto-generated constructor stub
		}
	}
}
