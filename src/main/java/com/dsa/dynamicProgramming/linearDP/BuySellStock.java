package com.dsa.dynamicProgramming.linearDP;

public class BuySellStock {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[] dp = new int[n+1];
        dp[0] = 0 ;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<prices.length ;i++){
            min = Math.min(min, prices[i]);
            dp[i+1] = Math.max(dp[i], prices[i] - min);
        }

        return dp[n];
    }
}
