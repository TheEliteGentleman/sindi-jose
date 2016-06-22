/**
 * 
 */
package za.co.sindi.jsonweb.test;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author buhake.sindi
 * @since 2016/05/24
 *
 */
public class AllAnagram {
	
	public static int countOccurrences(String s, char c, boolean caseSensitive) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			if (caseSensitive) {
				if (c == c1) count++;
			} else {
				if (Character.toLowerCase(c) == Character.toLowerCase(c1)) count++;
			}
		}
		
		return count;
	}

	public static String sanitize(String s) {
		return s.replaceAll("[^A-Za-z0-9]", "");
	}
	
	public static boolean isAnagram(String str1, String str2) {
		String s1 = sanitize(str1);
		String s2 = sanitize(str2);
		if (s1.length() != s2.length()) return false;
		
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if (countOccurrences(s1, c, false) != countOccurrences(s2, c, false)) return false;
		}
		
		return true;
	}
	
	public static Collection<String> getAllAnagrams(String string) {
//        throw new UnsupportedOperationException("Waiting to be implemented.");
		char[] characters = string.toCharArray();
		Collection<String> resultSet = new HashSet<String>();
		for (int i = 0; i < characters.length; i++) {
			StringBuilder sb = new StringBuilder();
			
			for (int j = i + 1; j < characters.length; j++) {
				sb.append(characters[j]);
			}
			
			sb.append(string.substring(0, i + 1));
			
			String s = sb.toString();
			if (isAnagram(string, s)) {
				resultSet.add(s);
			}
		}
		
		return resultSet;
    }

    public static void main(String[] args) {
        Collection<String> anagrams = getAllAnagrams("abba");
        for (String a : anagrams)
            System.out.println(a);
    }
}
