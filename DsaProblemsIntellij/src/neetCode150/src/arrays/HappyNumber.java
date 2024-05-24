package arrays;

import java.util.HashSet;

public class HappyNumber {
	public static void main(String[] args) {
		int n = 11;
		System.out.println(isHappyNumber(n));
	}

	public static boolean isHappyNumber(int n) {
		HashSet<Integer> seen = new HashSet<>();

		while (n != 1) {
			int current = n;
			int sum = 0;
			while (current != 0) {
				sum = sum + ((current % 10) * (current % 10));
				current = current / 10;
			}
			if (seen.contains(sum))
				return false;
			seen.add(sum);
			n = sum;
		}
		return true;
	}

}
