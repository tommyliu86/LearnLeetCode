package com.lwf.classic.two.tow;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            List<Integer> list = new ArrayList<>();
            Stack<Integer> stack=new Stack<>();
            for (int i = 0; i < asteroids.length; i++) {
                int asteroid = asteroids[i];
                if (asteroid<0){
                    while (!stack.isEmpty()&&asteroid!=0){
                        if (stack.peek()+asteroid>0) {
                            asteroid=0;
                        }else if (stack.peek()+asteroid<0){
                            stack.pop();
                        }else {
                            stack.pop();
                            asteroid=0;
                        }
                    }
                    if (asteroid!=0){
                        list.add(asteroid);
                    }
                }else {
                    stack.push(asteroid);
                }
            }
            int[] ans=new int[list.size()+stack.size()];
            for (int i = 0; i < list.size(); i++) {
                ans[i]=list.get(i);
            }
            int i=ans.length-1;
            while (!stack.isEmpty()) {
                ans[i--]=stack.pop();
            }
            return ans;
        }
    }
}
