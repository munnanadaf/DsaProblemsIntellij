package heaps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : tasks) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		pq.addAll(map.values());
		Queue<Pair> q = new LinkedList<>();
		int time = 0;
		while (!pq.isEmpty() || !q.isEmpty()) {
			time++;
			if (!pq.isEmpty()) {
				int count = pq.poll() - 1;
				if (count != 0) {
					q.offer(new Pair(count, time + n));
				}
			}
			if (!q.isEmpty() && q.peek().getValue() == time) {
				pq.offer(q.poll().getKey());
			}
		}
		return time;
	}

	class Pair {
		private int key;
		private int value;

		Pair(int key, int value) {
			this.setKey(key);
			this.setValue(value);
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}
	}
}