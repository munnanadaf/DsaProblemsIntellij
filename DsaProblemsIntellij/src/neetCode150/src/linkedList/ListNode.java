package linkedList;

public class ListNode {
	public ListNode next;
	public int val;

	public ListNode() {
		
	}

	public ListNode(int data) {
		super();
		this.val = data;
	}

	public static ListNode addNode(ListNode head, int data) {
		if (head == null)
			return new ListNode(data);
		ListNode cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = new ListNode(data);
		return head;
	}

	public static void printNode(ListNode head) {
		if (head == null)
			return;
		ListNode cur = head;
		while (cur != null) {
			System.out.print(cur.val + " ->");
			cur = cur.next;
		}
	}

}
