/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwe;

import za.co.sindi.jsonweb.Requirement;
import za.co.sindi.jsonweb.jose.jwa.Algorithm;
import za.co.sindi.jsonweb.jose.jwa.JWAConstants;

/**
 * @author Bienfait Sindi
 * @since 01 April 2016
 *
 */
public final class JWEAlgorithm extends Algorithm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6848042856959158673L;
	
	public static final JWEAlgorithm RSA1_5 = new JWEAlgorithm(JWAConstants.JWE_RSA1_5, JWAConstants.JWE_JCA_RSA1_5, "RSAES-PKCS1-v1_5", Requirement.RECOMMENDED);
	public static final JWEAlgorithm RSA_OAEP = new JWEAlgorithm(JWAConstants.JWE_RSA_OAEP, JWAConstants.JWE_JCA_RSA_OAEP, "RSAES OAEP using default parameters", Requirement.RECOMMENDED);
	public static final JWEAlgorithm RSA_OAEP_256 = new JWEAlgorithm(JWAConstants.JWE_RSA_OAEP_256, JWAConstants.JWE_JCA_RSA_OAEP_256, "RSAES OAEP using SHA-256 and MGF1 with SHA-256", Requirement.OPTIONAL);
	public static final JWEAlgorithm A128KW = new JWEAlgorithm(JWAConstants.JWE_A128KW, JWAConstants.JWE_JCA_A128KW, "AES Key Wrap with default initial value using 128-bit key", Requirement.RECOMMENDED);
	public static final JWEAlgorithm A192KW = new JWEAlgorithm(JWAConstants.JWE_A192KW, JWAConstants.JWE_JCA_A192KW, "AES Key Wrap with default initial value using 192-bit key", Requirement.OPTIONAL);
	public static final JWEAlgorithm A256KW = new JWEAlgorithm(JWAConstants.JWE_A256KW, JWAConstants.JWE_JCA_A256KW, "AES Key Wrap with default initial value using 256-bit key", Requirement.OPTIONAL);
	public static final JWEAlgorithm DIR = new JWEAlgorithm(JWAConstants.JWE_DIR, JWAConstants.JWE_JCA_DIR, "Direct use of a shared symmetric key as the CEK", Requirement.RECOMMENDED);
	public static final JWEAlgorithm ECDH_ES = new JWEAlgorithm(JWAConstants.JWE_ECDH_ES, JWAConstants.JWE_JCA_ECDH_ES, "Elliptic Curve Diffie-Hellman Ephemeral Static key agreement using Concat KDF", Requirement.RECOMMENDED);
	public static final JWEAlgorithm ECDH_ES_PLUS_A128KW = new JWEAlgorithm(JWAConstants.JWE_ECDH_ES_PLUS_A128KW, JWAConstants.JWE_JCA_ECDH_ES_PLUS_A128KW, "ECDH-ES using Concat KDF and CEK wrapped with \"A128KW\"", Requirement.RECOMMENDED);
	public static final JWEAlgorithm ECDH_ES_PLUS_A192KW = new JWEAlgorithm(JWAConstants.JWE_ECDH_ES_PLUS_A192KW, JWAConstants.JWE_JCA_ECDH_ES_PLUS_A192KW, "ECDH-ES using Concat KDF and CEK wrapped with \"A192KW\"", Requirement.OPTIONAL);
	public static final JWEAlgorithm ECDH_ES_PLUS_A256KW = new JWEAlgorithm(JWAConstants.JWE_ECDH_ES_PLUS_A256KW, JWAConstants.JWE_JCA_ECDH_ES_PLUS_A256KW, "ECDH-ES using Concat KDF and CEK wrapped with \"A256KW\"", Requirement.RECOMMENDED);
	public static final JWEAlgorithm A128GCMKW = new JWEAlgorithm(JWAConstants.JWE_A128GCMKW, JWAConstants.JWE_JCA_A128GCMKW, "Key wrapping with AES GCM using 128-bit key", Requirement.OPTIONAL);
	public static final JWEAlgorithm A192GCMKW = new JWEAlgorithm(JWAConstants.JWE_A192GCMKW, JWAConstants.JWE_JCA_A192GCMKW, "Key wrapping with AES GCM using 192-bit key", Requirement.OPTIONAL);
	public static final JWEAlgorithm A256GCMKW = new JWEAlgorithm(JWAConstants.JWE_A256GCMKW, JWAConstants.JWE_JCA_A256GCMKW, "Key wrapping with AES GCM using 256-bit key", Requirement.OPTIONAL);
	public static final JWEAlgorithm PBES2_HS256_PLUS_A128KW = new JWEAlgorithm(JWAConstants.JWE_PBES2_HS256_PLUS_A128KW, JWAConstants.JWE_JCA_PBES2_HS256_PLUS_A128KW, "PBES2 with HMAC SHA-256 and \"A128KW\" wrapping", Requirement.OPTIONAL);
	public static final JWEAlgorithm PBES2_HS384_PLUS_A192KW = new JWEAlgorithm(JWAConstants.JWE_PBES2_HS384_PLUS_A192KW, JWAConstants.JWE_JCA_PBES2_HS384_PLUS_A192KW, "PBES2 with HMAC SHA-256 and \"A192KW\" wrapping", Requirement.OPTIONAL);
	public static final JWEAlgorithm PBES2_HS512_PLUS_A256KW = new JWEAlgorithm(JWAConstants.JWE_PBES2_HS512_PLUS_A256KW, JWAConstants.JWE_JCA_PBES2_HS512_PLUS_A256KW, "PBES2 with HMAC SHA-256 and \"A256KW\" wrapping", Requirement.OPTIONAL);
	
	/**
	 * @param jwaAlgorithmName
	 * @param jcaAlgorithmName
	 * @param description
	 * @param implementationRequirement
	 */
	private JWEAlgorithm(String jwaAlgorithmName, String jcaAlgorithmName, String description, Requirement implementationRequirement) {
		super(jwaAlgorithmName, jcaAlgorithmName, description, implementationRequirement);
		// TODO Auto-generated constructor stub
	}
}
