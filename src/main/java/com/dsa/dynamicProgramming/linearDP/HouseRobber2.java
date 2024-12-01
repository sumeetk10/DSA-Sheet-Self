package com.dsa.dynamicProgramming.linearDP;

public class HouseRobber2 {
    public int rob(int[] nums) {

        if(nums.length == 1 ) return nums[0];
        if(nums.length == 2 ) return Math.max(nums[0], nums[1]);

        return Math.max(rob1(nums , 0 , nums.length-1) , rob1(nums , 1 , nums.length));
    }


    public int rob1(int[] nums , int start , int end ) {

        int[] dp = new int[end - start];
        dp[0] = nums[start];
        dp[1] = Math.max(dp[0] , nums[start+1]);

        for(int i = start+2 ;i < end ;i++)
            dp[i-start] = Math.max(nums[i] + dp[i-start-2] , dp[i-start-1]);


        return dp[dp.length-1];
    }
}
