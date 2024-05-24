package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class FindAllPeopleWithSecret {
	public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
		Set<Integer> res = new HashSet<>();
		Map<Integer, int[]> personTimeMap = new HashMap<>();
		personTimeMap.put(1, new int[] { firstPerson, 0 });
		res.add(0);
		res.add(firstPerson);
		int m = meetings.length;
		Arrays.sort(meetings, (a, b) -> a[2] == b[2] ? ((a[1] == b[1]) ? a[0] - b[0] : a[1] - b[1]) : a[2] - b[2]);
		for (int i = 0; i < m; i++) {
			int meeting[] = meetings[i];
			if (personTimeMap.containsKey(meeting[0]) && personTimeMap.get(meeting[0])[1] <= meeting[2]) {
				res.add(meeting[1]);
				personTimeMap.put(meeting[1], new int[] { meeting[1], meeting[2] });
			} else {

			}
		}

		return new ArrayList<>(res);
	}

	public static void main(String[] args) {
//		int meetings[][] = { { 1, 2, 5 }, { 2, 3, 8 }, { 1, 5, 10 } };

		int meetings[][] = { { 3, 4, 2 }, { 1, 2, 1 }, { 2, 3, 1 } };
		int n = 5;
		int f = 1;
		System.out.println(findAllPeople(n, meetings, f));
	}
}