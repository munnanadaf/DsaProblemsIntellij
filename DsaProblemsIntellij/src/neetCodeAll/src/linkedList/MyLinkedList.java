package linkedList;

class MyLinkedList {
	Node head;
	int size;

	public class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
		}
	}

	public MyLinkedList() {
		this.head = null;
		this.size = 0;
	}

	public int get(int index) {
		if (index >= size)
			return -1;
		int count = 0;
		Node temp = head;
		while (count < index) {
			count++;
			temp = temp.next;
		}
		return temp.val;
	}

	public void addAtHead(int val) {
		Node newnew = new Node(val);
		newnew.next = head;
		head = newnew;
		size++;
	}

	public void addAtTail(int val) {
		if (head == null) {
			addAtHead(val);
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
			Node newnew = new Node(val);
			temp.next = newnew;
			size++;
		}
	}

	public void addAtIndex(int index, int val) {
		if (index > size)
			return;
		if (index == 0)
			addAtHead(val);
		else {
			int count = 1;
			Node temp = head;
			while (count < index) {
				temp = temp.next;
				count++;
			}
			Node newnew = new Node(val);
			Node next = temp.next;
			temp.next = newnew;
			newnew.next = next;
			size++;
		}
	}

	public void deleteAtIndex(int index) {
		if (index >= size)
			return;
		if (index == 0) {
			head = head.next;
			size--;
		} else {
			int count = 1;
			Node temp = head;
			while (count < index) {
				count++;
				temp = temp.next;
			}
			temp.next = temp.next.next;
			size--;
		}
	}
}