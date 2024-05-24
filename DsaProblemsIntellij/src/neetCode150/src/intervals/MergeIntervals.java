package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public static void main(String[] args) {
		int a[][] = { { 1, 3 }, { 3, 6 }, { 1, 8 }, { 4, 10 } };
		mergeIntervals(a);

	}

	public static int[][] mergeIntervals(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return new int[0][0];
//		sorting by passing the comparator using first elements of each array in 2d array
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int start = intervals[0][0];
		int end = intervals[0][1];
		List<int[]> res = new ArrayList<>();
		for (int[] row : intervals) {
			if (row[0] <= end) {
				end = Math.max(end, row[1]);
			} else {
				res.add(new int[] { start, end });
				start = row[0];
				end = row[1];
			}
		}
		res.add(new int[] { start, end });
		return res.toArray(new int[0][]);

//		passing an array of size = 0 where it tries to store the resultant array;
// 		if result array can't be accomodated then it will dynamically allocate new array automatically

	}

}
