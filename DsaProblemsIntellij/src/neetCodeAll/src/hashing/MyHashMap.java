package hashing;

class MyHashMap {
	public static final int size = 19997;
	public static final int mult = 12582917;
	ListNode data[];

	public int hash(int key) {
		return (int) (((long) key * mult) % size);
	}

	public MyHashMap() {
		data = new ListNode[size];
	}

	public void put(int key, int value) {
		remove(key); // if already contains, need to replace. first need to remove from linkedList
		int h = hash(key);
		ListNode node = new ListNode(key, value, data[h]);
		data[h] = node;
	}

	public int get(int key) {
		int h = hash(key);
		ListNode node = data[h];
		for (; node != null; node = node.next) {
			if (node.key == key)
				return node.value;
		}
		return -1;
	}

	public void remove(int key) {
		int h = hash(key);
		ListNode node = data[h];
		if (node == null)
			return;
		if (node.key == key)
			data[h] = node.next; // first node itself, replacing current with next node, may be available,
									// otherwise null;
		for (; node.next != null; node = node.next) {
			if (node.next.key == key) {
				node.next = node.next.next;
				return;
			}
		}
	}
}

class ListNode {
	int key;
	int value;
	ListNode next;

	ListNode(int key, int value, ListNode next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */