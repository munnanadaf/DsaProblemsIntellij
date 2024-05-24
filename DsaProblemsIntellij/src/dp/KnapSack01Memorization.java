package dp;

public class KnapSack01Memorization {
	static int m[][];

	// memorization
	public static int knapSack(int wt[], int val[], int w, int n) {
		if (n == 0 || w == 0)
			return 0;
		if (m[n][w] != -1)
			return m[n][w];
		if (wt[n - 1] > w)
			return m[n][w] = knapSack(wt, val, w, n - 1);
		else {
			return m[n][w] = Math.max(val[n - 1] + knapSack(wt, val, w - wt[n - 1], n - 1),
					knapSack(wt, val, w, n - 1));

		}
	}

	public static void main(String[] args) {

		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int w = 80;
		int n = val.length;
		m = new int[n + 1][w + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= w; j++) {
				m[i][j] = -1;
			}
		}
		System.out.println(knapSack(val, wt, w, n));
	}

}
