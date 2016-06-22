/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

/**
 * @author Bienfait Sindi
 * @since 05 April 2016
 *
 */
public enum PublicKeyUse {
	SIGNATURE("sig")
	,ENCRYPTION("enc")
	;
	private final String value;

	/**
	 * @param value
	 */
	private PublicKeyUse(String value) {
		this.value = value;
	}
	
	public static PublicKeyUse of(final String value) {
		for (PublicKeyUse keyUse : values()) {
			if (keyUse.value.equals(value)) {
				return keyUse;
			}
		}
		
		throw new IllegalArgumentException("Invalid use value '"+ value + "'.");
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
