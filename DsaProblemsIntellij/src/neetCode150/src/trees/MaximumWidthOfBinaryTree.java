package trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
	class Node {
		TreeNode node;
		int ind;

		public Node(TreeNode node, int ind) {
			this.node = node;
			this.ind = ind;
		}
	}

	public int maxWidth(TreeNode root) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(root, 0));
		int max = 0;
		while (!q.isEmpty()) {
			Node wrapNode = q.poll();
			TreeNode cur = wrapNode.node;
			int ind = wrapNode.ind;
			int size = q.size();
			int start = 0, end = 0;
			for (int i = 0; i < size; i++) {
				if (i == 0)
					start = ind;
				if (i == size - 1)
					end = ind;
				if (cur.left != null) {
					q.add(new Node(cur.left, 2 * ind)); // storing ind of left child
				} // ind is parent position wrt its children.
				if (cur.right != null) {
					q.add(new Node(cur.right, 2 * ind + 1)); // right child ind.
				}
			}
			max = Math.max(max, end - start + 1);
		}
		return max;
	}
}
