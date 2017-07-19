/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;

import za.co.sindi.common.utils.PreConditions;

/**
 * @author Bienfait Sindi
 * @since 12 June 2017
 *
 */
public abstract class JWSSignatureCryptographicAlgorithm extends AbstractJWSCryptographicAlgorithm {

	private final Signature SIGNATURE;

	/**
	 * @param algorithm
	 * @param provider
	 * @throws NoSuchAlgorithmException 
	 * @throws NoSuchProviderException 
	 */
	protected JWSSignatureCryptographicAlgorithm(JWSAlgorithm algorithm) throws NoSuchAlgorithmException, NoSuchProviderException {
		this(algorithm, (String)null);
	}
	
	/**
	 * @param algorithm
	 * @param provider
	 * @param miminumKeyLength
	 * @throws NoSuchAlgorithmException 
	 */
	protected JWSSignatureCryptographicAlgorithm(JWSAlgorithm algorithm, final String provider) throws NoSuchAlgorithmException {
		this(algorithm, Security.getProvider(provider));
	}
	
	/**
	 * @param algorithm
	 * @param provider
	 * @throws NoSuchAlgorithmException 
	 */
	protected JWSSignatureCryptographicAlgorithm(JWSAlgorithm algorithm, Provider provider) throws NoSuchAlgorithmException {
		super(algorithm);
		SIGNATURE = provider != null ? Signature.getInstance(algorithm.getJcaAlgorithmName(), provider) : Signature.getInstance(algorithm.getJcaAlgorithmName());
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSCryptographicAlgorithm#validateSignatureKey(java.security.Key)
	 */
//	@Override
	protected void validateSignatureKey(Key key) {
		// TODO Auto-generated method stub
		PreConditions.checkArgument(key != null, "A Signature key is required.");
		PreConditions.checkArgument(key instanceof PrivateKey, "A Private Key Signature is required.");
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSCryptographicAlgorithm#validateVerificationKey(java.security.Key)
	 */
//	@Override
	protected void validateVerificationKey(Key key) {
		// TODO Auto-generated method stub
		PreConditions.checkArgument(key != null, "A Signature key is required.");
		PreConditions.checkArgument(key instanceof PublicKey, "A Public Key Signature key is required.");
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwa.CryptographicAlgorithm#initSign(java.security.Key)
	 */
	@Override
	public void initSign(Key key) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		validateSignatureKey(key);
		SIGNATURE.initSign((PrivateKey) key);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSSignatureAlgorithm#initVerify(java.security.Key)
	 */
	@Override
	public void initVerify(Key key) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		validateVerificationKey(key);
		SIGNATURE.initVerify((PublicKey) key);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwa.CryptographicAlgorithm#update(byte[])
	 */
	@Override
	public void update(byte[] input) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		SIGNATURE.update(input);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwa.CryptographicAlgorithm#update(byte[], int, int)
	 */
	@Override
	public void update(byte[] input, int offset, int length) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		SIGNATURE.update(input, offset, length);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwa.CryptographicAlgorithm#update(java.nio.ByteBuffer)
	 */
	@Override
	public void update(ByteBuffer input) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		SIGNATURE.update(input);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwa.CryptographicAlgorithm#compute()
	 */
	@Override
	public byte[] compute() throws GeneralSecurityException {
		// TODO Auto-generated method stub
		return SIGNATURE.sign();
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSSignatureVerificationAlgorithm#verify(byte[])
	 */
	@Override
	public boolean verify(byte[] signature) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		return SIGNATURE.verify(signature);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSSignatureVerificationAlgorithm#verify(byte[], int, int)
	 */
	@Override
	public boolean verify(byte[] signature, int offset, int length) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		return SIGNATURE.verify(signature, offset, length);
	}
}
