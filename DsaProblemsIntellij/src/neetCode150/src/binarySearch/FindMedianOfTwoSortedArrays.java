package binarySearch;

class FindMedianOfTwoSortedArrays {
	public static void main(String[] args) {
		int a[] = { 1, 3 };
		int b[] = { 2 };
		System.out.println(findMedianSortedArrays(a, b));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;

		if (n1 > n2) {
			return findMedianSortedArrays(nums2, nums1);
		}

		int total = n1 + n2;
		int half = (total + 1) / 2;

		int left = 0;
		int right = n1;

		double result = 0.0;

		while (left <= right) {
			int m1 = left + (right - left) / 2;
			int m2 = half - m1;

			int left1 = (m1 > 0) ? nums1[m1 - 1] : Integer.MIN_VALUE;
			int right1 = (m1 < n1) ? nums1[m1] : Integer.MAX_VALUE;
			int left2 = (n2 > 0) ? nums2[m2 - 1] : Integer.MIN_VALUE;
			int right2 = (m2 < n2) ? nums2[m2] : Integer.MAX_VALUE;

			if (left1 <= right2 && left2 <= right1) {
				if (total % 2 == 0) {
					result = (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
				} else {
					result = Math.max(left1, left2);
				}
				break;
			}
			else if (left1 > right2) {
				right = m1 - 1;
			} else {
				left = m1 + 1;
			}
		}

		return result;
	}
}