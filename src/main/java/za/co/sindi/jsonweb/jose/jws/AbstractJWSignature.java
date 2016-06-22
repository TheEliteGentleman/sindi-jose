/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws;

import java.security.Signature;
import java.security.SignatureException;

import za.co.sindi.common.utils.PreConditions;

/**
 * @author Bienfait Sindi
 * @since 05 April 2016
 *
 */
public abstract class AbstractJWSignature implements JWSignature {

	private static final String SIGNATURE_NOT_INITIALIZED = "Signature not initialized";
	
	private JWSAlgorithm algorithm;
	private Signature signature;
	
	/**
	 * @param algorithm
	 * @throws JWSignatureException 
	 */
	protected AbstractJWSignature(JWSAlgorithm algorithm) throws JWSignatureException {
		super();
		PreConditions.checkArgument(algorithm != null, "No JWS algorithm was specified.");
		this.algorithm = algorithm;
		signature = initializeSignature();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSignature#getAlgorithm()
	 */
	public JWSAlgorithm getAlgorithm() {
		// TODO Auto-generated method stub
		return algorithm;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSignature#update(byte[])
	 */
	public void update(byte[] data) throws JWSignatureException {
		// TODO Auto-generated method stub
		update(data, 0, data.length);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSignature#update(byte[], int, int)
	 */
	public void update(byte[] data, int offset, int length) throws JWSignatureException {
		// TODO Auto-generated method stub
		PreConditions.checkArgument(signature != null, SIGNATURE_NOT_INITIALIZED);
		try {
			signature.update(data, offset, length);
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			throw new JWSignatureException(e);
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSignature#sign()
	 */
	public byte[] sign() throws JWSignatureException {
		// TODO Auto-generated method stub
		PreConditions.checkArgument(signature != null, SIGNATURE_NOT_INITIALIZED);
		try {
			return signature.sign();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			throw new JWSignatureException(e);
		}
	}
	
	protected abstract Signature initializeSignature() throws JWSignatureException;
}
