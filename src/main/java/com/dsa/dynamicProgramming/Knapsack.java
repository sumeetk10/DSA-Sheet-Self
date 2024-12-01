package com.dsa.dynamicProgramming;

public class Knapsack {
    class Solution {
        // Function to return max value that can be put in knapsack of capacity.
        static int knapSack(int capacity, int val[], int wt[]) {
            // code here

            return knapsack(wt,val,capacity, wt.length);
        }

        static int knapsack(int[] wt, int[] val, int W, int n){


            if(n == 0 || W == 0) return 0;
            int[][] t = new int[n+1][w+1];


            if(wt[n-1] <= W){
                return Math.max(val[n-1]+knapsack(wt,val,W-wt[n-1], n-1), knapsack(wt,val,W,n-1));

            }
            else{
                return knapsack(wt,val,W,n-1);
            }
        }
    }
}



//============================Memoization============================

class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int maxProfit(int W, int wt[], int val[],int dp[][],int n){
        if(n<0 || W==0){
            return 0;
        }
        if(dp[n][W]!=-1){
            return dp[n][W];
        }
        else if(wt[n]<=W){
            return dp[n][W]=Math.max(val[n]+maxProfit(W-wt[n],wt,val,dp,n-1), maxProfit(W,wt,val,dp,n-1));
        }
        else{
            return dp[n][W]=maxProfit(W,wt,val,dp,n-1);
        }

    }
    static int knapSack(int W, int wt[], int val[]) {
        // your code here
        int [][]dp=new int[wt.length+1][W+1];

        for(int i=0;i<wt.length+1;i++){
            for(int j=0;j<W+1;j++){
                dp[i][j]=-1;
            }
        }

        return maxProfit(W,wt,val,dp,wt.length-1);
    }
}



//==================Tabulation===========================

class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int maxProfit(int W, int wt[], int val[],int dp[][],int n){
        for(int i=0;i<n+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(wt[i-1]<=j){
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
    static int knapSack(int W, int wt[], int val[]) {
        // your code here
        int [][]dp=new int[wt.length+1][W+1];

        return maxProfit(W,wt,val,dp,wt.length);
    }
}

