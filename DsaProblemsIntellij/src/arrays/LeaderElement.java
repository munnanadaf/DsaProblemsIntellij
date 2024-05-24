package arrays;

// leader if all the right elements are less than current element;
public class LeaderElement {
	public static void leaderElements(int[] a) {
		int curLeader = a[a.length - 1];
		System.out.print(curLeader + " ");
		for (int i = a.length-1; i >=0; i--) {
			if (a[i] > curLeader) {
				curLeader = a[i];
				System.out.print(curLeader + " ");
			}
		}
	}
	public static void main(String[] args) {
		int k [] = {13,4,5,10,5,8,0,5,8};
		leaderElements(k);
	}
}
