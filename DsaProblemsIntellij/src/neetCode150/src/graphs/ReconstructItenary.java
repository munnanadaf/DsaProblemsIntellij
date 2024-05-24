package graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class ReconstructItenary {
	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, PriorityQueue<String>> flights = new HashMap<>();
		LinkedList<String> path = new LinkedList<>();
		for (List<String> ticket : tickets) {
			String src = ticket.get(0);
			String dest = ticket.get(1);
			flights.putIfAbsent(src, new PriorityQueue<>());
			flights.get(src).add(dest);
		}

		dfs("JFK", flights, path);
		return path;
	}

	public void dfs(String src, Map<String, PriorityQueue<String>> flights, LinkedList<String> path) {
		PriorityQueue<String> arrivals = flights.get(src);
		while (arrivals != null && !arrivals.isEmpty()) {
			dfs(arrivals.poll(), flights, path);
		}
		path.addFirst(src);
	}
}