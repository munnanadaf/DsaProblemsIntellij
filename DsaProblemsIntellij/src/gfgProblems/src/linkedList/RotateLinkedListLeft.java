package linkedList;

class RotateLinkedListLeft {
	// Function to rotate a linked list.
	public Node rotate(Node head, int k) {
		// add code here
		int n = 0;
		Node tmp = head;
		while (tmp != null) {
			n++;
			tmp = tmp.next;
		}
		if (k > n)
			k = n - k % n;

		if (n == k)
			return head;
		Node newHead = head;
		Node prev = null;
		while (k > 0) {
			prev = newHead;
			newHead = newHead.next;
			k--;
		}
		prev.next = null;

		Node last = newHead;
		while (last != null && last.next != null) {
			last = last.next;
		}
		last.next = head;
		return newHead;
	}
}