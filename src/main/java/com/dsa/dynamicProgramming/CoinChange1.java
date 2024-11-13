package com.dsa.dynamicProgramming;

import java.util.Arrays;

public class CoinChange1 {
    public static long solve(int ind, int target, int coins[], long dp[][]){
        if(target==0)   return 1;
        if(target<0 || ind<0)   return 0;

        if(dp[ind][target] != -1)   return dp[ind][target];
        long nTake = solve(ind-1, target, coins, dp);
        long take = solve(ind, target-coins[ind], coins, dp);

        return dp[ind][target] = (take+nTake);
    }
    long count(int coins[], int sum) {
        // code here.
        int n = coins.length;
        long dp[][] = new long[n][sum+1];
        for(long row[]:dp)
            Arrays.fill(row, -1);
        return solve(n-1, sum, coins, dp);
    }
}
