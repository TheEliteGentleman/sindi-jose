/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwa;

/**
 * @author Bienfait Sindi
 * @since 12 June 2017
 * 
 */
public interface CryptographicAlgorithm<JWA extends Algorithm> {

	public JWA getAlgorithm();
}
