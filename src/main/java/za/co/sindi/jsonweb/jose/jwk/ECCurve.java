/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

/**
 * @author Bienfait Sindi
 * @since 06 April 2016
 *
 */
public enum ECCurve {

	P_256("P-256")
	,P_384("P-384")
	,P_521("P-521")
	;
	private final String curve;

	/**
	 * @param curve
	 */
	private ECCurve(String curve) {
		this.curve = curve;
	}
	
	public static ECCurve of(final String curve) {
		for (ECCurve ecCurve : values()) {
			if (ecCurve.curve.equals(curve)) {
				return ecCurve;
			}
		}
		
		throw new IllegalArgumentException("Unknown Elliptic Curve '" + curve + "'.");
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return curve;
	}
}
