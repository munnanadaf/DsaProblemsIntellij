package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBinaryTree {
	public void serialize(Node root, ArrayList<Integer> A) {
		Queue<Node> q = new LinkedList<>();
		int i = 0;
		q.add(root);
		A.add(root.data);
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (cur.left != null) {
				q.add(cur.left);
				A.add(cur.left.data);
			} else {
				A.add(-1);
			}
			if (cur.right != null) {
				q.add(cur.right);
				A.add(cur.right.data);
			} else {
				A.add(-1);
			}
		}
	}

	public Node deSerialize(ArrayList<Integer> A) {
		int i = 0;
		Queue<Node> q = new LinkedList<>();
		Node root = new Node(A.get(i++));
		q.offer(root);
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			int elem = A.get(i++);
			if (elem != -1) {
				cur.left = new Node(elem);
				q.add(cur.left); // for next level of adding. left subTree
			}
			elem = A.get(i++);
			if (elem != -1) {
				cur.right = new Node(elem);
				q.add(cur.right); // for next level of adding, right subtree
			}
		}
		return root;
	}
}
