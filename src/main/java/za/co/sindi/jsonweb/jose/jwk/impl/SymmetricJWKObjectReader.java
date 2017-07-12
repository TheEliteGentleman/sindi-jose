/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk.impl;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.Base64URLBytes;
import za.co.sindi.jsonweb.jose.JOSE;
import za.co.sindi.jsonweb.jose.jwk.AbstractJWKObjectReader;
import za.co.sindi.jsonweb.jose.jwk.JWKConstants;
import za.co.sindi.jsonweb.jose.jwk.JWKObjectReader;
import za.co.sindi.jsonweb.jose.jwk.SymmetricJWK;
import za.co.sindi.jsonweb.jose.jwk.SymmetricJWKObjectBuilder;
import za.co.sindi.jsonweb.json.JSONObject;

/**
 * @author Bienfait Sindi
 * @since 25 May 2017
 *
 */
public class SymmetricJWKObjectReader extends AbstractJWKObjectReader<SymmetricJWK, SymmetricJWKObjectBuilder> implements JWKObjectReader<SymmetricJWK> {

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractJWKObjectReader#createJWKObjectBuilder()
	 */
	@Override
	protected SymmetricJWKObjectBuilder createJWKObjectBuilder() {
		// TODO Auto-generated method stub
		return JOSE.createSymmetricJWKObjectBuilder();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractJWKObjectReader#build(za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder, za.co.sindi.jsonweb.json.JSONObject)
	 */
	@Override
	protected void build(SymmetricJWKObjectBuilder jwkObjectBuilder, JSONObject jsonObject) throws Exception {
		// TODO Auto-generated method stub
		PreConditions.checkState(jsonObject.containsKey(JWKConstants.OCT_PARAM_KEY_VALUE) && !jsonObject.isNull(JWKConstants.OCT_PARAM_KEY_VALUE), "JWK Symmetric key value '" + JWKConstants.OCT_PARAM_KEY_VALUE + "' is null or doesn't exist.");
		jwkObjectBuilder.setKeyValue(new Base64URLBytes(jsonObject.getString(JWKConstants.OCT_PARAM_KEY_VALUE)));
	}
}
