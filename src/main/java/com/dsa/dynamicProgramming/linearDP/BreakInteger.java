package com.dsa.dynamicProgramming.linearDP;

public class BreakInteger {
    public int integerBreak(int n) {
        int[] dp = new int [n+1];
        dp[0]=0;
        dp[1]=0;
        dp[2]=1;
        for (int i=3;i<=n;i++)
            for (int j=1;j<=i;j++)
                //multiply number with either dp[compliment] or compliment
                dp[i] = Math.max(dp[i], j*Math.max(dp[i-j],i-j));

        return dp[n];
    }
}
