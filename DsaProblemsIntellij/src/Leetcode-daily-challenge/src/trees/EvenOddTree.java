package trees;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */



class EvenOddTree {
	public boolean isEvenOddTree(TreeNode root) {
		Queue<TreeNode> q = new ArrayDeque<>();
		q.offer(root);
		var level = 0;
		while (!q.isEmpty()) {
			var prev = level % 2 == 0 ? -1 : Integer.MAX_VALUE;
			// for each level prev will be reassigned, if even node i.e 0, 2, 4, it will be
			// -1, otherwise max value.
			// coming from right to left. thats y taking previous as max.
			// each complete for loop represents 1 complete level elements.
			for (var i = q.size(); i > 0; i--) {
				var node = q.poll();
				if (level % 2 == 0) {
					if (node.val % 2 == 0 || node.val <= prev)
						return false;
				} else {
					if (node.val % 2 != 0 || node.val >= prev)
						return false;
				}
				prev = node.val;
				if (node.left != null)
					q.offer(node.left);
				if (node.right != null)
					q.offer(node.right);
			}
			level++;
		}
		return true;
	}
}