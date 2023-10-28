package com.lwf.oneLearnOneday.easy;

/**
 * 2520. 统计能整除数字的位数
 * https://leetcode.cn/problems/count-the-digits-that-divide-a-number/description/?envType=daily-question&envId=2023-10-26
 * @author liuwenfei
 * @date 2023/10/26 8:46
 */
public class CountDigits {
    /**
     * 除余算法
     */
    class Solution {
        public int countDigits(int num) {
            int ans=0;
            int n=num;
            while (n>0){
                int i = n % 10;
                ans+=(num%i)==0?1:0;
                n/=10;
            }
            return ans;
        }
    }
}
