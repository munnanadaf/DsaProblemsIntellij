package trees;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class DeleteANodeInBST {
	public TreeNode deleteNode(TreeNode root, int key) {

		// key not in tree
		if (root == null)
			return root;

		if (root.val > key)
			root.left = deleteNode(root.left, key);

		else if (root.val < key)
			root.right = deleteNode(root.right, key);

		// node with key , found, root is our key
		else {
			// case1 - leaf node
			if (root.left == null && root.right == null)
				return null;

			// case2 - 1 child, return entire opposite subtree
			if (root.left == null) // making right node as new root
				return root.right;

			else if (root.right == null)
				return root.left;

			// case3 - 2 child
			TreeNode next = nextInorderNode(root.right); // leftMost node in rightSubtree will be always > root.
			root.val = next.val;
			root.right = deleteNode(root.right, next.val);
		}

		return root;
	}

	static TreeNode nextInorderNode(TreeNode node) {
		// find leftmost node

		while (node.left != null)
			node = node.left;

		return node;
	}
}