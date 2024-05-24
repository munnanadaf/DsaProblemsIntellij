package trees;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class TreeFromInorderANDPostOrder {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int n = postorder.length;
		if (n == 0)
			return null;
		if (n == 1)
			return new TreeNode(inorder[0]);
		return helpBuildTree(inorder, postorder, 0, n - 1, 0, n - 1);
	}
	public TreeNode helpBuildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd)
			return null;
		int rootVal = postorder[postEnd];
		TreeNode root = new TreeNode(rootVal);
		int mid = getRootIndex(inorder, rootVal);
		int leftTreeSize = mid - inStart;
		int rightTreeSize = inEnd - mid;
		root.left = helpBuildTree(inorder, postorder, inStart, mid - 1, postStart, postStart + leftTreeSize - 1);
		root.right = helpBuildTree(inorder, postorder, mid + 1, inEnd, postEnd - rightTreeSize, postEnd - 1);
		return root;
	}
	public int getRootIndex(int[] inorder, int root) {
		for (int i = 0; i <= inorder.length; i++) {
			if (inorder[i] == root)
				return i;
		}
		return 0;
	}
}