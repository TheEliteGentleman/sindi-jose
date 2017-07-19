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
	
	public static byte[] encodeJwsJoseHeader(final JWSJOSEHeader jwsJOSEHeader) throws EncodingException {
//		PreConditions.checkArgument(jwsJOSEHeader != null, "No JWS JOSE Header was specified.");
		return base64UrlEncode(toUTF8Bytes(jwsJOSEHeader.toString()));
	}
	
	public static byte[] encodeJwsPayload(final JWSPayload jwsPayload) throws EncodingException {
//		PreConditions.checkArgument(jwsPayload != null, "No JWS Payload was specified.");
		return base64UrlEncode(jwsPayload.getEncoded());
	}
	
	public static byte[] generateJwsSigningInput(final JWSJOSEHeader jwsJoseHeader, final JWSPayload jwsPayload) throws EncodingException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			baos.write(encodeJwsJoseHeader(jwsJoseHeader));
			baos.write(JWSConstants.JWS_APPEND_SEPARATOR);
			baos.write(encodeJwsPayload(jwsPayload));
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return baos.toByteArray();
	}
}
