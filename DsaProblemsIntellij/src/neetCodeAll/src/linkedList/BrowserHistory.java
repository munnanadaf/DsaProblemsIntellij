package linkedList;

class BrowserHistory {

	class Node {
		String val;
		Node prev;
		Node next;

		public Node(String val) {
			this.val = val;
		}
	}

	Node cur;

	public BrowserHistory(String homepage) {
		Node node = new Node(homepage);
		node.prev = null;
		node.next = null;
		cur = node;
	}

	public void visit(String url) {
		Node node = new Node(url);
		cur.next = node;
		Node tmp = cur;
		cur = cur.next;
		cur.prev = tmp;
	}

	public String back(int steps) {
		while (cur.prev != null && steps-- > 0) {
			cur = cur.prev;
		}
		return cur.val;
	}

	public String forward(int steps) {
		while (cur.next != null && steps-- > 0) {
			cur = cur.next;
		}
		return cur.val;
	}
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage); obj.visit(url); String
 * param_2 = obj.back(steps); String param_3 = obj.forward(steps);
 */