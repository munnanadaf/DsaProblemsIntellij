package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class NetworkDelayTime {
	public int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for (int[] edge : times) {
			graph.putIfAbsent(edge[0], new ArrayList<>());
			graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
		boolean[] visited = new boolean[N + 1];
		int[] minDis = new int[N + 1];
		Arrays.fill(minDis, Integer.MAX_VALUE);
		minDis[K] = 0;
		pq.offer(new int[] { 0, K });
		int max = 0;
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int currNode = curr[1];
			if (visited[currNode])
				continue;
			visited[currNode] = true;
			int currDis = curr[0];
			max = currDis;
			N--;
			if (!graph.containsKey(currNode))
				continue;
			for (int[] next : graph.get(currNode)) {
				if (!visited[next[0]] && currDis + next[1] < minDis[next[0]])
					pq.offer(new int[] { currDis + next[1], next[0] });
			}
		}
		return N == 0 ? max : -1;
	}
}