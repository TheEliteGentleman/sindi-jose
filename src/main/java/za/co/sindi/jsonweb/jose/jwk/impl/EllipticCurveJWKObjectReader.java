/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk.impl;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.Base64URLUInt;
import za.co.sindi.jsonweb.jose.JOSE;
import za.co.sindi.jsonweb.jose.jwk.AbstractJWKObjectReader;
import za.co.sindi.jsonweb.jose.jwk.JWKConstants;
import za.co.sindi.jsonweb.jose.jwk.ECCurve;
import za.co.sindi.jsonweb.jose.jwk.EllipticCurveJWK;
import za.co.sindi.jsonweb.jose.jwk.EllipticCurveJWKObjectBuilder;
import za.co.sindi.jsonweb.jose.jwk.JWKObjectReader;
import za.co.sindi.jsonweb.json.JSONObject;

/**
 * @author Bienfait Sindi
 * @since 25 May 2017
 *
 */
public class EllipticCurveJWKObjectReader extends AbstractJWKObjectReader<EllipticCurveJWK, EllipticCurveJWKObjectBuilder> implements JWKObjectReader<EllipticCurveJWK> {

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractJWKObjectReader#createJWKObjectBuilder()
	 */
	@Override
	protected EllipticCurveJWKObjectBuilder createJWKObjectBuilder() {
		// TODO Auto-generated method stub
		return JOSE.createEllipticCurveJWKObjectBuilder();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractJWKObjectReader#build(za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder, za.co.sindi.jsonweb.json.JSONObject)
	 */
	@Override
	protected void build(EllipticCurveJWKObjectBuilder jwkObjectBuilder, JSONObject jsonObject) throws Exception {
		// TODO Auto-generated method stub
		PreConditions.checkState(!jsonObject.isNull(JWKConstants.EC_PARAM_CURVE), "No JWK Elliptic Curve parameter '" + JWKConstants.EC_PARAM_CURVE + "' found.");
		PreConditions.checkState(!jsonObject.isNull(JWKConstants.EC_PARAM_X_COORDINATE), "No JWK Elliptic Curve parameter '" + JWKConstants.EC_PARAM_X_COORDINATE + "' found.");
//		PreConditions.checkState(!jsonObject.isNull(Constants.EC_PARAM_Y_COORDINATE), "No JWK Elliptic Curve parameter '" + Constants.EC_PARAM_Y_COORDINATE + "' found.");
		
		jwkObjectBuilder.setCurve(ECCurve.of(jsonObject.getString(JWKConstants.EC_PARAM_CURVE)));
		jwkObjectBuilder.setCoordinateX(new Base64URLUInt(jsonObject.getString(JWKConstants.EC_PARAM_X_COORDINATE)));
		if (!jsonObject.isNull(JWKConstants.EC_PARAM_Y_COORDINATE)) {
			jwkObjectBuilder.setCoordinateY(new Base64URLUInt(jsonObject.getString(JWKConstants.EC_PARAM_Y_COORDINATE)));
		}
		
		if (!jsonObject.isNull(JWKConstants.EC_PARAM_ECC_PRIVATE_KEY)) {
			jwkObjectBuilder.setPrivateKey(new Base64URLUInt(jsonObject.getString(JWKConstants.EC_PARAM_ECC_PRIVATE_KEY)));
		}
	}
}
