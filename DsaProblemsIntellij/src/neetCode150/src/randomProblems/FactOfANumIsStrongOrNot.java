package randomProblems;

public class FactOfANumIsStrongOrNot {

	public static void main(String[] args) {
		int n = 145;
		isFactOfNStrong(n);

	}

	private static void isFactOfNStrong(int n) {
		int original = n;
		int sum = 0;
		while (n != 0) {
			int digit = getFact(n % 10);
			sum = sum + digit;
			n = n / 10;
		}

		if (sum == original) {
			System.out.println("Is a strong number");
		} else {
			System.out.println("Not a strong number");
		}
	}

	public static int getFact(int num) {
		int fact = 1;
		while (num > 0) {
			fact = fact * num;
			num--;
		}
		return fact;
	}

}
