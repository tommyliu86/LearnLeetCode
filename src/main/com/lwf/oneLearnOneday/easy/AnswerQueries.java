package com.lwf.oneLearnOneday.easy;

import javax.management.Query;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuwenfei
 * @date 2023/3/17 9:21
 */
public class AnswerQueries {
    /**
     * 前缀和就是queries中要查找的大小，因此不需要进行排序后遍历查找，可以通过计算好前缀和，直接进行二分查找
     */
    class Solution {
        public int[] answerQueries(int[] nums, int[] queries) {
            int[] sums=new int[nums.length+1];
            Arrays.sort(nums);
            for (int i = 1; i < sums.length; i++) {
                sums[i]=sums[i-1]+nums[i-1];
            }
            int[] ans=new int[queries.length];
            for (int i = 0; i < ans.length; i++) {
                ans[i]=binarySearch(sums,queries[i]);
            }
            return ans;
        }

        private int binarySearch(int[] sums, int query) {
            int i=0,j=sums.length-1;
            while (i<j){
                int mid=(i+j)/2;
                if (sums[mid]<=query){
                    i=mid+1;
                }else{
                    j=mid;
                }
            }
            return sums[i]>query?i-1:i;
        }
    }
    /**
     * 暴力解题，依次计算前缀和，同时排序qieries，来匹配前缀和满足条件的情况。。
     */
    class Solution1 {
        public int[] answerQueries(int[] nums, int[] queries) {
            Arrays.sort(nums);
            Integer[] indexes=new Integer[queries.length];
            for (int i = 0; i < indexes.length; i++) {
                indexes[i]=i;
            }
            Arrays.sort(indexes, Comparator.comparingInt(a -> queries[a]));
            Arrays.sort(queries);
            int[] ans=new int[queries.length];
            int sum=0;
            int i=0,j=0;
            while (j<queries.length){
                while (sum<=queries[j]&&i<nums.length){
                    sum+=nums[i++];
                }
                ans[indexes[j]]=sum<=queries[j]? i:(i-1) ;
                j++;
            }
            return ans;
        }
    }
}
