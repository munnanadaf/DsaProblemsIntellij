package linkedList;

class MiddleOfLinkedList {
	int getMiddle(Node head) {
		// Your code here.
		Node slow = head;
		Node fast = head;
		int n = 0;

		while (fast != null && fast.next != null) { // mid+1 for even length.
			slow = slow.next;
			fast = fast.next.next; // if even, fast will be assigned null in this case.
		}
		return slow.data;
	}
}