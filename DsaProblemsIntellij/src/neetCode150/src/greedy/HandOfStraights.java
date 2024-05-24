package greedy;

import java.util.PriorityQueue;

class HandOfStraights {
	public boolean isNStraightHand(int[] hand, int groupSize) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int num : hand) {
			pq.add(num);
		}

		while (!pq.isEmpty()) {
			int start = pq.poll();
			for (int j = 1; j < groupSize; j++) {
				if (pq.remove(start + j)) {
					continue;
				}
				return false;
			}
		}

		return true;

	}
}