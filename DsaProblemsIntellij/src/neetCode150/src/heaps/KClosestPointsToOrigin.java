package heaps;

import java.util.PriorityQueue;

class KClosestPointsToOrigin {
	public static void main(String[] args) {
		int[][] a = { { 1, 3 }, { -2, 2 } };
		for (int[] is : kClosest(a, 1)) {
			for (int ff : is) {
				System.out.println(ff + " ");
			}
			System.out.println();
		}
	}

	public static int[][] kClosest(int[][] points, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		for (int[] a : points) {
			int res = (a[0] * a[0]) + (a[1] * a[1]);
			pq.offer(new int[] { res, a[0], a[1] });
		}
		int[][] res = new int[k][2];
		while (k > 0) {
			int[] data = pq.poll();
			res[--k] = new int[] { data[1], data[2] };
		}
		return res;
	}
}