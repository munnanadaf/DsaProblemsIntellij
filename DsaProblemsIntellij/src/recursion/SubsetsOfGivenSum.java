package recursion;

public class SubsetsOfGivenSum {

	public int subSetOfGivenSumFromArray(int[] a, int n, int sum) {
		if (n == 0)
			return (sum == 0) ? 1 : 0;
		// including last element & excluding last element
		System.out.println("n "+n+" sum"+sum);
		return subSetOfGivenSumFromArray(a, n - 1, sum) + subSetOfGivenSumFromArray(a, n - 1, sum - a[n - 1]);

	}

	public static void main(String[] args) {
		int a[] = { 10, 5, 15, 20 };
		int n = 3;
		int sum = 20;
		SubsetsOfGivenSum s = new SubsetsOfGivenSum();
		
		//starting from last element
		int res = s.subSetOfGivenSumFromArray(a, n, sum);
		if(res ==1) {
			System.out.println("found subset");
		}
		else {
			System.out.println("No subset of a given sum is found");
		}
	}

}
