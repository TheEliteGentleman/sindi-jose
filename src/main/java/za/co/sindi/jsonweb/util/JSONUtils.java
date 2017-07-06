/**
 * 
 */
package za.co.sindi.jsonweb.util;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.json.JSONBuilderFactory;
import za.co.sindi.jsonweb.json.JSONObject;
import za.co.sindi.jsonweb.json.JSONObjectBuilder;
import za.co.sindi.jsonweb.json.impl.DefaultJSONBuilderFactory;

/**
 * @author Bienfait Sindi
 * @since 05 June 2017
 *
 */
public class JSONUtils {

	private JSONUtils() {
		throw new AssertionError("Private Constructor.");
	}

	public static JSONObject merge(final JSONObject jsonObject1, final JSONObject jsonObject2) {
		PreConditions.checkArgument(jsonObject1 != null, "First JSONObject was not provided.");
		PreConditions.checkArgument(jsonObject2 != null, "Second JSONObject was not provided.");

		JSONBuilderFactory factory = new DefaultJSONBuilderFactory();
		JSONObjectBuilder jsonObjectBuilder = factory.createJSONObjectBuilder();
		for (String key : jsonObject1.keySet()) {
			jsonObjectBuilder.add(key, jsonObject1.get(key));
		}
		
		for (String key : jsonObject2.keySet()) {
			jsonObjectBuilder.add(key, jsonObject1.get(key));
		}
		
		return jsonObjectBuilder.build();
	}
}
