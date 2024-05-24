package randomProblems;

public class numOfSetBits {
	public static void main(String[] args) {
//		int a = 11111111111111111111111111111101;
	}

	public int hammingWeight(int n) {
		return Integer.bitCount(n);

	}

	public int hammingWeight1(int n) {
		int count = 0;
		String str = Integer.toBinaryString(n);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1')
				count++;
		}
		return count;
	}
}
