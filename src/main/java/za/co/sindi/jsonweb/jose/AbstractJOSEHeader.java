/**
 * 
 */
package za.co.sindi.jsonweb.jose;

import java.net.URI;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import za.co.sindi.common.utils.PreConditions;
import za.co.sindi.common.utils.Strings;
import za.co.sindi.jsonweb.AbstractJWObject;
import za.co.sindi.jsonweb.jose.jwa.Algorithm;
import za.co.sindi.jsonweb.jose.jwa.JWAConstants;
import za.co.sindi.jsonweb.jose.jwk.PublicJWK;
import za.co.sindi.jsonweb.json.JSONArrayBuilder;
import za.co.sindi.jsonweb.json.JSONBuilderFactory;
import za.co.sindi.jsonweb.json.JSONObject;
import za.co.sindi.jsonweb.json.JSONObjectBuilder;
import za.co.sindi.jsonweb.json.impl.DefaultJSONBuilderFactory;
import za.co.sindi.jsonweb.util.URLUtils;
import za.co.sindi.jsonweb.util.X509CertificateUtils;

/**
 * @author Bienfait Sindi
 * @since 15 May 2016
 *
 */
public abstract class AbstractJOSEHeader<JWA extends Algorithm> extends AbstractJWObject implements JOSEHeader<JWA> {

