package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/6/15 8:40
 */
public class CanMakePaliQueries {
    /**
     * 不能暴力，，子串可以排序。。因此需要统计子串中的奇数字符的个数，
     * 使用了前缀和技巧,可以在O(1)时间内获取任意区间内某个字符出现的次数,这是此解法的关键。
     */

    class Solution {
        public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
            //构建前缀和数组,preSum[i][j]表示从下标0到下标j的字符串中字符i出现的次数
            int[][] preSum=new int[26][s.length()+1];
            //遍历字符串s,构建前缀和数组
            for (int i = 0; i < s.length(); i++) {
                //获取字符对应的下标j
                int j = s.charAt(i) - 'a';
                //更新前缀和数组
                for (int i1 = 0; i1 < preSum.length; i1++) {
                    preSum[i1][i+1]=preSum[i1][i];
                    //如果字符等于i1,则该字符出现次数加1
                    if (i1==j){
                        preSum[i1][i+1]++;
                    }
                }
            }

            //结果列表
            List<Boolean> ans=new ArrayList<>();

            //遍历queries数组
            for (int i = 0; i < queries.length; i++) {
                //获取查询的起始下标i,结束下标j和可以修改的字符数k
                int[] query = queries[i];
                //判断给定的substring是否可以通过修改k个字符变成回文串,如果可以返回true,否则返回false
                ans.add(check(preSum,query));
            }

            //返回最终结果列表
            return ans;

        }

        //判断给定的substring是否可以变成回文串的方法
        public boolean check(int[][] preSum,int[] query){
            //获取查询的起始下标i,结束下标j和可以修改的字符数k
            int i = query[0],j=query[1],k=query[2];
            //需要奇数字符串的个数
            int count=0;
            //统计下标i到j之间的奇数字符串的个数
            for (int i1 = 0; i1 < preSum.length; i1++) {
                //如果某个字符出现次数为奇数,则需要修改
                count+= ((preSum[i1][j + 1] - preSum[i1][i])&1);
            }
            //如果可以修改的字符数k大于等于count的一半,则可以变成回文串
            return k>=(count-((j-i+1)&1))/2;
        }
    }

    /**
     * 不能暴力，，子串可以排序。。因此需要统计子串中的奇数字符的个数，
     * 暴力遍历，看超时否，
     */
    class Solution1 {
        public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
            List<Boolean> ans = new ArrayList<>();
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                int bab = bab(s, query);
                if (bab == -1) {
                    ans.add(false);
                } else {
                    ans.add(true);
                }
            }
            return ans;
        }

        public int bab(String s, int[] qu) {
            int i = qu[0], j = qu[1], k = 0;
            while (i < j) {
                if (s.charAt(i++) != s.charAt(j--)) {
                    k++;
                }
                if (k > qu[2]) {
                    return -1;
                }
            }
            return k;
        }
    }
}
