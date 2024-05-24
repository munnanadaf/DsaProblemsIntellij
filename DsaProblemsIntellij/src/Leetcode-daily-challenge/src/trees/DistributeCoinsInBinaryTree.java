package trees;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class DistributeCoinsInBinaryTree {
	int moves;

	public int distributeCoins(TreeNode root) {
		dfs(root);
		return moves;
	}

	private int dfs(TreeNode node) {
		if (node == null)
			return 0;
		int left_excess = dfs(node.left);
		int right_excess = dfs(node.right);
		moves = moves + Math.abs(left_excess) + Math.abs(right_excess);
		return node.val + left_excess + right_excess - 1; // this can make res -ve so Math.abs
		// excluding 1 for current node, so -1
	}
}