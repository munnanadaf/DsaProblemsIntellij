package linkedList;

// design a circuilar queue
public class MyCircularQueue {
	public class Node {
		Node next;
		int value;

		public Node() {

		}

		public Node(int value) {
			this.value = value;
		}

	}

	Node head;
	Node tail;
	int size;
	int k;

	public MyCircularQueue(int k) {
		this.k = k;
		this.size = 0;
	}

	public boolean enQueue(int value) {
		if (isFull())
			return false;
		if (isEmpty()) {
			head = new Node(value);
			tail = head;
			size++;
			return true;
		} else {
			tail.next = new Node(value);
			tail = tail.next;
			tail.next = head;
			size++;
			return true;
		}
	}

	public boolean deQueue() {
		if (isEmpty())
			return false;
		if (head == tail) {
			head = null;
			tail = null;
			size--;
			return true;
		}
		tail.next = head.next; // breaking link for 1st node, connecting to 2nd node
		head = head.next; // making 2nd node new head.
		size--;
		return true;

	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == k;
	}

	public int Front() {
		return size > 0 ? head.value : -1;
	}

	public int Rear() {
		return size > 0 ? tail.value : -1;
	}
}
