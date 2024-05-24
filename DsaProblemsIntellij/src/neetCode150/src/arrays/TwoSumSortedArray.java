package arrays;

class TwoSumSortedArray {
	public static void main(String[] args) {
		int[] arr = { 2, 7, 11, 15 };
		int res[] = twoSum(arr, 9);
		for (int i : res) {
			System.out.print(i+" ");
		}
	}

	public static int[] twoSum(int[] numbers, int target) {
		int res[] = new int[2];
		int i = 0, j = numbers.length - 1;
		while (i <= j) {
			int sum = numbers[i] + numbers[j];
			if (sum < target)
				i++;
			else if (sum > target)
				j--;
			else {
				res[0] = i+1;
				res[1] = j+1;
				break;
			}
		}
		return res;}
}