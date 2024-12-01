package com.dsa.dynamicProgramming;

import java.util.Arrays;

public class LCS {
    //longest common subsequence
    //memoization

    static int lcs(int n, int m, String s1, String s2) {


        //recursive + memoization
        int x=s1.length(),y=s2.length();
        int[][] dp=new int[x+1][y+1];
        for(int[] a:dp)
            Arrays.fill(a,-1);

        solve(dp,s1,s2,x,y);

        return dp[x][y];
    }

    static int solve(int[][] dp,String s1,String s2,int i,int j)
    {
        if(i== 0|| j==0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int inc=0,ni=0;
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            inc = 1+solve(dp,s1,s2,i-1,j-1);
        }

        else{
            ni = Math.max(solve(dp,s1,s2,i-1,j),solve(dp,s1,s2,i,j-1));
        }

        dp[i][j]=Math.max(inc,ni);
        return dp[i][j];

    }
}

class BottomUpLCS{
    public int longestCommonSubsequence(String text1, String text2) {
        //Bottom Up approach
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n+1][m+1];
        // for(int i = 0 ; i < n ; i++) Arrays.fill(dp[i], -1);
        // return lcs(n-1, m-1, text1, text2, dp);
        for(int i = 0 ; i <= n; i++) dp[i][0] = 0;
        for(int j = 0 ; j <= m; j++) dp[0][j] = 0;

        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= m ; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                {
                    int pick1 = dp[i-1][j];
                    int pick2 = dp[i][j-1];
                    dp[i][j] = Math.max(pick1, pick2);
                }
            }
        }
        return dp[n][m];
    }

}
