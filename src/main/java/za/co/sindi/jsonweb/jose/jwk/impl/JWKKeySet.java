/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk.impl;

import java.util.ArrayList;
import java.util.Collection;

import za.co.sindi.jsonweb.AbstractJWObject;
import za.co.sindi.jsonweb.jose.jwk.JWKConstants;
import za.co.sindi.jsonweb.jose.jwk.JWK;
import za.co.sindi.jsonweb.jose.jwk.JWKSet;
import za.co.sindi.jsonweb.json.JSONArrayBuilder;
import za.co.sindi.jsonweb.json.JSONObject;
import za.co.sindi.jsonweb.json.JSONObjectBuilder;
import za.co.sindi.jsonweb.json.impl.DefaultJSONArrayBuilder;
import za.co.sindi.jsonweb.json.impl.DefaultJSONObjectBuilder;

/**
 * @author buhake.sindi
 * @since 05 May 2016
 *
 */
public class JWKKeySet extends AbstractJWObject implements JWKSet {
	
	private Collection<JWK> keys;

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKSet#getAllKeys()
	 */
	@Override
	public JWK[] getAllKeys() {
		// TODO Auto-generated method stub
//		@SuppressWarnings("unchecked")
//		Collection<JWK> keys = (Collection<JWK>) getParameter(Constants.JWK_KEYS);
		if (keys == null) {
			return null;
		}
		
		return keys.toArray(new JWK[keys.size()]);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.JWKSet#addKey(za.co.sindi.jsonweb.jose.jwk.JWK)
	 */
	public void addKey(JWK key) {
		// TODO Auto-generated method stub
		if (key != null) {
//			if (!containsParameter(Constants.JWK_KEYS)) {
//				setParameter(Constants.JWK_KEYS, new ArrayList<JWK>());
//			}
//			
//			((Collection<JWK>) getParameter(Constants.JWK_KEYS)).add(key);
			if (keys == null) {
				keys = new ArrayList<JWK>();
			}
			
			keys.add(key);
		}
	}

//	/* (non-Javadoc)
//	 * @see za.co.sindi.jsonweb.jose.jwk.JWKSet#removeKey(za.co.sindi.jsonweb.jose.jwk.JWK)
//	 */
//	@Override
//	public void removeKey(JWK key) {
//		// TODO Auto-generated method stub
////		if (key == null) {
////			setParameter(Constants.JWK_KEYS, null);
////		} else {
////			if (!containsParameter(Constants.JWK_KEYS)) {
////				setParameter(Constants.JWK_KEYS, new ArrayList<JWK>());
////			}
////			
////			@SuppressWarnings("unchecked")
////			Iterator<JWK> keyIterator = ((Collection<JWK>) getParameter(Constants.JWK_KEYS)).iterator();
////			while (keyIterator.hasNext()) {
////				if (keyIterator.next().getKeyId().equals(key.getKeyId())) {
////					keyIterator.remove();
////				}
////			}
////		}
//		
//		if (key != null && keys != null) {
//			Iterator<JWK> keyIterator = keys.iterator();
//			while (keyIterator.hasNext()) {
//				if (keyIterator.next().getKeyId().equals(key.getKeyId())) {
//					keyIterator.remove();
//				}
//			}
//		}
//	}

//	/* (non-Javadoc)
//	 * @see za.co.sindi.jsonweb.JWObject#read(za.co.sindi.jsonweb.json.JSONObject)
//	 */
//	@Override
//	public void read(JSONObject jsonObject) throws Exception {
//		// TODO Auto-generated method stub
//		PreConditions.checkArgument(jsonObject != null, "No JSON object was provided.");
//		PreConditions.checkState(!jsonObject.isNull(Constants.JWK_KEYS), "No JWK Key Set parameter '" + Constants.JWK_KEYS + "' found.");
//		
//		JSONArray jsonArray = jsonObject.getJSONArray(Constants.JWK_KEYS);
//		if (!jsonArray.isEmpty()) {
//			for (int i = 0; i < jsonArray.size(); i++) {
//				JSONObject keyJSONObject = jsonArray.getJSONObject(i);
//				if (!keyJSONObject.isNull(Constants.JWK_KEY_TYPE)) {
//					KeyType keyType = KeyType.of(keyJSONObject.getString(Constants.JWK_KEY_TYPE));
////					if (KeyType.EC.equals(keyType)) {
////						JWK jwk = new JWKEllipticCurveKey();
////						jwk.read(keyJSONObject);
////						addKey(jwk);
////					} else if (KeyType.OCT.equals(keyType)) {
////						JWK jwk = new JWKSymmetricKey();
////						jwk.read(keyJSONObject);
////						addKey(jwk);
////					} else if (KeyType.RSA.equals(keyType)) {
////						JWK jwk = new JWKRSAKey();
////						jwk.read(keyJSONObject);
////						addKey(jwk);
////					}
//					JWK jwk = JWKeys.getJWK(keyType);
//					PreConditions.checkState(jwk != null, "The key type '"+ keyType.getParameterValue() + "' is invalid.");
//					jwk.read(keyJSONObject);
//					addKey(jwk);
//				}
//			}
//		}
//	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.JWObject#toJSONObject()
	 */
	@Override
	public JSONObject toJSONObject() throws Exception {
		// TODO Auto-generated method stub
		JSONObjectBuilder jsonObjectBuilder = new DefaultJSONObjectBuilder();
		JSONArrayBuilder jsonArrayBuilder = new DefaultJSONArrayBuilder();
		JWK[] keys = getAllKeys();
		if (keys != null) {
			for (JWK key : keys) {
				jsonArrayBuilder.add(key.toJSONObject());
			}
			jsonObjectBuilder.add(JWKConstants.JWK_KEYS, jsonArrayBuilder);
		}
		return jsonObjectBuilder.build();
	}
}
