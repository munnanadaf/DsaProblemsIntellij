package greedy;

//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class MeetingRooms {
	// Function to find the maximum number of meetings that can
	// be performed in a meeting room.
	public static int maxMeetings(int start[], int end[], int n) {
		Pair[] pairs = new Pair[start.length];
		for (int i = 0; i < start.length; i++) {
			pairs[i] = new Pair(start[i], end[i]);
		}

		Arrays.sort(pairs, (a, b) -> a.end - b.end);

		int res = 0;
		int prevEnd = -1;
		int prevStart = -1;
		for (Pair p : pairs) {
			if (p.start > prevEnd) {
				res++;
				prevStart = p.start;
				prevEnd = p.end;
			}
		}

		return res;

	}

}

class Pair {
	int start;
	int end;

	Pair(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
