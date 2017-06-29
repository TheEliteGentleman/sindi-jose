/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws;

import static za.co.sindi.codec.Strings.toUTF8Bytes;
import static za.co.sindi.jsonweb.util.Base64URLUtils.base64UrlEncode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import za.co.sindi.codec.exception.EncodingException;

/**
 * @author Bienfait Sindi
 * @since 19 June 2017
 *
 */
public final class JWSUtils {

	private JWSUtils() {
		throw new AssertionError("Private Constructor.");
	}
	
//	public static JWSJOSEHeader decodeJwsJoseHeader(final String encodedJwsProtectedHeaderString) throws Exception {
//		String jsonObjectString = asUTF8String(base64UrlDecode(toASCIIBytes(encodedJwsProtectedHeaderString)));
//		JSONReaderFactory jsonReaderFactory = new DefaultJSONReaderFactory();
//		JSONReader jsonObjectReader = jsonReaderFactory.createReader(new StringReader(jsonObjectString));
//		JWSObjectReader jwsObjectReader = new DefaultJWSObjectReader();
//		return jwsObjectReader.readObject(jsonObjectReader.readJSONObject());
//	}
//	
//	public static <T> T decodeJwsPayload(final String encodedJwsPayloadString, final JWSPayloadDecoder<T> jwsPayloadDecoder) throws DecodingException {
//		return jwsPayloadDecoder.decode(base64UrlDecode(toASCIIBytes(encodedJwsPayloadString)));
//	}
	
	private static byte[] encodeJwsJoseHeader(final JWSJOSEHeader jwsJOSEHeader) throws EncodingException {
//		PreConditions.checkArgument(jwsJOSEHeader != null, "No JWS JOSE Header was specified.");
		return base64UrlEncode(toUTF8Bytes(jwsJOSEHeader.toString()));
	}
	
	private static byte[] encodeJwsPayload(final JWSPayload jwsPayload) throws EncodingException {
//		PreConditions.checkArgument(jwsPayload != null, "No JWS Payload was specified.");
		return base64UrlEncode(jwsPayload.getEncoded());
	}
	
	public static byte[] generateJwsSigningInput(final JWSJOSEHeader jwsJoseHeader, final JWSPayload jwsPayload) throws IOException, EncodingException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos.write(encodeJwsJoseHeader(jwsJoseHeader));
		baos.write(JWSConstants.JWS_APPEND_SEPARATOR);
		baos.write(encodeJwsPayload(jwsPayload));
		return baos.toByteArray();
	}
	
//	public static byte[] generateJwsSignature(final byte[] jwsSigningInput, final Key key, final JWSAlgorithm jwsAlgorithm, JWSCryptographicAlgorithmFactory jwsCryptographicAlgorithmFactory) throws EncodingException, GeneralSecurityException {
////		PreConditions.checkArgument(jwsSigningInput != null && jwsSigningInput.length > 0, "No JWS Signing Input was specified.");
////		PreConditions.checkArgument(key != null, "No cryptographic key was specified.");
////		PreConditions.checkArgument(jwsAlgorithm != null, "No JWS Digital Signature Algorithm key was specified.");
////		PreConditions.checkState(jwsCryptographicAlgorithmFactory != null, "No JWS Digital Signature factory was specified.");
//		
//		JWSComputationCryptographicAlgorithm jwsCryptographicAlgorithm = jwsCryptographicAlgorithmFactory.newCryptographicAlgorithm(jwsAlgorithm);
//		PreConditions.checkState(jwsCryptographicAlgorithm != null, "Couldn't find JWS Digital Signature algorithm for JWS Algorithm '" + jwsAlgorithm.getJwaAlgorithmName() + "'");
//		jwsCryptographicAlgorithm.initSign(key);
//		jwsCryptographicAlgorithm.update(jwsSigningInput);
//		return base64UrlEncode(jwsCryptographicAlgorithm.compute());
//	}
	
//	public static boolean verifyJwsSignature(final JWSJOSEHeader jwsJoseHeader, final JWSPayload jwsPayload, final Key key, final byte[] jwsSignature, JWSCryptographicAlgorithmFactory jwsCryptographicAlgorithmFactory) throws IOException, EncodingException, GeneralSecurityException {
//		byte[] jwsSigningInput = generateJwsSigningInput(jwsJoseHeader, jwsPayload);
//		
//		JWSVerificationCryptographicAlgorithm jwsCryptographicAlgorithm = jwsCryptographicAlgorithmFactory.newCryptographicAlgorithm(jwsJoseHeader.getAlgorithm());
//		PreConditions.checkState(jwsCryptographicAlgorithm != null, "Couldn't find JWS Digital Signature algorithm for JWS Algorithm '" + jwsJoseHeader.getAlgorithm().getJwaAlgorithmName() + "'");
//		jwsCryptographicAlgorithm.initVerify(key);
//		jwsCryptographicAlgorithm.update(jwsSigningInput);
//		return jwsCryptographicAlgorithm.verify(jwsSignature);
//	}
}
