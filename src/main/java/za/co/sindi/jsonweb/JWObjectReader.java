/**
 * 
 */
package za.co.sindi.jsonweb;

import za.co.sindi.jsonweb.json.JSONObject;

/**
 * @author Bienfait Sindi
 * @since 10 May 2017
 *
 */
public interface JWObjectReader<T extends JWObject> {

	public T readObject(JSONObject jsonObject) throws Exception;
}
