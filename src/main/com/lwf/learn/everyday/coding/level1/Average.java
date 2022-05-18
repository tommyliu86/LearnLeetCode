package com.lwf.learn.everyday.coding.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-03 17:00
 */
public class Average {
    class Solution {
        public double average(int[] salary) {
            int min=Integer.MAX_VALUE;
            int max=0;
            int sum=0;
            for (int i = 0; i < salary.length; i++) {
                min=Math.min(salary[i],min);
                max=Math.max(salary[i],max);
                sum+=salary[i];
            }
            return (sum-min-max)/(salary.length-2);
        }
    }
}
