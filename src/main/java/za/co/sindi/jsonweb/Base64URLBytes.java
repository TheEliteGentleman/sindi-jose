/**
 * 
 */
package za.co.sindi.jsonweb;

import za.co.sindi.codec.exception.DecodingException;
import za.co.sindi.codec.exception.EncodingException;
import za.co.sindi.common.utils.Strings;
import za.co.sindi.jsonweb.util.Base64URLUtils;

/**
 * @author Bienfait Sindi
 * @since 08 April 2016
 *
 */
public class Base64URLBytes implements Base64URL<byte[]> {

	private byte[] value;
	private String jsonValue;
	
	/**
	 * @param value
	 * @throws EncodingException 
	 */
	public Base64URLBytes(byte[] value) throws EncodingException {
		super();
		this.value = value;
		if (value != null) {
			jsonValue = new String(Base64URLUtils.base64UrlEncode(value));
		}
	}

	/**
	 * @param jsonValue
	 * @throws DecodingException 
	 */
	public Base64URLBytes(String jsonValue) throws DecodingException {
		super();
		this.jsonValue = jsonValue;
		if (!Strings.isNullOrEmpty(jsonValue)) {
			this.value = Base64URLUtils.base64UrlDecode(jsonValue.getBytes());
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.Value#getActualValue()
	 */
	public byte[] getActualValue() {
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
