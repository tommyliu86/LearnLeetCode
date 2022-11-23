package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2022/11/23 8:52
 */
public class CountBalls {
    class Solution {
        public int countBalls(int lowLimit, int highLimit) {
            int[] counts=new int[46];
            for (int i = lowLimit; i <=highLimit; i++) {
                int k=i;
                int c=0;
                while (k!=0){
                    c+=k%10;
                    k/=10;
                }
                counts[c]++;
            }
            return Arrays.stream(counts).max().getAsInt();
        }
    }
}
