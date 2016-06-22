/**
 * 
 */
package za.co.sindi.jsonweb;

import java.nio.charset.Charset;

import za.co.sindi.codec.exception.EncodingException;

/**
 * @author Bienfait Sindi
 * @since 08 April 2016
 *
 */
public class Base64URLString extends Base64URL<String> {

	private String value;
	private String jsonValue;
	
	/**
	 * @param value
	 * @param charset
	 * @throws EncodingException 
	 */
	public Base64URLString(String value, Charset charset, boolean encode) throws EncodingException {
		super();
		if (encode) {
			this.value = value;
			if (value != null) {
				jsonValue = new String(getBase64urlCodec().encode(value.getBytes(charset)));
			}
		} else {
			this.jsonValue = value;
			if (value != null) {
				value = new String(getBase64urlCodec().encode(value.getBytes()), charset);
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
