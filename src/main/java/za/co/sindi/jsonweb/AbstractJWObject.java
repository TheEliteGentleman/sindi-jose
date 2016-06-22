/**
 * 
 */
package za.co.sindi.jsonweb;

/**
 * @author Bienfait Sindi
 * @since 05 April 2016
 *
 */
public abstract class AbstractJWObject implements JWObject {

//	private Map<String, Object> parameters;
//	
//	/**
//	 * 
//	 */
//	protected AbstractJWObject() {
//		super();
//		// TODO Auto-generated constructor stub
//		parameters = new LinkedHashMap<String, Object>();
//	}
//	
//	protected boolean containsParameter(final String name) {
//		return parameters.containsKey(name);
//	}
//	
//	protected String[] getAllParameterNames() {
//		return parameters.keySet().toArray(new String[parameters.size()]);
//	}
//	
//	protected Object getParameter(final String name) {
//		return parameters.get(name);
//	}
//	
//	protected void setParameter(final String name, final Object value) {
//		if (!Strings.isNullOrEmpty(name)) {
//			if (value != null) {
//				parameters.put(name, value);
//			} else {
//				parameters.remove(name);
//			}
//		}
//	}
//	
//	protected void remove(final String name) {
//		parameters.remove(name);
//	}
//	
//	protected Set<Entry<String, Object>> parameterEntrySet() {
//		return parameters.entrySet();
//	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		try {
			return toJSONObject().toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
