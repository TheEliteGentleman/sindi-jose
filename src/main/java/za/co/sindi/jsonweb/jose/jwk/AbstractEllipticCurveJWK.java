/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

import za.co.sindi.jsonweb.Base64URLUInt;
import za.co.sindi.jsonweb.json.JSONObjectBuilder;

/**
 * @author Bienfait Sindi
 * @since 22 April 2016
 *
 */
public abstract class AbstractEllipticCurveJWK extends AbstractJWK implements EllipticCurveJWK {

	private ECCurve curve;
	private Base64URLUInt coordinateX;
	
	/**
	 * 
	 */
	protected AbstractEllipticCurveJWK() {
		super(KeyType.EC);
		// TODO Auto-generated constructor stub
	}

//	/* (non-Javadoc)
//	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractJWK#read(za.co.sindi.jsonweb.json.JSONObject)
//	 */
//	@Override
//	public void read(JSONObject jsonObject) throws Exception {
//		// TODO Auto-generated method stub
//		super.read(jsonObject);
//		PreConditions.checkState(!jsonObject.isNull(Constants.EC_PARAM_CURVE), "No JWK Elliptic Curve parameter '" + Constants.EC_PARAM_CURVE + "' found.");
//		PreConditions.checkState(!jsonObject.isNull(Constants.EC_PARAM_X_COORDINATE), "No JWK Elliptic Curve parameter '" + Constants.EC_PARAM_X_COORDINATE + "' found.");
//		
//		setCurve(ECCurve.of(jsonObject.getString(Constants.EC_PARAM_CURVE)));
//		setCoordinateX(new Base64URLUInt(jsonObject.getString(Constants.EC_PARAM_X_COORDINATE)));
//	}

//	/* (non-Javadoc)
//	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractJWK#readFully(za.co.sindi.jsonweb.json.JSONObject)
//	 */
//	@Override
//	protected void readFully(JSONObject jsonObject) throws Exception {
//		// TODO Auto-generated method stub
//		PreConditions.checkState(!jsonObject.isNull(Constants.EC_PARAM_CURVE), "No JWK Elliptic Curve parameter '" + Constants.EC_PARAM_CURVE + "' found.");
//		PreConditions.checkState(!jsonObject.isNull(Constants.EC_PARAM_X_COORDINATE), "No JWK Elliptic Curve parameter '" + Constants.EC_PARAM_X_COORDINATE + "' found.");
//		
//		setCurve(ECCurve.of(jsonObject.getString(Constants.EC_PARAM_CURVE)));
//		setCoordinateX(new Base64URLUInt(jsonObject.getString(Constants.EC_PARAM_X_COORDINATE)));
//		readFullyInternally(jsonObject);
//	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractJWK#populateJSONObject(za.co.sindi.jsonweb.json.JSONObjectBuilder)
	 */
	@Override
	protected void populateJSONObject(JSONObjectBuilder jsonObjectBuilder) {
		// TODO Auto-generated method stub
		jsonObjectBuilder.add(JWKConstants.EC_PARAM_CURVE, getCurve().toString());
		jsonObjectBuilder.add(JWKConstants.EC_PARAM_X_COORDINATE, getCoordinateX().getJSONValue());
//		populateJSONObjectInternally(jsonObjectBuilder);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.EllipticCurveJWK#getCurve()
	 */
	public ECCurve getCurve() {
		// TODO Auto-generated method stub
//		return (ECCurve) getParameter(Constants.EC_PARAM_CURVE);
		return curve;
	}
	
	public void setCurve(ECCurve curve) {
		// TODO Auto-generated method stub
//		setParameter(Constants.EC_PARAM_CURVE, curve);
		this.curve = curve;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.EllipticCurveJWK#getCorordinateX()
	 */
	public Base64URLUInt getCoordinateX() {
		// TODO Auto-generated method stub
//		return (Base64URLUInt) getParameter(Constants.EC_PARAM_X_COORDINATE);
		return coordinateX;
	}
	
	public void setCoordinateX(Base64URLUInt coordinateX) {
		// TODO Auto-generated method stub
//		setParameter(Constants.EC_PARAM_X_COORDINATE, coordinateX);
		this.coordinateX = coordinateX;
	}
	
//	protected abstract void readFullyInternally(final JSONObject jsonObject) throws Exception;
//	protected abstract void populateJSONObjectInternally(final JSONObjectBuilder jsonObjectBuilder);
}
