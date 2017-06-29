/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws;

import za.co.sindi.codec.Strings;
import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.json.JSONObject;

/**
 * @author Bienfait Sindi
 * @since 19 June 2017
 *
 */
public final class JWSPayloads {

	private JWSPayloads() {
		throw new AssertionError("Private Constructor.");
	}
	
	public static JWSPayload newPayload(final String payload) {
		PreConditions.checkArgument(!za.co.sindi.common.utils.Strings.isNullOrEmpty(payload), "No String payload was provided.");
		
		return new JWSPayload() {
			
			@Override
			public byte[] getEncoded() {
				// TODO Auto-generated method stub
				return Strings.toUTF8Bytes(payload);
			}
		};
	}
	
	public static JWSPayload newPayload(final byte[] payload) {
		PreConditions.checkArgument(payload != null && payload.length > 0, "No payload bytes was provided.");
		
		return new JWSPayload() {
			
			@Override
			public byte[] getEncoded() {
				// TODO Auto-generated method stub
				return payload;
			}
		};
	}
	
	public static JWSPayload newPayload(final JSONObject jsonObject) {
		PreConditions.checkArgument(jsonObject != null, "No JSON Ojbect was provided.");
		
		return newPayload(jsonObject.toString());
	}
}
