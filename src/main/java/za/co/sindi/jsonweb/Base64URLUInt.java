/**
 * 
 */
package za.co.sindi.jsonweb;

import java.math.BigInteger;

import za.co.sindi.codec.exception.DecodingException;
import za.co.sindi.codec.exception.EncodingException;
import za.co.sindi.common.utils.Strings;

/**
 * @author Bienfait Sindi
 * @since 08 April 2016
 *
 */
public class Base64URLUInt extends Base64URL<BigInteger> {

	private BigInteger value;
	private String jsonValue;
	
	/**
	 * @param value
	 * @throws EncodingException 
	 */
	public Base64URLUInt(BigInteger value) throws EncodingException {
		super();
		this.value = value;
		if (value != null) {
			jsonValue = new String(getBase64urlCodec().encode(value.toByteArray()));
		}
	}

	/**
	 * @param jsonValue
	 * @throws DecodingException 
	 */
	public Base64URLUInt(String jsonValue) throws DecodingException {
		super();
		this.jsonValue = jsonValue;
		if (!Strings.isNullOrEmpty(jsonValue)) {
			this.value = new BigInteger(1, getBase64urlCodec().decode(jsonValue.getBytes()));
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.Value#getActualValue()
	 */
	public BigInteger getActualValue() {
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
	
	public static void main(String[] args) {
		try {
			System.out.println(new Base64URLUInt(BigInteger.ONE).getJSONValue());
		} catch (EncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
