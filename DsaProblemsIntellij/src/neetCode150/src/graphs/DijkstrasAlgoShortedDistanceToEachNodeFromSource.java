package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class DijkstrasAlgoShortedDistanceToEachNodeFromSource {
	// Function to find the shortest distance of all the vertices
	// from the source vertex S.
	static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
		// Write your code here
		Queue<Pair1> pq = new PriorityQueue<>((x, y) -> x.minDistance - y.minDistance);
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[S] = 0;
		pq.add(new Pair1(S, 0));
		while (!pq.isEmpty()) {
			Pair1 p = pq.poll();
			int node = p.node;
			int curDistance = p.minDistance;
			for (int i = 0; i < adj.get(node).size(); i++) {
				int edgeWeight = adj.get(node).get(i).get(1);
				int adjNode = adj.get(node).get(i).get(0);
				int newDistance = curDistance + edgeWeight;
				if (newDistance < dist[adjNode]) {
					dist[adjNode] = newDistance;
					pq.add(new Pair1(adjNode, dist[adjNode]));
				}
			}

		}
		return dist;
	}
}

class Pair1 {
	int node;
	int minDistance;

	Pair1(int node, int minDistance) {
		this.node = node;
		this.minDistance = minDistance;
	}
}