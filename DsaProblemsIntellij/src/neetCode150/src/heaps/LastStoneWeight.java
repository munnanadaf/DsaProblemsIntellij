package heaps;

import java.util.Collections;
import java.util.PriorityQueue;

class LastStoneWeight {
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int k : stones) {
			maxHeap.add(k);
		}

		while (maxHeap.size() > 1) {
			int x = maxHeap.remove();
			int y = maxHeap.remove();
			if (x == y) {

			}
			if (x != y) {
				maxHeap.add(x - y);
			}
		}

		return maxHeap.size() == 1 ? maxHeap.remove() : 0;
	}
}