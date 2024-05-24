package linkedList;

class RemoveDuplicateElements {
	// Function to remove duplicates from sorted linked list.
	Node removeDuplicates(Node head) {
		// Your code here
		Node tmp = head;
		while (tmp != null) {
			while (tmp.next != null && tmp.data == tmp.next.data) {
				tmp.next = tmp.next.next;
			}
			tmp = tmp.next;
		}
		return head;
	}
}