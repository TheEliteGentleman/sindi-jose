/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws;

import za.co.sindi.jsonweb.jose.jwa.CryptographicAlgorithmFactory;

/**
 * @author Bienfait Sindi
 * @since 19 June 2017
 *
 */
public interface JWSCryptographicAlgorithmFactory extends CryptographicAlgorithmFactory<JWSAlgorithm> {

	public JWSCryptographicAlgorithm newCryptographicAlgorithm(final String jwaAlgorithmName);
	public JWSCryptographicAlgorithm newCryptographicAlgorithm(final JWSAlgorithm algorithm);
}
