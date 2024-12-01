package com.dsa.dynamicProgramming;
import java.util.*;
public class LPS {
    public int longestPalinSubseq(String S)
    {
        //code here
        StringBuilder str = new StringBuilder();

        str.append(S);
        String rev = str.reverse().toString();

        int n = S.length();
        int m = rev.length();
        int[][] dp = new int[n+1][m+1];

        for(int[] a: dp) {
            Arrays.fill(a,-1);
        }

        return LPS(S, rev, n, m, dp);
    }

    public int LPS(String s1, String rev, int n, int m, int[][] dp){

        if(n == 0 || m == 0) return 0;
        if(dp[n][m] != -1) {
            return dp[n][m];
        }

        if(s1.charAt(n-1) == rev.charAt(m-1)){
            return dp[n][m] = 1 + LPS(s1,rev,n-1,m-1, dp);
        }

        return dp[n][m] = Math.max(LPS(s1, rev, n-1,m,dp), LPS(s1,rev,n,m-1,dp));
    }
}
