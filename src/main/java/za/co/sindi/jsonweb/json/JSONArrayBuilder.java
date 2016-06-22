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
public interface JSONArrayBuilder {
	
	public JSONArrayBuilder add(Object value);

	public JSONArrayBuilder add(String value);

	public JSONArrayBuilder add(BigDecimal value);

	public JSONArrayBuilder add(BigInteger value);

	public JSONArrayBuilder add(int value);

	public JSONArrayBuilder add(long value);

	public JSONArrayBuilder add(double value);

	public JSONArrayBuilder add(boolean value);

	public JSONArrayBuilder addNull();

	public JSONArrayBuilder add(JSONObjectBuilder builder);

	public JSONArrayBuilder add(JSONArrayBuilder builder);
	
	public JSONArrayBuilder add(JSONObject json);

	public JSONArrayBuilder add(JSONArray jsonArray);

	public JSONArray build();
}
