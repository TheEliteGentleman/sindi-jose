/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk.impl;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.Base64URLUInt;
import za.co.sindi.jsonweb.jose.jwk.AbstractRSAJWK;
import za.co.sindi.jsonweb.jose.jwk.Constants;
import za.co.sindi.jsonweb.jose.jwk.PrivateJWK;
import za.co.sindi.jsonweb.jose.jwk.PublicJWK;
import za.co.sindi.jsonweb.jose.jwk.RSAPrivateJWK;
import za.co.sindi.jsonweb.jose.jwk.RSAPublicJWK;
import za.co.sindi.jsonweb.json.JSONObject;
import za.co.sindi.jsonweb.json.JSONObjectBuilder;

/**
 * @author Bienfait Sindi
 * @since 29 April 2016
 *
 */
public class JWKRSAKey extends AbstractRSAJWK implements RSAPublicJWK, RSAPrivateJWK, PublicJWK, PrivateJWK {
	
	private Base64URLUInt privateExponent;
	private Base64URLUInt firstPrimeFactor;
	private Base64URLUInt secondPrimeFactor;
	private Base64URLUInt firstFactorCRTExponent;
	private Base64URLUInt secondFactorCRTExponent;
	private Base64URLUInt firstCRTCoefficient;
	private List<OtherPrimesInfo> otherPrimes;

