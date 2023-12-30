package com.lwf.classic.two.tow;

/**
 * @author liuwenfei
 * @date 2023/3/31 9:38
 */
public class TwoSum {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int i=0,j=numbers.length-1;
            while (i<j){
                if (numbers[i]+numbers[j]>target){
                    j--;
                }else if (numbers[i]+numbers[j]<target){
                    i++;
                }else {
                    break;
                }
            }
            return new int[]{i,j};
        }
    }
}
