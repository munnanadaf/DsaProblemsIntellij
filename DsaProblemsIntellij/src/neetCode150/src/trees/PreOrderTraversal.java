package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class PreOrderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		preOrder(root, res);
		return res;
	}

	public static void preOrder(TreeNode root, List<Integer> res) {
		if (root != null) {
			res.add(root.val);
			preOrder(root.left, res);
			preOrder(root.right, res);
		}
	}

	void iterativePreorder(TreeNode root) {

		// Base Case
		if (root == null) {
			return;
		}

		// Create an empty stack and push root to it
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		nodeStack.push(root);

		/*
		 * Pop all items one by one. Do following for every popped item a) print it b)
		 * push its right child c) push its left child Note that right child is pushed
		 * first so that left is processed first
		 */
		while (nodeStack.empty() == false) {

			// Pop the top item from stack and print it
			TreeNode mynode = nodeStack.peek();
			System.out.print(mynode.val + " ");
			nodeStack.pop();

			// Push right and left children of the popped TreeNode to stack
			if (mynode.right != null) {
				nodeStack.push(mynode.right);
			}
			if (mynode.left != null) {
				nodeStack.push(mynode.left);
			}
		}
	}

}