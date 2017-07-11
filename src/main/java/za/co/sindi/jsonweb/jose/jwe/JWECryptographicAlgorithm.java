/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwe;

import za.co.sindi.jsonweb.jose.jwa.AbstractCryptographicAlgorithm;

/**
 * @author Bienfait Sindi
 * @since 12 June 2017
 *
 */
public abstract class JWECryptographicAlgorithm extends AbstractCryptographicAlgorithm<JWEAlgorithm> implements JWEEncryptionCryptographicAlgorithm, JWEDecryptionCryptographicAlgorithm {
	
	/**
	 * @param algorithm
	 */
	protected JWECryptographicAlgorithm(JWEAlgorithm algorithm) {
		super(algorithm);
	}
}
