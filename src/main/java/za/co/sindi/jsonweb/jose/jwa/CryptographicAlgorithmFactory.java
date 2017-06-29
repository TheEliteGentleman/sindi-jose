/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwa;

/**
 * @author Bienfait Sindi
 * @since 12 June 2017
 *
 */
public interface CryptographicAlgorithmFactory<JWA extends Algorithm> {

	public CryptographicAlgorithm<JWA> newCryptographicAlgorithm(final String jwaAlgorithmName);
	public CryptographicAlgorithm<JWA> newCryptographicAlgorithm(final JWA algorithm);
}
