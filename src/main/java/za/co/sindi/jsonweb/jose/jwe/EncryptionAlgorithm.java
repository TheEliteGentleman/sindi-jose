/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwe;

import za.co.sindi.jsonweb.Requirement;
import za.co.sindi.jsonweb.jose.jwa.Algorithm;
import za.co.sindi.jsonweb.jose.jwa.JWAConstants;

/**
 * @author Bienfait Sindi
 * @since 16 May 2016
 *
 */
public class EncryptionAlgorithm extends Algorithm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8312909039684040487L;
	
	public static final EncryptionAlgorithm A128CBC_HS256 = new EncryptionAlgorithm(JWAConstants.JWE_ENC_A128CBC_HS256, JWEConstants.JWE_JCA_A128CBC_HS256, "AES_128_CBC_HMAC_SHA_256 authenticated encryption algorithm, as defined in Section 5.2.3", Requirement.REQUIRED);
	public static final EncryptionAlgorithm A192CBC_HS384 = new EncryptionAlgorithm(JWAConstants.JWE_ENC_A192CBC_HS384, JWEConstants.JWE_JCA_A192CBC_HS384, "AES_192_CBC_HMAC_SHA_384 authenticated encryption algorithm, as defined in Section 5.2.4", Requirement.OPTIONAL);
	public static final EncryptionAlgorithm A256CBC_HS512 = new EncryptionAlgorithm(JWAConstants.JWE_ENC_A256CBC_HS512, JWEConstants.JWE_JCA_A256CBC_HS512, "AES_256_CBC_HMAC_SHA_512 authenticated encryption algorithm, as defined in Section 5.2.5", Requirement.REQUIRED);
	public static final EncryptionAlgorithm A128GCM = new EncryptionAlgorithm(JWAConstants.JWE_ENC_A128GCM, JWEConstants.JWE_JCA_A128GCM, "AES GCM using 128-bit key", Requirement.RECOMMENDED);
	public static final EncryptionAlgorithm A192GCM = new EncryptionAlgorithm(JWAConstants.JWE_ENC_A192GCM, JWEConstants.JWE_JCA_A192GCM, "AES GCM using 192-bit key", Requirement.OPTIONAL);
	public static final EncryptionAlgorithm A256GCM = new EncryptionAlgorithm(JWAConstants.JWE_ENC_A256GCM, JWEConstants.JWE_JCA_A256GCM, "AES GCM using 256-bit key", Requirement.RECOMMENDED);
	
	/**
	 * @param jwaAlgorithmName
	 * @param jcaAlgorithmName
	 * @param description
	 * @param implementationRequirement
	 */
	private EncryptionAlgorithm(String jwaAlgorithmName, String jcaAlgorithmName, String description, Requirement implementationRequirement) {
		super(jwaAlgorithmName, jcaAlgorithmName, description, implementationRequirement);
		// TODO Auto-generated constructor stub
	}
}
