package trees;

/// if left depth and right depth difference is <=1
class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return maxDepth(root) == -1 ? false : true;
	}

	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int l = maxDepth(root.left);
		int r = maxDepth(root.right);
//		edge case for skewed tree
		if (l == -1 || r == -1)
			return -1;
		if (Math.abs(l - r) > 1)
			return -1;
		return 1 + (Math.max(l, r));
	}
}