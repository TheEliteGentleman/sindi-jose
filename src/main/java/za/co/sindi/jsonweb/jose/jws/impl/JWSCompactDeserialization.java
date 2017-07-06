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
import za.co.sindi.jsonweb.jose.jws.JWSPayload;
import za.co.sindi.jsonweb.jose.jws.JWSPayloads;

/**
 * @author Bienfait Sindi
 * @since 07 June 2017
 *
 */
public class JWSCompactDeserialization extends JWSDeserialization {

	private boolean validationSuccess = false;
	private JWSJOSEHeader jwsJOSEHeader;
	private byte[] unsignedJwsPayload = null;
	
	/**
	 * 
	 */
	public JWSCompactDeserialization() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param unsignedJwsPayload
	 */
	public JWSCompactDeserialization(JWSPayload jwsPayload) {
		this(jwsPayload.getEncoded());
	}


	/**
	 * @param unsignedJwsPayload
	 */
	public JWSCompactDeserialization(byte[] unsignedJwsPayload) {
		super();
		this.unsignedJwsPayload = unsignedJwsPayload;
	}

	/**
	 * @return the jwsJOSEHeader
	 */
	public JWSJOSEHeader getJwsJOSEHeader() {
		return jwsJOSEHeader;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSDeserialization#getUnsignedJwsPayload()
	 */
	@Override
	public byte[] getUnsignedJwsPayload() {
		// TODO Auto-generated method stub
		return unsignedJwsPayload;
	}
	
	/**
	 * @return the validationSuccess
	 */
	public boolean isValidationSuccess() {
		return validationSuccess;
	}

	public void deserialize(final String encodedJwsString, final Key key) throws JWSException {
		PreConditions.checkArgument(!Strings.isNullOrEmpty(encodedJwsString), "No JWS Compact Serialized string was provided.");
		String[] jwsEncodedStringParts = encodedJwsString.split("\\" + JWSConstants.JWS_APPEND_SEPARATOR);
		PreConditions.checkState(jwsEncodedStringParts.length == 3, "The JWS Compact Serialized string has only " + jwsEncodedStringParts.length + " parts instead of 3.");
		
		try {
			jwsJOSEHeader = decodeJwsJoseHeader(jwsEncodedStringParts[0]);
			if (!Strings.isNullOrEmpty(jwsEncodedStringParts[1])) {
				unsignedJwsPayload = base64UrlDecode(jwsEncodedStringParts[1]);
			} else {
				payloadDetached = true;
				
				if (unsignedJwsPayload == null || unsignedJwsPayload.length == 0) {
					throw new JWSException("The JWS Compact Serialization string contact no JWS Payload, thus making it detached. Please provide a JWS Payload in order to validate the JWS message.");
				}
			}
			validationSuccess = verifyJwsSignature(jwsJOSEHeader, JWSPayloads.newPayload(unsignedJwsPayload), key, base64UrlDecode(jwsEncodedStringParts[2]));
//			if (!validationSuccess) {
//				throw new JWSException("Failed to verify encoded JWS String (" + encodedJwsString + ") with JWS Algorithm '" + jwsJOSEHeader.getAlgorithm().getJwaAlgorithmName() + "'.");
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new JWSException(e);
		}
	}
}
