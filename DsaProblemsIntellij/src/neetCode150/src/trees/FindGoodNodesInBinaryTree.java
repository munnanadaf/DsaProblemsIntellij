package trees;

class FindGoodNodesInBinaryTree {
	public int goodNodes(TreeNode root) {
		return 1 + findGoodNodes(root.left, root.val) + findGoodNodes(root.right, root.val);
	}

	public int findGoodNodes(TreeNode root, int maxValue) {
		if (root == null)
			return 0;
		int res = 0;
		if (maxValue <= root.val)
			res++;
		maxValue = Math.max(maxValue, root.val);
		int left = findGoodNodes(root.left, maxValue);
		int right = findGoodNodes(root.right, maxValue);
		return left + right + res;
	}
}