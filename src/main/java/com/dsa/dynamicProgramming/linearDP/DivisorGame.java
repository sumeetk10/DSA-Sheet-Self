package com.dsa.dynamicProgramming.linearDP;

public class DivisorGame {
    public boolean divisorGame(int n) {
        if(n==1){
            return false;
        }
        boolean []dp=new boolean [n+1];
        dp[0]=false;
        dp[1]=false;
        dp[2]=true;
        for(int i=3; i<n+1;i++){
            dp[i]=!dp[i-1];
        }
        return dp[n];
    }
}
