package bitManipulation;

public class PowerSetUsingBitWisse {

	// logic is whichever bit is set in the counter we print that character starting
	// from right left from counter and left to right from string i.e ab means 011
	public static void powerSet(String z) {

		int n = z.length();
		int p = (int) Math.pow(2, n);
		for (int counter = 0; counter < p; counter++) {
			for (int i = 0; i < n; i++) {
				if ((counter & (1 << i)) != 0) {
					System.out.print(z.charAt(i));
				}
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		powerSet("abc");
	}

}
