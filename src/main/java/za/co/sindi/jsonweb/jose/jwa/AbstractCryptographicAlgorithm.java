/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwa;

import za.co.sindi.common.utils.PreConditions;

/**
 * @author Bienfait Sindi
 * @since 12 June 2017
 * 
 */
public abstract class AbstractCryptographicAlgorithm<JWA extends Algorithm> implements CryptographicAlgorithm<JWA> {

	private JWA algorithm;

	/**
	 * @param algorithm
	 */
	protected AbstractCryptographicAlgorithm(JWA algorithm) {
		super();
		PreConditions.checkArgument(algorithm != null, "No JWA algorithm type was specified.");
		this.algorithm = algorithm;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwa.CrytographicAlgorithm#getAlgorithm()
	 */
	@Override
	public JWA getAlgorithm() {
		// TODO Auto-generated method stub
		return algorithm;
	}
}
