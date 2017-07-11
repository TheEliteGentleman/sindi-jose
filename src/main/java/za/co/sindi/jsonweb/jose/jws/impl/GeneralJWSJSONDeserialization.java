/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws.impl;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collection;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.jose.jws.JWSException;
import za.co.sindi.jsonweb.jose.jws.JWSJOSEHeader;
import za.co.sindi.jsonweb.jose.jws.JWSJSONDeserialization;
import za.co.sindi.jsonweb.jose.jws.JWSPayload;
import za.co.sindi.jsonweb.jose.jws.JWSPayloads;
import za.co.sindi.jsonweb.jose.jws.JWSSignatureResult;
import za.co.sindi.jsonweb.json.JSONArray;
import za.co.sindi.jsonweb.json.JSONObject;

/**
 * @author Bienfait Sindi
 * @since 10 July 2017
 *
 */
public class GeneralJWSJSONDeserialization extends JWSJSONDeserialization {

	private JWSPayload jwsPayload;
	
	/**
	 * 
	 */
	public GeneralJWSJSONDeserialization() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param jwsPayload
	 */
	public GeneralJWSJSONDeserialization(JWSPayload jwsPayload) {
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
		PreConditions.checkArgument(securityKeys != null && securityKeys.length > 0, "No signature key(s) were provided.");
		
		try {
			if (!signedJwsDocument.containsKey("signatures")) {
				throw new JWSException("No \"signatures\" JSON element was found.");
			}
			
			if (!signedJwsDocument.containsKey("payload")) {
				super.payloadDetached = true;
			} else {
				jwsPayload = JWSPayloads.newPayload(base64UrlDecode(signedJwsDocument.getString("payload")));
			}
			
			if (jwsPayload == null) {
				throw new JWSException("No JWS Payload were found or provided (if in detached mode).");
			}
			
			JSONArray signedSignatures = signedJwsDocument.getJSONArray("signatures");
			if (signedSignatures.size() != securityKeys.length) {
				throw new JWSException("Found " + signedSignatures.size() + " signatures on the JSON encoded signature but was provided " + securityKeys.length + " signature keys for validation.");
			}
			
			Collection<JWSSignatureResult> results = new ArrayList<>();
			for (int i = 0; i < signedSignatures.size(); i++) {
				JSONObject signedObject = signedSignatures.getJSONObject(i);
				
				JWSJOSEHeader protectedJwsHeader = decodeJwsJoseHeader(signedObject.getString("protected"));
				JSONObject unprotectedJwsHeader = signedObject.containsKey("header") ? signedObject.getJSONObject("header") : null;
				
				boolean signatureValid = verifyJwsSignature(jwsPayload, protectedJwsHeader, unprotectedJwsHeader, signedObject.getString("signature"), securityKeys[i]);
				results.add(new DefaultJWSSignatureResult(protectedJwsHeader, unprotectedJwsHeader, securityKeys[i], signatureValid));
			}
			
			return results.toArray(new JWSSignatureResult[results.size()]);
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
