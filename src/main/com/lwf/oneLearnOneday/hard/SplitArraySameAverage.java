package com.lwf.oneLearnOneday.hard;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2022/11/14 9:03
 */
public class SplitArraySameAverage {
    /**
     * 折半搜索
     */
    class Solution {
        public boolean splitArraySameAverage(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            int n=nums.length;
            if (sum==0){
                return false;
            }
            //利用均值来进行倍数放大，这样在计算subSum时可以不用考虑当前subSum的计数问题。
            for (int i = 0; i < nums.length; i++) {
                nums[i]=nums[i]*n-sum;
            }
            Set<Integer> leftSum=new HashSet<>();
            for (int i = 1; i <(1<<n/2) ; i++) {
                int subs=0;
                for (int j = 0; j <n/2 ; j++) {
                    if ((i&(1<<j))>0){
                        subs+=nums[j];
                    }
                }
                if (subs==0){
                    return true;
                }
                leftSum.add(subs);
            }
            for (int i = 1; i <(1<<(n-n/2)) ; i++) {
                int subs=0;
                for (int j = 0; j <n-n/2 ; j++) {
                    if ((i&(1<<j))>0){
                        subs+=nums[j+n/2];
                    }
                }
                if (subs==0||((i != (1 << (n - n/2)) - 1)&& leftSum.contains( -subs))){
                    return true;
                }
            }
            return false;
        }

    }
    /**
     * 暴力遍历
     */
    class Solution1 {
        public boolean splitArraySameAverage(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            int n=nums.length;
            return dfs(nums,1,sum,n,nums[0],1);
        }
        public boolean dfs(int[] nums,int i,int sum,int n,int curSum,int curN){
            if (i>=nums.length){
                return false;
            }
            if ((curN<n&& curSum*n==sum*curN)||(curN+1<n&&(curSum+nums[i])*n==sum*(curN+1))) {
                return true;
            }
            return dfs(nums,i+1,sum,n,curSum,curN)||dfs(nums,i+1,sum,n,curSum+nums[i],curN+1);
        }
    }
}
