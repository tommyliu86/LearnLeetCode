package com.lwf.oneLearnOneday.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/10/16 8:36
 */
public class SingleNumber {
    /**
     * 136. 只出现一次的数字
     * https://leetcode.cn/problems/single-number/
     */
    class Solution1 {
        /**
         * 考察位运算的知识点， 异或操作 a^a=0. a^0=a
         * @param nums
         * @return
         */
        public int singleNumber(int[] nums) {
            int ans=0;
            for (int num : nums) {
                ans^=num;
            }
            return ans;
        }
    }

    /**
     * 137. 只出现一次的数字 II
     * https://leetcode.cn/problems/single-number-ii/?envType=daily-question&envId=2023-10-15
     */
    class Solution2 {
        /**
         * 使用32长度的数组的方法 可以看到，使用两次for循环，因此我们也可以直接把位作为第一层循环，把数组作为第二层，这样
         * 每个位循环一遍就是确定的数。
         * @param nums
         * @return
         */
        public int singleNumber(int[] nums) {
            int ans=0;
            for (int i = 0; i < 32; i++) {
                int bitCount=0;
                for (int num : nums) {
                    bitCount+=((num&(1<<i))!=0)?1:0;
                }
                if ((bitCount%3)!=0){
                    ans|=(1<<i);
                }
            }
            return ans;
        }
        /**
         * 数组+位运算
         * 位运算思路，通过32位的位运算统计
         * @param nums
         * @return
         */
        public int singleNumber2(int[] nums) {
            int[] ans=new int[32];
            //使用32长度的数组 这里可以看到，使用两次for循环，因此我们也可以直接把位作为第一层循环，把数组作为第二层，这样
            //每个位循环一遍就是确定的数。
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                for (int i1 = 0; i1 < 32; i1++) {
                    int bit=(1<<i1)&num;
                    if (bit!=0){
                        ans[i1]=(ans[i1]+1)%3;
                    }
                }
            }
            int answer=0;
            for (int i1 = 0; i1 < 32; i1++) {
                answer|=(1<<i1)*ans[i1];
            }
            return answer;
        }
        /**
         * 常规思路，哈希
         * @param nums
         * @return
         */
        public int singleNumber1(int[] nums) {
            Map<Integer,Integer> map=new HashMap<>();
            for (int num : nums) {
                map.put(num,map.getOrDefault(num,0)+1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue()==1) {
                    return entry.getKey();
                }
            }
            return 0;
        }
    }

    /**
     * 260. 只出现一次的数字 III
     * https://leetcode.cn/problems/single-number-iii/?envType=daily-question&envId=2023-10-15
     * 位运算 + 分类思考
     */
    class Solution3 {
        public int[] singleNumber(int[] nums) {
            int xor=0;
            for (int num : nums) {
                xor^=num;
            }
            int i=0;
            while (((1<<i)&xor)==0){
                i++;
            }
            int[] ans=new int[2];
            for (int i1 = 0; i1 < nums.length; i1++) {
                int num = nums[i1];
                if ((num&(1<<i))==0){
                    ans[0]^=num;
                }else{
                    ans[1]^=num;
                }
            }
            return ans;
        }
    }
}
