package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2022/12/12 19:29
 */
public class BeautySum {
    /**
     * 双层循环？？
     */
    class Solution {
        public int beautySum(String s) {
            int[] sums=new int[26];
            char[] chars = s.toCharArray();
            int ans=0;
            for (int i = 0; i < chars.length; i++) {
                sums[chars[i]-'a']++;
                if (i>1){
                    int j=0;
                    int[] sub= Arrays.copyOf( sums,26);
                    while (j<i-1){
                        int max=0;
                        int min=Integer.MAX_VALUE;

                        for (int k = 0; k < sub.length; k++) {
                            if (sub[k]!=0){
                                max=Math.max(max,sub[k]);
                                min=Math.min(min,sub[k]);
                            }
                        }
                        ans+=max-min;
                        sub[chars[j]-'a']--;
                        j++;
                    }
                }
            }
            return ans;
        }
    }
}
