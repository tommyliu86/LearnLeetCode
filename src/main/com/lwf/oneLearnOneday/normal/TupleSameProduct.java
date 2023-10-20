package com.lwf.oneLearnOneday.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/10/19 8:34
 */
public class TupleSameProduct {
    class Solution {
        /**
         * 考虑 两数相乘 i*j ，如果i*j=a*b  由于 数组中没有相同元素，因此可以知道，满足这种条件时，肯定是4个元素都不相同的，因此
         * 我们可以直接记录所有两数乘的结果，然后直接在其中计算即可。
         * 假设一个乘积为 k个数对，则 可以有 k*（k-1）/2 种不同组合，梅4个数字要组合 a*b=c*d，可以不同排列，则可以是 2*2*2种排列，
         * （a*b 排列 c*d 排列 a*b 和c*d交换位置）
         * @param nums
         * @return
         */
        public int tupleSameProduct(int[] nums) {
            Map<Integer,Integer> ks=new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    int i1 = nums[i] * nums[j];
                    ks.put(i1,ks.getOrDefault(i1,0)+1);
                }
            }
            int ans=0;
            for (Map.Entry<Integer, Integer> entry : ks.entrySet()) {
                Integer k = entry.getKey();
                Integer v = entry.getValue();
                if (v > 1) {
                    ans += 8 * (v * (v - 1) / 2);
                }
            }
            return ans;
        }
    }
}
