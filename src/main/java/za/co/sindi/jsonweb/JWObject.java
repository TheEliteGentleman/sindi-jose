/**
 * 
 */
package za.co.sindi.jsonweb;

import za.co.sindi.jsonweb.json.JSONObject;

/**
 * @author Bienfait Sindi
 * @since 07 April 2016
 *
 */
public interface JWObject {

	public void read(JSONObject jsonObject) throws Exception;
	public JSONObject toJSONObject() throws Exception;
}
