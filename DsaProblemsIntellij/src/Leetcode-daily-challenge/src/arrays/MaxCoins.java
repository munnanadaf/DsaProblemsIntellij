package arrays;

import java.util.Arrays;

// me 2nd highest, bob least, another one always biggest, repeat, return my result
class MaxCoins {
	public int maxCoins(int[] piles) {
		Arrays.sort(piles); // after sorting, 1st 3rd part goes to bob, 2nd to me, 3rd to biggest person
		int res = 0;
		int n = piles.length;
		for (int i = n / 3; i < n; i = i + 2) // first 3 fixed to smallest, next piles alternate between me & big person
			res = res + piles[i];
		return res;
	}
}