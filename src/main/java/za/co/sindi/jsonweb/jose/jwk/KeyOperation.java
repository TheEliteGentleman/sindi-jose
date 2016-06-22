/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

/**
 * @author Bienfait Sindi
 * @since 05 April 2016
 *
 */
public enum KeyOperation {
	SIGN("sign")
	,VERIFY("verify")
	,ENCRYPT("encrypt")
	,DECRYPT("decrypt")
	,WRAP_KEY("wrapKey")
	,UNWRAP_KEY("unwrapKey")
	,DERIVE_KEY("deriveKey")
	,DERIVE_BITS("deriveBits")
	;
	private final String value;

	/**
	 * @param value
	 */
	private KeyOperation(String value) {
		this.value = value;
	}
	
	public static KeyOperation of(final String value) {
		for (KeyOperation ko : values()) {
			if (ko.value.equals(value)) {
				return ko;
			}
		}
		
		throw new IllegalArgumentException("Unknown JWK Key operation '" + value + "'.");
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value;
	}
}
