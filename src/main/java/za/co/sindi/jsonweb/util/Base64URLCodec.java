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
 * @since 31 March 2016
 *
 */
public class Base64URLCodec extends BinaryCodec {
	
	private static final BinaryCodec BASE64_CODEC = Base64Codec.getBase64Codec().withoutPadding();
	
	/* (non-Javadoc)
	 * @see za.co.sindi.codec.BinaryEncoder#encode(byte[])
	 */
	public byte[] encode(byte[] data) throws EncodingException {
		// TODO Auto-generated method stub
		return BASE64_CODEC.encode(data);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.codec.BinaryDecoder#decode(byte[])
	 */
	public byte[] decode(byte[] data) throws DecodingException {
		// TODO Auto-generated method stub
		return BASE64_CODEC.decode(data);
	}


//	/* (non-Javadoc)
//	 * @see za.co.sindi.codec.StringEncoder#encode(java.lang.String)
//	 */
//	public String encode(String data) throws EncodingException {
//		// TODO Auto-generated method stub
//		if (data == null || data.isEmpty()) {
//			return data;
//		}
//		
//		String encoded = new String(BASE64_ENCODER.encode(data.getBytes(CHARSET_DEFAULT)), charset);
//		return encoded.replaceAll("=", "");
//	}
//
//	/* (non-Javadoc)
//	 * @see za.co.sindi.codec.StringDecoder#decode(java.lang.String)
//	 */
//	public String decode(String data) throws DecodingException {
//		// TODO Auto-generated method stub
//		if (data == null || data.isEmpty()) {
//			return data;
//		}
//		
//		String value = data;
//		int remainderCount = data.length() % 4; 
//		if (remainderCount != 0) {
//			value += Strings.repeat("=", 4 - remainderCount);
//		}
//		
//		String decoded = new String(BASE64_DECODER.decode(value.getBytes(charset)), CHARSET_DEFAULT);
//		return decoded;
//	}
}
