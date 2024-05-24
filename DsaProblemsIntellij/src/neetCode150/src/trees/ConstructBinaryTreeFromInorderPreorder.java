package trees;

class ConstructBinaryTreeFromInorderPreorder {
	int p = 0;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTeeHelper(preorder, inorder, 0, inorder.length - 1);
	}

// bcz all the root nodes in pre order will be coming 1 by 1. ordered.
	public TreeNode buildTeeHelper(int[] preorder, int[] inorder, int startIndex, int endIndex) {
		if (startIndex > endIndex)
			return null;
		TreeNode root = new TreeNode(preorder[p]); // preorder array will be used to create root node.
		int curIndex = getRootIndex(inorder, preorder[p], startIndex, endIndex);
		p++;
		root.left = buildTeeHelper(preorder, inorder, startIndex, curIndex - 1);
		root.right = buildTeeHelper(preorder, inorder, curIndex + 1, endIndex);
		return root;

	}

	public int getRootIndex(int[] inorder, int root, int start, int end) {
		for (int i = start; i <= end; i++) {
			if (inorder[i] == root)
				return i;
		}
		return -1;
	}
}