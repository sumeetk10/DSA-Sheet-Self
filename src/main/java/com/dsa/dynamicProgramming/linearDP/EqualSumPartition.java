package com.dsa.dynamicProgramming.linearDP;

public class EqualSumPartition {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num: nums){
            totalSum+=num;
        }

        if(totalSum%2!=0){
            return false;
        }
        int subsetSum = totalSum/2;
        Boolean[][] dp = new Boolean[nums.length+1][subsetSum+1];

        return dfs(nums, nums.length-1,subsetSum, dp);
    }

    private boolean dfs(int[] nums, int n, int subsetSum, Boolean[][] dp){
        if(subsetSum == 0){
            return true;
        }
        if(subsetSum<0 || n==0){
            return false;
        }
        if(dp[n][subsetSum]!=null){
            return dp[n][subsetSum];
        }

        boolean res =  dfs(nums, n-1, subsetSum-nums[n-1], dp) || dfs(nums, n-1, subsetSum, dp);
        dp[n][subsetSum] = res;
        return dp[n][subsetSum];
    }
}
