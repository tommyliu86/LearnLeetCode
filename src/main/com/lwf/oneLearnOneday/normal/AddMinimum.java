package com.lwf.oneLearnOneday.normal;

/**
 * 2645. 构造有效字符串的最少插入数
 * @author liuwenfei
 * @date 2024/1/11 9:22
 */
public class AddMinimum {
    /**
     * 双指针进行遍历对比
     */
    class Solution {
        //ABC 不用补充，直接遍历，看当前字符串和abc查多少
        public int addMinimum(String word) {
            char[] chars = word.toCharArray();
            char[] template="abc".toCharArray();

            int i=0,t=0,ans=0;
            while (i<chars.length){
                char cur = chars[i];
                if (cur==template[t]){
                    i++;
                    t=(t+1)%3;
                }else{
                    ans++;
                    t=(t+1)%3;
                }
            }
            return ans+(t==0?0:3-t);
        }
    }
}
