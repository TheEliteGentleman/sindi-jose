/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwe;

import za.co.sindi.jsonweb.jose.jwa.CryptographicAlgorithmFactory;

/**
 * @author Bienfait Sindi
 * @since 19 June 2017
 *
 */
public interface JWECryptographicAlgorithmFactory extends CryptographicAlgorithmFactory<JWEAlgorithm> {

	public JWECryptographicAlgorithm newCryptographicAlgorithm(final String jwaAlgorithmName);
	public JWECryptographicAlgorithm newCryptographicAlgorithm(final JWEAlgorithm algorithm);
}
