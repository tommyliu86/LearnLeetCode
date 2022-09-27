package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2022/9/26 9:01
 */
public class MissingTwo {
    /**
     * 位运算 负数的二进制是正数的 按位取反 +末尾补1
     * 负数以原码的补码形式表达
     */
    class Solution2 {
        public int[] missingTwo(int[] nums) {
            int xor=0;
            for (int i = 0; i < nums.length + 2; i++) {
                xor^=i+1;
                if (i<nums.length){
                    xor^=nums[i];
                }
            }
            int mark = xor & (xor * -1);
            int t1=0,t2=0;
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i]&mark)!=0){
                    t1^=nums[i];
                }else{
                    t2^=nums[i];
                }
            }
            for (int i = 1; i <= nums.length + 2; i++) {
                if ((i&mark)!=0){
                    t1^=i;
                }else{
                    t2^=i;
                }
            }
            return new int[]{t1,t2};
        }
    }
    /**
     * 标记法，简单解题思路
     */
    class Solution {
        public int[] missingTwo(int[] nums) {
            int[] rtn=new int[2];
            Arrays.fill(rtn,1);
            int n = nums.length + 2;
            for (int i = 0; i < nums.length; i++) {
                int cur = Math.abs(nums[i]);
                if (cur >n-2) {
                    rtn[ cur-(n-2)-1]*=-1;
                }else{
                    nums[cur-1]*=-1;
                }
            }
            int[] ans=new int[2];
            int c=0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]>0){
                    ans[c++]=i+1;
                }
            }
            if (c<2){
                for (int i = 0; i < rtn.length; i++) {
                    if (rtn[i]>0){
                        ans[c++]=i+n-1 +1;
                    }
                }
            }
            return ans;
        }
    }
}
