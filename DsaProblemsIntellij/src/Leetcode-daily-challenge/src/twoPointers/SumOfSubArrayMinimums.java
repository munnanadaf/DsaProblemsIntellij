package twoPointers;


// brute force
public class SumOfSubArrayMinimums {
	public int sumSubarrayMins(int[] arr) {
		int n = arr.length;

		int sum = 0;
		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = i; j < n; j++) {
				min = Math.min(min, arr[j]);
				sum = sum + min;
				sum = sum % ((int) (1e9 + 7));
			}
		}

		int mod = sum % ((int) (1e9 + 7));

		// int sum = 0;
		// for(int i = 0;i<n;i++){
		// for(int j = i;j<n;j++){
		// int min = Integer.MAX_VALUE;
		// for(int k = i;k<=j;k++){
		// min = Math.min(min,arr[k]);
		// }
		// sum = sum+min;
		// sum = sum%((int)(1e9+7));
		// }
		// }

		return mod;
	}
}