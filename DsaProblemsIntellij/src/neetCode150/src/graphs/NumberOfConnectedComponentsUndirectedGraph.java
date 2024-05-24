package graphs;

import java.util.ArrayList;

public class NumberOfConnectedComponentsUndirectedGraph {
	void dfs(ArrayList<ArrayList<Integer>> adj, int[] visited, int u) {
		for (int v = 0; v < adj.size(); v++) {
			if (u != v && adj.get(u).get(v) == 1 && visited[v] == 0) {
				visited[v] = 1;
				dfs(adj, visited, v);
			}
		}
	}

	int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {

		int[] visited = new int[adj.size()];
		int count = 0;

		for (int u = 0; u < adj.size(); u++) {
			if (visited[u] == 0) {
				dfs(adj, visited, u);
				count++;
			}
		}
		return count;
	}
};