package com.lwf.oneLearnOneday.easy;

import java.util.List;

/**
 * 2824. 统计和小于目标的下标对数目
 * @author liuwenfei
 * @date 2023/11/24 9:26
 */
public class CountPairs {
    /**
     * 双指针，排序后找到可以使用的i==0的对应的j，之后i变大时，和肯定变大，若i+j>=target,只要j--找到后续的j即可，
     */
    class Solution {
        public int countPairs(List<Integer> nums, int target) {
            nums.sort(Integer::compareTo);
            int ans=0;
            int i=0,j= nums.size()-1;
            while (i<j){
                while (i<j&&nums.get(i)+nums.get(j)>=target){
                   j--;
                }
                if (i<j){
                    ans+=j-i;
                }
                i++;
            }
            return ans;
        }
    }
}
