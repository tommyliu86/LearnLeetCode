package com.lwf.learn.everyday.second.day20;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-02 13:22
 */
public class IsHappy {
    class Solution {
        public boolean isHappy(int n) {
            Set<Integer> set = new HashSet<>();
            while (n != 1 && !set.contains(n)) {
                set.add(n);
                int x = 0;
                while (n != 0) {
                    x += (n % 10) * (n % 10);
                    n /= 10;
                }
                n=x;

            }
            return n==1;
        }
    }
}
