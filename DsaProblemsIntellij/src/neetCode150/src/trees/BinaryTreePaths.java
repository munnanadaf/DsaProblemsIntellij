package trees;

import java.util.ArrayList;
import java.util.List;

class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		getPath(res, root, "");
		return res;
	}

	public void getPath(List<String> res, TreeNode root, String temp) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			temp = temp + root.val;
			res.add(temp);
			temp = "";
			return;
		}
		temp = temp + root.val + "->";
		getPath(res, root.left, temp);
		getPath(res, root.right, temp);
	}
}