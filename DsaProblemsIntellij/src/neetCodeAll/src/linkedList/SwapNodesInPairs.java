package linkedList;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		ListNode a = head;
		if (head == null || head.next == null)
			return head;
		ListNode b = head.next;
		ListNode newHead = head.next; // 2nd node is newHead, which is now 1st node.
		ListNode prev = null;
		while (a != null && b != null) {
			ListNode tmp = b.next; // 3rd node, next a.
			a.next = tmp;
			b.next = a;
			if (prev != null)
				prev.next = b;
			if (a.next == null)
				break;
			b = a.next.next;
			prev = a;
			a = a.next;
			printList(newHead);
		}
		return newHead;
	}

	// recursion.
	public ListNode helpSwapNodes(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode second = head.next;
		ListNode third = second.next;
		second.next = head; // linking to previous node
		head.next = helpSwapNodes(third);
		return second;
	}

	public void printList(ListNode head) {
		while (head != null) {
			System.out.println(head.val + " -> ");
			head = head.next;
		}
	}
}