package dsa;


//Java program for the above approach
class GFG{

	// Function to find the minimum
	// number to steps to reduce N to 0
	static int minDays(int n)
	{

		// Base case
		if (n < 1)
			return n;

		// Recursive Call to count the
		// minimum steps needed
		int cnt = 1 + Math.min(n % 2 + minDays(n / 2),
							n % 3 + minDays(n / 3));

		// Return the answer
		return cnt;
	}

	// Driver Code
	public static void main(String[] args)
	{
		// Given Number N
		int N = 5;

		// Function Call
		System.out.print(minDays(N));
	}
}

//This code is contributed by PrinciRaj1992
