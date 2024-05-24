package heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

// return room which conducts max no. of meetings
// can start at any time, delayed meeting if room is not available, but duration remains same.
class MeetingRooms3 {
	public int mostBooked(int n, int[][] meetings) {
		Arrays.sort(meetings, (a, b) -> a[0] - b[0]); // based on meeting start time
		PriorityQueue<long[]> queue = new PriorityQueue<>(
				(a, b) -> a[0] == b[0] ? (int) (a[1] - b[1]) : (int) (a[0] - b[0]));
		// {endTime, room}
		int[] roomCount = new int[n]; // count of meetings at each rooms.
		int result = 0;

		for (int i = 0; i < n; i++) {
			queue.add(new long[] { 0, i }); // initial end time = 0, initial room = 0;
		}

		for (int[] meeting : meetings) {
			int time = meeting[0]; // starttime
			while (queue.peek()[0] < time)
				queue.add(new long[] { time, queue.poll()[1] }); // order all avaialble rooms by room index; // at
																	// curTime, taking minRoom available at queue
			long[] current = queue.poll(); // queue, will always have something bcz, initially we are inserting room
											// numbers with, end time as 0
			int curRoom = (int) current[1];
			long meetingEndTime = current[0] + (meeting[1] - meeting[0]);
			roomCount[curRoom]++;

			if (roomCount[curRoom] > roomCount[result])
				result = curRoom; // max meetings room
			else if (roomCount[curRoom] == roomCount[result])
				result = Math.min(result, curRoom); // if same, we take low index room

			queue.add(new long[] { meetingEndTime, curRoom });
		}
		return result;
	}
}