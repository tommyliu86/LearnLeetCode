package com.lwf.oneLearnOneday.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2023/3/16 15:12
 */
public class CountSubarrays {
    /**
     * 继续优化
     * 代码逻辑优化，但是执行效率还是一样。。。
     */
    class Solution {
        public int countSubarrays(int[] nums, int k) {
            int[] counts=new int[nums.length+1];
            Map<Integer, Integer> before=new HashMap<>();
            before.put(0,1);
            int kIndex=nums.length;
            int ans=0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]==k) kIndex=i;
                counts[i+1]=counts[i]+(nums[i]>k?1:(nums[i]==k?0:-1));
                if (i<kIndex){
                    before.put(counts[i+1], before.getOrDefault(counts[i+1],0)+1);
                }else {
                  ans+=  before.getOrDefault(counts[i+1],0);
                  ans+=  before.getOrDefault(counts[i+1]-1,0);
                }
            }

            return ans;
        }
    }
    /**
     * 转换为个数统计，一般使用变换前缀和，使用1，-1来作为da或小的统计，然后使用map来记录和的出现次数
     */
    class Solution1 {
        public int countSubarrays(int[] nums, int k) {
            int[] counts=new int[nums.length+1];
            Map<Integer, Integer> before=new HashMap<>();
            before.put(0,1);
            Map<Integer, Integer> after=new HashMap<>();
            int kIndex=nums.length;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]==k) kIndex=i;
                counts[i+1]=counts[i]+(nums[i]>k?1:(nums[i]==k?0:-1));
                if (i<kIndex){
                    before.put(counts[i+1], before.getOrDefault(counts[i+1],0)+1);
                }else {
                    after.put(counts[i+1], after.getOrDefault(counts[i+1],0)+1);
                }
            }
            int ans=0;
            // 在k前面和后面的 count相同，则表示在这个区间内大于k和小于k 的数量相同，此时肯定为奇数个
            //在k后面的 比前面的大1，则表示这个区间中 大于k的比小于k的多1，则肯定为偶数个，
            for (Map.Entry<Integer, Integer> entry : before.entrySet()) {

                Integer key1 = entry.getKey();
                if (after.containsKey(key1)){
                    ans+=entry.getValue()*after.get(key1);
                }
                if (after.containsKey(key1+1)){
                    ans+=entry.getValue()*after.get(key1+1);
                }
            }
            return ans;
        }
    }
}
