package com.dsa.array;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;

        for(int x : nums) {
            leftSum += x;
        }

        for(int i=0; i<nums.length; i++) {
            leftSum -= nums[i];

            if(leftSum == rightSum) return i;

            rightSum += nums[i];
        }

        return -1;
    }
}
