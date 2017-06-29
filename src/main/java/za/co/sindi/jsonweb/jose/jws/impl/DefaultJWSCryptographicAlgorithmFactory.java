/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws.impl;

import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.jose.jwa.Algorithms;
import za.co.sindi.jsonweb.jose.jws.JWSAlgorithm;
import za.co.sindi.jsonweb.jose.jws.JWSCryptographicAlgorithm;
import za.co.sindi.jsonweb.jose.jws.JWSCryptographicAlgorithmFactory;
import za.co.sindi.jsonweb.jose.jws.impl.HMacSHAJWSCryptographicAlgorithm.HMacSHA256JWSCryptographicAlgorithm;
import za.co.sindi.jsonweb.jose.jws.impl.HMacSHAJWSCryptographicAlgorithm.HMacSHA384JWSCryptographicAlgorithm;
import za.co.sindi.jsonweb.jose.jws.impl.HMacSHAJWSCryptographicAlgorithm.HMacSHA512JWSCryptographicAlgorithm;
import za.co.sindi.jsonweb.jose.jws.impl.SHAwithRSAJWSCryptographicAlgorithm.SHA256withRSAJWSCryptographicAlgorithm;
import za.co.sindi.jsonweb.jose.jws.impl.SHAwithRSAJWSCryptographicAlgorithm.SHA384withRSAJWSCryptographicAlgorithm;
import za.co.sindi.jsonweb.jose.jws.impl.SHAwithRSAJWSCryptographicAlgorithm.SHA512withRSAJWSCryptographicAlgorithm;

/**
 * @author Bienfait Sindi
 * @since 19 June 2017
 * 
 */
public class DefaultJWSCryptographicAlgorithmFactory implements JWSCryptographicAlgorithmFactory {

	private static final Logger LOGGER = Logger.getLogger(DefaultJWSCryptographicAlgorithmFactory.class.getName());
	private static final Map<JWSAlgorithm, JWSCryptographicAlgorithm> JWS_SIGNATURES;
	
	static {
		Map<JWSAlgorithm, JWSCryptographicAlgorithm> jwsAlgorithms = new LinkedHashMap<>();
		try {
			jwsAlgorithms.put(JWSAlgorithm.HS256, new HMacSHA256JWSCryptographicAlgorithm());
			jwsAlgorithms.put(JWSAlgorithm.HS384, new HMacSHA384JWSCryptographicAlgorithm());
			jwsAlgorithms.put(JWSAlgorithm.HS512, new HMacSHA512JWSCryptographicAlgorithm());
			jwsAlgorithms.put(JWSAlgorithm.RS256, new SHA256withRSAJWSCryptographicAlgorithm());
			jwsAlgorithms.put(JWSAlgorithm.RS384, new SHA384withRSAJWSCryptographicAlgorithm());
			jwsAlgorithms.put(JWSAlgorithm.RS512, new SHA512withRSAJWSCryptographicAlgorithm());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			if (LOGGER.isLoggable(Level.SEVERE)) {
				LOGGER.log(Level.SEVERE, "Unable to initialize an instance of JWSCryptographicAlgorithmFactory.", e);
			}
			
			throw new InstantiationError("Unable to create class " + DefaultJWSCryptographicAlgorithmFactory.class.getName() + ". Please see the log file for more info.");
		}
		
		JWS_SIGNATURES = Collections.unmodifiableMap(jwsAlgorithms);
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSCryptographicAlgorithmFactory#newCryptographicAlgorithm(java.lang.String)
	 */
	@Override
	public JWSCryptographicAlgorithm newCryptographicAlgorithm(String jwaAlgorithmName) {
		// TODO Auto-generated method stub
		return newCryptographicAlgorithm((JWSAlgorithm)Algorithms.getAlgorithm(jwaAlgorithmName));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSCryptographicAlgorithmFactory#newCryptographicAlgorithm(za.co.sindi.jsonweb.jose.jws.JWSAlgorithm)
	 */
	@Override
	public JWSCryptographicAlgorithm newCryptographicAlgorithm(JWSAlgorithm algorithm) {
		// TODO Auto-generated method stub
		PreConditions.checkArgument(algorithm != null, "A JWS Algorithm type is required.");
		PreConditions.checkArgument(JWS_SIGNATURES.containsKey(algorithm), "No JWS Signature algorithm has been registered for JWS Algorithm '" + algorithm.getJwaAlgorithmName() + "'.");
		return JWS_SIGNATURES.get(algorithm);
	}
}
