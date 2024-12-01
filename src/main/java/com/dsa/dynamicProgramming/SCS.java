package com.dsa.dynamicProgramming;

public class SCS {

    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Your code here
        //m+n-lcs

        int[][] dp=new int[m+1][n+1];
        for(int[] a:dp)
            Arrays.fill(a,-1);

        solve(dp,X,Y,m,n);

        return m+n-dp[m][n];
    }

    static int solve(int[][] dp,String s1,String s2,int i,int j)
    {
        if(i== 0|| j==0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int inc=0,ni=0;
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            inc = 1+solve(dp,s1,s2,i-1,j-1);
        }

        else{
            ni = Math.max(solve(dp,s1,s2,i-1,j),solve(dp,s1,s2,i,j-1));
        }

        dp[i][j]=Math.max(inc,ni);
        return dp[i][j];

    }
}


class PrintSCS{
    class Solution {
        public String shortestCommonSupersequence(String str1, String str2) {

            int m=str1.length();
            int n=str2.length();

            int dp[][]=new int[m+1][n+1];

            for(int i[]:dp){
                Arrays.fill(i, -1);
            }

            for(int i=0;i<=m;i++){
                dp[i][0]=0;
            }
            for(int i=0;i<=n;i++){
                dp[0][i]=0;
            }

            for(int i=1;i<m+1;i++){
                for(int j=1;j<n+1;j++){

                    if(str1.charAt(i-1)==str2.charAt(j-1)){
                        dp[i][j]=1+dp[i-1][j-1];
                    }

                    else{
                        dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
                    }
                }
            }

            String ans="";
            int i=m,j=n;

            //print lcs
            while(i>0 && j>0){

                if(str1.charAt(i-1)==str2.charAt(j-1)){

                    ans+=str1.charAt(i-1);
                    i--;
                    j--;

                }
                else if(dp[i-1][j]>dp[i][j-1]){

                    ans+=str1.charAt(i-1);
                    i--;
                }
                else{

                    ans+=str2.charAt(j-1);
                    j--;
                }
            }

            //print remaining
            while(i>0){
                ans+=str1.charAt(i-1);
                i--;
            }
            while(j>0){
                ans+=str2.charAt(j-1);
                j--;
            }

            String ans2 = new StringBuilder(ans).reverse().toString();
            return ans2;
        }
    }
}