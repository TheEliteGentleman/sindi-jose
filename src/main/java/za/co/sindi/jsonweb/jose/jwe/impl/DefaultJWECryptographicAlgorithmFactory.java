/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwe.impl;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.jose.jwa.Algorithms;
import za.co.sindi.jsonweb.jose.jwe.JWEAlgorithm;
import za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithm;
import za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithmFactory;

/**
 * @author Bienfait Sindi
 * @since 19 June 2017
 * 
 */
public class DefaultJWECryptographicAlgorithmFactory implements JWECryptographicAlgorithmFactory {

	private static final Logger LOGGER = Logger.getLogger(DefaultJWECryptographicAlgorithmFactory.class.getName());
	private static final Map<JWEAlgorithm, JWECryptographicAlgorithm> JWE_ALGORITHMS;
	
	static {
		Map<JWEAlgorithm, JWECryptographicAlgorithm> jweAlgorithms = new LinkedHashMap<>();
		JWE_ALGORITHMS = Collections.unmodifiableMap(jweAlgorithms);
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithmFactory#newCryptographicAlgorithm(java.lang.String)
	 */
	@Override
	public JWECryptographicAlgorithm newCryptographicAlgorithm(String jwaAlgorithmName) {
		// TODO Auto-generated method stub
		return newCryptographicAlgorithm((JWEAlgorithm)Algorithms.getAlgorithm(jwaAlgorithmName));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithmFactory#newCryptographicAlgorithm(za.co.sindi.jsonweb.jose.jws.JWSAlgorithm)
	 */
	@Override
	public JWECryptographicAlgorithm newCryptographicAlgorithm(JWEAlgorithm algorithm) {
		// TODO Auto-generated method stub
		PreConditions.checkArgument(algorithm != null, "A JWE Algorithm type is required.");
		PreConditions.checkArgument(JWE_ALGORITHMS.containsKey(algorithm), "No JWE Encryption algorithm has been registered for JWE Algorithm '" + algorithm.getJwaAlgorithmName() + "'.");
		return JWE_ALGORITHMS.get(algorithm);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithmFactory#newKeyEncryptionCryptographicAlgorithm(java.lang.String)
	 */
	@Override
	public JWEKeyEncryptionCryptographicAlgorithm newKeyEncryptionCryptographicAlgorithm(String jwaAlgorithmName) {
		// TODO Auto-generated method stub
		return (JWEKeyEncryptionCryptographicAlgorithm) newCryptographicAlgorithm(jwaAlgorithmName);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithmFactory#newKeyEncryptionCryptographicAlgorithm(za.co.sindi.jsonweb.jose.jwe.JWEAlgorithm)
	 */
	@Override
	public JWEKeyEncryptionCryptographicAlgorithm newKeyEncryptionCryptographicAlgorithm(JWEAlgorithm algorithm) {
		// TODO Auto-generated method stub
		return (JWEKeyEncryptionCryptographicAlgorithm) newCryptographicAlgorithm(algorithm);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithmFactory#newKeyWrappingCryptographicAlgorithm(java.lang.String)
	 */
	@Override
	public JWEKeyWrappingCryptographicAlgorithm newKeyWrappingCryptographicAlgorithm(String jwaAlgorithmName) {
		// TODO Auto-generated method stub
		return (JWEKeyWrappingCryptographicAlgorithm) newCryptographicAlgorithm(jwaAlgorithmName);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWECryptographicAlgorithmFactory#newKeyWrappingCryptographicAlgorithm(za.co.sindi.jsonweb.jose.jwe.JWEAlgorithm)
	 */
	@Override
	public JWEKeyWrappingCryptographicAlgorithm newKeyWrappingCryptographicAlgorithm(JWEAlgorithm algorithm) {
		// TODO Auto-generated method stub
		return (JWEKeyWrappingCryptographicAlgorithm) newCryptographicAlgorithm(algorithm);
	}
}
