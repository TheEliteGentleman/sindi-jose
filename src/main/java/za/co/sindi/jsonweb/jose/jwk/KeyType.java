/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

import za.co.sindi.jsonweb.Requirement;

/**
 * @author Bienfait Sindi
 * @since 06 April 2016
 *
 */
public final class KeyType {

	public static final KeyType EC = new KeyType(JWKConstants.KTY_EC, "Elliptic Curve", Requirement.RECOMMENDED);
	public static final KeyType RSA = new KeyType(JWKConstants.KTY_RSA, "RSA", Requirement.REQUIRED);
	public static final KeyType OCT = new KeyType(JWKConstants.KTY_OCT, "Octet Sequence", Requirement.REQUIRED);
	
	private final String parameterValue;
	private final String description;
	private final Requirement implementationRequirement;
	
	/**
	 * @param parameterValue
	 * @param description
	 * @param implementationRequirement
	 */
	private KeyType(String parameterValue, String description, Requirement implementationRequirement) {
		super();
		this.parameterValue = parameterValue;
		this.description = description;
		this.implementationRequirement = implementationRequirement;
	}

	/**
	 * @return the parameterValue
	 */
	public String getParameterValue() {
		return parameterValue;
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
		result = prime * result + ((parameterValue == null) ? 0 : parameterValue.hashCode());
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
		KeyType other = (KeyType) obj;
		if (parameterValue == null) {
			if (other.parameterValue != null)
				return false;
		} else if (!parameterValue.equals(other.parameterValue))
			return false;
		return true;
	}

	public static KeyType of(final String value) {
		if (EC.parameterValue.equals(value)) {
			return EC;
		}
		
		if (RSA.parameterValue.equals(value)) {
			return RSA;
		}
		
		if (OCT.parameterValue.equals(value)) {
			return OCT;
		}
		
		throw new IllegalArgumentException("Unknown JWK key type '" + value + "'.");
	}
}
