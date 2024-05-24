package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
	public List<TreeNode> findDuplicateSubtree(TreeNode root) {
		Map<String, Integer> map = new HashMap<>();
		List<TreeNode> res = new ArrayList<>();
		helper(root, res, map);
		return res;
	}

	public String helper(TreeNode root, List<TreeNode> res, Map<String, Integer> map) {
		if (root == null)
			return "";
		String left = helper(root.left, res, map); // bottom up approach
		String right = helper(root.right, res, map);

		String formedString = root.val + ":" + left + ":" + right;
		map.put(formedString, map.getOrDefault(formedString, 0) + 1);
		if (map.get(formedString) == 2)
			res.add(root); // adding root if its subTrees are duplicate.
		return formedString;
	}
}
