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
	protected boolean payloadDetached;
	
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

	/**
	 * @return the payloadDetached
	 */
	public boolean isPayloadDetached() {
		return payloadDetached;
	}
	
//	protected byte[] encodeJwsJoseHeader(final JWSJOSEHeader jwsJOSEHeader) throws EncodingException {
////		PreConditions.checkArgument(jwsJOSEHeader != null, "No JWS JOSE Header was specified.");
//		return base64UrlEncode(toUTF8Bytes(jwsJOSEHeader.toString()));
//	}
//	
//	protected byte[] encodeJwsPayload(final JWSPayload jwsPayload) throws EncodingException {
////		PreConditions.checkArgument(jwsPayload != null, "No JWS Payload was specified.");
//		return base64UrlEncode(jwsPayload.getEncoded());
//	}

	protected byte[] generateJwsSignature(final byte[] jwsSigningInput, final Key key, final JWSAlgorithm jwsAlgorithm) throws EncodingException, GeneralSecurityException {
		PreConditions.checkArgument(jwsSigningInput != null && jwsSigningInput.length > 0, "No JWS Signing Input was specified.");
//		PreConditions.checkArgument(key != null, "No cryptographic key was specified.");
//		PreConditions.checkArgument(jwsAlgorithm != null, "No JWS Digital Signature Algorithm key was specified.");
//		PreConditions.checkState(jwsSignatureAlgorithmFactory != null, "No JWS Digital Signature factory was specified.");
		
		JWSComputationCryptographicAlgorithm jwsCryptographicAlgorithm = jwsCryptographicAlgorithmFactory.newCryptographicAlgorithm(jwsAlgorithm);
		PreConditions.checkState(jwsCryptographicAlgorithm != null, "Couldn't find JWS Digital Signature algorithm for JWS Algorithm '" + jwsAlgorithm.getJwaAlgorithmName() + "'");
		jwsCryptographicAlgorithm.initSign(key);
		jwsCryptographicAlgorithm.update(jwsSigningInput);
		return base64UrlEncode(jwsCryptographicAlgorithm.compute());
	}
}
