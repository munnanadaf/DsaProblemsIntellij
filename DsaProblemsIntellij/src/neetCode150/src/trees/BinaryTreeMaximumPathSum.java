package trees;

class BinaryTreeMaximumPathSum {
	int curMax;

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		curMax = root.val;
		maxPathSumHelper(root);
		return curMax;
	}

	public int maxPathSumHelper(TreeNode root) {
		if (root == null)
			return 0;
		int leftMax = Math.max(0, maxPathSumHelper(root.left));
		int rightMax = Math.max(0, maxPathSumHelper(root.right));
//		1st case, we include all, both left n right n current root.
		curMax = Math.max(curMax, root.val + leftMax + rightMax);
//		2nd case, we either take left+cur or right+cur.
		return root.val + Math.max(leftMax, rightMax);
	}
}