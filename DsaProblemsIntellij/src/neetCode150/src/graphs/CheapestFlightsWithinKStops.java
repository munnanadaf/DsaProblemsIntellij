package graphs;

import java.util.Arrays;

class CheapestFlightsWithinKStops {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		int prev[] = new int[n];
		Arrays.fill(prev, Integer.MAX_VALUE);
		prev[src] = 0;
		for (int i = 0; i <= k; i++) {
			int cur[] = Arrays.copyOf(prev, n);
			for (int[] edge : flights) {
				int from = edge[0];
				int to = edge[1];
				int wt = edge[2];
				if (prev[from] != Integer.MAX_VALUE && prev[from] + wt < cur[to]) {
					cur[to] = prev[from] + wt;
				}
			}
			prev = Arrays.copyOf(cur, n);
		}
		return prev[dst] == Integer.MAX_VALUE ? -1 : prev[dst];
	}
}