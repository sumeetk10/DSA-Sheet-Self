package com.dsa.dynamicProgramming;

import java.util.Arrays;

public class NumberOfInsertAndDelete {
    public int minOperations(String str1, String str2)
    {
        // Your code goes here
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] a:dp){
            Arrays.fill(a, -1);
        }

        int lcs = LCS(str1,str2, n, m, dp);

        int insert = n - lcs;
        int del = m - lcs;

        return insert+del;
    }

    public int LCS(String s1, String s2, int n, int m, int[][] dp) {

        if(n == 0 || m == 0) return 0;

        if(dp[n][m] != -1) return dp[n][m];

        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return dp[n][m] = 1+ LCS(s1,s2,n-1,m-1,dp);
        }

        return dp[n][m] = Math.max(LCS(s1,s2,n-1,m,dp) , LCS(s1,s2,n, m-1,dp));
    }
}
