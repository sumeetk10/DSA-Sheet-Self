package com.dsa.dynamicProgramming;

public class EqualSumPartition {
    static boolean equalPartition(int arr[]) {
        // code here

        int sum = 0;
        for(int num : arr) {
            sum += num;
        }

        if(sum % 2 != 0) return false;

        return findEqualSum(arr, sum/2, arr.length);
    }

    static boolean findEqualSum(int[] arr, int sum, int n) {

        if(sum == 0) return true;
        if(n == 0) return false;

        if(arr[n-1] <= sum){
            return findEqualSum(arr, sum-arr[n-1],n-1) || findEqualSum(arr, sum, n-1);
        }
        else{
            return findEqualSum(arr, sum, n-1);
        }
    }
}
