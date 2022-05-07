package com.lwf.learn.everyday.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-06 18:49
 */
public class DeleteAndEarn {
    class Solution {
        public int deleteAndEarn(int[] nums) {
            if (nums.length<2){
                return nums[0];
            }
            Map<Integer, Integer> map = new HashMap();

            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + nums[i]);
            }
            Integer[] integers = map.keySet().toArray(new Integer[map.keySet().size()]);
            Arrays.sort(integers);
            int pre=map.get(integers[0]);
            int cur=integers[1]-integers[0]==1?Math.max(map.get(integers[1]),pre):(pre+map.get(integers[1]));
            for (int i = 0; i < integers.length; i++) {
                if (integers[i]-integers[i-1]==1){
                    int temp=cur;
                    cur=Math.max(pre+map.get(integers[i]),cur);
                    pre=temp;
                }else{
                    pre=cur;
                    cur=cur+map.get(integers[i]);
                }
            }
            return cur;
        }
    }
}
