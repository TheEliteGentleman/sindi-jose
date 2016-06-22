/**
 * 
 */
package za.co.sindi.jsonweb;

import za.co.sindi.jsonweb.util.Base64URLCodec;

/**
 * @author Bienfait Sindi
 * @since 08 April 2016
 *
 */
public abstract class Base64URL<V> implements Value<V, String> {

	private Base64URLCodec base64urlCodec;

	/**
	 * 
	 */
	protected Base64URL() {
		super();
		// TODO Auto-generated constructor stub
		base64urlCodec = new Base64URLCodec();
	}

	/**
	 * @return the base64urlCodec
	 */
	protected Base64URLCodec getBase64urlCodec() {
		return base64urlCodec;
	}
}
