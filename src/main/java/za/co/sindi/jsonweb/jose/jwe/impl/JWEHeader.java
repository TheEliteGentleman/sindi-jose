/**
 * 
 */
package za.co.sindi.jsonweb.jose.jwe.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.jsonweb.jose.AbstractJOSEHeader;
import za.co.sindi.jsonweb.jose.Constants;
import za.co.sindi.jsonweb.jose.JOSEHeader;
import za.co.sindi.jsonweb.jose.jwe.CompressionAlgorithm;
import za.co.sindi.jsonweb.jose.jwe.EncryptionAlgorithm;
import za.co.sindi.jsonweb.jose.jwe.JWEAlgorithm;
import za.co.sindi.jsonweb.jose.jwe.JWEConstants;
import za.co.sindi.jsonweb.jose.jwe.JWEJOSEHeader;
import za.co.sindi.jsonweb.json.JSONObjectBuilder;

/**
 * @author Bienfait Sindi
 * @since 12 May 2016
 *
 */
public class JWEHeader extends AbstractJOSEHeader<JWEAlgorithm> implements JWEJOSEHeader, JOSEHeader<JWEAlgorithm> {

	private static final Set<String> REGISTERED_HEADER_NAMES;
	
	static {
		Set<String> registeredHeaderNames = new HashSet<String>();
		registeredHeaderNames.add(Constants.JOSE_HEADER_ALGORITHM);
		registeredHeaderNames.add(JWEConstants.JWE_HEADER_ENCRYPTION_ALGORITHM);
		registeredHeaderNames.add(JWEConstants.JWE_HEADER_COMPRESSION_ALGORITHM);
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
	
	private EncryptionAlgorithm encryptionAlgorithm;
	private CompressionAlgorithm compressionAlgorithm;
	
	/**
	 * @param algorithm
	 * @param encryptionAlgorithm
	 */
	public JWEHeader(JWEAlgorithm algorithm, EncryptionAlgorithm encryptionAlgorithm) {
		super(algorithm);
		PreConditions.checkArgument(encryptionAlgorithm != null, "An encryption algorithm is required.");
		this.encryptionAlgorithm = encryptionAlgorithm;
	}

//	/* (non-Javadoc)
//	 * @see za.co.sindi.jsonweb.jose.BaseJOSEHeader#read(za.co.sindi.jsonweb.json.JSONObject)
//	 */
//	@Override
//	public void read(JSONObject jsonObject) throws Exception {
//		// TODO Auto-generated method stub
//		PreConditions.checkState(!jsonObject.isNull(za.co.sindi.jsonweb.jose.jwe.Constants.JWE_HEADER_ENCRYPTION_ALGORITHM) , "The JWE parameter header " + za.co.sindi.jsonweb.jose.jwe.Constants.JWE_HEADER_ENCRYPTION_ALGORITHM + " is required.");
//		encryptionAlgorithm = Algorithms.getAlgorithm(jsonObject.getString(za.co.sindi.jsonweb.jose.jwe.Constants.JWE_HEADER_ENCRYPTION_ALGORITHM));
//		if (!jsonObject.isNull(za.co.sindi.jsonweb.jose.jwe.Constants.JWE_HEADER_COMPRESSION_ALGORITHM)) {
//			compressionAlgorithm = CompressionAlgorithm.of(jsonObject.getString(za.co.sindi.jsonweb.jose.jwe.Constants.JWE_HEADER_COMPRESSION_ALGORITHM));
//		}
//		super.read(jsonObject);
//	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.JOSEHeader#getRegisteredHeaderNames()
	 */
	@Override
	public Set<String> getRegisteredHeaderNames() {
		// TODO Auto-generated method stub
		return REGISTERED_HEADER_NAMES;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEJOSEHeader#getEncryptionAlgorithm()
	 */
	@Override
	public EncryptionAlgorithm getEncryptionAlgorithm() {
		// TODO Auto-generated method stub
		return encryptionAlgorithm;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEJOSEHeader#getCompressionAlgorithm()
	 */
	@Override
	public CompressionAlgorithm getCompressionAlgorithm() {
		// TODO Auto-generated method stub
		return compressionAlgorithm;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jwe.JWEJOSEHeader#setCompressionAlgorithm(za.co.sindi.jsonweb.jose.jwe.CompressionAlgorithm)
	 */
//	@Override
	public void setCompressionAlgorithm(CompressionAlgorithm compressionAlgorithm) {
		// TODO Auto-generated method stub
		this.compressionAlgorithm = compressionAlgorithm;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.BaseJOSEHeader#populateJSONObject(za.co.sindi.jsonweb.json.JSONObjectBuilder)
	 */
	@Override
	protected void populateJSONObject(JSONObjectBuilder jsonObjectBuilder) {
		// TODO Auto-generated method stub
//		super.populateJSONObject(jsonObjectBuilder);
		jsonObjectBuilder.add(za.co.sindi.jsonweb.jose.jwe.JWEConstants.JWE_HEADER_ENCRYPTION_ALGORITHM, encryptionAlgorithm.getJwaAlgorithmName());
		if (compressionAlgorithm != null) {
			jsonObjectBuilder.add(za.co.sindi.jsonweb.jose.jwe.JWEConstants.JWE_HEADER_COMPRESSION_ALGORITHM, compressionAlgorithm.toString());
		}
	}
}
