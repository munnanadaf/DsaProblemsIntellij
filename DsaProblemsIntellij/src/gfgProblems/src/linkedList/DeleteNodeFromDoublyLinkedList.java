package linkedList;

public class DeleteNodeFromDoublyLinkedList {
	
	
	// x is node position
	public Node deleteNode(Node head, int x) {
		if(head == null || x == 0)
			return head;
		if(x == 1) // first post
			return head.next; 
		Node tmp = head;
		for(int i =1;i<x-1;i++) { // node before the actual node to be deleted
			tmp = tmp.next;
		}
		tmp.next = tmp.next.next; // deleting middle node // prev link will be broken automatically.
		return head;
	}

}
