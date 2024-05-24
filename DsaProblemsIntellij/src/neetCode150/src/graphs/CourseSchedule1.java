package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CourseSchedule1 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int inDegree[] = new int[numCourses];
		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			adjList.add(new ArrayList<>());
		}
		int totalEdges = prerequisites.length;
		for (int i = 0; i < totalEdges; i++) {
			adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		for (int i = 0; i < numCourses; i++) {
			for (int it : adjList.get(i)) {
				inDegree[it]++;
			}
		}
		Queue<Integer> bfsQueue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (inDegree[i] == 0) {
				bfsQueue.offer(i);
			}
		}
		List<Integer> resList = new ArrayList<>();
		while (!bfsQueue.isEmpty()) {
			int curNode = bfsQueue.poll();
			resList.add(curNode);
			for (int neighbourNode : adjList.get(curNode)) {
				inDegree[neighbourNode]--;
				if (inDegree[neighbourNode] == 0)
					bfsQueue.offer(neighbourNode);
			}
		}
		return resList.size() == numCourses;
	}
}