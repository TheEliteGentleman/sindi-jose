/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwt.impl;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.NumericDate;
import za.co.sindi.jsonweb.StringOrURI;
import za.co.sindi.jsonweb.jose.jwt.JWTConstants;
import za.co.sindi.jsonweb.jose.JOSE;
import za.co.sindi.jsonweb.jose.jwt.JWTClaims;
import za.co.sindi.jsonweb.jose.jwt.JWTClaimsObjectBuilder;
import za.co.sindi.jsonweb.jose.jwt.JWTClaimsObjectReader;
import za.co.sindi.jsonweb.json.JSONObject;

/**
 * @author Bienfait Sindi
 * @since 25 May 2017
 *
 */
public class DefaultJWTClaimsObjectReader implements JWTClaimsObjectReader {

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.JWObjectReader#readObject(za.co.sindi.jsonweb.json.JSONObject)
	 */
	@Override
	public JWTClaims readObject(JSONObject jsonObject) throws Exception {
		// TODO Auto-generated method stub
		PreConditions.checkArgument(jsonObject != null, "No JSON object was provided.");
		
		JWTClaimsObjectBuilder builder = JOSE.createJWTClaimsObjectBuilder();
		if (!jsonObject.isNull(JWTConstants.JWT_CLAIM_ISSUER)) {
			builder.setIssuer(new StringOrURI(jsonObject.getString(JWTConstants.JWT_CLAIM_ISSUER)));
		}
		
		if (!jsonObject.isNull(JWTConstants.JWT_CLAIM_SUBJECT)) {
			builder.setSubject(new StringOrURI(jsonObject.getString(JWTConstants.JWT_CLAIM_SUBJECT)));
		}
		
		if (!jsonObject.isNull(JWTConstants.JWT_CLAIM_EXPIRATION_TIME)) {
			builder.setExpirationTime(new NumericDate(jsonObject.getLong(JWTConstants.JWT_CLAIM_EXPIRATION_TIME)));
		}
		
		if (!jsonObject.isNull(JWTConstants.JWT_CLAIM_NOT_BEFORE)) {
			builder.setNotBefore(new NumericDate(jsonObject.getLong(JWTConstants.JWT_CLAIM_NOT_BEFORE)));
		}
		
		if (!jsonObject.isNull(JWTConstants.JWT_CLAIM_ISSUED_AT)) {
			builder.setNotBefore(new NumericDate(jsonObject.getLong(JWTConstants.JWT_CLAIM_ISSUED_AT)));
		}
		
		if (!jsonObject.isNull(JWTConstants.JWT_CLAIM_JWT_ID)) {
			builder.setJwtID(jsonObject.getString(JWTConstants.JWT_CLAIM_JWT_ID));
		}
		
		return builder.build();
	}
}
