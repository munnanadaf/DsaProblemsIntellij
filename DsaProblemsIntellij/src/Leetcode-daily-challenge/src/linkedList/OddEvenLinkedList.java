package linkedList;

//  Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		if (head == null)
			return head;
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;
		while (even != null && even.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;

			odd = odd.next;
			even = even.next;
		}
		// atlast the link is broken between odd & even nodes, readding odd last node
		// with even first node.
		odd.next = evenHead;
		return head;

	}
}