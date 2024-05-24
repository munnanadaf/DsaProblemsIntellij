package trees;

public class DiameterOfTheBinaryTree {
	int diam = 0;

	public int diameter(Node root) {
		helpFindDiam(root);
		return diam;
	}

	public int helpFindDiam(Node root) {
		if (root == null)
			return 0;
		int lh = helpFindDiam(root.left);
		int rh = helpFindDiam(root.right);
		diam = Math.max(diam, lh + rh + 1); // left+right+curRoot = count, cur diam from cur Node
		return 1 + Math.max(lh, rh); // considers max height from cur node, either left or right
	}
}
