package com.lwf.oneLearnOneday.normal;

import java.util.Stack;

public class AsteroidCollision {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < asteroids.length; i++) {
                int asteroid = asteroids[i];
                while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                    Integer pop = stack.pop();
                    if (pop + asteroid > 0) {
                        asteroid = pop;
                    } else if (pop + asteroid == 0) {
                        asteroid = 0;
                    }
                }
                if (asteroid != 0) {
                    stack.push(asteroid);
                }
            }
            int[] rtn = new int[stack.size()];
            for (int i = rtn.length - 1; i >= 0; i--) {
                rtn[i] = stack.pop();
            }
            return rtn;
        }
    }
}