	/**
	 * 
	 */
	public JWKRSAKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 */
	public JWKRSAKey(Base64URLUInt modulus, Base64URLUInt publicExponent) {
		this(modulus, publicExponent, null, null, null, null, null, null);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param modulus
	 * @param publicExponent
	 * @param privateExponent
	 * @param primeP
	 * @param primeQ
	 * @param primeExponentP
	 * @param primeExponentQ
	 * @param crtCoefficient
	 */
	public JWKRSAKey(Base64URLUInt modulus, Base64URLUInt publicExponent, Base64URLUInt privateExponent, Base64URLUInt primeP, Base64URLUInt primeQ, Base64URLUInt primeExponentP, Base64URLUInt primeExponentQ, Base64URLUInt crtCoefficient) {
		super();
		// TODO Auto-generated constructor stub
		PreConditions.checkArgument(modulus != null, "RSA modulus is required.");
		PreConditions.checkArgument(publicExponent != null, "RSA public exponent is required.");
		if (privateExponent != null) {
			PreConditions.checkArgument(primeP != null, "RSA first prime factor is required.");
			PreConditions.checkArgument(primeQ != null, "RSA second prime factor is required.");
			PreConditions.checkArgument(primeExponentP != null, "RSA first prime exponent is required.");
			PreConditions.checkArgument(primeExponentQ != null, "RSA second exponent is required.");
			PreConditions.checkArgument(crtCoefficient != null, "RSA CRT coefficient is required.");
		}
		
		setModulus(modulus);
		setPublicExponent(publicExponent);
		setPrivateExponent(privateExponent);
		setFirstPrimeFactor(primeP);
		setSecondPrimeFactor(primeP);
		setFirstFactorCRTExponent(primeExponentP);
		setSecondFactorCRTExponent(primeExponentQ);
		setFirstCRTCoefficient(crtCoefficient);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.PrivateJWK#toJCAPrivateKey()
	 */
	@Override
	public PrivateKey toJCAPrivateKey() throws GeneralSecurityException {
		// TODO Auto-generated method stub
		Base64URLUInt modulus = getModulus();
		Base64URLUInt publicExponent = getPublicExponent();
		Base64URLUInt privateExponent = getPrivateExponent();
		Base64URLUInt primeP = getFirstPrimeFactor();
		Base64URLUInt primeQ = getSecondPrimeFactor();
		Base64URLUInt primeExponentP = getFirstFactorCRTExponent();
		Base64URLUInt primeExponentQ = getSecondFactorCRTExponent();
		Base64URLUInt crtCoefficient = getFirstCRTCoefficient();
		
		PreConditions.checkState(modulus != null, "JWK RSA modulus is required.");
		PreConditions.checkState(publicExponent != null, "JWK RSA public exponent is required.");
		PreConditions.checkState(privateExponent != null, "JWK RSA private exponent is required.");
		PreConditions.checkState(primeP != null, "JWK RSA first prime factor is required.");
		PreConditions.checkState(primeQ != null, "JWK RSA second prime factor is required.");
		PreConditions.checkState(primeExponentP != null, "JWK RSA first prime exponent is required.");
		PreConditions.checkState(primeExponentQ != null, "JWK RSA second exponent is required.");
		PreConditions.checkState(crtCoefficient != null, "JWK RSA CRT coefficient is required.");
		
		return KeyFactory.getInstance("RSA").generatePrivate(new RSAPrivateCrtKeySpec(modulus.getActualValue(), publicExponent.getActualValue(), privateExponent.getActualValue(), primeP.getActualValue(), primeQ.getActualValue(), primeExponentP.getActualValue(), primeExponentQ.getActualValue(), crtCoefficient.getActualValue()));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.PublicJWK#toJCAPublicKey()
	 */
	@Override
	public PublicKey toJCAPublicKey() throws GeneralSecurityException {
		// TODO Auto-generated method stub
		Base64URLUInt modulus = getModulus();
		Base64URLUInt publicExponent = getPublicExponent();
		PreConditions.checkState(modulus != null, "JWK RSA modulus is required.");
		PreConditions.checkState(publicExponent != null, "JWK RSA public exponent is required.");
		
		return KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(modulus.getActualValue(), publicExponent.getActualValue()));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.RSAPrivateJWK#getPrivateExponent()
	 */
	@Override
	public Base64URLUInt getPrivateExponent() {
		// TODO Auto-generated method stub
//		return (Base64URLUInt) getParameter(Constants.RSA_PARAM_EXPONENT_PRIVATE);
		return privateExponent;
	}
	
	private void setPrivateExponent(Base64URLUInt privateExponent) {
		// TODO Auto-generated method stub
//		setParameter(Constants.RSA_PARAM_EXPONENT_PRIVATE, privateExponent);
		this.privateExponent = privateExponent;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.RSAPrivateJWK#getFirstPrimeFactor()
	 */
	@Override
	public Base64URLUInt getFirstPrimeFactor() {
		// TODO Auto-generated method stub
//		return (Base64URLUInt) getParameter(Constants.RSA_PARAM_FIRST_PRIME_FACTOR);
		return firstPrimeFactor;
	}
	
	private void setFirstPrimeFactor(Base64URLUInt firstPrimeFactor) {
		// TODO Auto-generated method stub
//		setParameter(Constants.RSA_PARAM_FIRST_PRIME_FACTOR, firstPrimeFactor);
		this.firstPrimeFactor = firstPrimeFactor;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.RSAPrivateJWK#getSecondPrimeFactor()
	 */
	@Override
	public Base64URLUInt getSecondPrimeFactor() {
		// TODO Auto-generated method stub
//		return (Base64URLUInt) getParameter(Constants.RSA_PARAM_SECOND_PRIME_FACTOR);
		return secondPrimeFactor;
	}
	
	private void setSecondPrimeFactor(Base64URLUInt secondPrimeFactor) {
		// TODO Auto-generated method stub
//		setParameter(Constants.RSA_PARAM_SECOND_PRIME_FACTOR, secondPrimeFactor);
		this.secondPrimeFactor = secondPrimeFactor;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.RSAPrivateJWK#getFirstFactorCRTExponent()
	 */
	@Override
	public Base64URLUInt getFirstFactorCRTExponent() {
		// TODO Auto-generated method stub
//		return (Base64URLUInt) getParameter(Constants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT);
		return firstFactorCRTExponent;
	}
	
	private void setFirstFactorCRTExponent(Base64URLUInt firstFactorCRTExponent) {
		// TODO Auto-generated method stub
//		setParameter(Constants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT, firstFactorCRTExponent);
		this.firstFactorCRTExponent = firstFactorCRTExponent;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.RSAPrivateJWK#getSecondFactorCRTExponent()
	 */
	@Override
	public Base64URLUInt getSecondFactorCRTExponent() {
		// TODO Auto-generated method stub
//		return (Base64URLUInt) getParameter(Constants.RSA_PARAM_SECOND_FACTOR_CRT_EXPONENT);
		return secondFactorCRTExponent;
	}
	
	private void setSecondFactorCRTExponent(Base64URLUInt secondFactorCRTExponent) {
		// TODO Auto-generated method stub
//		setParameter(Constants.RSA_PARAM_SECOND_FACTOR_CRT_EXPONENT, secondFactorCRTExponent);
		this.secondFactorCRTExponent = secondFactorCRTExponent;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.RSAPrivateJWK#getFirstCRTCoefficient()
	 */
	@Override
	public Base64URLUInt getFirstCRTCoefficient() {
		// TODO Auto-generated method stub
//		return (Base64URLUInt) getParameter(Constants.RSA_PARAM_FIRST_CRT_COEFFICIENT);
		return firstCRTCoefficient;
	}
	
	private void setFirstCRTCoefficient(Base64URLUInt firstCRTCoefficient) {
		// TODO Auto-generated method stub
//		setParameter(Constants.RSA_PARAM_FIRST_CRT_COEFFICIENT, firstCRTCoefficient);
		this.firstCRTCoefficient = firstCRTCoefficient;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.RSAPrivateJWK#getOtherPrimes()
	 */
	@Override
	public OtherPrimesInfo[] getOtherPrimes() {
		// TODO Auto-generated method stub
//		return (OtherPrimesInfo[]) getParameter(Constants.RSA_PARAM_OTH);
		if (otherPrimes != null) {
			return otherPrimes.toArray(new OtherPrimesInfo[otherPrimes.size()]);
		}
		
		return null;
	}
	
	private void setOtherPrimes(OtherPrimesInfo[] otherPrimes) {
		// TODO Auto-generated method stub
//		setParameter(Constants.RSA_PARAM_OTH, otherPrimes);
		if (otherPrimes != null) {
			if (this.otherPrimes == null) {
				this.otherPrimes = new ArrayList<OtherPrimesInfo>();
				this.otherPrimes.addAll(Arrays.asList(otherPrimes));
			}
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractRSAJWK#read(za.co.sindi.jsonweb.json.JSONObject)
	 */
	@Override
	public void read(JSONObject jsonObject) throws Exception {
		// TODO Auto-generated method stub
		super.read(jsonObject);
		if (!jsonObject.isNull(Constants.RSA_PARAM_EXPONENT_PRIVATE)) {
			setPrivateExponent(new Base64URLUInt(jsonObject.getString(Constants.RSA_PARAM_EXPONENT_PRIVATE)));
			
			PreConditions.checkState(!jsonObject.isNull(Constants.RSA_PARAM_FIRST_PRIME_FACTOR), "JWK RSA key requires the '" + Constants.RSA_PARAM_FIRST_PRIME_FACTOR + "' parameter.");
			setFirstPrimeFactor(new Base64URLUInt(jsonObject.getString(Constants.RSA_PARAM_FIRST_PRIME_FACTOR)));
			
			PreConditions.checkState(!jsonObject.isNull(Constants.RSA_PARAM_SECOND_PRIME_FACTOR), "JWK RSA key requires the '" + Constants.RSA_PARAM_SECOND_PRIME_FACTOR + "' parameter.");
			setSecondPrimeFactor(new Base64URLUInt(jsonObject.getString(Constants.RSA_PARAM_SECOND_PRIME_FACTOR)));
			
			PreConditions.checkState(!jsonObject.isNull(Constants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT), "JWK RSA key requires the '" + Constants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT + "' parameter.");
			setFirstFactorCRTExponent(new Base64URLUInt(jsonObject.getString(Constants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT)));
			
			PreConditions.checkState(!jsonObject.isNull(Constants.RSA_PARAM_SECOND_FACTOR_CRT_EXPONENT), "JWK RSA key requires the '" + Constants.RSA_PARAM_SECOND_FACTOR_CRT_EXPONENT + "' parameter.");
			setSecondFactorCRTExponent(new Base64URLUInt(jsonObject.getString(Constants.RSA_PARAM_SECOND_FACTOR_CRT_EXPONENT)));
			
			PreConditions.checkState(!jsonObject.isNull(Constants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT), "JWK RSA key requires the '" + Constants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT + "' parameter.");
			setFirstCRTCoefficient(new Base64URLUInt(jsonObject.getString(Constants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT)));
		}
	}

//	/* (non-Javadoc)
//	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractRSAJWK#readFullyInternally(za.co.sindi.jsonweb.json.JSONObject)
//	 */
//	@Override
//	protected void readFullyInternally(JSONObject jsonObject) throws Exception {
//		// TODO Auto-generated method stub
//		if (!jsonObject.isNull(Constants.RSA_PARAM_EXPONENT_PRIVATE)) {
//			setPrivateExponent(new Base64URLUInt(jsonObject.getString(Constants.RSA_PARAM_EXPONENT_PRIVATE)));
//			
//			PreConditions.checkState(!jsonObject.isNull(Constants.RSA_PARAM_FIRST_PRIME_FACTOR), "JWK RSA key requires the '" + Constants.RSA_PARAM_FIRST_PRIME_FACTOR + "' parameter.");
//			setFirstPrimeFactor(new Base64URLUInt(jsonObject.getString(Constants.RSA_PARAM_FIRST_PRIME_FACTOR)));
//			
//			PreConditions.checkState(!jsonObject.isNull(Constants.RSA_PARAM_SECOND_PRIME_FACTOR), "JWK RSA key requires the '" + Constants.RSA_PARAM_SECOND_PRIME_FACTOR + "' parameter.");
//			setSecondPrimeFactor(new Base64URLUInt(jsonObject.getString(Constants.RSA_PARAM_SECOND_PRIME_FACTOR)));
//			
//			PreConditions.checkState(!jsonObject.isNull(Constants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT), "JWK RSA key requires the '" + Constants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT + "' parameter.");
//			setFirstFactorCRTExponent(new Base64URLUInt(jsonObject.getString(Constants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT)));
//			
//			PreConditions.checkState(!jsonObject.isNull(Constants.RSA_PARAM_SECOND_FACTOR_CRT_EXPONENT), "JWK RSA key requires the '" + Constants.RSA_PARAM_SECOND_FACTOR_CRT_EXPONENT + "' parameter.");
//			setSecondFactorCRTExponent(new Base64URLUInt(jsonObject.getString(Constants.RSA_PARAM_SECOND_FACTOR_CRT_EXPONENT)));
//			
//			PreConditions.checkState(!jsonObject.isNull(Constants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT), "JWK RSA key requires the '" + Constants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT + "' parameter.");
//			setFirstCRTCoefficient(new Base64URLUInt(jsonObject.getString(Constants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT)));
//		}
//	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractRSAJWK#populateJSONObject(za.co.sindi.jsonweb.json.JSONObjectBuilder)
	 */
	@Override
	protected void populateJSONObject(JSONObjectBuilder jsonObjectBuilder) {
		// TODO Auto-generated method stub
		super.populateJSONObject(jsonObjectBuilder);
		if (privateExponent != null) {
			jsonObjectBuilder.add(Constants.RSA_PARAM_EXPONENT_PRIVATE, getPrivateExponent().getJSONValue());
			jsonObjectBuilder.add(Constants.RSA_PARAM_FIRST_PRIME_FACTOR, getFirstPrimeFactor().getJSONValue());
			jsonObjectBuilder.add(Constants.RSA_PARAM_SECOND_PRIME_FACTOR, getSecondPrimeFactor().getJSONValue());
			jsonObjectBuilder.add(Constants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT, getFirstFactorCRTExponent().getJSONValue());
			jsonObjectBuilder.add(Constants.RSA_PARAM_SECOND_FACTOR_CRT_EXPONENT, getSecondFactorCRTExponent().getJSONValue());
			jsonObjectBuilder.add(Constants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT, getFirstCRTCoefficient().getJSONValue());
		}
	}

//	/* (non-Javadoc)
//	 * @see za.co.sindi.jsonweb.jose.jwk.AbstractRSAJWK#populateJSONObjectInternally(za.co.sindi.jsonweb.json.JSONObjectBuilder)
//	 */
//	@Override
//	protected void populateJSONObjectInternally(JSONObjectBuilder jsonObjectBuilder) {
//		// TODO Auto-generated method stub
//		if (privateExponent != null) {
//			jsonObjectBuilder.add(Constants.RSA_PARAM_EXPONENT_PRIVATE, getPrivateExponent().getJSONValue());
//			jsonObjectBuilder.add(Constants.RSA_PARAM_FIRST_PRIME_FACTOR, getFirstPrimeFactor().getJSONValue());
//			jsonObjectBuilder.add(Constants.RSA_PARAM_SECOND_PRIME_FACTOR, getSecondPrimeFactor().getJSONValue());
//			jsonObjectBuilder.add(Constants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT, getFirstFactorCRTExponent().getJSONValue());
//			jsonObjectBuilder.add(Constants.RSA_PARAM_SECOND_FACTOR_CRT_EXPONENT, getSecondFactorCRTExponent().getJSONValue());
//			jsonObjectBuilder.add(Constants.RSA_PARAM_FIRST_FACTOR_CRT_EXPONENT, getFirstCRTCoefficient().getJSONValue());
//		}
//	}
}
