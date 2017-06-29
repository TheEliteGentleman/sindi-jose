/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwa;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.common.utils.Strings;
import za.co.sindi.jsonweb.jose.jwe.EncryptionAlgorithm;
import za.co.sindi.jsonweb.jose.jwe.JWEAlgorithm;
import za.co.sindi.jsonweb.jose.jws.JWSAlgorithm;

/**
 * @author Bienfait Sindi
 * @since 28 March 2016
 *
 */
public class Algorithms {

	private static final Map<String, Algorithm> ALGORITHMS;
	
	static {
		Map<String, Algorithm> algorithms = new HashMap<String, Algorithm>();
		
		//JWE
		algorithms.put(JWAConstants.JWE_RSA1_5, JWEAlgorithm.RSA1_5);
		algorithms.put(JWAConstants.JWE_RSA_OAEP, JWEAlgorithm.RSA_OAEP);
		algorithms.put(JWAConstants.JWE_RSA_OAEP_256, JWEAlgorithm.RSA_OAEP_256);
		algorithms.put(JWAConstants.JWE_A128KW, JWEAlgorithm.A128KW);
		algorithms.put(JWAConstants.JWE_A192KW, JWEAlgorithm.A192KW);
		algorithms.put(JWAConstants.JWE_A256KW, JWEAlgorithm.A256KW);
		algorithms.put(JWAConstants.JWE_DIR, JWEAlgorithm.DIR);
		algorithms.put(JWAConstants.JWE_ECDH_ES, JWEAlgorithm.ECDH_ES);
		algorithms.put(JWAConstants.JWE_ECDH_ES_PLUS_A128KW, JWEAlgorithm.ECDH_ES_PLUS_A128KW);
		algorithms.put(JWAConstants.JWE_ECDH_ES_PLUS_A192KW, JWEAlgorithm.ECDH_ES_PLUS_A192KW);
		algorithms.put(JWAConstants.JWE_ECDH_ES_PLUS_A256KW, JWEAlgorithm.ECDH_ES_PLUS_A256KW);
		algorithms.put(JWAConstants.JWE_A128GCMKW, JWEAlgorithm.A128GCMKW);
		algorithms.put(JWAConstants.JWE_A192GCMKW, JWEAlgorithm.A192GCMKW);
		algorithms.put(JWAConstants.JWE_A256GCMKW, JWEAlgorithm.A256GCMKW);
		algorithms.put(JWAConstants.JWE_PBES2_HS256_PLUS_A128KW, JWEAlgorithm.PBES2_HS256_PLUS_A128KW);
		algorithms.put(JWAConstants.JWE_PBES2_HS384_PLUS_A192KW, JWEAlgorithm.PBES2_HS384_PLUS_A192KW);
		algorithms.put(JWAConstants.JWE_PBES2_HS512_PLUS_A256KW, JWEAlgorithm.PBES2_HS512_PLUS_A256KW);

		//JWE Encryption
		algorithms.put(JWAConstants.JWE_ENC_A128CBC_HS256, EncryptionAlgorithm.A128CBC_HS256);
		algorithms.put(JWAConstants.JWE_ENC_A192CBC_HS384, EncryptionAlgorithm.A192CBC_HS384);
		algorithms.put(JWAConstants.JWE_ENC_A256CBC_HS512, EncryptionAlgorithm.A256CBC_HS512);
		algorithms.put(JWAConstants.JWE_ENC_A128GCM, EncryptionAlgorithm.A128GCM);
		algorithms.put(JWAConstants.JWE_ENC_A192GCM, EncryptionAlgorithm.A192GCM);
		algorithms.put(JWAConstants.JWE_ENC_A256GCM, EncryptionAlgorithm.A256GCM);
		
		//JWS
		algorithms.put(JWAConstants.JWS_HMAC_SHA_256, JWSAlgorithm.HS256);
		algorithms.put(JWAConstants.JWS_HMAC_SHA_384, JWSAlgorithm.HS384);
		algorithms.put(JWAConstants.JWS_HMAC_SHA_512, JWSAlgorithm.HS512);
		algorithms.put(JWAConstants.JWS_RSA_SHA_256, JWSAlgorithm.RS256);
		algorithms.put(JWAConstants.JWS_RSA_SHA_384, JWSAlgorithm.RS384);
		algorithms.put(JWAConstants.JWS_RSA_SHA_512, JWSAlgorithm.RS512);
		algorithms.put(JWAConstants.JWS_ECDSA_SHA_256, JWSAlgorithm.ES256);
		algorithms.put(JWAConstants.JWS_ECDSA_SHA_384, JWSAlgorithm.ES384);
		algorithms.put(JWAConstants.JWS_ECDSA_SHA_512, JWSAlgorithm.ES512);
		algorithms.put(JWAConstants.JWS_PSS_SHA_256, JWSAlgorithm.PS256);
		algorithms.put(JWAConstants.JWS_PSS_SHA_384, JWSAlgorithm.PS384);
		algorithms.put(JWAConstants.JWS_PSS_SHA_512, JWSAlgorithm.PS512);
		algorithms.put(JWAConstants.JWS_NONE, JWSAlgorithm.NONE);
		
		ALGORITHMS = Collections.unmodifiableMap(algorithms);
	}
	
	private Algorithms() {
		throw new AssertionError("Private Constructor.");
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Algorithm> T getAlgorithm(final String jwaAlgorithmName) {
		PreConditions.checkArgument(!Strings.isNullOrEmpty(jwaAlgorithmName), "No JWA Algorithm name was provided.");
		PreConditions.checkArgument(ALGORITHMS.containsKey(jwaAlgorithmName), "Algorithm name '" + jwaAlgorithmName + "' does not exist.");
		return (T) ALGORITHMS.get(jwaAlgorithmName);
	}
}
