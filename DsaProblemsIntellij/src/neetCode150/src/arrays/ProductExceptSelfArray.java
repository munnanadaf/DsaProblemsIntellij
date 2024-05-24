package arrays;

class ProductExceptSelfArray {
	public static void main(String[] args) {
		int a[] = { -1, 1, 0, -3, 3 };
		productExceptSelf(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	public static int[] productExceptSelf(int[] nums) {
		int prod = 1;

		for (int k : nums) {
			if (k != 0) {
				prod = prod * k;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[i] = prod / nums[i];
			} else {
				nums[i] = prod * 0;
			}
		}
		return nums;
	}
}