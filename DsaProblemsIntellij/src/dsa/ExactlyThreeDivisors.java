package dsa;

public class ExactlyThreeDivisors {

	public static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	
	// works but slower takes more execution time
	public static void divisors(int n) {
		for (int j = 3; j < n; j++) {
			int count = 0;
			if (!isPrime(j)) {
				for(int i=2;i<j;i++) {
					if(j%i==0) {
						count++;
					}
				}
			}
			if (count == 1) {
				System.out.println("number " + j);
			}
		}
	}
	
	
	// faster approach
	
	//square of a prime number can only be divisible by its sqrt and 1 and by itself since it is less than n itself
	public static void divisors1(int n) {
		for (int j = 2; j*j <= n; j++) {
			if (isPrime(j)) {
				if(j*j<=n) {
					System.out.println("number "+j*j);
				}
			}
		}
	}

	public static void main(String[] args) {
		divisors1(50);
	}
}
