/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws.impl;

import java.security.Key;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.jose.jws.JWSException;
import za.co.sindi.jsonweb.jose.jws.JWSJOSEHeader;
import za.co.sindi.jsonweb.jose.jws.JWSJSONDeserialization;
import za.co.sindi.jsonweb.jose.jws.JWSPayload;
import za.co.sindi.jsonweb.jose.jws.JWSPayloads;
import za.co.sindi.jsonweb.jose.jws.JWSSignatureResult;
import za.co.sindi.jsonweb.json.JSONObject;

/**
 * @author Bienfait Sindi
 * @since 10 July 2017
 *
 */
public class FlattenedJWSJSONDeserialization extends JWSJSONDeserialization {

	private JWSPayload jwsPayload;
	
	/**
	 * 
	 */
	public FlattenedJWSJSONDeserialization() {
		this(null);
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param jwsPayload
	 */
	public FlattenedJWSJSONDeserialization(JWSPayload jwsPayload) {
		super();
		// TODO Auto-generated constructor stub
		this.jwsPayload = jwsPayload;
	}
	
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSJSONDeserialization#deserialize(za.co.sindi.jsonweb.json.JSONObject, java.security.Key[])
	 */
	@Override
	public JWSSignatureResult[] deserialize(JSONObject signedJwsDocument, Key... securityKeys) throws JWSException {
		// TODO Auto-generated method stub
		PreConditions.checkArgument(signedJwsDocument != null, "A Signed JWS JSON Document is required.");
		PreConditions.checkArgument(securityKeys != null && securityKeys.length != 1, "No signature key(s) were provided.");
		
		try {
			if (!signedJwsDocument.containsKey("payload")) {
				super.payloadDetached = true;
			} else {
				jwsPayload = JWSPayloads.newPayload(base64UrlDecode(signedJwsDocument.getString("payload")));
			}
			
			if (jwsPayload == null) {
				throw new JWSException("No JWS Payload were found or provided (if in detached mode).");
			}
			
			JWSSignatureResult[] results = new JWSSignatureResult[1];
			JWSJOSEHeader protectedJwsHeader = decodeJwsJoseHeader(signedJwsDocument.getString("protected"));
			JSONObject unprotectedJwsHeader = signedJwsDocument.containsKey("header") ? signedJwsDocument.getJSONObject("header") : null;
			
			boolean signatureValid = verifyJwsSignature(jwsPayload, protectedJwsHeader, unprotectedJwsHeader, signedJwsDocument.getString("signature"), securityKeys[0]);
			results[0] = new DefaultJWSSignatureResult(protectedJwsHeader, unprotectedJwsHeader, securityKeys[0], signatureValid);
			
			return results;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new JWSException(e);
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSDeserialization#getUnsignedJwsPayload()
	 */
	@Override
	public byte[] getUnsignedJwsPayload() {
		// TODO Auto-generated method stub
		return jwsPayload.getEncoded();
	}
}
