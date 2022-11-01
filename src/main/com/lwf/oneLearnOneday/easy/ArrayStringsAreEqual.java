package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2022/11/1 9:49
 */
public class ArrayStringsAreEqual {
    /**
     * 暴力解法，直接拼接为string
     */
    class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            return String.join("",word1).equalsIgnoreCase(String.join("",word2));
        }
    }
    /**
     * 指针遍历
     */
    class Solution1 {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            int i1=0;
            int[] i2=new int[2];
            while (i1<word1.length&&i2[0]<word2.length){
                String w1 = word1[i1];
                for (int i = 0; i < w1.length(); i++) {
                    if (i2[0]<word2.length&& w1.charAt(i)==word2[i2[0]].charAt(i2[1])) {
                        i2[1]++;
                        if (i2[1]>=word2[i2[0]].length()){
                            i2[0]++;
                            i2[1]=0;
                        }
                    }else{
                        return false;
                    }
                }
                i1++;
            }
            return i2[0]==word2.length;
        }
    }
}
