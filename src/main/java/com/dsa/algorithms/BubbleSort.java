package com.dsa.algorithms;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,2,5,8,4,1};
        BubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void BubbleSort(int[] a)
    {
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-1; j++) {

                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}

//TC = 0(n*n)
//SC = 0(1)