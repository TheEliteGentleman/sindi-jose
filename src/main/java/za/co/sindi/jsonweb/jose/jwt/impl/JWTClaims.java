/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwt.impl;

import za.co.sindi.common.utils.Strings;
import za.co.sindi.jsonweb.AbstractJWObject;
import za.co.sindi.jsonweb.NumericDate;
import za.co.sindi.jsonweb.StringOrURI;
import za.co.sindi.jsonweb.jose.jwt.JWTConstants;
import za.co.sindi.jsonweb.json.JSONBuilderFactory;
import za.co.sindi.jsonweb.json.JSONObject;
import za.co.sindi.jsonweb.json.JSONObjectBuilder;
import za.co.sindi.jsonweb.json.impl.DefaultJSONBuilderFactory;

/**
 * @author Bienfait Sindi
 * @since 09 June 2016
 *
 */
public class JWTClaims extends AbstractJWObject implements za.co.sindi.jsonweb.jose.jwt.JWTClaims {

	private StringOrURI issuer;
	private StringOrURI subject;
	private NumericDate expirationTime;
	private NumericDate notBefore;
	private NumericDate issuedAt;
	private String jwtID;
	
//	/* (non-Javadoc)
//	 * @see za.co.sindi.jsonweb.JWObject#read(za.co.sindi.jsonweb.json.JSONObject)
//	 */
//	@Override
//	public void read(JSONObject jsonObject) throws Exception {
//		// TODO Auto-generated method stub
//		PreConditions.checkArgument(jsonObject != null, "No JSON object was provided.");
//		
//		if (!jsonObject.isNull(Constants.JWT_CLAIM_ISSUER)) {
//			setIssuer(new StringOrURI(jsonObject.getString(Constants.JWT_CLAIM_ISSUER)));
//		}
//		
//		if (!jsonObject.isNull(Constants.JWT_CLAIM_SUBJECT)) {
//			setSubject(new StringOrURI(jsonObject.getString(Constants.JWT_CLAIM_SUBJECT)));
//		}
//		
//		if (!jsonObject.isNull(Constants.JWT_CLAIM_EXPIRATION_TIME)) {
//			setExpirationTime(new NumericDate(jsonObject.getLong(Constants.JWT_CLAIM_EXPIRATION_TIME)));
//		}
//		
//		if (!jsonObject.isNull(Constants.JWT_CLAIM_NOT_BEFORE)) {
//			setNotBefore(new NumericDate(jsonObject.getLong(Constants.JWT_CLAIM_NOT_BEFORE)));
//		}
//		
//		if (!jsonObject.isNull(Constants.JWT_CLAIM_ISSUED_AT)) {
//			setNotBefore(new NumericDate(jsonObject.getLong(Constants.JWT_CLAIM_ISSUED_AT)));
//		}
//		
//		if (!jsonObject.isNull(Constants.JWT_CLAIM_JWT_ID)) {
//			setJwtID(jsonObject.getString(Constants.JWT_CLAIM_JWT_ID));
//		}
//	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.JWObject#toJSONObject()
	 */
	@Override
	public JSONObject toJSONObject() throws Exception {
		// TODO Auto-generated method stub
		JSONBuilderFactory factory = new DefaultJSONBuilderFactory();
		JSONObjectBuilder jsonObjectBuilder = factory.createJSONObjectBuilder();
		
		if (issuer != null) {
			jsonObjectBuilder.add(JWTConstants.JWT_CLAIM_ISSUER, issuer.getJSONValue());
		}
		
		if (subject != null) {
			jsonObjectBuilder.add(JWTConstants.JWT_CLAIM_SUBJECT, subject.getJSONValue());
		}
		
		if (expirationTime != null) {
			jsonObjectBuilder.add(JWTConstants.JWT_CLAIM_EXPIRATION_TIME, expirationTime.getJSONValue());
		}
		
		if (notBefore != null) {
			jsonObjectBuilder.add(JWTConstants.JWT_CLAIM_NOT_BEFORE, notBefore.getJSONValue());
		}
		
		if (issuedAt != null) {
			jsonObjectBuilder.add(JWTConstants.JWT_CLAIM_ISSUED_AT, issuedAt.getJSONValue());
		}
		
		if (!Strings.isNullOrEmpty(jwtID)) {
			jsonObjectBuilder.add(JWTConstants.JWT_CLAIM_JWT_ID, jwtID);
		}
		
		populateJSONObject(jsonObjectBuilder);
		return jsonObjectBuilder.build();
	}
	
	protected void populateJSONObject(final JSONObjectBuilder jsonObjectBuilder) {
		
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwt.JWTClaims#getIssuer()
	 */
	@Override
	public StringOrURI getIssuer() {
		// TODO Auto-generated method stub
		return issuer;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwt.JWTClaims#setIssuer(za.co.sindi.jsonweb.StringOrURI)
	 */
//	@Override
	public void setIssuer(StringOrURI issuer) {
		// TODO Auto-generated method stub
		this.issuer = issuer;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwt.JWTClaims#getSubject()
	 */
	@Override
	public StringOrURI getSubject() {
		// TODO Auto-generated method stub
		return subject;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwt.JWTClaims#setSubject(za.co.sindi.jsonweb.StringOrURI)
	 */
//	@Override
	public void setSubject(StringOrURI subject) {
		// TODO Auto-generated method stub
		this.subject = subject;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwt.JWTClaims#getExpirationTime()
	 */
	@Override
	public NumericDate getExpirationTime() {
		// TODO Auto-generated method stub
		return expirationTime;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwt.JWTClaims#setExpirationTime(za.co.sindi.jsonweb.NumericDate)
	 */
//	@Override
	public void setExpirationTime(NumericDate expirationTime) {
		// TODO Auto-generated method stub
		this.expirationTime = expirationTime;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwt.JWTClaims#getNotBefore()
	 */
	@Override
	public NumericDate getNotBefore() {
		// TODO Auto-generated method stub
		return notBefore;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwt.JWTClaims#setNotBefore(za.co.sindi.jsonweb.NumericDate)
	 */
//	@Override
	public void setNotBefore(NumericDate notBefore) {
		// TODO Auto-generated method stub
		this.notBefore = notBefore;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwt.JWTClaims#getIssuedAt()
	 */
	@Override
	public NumericDate getIssuedAt() {
		// TODO Auto-generated method stub
		return issuedAt;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwt.JWTClaims#setIssuedAt(za.co.sindi.jsonweb.NumericDate)
	 */
//	@Override
	public void setIssuedAt(NumericDate issuedAt) {
		// TODO Auto-generated method stub
		this.issuedAt = issuedAt;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwt.JWTClaims#getJwtID()
	 */
	@Override
	public String getJwtID() {
		// TODO Auto-generated method stub
		return jwtID;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwt.JWTClaims#setJwtID(java.lang.String)
	 */
//	@Override
	public void setJwtID(String jwtID) {
		// TODO Auto-generated method stub
		this.jwtID = jwtID;
	}
}
