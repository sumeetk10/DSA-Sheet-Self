package com.dsa.dynamicProgramming.linearDP;

public class DecodeWays {
    public int numDecodings(String s) {
        int[] memo = new int[101];
        Arrays.fill(memo,-1);
        return solveitForMe(0,s,memo);

    }

    private int solveitForMe(int indx, String s, int[] memo){

        if(indx>=s.length())
            return 1;
        if(memo[indx]!=-1)
            return memo[indx];

        int res = 0;
        int way1 = s.charAt(indx)-'0';                  //take One digit at a time
        int way2 = 0;

        if(indx<s.length()-1)
            way2 = way1*10 + s.charAt(indx+1)-'0';      //take two digit fixed first then move further

        if(way1>0)
            res+=solveitForMe(indx+1,s,memo);           //move by index + 1
        if(way2>=10 && way2<=26)
            res+=solveitForMe(indx+2,s,memo);           //move by index + 2

        return memo[indx] = res;

    }
}
