/**
 * 
 */
package za.co.sindi.jsonweb.json;

/**
 * @author Bienfait Sindi
 * @since 07 April 2016
 *
 */
public interface JSONObject extends JSON {
	
    public JSONArray getJSONArray(String name);

    public JSONObject getJSONObject(String name);

    public boolean getBoolean(String name);

    public boolean getBoolean(String name, boolean defaultValue);

    public double getDouble(String name);

    public double getDouble(String name, double defaultValue);
    
    public int getInt(String name);

    public int getInt(String name, int defaultValue);
    
    public long getLong(String name);

    public long getLong(String name, long defaultValue);
    
    public String getString(String name);

    public String getString(String name, String defaultValue);

    public boolean isNull(String name);
    
    public Object unwrap();
}
