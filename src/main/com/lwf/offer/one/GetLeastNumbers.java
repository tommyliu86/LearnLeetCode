package com.lwf.offer.one;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author liuwenfei
 * @date 2023/1/31 19:24
 */
public class GetLeastNumbers {
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            int l=0,r=arr.length-1;
            fastSort(arr,l,r,k-1);
            int[] ans=new int[k];
            for (int i = 0; i < ans.length; i++) {
                ans[i]=arr[i];
            }
            return ans;
        }

        /**
         *
         * 快速排序，
         */
        public void fastSort(int[] arr,int l,int r,int k){
            if (l>=r){
                return;
            }
            int m=arr[l];
            int i=l;
            for (int j = l+1; j <= r; j++) {
                if (arr[j]<=m){
                    int temp=arr[j];
                    arr[j]=arr[++i];
                    arr[i]=temp;
                }
            }
            arr[l]=arr[i];
            arr[i]=m;
            if (i==k){
                return;
            }else if (i>k){
                fastSort(arr,l,i-1,k);
            }else {
                fastSort(arr,i+1,r,k);
            }
        }
    }
}
