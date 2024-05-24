package graphs;

public class FindJudge {
//	1st person trusts 2nd person
	public int findJudge(int n, int trust[][]) {
		if (n == 1)
			return 1; // he doesnt trust anyone
		int trustCount[] = new int[n + 1];
		for (int arr[] : trust) {
			trustCount[arr[0]]--;// outgoing, he trusts 2nd person
			trustCount[arr[1]]++;// incoming, 1st person trusts him
		}

		for (int person = 0; person < trustCount.length; person++) {
			if (trustCount[person] == n - 1)
				return person;// actually we are storing person as index; in trustCount array
		}
		return -1;
	}
}
