/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

import za.co.sindi.jsonweb.Base64URLUInt;
import za.co.sindi.jsonweb.json.JSONObjectBuilder;

/**
 * @author Bienfait Sindi
 * @since 19 April 2016
 *
 */
public abstract class AbstractRSAJWK extends AbstractJWK implements RSAJWK {

	private Base64URLUInt modulus;
	private Base64URLUInt publicExponent;
	
	/**
	 * 
	 */
	protected AbstractRSAJWK() {
		super(KeyType.RSA);
		// TODO Auto-generated constructor stub
	}

//	/* (non-Javadoc)
//	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractJWK#read(za.co.sindi.jsonweb.json.JSONObject)
//	 */
//	@Override
//	public void read(JSONObject jsonObject) throws Exception {
//		// TODO Auto-generated method stub
//		super.read(jsonObject);
//		PreConditions.checkState(!jsonObject.isNull(Constants.RSA_PARAM_MODULUS), "No JWK RSA parameter '" + Constants.RSA_PARAM_MODULUS + "' found.");
//		PreConditions.checkState(!jsonObject.isNull(Constants.RSA_PARAM_EXPONENT_PUBLIC), "No RSA Curve parameter '" + Constants.RSA_PARAM_EXPONENT_PUBLIC + "' found.");
//		
//		setModulus(new Base64URLUInt(jsonObject.getString(Constants.RSA_PARAM_MODULUS)));
//		setPublicExponent(new Base64URLUInt(jsonObject.getString(Constants.RSA_PARAM_EXPONENT_PUBLIC)));
//	}

//	/* (non-Javadoc)
//	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractJWK#readFully(za.co.sindi.jsonweb.json.JSONObject)
//	 */
//	@Override
//	protected void readFully(JSONObject jsonObject) throws Exception {
//		// TODO Auto-generated method stub
//		PreConditions.checkState(!jsonObject.isNull(Constants.RSA_PARAM_MODULUS), "No JWK RSA parameter '" + Constants.RSA_PARAM_MODULUS + "' found.");
//		PreConditions.checkState(!jsonObject.isNull(Constants.RSA_PARAM_EXPONENT_PUBLIC), "No RSA Curve parameter '" + Constants.RSA_PARAM_EXPONENT_PUBLIC + "' found.");
//		
//		setModulus(new Base64URLUInt(jsonObject.getString(Constants.RSA_PARAM_MODULUS)));
//		setPublicExponent(new Base64URLUInt(jsonObject.getString(Constants.RSA_PARAM_EXPONENT_PUBLIC)));
//		readFullyInternally(jsonObject);
//	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractJWK#populateJSONObject(za.co.sindi.jsonweb.json.JSONObjectBuilder)
	 */
	@Override
	protected void populateJSONObject(JSONObjectBuilder jsonObjectBuilder) {
		// TODO Auto-generated method stub
		jsonObjectBuilder.add(JWKConstants.RSA_PARAM_MODULUS, getModulus().getJSONValue());
		jsonObjectBuilder.add(JWKConstants.RSA_PARAM_EXPONENT_PUBLIC, getPublicExponent().getJSONValue());
//		populateJSONObjectInternally(jsonObjectBuilder);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.RSAJWK#getModulus()
	 */
	public Base64URLUInt getModulus() {
		// TODO Auto-generated method stub
//		return (Base64URLUInt) getParameter(Constants.RSA_PARAM_MODULUS);
		return modulus;
	}
	
	public void setModulus(Base64URLUInt modulus) {
		// TODO Auto-generated method stub
//		setParameter(Constants.RSA_PARAM_MODULUS, modulus);
		this.modulus = modulus;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.RSAJWK#getPublicExponent()
	 */
	public Base64URLUInt getPublicExponent() {
		// TODO Auto-generated method stub
//		return (Base64URLUInt) getParameter(Constants.RSA_PARAM_EXPONENT_PUBLIC);
		return publicExponent;
	}
	
	public void setPublicExponent(Base64URLUInt exponent) {
		// TODO Auto-generated method stub
//		setParameter(Constants.RSA_PARAM_EXPONENT_PUBLIC, exponent);
		this.publicExponent = exponent;
	}
	
//	protected abstract void readFullyInternally(final JSONObject jsonObject) throws Exception;
//	protected abstract void populateJSONObjectInternally(final JSONObjectBuilder jsonObjectBuilder);
}
