package com.lwf.oneLearnOneday.hard;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Arrays;

/**
 * 689. 三个无重叠子数组的最大和
 * https://leetcode.cn/problems/maximum-sum-of-3-non-overlapping-subarrays/description/?envType=daily-question&envId=2023-11-20
 *
 * @author liuwenfei
 * @date 2023/11/20 9:07
 */
public class MaxSumOfThreeSubarrays {
    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal(0);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        currency.setMinimumFractionDigits(3);
        currency.setMaximumFractionDigits(3);
        System.out.println(currency.format(amount).substring(1));
    }


    /**
     * 三个 滑动窗口
     * 滑动窗口，考虑两组滑动窗口，一组窗口从前到后遍历记录最大位置，那我们两组时，相当于同时记录了第二组的当前和第一组当前的最大，
     * 三组同理，是 一和二
     */

    class Solution {
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            int sum1= 0;
            int sum2= 0;
            int sum3= 0;
            for (int i = 0; i < 3 * k; i++) {
                if (i<k){
                    sum1+=nums[i];
                }else if (i<2*k){
                    sum2+=nums[i];
                }else {
                    sum3+=nums[i];
                }
            }
            int[] sums1=new int[]{0,sum1};
            int[] sums12=new int[]{0,k,sum1+sum2};
            int[] sums123=new int[]{0,k,2*k,sum1+sum2+sum3};
            for (int i = 3 * k; i < nums.length; i++) {
                sum1=sum1-nums[ i-3*k]+nums[i-2*k];
                sum2=sum2-nums[ i-2*k]+nums[i-k];
                sum3=sum3-nums[ i-k]+nums[i];
                if (sum1> sums1[1]) {
                    sums1=new int[]{i-3*k+1,sum1};
                }
                if (sums1[1]+sum2> sums12[2]) {
                    sums12=new int[]{sums1[0],i-2*k+1,sums1[1]+sum2};
                }
                if (sum3+sums12[2]>sums123[3]){
                    sums123=new int[]{sums12[0],sums12[1],i-k+1,sum3+sums12[2]};
                }
            }
            return new int[]{sums123[0],sums123[1],sums123[2]};
        }

    }

    /**
     * 暴力循环枚举 这样的解法，是固定了中间的窗口，两边进行滑动窗口查找，本质上是多次循环的枚举，
     * 1. 固定中间的子数组，则 从左到右，找到 left+mid+right的最大
     */

    class Solution1 {
        public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
            //中间子数组进行移动
            int max = 0;
            int[] ans = new int[3];
            for (int i = k; i <= nums.length - 2 * k; i++) {
                int[] pre = slideWindow(nums, k, 0, i);
                int[] post = slideWindow(nums, k, i + k, nums.length);
                int sum = pre[1] + post[1];
                for (int i1 = 0; i1 < k; i1++) {
                    sum += nums[i + i1];
                }
                if (max < sum) {
                    max = sum;
                    ans[0] = pre[0];
                    ans[1] = i;
                    ans[2] = post[0];
                }
            }
            return ans;
        }

        //滑动窗口找最大
        public int[] slideWindow(int[] nums, int k, int i, int j) {
            int[] ans = new int[2];
            int sum = 0;
            int x = i, y = i;
            while (x < j) {
                while (x - y < k) {
                    sum += nums[x++];
                }
                if (ans[1] < sum) {
                    ans[0] = y;
                    ans[1] = sum;
                }
                sum -= nums[y++];
            }
            return ans;
        }
    }
}
