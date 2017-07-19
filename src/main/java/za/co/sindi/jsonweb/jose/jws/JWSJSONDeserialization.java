/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws;

import java.io.StringReader;
import java.security.Key;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.jose.jws.impl.DefaultJWSObjectReader;
import za.co.sindi.jsonweb.json.JSONObject;
import za.co.sindi.jsonweb.json.JSONReader;
import za.co.sindi.jsonweb.json.JSONReaderFactory;
import za.co.sindi.jsonweb.json.impl.DefaultJSONReaderFactory;
import za.co.sindi.jsonweb.util.JSONUtils;

/**
 * @author Bienfait Sindi
 * @since 10 July 2017
 *
 */
public abstract class JWSJSONDeserialization extends JWSDeserialization {
	
	protected boolean verifyJwsSignature(final JWSPayload jwsPayload, final JWSJOSEHeader protectedJwsHeader, final JWSJOSEHeader unprotectedJwsHeader, final String encodedJwsSignature, final Key key) throws JWSException {
		try {
			JWSJOSEHeader jwsJOSEHeader = protectedJwsHeader;
			if (protectedJwsHeader != null && unprotectedJwsHeader != null) {
				JSONObject mergedJSONObject = JSONUtils.merge(protectedJwsHeader.toJSONObject(), unprotectedJwsHeader.toJSONObject());
				JWSObjectReader jwsObjectReader = new DefaultJWSObjectReader();
				jwsJOSEHeader = jwsObjectReader.readObject(mergedJSONObject);
			}
			
			PreConditions.checkState(jwsJOSEHeader.getAlgorithm() != null, "No JWS Algorithm was found.");
			return JWSAlgorithm.NONE.equals(jwsJOSEHeader.getAlgorithm()) ? true : verifyJwsSignature(jwsJOSEHeader, jwsPayload, key, base64UrlDecode(encodedJwsSignature));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if (e instanceof JWSException) {
				throw (JWSException)e;
			} else {
				throw new JWSException(e);
			}
		}
	}

	public JWSSignatureResult[] deserialize(final String signedJwsDocument, final Key... securityKeys) throws JWSException {
		JSONReaderFactory jsonReaderFactory = new DefaultJSONReaderFactory();
		JSONReader jsonObjectReader = jsonReaderFactory.createReader(new StringReader(signedJwsDocument));
		return deserialize(jsonObjectReader.readJSONObject(), securityKeys);
	}
	
	public abstract JWSSignatureResult[] deserialize(final JSONObject signedJwsDocument, final Key... securityKeys) throws JWSException;
	
	protected static class DefaultJWSSignatureResult implements JWSSignatureResult {
		
		private JWSJOSEHeader protectedJwsHeader;
		private JWSJOSEHeader unprotectedJwsHeader;
		private Key key;
		private boolean validated;

		/**
		 * @param protectedJwsHeader
		 * @param unprotectedJwsHeader
		 * @param key
		 * @param validated
		 */
		public DefaultJWSSignatureResult(JWSJOSEHeader protectedJwsHeader, JWSJOSEHeader unprotectedJwsHeader, Key key, boolean validated) {
			super();
			this.protectedJwsHeader = protectedJwsHeader;
			this.unprotectedJwsHeader = unprotectedJwsHeader;
			this.key = key;
			this.validated = validated;
		}

		/* (non-Javadoc)
		 * @see za.co.sindi.jsonweb.jose.jws.JWSSignatureResult#getProtectedJwsHeader()
		 */
		@Override
		public JWSJOSEHeader getProtectedJwsHeader() {
			// TODO Auto-generated method stub
			return protectedJwsHeader;
		}

		/* (non-Javadoc)
		 * @see za.co.sindi.jsonweb.jose.jws.JWSSignatureResult#getUnprotectedJwsHeader()
		 */
		@Override
		public JWSJOSEHeader getUnprotectedJwsHeader() {
			// TODO Auto-generated method stub
			return unprotectedJwsHeader;
		}

		/* (non-Javadoc)
		 * @see za.co.sindi.jsonweb.jose.jws.JWSSignatureResult#getKey()
		 */
		@Override
		public Key getKey() {
			// TODO Auto-generated method stub
			return key;
		}

		/* (non-Javadoc)
		 * @see za.co.sindi.jsonweb.jose.jws.JWSSignatureResult#validationSucceeded()
		 */
		@Override
		public boolean validationSucceeded() {
			// TODO Auto-generated method stub
			return validated;
		}
	}
}
