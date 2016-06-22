/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwe;

/**
 * @author Bienfait Sindi
 * @since 16 May 2016
 *
 */
public enum CompressionAlgorithm {
	DEFLATE("DEF")
	;
	private final String name;

	/**
	 * @param name
	 */
	private CompressionAlgorithm(final String name) {
		this.name = name;
	}
	
	public static CompressionAlgorithm of(final String name) {
		for (CompressionAlgorithm algorithm : values()) {
			if (algorithm.name.equals(name)) {
				return algorithm;
			}
		}
		
		throw new IllegalArgumentException("Unknown compression algorithm '" + name + "'.");
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
}
