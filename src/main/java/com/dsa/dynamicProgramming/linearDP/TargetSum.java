package com.dsa.dynamicProgramming.linearDP;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // Check if the target is achievable
        if ((sum + target) % 2 != 0 || sum < Math.abs(target)) {
            return 0;
        }

        int subsetSum = (sum + target) / 2;
        return countSubsets(nums, subsetSum);
    }

    private int countSubsets(int[] nums, int subsetSum) {
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1; // Base case: one way to get zero sum

        for (int num : nums) {
            for (int j = subsetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[subsetSum];
    }

}
