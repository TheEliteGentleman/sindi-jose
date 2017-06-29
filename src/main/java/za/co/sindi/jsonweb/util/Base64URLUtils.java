/**
 * 
 */
package za.co.sindi.jsonweb.util;

import za.co.sindi.codec.Base64Codec;
import za.co.sindi.codec.BinaryCodec;
import za.co.sindi.codec.exception.DecodingException;
import za.co.sindi.codec.exception.EncodingException;

/**
 * @author Bienfait Sindi
 * @since 13 June 2017
 *
 */
public final class Base64URLUtils {

	private static final BinaryCodec BASE64_CODEC = Base64Codec.getBase64UrlSafeCodec().withoutPadding();
//	private static final Encoder BASE64_ENCODER = Base64.getUrlEncoder();
//	private static final Decoder BASE64_DECODER = Base64.getUrlDecoder();
	
	/**
	 * 
	 */
	private Base64URLUtils() {
		super();
		// TODO Auto-generated constructor stub
		throw new AssertionError("Private Constructor.");
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.codec.BinaryEncoder#encode(byte[])
	 */
	public static byte[] base64UrlEncode(byte[] data) throws EncodingException {
		// TODO Auto-generated method stub
		return BASE64_CODEC.encode(data);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.codec.BinaryDecoder#decode(byte[])
	 */
	public static byte[] base64UrlDecode(byte[] data) throws DecodingException {
		// TODO Auto-generated method stub
		return BASE64_CODEC.decode(data);
	}
}
