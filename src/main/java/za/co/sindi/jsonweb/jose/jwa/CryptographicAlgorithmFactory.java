/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwa;

/**
 * @author Bienfait Sindi
 * @since 12 June 2017
 *
 */
public interface CryptographicAlgorithmFactory<JWA extends Algorithm, CA extends CryptographicAlgorithm<JWA>> {

	public CA newCryptographicAlgorithm(final String jwaAlgorithmName);
	public CA newCryptographicAlgorithm(final JWA algorithm);
}
