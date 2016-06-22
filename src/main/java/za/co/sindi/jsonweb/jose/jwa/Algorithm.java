/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwa;

import za.co.sindi.jsonweb.Requirement;

/**
 * Implementation of <a href="https://tools.ietf.org/html/rfc7518">RFC 7518</a>.
 * 
 * @author Bienfait Sindi
 * @since 22 March 2016
 *
 */
public abstract class Algorithm {
	
	private final String jwaAlgorithmName;
	private final String jcaAlgorithmName;
	private final String description;
	private final Requirement implementationRequirement;

	/**
	 * @param jwaAlgorithmName
	 * @param jcaAlgorithmName
	 * @param description
	 * @param implementationRequirement
	 */
	protected Algorithm(final String jwaAlgorithmName, final String jcaAlgorithmName, final String description,
			final Requirement implementationRequirement) {
		this.jwaAlgorithmName = jwaAlgorithmName;
		this.jcaAlgorithmName = jcaAlgorithmName;
		this.description = description;
		this.implementationRequirement = implementationRequirement;
	}

	/**
	 * @return the jwaAlgorithmName
	 */
	public String getJwaAlgorithmName() {
		return jwaAlgorithmName;
	}

	/**
	 * @return the jcaAlgorithmName
	 */
	public String getJcaAlgorithmName() {
		return jcaAlgorithmName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the implementationRequirement
	 */
	public Requirement getImplementationRequirement() {
		return implementationRequirement;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jwaAlgorithmName == null) ? 0 : jwaAlgorithmName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Algorithm other = (Algorithm) obj;
		if (jwaAlgorithmName == null) {
			if (other.jwaAlgorithmName != null)
				return false;
		} else if (!jwaAlgorithmName.equals(other.jwaAlgorithmName))
			return false;
		return true;
	}
}
