package linkedList;

import java.util.HashMap;
import java.util.Map;

// Definition for a Node.
class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}

class CopyLinkedListWithRandomPointers {
	public Node copyRandomList(Node head) {
		Node tempHead = head;
		Map<Node, Node> nodes = new HashMap<>();

		while (tempHead != null) {
			Node copy = new Node(tempHead.val);
			nodes.put(tempHead, copy);
			tempHead = tempHead.next;
		}
		nodes.put(tempHead, null);
//		Integer.MAX_VALUE;

		Node copyNode = nodes.get(head);
		Node copyHead = copyNode;
		while (head != null) {
			copyNode.next = nodes.get(head.next);
			copyNode.random = nodes.get(head.random);
			head = head.next;
			copyNode = copyNode.next;
		}

		return copyHead;

	}
}