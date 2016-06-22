/**
 * 
 */
package za.co.sindi.jsonweb.json.impl;

import za.co.sindi.jsonweb.json.JSONArrayBuilder;
import za.co.sindi.jsonweb.json.JSONBuilderFactory;
import za.co.sindi.jsonweb.json.JSONObjectBuilder;

/**
 * @author Bienfait Sindi
 * @since 11 April 2016
 *
 */
public class DefaultJSONBuilderFactory implements JSONBuilderFactory {

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONBuilderFactory#createJSONObjectBuilder()
	 */
	public JSONObjectBuilder createJSONObjectBuilder() {
		// TODO Auto-generated method stub
		return new DefaultJSONObjectBuilder();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.json.JSONBuilderFactory#createJSONArrayBuilder()
	 */
	public JSONArrayBuilder createJSONArrayBuilder() {
		// TODO Auto-generated method stub
		return new DefaultJSONArrayBuilder();
	}
}
