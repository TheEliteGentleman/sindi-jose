/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk.impl;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.jose.JOSE;
import za.co.sindi.jsonweb.jose.jwk.JWKConstants;
import za.co.sindi.jsonweb.jose.jwk.JWK;
import za.co.sindi.jsonweb.jose.jwk.JWKKeyTypeUtils;
import za.co.sindi.jsonweb.jose.jwk.JWKSet;
import za.co.sindi.jsonweb.jose.jwk.JWKSetObjectBuilder;
import za.co.sindi.jsonweb.jose.jwk.JWKSetObjectReader;
import za.co.sindi.jsonweb.jose.jwk.KeyType;
import za.co.sindi.jsonweb.json.JSONArray;
import za.co.sindi.jsonweb.json.JSONObject;

/**
 * @author Bienfait Sindi
 * @since 25 May 2017
 *
 */
public class DefaultJWKSetObjectReader implements JWKSetObjectReader {

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.JWObjectReader#readObject(za.co.sindi.jsonweb.json.JSONObject)
	 */
	@Override
	public JWKSet readObject(JSONObject jsonObject) throws Exception {
		// TODO Auto-generated method stub
		PreConditions.checkArgument(jsonObject != null, "No JSON object was provided.");
		PreConditions.checkState(!jsonObject.isNull(JWKConstants.JWK_KEYS), "No JWK Key Set parameter '" + JWKConstants.JWK_KEYS + "' found.");
		
		JWKSetObjectBuilder builder = JOSE.createJWKSetObjectBuilder();
		JSONArray jsonArray = jsonObject.getJSONArray(JWKConstants.JWK_KEYS);
		if (!jsonArray.isEmpty()) {
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject keyJSONObject = jsonArray.getJSONObject(i);
				if (!keyJSONObject.isNull(JWKConstants.JWK_KEY_TYPE)) {
					KeyType keyType = KeyType.of(keyJSONObject.getString(JWKConstants.JWK_KEY_TYPE));
					JWK jwk = JWKKeyTypeUtils.getJWKObjectReader(keyType).readObject(keyJSONObject);
					PreConditions.checkState(jwk != null, "The key type '"+ keyType.getParameterValue() + "' is invalid.");
					builder.addKey(jwk);
				}
			}
		}
		
		return builder.build();
	}
}
