/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws.impl;

import za.co.sindi.common.utils.Strings;

import java.security.Key;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.jose.jws.JWSConstants;
import za.co.sindi.jsonweb.jose.jws.JWSDeserialization;
import za.co.sindi.jsonweb.jose.jws.JWSException;
import za.co.sindi.jsonweb.jose.jws.JWSJOSEHeader;
import za.co.sindi.jsonweb.jose.jws.JWSPayloads;

/**
 * @author Bienfait Sindi
 * @since 07 June 2017
 *
 */
public class JWSCompactDeserialization extends JWSDeserialization {

	private boolean verified = false;
	private byte[] unsignedJwsPayload = null;
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSDeserialization#getUnsignedJwsPayload()
	 */
	@Override
	public byte[] getUnsignedJwsPayload() {
		// TODO Auto-generated method stub
		return verified ? unsignedJwsPayload : null;
	}
	
	public void deserialize(final String encodedJwsString, final Key key) throws JWSException {
		PreConditions.checkArgument(!Strings.isNullOrEmpty(encodedJwsString), "No JWS Compact Serialized string was provided.");
		String[] jwsEncodedStringParts = encodedJwsString.split("\\" + JWSConstants.JWS_APPEND_SEPARATOR);
		PreConditions.checkState(jwsEncodedStringParts.length == 3, "The JWS Compact Serialized string has only " + jwsEncodedStringParts.length + " parts instead of 3.");
		
		try {
			JWSJOSEHeader jwsJoseHeader = decodeJwsJoseHeader(jwsEncodedStringParts[0]);
			unsignedJwsPayload = base64UrlDecode(jwsEncodedStringParts[1]);
			verified = verifyJwsSignature(jwsJoseHeader, JWSPayloads.newPayload(unsignedJwsPayload), key, base64UrlDecode(jwsEncodedStringParts[2]));
			if (!verified) {
				throw new JWSException("Failed to verify encoded JWS String (" + encodedJwsString + ") with JWS Algorithm '" + jwsJoseHeader.getAlgorithm().getJwaAlgorithmName() + "'.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new JWSException(e);
		}
	}
}
