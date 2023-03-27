package com.lwf.offer.two;

import java.util.Stack;

/**
 * @author liuwenfei
 * @date 2023/3/17 18:28
 */
public class AsteroidCollision {
    /**
     * 用栈来模拟小行星的方向即可
     */
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> right = new Stack<>();
            for (int i = 0; i < asteroids.length; i++) {
                if (asteroids[i] > 0) {
                    right.push(asteroids[i]);
                } else {
                    boolean left=true;
                    while (left&& !right.isEmpty()&&right.peek()>0){
                        if (right.peek()+asteroids[i]<0) {
                            right.pop();
                        }else{
                            if (right.peek()+asteroids[i]==0){
                                right.pop();
                            }
                            left=false;
                        }
                    }
                    if (left){
                        right.push(asteroids[i]);
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
