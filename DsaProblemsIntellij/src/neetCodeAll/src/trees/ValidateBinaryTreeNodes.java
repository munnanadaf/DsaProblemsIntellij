package trees;

import java.util.LinkedList;
import java.util.Queue;

class ValidateBinaryTreeNodes {
	public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
		int[] inDegree = new int[n];
		for (int i = 0; i < n; i++) { // i is the root element
			if (leftChild[i] != -1) // left child of i
				inDegree[leftChild[i]]++;
			if (rightChild[i] != -1) // right child of i
				inDegree[rightChild[i]]++;
		}
		int root = -1;
		for (int i = 0; i < n; i++) {
			if (inDegree[i] == 0) { // root node in degree is 0
				if (root == -1)
					root = i;
				else
					return false; // two roots. disconnected trees
			}
		}
		if (root == -1) // did not find any root. // all have inDegree
			return false;
		boolean[] visited = new boolean[n];
		Queue<Integer> que = new LinkedList<>();
		que.offer(root);
		while (!que.isEmpty()) { // level order visiting, bcz i root, left & right are children
			int node = que.poll();
			if (visited[node])
				return false;
			visited[node] = true;
			if (leftChild[node] != -1) {
				que.offer(leftChild[node]);
			}
			if (rightChild[node] != -1) {
				que.offer(rightChild[node]);
			}
		}
		int visitedCount = 0;
		for (boolean b : visited) {
			if (b)
				visitedCount++;
		}

		return visitedCount == n;
	}

	public static void main(String[] args) {
		int leftChild[] = { 1, -1, 3, -1 };
		int rightChild[] = { 2, -1, -1, -1 };
		int n = 4;

		System.out.println(validateBinaryTreeNodes(n, leftChild, rightChild));
	}
}