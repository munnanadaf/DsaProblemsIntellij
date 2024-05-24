package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class LargestValueInEachTreeRow {
	public List<Integer> largestValues(TreeNode root) {
		if (root == null)
			return new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int curr_level_size = queue.size();
			int max_val = Integer.MIN_VALUE;

			for (int i = 0; i < curr_level_size; i++) { // processing cur level nodes.
				TreeNode node = queue.poll();
				max_val = Math.max(max_val, node.val);

				if (node.left != null)
					queue.offer(node.left); // next level nodes
				if (node.right != null)
					queue.offer(node.right);// next level nodes
			}

			result.add(max_val);
		}
		return result;
	}
}