/**
 * 
 */
package za.co.sindi.jsonweb.jose.jws.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import za.co.sindi.jsonweb.jose.BaseJOSEHeader;
import za.co.sindi.jsonweb.jose.Constants;
import za.co.sindi.jsonweb.jose.JOSEHeader;
import za.co.sindi.jsonweb.jose.jws.JWSAlgorithm;
import za.co.sindi.jsonweb.jose.jws.JWSJOSEHeader;

/**
 * @author Bienfait Sindi
 * @since 12 May 2016
 *
 */
public class JWSHeader extends BaseJOSEHeader<JWSAlgorithm> implements JWSJOSEHeader, JOSEHeader<JWSAlgorithm> {

	private static final Set<String> REGISTERED_HEADER_NAMES;
	
	static {
		Set<String> registeredHeaderNames = new HashSet<String>();
		registeredHeaderNames.add(Constants.JOSE_HEADER_ALGORITHM);
		registeredHeaderNames.add(Constants.JOSE_HEADER_JWK_SET_URL);
		registeredHeaderNames.add(Constants.JOSE_HEADER_JWK);
		registeredHeaderNames.add(Constants.JOSE_HEADER_KEY_ID);
		registeredHeaderNames.add(Constants.JOSE_HEADER_X509_URL);
		registeredHeaderNames.add(Constants.JOSE_HEADER_X509_CERTIFICATE_CHAIN);
		registeredHeaderNames.add(Constants.JOSE_HEADER_X509_CERTIIFICATE_SHA1_THUMBPRINT);
		registeredHeaderNames.add(Constants.JOSE_HEADER_X509_CERTIFICATE_SHA256_THUMBPRINT);
		registeredHeaderNames.add(Constants.JOSE_HEADER_TYPE);
		registeredHeaderNames.add(Constants.JOSE_HEADER_CONTENT_TYPE);
		registeredHeaderNames.add(Constants.JOSE_HEADER_CRITICAL);
		
		REGISTERED_HEADER_NAMES = Collections.unmodifiableSet(registeredHeaderNames);
	}
	
	/**
	 * @param algorithm
	 */
	public JWSHeader(JWSAlgorithm algorithm) {
		super(algorithm);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.JOSEHeader#getRegisteredHeaderNames()
	 */
	@Override
	public Set<String> getRegisteredHeaderNames() {
		// TODO Auto-generated method stub
		return REGISTERED_HEADER_NAMES;
	}
}
