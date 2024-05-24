package trees;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfBinaryTree {
	public boolean isCompleteBinaryTree(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		boolean end = false;
		while (!q.isEmpty()) {
			TreeNode curNode = q.poll();
			if (curNode == null)
				end = true; // indicates, this is the last node
			else {
				if (end) // the curNode is not null & previously encountered null node, so not complete
							// binary tree
					return false;// complete is filled left to right, no gap in between, at the end it can be
									// empty
				q.offer(curNode.left);
				q.offer(curNode.right);
			}
		}
		return true;
	}
}
