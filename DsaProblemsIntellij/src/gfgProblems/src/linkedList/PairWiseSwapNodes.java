package linkedList;

public class PairWiseSwapNodes {
	public Node swapPairWise(Node head) {
		if (head == null || head.next == null)
			return head;
		Node prev = null;
		Node next = null;
		Node slow = head;
		Node fast = head.next;
		Node newHead = head.next;

		while (slow != null && fast != null) {
			next = fast.next;
			slow.next = next; // linking slow to fast's next
			fast.next = slow;
			if (prev != null)
				prev.next = fast; // linking prev node to fast, which was new Slow earlier.
			if (slow.next == null) // check if there is next node or not
				break;
			fast = slow.next.next; // slow will be moved to next, next's next will be our fast.
			prev = slow;
			slow = slow.next;
		}
		return newHead;
	}
}
