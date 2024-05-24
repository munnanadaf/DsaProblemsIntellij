package arrays;

class MinimumCommonValue {
	public static int getCommon(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		int min = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		while (i < n && j < m) {
			if (nums1[i] < nums2[j])
				i++;
			else if (nums1[i] > nums2[j])
				j++;
			else
				return nums1[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		int num1[] = { 1, 1, 2 };
		int num2[] = { 2, 4 };
		System.out.println(getCommon(num1, num2));

	}
}