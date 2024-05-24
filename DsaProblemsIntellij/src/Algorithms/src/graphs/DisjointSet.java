package graphs;

public class DisjointSet {
	int[] rank;
	int[] size;
	int[] parent;

	public DisjointSet(int n) {
		rank = new int[n+1];
		size = new int[n+1];
		parent = new int[n+1];

		for (int i = 0; i <= n; i++) {
			rank[i] = 0;
			parent[i] = i;
			size[i] = 0;
		}
	}

	public int findUParent(int node) {
		if (node == parent[node])
			return node;
		int up = findUParent(parent[node]);
		parent[node] = up; // path compression. assigning its parent to curr node, so that each time need not travel
		return parent[node];
	}

	public void unionByRank(int u, int v) {
		int upU = findUParent(u);
		int upV = findUParent(v);
		if (upU == upV)
			return;
		if (rank[upU] < rank[upV]) {
			parent[upU] = upV;
		} else if (rank[upV] < rank[upU]) {
			parent[upV] = upU;
		} else {
			parent[upV] = upU;
			rank[upU]++; // if equal, increase rank of new parent
		}
	}

	public void unionBySize(int u, int v) {
		int upU = findUParent(u);
		int upV = findUParent(v);
		if (upU == upV)
			return; // both are connected to same parent
		if (size[upU] < size[upV]) {
			parent[upU] = upV;
			size[upV] = size[upV] + size[upU]; // size of both
		} else {
			parent[upV] = upU;
			size[upU] = size[upU] + size[upV];
		}
	}

	public static void main(String[] args) {
		DisjointSet ds = new DisjointSet(7);
		ds.unionByRank(1, 2);
		ds.unionByRank(2, 3);
		ds.unionByRank(4, 5);
		ds.unionByRank(6, 7);
		ds.unionByRank(5, 6);

		if (ds.findUParent(3) == ds.findUParent(7)) {
			System.out.println("same***");
		} else {
			System.out.println("not same**");
		}

		ds.unionByRank(3, 7);

		if (ds.findUParent(3) == ds.findUParent(7)) {
			System.out.println("same***");
		} else {
			System.out.println("not same");
		}
		
	}

}
