package com.dsa.dynamicProgramming;

public class SubsetSum {

        static Boolean isSubsetSum(int arr[], int sum) {
            // code here
            return findSubset(arr,sum,arr.length);
        }

        static boolean findSubset(int[] arr, int sum, int n){

            if(sum == 0) return true;
            if(n == 0) return false;

            if(arr[n-1] <= sum){
                return findSubset(arr, sum-arr[n-1], n-1) || findSubset(arr,sum,n-1);
            }
            else{
                return findSubset(arr, sum, n-1);
            }
        }

}


//Bottom up approach

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean dp[][] = new boolean[N+1][sum+1];
        for(int i=0;i<N+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0){
                    dp[i][j] = false;
                }
                if(j==0){
                    dp[i][j] = true;
                }
            }
        }

        for(int i=1;i<N+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][sum];
    }
}