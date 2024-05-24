package sorting;

class MergeSort {
	public int[] sortArray(int[] nums) {
		mergeSort(nums, 0, nums.length - 1);
		return nums;
	}
	public void mergeFun(int[] arr, int l, int m, int r) {
		int n1 = m + 1 - l;
		int n2 = r - m;
		int[] left = new int[n1];
		for (int i = 0; i < n1; i++) {
			left[i] = arr[l + i];
		}
		int[] right = new int[n2];
		for (int i = 0; i < n2; i++) {
			right[i] = arr[m + 1 + i];
		}
		int i = 0, j = 0, k = l;
		while (i < n1 || j < n2) {
			if (j == n2 || i < n1 && left[i] < right[j])
				arr[k++] = left[i++];
			else
				arr[k++] = right[j++];
		}
	}
	public void mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int m = (high - low) / 2 + low;
			mergeSort(arr, low, m);
			mergeSort(arr, m + 1, high);
			mergeFun(arr, low, m, high);
		}
	}

	// public int[] sortArray(int[] nums) {
	// PriorityQueue<Integer> pq = new PriorityQueue<>();
	// for(int num:nums){
	// pq.offer(num);
	// }
	// int i = 0;
	// while(!pq.isEmpty()){
	// nums[i++] = pq.poll();
	// }
	// return nums;
	// }
}