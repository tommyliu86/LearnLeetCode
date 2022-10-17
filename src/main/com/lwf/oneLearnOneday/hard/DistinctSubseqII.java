package com.lwf.oneLearnOneday.hard;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2022/10/14 8:52
 */
public class DistinctSubseqII {
    class Solution {
        public int distinctSubseqII(String s) {
            int mod=1000000007;
            char[] chars = s.toCharArray();
            //记录 最后一个char是 26个字符时的组合总和，每次下一个字符都可以和前面出现过的所有字符结尾情况
            //组合出新的组合
            int[] sums=new int[26];

            for (int i = 0; i < chars.length; i++) {
                int sum=0;
                for (int j = 0; j < sums.length; j++) {
                    sum+=sums[j];
                    sum%=mod;
                }
                //这里计算的sum是前一个元素是26个char的时候的组合，因此是不包含这个char本身单独一个char时的情况
                //因此需要+1
                sums[chars[i]-'a']=sum+1;
            }
            int ans=0;
            for (int i = 0; i < sums.length; i++) {
                ans=(ans+sums[i])%mod;
            }
            return ans;

        }

    }
}
