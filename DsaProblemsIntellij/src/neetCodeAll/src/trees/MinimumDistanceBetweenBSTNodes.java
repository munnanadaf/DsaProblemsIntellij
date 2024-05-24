package trees;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class MinimumDistanceBetweenBSTNodes {
	TreeNode prev = null;
	int res = Integer.MAX_VALUE;

	public int minDiffInBST(TreeNode root) {
		inOrder(root);
		return res;
	}

	public void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		if (prev != null)
			res = Math.min(res, root.val - prev.val);
		prev = root;
		inOrder(root.right);
	}
}