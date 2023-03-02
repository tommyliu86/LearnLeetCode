package com.lwf.offer.two;

/**
 * @author liuwenfei
 * @date 2023/3/1 19:07
 */
public class TwoSum {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {

            int i=0,j=numbers.length-1;
            int sum=0;
            while ((sum=numbers[i]+numbers[j])!=target){
                if (sum>target){
                    j--;
                }else{
                    i++;
                }
            }
            return new int[]{i,j};
        }
    }
}
