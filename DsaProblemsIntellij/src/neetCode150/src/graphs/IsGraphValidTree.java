package graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class IsGraphValidTree {
	public static void main(String[] args) {
		int n = 5;
		int edges[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
		System.out.println(checkGraph(edges, n, n));
	}

	public static Boolean checkGraph(int[][] edges, int n, int m) {
		boolean visited[] = new boolean[n];
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			map.put(i, list);
		}

		for (int[] edge : edges) {
			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
		}
		if (!bfsConnected(map, visited, 0, -1))
			return false;
		for (boolean isVisited : visited)
			if (!isVisited)
				return false;
		return true;
	}

// checks if it has cycle && is connected or not.
	public static boolean bfsConnected(HashMap<Integer, ArrayList<Integer>> map, boolean[] visited, int cur, int par) {
		if (visited[cur])
			return false;
		visited[cur] = true;
		for (int neighbour : map.get(cur)) {
			if (neighbour != par && !bfsConnected(map, visited, neighbour, cur)) {
				return false;
			}
		}
		return true;
	}
}