/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws;

import za.co.sindi.jsonweb.jose.jwa.AbstractCryptographicAlgorithm;

/**
 * @author Bienfait Sindi
 * @since 12 June 2017
 *
 */
public abstract class AbstractJWSCryptographicAlgorithm extends AbstractCryptographicAlgorithm<JWSAlgorithm> implements JWSCryptographicAlgorithm, JWSComputationCryptographicAlgorithm, JWSVerificationCryptographicAlgorithm {
	
	/**
	 * @param algorithm
	 */
	protected AbstractJWSCryptographicAlgorithm(JWSAlgorithm algorithm) {
		super(algorithm);
	}
}
