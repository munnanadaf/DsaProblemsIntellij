package stacks;

class NextGreaterElement {
	
	
	// brute force
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int res[] = new int[n];
		for (int j = 0; j < nums1.length; j++) {
			int num = nums1[j];
			int i = 0;
			while (nums2[i] != num)
				i++;
			for (i++; i < nums2.length; i++) {
				if (nums2[i] > num) {
					res[j] = nums2[i];
					break;
				}
			}
			if (res[j] == 0)
				res[j] = -1;
		}
		return res;
	}
}