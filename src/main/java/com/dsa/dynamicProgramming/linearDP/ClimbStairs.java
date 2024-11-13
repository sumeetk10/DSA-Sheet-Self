package com.dsa.dynamicProgramming.linearDP;

public class ClimbStairs {
    public int climbStairs(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return findWays(n,dp);
    }

    public int findWays(int n, int[] dp){

        if(n == 1 || n==2) return n;

        if(dp[n] != -1) return dp[n];

        else{
            return dp[n] = findWays(n-1,dp) + findWays(n-2,dp);
        }
    }
}
