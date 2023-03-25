package com.lwf.oneLearnOneday.normal;

public class FindLengthOfShortestSubarray {
    //前后递增+二分查找
    class Solution {
        public int findLengthOfShortestSubarray(int[] arr) {
            int l = 0, r = arr.length - 1;
            //left 递增 1222233 23333333333333335
            while (l < r && l + 1 <= r && arr[l + 1] >= arr[l]) {
                l++;
            }
            //right 递增
            while (l < r && r - 1 >= l && arr[r - 1] <= arr[r]) {
                r--;
            }
            if (l==r) {
                return 0;
            }else{
                int min=Math.min(arr.length-l-1,r);
                for (int i = r; i < arr.length; i++) {
                    int i1 = halfL(arr, 0, l, arr[i]);
                    min=Math.min(min,i-i1);

                }
                return min;
            }

        }
        //找到第一个大于t的数， 123 5=2 大于最后一个时，找不到
        public int halfL(int[] arr,int l,int r,int target){
            while (l<r){
                int mid=(l+r)/2;
                if (arr[mid]>target){
                    r=mid;
                }else{
                    l=mid+1;
                }

            }
            return arr[ l]>target?l :(l+1);
        }
    }
}
