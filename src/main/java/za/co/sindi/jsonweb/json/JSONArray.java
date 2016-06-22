/**
 * 
 */
package za.co.sindi.jsonweb.json;

/**
 * @author Bienfait Sindi
 * @since 07 April 2016
 *
 */
public interface JSONArray extends JSON {

    public JSONObject getJSONObject(int index);

    public JSONArray getJSONArray(int index);

    public String getString(int index);

    public String getString(int index, String defaultValue);

    public int getInt(int index);

    public int getInt(int index, int defaultValue);

    public boolean getBoolean(int index);

    public boolean getBoolean(int index, boolean defaultValue);
    
    public boolean isEmpty();
    
    public boolean isNull(int index);
    
    public int size();
    
    public Object unwrap();
}
