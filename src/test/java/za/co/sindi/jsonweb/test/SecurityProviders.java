/**
 * 
 */
package za.co.sindi.jsonweb.test;

import java.security.Provider;
import java.security.Security;
import java.util.Enumeration;

/**
 * @author buhake.sindi
 *
 */
public class SecurityProviders {

	public static void main(String[] args) {
		try {
			Provider p[] = Security.getProviders();
			for (int i = 0; i < p.length; i++) {
				System.out.println(p[i]);
				for (@SuppressWarnings("rawtypes")
				Enumeration e = p[i].keys(); e.hasMoreElements();)
					System.out.println("\t" + e.nextElement());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
