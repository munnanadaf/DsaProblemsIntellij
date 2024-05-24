package dp;



public class Knapsack01 {

	
	// recursive approach
	public static int knapSack(int wt[], int val[], int w, int n) {
		if (n == 0 || w == 0)
			return 0;
		if (wt[n - 1] > w) 
			return knapSack(wt, val, w, n - 1);
		else {
			int max = Math.max(val[n - 1] + knapSack(wt, val, w - wt[n - 1], n - 1), knapSack(wt, val, w, n - 1));
			return max;
		}
	}

	public static void main(String[] args) {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 80;
		int n = val.length;
		System.out.println(knapSack(val, wt, W, n));
	}

}
