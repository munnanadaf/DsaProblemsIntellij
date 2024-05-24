package StringProbelms;


// leetcode problem
public class PalindromeAlphaNumeric {
	
	public static boolean isPalindrome(String str) {
		int i=0;
		int j= str.length()-1;
		while(i<j) {
			while(i<j && !Character.isLetterOrDigit(str.charAt(i)))i++;
			while(i<j && !Character.isLetterOrDigit(str.charAt(j)))j--;
			if(str.charAt(i)!=str.charAt(j))return false;
			else {
				i++;
				j--;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("hello  3  olleh"));
	}

}
