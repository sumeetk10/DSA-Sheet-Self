package com.dsa.array;

public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {

        int inc,dec;
        inc = dec = 0;

        for(int i=1; i<nums.length; i++) {

            if(nums[i] >= nums[i-1]) inc++;
            if(nums[i] <= nums[i-1]) dec++;
        }

        int len = nums.length-1;
        if(inc == len || dec == len){
            return true;
        }
        else{
            return false;
        }
    }
}
