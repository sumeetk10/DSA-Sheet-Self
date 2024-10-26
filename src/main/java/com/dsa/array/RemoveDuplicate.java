package com.dsa.array;

public class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {

        int left = 0;
        int right = 1;

        while(right < nums.length) {
            if(nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
            right++;
        }

        return left+1;
    }
}
