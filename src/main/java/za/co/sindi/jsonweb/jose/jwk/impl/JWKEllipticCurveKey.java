/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk.impl;

import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.Base64URLUInt;
import za.co.sindi.jsonweb.jose.jwk.AbstractEllipticCurveJWK;
import za.co.sindi.jsonweb.jose.jwk.JWKConstants;
import za.co.sindi.jsonweb.jose.jwk.ECCurve;
import za.co.sindi.jsonweb.jose.jwk.EllipticCurveJWK;
import za.co.sindi.jsonweb.jose.jwk.EllipticCurvePrivateJWK;
import za.co.sindi.jsonweb.jose.jwk.EllipticCurvePublicJWK;
import za.co.sindi.jsonweb.jose.jwk.JCAECGenParameterSpecs;
import za.co.sindi.jsonweb.jose.jwk.JWK;
import za.co.sindi.jsonweb.jose.jwk.PrivateJWK;
import za.co.sindi.jsonweb.jose.jwk.PublicJWK;
import za.co.sindi.jsonweb.json.JSONObjectBuilder;

/**
 * @author Bienfait Sindi
 * @since 18 April 2016
 *
 */
public class JWKEllipticCurveKey extends AbstractEllipticCurveJWK implements EllipticCurvePublicJWK, EllipticCurvePrivateJWK, EllipticCurveJWK, PublicJWK, PrivateJWK, JWK {
	
	private Base64URLUInt coordinateY;
	private Base64URLUInt privateKey;
	
	/**
	 * 
	 */
	public JWKEllipticCurveKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	/**
//	 * @param curve - Elliptic Curves
//	 * @param x - x coordinate
//	 * @param y - y coordinate
//	 * @see ECCurve
//	 */
//	public JWKEllipticCurveKey(ECCurve curve, Base64URLUInt x, Base64URLUInt y) {
//		this(curve, x, y, null);
//		// TODO Auto-generated constructor stub
//	}
//	
//	/** 
//	 * @param x - x coordinate
//	 * @param y - y coordinate
//	 * @param d - private key
//	 */
//	public JWKEllipticCurveKey(ECCurve curve, Base64URLUInt x, Base64URLUInt y, Base64URLUInt d) {
//		super();
//		// TODO Auto-generated constructor stub
//		PreConditions.checkArgument(curve != null, "Elliptic Curve ECCurve is required.");
//		PreConditions.checkArgument(x != null, "Elliptic Curve X coordinate is required.");
//		PreConditions.checkArgument(y != null, "Elliptic Curve Y coordinate is required.");
//		
//		setCurve(curve);
//		setCoordinateX(x);
//		setCoordinateY(y);
//		setPrivateKey(d);
//	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.EllipticCurvePublicJWK#getCoordinateY()
	 */
	@Override
	public Base64URLUInt getCoordinateY() {
		// TODO Auto-generated method stub
//		return (Base64URLUInt) getParameter(Constants.EC_PARAM_Y_COORDINATE);
		return coordinateY;
	}
	
