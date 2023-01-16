package com.lwf.offer.one;

/**
 * @author liuwenfei
 * @date 2023/1/16 15:43
 */
public class MinArray {
    public static void main(String[] args) {
        new Solution().minArray(new int[]{3,1,1,1});
    }
    static
    class Solution {
        /**
         * 二分查找
         * 与右侧点比较，当点相等时，可以向左移动，这样可以把递增数列覆盖到
         * @param numbers
         * @return
         */
        public int minArray(int[] numbers) {
            int l=0,r=numbers.length-1;
            while (l<=r){
                int mid=(l+r)/2;
                if (numbers[mid]>numbers[r]){
                    l=mid+1;
                }else if (numbers[mid]==numbers[r]){
                    r--;
                }else{
                    r=mid;
                }
            }
            return numbers[r];
        }

        /**
         * 与左侧比较，会导致点向右移动
         * @param numbers
         * @return
         */
        public int minArray1(int[] numbers) {
            int l=0,r=numbers.length-1;
            while (l<=r){
                int mid=(l+r)/2;
                if (numbers[mid]>numbers[l]){
                    l=mid+1;
                }else if (numbers[mid]==numbers[l]){
                    l++;
                }else{
                    r=mid;
                }
            }
            return numbers[l];
        }
    }
}
