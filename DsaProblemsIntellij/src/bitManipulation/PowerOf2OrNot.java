package bitManipulation;

public class PowerOf2OrNot {

	// naive method
	// if a number becomes odd at any point after dividing by 2 then its not power
	// of 2
	public static boolean powerof2orNot(int n) {
		while (n != 1) {
			if (n % 2 != 0)
				return false;
			n = n / 2;
		}
		if (n == 0) {
			return false;
		}
		return true;
	}

	// faster method
	// the logic is that if a number is pow of 2 it has only one bit set otherwise
	// its not pow of 2
	public static boolean powerof2orNot2(int n) {
		if (n == 0)
			return false;
		return ((n & (n - 1)) == 0);

	}

	public static void main(String[] args) {
		System.out.println(powerof2orNot(6));
		System.out.println(powerof2orNot(6));
//		powerof2orNot(4);
	}
}
