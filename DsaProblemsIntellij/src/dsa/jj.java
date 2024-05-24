package dsa;

//Java implementation of the approach
class jj
{
static int MOD = (int)(1e9 + 7);

//Function to find the count of integers
//obtained by replacing '?' in a given
//string such that formed integer
//gives remainder 5 when it is divided by 13
static int modulo_13(String s, int n)
{
	long [][]dp = new long[n + 1][13];

	// Initialise
	dp[0][0] = 1;

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < 10; j++)
		{
			int nxt = s.charAt(i) - '0';

			// Place digit j at ? position
			if (s.charAt(i) == '?')
				nxt = j;

			// Get the remainder
			for (int k = 0; k < 13; k++)
			{
				int rem = (10 * k + nxt) % 13;
				dp[i + 1][rem] += dp[i][k];
				dp[i + 1][rem] %= MOD;
			}
			if (s.charAt(i) != '?')
				break;
		}
	}

	// Return the required answer
	return (int)dp[n][1];
}

//Driver code
public static void main(String []args)
{
	String s = "??";
	int n = s.length();

	System.out.println(modulo_13(s, n));
}
}

//This code is contributed by Rajput-Ji

