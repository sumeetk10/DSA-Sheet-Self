package com.dsa.array;

public class SecondLargest {
    public int getSecondLargest(int[] arr) {
        // Code Here

        int fm = -1;
        int sm = -1;

        for(int i=0; i<arr.length; i++) {

            if(arr[i] > fm && arr[i] > sm) {
                sm = fm;
                fm = arr[i];
            }

            if(arr[i] > sm && arr[i] < fm) {
                sm = arr[i];
            }
        }

        return sm;
    }
}
