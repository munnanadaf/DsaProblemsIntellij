package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeZigZagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		int level = 1;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (q.size() > 0) {
			int size = q.size();
			List<Integer> subList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode curNode = q.poll();
				if (curNode.left != null)
					q.offer(curNode.left);
				if (curNode.right != null)
					q.offer(curNode.right);
				if (level % 2 != 0) // starting from level 1, for us level 0 will be in correct order
					subList.add(curNode.val);
				else // alternate will be in reverse order.
					subList.add(0, curNode.val);
			}
			level++;
			res.add(new ArrayList<>(subList));
		}
		return res;
	}
}