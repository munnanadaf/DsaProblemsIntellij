package trees;

public class IsSumTree {
	int sum(Node root) {
		if (root == null)
			return 0;
		return root.data + sum(root.left) + sum(root.right);
	}

	boolean isSumTree(Node root) {
		// Your code here
		if (root == null)
			return true;
		if (root.left == null && root.right == null)
			return true;

		return ((root.data == sum(root.left) + sum(root.right)) && (isSumTree(root.left) && isSumTree(root.right)));
	}
}
