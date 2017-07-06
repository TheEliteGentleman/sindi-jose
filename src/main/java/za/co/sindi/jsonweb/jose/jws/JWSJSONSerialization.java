/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws;

import java.security.Key;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.jose.jws.impl.DefaultJWSObjectReader;
import za.co.sindi.jsonweb.json.JSONObject;
import za.co.sindi.jsonweb.util.JSONUtils;

/**
 * @author Bienfait Sindi
 * @since 23 June 2017
 *
 */
public abstract class JWSJSONSerialization extends JWSSerialization {

	protected JWSPayload jwsPayload;

	/**
	 * @param unsignedJwsPayload
	 */
	protected JWSJSONSerialization(JWSPayload jwsPayload) {
		super();
		PreConditions.checkArgument(jwsPayload != null, "No JWS Payload was provided.");
		this.jwsPayload = jwsPayload;
	}
	
	protected byte[] generateJwsSignature(final JWSJOSEHeader protectedJwsHeader, final JWSJOSEHeader unprotectedJwsHeader, final Key key) throws JWSException {
		
		try {
			JWSJOSEHeader jwsJOSEHeader = protectedJwsHeader != null ? protectedJwsHeader : unprotectedJwsHeader;
			if (protectedJwsHeader != null && unprotectedJwsHeader != null) {
				JSONObject mergedJSONObject = JSONUtils.merge(protectedJwsHeader.toJSONObject(), unprotectedJwsHeader.toJSONObject());
				JWSObjectReader jwsObjectReader = new DefaultJWSObjectReader();
				jwsJOSEHeader = jwsObjectReader.readObject(mergedJSONObject);
			}
			
			PreConditions.checkState(jwsJOSEHeader.getAlgorithm() != null, "No JWS Algorithm was found.");
			return generateJwsSignature(JWSUtils.generateJwsSigningInput(jwsJOSEHeader, jwsPayload), key, jwsJOSEHeader.getAlgorithm());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if (e instanceof JWSException) {
				throw (JWSException)e;
			} else {
				throw new JWSException(e);
			}
		}
	}
	
	public abstract JSONObject serialize() throws JWSException;
}
