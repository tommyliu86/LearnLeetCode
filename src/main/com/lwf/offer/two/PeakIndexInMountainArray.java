package com.lwf.offer.two;

/**
 * LCR 069. 山脉数组的峰顶索引
 * @author liuwenfei
 * @date 2023/11/9 18:28
 */
public class PeakIndexInMountainArray {
    /**
     * 二分查找
     */
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int i=1,j=arr.length-2;
            while (i<=j){
                int m=i+(j-i)/2;
                if (arr[m]>arr[m-1]&&arr[m]>arr[m+1]){
                    return m;
                }else if (arr[m-1]<arr[m]&&arr[m]<arr[m+1]){
                    i=m+1;
                }else{
                    j=m-1;
                }
            }
            return -1;
        }
    }
}
