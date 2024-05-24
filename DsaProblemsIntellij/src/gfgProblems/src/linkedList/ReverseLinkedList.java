package linkedList;

class ReverseLinkedList {
	// Function to reverse a linked list.
	Node reverseList(Node head) {
		// code here
		if (head == null)
			return head;
		// Node tmp = head.next;
		Node newHead = head;
		if (head.next != null) {
			newHead = reverseList(head.next);
			head.next.next = head; // linking nextnodes.next to cur. then unlinking curLink
			head.next = null;
		}
		return newHead;

// iterative        
		// Node prev = null;
		// Node cur = head;
		// Node next = null;
		// while(cur != null){
		// next = cur.next;
		// cur.next = prev;
		// prev = cur;
		// cur = next;
		// }
		// return prev;
	}

}