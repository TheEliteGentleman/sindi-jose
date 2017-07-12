/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk.impl;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.Base64URLUInt;
import za.co.sindi.jsonweb.jose.JOSE;
import za.co.sindi.jsonweb.jose.jwk.AbstractJWKObjectReader;
import za.co.sindi.jsonweb.jose.jwk.JWKConstants;
import za.co.sindi.jsonweb.jose.jwk.JWKObjectReader;
import za.co.sindi.jsonweb.jose.jwk.RSAJWK;
import za.co.sindi.jsonweb.jose.jwk.RSAJWKObjectBuilder;
import za.co.sindi.jsonweb.json.JSONObject;

/**
 * @author Bienfait Sindi
 * @since 25 May 2017
 *
 */
public class RSAJWKObjectReader extends AbstractJWKObjectReader<RSAJWK, RSAJWKObjectBuilder> implements JWKObjectReader<RSAJWK> {

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractJWKObjectReader#createJWKObjectBuilder()
	 */
	@Override
	protected RSAJWKObjectBuilder createJWKObjectBuilder() {
		// TODO Auto-generated method stub
		return JOSE.createRSAJWKObjectBuilder();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractJWKObjectReader#build(za.co.sindi.jsonweb.jose.jwk.JWKObjectBuilder, za.co.sindi.jsonweb.json.JSONObject)
	 */
	@Override
	protected void build(RSAJWKObjectBuilder jwkObjectBuilder, JSONObject jsonObject) throws Exception {
		// TODO Auto-generated method stub
		PreConditions.checkState(jsonObject.containsKey(JWKConstants.RSA_PARAM_MODULUS) && !jsonObject.isNull(JWKConstants.RSA_PARAM_MODULUS), "No JWK RSA parameter '" + JWKConstants.RSA_PARAM_MODULUS + "' found.");
		PreConditions.checkState(jsonObject.containsKey(JWKConstants.RSA_PARAM_MODULUS) && !jsonObject.isNull(JWKConstants.RSA_PARAM_EXPONENT_PUBLIC), "No RSA Curve parameter '" + JWKConstants.RSA_PARAM_EXPONENT_PUBLIC + "' found.");
		
		jwkObjectBuilder.setModulus(new Base64URLUInt(jsonObject.getString(JWKConstants.RSA_PARAM_MODULUS)));
		jwkObjectBuilder.setPublicExponent(new Base64URLUInt(jsonObject.getString(JWKConstants.RSA_PARAM_EXPONENT_PUBLIC)));
		
		if (jsonObject.containsKey(JWKConstants.RSA_PARAM_EXPONENT_PRIVATE) && !jsonObject.isNull(JWKConstants.RSA_PARAM_EXPONENT_PRIVATE)) {
			jwkObjectBuilder.setPrivateExponent(new Base64URLUInt(jsonObject.getString(JWKConstants.RSA_PARAM_EXPONENT_PRIVATE)));
			
			PreConditions.checkState(jsonObject.containsKey(JWKConstants.RSA_PARAM_FIRST_PRIME_FACTOR) && !jsonObject.isNull(JWKConstants.RSA_PARAM_FIRST_PRIME_FACTOR), "JWK RSA key requires the '" + JWKConstants.RSA_PARAM_FIRST_PRIME_FACTOR + "' parameter.");
			jwkObjectBuilder.setFirstPrimeFactor(new Base64URLUInt(jsonObject.getString(JWKConstants.RSA_PARAM_FIRST_PRIME_FACTOR)));
			
			PreConditions.checkState(jsonObject.containsKey(JWKConstants.RSA_PARAM_SECOND_PRIME_FACTOR) && !jsonObject.isNull(JWKConstants.RSA_PARAM_SECOND_PRIME_FACTOR), "JWK RSA key requires the '" + JWKConstants.RSA_PARAM_SECOND_PRIME_FACTOR + "' parameter.");
			jwkObjectBuilder.setSecondPrimeFactor(new Base64URLUInt(jsonObject.getString(JWKConstants.RSA_PARAM_SECOND_PRIME_FACTOR)));
			
			PreConditions.checkState(jsonObject.containsKey(JWKConstants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT) && !jsonObject.isNull(JWKConstants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT), "JWK RSA key requires the '" + JWKConstants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT + "' parameter.");
			jwkObjectBuilder.setFirstFactorCRTExponent(new Base64URLUInt(jsonObject.getString(JWKConstants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT)));
			
			PreConditions.checkState(jsonObject.containsKey(JWKConstants.RSA_PARAM_SECOND_FACTOR_CRT_EXPONENT) && !jsonObject.isNull(JWKConstants.RSA_PARAM_SECOND_FACTOR_CRT_EXPONENT), "JWK RSA key requires the '" + JWKConstants.RSA_PARAM_SECOND_FACTOR_CRT_EXPONENT + "' parameter.");
			jwkObjectBuilder.setSecondFactorCRTExponent(new Base64URLUInt(jsonObject.getString(JWKConstants.RSA_PARAM_SECOND_FACTOR_CRT_EXPONENT)));
			
			PreConditions.checkState(jsonObject.containsKey(JWKConstants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT) && !jsonObject.isNull(JWKConstants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT), "JWK RSA key requires the '" + JWKConstants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT + "' parameter.");
			jwkObjectBuilder.setFirstCRTCoefficient(new Base64URLUInt(jsonObject.getString(JWKConstants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT)));
		}
	}
}
