/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws.impl;

import java.security.GeneralSecurityException;
import java.security.Key;

import za.co.sindi.codec.Strings;
import za.co.sindi.codec.exception.EncodingException;
import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.jose.jws.JWSAlgorithm;
import za.co.sindi.jsonweb.jose.jws.JWSConstants;
import za.co.sindi.jsonweb.jose.jws.JWSException;
import za.co.sindi.jsonweb.jose.jws.JWSJOSEHeader;
import za.co.sindi.jsonweb.jose.jws.JWSPayload;
import za.co.sindi.jsonweb.jose.jws.JWSSerialization;
import za.co.sindi.jsonweb.jose.jws.JWSUtils;

/**
 * @author Bienfait Sindi
 * @since 07 June 2017
 *
 */
public class JWSCompactSerialization extends JWSSerialization {

	public String serialize(final JWSJOSEHeader jwsJOSEHeader, final JWSPayload jwsPayload, final Key key) throws JWSException {
		PreConditions.checkArgument(jwsJOSEHeader != null, "No JWS JOSE Header was specified.");
		PreConditions.checkState(jwsJOSEHeader.getAlgorithm() != null, "No JWS Algorithm was found.");
		PreConditions.checkArgument(jwsPayload != null, "No JWS Payload was specified.");
//		PreConditions.checkArgument(!JWSAlgorithm.NONE.equals(jwsJOSEHeader.getAlgorithm()) && key != null, "No cryptographic key was specified.");
	
		if (!JWSAlgorithm.NONE.equals(jwsJOSEHeader.getAlgorithm()) && key == null) {
			throw new JWSException("No cryptographic key was specified.");
		}
		
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(Strings.asASCIIString(JWSUtils.encodeJwsJoseHeader(jwsJOSEHeader)))
			  .append(JWSConstants.JWS_APPEND_SEPARATOR)
			  .append(payloadDetached ? "" : Strings.asASCIIString(JWSUtils.encodeJwsPayload(jwsPayload)))
			  .append(JWSConstants.JWS_APPEND_SEPARATOR)
			  .append(JWSAlgorithm.NONE.equals(jwsJOSEHeader.getAlgorithm()) ? "" : Strings.asASCIIString(generateJwsSignature(JWSUtils.generateJwsSigningInput(jwsJOSEHeader, jwsPayload), key, jwsJOSEHeader.getAlgorithm())));
			
			return sb.toString();
		} catch (EncodingException | GeneralSecurityException e) {
			// TODO Auto-generated catch block
			throw new JWSException(e);
		}
		
//		try {
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			baos.write(encodeJwsJoseHeader(jwsJOSEHeader));
//			baos.write(JWSConstants.JWS_APPEND_SEPARATOR);
//			baos.write(encodeJwsPayload(jwsPayload));
//			byte[] jwsSigningInput = baos.toByteArray();
//			baos.write(JWSConstants.JWS_APPEND_SEPARATOR);
//			baos.write(generateJwsSignature(jwsSigningInput, key, (JWSAlgorithm) jwsJOSEHeader.getAlgorithm()));
//			return asASCIIString(baos.toByteArray());
//		} catch (IOException | EncodingException | GeneralSecurityException e) {
//			// TODO Auto-generated catch block
//			throw new JWSException(e);
//		}
	}
}
