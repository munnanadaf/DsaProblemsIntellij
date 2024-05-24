package greedy;

import java.util.Arrays;

class NumberOfMinArrowsToBurstBalloons {
	public int findMinArrowShots(int[][] points) {
		int n = points.length;
		if (n == 0)
			return 0;
		Arrays.sort(points, (a, b) -> a[1] - b[1]);
		int arrowPos = points[0][1]; // ending x we are considering
		int arrowCount = 1;
		for (int i = 1; i < n; i++) {
			if (arrowPos >= points[i][0] && arrowPos <= points[i][1]) // no need to take more arrows, current 1 can
																		// handle
				continue;
			arrowCount++;
			arrowPos = points[i][1];
		}
		return arrowCount;
	}
}