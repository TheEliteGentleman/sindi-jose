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
public abstract class JWSCryptographicAlgorithm extends AbstractCryptographicAlgorithm<JWSAlgorithm> implements JWSComputationCryptographicAlgorithm, JWSVerificationCryptographicAlgorithm {
	
	/**
	 * @param algorithm
	 */
	protected JWSCryptographicAlgorithm(JWSAlgorithm algorithm) {
		super(algorithm);
	}
}
