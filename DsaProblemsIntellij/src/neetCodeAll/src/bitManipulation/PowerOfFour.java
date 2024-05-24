package bitManipulation;

class PowerOfFour {
	public boolean isPowerOfFour(int n) {
		return (n & n - 1) == 0 && (n - 1) % 3 == 0;

//		while (n % 4 == 0)
//		    n = n / 4;
//		 return n == 1;
	}
	// (n & n-1) ==0 to check only 1 bit is set.
	// (n-1)%3 == 0 to check its not odd number.
}