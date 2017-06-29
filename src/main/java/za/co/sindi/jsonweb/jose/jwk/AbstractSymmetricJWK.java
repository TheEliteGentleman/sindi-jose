/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

import za.co.sindi.jsonweb.Base64URLBytes;
import za.co.sindi.jsonweb.json.JSONObjectBuilder;

/**
 * @author Bienfait Sindi
 * @since 28 April 2016
 *
 */
public abstract class AbstractSymmetricJWK extends AbstractJWK implements SymmetricJWK {

	private Base64URLBytes keyValue;
	
	/**
	 * 
	 */
	protected AbstractSymmetricJWK() {
		super(KeyType.OCT);
	}
	
//	/**
//	 * @param keyValue
//	 */
//	protected AbstractSymmetricJWK(Base64URLBytes keyValue) {
//		this(keyValue, null);
//	}
//	
//	/**
//	 * @param keyValue
//	 * @param algorithm
//	 */
//	protected AbstractSymmetricJWK(Base64URLBytes keyValue, Algorithm algorithm) {
//		this();
//		PreConditions.checkArgument(keyValue != null, "Symmetric key value is required.");
//		setAlgorithm(algorithm);
//		setKeyValue(keyValue);
////		this.keyValue = keyValue;
//	}
	
	public void setKeyValue(Base64URLBytes keyValue) {
//		setParameter(Constants.OCT_PARAM_KEY_VALUE, keyValue);
		this.keyValue = keyValue;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.SymmetricJWK#getKeyValue()
	 */
	public Base64URLBytes getKeyValue() {
		// TODO Auto-generated method stub
//		return (Base64URLBytes) getParameter(Constants.OCT_PARAM_KEY_VALUE);
		return keyValue;
	}

//	/* (non-Javadoc)
//	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractJWK#read(za.co.sindi.jsonweb.json.JSONObject)
//	 */
//	@Override
//	public void read(JSONObject jsonObject) throws Exception {
//		// TODO Auto-generated method stub
//		super.read(jsonObject);
//		PreConditions.checkState(!jsonObject.isNull(Constants.OCT_PARAM_KEY_VALUE), "JWK Symmetric key value '" + Constants.OCT_PARAM_KEY_VALUE + "' is null or doesn't exist.");
////		setKeyValue(new Base64URLBytes(jsonObject.getString(Constants.OCT_PARAM_KEY_VALUE)));
//		keyValue = new Base64URLBytes(jsonObject.getString(Constants.OCT_PARAM_KEY_VALUE));
//	}

//	/* (non-Javadoc)
//	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractJWK#readFully(za.co.sindi.jsonweb.json.JSONObject)
//	 */
//	@Override
//	protected void readFully(JSONObject jsonObject) throws Exception {
//		// TODO Auto-generated method stub
//		PreConditions.checkState(!jsonObject.isNull(Constants.OCT_PARAM_KEY_VALUE), "JWK Symmetric key value '" + Constants.OCT_PARAM_KEY_VALUE + "' is null or doesn't exist.");
////		setKeyValue(new Base64URLBytes(jsonObject.getString(Constants.OCT_PARAM_KEY_VALUE)));
//		keyValue = new Base64URLBytes(jsonObject.getString(Constants.OCT_PARAM_KEY_VALUE));
//	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractJWK#populateJSONObject(za.co.sindi.jsonweb.json.JSONObjectBuilder)
	 */
	@Override
	protected void populateJSONObject(JSONObjectBuilder jsonObjectBuilder) {
		// TODO Auto-generated method stub
		jsonObjectBuilder.add(JWKConstants.OCT_PARAM_KEY_VALUE, getKeyValue().getJSONValue());
	}
}
