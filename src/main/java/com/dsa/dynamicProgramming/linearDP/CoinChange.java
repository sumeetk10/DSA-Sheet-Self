package com.dsa.dynamicProgramming.linearDP;

public class CoinChange {
    public int solve(int coins[],int amount, int i,int dp[][]  ){
        int n=coins.length;
        if(amount==0){
            return 0;
        }
        if(i>=n || amount<0){
            return Integer.MAX_VALUE-1;
        }
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }
        int include=Integer.MAX_VALUE;
        if(amount>=coins[i]){
            include =1+ solve(coins,amount-coins[i], i,dp);
        }
        int exclude= solve(coins,amount,i+1,dp);
        return dp[i][amount]= Math.min(include,exclude);
    }
    public int coinChange(int[] coins, int amount) {
        int dp[][]= new int[coins.length][amount+1];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        int result=solve(coins,amount,0,dp);
        return result==Integer.MAX_VALUE-1? -1:result;
    }
}
