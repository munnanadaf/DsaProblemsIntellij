package linkedList;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 */
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

class MaxTwinSumOfLinkedList {
	public int pairSum(ListNode head) {
		Stack<ListNode> stack = new Stack<>();
		ListNode dummy = head;
		while (dummy != null) {
			stack.push(dummy);
			dummy = dummy.next;
		}
		int max = 0;
		while (stack.size() > stack.size() / 2) {
			max = Math.max(max, (head.val + stack.pop().val));
			head = head.next;
		}
		return max;
	}

	public int pairSum1(ListNode head) {

		// //find the middle
		ListNode middle = findMiddle(head);

		// //reverse second half
		ListNode second = reverse(middle);

		// //find pair sum max
		int max = 0;
		while (head != null && second != null) {

			max = Math.max(head.val + second.val, max);
			head = head.next;
			second = second.next;
		}
		return max;
	}

	public ListNode findMiddle(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode reverse(ListNode head) {

		ListNode prev = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		return prev;
	}
}