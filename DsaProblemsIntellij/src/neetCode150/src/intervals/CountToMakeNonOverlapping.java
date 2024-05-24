package intervals;

import java.util.Arrays;

class CountToMakeNonOverlapping {
	public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		int prevEnd = intervals[0][1];
		int res = 0;
		for (int i = 1; i < intervals.length; i++) {
			int curStart = intervals[i][0];
			int curEnd = intervals[i][1];
			if (curStart >= prevEnd)
				prevEnd = Math.max(curEnd, prevEnd);
			else {
				res++;
				prevEnd = Math.min(curEnd, prevEnd);
			}
		}

		return res;
	}
}