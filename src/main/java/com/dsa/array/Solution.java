package com.dsa.array;

public class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        int n = nums.length;

        for(int i=0; i<n-1; i++) {
            if(nums[i] > nums[i+1]){
                count++;

                if (count > 1) {
                    return false;
                }

                // Decide whether to modify nums[i-1] or nums[i]
                if(i>0 && nums[i-1] > nums[i+1]){
                    nums[i+1] = nums[i];
                }
                else{
                    nums[i] = nums[i+1];
                }
            }
        }

        return count<=1;
    }
}
