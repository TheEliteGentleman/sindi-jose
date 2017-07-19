/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws;

import static za.co.sindi.jsonweb.util.Base64URLUtils.base64UrlEncode;

import java.security.GeneralSecurityException;
import java.security.Key;

import za.co.sindi.codec.exception.EncodingException;
import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.jose.jws.impl.DefaultJWSCryptographicAlgorithmFactory;

/**
 * @author Bienfait Sindi
 * @since 07 June 2017
 *
 */
public abstract class JWSSerialization {

	protected JWSCryptographicAlgorithmFactory jwsCryptographicAlgorithmFactory = new DefaultJWSCryptographicAlgorithmFactory();
	protected boolean payloadDetached = false;
	
	/**
	 * @param jwsCryptographicAlgorithmFactory the jwsCryptographicAlgorithmFactory to set
	 */
	public void setJwsCryptographicAlgorithmFactory(JWSCryptographicAlgorithmFactory jwsCryptographicAlgorithmFactory) {
		this.jwsCryptographicAlgorithmFactory = jwsCryptographicAlgorithmFactory;
	}
	
	/**
	 * @param payloadDetached the payloadDetached to set
	 */
	public void setPayloadDetached(boolean payloadDetached) {
		this.payloadDetached = payloadDetached;
	}


	protected byte[] generateJwsSignature(final byte[] jwsSigningInput, final Key key, final JWSAlgorithm jwsAlgorithm) throws EncodingException, GeneralSecurityException {
		PreConditions.checkArgument(jwsSigningInput != null && jwsSigningInput.length > 0, "No JWS Signing Input was specified.");
//		PreConditions.checkArgument(key != null, "No cryptographic key was specified.");
//		PreConditions.checkArgument(jwsAlgorithm != null, "No JWS Digital Signature Algorithm key was specified.");
//		PreConditions.checkState(jwsSignatureAlgorithmFactory != null, "No JWS Digital Signature factory was specified.");
		
		JWSComputationCryptographicAlgorithm jwsCryptographicAlgorithm = (JWSComputationCryptographicAlgorithm) jwsCryptographicAlgorithmFactory.newCryptographicAlgorithm(jwsAlgorithm);
		PreConditions.checkState(jwsCryptographicAlgorithm != null, "Couldn't find JWS Digital Signature algorithm for JWS Algorithm '" + jwsAlgorithm.getJwaAlgorithmName() + "'");
		jwsCryptographicAlgorithm.initSign(key);
		jwsCryptographicAlgorithm.update(jwsSigningInput);
		return base64UrlEncode(jwsCryptographicAlgorithm.compute());
	}
}
