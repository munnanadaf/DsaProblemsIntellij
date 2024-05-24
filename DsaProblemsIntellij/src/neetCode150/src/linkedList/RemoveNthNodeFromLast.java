package linkedList;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
public class RemoveNthNodeFromLast {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.addNode(head, 2);
		head.addNode(head, 3);
		head.addNode(head, 4);
		head.addNode(head, 5);

		head.printNode(removeNthFromEnd(head, 2));
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;
		if (head.next == null && n == 1)
			return null;
		ListNode start = new ListNode();
		start.next = head;
		ListNode slow = start;
		ListNode fast = start;
		int i = 0;
		while (i < n && fast != null && fast.next != null) {
			fast = fast.next;
			i++;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return start.next;
	}
}