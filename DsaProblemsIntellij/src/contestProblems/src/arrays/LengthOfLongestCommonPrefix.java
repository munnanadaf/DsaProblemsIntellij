package arrays;

class LengthOfLongestCommonPrefix {
	public static int longestCommonPrefix(int[] arr1, int[] arr2) {
		int res = 0;

		for (int num2 : arr2) {
			for (int num1 : arr1) {
				String str1 = String.valueOf(num1);
				String str2 = String.valueOf(num2);
				int n = str1.length();
				if (str2.substring(0, str1.length()).equals(str1) && n > res)
					res = n;
			}
		}

		return res;
	}
	
	public static void main(String[] args) {
		int a[]  = {1,10,100};
		int b[] = {1000};
		
		System.out.println(longestCommonPrefix(a, b));
	}
}