	private JWA algorithm;
	private URI jwkSetURI;
	private PublicJWK jsonWebKey;
	private String keyId;
	private URI x509URI;
	private List<X509Certificate> x509CertificateChains;
	private String x509CertificateSHA1Thumbprint;
	private String x509CertificateSHA256Thumbprint;
	private MediaType type;
	private MediaType contentType;
	private Set<String> criticalHeaders;
	private Map<String, Object> privateParameters= new LinkedHashMap<String, Object>();

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.JWObject#toJSONObject()
	 */
	@Override
	public JSONObject toJSONObject() throws Exception {
		// TODO Auto-generated method stub
		JSONBuilderFactory factory = new DefaultJSONBuilderFactory();
		JSONObjectBuilder jsonObjectBuilder = factory.createJSONObjectBuilder();
		if (getAlgorithm() != null) {
			jsonObjectBuilder.add(Constants.JOSE_HEADER_ALGORITHM, getAlgorithm().getJwaAlgorithmName());
		}
		
		if (getJWKSetURI() != null) {
			jsonObjectBuilder.add(Constants.JOSE_HEADER_JWK_SET_URL, getJWKSetURI().toString());
		}
		
		if (getJSONWebKey() != null) {
			jsonObjectBuilder.add(Constants.JOSE_HEADER_JWK, getJSONWebKey().toJSONObject());
		}
		
		if (getKeyId() != null) {
//			if (getJSONWebKey() != null) {
//				PreConditions.checkState(getJSONWebKey().getKeyId().equals(getKeyId()), "The Key ID '" + getKeyId() + "' does not match with the JWK key ID '" + getJSONWebKey().getKeyId() + "'.");
//			}
			
			jsonObjectBuilder.add(Constants.JOSE_HEADER_KEY_ID, getKeyId());
		}
		
		if (getX509URI() != null) {
			jsonObjectBuilder.add(Constants.JOSE_HEADER_X509_URL, getX509URI());
		}
		
		X509Certificate[] x509CertificateChains = getX509CertificateChains();
		if (x509CertificateChains != null) {
			JSONArrayBuilder jsonArrayBuilder = factory.createJSONArrayBuilder();
			for (X509Certificate x509CertificateChain : x509CertificateChains) {
				jsonArrayBuilder.add(X509CertificateUtils.base64Encode(x509CertificateChain));
			}
			
			jsonObjectBuilder.add(Constants.JOSE_HEADER_X509_CERTIFICATE_CHAIN, jsonArrayBuilder);
		}
		
		String x509SHA1Thumbprint = getX509CertificateSHA1Thumbprint();
		if (x509SHA1Thumbprint != null) {
			jsonObjectBuilder.add(Constants.JOSE_HEADER_X509_CERTIIFICATE_SHA1_THUMBPRINT, x509SHA1Thumbprint);
		}
		
		String x509SHA256Thumbprint = getX509CertificateSHA256Thumbprint();
		if (x509SHA256Thumbprint != null) {
			jsonObjectBuilder.add(Constants.JOSE_HEADER_X509_CERTIFICATE_SHA256_THUMBPRINT, x509SHA256Thumbprint);
		}
		
		if (getType() != null) {
//			jsonObjectBuilder.add(Constants.JOSE_HEADER_TYPE, getType().getMediaTypeAsString(true));
			if (!JWAConstants.JWS_NONE.equals(getAlgorithm().getJwaAlgorithmName())) {
				jsonObjectBuilder.add(Constants.JOSE_HEADER_TYPE, getType().getMediaTypeAsString(true));
			}
		}
		
		if (getContentType() != null) {
			jsonObjectBuilder.add(Constants.JOSE_HEADER_CONTENT_TYPE, getContentType().getMediaTypeAsString(true));
		}
		
		String[] criticalHeaders = getCriticalHeaders();
		if (criticalHeaders != null) {
			JSONArrayBuilder jsonArrayBuilder = factory.createJSONArrayBuilder();
			for (String criticalHeader : criticalHeaders) {
				jsonArrayBuilder.add(criticalHeader);
			}
			
			jsonObjectBuilder.add(Constants.JOSE_HEADER_CRITICAL, jsonArrayBuilder);
		}
		
		populateJSONObject(jsonObjectBuilder);
		return jsonObjectBuilder.build();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.JOSEHeader#getPrivateHeaderNames()
	 */
	@Override
	public Set<String> getPrivateHeaderNames() {
		// TODO Auto-generated method stub
		return privateParameters.keySet();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#getAlgorithm()
	 */
	@Override
	public JWA getAlgorithm() {
		// TODO Auto-generated method stub
		return algorithm;
	}
	
	public void setAlgorithm(JWA algorithm) {
		this.algorithm = algorithm;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#getJWKSetURI()
	 */
	@Override
	public URI getJWKSetURI() {
		// TODO Auto-generated method stub
//		return (URI) getParameter(Constants.JOSE_HEADER_JWK_SET_URL);
		return jwkSetURI;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#setJWKSetURI(java.net.URI)
	 */
//	@Override
	public void setJWKSetURI(URI jwkSetURI) {
		// TODO Auto-generated method stub
		if (jwkSetURI != null) {
			PreConditions.checkSate(URLUtils.exists(jwkSetURI), "JWK Set URI " + jwkSetURI.toString() + " does not exist.");
			PreConditions.checkState("https".equalsIgnoreCase(jwkSetURI.getScheme()), "JWK Set URI " + jwkSetURI.toString() + " is not a secured HTTP protocol https.");
		}
		
//		setParameter(Constants.JOSE_HEADER_JWK_SET_URL, jwkSetURI);
		this.jwkSetURI = jwkSetURI;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#getJSONWebKey()
	 */
	@Override
	public PublicJWK getJSONWebKey() {
		// TODO Auto-generated method stub
//		return (PublicJWK) getParameter(Constants.JOSE_HEADER_JWK);
		return jsonWebKey;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#setJSONWebKey(za.co.sindi.jsonweb.jose.jwk.PublicJWK)
	 */
//	@Override
	public void setJSONWebKey(PublicJWK jsonWebKey) {
		// TODO Auto-generated method stub
//		setParameter(Constants.JOSE_HEADER_JWK, jsonWebKey);
		this.jsonWebKey = jsonWebKey;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#getKeyId()
	 */
	@Override
	public String getKeyId() {
		// TODO Auto-generated method stub
//		return (String) getParameter(Constants.JOSE_HEADER_KEY_ID);
		return keyId;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#setKeyId(java.lang.String)
	 */
//	@Override
	public void setKeyId(String keyId) {
		// TODO Auto-generated method stub
//		setParameter(Constants.JOSE_HEADER_KEY_ID, keyId);
		if (keyId != null) {
			PreConditions.checkArgument(!keyId.trim().isEmpty(), "A key ID must not be empty.");
		}
		
		this.keyId = keyId;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#getX509URI()
	 */
	@Override
	public URI getX509URI() {
		// TODO Auto-generated method stub
//		return (URI) getParameter(Constants.JOSE_HEADER_X509_URL);
		return x509URI;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#setX590URI(java.net.URI)
	 */
//	@Override
	public void setX590URI(URI x509URI) {
		// TODO Auto-generated method stub
		if (x509URI != null) {
			PreConditions.checkSate(URLUtils.exists(x509URI), "X.509 URI " + x509URI.toString() + " does not exist.");
			PreConditions.checkState("https".equalsIgnoreCase(x509URI.getScheme()), "X.509 URI " + x509URI.toString() + " is not a secured HTTP protocol https.");
		}
//		setParameter(Constants.JOSE_HEADER_X509_URL, x509URI);
		this.x509URI = x509URI;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#addX509Certificate(java.security.cert.X509Certificate)
	 */
//	@Override
	public void addX509Certificate(X509Certificate x509Certificate) {
		// TODO Auto-generated method stub
		if (x509Certificate != null) {
//			@SuppressWarnings("unchecked")
//			List<X509Certificate> x509CertificateChains = (List<X509Certificate>) getParameter(Constants.JOSE_HEADER_X509_CERTIFICATE_CHAIN);
			if (x509CertificateChains == null) {
				x509CertificateChains = new ArrayList<X509Certificate>();
			}
			
			x509CertificateChains.add(x509Certificate);
		} /* else {
			setParameter(Constants.JOSE_HEADER_X509_CERTIFICATE_CHAIN, null);
		} */
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#getX509CertificateChains()
	 */
	@Override
	public X509Certificate[] getX509CertificateChains() {
		// TODO Auto-generated method stub
//		@SuppressWarnings("unchecked")
//		List<X509Certificate> x509CertificateChains = (List<X509Certificate>) getParameter(Constants.JOSE_HEADER_X509_CERTIFICATE_CHAIN);
		if (x509CertificateChains != null) {
			return x509CertificateChains.toArray(new X509Certificate[x509CertificateChains.size()]);
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#setX509CertificateChains(java.security.cert.X509Certificate[])
	 */
//	@Override
	public void setX509CertificateChains(X509Certificate[] x509CertificateChains) {
		// TODO Auto-generated method stub
		if (x509CertificateChains != null) {
			if (this.x509CertificateChains == null) {
				this.x509CertificateChains = new ArrayList<X509Certificate>();
			} 
			
			this.x509CertificateChains.clear();
			this.x509CertificateChains.addAll(Arrays.asList(x509CertificateChains));
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#getX509CertificateSHA1Thumbprint()
	 */
	@Override
	public String getX509CertificateSHA1Thumbprint() {
		// TODO Auto-generated method stub
//		return (String) getParameter(Constants.JOSE_HEADER_X509_CERTIIFICATE_SHA1_THUMBPRINT);
		return x509CertificateSHA1Thumbprint;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#setX509CertificateSHA1Thumbprint(java.lang.String)
	 */
//	@Override
	public void setX509CertificateSHA1Thumbprint(String x509CertificateSHA1Thumbprint) {
		// TODO Auto-generated method stub
//		setParameter(Constants.JOSE_HEADER_X509_CERTIIFICATE_SHA1_THUMBPRINT, x509CertificateSHA1Thumbprint);
		this.x509CertificateSHA1Thumbprint = x509CertificateSHA1Thumbprint;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#getX509CertificateSHA256Thumbprint()
	 */
	@Override
	public String getX509CertificateSHA256Thumbprint() {
		// TODO Auto-generated method stub
//		return (String) getParameter(Constants.JOSE_HEADER_X509_CERTIFICATE_SHA256_THUMBPRINT);
		return x509CertificateSHA256Thumbprint;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#setX509CertificateSHA256Thumbprint(java.lang.String)
	 */
//	@Override
	public void setX509CertificateSHA256Thumbprint(String x509CertificateSHA256Thumbprint) {
		// TODO Auto-generated method stub
//		setParameter(Constants.JOSE_HEADER_X509_CERTIFICATE_SHA256_THUMBPRINT, x509CertificateSHA256Thumbprint);
		this.x509CertificateSHA256Thumbprint = x509CertificateSHA256Thumbprint;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#getType()
	 */
	@Override
	public MediaType getType() {
		// TODO Auto-generated method stub
//		return (MediaType) getParameter(Constants.JOSE_HEADER_TYPE);
		return type;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#setType(za.co.sindi.jsonweb.jose.MediaType)
	 */
//	@Override
	public void setType(MediaType type) {
		// TODO Auto-generated method stub
//		setParameter(Constants.JOSE_HEADER_TYPE, type);
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#getContentType()
	 */
	@Override
	public MediaType getContentType() {
		// TODO Auto-generated method stub
//		return (MediaType) getParameter(Constants.JOSE_HEADER_CONTENT_TYPE);
		return contentType;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#setContentType(za.co.sindi.jsonweb.jose.MediaType)
	 */
//	@Override
	public void setContentType(MediaType contentType) {
		// TODO Auto-generated method stub
//		setParameter(Constants.JOSE_HEADER_CONTENT_TYPE, contentType);
		this.contentType = contentType;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#addCriticalHeader(java.lang.String)
	 */
//	@Override
	public void addCriticalHeader(String criticalHeader) {
		// TODO Auto-generated method stub
		if (!Strings.isNullOrEmpty(criticalHeader)) {
			PreConditions.checkArgument(!getRegisteredHeaderNames().contains(criticalHeader), "Header parameter name '" + criticalHeader + "' is invalid (see paragraph 4.1.11 of RFC 7515 for clarity).");
			if (criticalHeaders == null) {
				criticalHeaders = new LinkedHashSet<>();
			}
			
			criticalHeaders.add(criticalHeader);
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#getCriticalHeaders()
	 */
//	@Override
	public String[] getCriticalHeaders() {
		// TODO Auto-generated method stub
		//We cannot return an empty list (See paragraph 4.1.11 of RFC 7515
		if (criticalHeaders == null || criticalHeaders.isEmpty()) {
			return null;
		}
		
		return criticalHeaders.toArray(new String[criticalHeaders.size()]);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsonweb.jose.jws.JWSHeader#setCriticalHeaders(java.lang.String[])
	 */
//	@Override
	public void setCriticalHeaders(String[] criticalHeaders) {
		// TODO Auto-generated method stub
		//We cannot accept an empty array (See paragraph 4.1.11 of RFC 7515
		if (criticalHeaders != null && criticalHeaders.length > 0) {
			if (this.criticalHeaders == null) {
				this.criticalHeaders = new LinkedHashSet<>();
			}
			
			this.criticalHeaders.addAll(Arrays.asList(criticalHeaders));
		}
	}
	
	protected void populateJSONObject(final JSONObjectBuilder jsonObjectBuilder) {
		
	}
}
