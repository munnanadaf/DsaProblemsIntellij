package strings;

import java.util.Arrays;

class ValidAnagram {
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
		
	}
//	public static boolean isAnagram(String s, String t) {
//		if (s.length() != t.length())
//			return false;
//		char[] charArray1 = t.toCharArray();
//		char[] charArray2 = s.toCharArray();
//		Arrays.sort(charArray1);
//		Arrays.sort(charArray2);
//		if (String.valueOf(charArray1).equals(String.valueOf(charArray2)))
//			return true;
//		else
//			return false;
//	}
	 public static boolean isAnagram(String s, String t) {
	        if (s == null || t == null)
	            return false;
	        
	        if (s.length() != t.length())
	            return false;
	        
	        String firstSort = sortString(s);
	        String secondSort = sortString(t);
	        return firstSort.equals(secondSort);
	    }

	    private static String sortString(String s) {
	        char[] chars = s.toCharArray();
	        Arrays.sort(chars);
	        return new String(chars);
	    }
}