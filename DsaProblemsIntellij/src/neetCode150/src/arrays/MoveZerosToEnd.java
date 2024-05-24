package arrays;

class MoveZerosToEnd {
	public static void main(String[] args) {
		int a[] = {1,2,3,0,4,6,0,0,0,4,5,6,0,0};
		moveZeroes(a);
		for (int i : a) {
			System.out.print(i+" ");
		}
	}

	public static void moveZeroes(int[] nums) {
		if (nums.length == 0)
			return;
		int i = 0, j = 0;
		while (j < nums.length) {
			if(nums[i]==0 && nums[j]!=0){
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				i=j;
				j++;
			}
			if (nums[j] != 0 && nums[i] != 0) {
				j++;
			}else {
				i = j;
				j++;
			}
		}
	}
}