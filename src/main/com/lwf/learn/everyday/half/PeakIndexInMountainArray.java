package com.lwf.learn.everyday.half;

public class PeakIndexInMountainArray {
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int l=0;
            int r=arr.length;
            while (l<=r){
                int m=(l+r)/2;
                if (arr[m]>arr[m-1]&&arr[m]>arr[m+1]){
                    return m;
                }else if (arr[m]>arr[m-1]){
                    l=m+1;
                }else{
                    r=m-1;
                }
            }
            return l;
        }
    }
}
