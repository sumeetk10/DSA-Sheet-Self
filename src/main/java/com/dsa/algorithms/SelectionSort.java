package com.dsa.algorithms;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,3,1,8,4,2};
        SelectionSortFunction(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void SelectionSortFunction(int[] arr)
    {
        for (int i = 0; i < arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

        }
    }
}

//find minimum and place at minimum position
//TC = 0(n*n);
//SC = 0(1);