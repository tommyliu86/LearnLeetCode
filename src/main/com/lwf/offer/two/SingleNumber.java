package com.lwf.offer.two;

public class SingleNumber {
    public static void main(String[] args) {
//        new SingleNumber.Solution().singleNumber(new int[]{30000,500,100,30000,100,30000,100});
    }

    /**
     * 1.注意需要使用>>>,如果是>>位移，这会在前面进行补位，
     * 2.按位查找时，每个位除余==1，
     */
    class Solution {
        public int singleNumber(int[] nums) {
            int[] bits=new int[32];
            for (int i = 0; i < nums.length; i++) {
                int cur = nums[i];
                int j=0;
                while (cur!=0){
                    int i1 = cur & 1;
                    bits[j++]+=i1;
                    cur>>>=1;
                }
            }
            int ans=0;
            for (int i = 0; i < bits.length; i++) {
                if (bits[i]%3==1){
                    ans|=(1<<i);
                }
            }
            return ans;
        }
    }
}
