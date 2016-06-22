/**
 * 
 */
package za.co.sindi.jsonweb.json;

/**
 * @author Bienfait Sindi
 * @since 11 April 2016
 *
 */
public interface JSONBuilderFactory {

	/**
     * Creates a {@code JsonObjectBuilder} instance that is used to build
     * {@link JsonObject}.
     *
     * @return a JSON object builder
     */
    public JSONObjectBuilder createJSONObjectBuilder();

    /**
     * Creates a {@code JsonArrayBuilder} instance that is used to build
     * {@link JsonArray}
     *
     * @return a JSON array builder
     */
    public JSONArrayBuilder createJSONArrayBuilder();
}
