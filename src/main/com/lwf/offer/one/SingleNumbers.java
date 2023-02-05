package com.lwf.offer.one;

public class SingleNumbers {

    /**
     * 异或 异或的分组，异或的结果中的位如果为1，表示两个数在这个位上不相等，不然异或的结果是0！
     */
    class Solution {
        public int[] singleNumbers(int[] nums) {
            int xor=0;
            for (int i = 0; i < nums.length; i++) {
                xor^=nums[i];
            }
            int[] ans=new int[2];
            int gap=1;
            while ((xor&gap)==0){
                gap<<=1;
            }
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i]&gap)==0) {
                    ans[0]^=nums[i];
                }else{
                    ans[1]^=nums[i];
                }
            }
            return ans;
        }
    }
}
