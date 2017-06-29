/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws;

import static za.co.sindi.codec.Strings.asUTF8String;
import static za.co.sindi.codec.Strings.toASCIIBytes;

import java.io.IOException;
import java.io.StringReader;
import java.security.GeneralSecurityException;
import java.security.Key;

import za.co.sindi.codec.exception.DecodingException;
import za.co.sindi.codec.exception.EncodingException;
import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.jose.jws.impl.DefaultJWSCryptographicAlgorithmFactory;
import za.co.sindi.jsonweb.jose.jws.impl.DefaultJWSObjectReader;
import za.co.sindi.jsonweb.json.JSONReader;
import za.co.sindi.jsonweb.json.JSONReaderFactory;
import za.co.sindi.jsonweb.json.impl.DefaultJSONReaderFactory;
import za.co.sindi.jsonweb.util.Base64URLUtils;

/**
 * @author Bienfait Sindi
 * @since 23 June 2017
 */
public abstract class JWSDeserialization {

	protected JWSCryptographicAlgorithmFactory jwsCryptographicAlgorithmFactory = new DefaultJWSCryptographicAlgorithmFactory();
	
	/**
	 * @param jwsCryptographicAlgorithmFactory the jwsCryptographicAlgorithmFactory to set
	 */
	public void setJwsCryptographicAlgorithmFactory(JWSCryptographicAlgorithmFactory jwsCryptographicAlgorithmFactory) {
		this.jwsCryptographicAlgorithmFactory = jwsCryptographicAlgorithmFactory;
	}
	
	protected byte[] base64UrlDecode(final String base64UrlEncodedString) throws DecodingException {
		return Base64URLUtils.base64UrlDecode(toASCIIBytes(base64UrlEncodedString));
	}
	
	protected JWSJOSEHeader decodeJwsJoseHeader(final String encodedJwsProtectedHeaderString) throws Exception {
		String jsonObjectString = asUTF8String(base64UrlDecode(encodedJwsProtectedHeaderString));
		JSONReaderFactory jsonReaderFactory = new DefaultJSONReaderFactory();
		JSONReader jsonObjectReader = jsonReaderFactory.createReader(new StringReader(jsonObjectString));
		JWSObjectReader jwsObjectReader = new DefaultJWSObjectReader();
		return jwsObjectReader.readObject(jsonObjectReader.readJSONObject());
	}
	
//	protected <T> T decodeJwsPayload(final String encodedJwsPayloadString, final JWSPayloadDecoder<T> jwsPayloadDecoder) throws DecodingException {
//		return jwsPayloadDecoder.decode(base64UrlDecode(toASCIIBytes(encodedJwsPayloadString)));
//	}
	
	protected boolean verifyJwsSignature(final JWSJOSEHeader jwsJoseHeader, final JWSPayload jwsPayload, final Key key, final byte[] jwsSignature) throws IOException, EncodingException, GeneralSecurityException {
		byte[] jwsSigningInput = JWSUtils.generateJwsSigningInput(jwsJoseHeader, jwsPayload);
		
		JWSVerificationCryptographicAlgorithm jwsCryptographicAlgorithm = jwsCryptographicAlgorithmFactory.newCryptographicAlgorithm(jwsJoseHeader.getAlgorithm());
		PreConditions.checkState(jwsCryptographicAlgorithm != null, "Couldn't find JWS Digital Signature algorithm for JWS Algorithm '" + jwsJoseHeader.getAlgorithm().getJwaAlgorithmName() + "'");
		jwsCryptographicAlgorithm.initVerify(key);
		jwsCryptographicAlgorithm.update(jwsSigningInput);
		return jwsCryptographicAlgorithm.verify(jwsSignature);
	}
	
	public abstract byte[] getUnsignedJwsPayload();
}
