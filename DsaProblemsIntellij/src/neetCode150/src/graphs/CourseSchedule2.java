package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CourseSchedule2 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adjList = new ArrayList<>();

		for (int i = 0; i < numCourses; i++) {
			adjList.add(new ArrayList<>());
		}

		int totalEdges = prerequisites.length;
		for (int i = 0; i < totalEdges; i++) {
			adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}

		int inDegree[] = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			for (int node : adjList.get(i)) {
				inDegree[node]++;
			}
		}

		Queue<Integer> bfsQueue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] == 0)
				bfsQueue.offer(i);
		}
		List<Integer> res = new ArrayList<>();
		while (!bfsQueue.isEmpty()) {
			int curNode = bfsQueue.poll();
			res.add(curNode);
			for (int neighbourNode : adjList.get(curNode)) {
				inDegree[neighbourNode]--;
				if (inDegree[neighbourNode] == 0)
					bfsQueue.offer(neighbourNode);
			}
		}

		return res.size() == numCourses ? res.stream().mapToInt(num -> num).toArray() : new int[0];

	}
}