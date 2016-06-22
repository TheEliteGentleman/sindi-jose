/**
 * 
 */
package za.co.sindi.jsonweb.jose;

import java.util.regex.Pattern;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.common.utils.Strings;

/**
 * @author Bienfait Sindi
 * @since 12 May 2016
 *
 */
public class MediaType {

	private static final Pattern TYPE_PATTERN = Pattern.compile("(application|audio|image|message|multipart|text|video|x-[^ ()<>@,;:\\/.\\[\\]]+)");
	
	//MediaType;
	public static final MediaType JOSE = new MediaType("JOSE");
	public static final MediaType JOSE_JSON = new MediaType("JOSE+JSON");
	public static final MediaType JWT = new MediaType("JWT");
	
	private String type;
	private String subType;
	private String parameters;
	private transient boolean typeSet;

	/**
	 * @param subType
	 */
	private MediaType(String subType) {
		this(null, subType, null);
	}
	
	/**
	 * @param subType
	 * @param parameters
	 */
	private MediaType(String subType, String parameters) {
		this(null, subType, parameters);
	}
	
	/**
	 * @param type
	 * @param subType
	 * @param parameters
	 */
	private MediaType(String type, String subType, String parameters) {
		super();
		PreConditions.checkArgument(!Strings.isNullOrEmpty(subType), "A media subtype is required.");
		this.type = type;
		this.subType = subType;
		this.parameters = parameters;
		this.typeSet = !Strings.isNullOrEmpty(type);
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the subType
	 */
	public String getSubType() {
		return subType;
	}

	/**
	 * @return the parameters
	 */
	public String getParameters() {
		return parameters;
	}

	/**
	 * @return the typeSet
	 */
	public boolean isTypeSet() {
		return typeSet;
	}
	
	public String getMediaTypeAsString(boolean compact) {
		StringBuilder sb = new StringBuilder();
		if (!compact && Strings.isNullOrEmpty(type)) {
			sb.append("application/");
		}
		sb.append(subType);
		if (!Strings.isNullOrEmpty(parameters)) {
			sb.append(";").append(parameters);
		}
		return sb.toString();
//		return (Strings.isNullOrEmpty(type) ? subType :  type + "/" + subType) + (!Strings.isNullOrEmpty(parameters) ? ";" + parameters : "");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + (typeSet ? 1231 : 1237);
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
		MediaType other = (MediaType) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (typeSet != other.typeSet)
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getMediaTypeAsString(false);
	}

	public static MediaType from(String value) {
		if (value == null || value.isEmpty()) {
			return null;
		}
		
		int semiColonPos = value.indexOf(";");
		String mediaType = "";
		String parameters = null;
		if (semiColonPos > -1) {
			mediaType = value.substring(0, semiColonPos);
			parameters = value.substring(semiColonPos + 1).trim();
		} else {
			mediaType = value;
		}
		
		int typeSeparatorPos = mediaType.indexOf("/");
		if (semiColonPos > -1 && typeSeparatorPos < 0) {
			throw new IllegalArgumentException("Couldn't determine media type from value '" + value + "'.");
		}
		
		//As Per RFC 2015 - all media type values, subtype values, and parameter names are case insensitive.
		String type = typeSeparatorPos > 0 ? mediaType.substring(0, typeSeparatorPos).toLowerCase() : null;
		String subType = typeSeparatorPos > 0 ? mediaType.substring(typeSeparatorPos + 1) : mediaType;
		
		if (!Strings.isNullOrEmpty(type) && !TYPE_PATTERN.matcher(type).matches()) {
			throw new IllegalArgumentException("Invalid media type '" + type + "'.");
		}
		
		return new MediaType(type, subType, parameters);
	}
}
