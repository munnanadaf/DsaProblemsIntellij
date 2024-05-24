package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class FindMinHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> res = new ArrayList<>();
		if (edges.length == 0) {
			res.add(0);
			return res;
		}

		int[] inDegree = new int[n];
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}
		for (int i = 0; i < edges.length; i++) {
			inDegree[edges[i][0]]++;
			inDegree[edges[i][1]]++;
			map.get(edges[i][0]).add(edges[i][1]);
			map.get(edges[i][1]).add(edges[i][0]);
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (inDegree[i] == 1)
				q.offer(i);
		}
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			count = count + size;
			for (int i = 0; i < size; i++) {
				Integer id = q.poll();
				inDegree[id]--;
				if (count == n)
					res.add(id);
				for (Integer adjId : map.get(id)) {
					if (inDegree[adjId] != 0) {
						inDegree[adjId]--;
						if (inDegree[adjId] == 1)
							q.offer(adjId);
					}
				}
			}
		}
		return res;
	}
}