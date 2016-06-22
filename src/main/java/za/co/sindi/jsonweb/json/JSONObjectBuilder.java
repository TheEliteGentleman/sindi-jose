/**
 * 
 */
package za.co.sindi.jsonweb.json;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Bienfait Sindi
 * @since 11 April 2016
 *
 */
public interface JSONObjectBuilder {
	
	public JSONObjectBuilder add(String name, Object value);

	public JSONObjectBuilder add(String name, String value);

	public JSONObjectBuilder add(String name, BigInteger value);

	public JSONObjectBuilder add(String name, BigDecimal value);

	public JSONObjectBuilder add(String name, int value);

	public JSONObjectBuilder add(String name, long value);

	public JSONObjectBuilder add(String name, double value);

	public JSONObjectBuilder add(String name, boolean value);

	public JSONObjectBuilder addNull(String name);

	public JSONObjectBuilder add(String name, JSONObjectBuilder builder);

	public JSONObjectBuilder add(String name, JSONArrayBuilder builder);
	
	public JSONObjectBuilder add(String name, JSONObject json);

	public JSONObjectBuilder add(String name, JSONArray jsonArray);

	public JSONObject build();
}
