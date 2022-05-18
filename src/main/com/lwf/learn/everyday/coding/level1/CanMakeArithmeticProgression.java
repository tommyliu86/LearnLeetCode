package com.lwf.learn.everyday.coding.level1;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-06 15:06
 */
public class CanMakeArithmeticProgression {
    class Solution {
        public boolean canMakeArithmeticProgression(int[] arr) {
            Arrays.sort(arr);
            int sub=arr[1]-arr[0];
            for (int i = 2; i < arr.length; i++) {
                if (arr[i]-arr[i-1]!=sub){
                 return false;
                }
            }
            return true;
        }
    }
}
