package com.lwf.oneLearnOneday.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liuwenfei
 * @date: 2024/5/14-8:35
 */
public class MinimumRounds {
    /**
     * 分类遍历，找到任务难度的所有的数量，然后进行2,3，分类，且数量分类要能最少。
     */
    class Solution {
        public int minimumRounds(int[] tasks) {
            Map<Integer,Integer> counts=new HashMap<>();
            for (int task : tasks) {
                counts.put(task,counts.getOrDefault(task,0)+1);
            }
            int ans=0;
            for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                Integer value = entry.getValue();
                if (value==1) {
                    return -1;
                }
                int sub=value/3;
                if (value%3!=0) {
                    sub=sub+1;
                }
                ans+=sub;
            }
            return ans;
        }
    }
}
