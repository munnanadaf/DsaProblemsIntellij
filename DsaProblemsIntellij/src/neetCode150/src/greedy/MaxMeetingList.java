package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class MaxMeetingList {
	public static void main(String[] args) {
		int N = 10;

		int[] S = { 12, 6, 16, 12, 6, 9, 16, 6, 17, 5 };
		int[] F = { 17, 13, 16, 18, 17, 10, 18, 12, 18, 11 };
		for (int nn : maxMeetings(N, S, F)) {
			System.out.println(nn + " ");
		}
	}

	public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
		// code here
		Pair[] pairs = new Pair[N];
		for (int i = 0; i < N; i++) {
			pairs[i] = new Pair(S[i], F[i], i + 1);
		}

		Arrays.sort(pairs, (a, b) -> a.finish - b.finish);

		ArrayList<Integer> res = new ArrayList<>();
		int prevFinish = pairs[0].finish;
		res.add(pairs[0].pos);

		for (int i = 1; i < pairs.length; i++) {
			if (pairs[i].start > prevFinish) {
				prevFinish = pairs[i].finish;
				res.add(pairs[i].pos);
			}
		}
		Collections.sort(res);
		return res;
	}

	static class Pair {
		int start;
		int finish;
		int pos;

		Pair(int start, int finish, int pos) {
			this.start = start;
			this.finish = finish;
			this.pos = pos;
		}
	}
}
