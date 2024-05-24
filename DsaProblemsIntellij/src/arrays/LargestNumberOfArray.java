package arrays;

public class LargestNumberOfArray {

	// sorted as well as unsorted array
	public static int largestNumber(int a[]) {
		int l = a[0];
		int s=0;
		
		// largest
		for (int i = 1; i < a.length; i++) {
			if (a[i] > l)
				l = a[i];
		}
		
		// 2nd largest
		for (int i = 0; i < a.length; i++) {
			if (a[i] < l && a[i]>s)
				s = a[i];
		}

		return s;
	}
	
	
	
	public static void main(String[] args) {
		int a[] = {1020, 10,13, 20, 19, 0, 80, 18, 12, 11220};
		System.out.println(largestNumber(a));
	}

}
