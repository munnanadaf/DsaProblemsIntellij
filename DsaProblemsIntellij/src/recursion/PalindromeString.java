package recursion;

public class PalindromeString {
	
	Boolean isPalindrom(String s, int start, int end) {
		if(start>=end) {
			return true;
		}
		
		return (s.charAt(start)==s.charAt(end)) && isPalindrom(s, start+1, end-1);
	}
	
	public static void main(String[] args) {
		PalindromeString obj = new PalindromeString();
		String str = "ABHHBA";
		System.out.println(obj.isPalindrom(str, 0, str.length()-1));
	}

}
