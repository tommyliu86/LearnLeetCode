package com.lwf.learn.everyday.half;

import java.util.Arrays;

public class FindTheDistanceValue {
    class Solution {
        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            int count=0;
            for (int i = 0; i < arr1.length; i++) {
                int half = half(arr2, arr1[i]);
                if (arr1[i]>arr2[half]){
                    if (arr1[i]-arr2[half]>d&&(half==arr2.length-1||arr2[half]-arr1[i]>d)){
                        count++;
                    }
                }else{
                    if ((half==0||arr1[i]-arr2[half-1]>d)&&(arr2[half]-arr1[i]>d)){
                        count++;
                    }
                }
            }
            return count;
        }
        public int half(int[] arr,int t){
            int l=0;
            int r=arr.length-1;
            while (l<r){
                int m=(l+r)/2;
                if (arr[m]==t){
                    return m;
                }else  if (arr[m]>t){
                    r=m;
                }else{
                    l=m+1;
                }
            }
            return r;
        }
    }
}
