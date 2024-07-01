package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * 2741. 特别的排列
 *
 * 解题：https://leetcode.cn/problems/special-permutations/solutions/2822935/javapython3cwei-yun-suan-ji-yi-hua-sou-s-gofc/?envType=daily-question&envId=2024-06-26
 * @author: liuwenfei
 * @date: 2024/6/27-9:07
 */
public class SpecialPerm {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString( 1234));
        System.out.println(Integer.toBinaryString( ~1234));
        System.out.println(Integer.toBinaryString( 1234&(-1234)));
        System.out.println(Integer.toBinaryString( 1234^(1234&(-1234)-1)));
    }

    class Solution {
        /**
         * 记忆化搜索，对递归过程中的值进行记录，保证后续的递归分支可以使用
         * 记忆化搜索需要注意的是记录什么信息，可以保证后续可用。
         * @param nums
         * @return
         */
        public int specialPerm(int[] nums) {

            int l = nums.length;
            //所有位都是1，这样可以通过异或获取相同长度上的取反结果，直接用取反方法，会得到32位的二进制
            int mask=(1<<l)-1;
            marks=new long[mask+1][l];
            for (int i = 0; i < marks.length; i++) {
                Arrays.fill(marks[i],-1);
            }
            long ans=0;
            for (int i = 0; i < nums.length; i++) {
                ans=(ans+dfs(i,(1<<i)^mask,nums))%mod;
            }
            return (int)ans;
        }
        int mod=1000_000_007;
        long[][] marks;
        //msk表示的是可用范围，
        private long dfs(int indez, int msk,int[] nums) {
            //全部用掉数字，表示找到一个排列
            if (msk==0){
                return 1;
            }
            if (marks[msk][indez]!=-1){
                return marks[msk][indez];
            }
            //枚举每个位置，和msk进行对比，找到每个可以选择的下个元素
            long rtn=0;
            for (int i = 0; i < nums.length; i++) {
                if ((msk&(1<<i))==0) {
                    continue;
                }
                if(nums[i]%nums[indez]==0||nums[indez]%nums[i]==0){
                    rtn+=dfs(i,msk^(1<<i),nums);
                }
            }
            return marks[msk][indez]=rtn;
        }
    }
}
