package linkedList;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class DoubleANumberRepresentedAsLinkedList {
	int carry;

	public ListNode doubleIt(ListNode head) {
		carry = 0;
		helpDouble(head);
		return (carry == 0) ? head : new ListNode(carry, head);
	}

	public void helpDouble(ListNode head) {
		if (head == null)
			return;
		helpDouble(head.next);
		int cur = 2 * head.val + carry;
		carry = cur / 10;
		head.val = cur % 10;
	}
}