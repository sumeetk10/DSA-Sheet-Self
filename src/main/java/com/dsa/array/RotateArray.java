package com.dsa.array;

public class RotateArray {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        if(n <= 1) return;

        k = k%n;
        helper(nums,0, n-1);
        helper(nums, 0, k-1);
        helper(nums, k, n-1);
    }

    public void helper(int[] nums, int low, int high){

        while(low <= high){
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;

            low++;
            high--;
        }
    }
}
