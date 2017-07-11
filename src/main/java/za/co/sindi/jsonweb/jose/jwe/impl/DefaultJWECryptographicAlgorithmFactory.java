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
	private static final Map<JWEAlgorithm, JWECryptographicAlgorithm> JWE_SIGNATURES;
	
	static {
		Map<JWEAlgorithm, JWECryptographicAlgorithm> jwsAlgorithms = new LinkedHashMap<>();
		JWE_SIGNATURES = Collections.unmodifiableMap(jwsAlgorithms);
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
		PreConditions.checkArgument(JWE_SIGNATURES.containsKey(algorithm), "No JWE Encryption algorithm has been registered for JWE Algorithm '" + algorithm.getJwaAlgorithmName() + "'.");
		return JWE_SIGNATURES.get(algorithm);
	}
}
