package trees;

public class LCA {
	public Node lca(Node root, int n1, int n2) {
		if (root == null)
			return root;
		if (root.data < n1 && root.data < n2) // root less than both n1 & n2, so ancestor must be in right subtree
			return lca(root.right, n1, n2);
		else if (root.data > n1 && root.data > n2) // ancestor must be in left subtree
			return lca(root.left, n1, n2);
		return root; // n1 is in left subtree & n2 is in right subtree so root is our lowest common
						// ancestor
	}
}
