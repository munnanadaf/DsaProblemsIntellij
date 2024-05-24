package dp;

import java.util.Arrays;

class MinCoinsForAmount_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int row[]:dp)
            Arrays.fill(row,-1);
        int ans = f(coins,n-1,amount,dp);
        if(ans>=1e9)return -1;
        return ans;
    }

    public static int f(int[] a, int ind, int t,int dp[][]){
        if(ind==0){
            if(t%a[0]==0) return t/a[0];
            return (int)1e9;
        }
        if(dp[ind][t] != -1 )return dp[ind][t];
        int notTake = 0+f(a,ind-1,t,dp);
        int take = Integer.MAX_VALUE;
        if(a[ind]<=t){
            take = 1+f(a,ind,t-a[ind],dp);
        }

        return dp[ind][t] = Math.min(take,notTake);
    }
}