	public void setCoordinateY(Base64URLUInt coordinateY) {
		// TODO Auto-generated method stub
//		setParameter(Constants.EC_PARAM_Y_COORDINATE, coordinateY);
		this.coordinateY = coordinateY;
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.EllipticCurvePrivateJWK#getPrivateKey()
	 */
	@Override
	public Base64URLUInt getPrivateKey() {
		// TODO Auto-generated method stub
//		return (Base64URLUInt) getParameter(Constants.EC_PARAM_ECC_PRIVATE_KEY);
		return privateKey;
	}

	public void setPrivateKey(Base64URLUInt privateKey) {
		// TODO Auto-generated method stub
//		setParameter(Constants.EC_PARAM_ECC_PRIVATE_KEY, privateKey);
		this.privateKey = privateKey;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.PublicJWK#toJCAPublicKey()
	 */
	@Override
	public PublicKey toJCAPublicKey() throws GeneralSecurityException {
		// TODO Auto-generated method stub
		ECCurve curve = getCurve();
		Base64URLUInt coordinateX = getCoordinateX();
		Base64URLUInt coordinateY = getCoordinateY();
		PreConditions.checkState(curve != null, "Elliptic Curve ECCurve is required.");
		PreConditions.checkState(coordinateX != null, "Elliptic Curve point X is required.");
		PreConditions.checkState(coordinateY != null, "Elliptic Curve point Y is required.");
		
		AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("EC", "SunEC");
		algorithmParameters.init(JCAECGenParameterSpecs.getECGenParameterSpec(curve));
		ECParameterSpec ecParameter = algorithmParameters.getParameterSpec(ECParameterSpec.class);
		ECPublicKeySpec publicKeySpec = new ECPublicKeySpec(new ECPoint(coordinateX.getActualValue(), coordinateY.getActualValue()), ecParameter);
		KeyFactory keyFactory = KeyFactory.getInstance("EC");
		return keyFactory.generatePublic(publicKeySpec);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.PrivateJWK#toJCAPrivateKey()
	 */
	@Override
	public PrivateKey toJCAPrivateKey() throws GeneralSecurityException {
		// TODO Auto-generated method stub
		ECCurve curve = getCurve();
		Base64URLUInt privateKey = getPrivateKey();
		PreConditions.checkState(curve != null, "Elliptic Curve ECCurve is required.");
		PreConditions.checkState(privateKey != null, "Elliptic Curve private key is required.");
		
		AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("EC", "SunEC");
		algorithmParameters.init(JCAECGenParameterSpecs.getECGenParameterSpec(curve));
		ECParameterSpec ecParameter = algorithmParameters.getParameterSpec(ECParameterSpec.class);
		ECPrivateKeySpec privateKeySpec = new ECPrivateKeySpec(privateKey.getActualValue(), ecParameter);
		KeyFactory keyFactory = KeyFactory.getInstance("EC");
		return keyFactory.generatePrivate(privateKeySpec);
	}

//	/* (non-Javadoc)
//	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractEllipticCurveJWK#read(za.co.sindi.jsonweb.json.JSONObject)
//	 */
//	@Override
//	public void read(JSONObject jsonObject) throws Exception {
//		// TODO Auto-generated method stub
//		super.read(jsonObject);
//		if (jsonObject.isNull(Constants.EC_PARAM_Y_COORDINATE)) {
//			throw new IllegalStateException("EC JWK parameter '" + Constants.EC_PARAM_Y_COORDINATE + "' is null or doesn't exist.");
//		}
//		
//		setCoordinateY(new Base64URLUInt(jsonObject.getString(Constants.EC_PARAM_Y_COORDINATE)));
//		if (!jsonObject.isNull(Constants.EC_PARAM_ECC_PRIVATE_KEY)) {
//			setPrivateKey(new Base64URLUInt(jsonObject.getString(Constants.EC_PARAM_ECC_PRIVATE_KEY)));
//		}
//	}

//	/* (non-Javadoc)
//	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractEllipticCurveJWK#readFullyInternally(za.co.sindi.jsonweb.json.JSONObject)
//	 */
//	@Override
//	protected void readFullyInternally(JSONObject jsonObject) throws Exception {
//		// TODO Auto-generated method stub
//		if (jsonObject.isNull(Constants.EC_PARAM_Y_COORDINATE)) {
//			throw new IllegalStateException("EC JWK parameter '" + Constants.EC_PARAM_Y_COORDINATE + "' is null or doesn't exist.");
//		}
//		
//		setCoordinateY(new Base64URLUInt(jsonObject.getString(Constants.EC_PARAM_Y_COORDINATE)));
//		if (!jsonObject.isNull(Constants.EC_PARAM_ECC_PRIVATE_KEY)) {
//			setPrivateKey(new Base64URLUInt(jsonObject.getString(Constants.EC_PARAM_ECC_PRIVATE_KEY)));
//		}
//	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractEllipticCurveJWK#populateJSONObject(za.co.sindi.jsonweb.json.JSONObjectBuilder)
	 */
	@Override
	protected void populateJSONObject(JSONObjectBuilder jsonObjectBuilder) {
		// TODO Auto-generated method stub
		super.populateJSONObject(jsonObjectBuilder);
		jsonObjectBuilder.add(JWKConstants.EC_PARAM_Y_COORDINATE, getCoordinateY().getJSONValue());
		Base64URLUInt privateKey = getPrivateKey();
		if (privateKey != null) {
			jsonObjectBuilder.add(JWKConstants.EC_PARAM_ECC_PRIVATE_KEY, privateKey.getJSONValue());
		}
	}

//	/* (non-Javadoc)
//	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractEllipticCurveJWK#populateJSONObjectInternally(za.co.sindi.jsonweb.json.JSONObjectBuilder)
//	 */
//	@Override
//	protected void populateJSONObjectInternally(JSONObjectBuilder jsonObjectBuilder) {
//		// TODO Auto-generated method stub
//		jsonObjectBuilder.add(Constants.EC_PARAM_Y_COORDINATE, getCoordinateY().getJSONValue());
//		Base64URLUInt privateKey = getPrivateKey();
//		if (privateKey != null) {
//			jsonObjectBuilder.add(Constants.EC_PARAM_ECC_PRIVATE_KEY, privateKey.getJSONValue());
//		}
//	}
}
