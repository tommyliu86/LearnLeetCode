package com.lwf.oneLearnOneday.hard;

import java.util.*;

public class CountTriplets {
    /**
     * 暴力枚举+计数
     */
    class Solution {
        public int countTriplets(int[] nums) {
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    int k = nums[i] & nums[j];
                    map.put(k, map.getOrDefault(k,0)+1);
                }
            }
            int ans=0;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if ((entry.getKey()&num)==0){
                        ans+=entry.getValue();
                    }
                }

            }
            return ans;
        }
    }
    /**
     * 位与计算，只要有不相同就会消除。只要消除到0就行。也就是说找零，而不是找1.
     */
    class Solution1 {
        public int countTriplets(int[] nums) {
            List<Integer>[] indexs=new List[16];
            for (int i = 0; i < indexs.length; i++) {
                indexs[i]=new ArrayList<>();
            }
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    int num = nums[i]&nums[j];
                    for (int k = 0; k < 16; j++) {
                        if ((num&(1<<k))==0) {
                            indexs[k].add(num);
                        }
                    }
                }
            }
            int ans=0;
            boolean[] mark=new boolean[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (mark[i]) continue;
                int num = nums[i];
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < 16; j++) {
                    if ((num&(1<<j))!=0) {
                        set.addAll(indexs[j]);
                    }
                }
                set.forEach(k->mark[k]=true);
                ans+=set.size()*set.size()*set.size();
            }
            return ans;
        }
    }
}
