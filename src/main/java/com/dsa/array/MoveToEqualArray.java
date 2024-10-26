package com.dsa.array;

public class MoveToEqualArray {
    public int minMoves(int[] nums) {

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int x : nums) {
            min = Math.min(min, x);
            sum += x;
        }

        return sum-min*nums.length;
    }
}
