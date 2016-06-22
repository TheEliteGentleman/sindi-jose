/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import za.co.sindi.jsonweb.jose.jwk.impl.JWKEllipticCurveKey;
import za.co.sindi.jsonweb.jose.jwk.impl.JWKRSAKey;
import za.co.sindi.jsonweb.jose.jwk.impl.JWKSymmetricKey;

/**
 * @author Bienfait Sindi
 * @since 16 May 2016
 *
 */
public final class JWKeys {

	private static final Map<KeyType, JWK> KEYS;
	
	static {
		Map<KeyType, JWK> keys = new HashMap<>();
		keys.put(KeyType.EC, new JWKEllipticCurveKey());
		keys.put(KeyType.OCT, new JWKSymmetricKey());
		keys.put(KeyType.RSA, new JWKRSAKey());
		KEYS = Collections.unmodifiableMap(keys);
	}
	
	private JWKeys() {
		throw new AssertionError("Private Constructor.");
	}
	
	public static JWK getJWK(final KeyType keyType) {
		return KEYS.get(keyType);
	}
}
