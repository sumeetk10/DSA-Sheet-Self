package com.dsa.dynamicProgramming.linearDP;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        for(int n : nums) {
            if(maxNum < n) maxNum = n;
        }

        int[] dp = new int[maxNum + 1];
        for(int n : nums) {
            dp[n] += n;
        }

        for(int i=2; i<=maxNum; i++) {
            dp[i] = Math.max(dp[i-2] + dp[i], dp[i-1]);
        }
        return dp[maxNum];
    }
}
