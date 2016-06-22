/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwk;

import java.security.spec.ECGenParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Bienfait Sindi
 * @since 28 April 2016
 *
 */
public final class JCAECGenParameterSpecs {

	private static final Map<ECCurve, ECGenParameterSpec> CURVE_PARAMETERS;
	
	static {
		Map<ECCurve, ECGenParameterSpec> curveParameters = new HashMap<>();
		curveParameters.put(ECCurve.P_256, new ECGenParameterSpec("secp256r1"));
		curveParameters.put(ECCurve.P_384, new ECGenParameterSpec("secp384r1"));
		curveParameters.put(ECCurve.P_521, new ECGenParameterSpec("secp521r1"));
		
		CURVE_PARAMETERS = Collections.unmodifiableMap(curveParameters);
	}
	
	private JCAECGenParameterSpecs() {
		throw new AssertionError("Private Constructor");
	}
	
	public static ECGenParameterSpec getECGenParameterSpec(final ECCurve curve) {
		return CURVE_PARAMETERS.get(curve);
	}
}
