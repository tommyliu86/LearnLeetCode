package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2022/9/13 9:21
 */
public class MaximumSwap {
    /**
     * 暴力模拟，直接使用双端队列进行保存index作为单调栈，然后把单调栈和num的每个index进行比较，找到不按照顺序排列的index就是变化的index了，
     * 然后向后查找和这个index相同的最小index，因为相同的数字，越靠近低位，数字越大。
     */
    class Solution {
        public int maximumSwap(int num) {
            Deque<Integer> stack=new LinkedList<>();
            List<Integer> list=new ArrayList<>();
            int i=num;
            while (i!=0){
                list.add( i%10);
                i/=10;
            }
            for (int j = list.size() - 1; j >= 0; j--) {
                while (!stack.isEmpty()&& list.get( stack.peek())<list.get(j)){
                    stack.pop();
                }
                stack.push(j);
            }
            int k=list.size()-1;
            while (!stack.isEmpty() && stack.peekLast()==k){
                k--;
                stack.pollLast();
            }
            if (stack.isEmpty()){
                return num;
            }
            Integer maxIndex = stack.pollLast();

            while (!stack.isEmpty()&&list.get( stack.peekLast())==list.get(maxIndex)){
                maxIndex=  stack.pollLast();
            }
            Integer max = list.get(maxIndex);
            list.set(maxIndex, list.get(k));
            list.set(k,max);
            int rtn=0;
            for (int j = list.size() - 1; j >= 0; j--) {
                rtn=10*rtn+list.get(j);
            }
            return rtn;
        }

    }

}
