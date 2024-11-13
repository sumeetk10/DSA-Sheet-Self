package com.dsa.dynamicProgramming;

public class LRS {
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        return findLongRepSubSeq(str, str);

    }
    public int findLongRepSubSeq(String str1, String str2){

        int dp[][] =  new int[str1.length()+1][str2.length()+1];

        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){

                if(str1.charAt(i-1) == str2.charAt(j-1) && i!=j){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
