/**
 * 
 */
package za.co.sindi.jsonweb;

import java.nio.charset.Charset;

import za.co.sindi.codec.exception.DecodingException;
import za.co.sindi.codec.exception.EncodingException;
import za.co.sindi.jsonweb.util.Base64URLUtils;

/**
 * @author Bienfait Sindi
 * @since 08 April 2016
 *
 */
public class Base64URLString implements Base64URL<String> {

	private String value;
	private String jsonValue;
	
	/**
	 * @param value
	 * @param charset
	 * @param encode
	 * @throws EncodingException 
	 * @throws DecodingException 
	 */
	public Base64URLString(String value, Charset charset, boolean encode) throws EncodingException, DecodingException {
		super();
		if (encode) {
			this.value = value;
			if (value != null) {
				jsonValue = new String(Base64URLUtils.base64UrlEncode(value.getBytes(charset)));
			}
		} else {
			this.jsonValue = value;
			if (value != null) {
				value = new String(Base64URLUtils.base64UrlDecode(value.getBytes(charset)));
			}
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.Value#getActualValue()
	 */
	public String getActualValue() {
		// TODO Auto-generated method stub
		return value;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.Value#getJSONValue()
	 */
	public String getJSONValue() {
		// TODO Auto-generated method stub
		return jsonValue;
	}
}
