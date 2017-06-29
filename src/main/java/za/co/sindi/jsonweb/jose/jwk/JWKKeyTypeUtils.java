/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

import za.co.sindi.jsonweb.jose.JOSE;

/**
 * @author Bienfait Sindi
 * @since 25 May 2017
 *
 */
public final class JWKKeyTypeUtils {

	private JWKKeyTypeUtils() {
		throw new AssertionError("Private Constructor.");
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends JWK, B extends JWKObjectBuilder<T, B>> JWKObjectBuilder<T, B> getJWKObjectBuilder(final KeyType keyType) {
		if (keyType == KeyType.EC) {
			return (JWKObjectBuilder<T, B>) JOSE.createEllipticCurveJWKObjectBuilder();
		}
		
		if (keyType == KeyType.OCT) {
			return (JWKObjectBuilder<T, B>) JOSE.createSymmetricJWKObjectBuilder();
		}
		
		if (keyType == KeyType.RSA) {
			return (JWKObjectBuilder<T, B>) JOSE.createRSAJWKObjectBuilder();
		}
		
		throw new IllegalArgumentException("Unknown JWK \"keys\" " + keyType + ".");
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends JWK> JWKObjectReader<T> getJWKObjectReader(final KeyType keyType) {
		if (keyType == KeyType.EC) {
			return (JWKObjectReader<T>) JOSE.createEllipticCurveJWKObjectReader();
		}
		
		if (keyType == KeyType.OCT) {
			return (JWKObjectReader<T>) JOSE.createSymmetricJWKObjectBuilder();
		}
		
		if (keyType == KeyType.RSA) {
			return (JWKObjectReader<T>) JOSE.createRSAJWKObjectBuilder();
		}
		
		throw new IllegalArgumentException("Unknown JWK \"keys\" " + keyType + ".");
	}
}
