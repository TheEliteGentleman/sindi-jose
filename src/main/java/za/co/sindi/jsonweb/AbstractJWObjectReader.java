/**
 * 
 */
package za.co.sindi.jsonweb;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.json.JSONObject;

/**
 * @author Bienfait Sindi
 * @since 15 May 2017
 *
 */
public abstract class AbstractJWObjectReader<T extends JWObject> implements JWObjectReader<T> {

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.JWObjectReader#readObject(za.co.sindi.jsonweb.json.JSONObject)
	 */
	@Override
	public T readObject(JSONObject jsonObject) throws Exception {
		// TODO Auto-generated method stub
		PreConditions.checkArgument(jsonObject != null, "No JSON object was provided.");
//		PreConditions.checkState(jsonObject.containsKey(Constants.JOSE_HEADER_ALGORITHM) && !jsonObject.isNull(Constants.JOSE_HEADER_ALGORITHM), "No JOSE parameter '" + Constants.JOSE_HEADER_ALGORITHM + "' found.");
		
		return readObjectFully(jsonObject);
	}
	
	protected abstract T readObjectFully(JSONObject jsonObject) throws Exception;
}
