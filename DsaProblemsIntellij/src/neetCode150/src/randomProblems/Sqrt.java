package randomProblems;

public class Sqrt {

	public static void main(String[] args) {
//		System.out.println("sqrt " + mySqrt(2147395599));
	}

//
//  takes 3ms
  public int mySqrt(int x) {
		if (x == 0)
			return 0;
		if (x == 1)
			return 1;
		return binSearch(0, (0 + x) / 2, x);
	}

	public static int binSearch(long l, long h, int x) {
//		for non perfect square numbers
		long m = (l + h) / 2;
		if (m * m < x && ((m + 1) * (m + 1)) > x)
			return (int)m;
		if (m * m == x)
			return (int)m;
		else if (m * m < x)
			return binSearch(m + 1, h, x);
		else
			return binSearch(l, m - 1, x);
	}

//	takes 4ms
	public static int mySqrt1(int x) {
		long low = 0;
		long high = x;
		long min = 0;
		while (low <= high) {
			long mid = low + (high - low) / 2;

			if (mid * mid <= x) {
				min = mid;
				low = mid + 1;
			} else if (mid * mid >= x) {
				high = mid - 1;
			}
		}
		return (int) min;
	}
}
