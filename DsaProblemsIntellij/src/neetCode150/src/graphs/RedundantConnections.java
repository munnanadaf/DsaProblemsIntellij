package graphs;

class RedundantConnections {
	public int[] findRedundantConnection(int[][] edges) {
		int[] parent = new int[2001];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		for (int[] edge : edges) {
			int node1 = edge[0];
			int node2 = edge[1];
			int parent1 = findPar(parent, node1);
			int parent2 = findPar(parent, node2);
			if (parent1 == parent2) {
				return edge;
			} else {
				parent[parent1] = parent2;
			}
		}
		return new int[2];
	}

	public int findPar(int[] parent, int curNode) {
		if (curNode != parent[curNode])
			parent[curNode] = findPar(parent, parent[curNode]);
		return parent[curNode];
	}
}