package dsa;

public class Trees {

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static class BinaryTree {
		static int idx = -1;

		public static Node buildTree(int nodes[]) {
			if (idx == nodes.length - 1) {
				return null;
			}
			idx++;
			if (nodes[idx] == -1) {
				return null;
			}
			Node newNode = new Node(nodes[idx]);
			newNode.left = buildTree(nodes);
			newNode.right = buildTree(nodes);
			return newNode;
		}

		public static void preOrder(Node root) {
			if (root == null) {
				return;
			}

			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}

		public static void inOrder(Node root) {
			if (root == null) {
				return;
			}

			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}

		public static void postOrder(Node root) {
			if (root == null) {
				return;
			}

			inOrder(root.left);
			inOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

public static void main(String[] args) {
	int nodesPreOrder[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
	int nodesInOrder[] = {4,-1,-1,2,5,-1,-1,1,-1,3,6,-1,-1};
	int nodesPostOrder[] = {4,-1,-1,5,-1,-1,2,6,-1,-1};
	BinaryTree tree = new BinaryTree();
	Node root = tree.buildTree(nodesPreOrder);
	Node root1 = tree.buildTree(nodesInOrder);
	Node root2 = tree.buildTree(nodesPostOrder);
//	System.out.println(root.data);
//	tree.preOrder(root);
	tree.inOrder(root1);
//	tree.postOrder(root2);
}
}
