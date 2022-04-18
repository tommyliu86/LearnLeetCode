package com.lwf.level1.dp;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-17 14:33
 */
public class Steps {
    class dp {
        public int climbStairs(int n) {
            if (n<3) return n;
            int step1=1;
            int step2=2;
            for (int i = 3; i <= n; i++) {
                int temp=step2;
                step2+=step1;
                step1=temp;
            }
            return step2;
        }

    }
    class Solution {
        public int climbStairs(int n) {
            if (n<3){
                return n;
            }
            return climbStairs(n-1)+climbStairs(n-2);
        }

    }
}
