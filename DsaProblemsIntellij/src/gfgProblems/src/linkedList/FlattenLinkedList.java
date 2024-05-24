package linkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class FlattenLinkedList {

	class Node {
		int data;
		Node next;
		Node bottom;

		Node(int d) {
			data = d;
			next = null;
			bottom = null;
		}
	}

	Node flatten(Node root) {
		// Your code here
		List<Integer> resList = new ArrayList<>();
		Node mainNode = root;
		while (mainNode != null) {
			Node bottomNode = mainNode;
			while (bottomNode != null) {
				resList.add(bottomNode.data);
				bottomNode = bottomNode.bottom;
			}
			mainNode = mainNode.next;
		}

		Collections.sort(resList);
		Node head = new Node(resList.get(0));
		Node tmpNode = head;
		for (int i = 1; i < resList.size(); i++) {
			tmpNode.bottom = new Node(resList.get(i));
			tmpNode = tmpNode.bottom;
		}
		return head;
	}
}