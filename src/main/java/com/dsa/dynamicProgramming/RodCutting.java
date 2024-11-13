package com.dsa.dynamicProgramming;

public class RodCutting {
    public int cutRod(int price[], int n) {

        int dp[][]=new int[n+1][n+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                dp[i][j]=dp[i-1][j];
                if(j>=i)
                    dp[i][j]=Math.max(dp[i][j],dp[i][j-i]+price[i-1]);
            }
        }
        return dp[n][n];
    }
}
