package com.dsa.dynamicProgramming;

public class PartitionWithGIvenDiff {
    static int mod=(int)Math.pow(10,9)+7;
    public static int countSubsetWithTarget(int n, int arr[], int target, int dp[][]){
        if(n == 0) {
            if(target == 0)
                return 1;
            return 0;
        }
        if(dp[n][target]!=-1){
            return dp[n][target];
        }
        else if(arr[n-1]>target){
            return dp[n][target]=countSubsetWithTarget(n-1,arr,target,dp)%mod;
        }
        else{
            return dp[n][target]=(countSubsetWithTarget(n-1,arr,target,dp)+countSubsetWithTarget(n-1,arr,target-arr[n-1],dp))%mod;
        }
    }
    public static int countPartitions(int n, int d, int[] arr) {
        // code here
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        if((d+sum)%2!=0||sum<d||n==1)return 0;
        int target=(sum+d)/2;
        int dp[][]=new int[n+1][target+1];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        countSubsetWithTarget(n,arr,target,dp);
        return dp[n][target];
    }
}
