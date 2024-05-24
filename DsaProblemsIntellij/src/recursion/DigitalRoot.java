package recursion;

public class DigitalRoot {
	// complete the function
	public static int digitalRoot(int n) {
		if (n < 10)
			return n;
		int k = digitalRoot(n / 10) + (n % 10);
		return digitalRoot(k);
	}
	
	
	public static void main(String[] args) {
		System.out.println(digitalRoot(99999));
	}
}