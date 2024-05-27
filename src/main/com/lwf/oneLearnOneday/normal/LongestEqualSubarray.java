package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * 2831. 找出最长等值子数组
 * @author: liuwenfei
 * @date: 2024/5/23-8:55
 */
public class LongestEqualSubarray {
    /**
     * 删除最多k个，那么可以使用滑动窗口，滑动过程中，记录窗口中每个元素的index，对于窗口尾巴，如果
     * size+k>curL，则表示超过了约束，需要移除最前面的位，同时滑动窗口的
     */
    class Solution {
        public int longestEqualSubarray(List<Integer> nums, int k) {
            Map<Integer, Queue<Integer>> map=new HashMap<>();
            int ans=0;
            int r=0;
            while (r<nums.size()){
                Integer i = nums.get(r);
                Queue<Integer> qu = map.compute(i, (a, b) -> b == null ? b = new LinkedList<>() : b);
                qu.add(r);
                while (!qu.isEmpty()&& r+1-qu.peek()>qu.size()+k){
                    qu.poll();
                }
                ans=Math.max(ans,qu.size());
                r++;

            }
            return ans;
        }
    }
}
