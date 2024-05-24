package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

class JobSequencing {
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		int[][] jobs = new int[n][3];
		for (int i = 0; i < n; i++) {
			jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
		}

//        sorted based on start time
		Arrays.sort(jobs, (a, b) -> {
			return Integer.compare(a[0], b[0]);
		});

		// [endTime, profit]
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			return Integer.compare(a[0], b[0]);
		});
		int max = 0;
		for (int i = 0; i < n; i++) {
//        	0th index for job[i][0] has startTime, while queue 0th index has endTime
			while (!pq.isEmpty() && jobs[i][0] >= pq.peek()[0]) {
				max = Math.max(max, pq.poll()[1]);
			}
//            array of endTime, Profit into queue;
			pq.offer(new int[] { jobs[i][1], max + jobs[i][2] });
		}

		max = 0;
		while (!pq.isEmpty()) {
			max = Math.max(max, pq.poll()[1]);
		}
		return max;
	}
	
// for dp
	class Job implements Comparable<Job> {
		int start;
		int end;
		int profit;

		Job(int start, int end, int profit) {
			this.start = start;
			this.end = end;
			this.profit = profit;
		}

		public int compareTo(Job otherJob) {
			return this.start - otherJob.start;
		}
	}

	public int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {
		int n = startTime.length;
		Job[] jobs = new Job[n];
		for (int i = 0; i < n; i++) {
			jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
		}
		Arrays.sort(jobs);
		int[] dp = new int[n];
		dp[n - 1] = jobs[n - 1].profit;
		for (int i = n - 2; i >= 0; i--) {
			dp[i] = Math.max(jobs[i].profit, dp[i + 1]);
			for (int j = i + 1; j < n; j++) {
				if (jobs[i].end <= jobs[j].start) {
					dp[i] = Math.max(dp[i], jobs[i].profit + dp[j]);
					break;
				}
			}
		}
		return dp[0];
	}
}