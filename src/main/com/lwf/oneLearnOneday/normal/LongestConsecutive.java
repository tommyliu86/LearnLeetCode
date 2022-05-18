package com.lwf.oneLearnOneday.normal;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *  https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * 128. 最长连续序列
 * @author: liuwenfei14
 * @date: 2022-02-14 22:57
 */
public class LongestConsecutive {
    /**
     * hash的利用。这里就是利用hash的直接查找来进行判断是否存在连续的序列，通过num-1不存在来假设num为当前序列的开始，然后++查找
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<Integer>();
        for (int num : nums) {
            numsSet.add(num);
        }
        int longest=0;

        for (int i = 0; i < nums.length || i+longest<nums.length; i++) {
            int currentNum = nums[i];
            if (numsSet.contains( currentNum-1)){
                continue;
            }else{
                int currentLength=1;
                while (numsSet.contains(++currentNum)){
                    currentLength++;
                }
                longest=Math.max(longest,currentLength);
            }
        }
        return longest;
    }

    /**
     * 优化，直接使用set来做循环，进行去重后的元素个数会少很多。。。
     *
     * @param nums
     * @return
     */
    public int longestConsecutive1(int[] nums) {
        Set<Integer> numsSet = new HashSet<Integer>();
        for (int num : nums) {
            numsSet.add(num);
        }
        int longest=0;

        for (Integer num : numsSet) {
            int currentNum = num;
            if (numsSet.contains( currentNum-1)){
                continue;
            }else{
                int currentLength=1;
                while (numsSet.contains(++currentNum)){
                    currentLength++;
                }
                longest=Math.max(longest,currentLength);
            }
        }

        return longest;
    }
}
