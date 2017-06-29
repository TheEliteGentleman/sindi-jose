/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws;

import za.co.sindi.jsonweb.Requirement;
import za.co.sindi.jsonweb.jose.jwa.Algorithm;
import za.co.sindi.jsonweb.jose.jwa.JWAConstants;

/**
 * @author Bienfait Sindi
 * @since 01 April 2016
 *
 */
public final class JWSAlgorithm extends Algorithm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9132874524669455609L;
	
	public static final JWSAlgorithm HS256 = new JWSAlgorithm(JWAConstants.JWS_HMAC_SHA_256, JWAConstants.JWS_JCA_HMAC_SHA_256, "HMAC using SHA-256", Requirement.REQUIRED);
	public static final JWSAlgorithm HS384 = new JWSAlgorithm(JWAConstants.JWS_HMAC_SHA_384, JWAConstants.JWS_JCA_HMAC_SHA_384, "HMAC using SHA-384", Requirement.OPTIONAL);
	public static final JWSAlgorithm HS512 = new JWSAlgorithm(JWAConstants.JWS_HMAC_SHA_512, JWAConstants.JWS_JCA_HMAC_SHA_512, "HMAC using SHA-512", Requirement.OPTIONAL);
	public static final JWSAlgorithm RS256 = new JWSAlgorithm(JWAConstants.JWS_RSA_SHA_256, JWAConstants.JWS_JCA_RSA_SHA_256, "RSASSA-PKCS1-v1_5 using SHA-256", Requirement.RECOMMENDED);
	public static final JWSAlgorithm RS384 = new JWSAlgorithm(JWAConstants.JWS_RSA_SHA_384, JWAConstants.JWS_JCA_RSA_SHA_384, "RSASSA-PKCS1-v1_5 using SHA-384", Requirement.OPTIONAL);
	public static final JWSAlgorithm RS512 = new JWSAlgorithm(JWAConstants.JWS_RSA_SHA_512, JWAConstants.JWS_JCA_RSA_SHA_512, "RSASSA-PKCS1-v1_5 using SHA-512", Requirement.OPTIONAL);
	public static final JWSAlgorithm ES256 = new JWSAlgorithm(JWAConstants.JWS_ECDSA_SHA_256, JWAConstants.JWS_JCA_ECDSA_SHA_256, "ECDSA using P-256 and SHA-256", Requirement.RECOMMENDED);
	public static final JWSAlgorithm ES384 = new JWSAlgorithm(JWAConstants.JWS_ECDSA_SHA_384, JWAConstants.JWS_JCA_ECDSA_SHA_384, "ECDSA using P-384 and SHA-384", Requirement.OPTIONAL);
	public static final JWSAlgorithm ES512 = new JWSAlgorithm(JWAConstants.JWS_ECDSA_SHA_512, JWAConstants.JWS_JCA_ECDSA_SHA_512, "ECDSA using P-512 and SHA-512", Requirement.OPTIONAL);
	public static final JWSAlgorithm PS256 = new JWSAlgorithm(JWAConstants.JWS_PSS_SHA_256, JWAConstants.JWS_JCA_PSS_SHA_256, "RSASSA-PSS using SHA-256 and MGF1 with SHA-256", Requirement.OPTIONAL);
	public static final JWSAlgorithm PS384 = new JWSAlgorithm(JWAConstants.JWS_PSS_SHA_384, JWAConstants.JWS_JCA_PSS_SHA_384, "RSASSA-PSS using SHA-384 and MGF1 with SHA-384", Requirement.OPTIONAL);
	public static final JWSAlgorithm PS512 = new JWSAlgorithm(JWAConstants.JWS_PSS_SHA_512, JWAConstants.JWS_JCA_PSS_SHA_512, "RSASSA-PSS using SHA-512 and MGF1 with SHA-512", Requirement.OPTIONAL);
	public static final JWSAlgorithm NONE = new JWSAlgorithm(JWAConstants.JWS_NONE, JWAConstants.JWS_JCA_NONE, "No digital signature or MAC performed", Requirement.OPTIONAL);
	
	/**
	 * @param jwaAlgorithmName
	 * @param jcaAlgorithmName
	 * @param description
	 * @param implementationRequirement
	 */
	private JWSAlgorithm(String jwaAlgorithmName, String jcaAlgorithmName, String description, Requirement implementationRequirement) {
		super(jwaAlgorithmName, jcaAlgorithmName, description, implementationRequirement);
		// TODO Auto-generated constructor stub
	}
}
