package dummy;

public class Shivanand {
	public static void main(String[] args) {
		int arr[] = { 2, 3, 1, 5, 4 };
		System.out.println(getMax(5, 3, arr));
	}

	public static int getMax(int n, int k, int[] values) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n-k+1; i++) {
			int tmpMax = values[i];
			for (int j = 1; j < k; j++) {
				tmpMax = tmpMax + (values[i+j] * (j+1));
			}
			max = Math.max(max, tmpMax);
		}
		return max;
	}
}
