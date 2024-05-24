package randomProblems;

public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int a[] = {1, 1, 2 };
		int k = removeDuplicates(a);

		for (int i = 0; i < k; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static int removeDuplicates(int nums[]) {
		if (nums.length == 0)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}

}
