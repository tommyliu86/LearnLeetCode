package com.lwf.offer.two;

import java.util.Stack;

/**
 * @author liuwenfei
 * @date 2023/3/17 18:28
 */
public class AsteroidCollision {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> right = new Stack<>();
            for (int i = 0; i < asteroids.length; i++) {
                if (asteroids[i] > 0) {
                    right.push(asteroids[i]);
                } else {
                    if (!right.isEmpty()&& right.peek()<0){
                        right.push(asteroids[i] );
                    }else{
                        while (!right.isEmpty() && right.peek() + asteroids[i] < 0) {
                            right.pop();
                        }
                        if (!right.isEmpty()) {
                            if (right.peek()+asteroids[i]==0) {
                                right.pop();
                            }
                        }else{
                            right.push(asteroids[i]);
                        }
                    }
                }
            }
            int[] ans = new int[right.size()];
            for (int i = ans.length - 1; i >= 0; i--) {
                ans[i] = right.pop();
            }
            return ans;
        }
    }
}
