package heaps;

import java.util.PriorityQueue;

class KthSmallestPrimeFraction {
	public int[] kthSmallestPrimeFraction(int[] arr, int k) {
		PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> {
			return Double.compare(a[0] / a[1], b[0] / b[1]);
		});
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				pq.offer(new double[] { arr[i], arr[j] });
			}
		}
		while (k > 0) {
			if (k == 1) {
				double[] res = pq.poll();
				return new int[] { (int) res[0], (int) res[1] };
			}
			pq.poll();
			k--;
		}
		return new int[0];
	}
}