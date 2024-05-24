package bits;

class NumberOfWonderfulSubstrings {
	public long wonderfulSubstrings(String word) {
		long count[] = new long[1024];
		long res = 0;
		int mask = 0;
		count[0] = 1; // empty string means even
		for (var ch : word.toCharArray()) {
			mask ^= 1 << (ch - 'a');
			res += count[mask];
			for (var n = 0; n < 10; n++)
				res += count[mask ^ (1 << n)];
			++count[mask];
		}
		return res;
	}
}