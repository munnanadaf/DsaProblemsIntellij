package linkedList;

public class CheckIfListIsPalindrome {
	// Function to check whether the list is palindrome.
	boolean isPalindrome(Node head) {
		Node slow = head;
		Node  fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		Node secHead = reverse(slow.next);
		
		while(secHead != null && head != null) {
			if(secHead.data != head.data)
				return false;
			secHead = secHead.next;
			head = head.next;
		}
		return true;
	}

	public Node reverse(Node head) {
		if(head == null)
			return head;
		Node newHead = head; // always reassigning head as newHead, recursive, last node should be head
		if(head.next != null) {
			newHead = reverse(head.next);
			head.next.next = head;  // head's next nodes next will be, curHead; reversing the link. i.e 1->2 to 1 <- 2
			head.next = null;
		}
		return newHead; // last node as newhead
	}

	public void printNodes(Node head) {
		while (head != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
	}

	public static void main(String[] args) {

		CheckIfListIsPalindrome cp = new CheckIfListIsPalindrome();
		Node head = new Node(2);
		head.next = new Node(1);
		System.out.println(cp.isPalindrome(head) + " ******************** ");

	}
}