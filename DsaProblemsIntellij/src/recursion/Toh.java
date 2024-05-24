package recursion;

//User function Template for Java

//avoid space at the starting of the string in "move disk....."
public class Toh {

	public long toh(int N, int from, int to, int aux) {
		// Your code here
		if (N == 1) {
			System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
			return 1;
		}
		toh(N - 1, from, aux, to);
		System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
		toh(N - 1, aux, to, from);
		return (long) Math.pow(2, N) - 1;
	}
}
