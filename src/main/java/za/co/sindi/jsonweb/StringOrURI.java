/**
 * 
 */
package za.co.sindi.jsonweb;

import java.net.URI;

/**
 * @author Bienfait Sindi
 * @since 08 April 2016
 *
 */
public class StringOrURI implements Value<Object, String> {

	private Object value;
	
	/**
	 * @param value
	 */
	public StringOrURI(String value) {
		super();
		this.value = value;
		if (value != null) {
			if (value.contains(":")) {
				this.value = URI.create(value);
			}
		}
	}
	
	/**
	 * @param uri
	 */
	public StringOrURI(URI uri) {
		super();
		this.value = uri;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.Value#getActualValue()
	 */
	public Object getActualValue() {
		// TODO Auto-generated method stub
		return value;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.Value#getJSONValue()
	 */
	public String getJSONValue() {
		// TODO Auto-generated method stub
		return value == null ? null : value.toString();
	}
}
