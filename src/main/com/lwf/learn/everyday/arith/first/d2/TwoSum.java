package com.lwf.learn.everyday.arith.first.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-16 15:07
 */
public class TwoSum {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int l=0;
            int r=numbers.length-1;

            while (l<r){
                int sum = numbers[l] + numbers[r];
                if (sum >target){
                    r--;
                }else if (sum==target){
                    return new int[]{l,r};
                }else{
                    l++;
                }
            }
            return new int[0];
        }
    }
}
