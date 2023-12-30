package com.lwf.classic.two.tow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/3/30 10:10
 */
public class SingleNumber {
    class Solution {

        public int singleNumber(int[] nums) {
            int[] bits=new int[32];
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int j=0;
                while (num!=0){
                    bits[j++]+=(num & 1);
                    num>>>=1;
                }
            }
            int ans=0;
            //这里用的乘法，会有性能损失
//            for (int i = bits.length - 1; i >= 0; i--) {
//                ans=ans*2+(bits[i]%3);
//            }
            for (int i = 0; i < bits.length; i++) {
                ans|=(bits[i]%3)<<i;
            }
            return ans;
        }
    }

    class Solution1 {
        /**
         * 暴力 +map
         *
         * @param nums
         * @return
         */
        public int singleNumber(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }
            return 0;
        }
    }
}
