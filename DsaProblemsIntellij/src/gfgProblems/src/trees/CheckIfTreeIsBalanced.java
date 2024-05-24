package trees;

public class CheckIfTreeIsBalanced {
	public boolean isBalanced(Node root) {
		return helpCheck(root) > 0 ? true : false;
	}

	public int helpCheck(Node root) {
		if (root == null)
			return 0;
		int lh = helpCheck(root.left);
		int rh = helpCheck(root.right);
		if (lh == -1 || rh == -1)
			return -1;
		int diff = Math.abs(lh - rh);
		return diff <= 1 ? diff + 1 : -1;
	}

	// -1, if not balanced, otherwise returning height of the tree.
}
