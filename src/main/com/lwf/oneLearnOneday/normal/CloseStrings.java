package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/12/1 9:04
 */
public class CloseStrings {
    public static void main(String[] args) {
        int count=0;
        for (int i = 0; i < 5; i++) {
            count|=1<<i;
        }
        System.out.println(Integer.toBinaryString(count));
        count^=1<<2;
        System.out.println(Integer.toBinaryString(count));

    }

    /**
     *位运算 + 数字统计对比
     */
    class Solution {
        public boolean closeStrings(String word1, String word2) {
            if (word1.length() != word2.length()) return false;
            int count = 0;
            int[] s1 = new int[26];
            int[] s2 = new int[26];
            for (int i = 0; i < word1.length(); i++) {
                int i1 = word1.charAt(i) - 'a';
                if (s1[i1] == 0)
                    count |= 1 << i1;
                s1[i1]++;
            }
            for (int i = 0; i < word2.length(); i++) {
                int i1 = word2.charAt(i) - 'a';
                if (s2[i1]==0){
                    count^=1<<i1;
                }
                s2[i1]++;
            }
            if (count!=0){
                return false;
            }
            for (int i = 0; i < s1.length; i++) {
                    if (s1[i]==s2[i]){
                        s1[i]=s2[i]=0;
                    } else {
                        int c = s1[i];
                        int j = 0;
                        for (; j < s2.length; j++) {
                            if (s2[j] == c )
                                break;
                        }
                        if (j == s2.length) {
                            return false;
                        } else {
                            s1[i] = s2[j] = 0;
                        }
                    }

            }
            return true;
        }
    }
}
