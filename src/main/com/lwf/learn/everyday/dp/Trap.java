package com.lwf.learn.everyday.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-10 18:52
 */
public class Trap {
    /**
     * 单调栈
     */
    class Solution {
        public int trap(int[] height) {
            Stack<Integer> stack=new Stack<>();
            int sum=0;
            for (int i = 0; i < height.length; i++) {
                while (stack.size()>0&& height[i]>height[ stack.peek()]){
                    Integer pop = stack.pop();
                    if (!stack.isEmpty()){
                        sum+=(i-stack.peek()-1)*(Math.min( height[i],height[stack.peek()])-height[pop]);
                    }

                }
                stack.push(i);
            }
            return sum;
        }
    }
    /**
     * 这样是把时间复杂度变高了。。
     */
    class test {
        public int trap(int[] height) {
            List<Integer> ys=new ArrayList<>();
            int sum=0;
            for (int i = 0; i < height.length; i++) {
                int l = height[i];
                int size = ys.size();
                for (int j = 0; j < l; j++) {
                    if (j+1>size){
                        ys.add(i);
                    }else{
                        Integer prei = ys.get(j);
                        sum+=i-prei-1;
                        ys.set(j,i);
                    }
                }
            }
            return sum;
        }
    }
}
